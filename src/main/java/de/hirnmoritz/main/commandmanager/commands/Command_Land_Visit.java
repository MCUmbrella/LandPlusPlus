package de.hirnmoritz.main.commandmanager.commands;

import de.hirnmoritz.main.messages.I18nUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import de.hirnmoritz.main.land.Land;
import de.hirnmoritz.main.land.LandManager;
import de.hirnmoritz.main.messages.PrefixWriter;

public class Command_Land_Visit implements Listener {

	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent event) {
		final Player player = event.getPlayer();
		final String args[] = event.getMessage().split(" ");
		
		if(event.getMessage().startsWith("/land visit")) {
			if(args.length == 3) {
				if(args[2] != null) {
				
					if(LandManager.nameIsSet(args[2])) {
					
						final Land land = new Land(LandManager.getLandID(args[2]));
						land.load();
						land.teleport(player);
						
						new PrefixWriter().write(I18nUtil.getLocalizedMessage("visit-success")).send(player);
				
					}else {
						new PrefixWriter().write(I18nUtil.getLocalizedMessage("land-not-found")).send(player);
					}
				
				}else {
					new PrefixWriter().write(I18nUtil.getLocalizedMessage("enter-name-first")).send(player);
				}
				
			}else {
				new PrefixWriter().write(I18nUtil.getLocalizedMessage("cmd-not-found")).send(player);
			}
			
		
		}
		
		return;
	}
	
	
}
