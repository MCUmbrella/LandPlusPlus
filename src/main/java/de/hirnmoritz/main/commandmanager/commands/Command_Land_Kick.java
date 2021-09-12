package de.hirnmoritz.main.commandmanager.commands;

import de.hirnmoritz.main.messages.I18nUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import de.hirnmoritz.main.land.Land;
import de.hirnmoritz.main.land.LandID;
import de.hirnmoritz.main.messages.PrefixWriter;
import de.hirnmoritz.main.uuid.UUIDManager;

public class Command_Land_Kick implements Listener {
	
	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent event) {
		final Player player = event.getPlayer();
		
		if(event.getMessage().startsWith("/land kick")) {
			
			final de.hirnmoritz.main.land.LandManager manager = new de.hirnmoritz.main.land.LandManager(new LandID(player.getLocation().getChunk()));
			
			if(manager.isClaimed()) {
				final Land land = manager.getLand();
				if(land.getOwner().equalsIgnoreCase(UUIDManager.getUUID(player)) || player.hasPermission("land.admin")) {
						
					 String args[] = event.getMessage().split(" ");
						 
					 if(args.length == 3) {
						@SuppressWarnings("deprecation")
						final Player target = Bukkit.getPlayer(args[2]);
						if(target != null) {
						 
							 land.removeMember(args[2]);
							 land.save();
								 
							 new PrefixWriter().write(I18nUtil.getLocalizedMessage("kickmember-success").replace("NAME",args[2])).send(player);
						
						}else {
							new PrefixWriter().write(I18nUtil.getLocalizedMessage("player-not-found")).send(player);
						}
						
					 }else {
						 new PrefixWriter().write(I18nUtil.getLocalizedMessage("invalid-player-name")).send(player);
					 }
						
	
				}else {
					new PrefixWriter().write(I18nUtil.getLocalizedMessage("not-owner")).send(player);
				}				
					
			}else {
				new PrefixWriter().write(I18nUtil.getLocalizedMessage("not-on-land")).send(player);
			}
			
		}
		
		return;
	}
	
	
}
