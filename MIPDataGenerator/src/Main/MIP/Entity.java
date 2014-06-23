package Main.MIP;

public class Entity {
	
	public String name;
	public String type;
	public String health;
	public Drop[] drops;
	public String[] spawn_biomes;
	public String spawn_height_minimum;
	public String spawn_height_maximum;
	public String[] notes;
	
	public Entity() {
		this.name = "entity";
		this.type = "Peaceful";
		this.health = "0";
		this.drops = new Drop[0];
		this.spawn_biomes = new String[0];
		this.spawn_height_minimum = "0";
		this.spawn_height_maximum = "0";
		this.notes = new String[0];
		
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
}
