package de.hirnmoritz.main.commandmanager.commands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import de.hirnmoritz.main.land.Land;
import de.hirnmoritz.main.land.LandID;
import de.hirnmoritz.main.land.LandManager;
import de.hirnmoritz.main.messages.PrefixWriter;
import de.hirnmoritz.main.uuid.UUIDManager;

public class Command_Land_Add implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent event) {
		final Player player = event.getPlayer();
		
		if(event.getMessage().startsWith("/land add") || event.getMessage().startsWith("/l add")) {
						
			final LandManager manager = new LandManager(new LandID(player.getLocation().getChunk()));
			
			if(manager.isClaimed()) {
				final Land land = manager.getLand();
				if(land.getOwner().equalsIgnoreCase(UUIDManager.getUUID(player))) {
						
					 String args[] = event.getMessage().split(" ");
						 
					 if(args.length == 3) {
							 
						 final Player target = Bukkit.getPlayer(args[2]);						 
						 
						 if(target != null) {
							 
							 land.addMember(args[2]);
							 land.save();
							 
							 
							 new PrefixWriter().write("§aSuccessfully added: §6"+args[2]+" §ato your land!").send(player);
							 
						 }else {
							 new PrefixWriter().write("§cPlayer not online!").send(player);
						 }
	 
					 }else {
						 new PrefixWriter().write("§cEnter an available name first!").send(player);
					 }	
						
				}else {
					new PrefixWriter().write("§cYou are not the §6Owner §cof this land!").send(player);
				}				
					
			}else {
				new PrefixWriter().write("§cYou are not on your land!").send(player);
			}
			
		}
		
		
		return;
	}
	
	
}
