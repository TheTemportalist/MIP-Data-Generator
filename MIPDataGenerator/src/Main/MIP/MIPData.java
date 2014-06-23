package Main.MIP;

import com.google.gson.Gson;

public class MIPData {

	public String plugin_title;
	public Version version;
	public Author[] authors;
	public String[] description;
	public boolean active;
	public Entity[] entities;
	public Item[] items;
	public Block[] blocks;
	
	public MIPData() {
		this.plugin_title = "Demo Mod";
		this.version = new Version();
		this.authors = new Author[0];
		this.description = new String[0];
		this.active = false;
		this.entities = new Entity[0];
		this.items = new Item[0];
		this.blocks = new Block[0];
		
	}
	
	public void print(Gson g) {
		System.out.println(g.toJson(this));
	}
	
}
