package de.hirnmoritz.main.commandmanager.commands;

import de.hirnmoritz.main.messages.I18nUtil;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import de.hirnmoritz.main.land.Land;
import de.hirnmoritz.main.land.LandID;
import de.hirnmoritz.main.land.LandManager;
import de.hirnmoritz.main.land.border.BorderType;
import de.hirnmoritz.main.messages.PrefixWriter;
import de.hirnmoritz.main.plugin.PluginSettings;
import de.hirnmoritz.main.uuid.UUIDManager;

public class Command_Land_SetBorderHeight implements Listener {
	
	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent event) {
		final Player player = event.getPlayer();
		final LandManager manager = new LandManager(new LandID(player.getLocation().getChunk()));
		final Land land = manager.getLand();
		
		if(event.getMessage().startsWith("/land setBorderHeight")) {
			if(manager.isClaimed()) {
			
				if(land.getOwner().equalsIgnoreCase(UUIDManager.getUUID(player))) {
					final String args[] = event.getMessage().split(" ");
					
					if(args.length == 3) {
						if(args[2] != null) {
							
							int height = 0;
							try {
								height = Integer.parseInt(args[2]);
								
							} catch (Exception e) {
								new PrefixWriter().write(I18nUtil.getLocalizedMessage("not-integer")).send(player);
								return;
							}
							
							if(height < 240) {
								
								if(PluginSettings.border) {
								
									int oldHeight = land.getBorderHeight();
									land.setBorderHeight(height);
									
									new PrefixWriter().write(I18nUtil.getLocalizedMessage("set-height-success")).send(player);
									
									land.createBorder(BorderType.WALL, Material.AIR, player.getLocation().getChunk(), oldHeight);
									land.createBorder(PluginSettings.border_type, PluginSettings.border_material, player.getLocation().getChunk(), height);
							
									land.save();
							
								}else {
									new PrefixWriter().write(I18nUtil.getLocalizedMessage("border-disabled")).send(player);
								}
								
							}else {
								new PrefixWriter().write(I18nUtil.getLocalizedMessage("height-out-of-range")).send(player);
							}
							
						}else {
							new PrefixWriter().write(I18nUtil.getLocalizedMessage("cmd-not-found")).send(player);
						}					
						
					}else {
						new PrefixWriter().write(I18nUtil.getLocalizedMessage("cmd-not-found")).send(player);
					}
					
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
