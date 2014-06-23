package Main.edittor;

import Core.Gui.GuiPanel;

@SuppressWarnings("serial")
public class BiomeEdittor extends EdittorPanel {
	
	public BiomeEdittor(int w, int h, GuiPanel owner, String listName, int index, Object value) {
		super(w, h, owner, listName, index, value);
	}
	
	@Override
	public void initGui() {
		super.initGui();
		
		this.labels.add(this.createLabel(10, 10, 90, 20, "Biome Name:"));
		this.fields.add(this.createTextFeld(100, 10, 200, 20, 100, this));
		
		this.refreshFields();
	}
	
	@Override
	public void refreshFields() {
		this.fields.get(0).setText((String)this.value);
	}
	
	@Override
	public void saveFields() {
		this.value = this.fields.get(0).getText();
	}
	
}