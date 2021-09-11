package de.hirnmoritz.main.commandmanager.commands;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import de.hirnmoritz.main.land.Land;
import de.hirnmoritz.main.land.LandID;
import de.hirnmoritz.main.land.LandManager;
import de.hirnmoritz.main.land.LandTranslator;
import de.hirnmoritz.main.messages.PrefixWriter;
import de.hirnmoritz.main.plugin.PluginSettings;

public class Command_Land_Claim implements Listener{

	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent event) {
		final Player player = event.getPlayer();
		final LandManager manager = new LandManager(new LandID(player.getLocation().getChunk()));
		
		if(event.getMessage().startsWith("/land claim")) {
			
			final String[] args = event.getMessage().split(" ");
			if(args.length == 3) {
				if(LandTranslator.available(args[2]) == true) {
					if(!manager.isClaimed()) {
						if(LandManager.getLands(player) < PluginSettings.max_claims) {
							if(player.isOnGround()) {
								final Land l = manager.getLand();
								l.claim(args[2], player, player.getLocation().getChunk(), player.getLocation().getBlockY());
								
								if(PluginSettings.border) {
									l.createBorder(PluginSettings.border_type, PluginSettings.border_material, player.getLocation().getChunk(), player.getLocation().getBlockY());
								}
								
								l.save();
							
								new PrefixWriter().write("§aYou have successfully claimed this land!").send(player);
								
							}else {
								new PrefixWriter().write("§cGo on ground first!").send(player);
							}
							
						}else {
							new PrefixWriter().write("§cYou have already claimed the max amount of lands!").send(player);
						}
						
					}else {
						new PrefixWriter().write("§cThis land is already claimed!").send(player);
					}
				
				}else {
					new PrefixWriter().write("§cThis name is already used, try an other!").send(player);
				}
			
			}else {
				new PrefixWriter().write("§cCommand not found, try §6/land claim <name> §cto claim a land!").send(player);
			}
		
		}
	
		return;
	}
	
	
}
