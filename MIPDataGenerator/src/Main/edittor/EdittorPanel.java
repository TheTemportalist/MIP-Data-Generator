package Main.edittor;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Core.Gui.GuiButton;
import Core.Gui.GuiPanel;

@SuppressWarnings("serial")
public abstract class EdittorPanel extends GuiPanel implements IDataOwner {
	
	final GuiPanel owner;
	/**
	 * Format: ""
	 */
	final String listName;
	final int listIndex;
	Object value;
	
	List<JLabel> labels = new ArrayList<JLabel>();
	List<JTextField> fields = new ArrayList<JTextField>();
	
	GuiButton save;
	List<ListEdittor> edittors = new ArrayList<ListEdittor>();
	
	public EdittorPanel(int w, int h, GuiPanel owner, String listName, int index, Object value) {
		super(w, h, false);
		this.owner = owner;
		this.listName = listName;
		this.listIndex = index;
		this.value = value;
		
		this.initGui();
	}
	
	protected void initGui() {
		int buttonID = -1;
		int x = this.guiLeft + 10;
		int w = this.xSize - 20;
		int h = 20;
		int y = this.ySize - h - 10 - 20;
		this.save = new GuiButton(++buttonID, x, y, w, h, "Save", this, this);
		
	}
	
	public abstract void refreshFields();
	
	public abstract void saveFields();
	
	@Override
	public void buttonPressed(GuiButton button) {
		if (button.id == this.save.id) {
			
			this.saveFields();
			
			((IDataOwner) this.owner).passRefreshedData(this.listName, this.listIndex, this.value);
			
			JFrame frame = (JFrame) SwingUtilities.getRoot(this);
			frame.dispose();
			
		}
	}

	@Override
	public void passRefreshedData(String listName, int index, Object value) {
		
	}
	
}
