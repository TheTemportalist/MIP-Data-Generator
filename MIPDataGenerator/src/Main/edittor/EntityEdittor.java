package Main.edittor;

import javax.swing.ListModel;

import Core.Gui.GuiButton;
import Core.Gui.GuiPanel;
import Main.MIP.Drop;
import Main.MIP.Entity;

@SuppressWarnings("serial")
public class EntityEdittor extends EdittorPanel {
	
	public EntityEdittor(int w, int h, GuiPanel owner, String listName, int index, Object value) {
		super(w, h, owner, listName, index, value);
	}
	
	@Override
	protected void initGui() {
		super.initGui();
		int buttonID = this.save.id;
		
		this.labels.add(this.createLabel(10, 10, 140, 20, "Name:"));
		this.fields.add(this.createTextFeld(150, 11, 200, 20, 100, this));
		
		this.labels.add(this.createLabel(10, 30, 140, 20, "Type:"));
		this.fields.add(this.createTextFeld(150, 31, 200, 20, 100, this));
		
		this.labels.add(this.createLabel(10, 50, 140, 20, "Health:"));
		this.fields.add(this.createTextFeld(150, 51, 200, 20, 100, this));
		
		this.labels.add(this.createLabel(10, 70, 140, 20, "Spawn Height:"));
		this.labels.add(this.createLabel(20, 90, 130, 20, "Minimum:"));
		this.fields.add(this.createTextFeld(150, 91, 200, 20, 100, this));
		
		this.labels.add(this.createLabel(20, 110, 130, 20, "Maximum:"));
		this.fields.add(this.createTextFeld(150, 111, 200, 20, 100, this));
		
		ListEdittor spawnBiomes = new ListEdittor() {
			@Override
			public Object getDefaultObject() {
				return "biome";
			}
		};
		buttonID = spawnBiomes.init(this, buttonID, 360, 10, 200, 310, "Spawn Biomes");
		this.edittors.add(spawnBiomes);
		
		ListEdittor drops = new ListEdittor() {
			@Override
			public Object getDefaultObject() {
				return new Drop();
			}
		};
		buttonID = drops.init(this, buttonID, 10, 135, 150, 180, "Drops");
		this.edittors.add(drops);
		
		ListEdittor notes = new ListEdittor() {
			@Override
			public Object getDefaultObject() {
				return "note";
			}
		};
		buttonID = notes.init(this, buttonID, 190, 135, 150, 180, "Notes");
		this.edittors.add(notes);
		
		this.refreshFields();
		
	}
	
	@Override
	public void refreshFields() {
		Entity e = (Entity) this.value;
		
		this.fields.get(4).setText(e.spawn_height_maximum);
		this.fields.get(3).setText(e.spawn_height_minimum);
		this.fields.get(2).setText(e.health);
		this.fields.get(1).setText(e.type);
		this.fields.get(0).setText(e.name);
		
		this.edittors.get(0).refreshList(e.spawn_biomes);
		this.edittors.get(1).refreshList(e.drops);
		this.edittors.get(2).refreshList(e.notes);
		
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public void saveFields() {
		Entity e = new Entity();
		
		e.name = this.fields.get(0).getText();
		e.type = this.fields.get(1).getText();
		e.health = this.fields.get(2).getText();
		e.spawn_height_minimum = this.fields.get(3).getText();
		e.spawn_height_maximum = this.fields.get(4).getText();
		
		ListModel model = null;
		Object[] data;
		
		model = this.edittors.get(0).getList().getModel();
		data = new String[model.getSize()];
		for (int i = 0; i < model.getSize(); i++)
			data[i] = (String) model.getElementAt(i);
		e.spawn_biomes = (String[]) data;
		
		model = this.edittors.get(1).getList().getModel();
		data = new Drop[model.getSize()];
		for (int i = 0; i < model.getSize(); i++)
			data[i] = (Drop) model.getElementAt(i);
		e.drops = (Drop[]) data;
		
		model = this.edittors.get(2).getList().getModel();
		data = new String[model.getSize()];
		for (int i = 0; i < model.getSize(); i++)
			data[i] = (String) model.getElementAt(i);
		e.notes = (String[]) data;
		
		this.value = e;
	}
	
	@Override
	public void buttonPressed(GuiButton button) {
		super.buttonPressed(button);
		
		Entity e = (Entity) this.value;
		ListEdittor edittor = null;
		
		edittor = this.edittors.get(0);
		if (edittor.isValidButton(button.id)) {
			Object[] objs = edittor.buttonPress(button.id, e.spawn_biomes);
			e.spawn_biomes = new String[objs.length];
			for (int j = 0; j < objs.length; j++) {
				e.spawn_biomes[j] = (String) objs[j];
			}
		}
		edittor = this.edittors.get(1);
		if (edittor.isValidButton(button.id)) {
			Object[] objs = edittor.buttonPress(button.id, e.drops);
			e.drops = new Drop[objs.length];
			for (int j = 0; j < objs.length; j++) {
				e.drops[j] = (Drop) objs[j];
			}
		}
		edittor = this.edittors.get(2);
		if (edittor.isValidButton(button.id)) {
			Object[] objs = edittor.buttonPress(button.id, e.notes);
			e.notes = new String[objs.length];
			for (int j = 0; j < objs.length; j++) {
				e.notes[j] = (String) objs[j];
			}
		}
		
		this.refreshFields();
	}
	
	@Override
	public void passRefreshedData(String listName, int index, Object value) {
		Entity ent = (Entity)this.value;
		
		if (listName.equalsIgnoreCase("Drops")) {
			if (index >= 0 && index < ent.drops.length) {
				ent.drops[index] = (Drop)value;
			}
		}
		else if (listName.equalsIgnoreCase("Notes")) {
			if (index >= 0 && index < ent.notes.length) {
				ent.notes[index] = (String)value;
			}
		}
		else if (listName.equalsIgnoreCase("Spawn Biomes")) {
			if (index >= 0 && index < ent.spawn_biomes.length) {
				ent.spawn_biomes[index] = (String)value;
			}
		}
		
		this.value = ent;
	}
	
}
