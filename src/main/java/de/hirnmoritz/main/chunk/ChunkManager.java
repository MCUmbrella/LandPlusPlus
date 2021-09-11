package de.hirnmoritz.main.chunk;

import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.block.Biome;

public abstract class ChunkManager {

	public static void changeBiome(Chunk chunk) {
		final int cX = chunk.getX() * 16; 
		final int cZ = chunk.getZ() * 16;
		final World world = chunk.getWorld();

		for(int x = 0; x < 16; x++) {
		     for(int z = 0; z < 16; z++) {
		          world.setBiome(cX + x, cZ+ z, Biome.SNOWY_TUNDRA);
		     }
		}
		
		
		return;
	}
	
	
}
