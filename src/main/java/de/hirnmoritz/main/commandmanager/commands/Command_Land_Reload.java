package de.hirnmoritz.main.commandmanager.commands;

import de.hirnmoritz.main.messages.I18nUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import de.hirnmoritz.main.messages.Messages;
import de.hirnmoritz.main.messages.PrefixWriter;
import de.hirnmoritz.main.plugin.PluginSettings;

public class Command_Land_Reload implements Listener {

	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent event) {
		final Player player = event.getPlayer();
		
		if(event.getMessage().equalsIgnoreCase("/land reload")) {
			if(player.hasPermission("land.admin") || player.isOp()) {
				
				PluginSettings.init();
				Messages.init();
				
				new PrefixWriter().write(I18nUtil.getLocalizedMessage("plugin-reloaded")).send(player);
			
			}else {
				new PrefixWriter().write(I18nUtil.getLocalizedMessage("no-permission")).send(player);
			}
			
		}
		
		return;
	}
	
	
}
