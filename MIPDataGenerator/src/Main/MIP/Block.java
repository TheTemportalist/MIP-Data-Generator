package Main.MIP;

import java.util.HashMap;

public class Block {
	
	public String name;
	public Type type;
	
	public enum Type {
		SOLID("Solid Block"), NONSOLID("Non-Solid Block"), FLUID("Fluid"), PLANT("Plant"), TILE(
				"Tile Entity"), BLOCK("Block");
		
		private static HashMap<String, Integer> positions = new HashMap<String, Integer>();
		
		private String name;
		
		Type(String name) {
			this.name = name;
		}
		
		@Override
		public String toString() {
			return this.name;
		}
		
		public static Type getType(String name) {
			return Type.positions.containsKey(name) ? Type.values()[Type.positions.get(name)]
					: null;
		}
		
	}
	
	public boolean ignoresGravity;
	public boolean hasTranspanrency;
	public boolean emitsLight;
	public String blastResistance;
	public String harvestLevel;
	public String stackLimit;
	public boolean flammable;
	public Drop[] drops;
	
	public Block() {
		this.name = "block";
		this.type = Block.Type.SOLID;
		this.ignoresGravity = true;
		this.hasTranspanrency = false;
		this.emitsLight = false;
		this.blastResistance = "0";
		this.harvestLevel = "Wood";
		this.stackLimit = "64";
		this.flammable = false;
		this.drops = new Drop[0];
		
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
}
