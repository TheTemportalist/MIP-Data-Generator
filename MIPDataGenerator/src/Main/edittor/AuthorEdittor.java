package Main.edittor;

import Core.Gui.GuiButton;
import Core.Gui.GuiPanel;
import Main.MIP.Author;

@SuppressWarnings("serial")
public class AuthorEdittor extends EdittorPanel {
	
	public AuthorEdittor(int w, int h, GuiPanel owner, String listName, int index, Object value) {
		super(w, h, owner, listName, index, value);
	}
	
	@Override
	protected void initGui() {
		super.initGui();
		
		this.labels.add(this.createLabel(10, 10, 140, 20, "Author's Name:"));
		this.fields.add(this.createTextFeld(150, 11, 200, 20, 100, this));
		
		this.labels.add(this.createLabel(10, 30, 140, 20, "Author's Twitter:      @"));
		this.fields.add(this.createTextFeld(150, 31, 200, 20, 100, this));
		
		this.refreshFields();
		
	}
	
	@Override
	public void refreshFields() {
		Author a = (Author) this.value;
		
		this.fields.get(1).setText(a.twitterHandler);
		this.fields.get(0).setText(a.name);
		
	}
	
	@Override
	public void saveFields() {
		Author a = new Author();
		
		a.name = this.fields.get(0).getText();
		a.twitterHandler = this.fields.get(1).getText();
		
		this.value = a;
	}
	
	@Override
	public void buttonPressed(GuiButton button) {
		super.buttonPressed(button);
		
		this.refreshFields();
	}
	
}
