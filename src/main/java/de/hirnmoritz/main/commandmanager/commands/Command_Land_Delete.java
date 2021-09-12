package de.hirnmoritz.main.commandmanager.commands;

import java.util.ArrayList;

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
import de.hirnmoritz.main.uuid.UUIDManager;

public class Command_Land_Delete implements Listener {

	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent event) {
		final Player player = event.getPlayer();
		
		if(event.getMessage().equalsIgnoreCase("/land delete")) {
			
			final LandManager manager = new LandManager(new LandID(player.getLocation().getChunk()));
			
			if(manager.isClaimed()) {
				final Land l = manager.getLand();
				if(l.getOwner().equalsIgnoreCase(UUIDManager.getUUID(player)) || player.hasPermission("land.admin")) {
						
					int amount = LandManager.getLands(player);
					LandManager.setLands(player, amount-1);
					
					final Land land = manager.getLand();
					
					final ArrayList<String> names = LandManager.getLandNames(player);
					names.remove(land.getName());
					LandManager.setLandNames(player, names);
									
					
					l.createBorder(BorderType.WALL, Material.AIR, player.getLocation().getChunk(), l.getBorderHeight());
					
					l.delete();
					
					new PrefixWriter().write(I18nUtil.getLocalizedMessage("delete-success")).send(player);
					
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
