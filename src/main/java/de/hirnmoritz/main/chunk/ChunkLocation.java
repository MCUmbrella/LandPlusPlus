package de.hirnmoritz.main.chunk;

import java.util.ArrayList;

import org.bukkit.Chunk;
import org.bukkit.Location;

public abstract class ChunkLocation {

	public static Location getMiddle(Chunk chunk, int height) {
		return chunk.getBlock(7, height, 7).getLocation();
	}
	
	public static Location[] getCorner(Chunk chunk, int height) {
		final Location location[] = new Location[4];
		
		location[0] = chunk.getBlock(0, height, 0).getLocation();		
		location[1] = chunk.getBlock(15, height, 15).getLocation();
		location[2] = chunk.getBlock(0, height, 15).getLocation();
		location[3] = chunk.getBlock(15, height, 0).getLocation();
		
		return location;
	}
	
	public static ArrayList<Location> getOutLine(Chunk chunk, int height) {
		final ArrayList<Location> outline = new ArrayList<>();
		
		final Location[] location = ChunkLocation.getCorner(chunk, height);
		
		for(int i=0; i<16; i++) {
			outline.add(new Location(chunk.getWorld(), location[0].getX(), height, location[0].getZ()));
			location[0].add(1, 0, 0);
		}
		
		for(int i=0; i<16; i++) {
			outline.add(new Location(chunk.getWorld(), location[1].getX(), height, location[1].getZ()));
			location[1].add(-1, 0, 0);
		}
		
		for(int i=0; i<16; i++) {
			outline.add(new Location(chunk.getWorld(), location[2].getX(), height, location[2].getZ()));
			location[2].add(0, 0, -1);
		}
		
		for(int i=0; i<16; i++) {
			outline.add(new Location(chunk.getWorld(), location[3].getX(), height, location[3].getZ()));
			location[3].add(0, 0, 1);
		}		
		
		return outline;
	}
	
	
}
