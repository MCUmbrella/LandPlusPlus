package de.hirnmoritz.main.land.function.border;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPistonExtendEvent;

import de.hirnmoritz.main.chunk.ChunkLocation;
import de.hirnmoritz.main.plugin.PluginSettings;

public class BorderProtection_Piston implements Listener {
	
	@EventHandler
	public void onEvent(BlockPistonExtendEvent event) {
		final Block block = event.getBlock();		
		final ArrayList<Location> outline = ChunkLocation.getOutLine(block.getWorld().getChunkAt(block.getChunk().getX(), block.getChunk().getZ()), block.getLocation().getBlockY()); 
		final Location[] border = outline.toArray(new Location[outline.size()]);
		
		if(PluginSettings.worlds.contains(block.getLocation().getWorld().getName())) {

			for(int i=0; i<border.length; i++) {
				final double distance = border[i].distance(block.getLocation());
				if(distance <= 2) {
					event.setCancelled(true);
				}
			}
			
		}
		
		return;
	}
	
	
}
