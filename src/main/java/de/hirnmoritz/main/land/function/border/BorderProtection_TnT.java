package de.hirnmoritz.main.land.function.border;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExplosionPrimeEvent;

import de.hirnmoritz.main.block.BlockManager;
import de.hirnmoritz.main.chunk.ChunkLocation;

public class BorderProtection_TnT implements Listener {

	@EventHandler
	public void onEvent(ExplosionPrimeEvent event) {
		final Entity entity = event.getEntity();
		final Location location = entity.getLocation();
		
	    final ArrayList<Block> blocks = BlockManager.getNearbyBlocks(location, event.getRadius());
		final ArrayList<Location> outline = ChunkLocation.getOutLine(entity.getLocation().getChunk(), 0);
		final Block[] b = blocks.toArray(new Block[blocks.size()]);
	        
		for(int i=0; i<b.length; i++) {
			if(outline.contains(new Location(b[i].getLocation().getWorld(), b[i].getLocation().getX(), 0, b[i].getLocation().getZ()))) {
				event.setRadius(1f);
			   
				final ArrayList<Block> tf = BlockManager.getNearbyBlocks(location, event.getRadius());
				final Block[] testfor = tf.toArray(new Block[tf.size()]);
				for(int a=0; a<testfor.length; a++) {
						
					if(outline.contains(new Location(testfor[a].getLocation().getWorld(), testfor[a].getLocation().getX(), 0, testfor[a].getLocation().getZ()))) {
						event.setCancelled(true);
					}
					
					
				}
			}		
			

		}
		
		return;
	}
	   
	    
}
