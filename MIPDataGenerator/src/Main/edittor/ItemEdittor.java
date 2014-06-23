package Main.edittor;

import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import Core.Gui.GuiPanel;
import Main.MIP.Item;

@SuppressWarnings("serial")
public class ItemEdittor extends EdittorPanel {
	
	JComboBox<Item.Type> itemType;
	
	public ItemEdittor(int w, int h, GuiPanel owner, String listName, int index, Object value) {
		super(w, h, owner, listName, index, value);
	}
	
	@Override
	public void initGui() {
		super.initGui();
		
		this.labels.add(this.createLabel(10, 10, 90, 20, "Name:"));
		this.fields.add(this.createTextFeld(100, 11, 100, 20, 100, this));
		
		this.labels.add(this.createLabel(10, 35, 100, 20, "Type:"));
		this.itemType = new JComboBox<Item.Type>();
		this.itemType.setBounds(100, 35, 100, 25);
		this.itemType.addActionListener(this);
		this.itemType.setModel(new DefaultComboBoxModel<Item.Type>(Item.Type.values()));
		this.add(this.itemType);
		
		this.refreshFields();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		if (e.getSource() instanceof JComboBox) {
			
		}
	}
	
	@Override
	public void refreshFields() {
		Item item = (Item) this.value;
		
		this.fields.get(0).setText(item.name);
		
		for (int i = 0; i < Item.Type.values().length; i++) {
			if (Item.Type.values()[i] == item.type) {
				this.itemType.setSelectedIndex(i);
				break;
			}
		}
		
	}
	
	@Override
	public void saveFields() {
		Item item = new Item();
		
		item.name = this.fields.get(0).getText();
		item.type = this.itemType.getItemAt(this.itemType.getSelectedIndex());
		
		this.value = item;
	}
	
}