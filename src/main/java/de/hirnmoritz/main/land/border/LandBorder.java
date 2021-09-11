package de.hirnmoritz.main.land.border;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;

import de.hirnmoritz.main.chunk.ChunkLocation;


public abstract class LandBorder  {

	public static void create(BorderType type, Chunk chunk, int height, Material material) {
		
		if(type == BorderType.CORNER) {
			final Location[] location = ChunkLocation.getCorner(chunk, height);
			for(int i= 0; i<location.length; i++) {
				location[i].getBlock().setType(material);
			}	
			
		}
		
		else if(type == BorderType.WALL) {
			final Location[] location = ChunkLocation.getCorner(chunk, height);
			for(int i=0; i<16; i++) {
				location[0].getBlock().setType(material);
				location[0].add(1, 0, 0);
			}
			
			for(int i=0; i<16; i++) {
				location[1].getBlock().setType(material);
				location[1].add(-1, 0, 0);
			}
			
			for(int i=0; i<16; i++) {
				location[2].getBlock().setType(material);
				location[2].add(0, 0, -1);
			}
			
			for(int i=0; i<16; i++) {
				location[3].getBlock().setType(material);
				location[3].add(0, 0, 1);
			}		
			
		}
		
		return;
	}
	
	
}
