package Core.Gui;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GuiButton extends JButton {
	
	public final int id;
	
	public GuiButton(int id, int x, int y, int w, int h, String name, ActionListener listener, JPanel panel) {
		super(name);
		
		this.id = id;
		
		this.setBounds(x, y, w, h);
		this.addActionListener(listener);
		this.setVisible(true);
		
		panel.add(this);
	}
	
}
