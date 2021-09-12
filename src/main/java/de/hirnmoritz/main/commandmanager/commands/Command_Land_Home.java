package de.hirnmoritz.main.commandmanager.commands;

import de.hirnmoritz.main.messages.I18nUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import de.hirnmoritz.main.land.Land;
import de.hirnmoritz.main.land.LandManager;
import de.hirnmoritz.main.messages.PrefixWriter;

public class Command_Land_Home implements Listener {

	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent event) {
		final Player player = event.getPlayer();
		
		if(event.getMessage().startsWith("/land home")) {
			final String[] args = event.getMessage().split(" ");		
			if(args.length == 3) {
				if(args[2] != null) {
				if(LandManager.getLandNames(player).contains(args[2])) {
					final LandManager manager = new LandManager(LandManager.getLandID(args[2]));
					final Land l= manager.getLand();
						
					l.teleport(player);
					new PrefixWriter().write(I18nUtil.getLocalizedMessage("tphome-success")).send(player);
	
					}else {
						new PrefixWriter().write(I18nUtil.getLocalizedMessage("land-not-found")).send(player);
					}
				
				}else {
					new PrefixWriter().write(I18nUtil.getLocalizedMessage("land-not-found")).send(player);
				}
				
			}else {
				new PrefixWriter().write(I18nUtil.getLocalizedMessage("cmd-not-found")).send(player);
			}
	
		}
		
		return;
	}
	
	
}
