package de.hirnmoritz.main.commandmanager.commands;

import de.hirnmoritz.main.messages.I18nUtil;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import de.hirnmoritz.main.land.Land;
import de.hirnmoritz.main.land.LandID;
import de.hirnmoritz.main.land.LandManager;
import de.hirnmoritz.main.messages.PrefixWriter;
import de.hirnmoritz.main.uuid.UUIDManager;

public class Command_Land_SetHome implements Listener {

	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent event) {
		final Player player = event.getPlayer();
		
		if(event.getMessage().equalsIgnoreCase("/land setHome")) {
			final LandManager manager = new LandManager(new LandID(player.getLocation().getChunk()));
			
			if(manager.isClaimed()) {
				final Land land = manager.getLand();
				
				if(land.getOwner().equalsIgnoreCase(UUIDManager.getUUID(player))) {
					
					land.setMiddle(new Location(player.getWorld(), player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getBlockZ()));
					land.save();
					
					new PrefixWriter().write(I18nUtil.getLocalizedMessage("sethome-success")).send(player);
					
				}else {
					new PrefixWriter().write(I18nUtil.getLocalizedMessage("not-owner")).send(player);
				}
				
			}else {
				new PrefixWriter().write(I18nUtil.getLocalizedMessage("land-not-claimed")).send(player);
			}
			
		}
		
		return;
	}
	
	
}
