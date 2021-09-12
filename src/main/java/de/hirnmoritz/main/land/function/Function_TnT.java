package de.hirnmoritz.main.land.function;

import de.hirnmoritz.main.messages.I18nUtil;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import de.hirnmoritz.main.land.Land;
import de.hirnmoritz.main.land.LandID;
import de.hirnmoritz.main.land.LandManager;
import de.hirnmoritz.main.messages.PrefixWriter;

public class Function_TnT implements Listener {
			
		@EventHandler
		public void onTnT(ExplosionPrimeEvent event) {
			final Entity entity = event.getEntity();
			final LandManager manager = new LandManager(new LandID(entity.getLocation().getChunk()));
			
			if(manager.isClaimed()) {
				final Land land = manager.getLand();
				
				if(land.getSettings().isAllowTnT()) {
					
					event.setCancelled(false);
					
				}else {
					
					event.setCancelled(true);
					
				}
				
			}	
		

		return;
	}
	
	
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		final Player player = event.getPlayer();
		
		if(event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(event.getClickedBlock().getType() == Material.TNT) {
				final LandManager manager = new LandManager(new LandID(event.getClickedBlock().getLocation().getChunk()));
				
				if(manager.isClaimed()) {
					final Land land = manager.getLand();
					
					if(land.getSettings().isAllowTnT()) {
						event.setCancelled(false);
					}else {
						event.setCancelled(true);
						new PrefixWriter().write(I18nUtil.getLocalizedMessage("cant-tnt")).send(player);
					}
					
				}
				
			}
		}
		
		return;
	}
		
	
}

