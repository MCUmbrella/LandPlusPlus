package de.hirnmoritz.main.land.function;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import de.hirnmoritz.main.land.Land;
import de.hirnmoritz.main.land.LandID;
import de.hirnmoritz.main.land.LandManager;
import de.hirnmoritz.main.lists.EntityList;
import de.hirnmoritz.main.uuid.UUIDManager;

public class Function_InteractEntity implements Listener {
	
	@EventHandler
	public void onCommand(PlayerInteractEntityEvent event) {
		final Entity e = event.getRightClicked();
		final Player player = event.getPlayer();
		final LandManager manager = new LandManager(new LandID(e.getLocation().getChunk()));
		final Land l = manager.getLand();
			
		if(EntityList.mob.contains(e.getType())) {
			
			if(manager.isClaimed()) {
				if(l.getSettings().isAllowInteractEntity() || l.getOwner().equalsIgnoreCase(UUIDManager.getUUID(player)) || l.getMembers().contains(player.getName())) {
					event.setCancelled(false);
						
					}else {
						event.setCancelled(true);
						
					}
				}
				
			}
				
		return;
	}
	
	
}
