package de.hirnmoritz.main.commandmanager.commands;

import de.hirnmoritz.main.messages.I18nUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import de.hirnmoritz.main.chunk.ChunkLocation;
import de.hirnmoritz.main.land.Land;
import de.hirnmoritz.main.land.LandID;
import de.hirnmoritz.main.land.LandManager;
import de.hirnmoritz.main.messages.PrefixWriter;

public class Command_Land_Middle implements Listener {

	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent event) {
		final Player player = event.getPlayer();
		final LandManager manager = new LandManager(new LandID(player.getLocation().getChunk()));
		
		if(event.getMessage().equalsIgnoreCase("/land middle")) {
		
			if(manager.isClaimed()) {
				final Land land = manager.getLand();
				player.teleport(ChunkLocation.getMiddle(player.getLocation().getChunk(), land.getMiddle().getBlockY()));
				
				new PrefixWriter().write(I18nUtil.getLocalizedMessage("tpmiddle-success")).send(player);
				
			}else {
				new PrefixWriter().write(I18nUtil.getLocalizedMessage("land-not-claimed")).send(player);
			}
		
		}
		
		return;
	}
	
	
}
