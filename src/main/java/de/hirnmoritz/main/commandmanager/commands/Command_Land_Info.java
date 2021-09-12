package de.hirnmoritz.main.commandmanager.commands;

import java.util.UUID;

import de.hirnmoritz.main.messages.I18nUtil;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import de.hirnmoritz.main.coloredboolean.ColoredBoolean;
import de.hirnmoritz.main.land.Land;
import de.hirnmoritz.main.land.LandID;
import de.hirnmoritz.main.land.LandManager;
import de.hirnmoritz.main.messages.Chat;
import de.hirnmoritz.main.messages.PrefixWriter;

public class Command_Land_Info implements Listener {
	
	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent event) {
		final Player player = event.getPlayer();
		
		if(event.getMessage().equalsIgnoreCase("/land info")) {
			final LandManager manager = new LandManager(new LandID(player.getLocation().getChunk()));
			final Land l = manager.getLand();
			
				if(manager.isClaimed()) {
					
					new PrefixWriter().write("§8"+Chat.LINE.getIndex()).send(player);
					new PrefixWriter().write(I18nUtil.getLocalizedMessage("name")+ l.getName()).send(player);
					final OfflinePlayer p = Bukkit.getServer().getOfflinePlayer(UUID.fromString(l.getOwner()));
					new PrefixWriter().write(I18nUtil.getLocalizedMessage("owner")+ p.getName()).send(player);
					
					new PrefixWriter().write(Chat.PLACEHOLDER.getIndex()).send(player);					
					
					new PrefixWriter().write(I18nUtil.getLocalizedMessage("members")).send(player);
					
					final String[] members = l.getMembers().toArray(new String[l.getMembers().size()]);

					for (String member : members) {
						new PrefixWriter().write(" " + Chat.SEPERATOR.getIndex() + " §e" + member).send(player);
					}
					
					new PrefixWriter().write(Chat.PLACEHOLDER.getIndex()).send(player);
					
					new PrefixWriter().write(I18nUtil.getLocalizedMessage("settings")).send(player);
					new PrefixWriter().write("§f- §6allowBreak §8("+ColoredBoolean.get(l.getSettings().isAllowBreak())+"§8)").send(player);
					new PrefixWriter().write("§f- §6allowBuild §8("+ColoredBoolean.get(l.getSettings().isAllowBuild())+"§8)").send(player);
					new PrefixWriter().write("§f- §6allowPvP §8("+ColoredBoolean.get(l.getSettings().isAllowPvP())+"§8)").send(player);
					new PrefixWriter().write("§f- §6allowTnT §8("+ColoredBoolean.get(l.getSettings().isAllowTnT())+"§8)").send(player);
					new PrefixWriter().write("§f- §6allowInteractEntity §8("+ColoredBoolean.get(l.getSettings().isAllowInteractEntity())+"§8)").send(player);
					new PrefixWriter().write("§f- §6allowUseButton §8("+ColoredBoolean.get(l.getSettings().isAllowUseButton())+"§8)").send(player);
					new PrefixWriter().write("§f- §6allowUseChest §8("+ColoredBoolean.get(l.getSettings().isAllowUseChest())+"§8)").send(player);
					new PrefixWriter().write("§f- §6allowUseTrappedChest §8("+ColoredBoolean.get(l.getSettings().isAllowUseTrappedChest())+"§8)").send(player);
					new PrefixWriter().write("§f- §6allowUseDoor §8("+ColoredBoolean.get(l.getSettings().isAllowUseDoor())+"§8)").send(player);
					new PrefixWriter().write("§f- §6allowUseFurnace §8("+ColoredBoolean.get(l.getSettings().isAllowUseFurnace())+"§8)").send(player);
					
					new PrefixWriter().write("§8"+Chat.LINE.getIndex()).send(player);
					
				}else {
					new PrefixWriter().write("§8"+Chat.LINE.getIndex()).send(player);
					new PrefixWriter().write(I18nUtil.getLocalizedMessage("land-not-claimed")).send(player);
					new PrefixWriter().write("§8"+Chat.LINE.getIndex()).send(player);
				}
					
			}
		
		return;
	}
	
	
}
