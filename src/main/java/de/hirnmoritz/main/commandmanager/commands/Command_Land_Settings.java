package de.hirnmoritz.main.commandmanager.commands;

import de.hirnmoritz.main.messages.I18nUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import de.hirnmoritz.main.land.Land;
import de.hirnmoritz.main.land.LandID;
import de.hirnmoritz.main.land.LandManager;
import de.hirnmoritz.main.messages.Chat;
import de.hirnmoritz.main.messages.PrefixWriter;
import de.hirnmoritz.main.server.Server;
import de.hirnmoritz.main.uuid.UUIDManager;

public class Command_Land_Settings implements Listener {

	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent event) {
		final Player player = event.getPlayer();
		final String args[] = event.getMessage().split(" ");
		
		if(event.getMessage().startsWith("/land settings")) {
			final LandManager manager = new LandManager(new LandID(player.getLocation().getChunk()));
			
			if(manager.isClaimed()) {
				final Land l = manager.getLand();
				if(l.getOwner().equalsIgnoreCase(UUIDManager.getUUID(player))) {
					
					if(args.length == 2) {
						new PrefixWriter().write(Chat.LINE.getIndex()).send(player);
						new PrefixWriter().write(I18nUtil.getLocalizedMessage("settings-usage")).send(player);
						new PrefixWriter().write(I18nUtil.getLocalizedMessage("settings-list")).send(player);
						new PrefixWriter().write(Chat.PLACEHOLDER.getIndex()).send(player);
						new PrefixWriter().write(I18nUtil.getLocalizedMessage("settings")).send(player);
						new PrefixWriter().write("§f-"+"§6allowBreak ").send(player);
						new PrefixWriter().write("§f-"+"§6allowBuild").send(player);
						new PrefixWriter().write("§f-"+"§6allowPvP").send(player);
						new PrefixWriter().write("§f-"+"§6allowTnT").send(player);
						new PrefixWriter().write("§f-"+"§6allowInteractEntity").send(player);
						new PrefixWriter().write("§f-"+"§6allowUseButton").send(player);
						new PrefixWriter().write("§f-"+"§6allowUseChest").send(player);
						new PrefixWriter().write("§f-"+"§6allowUseTrappedChest").send(player);
						new PrefixWriter().write("§f-"+"§6allowUseTrappedDoor").send(player);
						new PrefixWriter().write("§f-"+"§6allowUseTrappedFurnace").send(player);
						new PrefixWriter().write(Chat.LINE.getIndex()).send(player);
						return;
					}
					
					if(args.length == 3) {
						
						if(args[2].equalsIgnoreCase("allowBreak")) {
							if(l.getSettings().isAllowBreak()) {
								l.getSettings().setAllowBreak(false);
								new PrefixWriter().write(I18nUtil.getLocalizedMessage("allowBreak-disabled")).send(player);
							}else {
								l.getSettings().setAllowBreak(true);
								new PrefixWriter().write(I18nUtil.getLocalizedMessage("allowBreak-enabled")).send(player);
							}
						}
						
						else if(args[2].equalsIgnoreCase("allowBuild")) {
							if(l.getSettings().isAllowBuild()) {
								l.getSettings().setAllowBuild(false);
								new PrefixWriter().write(I18nUtil.getLocalizedMessage("allowBuild-disabled")).send(player);
							}else {
								l.getSettings().setAllowBuild(true);
								new PrefixWriter().write(I18nUtil.getLocalizedMessage("allowBuild-enabled")).send(player);
							}
						}
						
						else if(args[2].equalsIgnoreCase("allowTnT")) {
							if(l.getSettings().isAllowTnT()) {
								l.getSettings().setAllowTnT(false);
								new PrefixWriter().write(I18nUtil.getLocalizedMessage("allowTnT-disabled")).send(player);
							}else {
								l.getSettings().setAllowTnT(true);
								new PrefixWriter().write(I18nUtil.getLocalizedMessage("allowTnT-enabled")).send(player);
							}
						}
						
						else if(args[2].equalsIgnoreCase("allowPvP")) {
							if(l.getSettings().isAllowPvP()) {
								l.getSettings().setAllowPvP(false);
								new PrefixWriter().write(I18nUtil.getLocalizedMessage("allowPvP-disabled")).send(player);
							}else {
								l.getSettings().setAllowPvP(true);
								new PrefixWriter().write(I18nUtil.getLocalizedMessage("allowPvP-enabled")).send(player);
							}
						}
						
						else if(args[2].equalsIgnoreCase("allowInteractEntity")) {
							if(l.getSettings().isAllowInteractEntity()) {
								l.getSettings().setAllowInteractEntity(false);
								new PrefixWriter().write(I18nUtil.getLocalizedMessage("allowInteractEntity-disabled")).send(player);
							}else {
								l.getSettings().setAllowInteractEntity(true);
								new PrefixWriter().write(I18nUtil.getLocalizedMessage("allowInteractEntity-enabled")).send(player);
							}
						}
						
						else if(args[2].equalsIgnoreCase("allowUseButton")) {
							final int version = Server.getVersion();
							if(version >= 1129) {
								if(l.getSettings().isAllowUseButton()) {
									l.getSettings().setAllowUseButton(false);
									new PrefixWriter().write(I18nUtil.getLocalizedMessage("allowUseButton-disabled")).send(player);
								}else {
									l.getSettings().setAllowUseButton(true);
									new PrefixWriter().write(I18nUtil.getLocalizedMessage("allowUseButton-enabled")).send(player);
								}
							}else {
								new PrefixWriter().write("§cServer version to low, ask an admin to use version 1.13 or above!").send(player);
							}
						}
						
						else if(args[2].equalsIgnoreCase("allowUseChest")) {
							if(l.getSettings().isAllowUseChest()) {
								l.getSettings().setAllowUseChest(false);
								new PrefixWriter().write(I18nUtil.getLocalizedMessage("allowUseChest-disabled")).send(player);
							}else {
								l.getSettings().setAllowUseChest(true);
								new PrefixWriter().write(I18nUtil.getLocalizedMessage("allowUseChest-enabled")).send(player);
							}
						}
						
						else if(args[2].equalsIgnoreCase("allowUseTrappedChest")) {
							if(l.getSettings().isAllowUseTrappedChest()) {
								l.getSettings().setAllowUseTrappedChest(false);
								new PrefixWriter().write(I18nUtil.getLocalizedMessage("allowUseTrappedChest-disabled")).send(player);
							}else {
								l.getSettings().setAllowUseTrappedChest(true);
								new PrefixWriter().write(I18nUtil.getLocalizedMessage("allowUseTrappedChest-enabled")).send(player);
							}
						}
						
						else if(args[2].equalsIgnoreCase("allowUseDoor")) {
							final int version = Server.getVersion();
							if(version >= 1129) {
								if(l.getSettings().isAllowUseDoor()) {
									l.getSettings().setAllowUseDoor(false);
									new PrefixWriter().write(I18nUtil.getLocalizedMessage("allowUseDoor-disabled")).send(player);
								}else {
									l.getSettings().setAllowUseDoor(true);
									new PrefixWriter().write(I18nUtil.getLocalizedMessage("allowUseDoor-enabled")).send(player);
								}
							}else {
								new PrefixWriter().write("§cServer version to low, ask an admin to use version 1.13 or above!").send(player);
							}
						}
						
						else if(args[2].equalsIgnoreCase("allowUseFurnace")) {
							if(l.getSettings().isAllowUseFurnace()) {
								l.getSettings().setAllowUseFurnace(false);
								new PrefixWriter().write(I18nUtil.getLocalizedMessage("allowUseFurnace-disabled")).send(player);
							}else {
								l.getSettings().setAllowUseFurnace(true);
								new PrefixWriter().write(I18nUtil.getLocalizedMessage("allowUseFurnace-enabled")).send(player);
							}
						}
						
						else {
							new PrefixWriter().write(I18nUtil.getLocalizedMessage("setting-not-found").replace("{NAME}",args[2])).send(player);
						}
						
						
						l.save();
						
						return;
					}
						
						
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
