package de.hirnmoritz.main.land.function;

import de.hirnmoritz.main.messages.I18nUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import de.hirnmoritz.main.land.Land;
import de.hirnmoritz.main.land.LandID;
import de.hirnmoritz.main.land.LandManager;
import de.hirnmoritz.main.messages.PrefixWriter;
import de.hirnmoritz.main.uuid.UUIDManager;

public class Function_Build implements Listener {
	
	@EventHandler
	public void onEvent(BlockPlaceEvent event) {
		final Player player = event.getPlayer();
		final LandManager manager = new LandManager(new LandID(event.getBlock().getLocation().getChunk()));
		final Land l = manager.getLand();
		
		if(manager.isClaimed()) {
			if(l.getSettings().isAllowBuild() || l.getOwner().equalsIgnoreCase(UUIDManager.getUUID(player)) || l.getMembers().contains(player.getName())) {
				event.setCancelled(false);
			}else {
				event.setCancelled(true);
				new PrefixWriter().write(I18nUtil.getLocalizedMessage("cant-build")).send(player);
			}
		}
		
		
		return;
	}
	
	
}
