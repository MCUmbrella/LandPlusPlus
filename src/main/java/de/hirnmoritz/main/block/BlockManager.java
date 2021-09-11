package de.hirnmoritz.main.block;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.block.Block;

public abstract class BlockManager {

	public static ArrayList<Block> getNearbyBlocks(Location location, float radius){		
		final ArrayList<Block> blocks = new ArrayList<Block>();
		
        for(int x = (int) (location.getX() - radius); x <= location.getBlockX() + radius; x++) {
            for(int y = (int) (location.getY() - radius); y <= location.getBlockY() + radius; y++) {
                for(int z = (int) (location.getZ() - radius); z <= location.getBlockZ() + radius; z++) {
                   blocks.add(location.getWorld().getBlockAt(x, y, z));
                }
            }
        }
		
		return blocks;
	}
	
	
}
