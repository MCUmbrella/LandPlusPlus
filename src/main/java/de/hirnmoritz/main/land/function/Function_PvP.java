package de.hirnmoritz.main.land.function;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import de.hirnmoritz.main.land.Land;
import de.hirnmoritz.main.land.LandID;
import de.hirnmoritz.main.land.LandManager;
import de.hirnmoritz.main.messages.PrefixWriter;

public class Function_PvP implements Listener {

	@EventHandler
	public void onEvent(EntityDamageByEntityEvent event) {
		final Entity damaged = event.getEntity();
		final Entity damager = event.getDamager();
		if(damager instanceof Player && damaged instanceof Player) {
			final LandManager manager = new LandManager(new LandID(damaged.getLocation().getChunk()));
			final Land land = manager.getLand();
			
			if(manager.isClaimed()) {
				if(!(land.getSettings().isAllowPvP())) {
					event.setCancelled(true);
					new PrefixWriter().write("§cPvP is not allowed on this land!").send((Player)damager);
				}else {
					event.setCancelled(false);
				}
			}
			
		}
		
		return;
	}
	
	
}
