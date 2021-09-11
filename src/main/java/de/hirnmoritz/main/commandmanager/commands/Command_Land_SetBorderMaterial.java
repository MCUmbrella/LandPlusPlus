package de.hirnmoritz.main.commandmanager.commands;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import de.hirnmoritz.main.land.Land;
import de.hirnmoritz.main.land.LandID;
import de.hirnmoritz.main.land.LandManager;
import de.hirnmoritz.main.land.border.BorderMaterial;
import de.hirnmoritz.main.messages.Chat;
import de.hirnmoritz.main.messages.PrefixWriter;
import de.hirnmoritz.main.plugin.PluginSettings;
import de.hirnmoritz.main.uuid.UUIDManager;

public class Command_Land_SetBorderMaterial implements Listener {

	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent event) {
		final Player player = event.getPlayer();
		
		if(event.getMessage().startsWith("/land setBorderMaterial")) {
			final String[] args = event.getMessage().split(" ");
			final LandManager manager = new LandManager(new LandID(player.getLocation().getChunk()));
			final Land land = manager.getLand();
			
			if(manager.isClaimed()) {
			
				if(land.getOwner().equalsIgnoreCase(UUIDManager.getUUID(player))) {
				
					if(args.length == 2) {
						new PrefixWriter().write("§8"+Chat.LINE.getIndex()).send(player);
						final Material[] material = BorderMaterial.types.toArray(new Material[BorderMaterial.types.size()]);
						new PrefixWriter().write("§3A list of materials is listed below:").send(player);
						new PrefixWriter().write(Chat.PLACEHOLDER.getIndex()).send(player);
						
						for(int i=0; i<material.length; i++) {
							new PrefixWriter().write("§f -§6 "+material[i]).send(player);;
						}
						
						new PrefixWriter().write("§8"+Chat.LINE.getIndex()).send(player);
						return;
					}
					
					else if(args.length == 3) {
						if(BorderMaterial.types.contains(Material.getMaterial(args[2]))) {
							
							if(PluginSettings.border) {
							
								final Material material = Material.getMaterial(args[2]);
								land.createBorder(PluginSettings.border_type, material, player.getLocation().getChunk(), land.getBorderHeight());
								land.save();
								
								new PrefixWriter().write("§aSuccessfully changed border material!").send(player);
							
							}else {
								new PrefixWriter().write("§cLand border is disabled").send(player);
							}
								
						}else {
							new PrefixWriter().write("§cMaterial doesn't exist!").send(player);
						}
						
					}else {
						new PrefixWriter().write("§cCommand not found, try §6/land setBorderMaterial <material>").send(player);
					}
				
				}else {
					new PrefixWriter().write("§cYou are not the §6Owner§c of this land!").send(player);
				}
			
			}else {
				new PrefixWriter().write("§cThat is not your land!").send(player);
			}
			
		}
		
		return;
	}
	
	
}
