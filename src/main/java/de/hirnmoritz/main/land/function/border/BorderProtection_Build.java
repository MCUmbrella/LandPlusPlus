package de.hirnmoritz.main.land.function.border;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import de.hirnmoritz.main.chunk.ChunkLocation;
import de.hirnmoritz.main.land.Land;
import de.hirnmoritz.main.land.LandID;
import de.hirnmoritz.main.land.LandManager;
import de.hirnmoritz.main.plugin.PluginSettings;
import de.hirnmoritz.main.uuid.UUIDManager;

public class BorderProtection_Build implements Listener {
	
	@EventHandler
	public void onEvent(BlockPlaceEvent event) {
		
	final Block block = event.getBlock();
	final Player player = event.getPlayer();
	final ArrayList<Location> border = ChunkLocation.getOutLine(block.getChunk(), block.getLocation().getBlockY());
	
	final LandManager manager = new LandManager(new LandID(block.getChunk()));
	final Land land = manager.getLand();
	
		if(PluginSettings.worlds.contains(block.getLocation().getWorld().getName())) {
			if(border.contains(block.getLocation())) {
				if(manager.isClaimed()) {
					if(land.getOwner().equalsIgnoreCase(UUIDManager.getUUID(player))) {
						event.setCancelled(false);
						return;
					}else {
						event.setCancelled(true);
					}
				}
			}
		}
	
		return;
	}
	
	
}
