package de.hirnmoritz.main.land.function;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import de.hirnmoritz.main.land.Land;
import de.hirnmoritz.main.land.LandID;
import de.hirnmoritz.main.land.LandManager;
import de.hirnmoritz.main.lists.ButtonList;
import de.hirnmoritz.main.lists.DoorList;
import de.hirnmoritz.main.messages.PrefixWriter;
import de.hirnmoritz.main.uuid.UUIDManager;

public class Function_InteractUse implements Listener {

	@EventHandler
	public void onEvent(PlayerInteractEvent event) {
		if(event.getAction() == Action.RIGHT_CLICK_BLOCK) {
		final Player player = event.getPlayer();
		final LandManager manager = new LandManager(new LandID(event.getClickedBlock().getLocation().getChunk()));
		final Land l = manager.getLand();
		
		if(manager.isClaimed()) {
		
			if(DoorList.doors.contains(event.getClickedBlock().getType())) {
				if(l.getSettings().isAllowUseDoor()  || l.getMembers().contains(player.getName()) || l.getOwner().equalsIgnoreCase(UUIDManager.getUUID(player))) {
					event.setCancelled(false);
				}else {
					event.setCancelled(true);
					new PrefixWriter().write("§cYou can't use doors on this land!").send(player);
				}
			}
			
			if(ButtonList.buttons.contains(event.getClickedBlock().getType())) {
				if(l.getSettings().isAllowUseButton() || l.getMembers().contains(player.getName()) || l.getOwner().equalsIgnoreCase(UUIDManager.getUUID(player))) {
					event.setCancelled(false);
				}else {
					event.setCancelled(true);
					new PrefixWriter().write("§cYou can't use buttons on this land!").send(player);
				}
			}
			
			if(event.getClickedBlock().getType() == Material.TRAPPED_CHEST) {
				if(l.getSettings().isAllowUseTrappedChest()  || l.getMembers().contains(player.getName()) || l.getOwner().equalsIgnoreCase(UUIDManager.getUUID(player))) {
					event.setCancelled(false);
				}else {
					event.setCancelled(true);
					new PrefixWriter().write("§cYou can't use trapped chests on this land!").send(player);
				}
			}
			
			if(event.getClickedBlock().getType() == Material.CHEST) {
				if(l.getSettings().isAllowUseChest() || l.getMembers().contains(player.getName()) || l.getOwner().equalsIgnoreCase(UUIDManager.getUUID(player))) {
					event.setCancelled(false);
				}else {
					event.setCancelled(true);
					new PrefixWriter().write("§cYou can't use chests on this land!").send(player);
				}
			}
			
			if(event.getClickedBlock().getType() == Material.FURNACE) {
				if(l.getSettings().isAllowUseFurnace() || l.getMembers().contains(player.getName()) || l.getOwner().equalsIgnoreCase(UUIDManager.getUUID(player))) {
					event.setCancelled(false);
				}else {
					event.setCancelled(true);
					new PrefixWriter().write("§cYou can't use furnaces on this land!").send(player);
				}
			}
		
		}
			
		}
		
		return;
	}

	
}
