package de.hirnmoritz.main.commandmanager.commands;

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
						
						new PrefixWriter().write("§aYou haven been teleportet!").send(player);
				
					}else {
						new PrefixWriter().write("§cLand not found!").send(player);
					}
				
				}else {
					new PrefixWriter().write("§cEnter name fist!").send(player);
				}
				
			}else {
				new PrefixWriter().write("§cCommand not found, try §6/land visit <name>").send(player);
			}
			
		
		}
		
		return;
	}
	
	
}
