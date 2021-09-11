package de.hirnmoritz.main.land;

import org.bukkit.Chunk;

public class LandID {
	
	private String id;
	
	public LandID(Chunk chunk) {
		this.id = String.valueOf(chunk.getX())+":::"+String.valueOf(chunk.getZ());
		return;
	}
	
	public LandID(int x, int z) {
		this.id = String.valueOf(x)+":::"+String.valueOf(z);
		return;
	}
	
	public LandID(String stringID) {
		this.id = stringID;
		return;
	}
	
	public String getId() {
		return id;
	}
	
	
}
