package de.hirnmoritz.main.commandmanager.commands;

import de.hirnmoritz.main.messages.I18nUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import de.hirnmoritz.main.gui.Gui;
import de.hirnmoritz.main.gui.Page;
import de.hirnmoritz.main.gui.pages.Page_Menu;
import de.hirnmoritz.main.messages.PrefixWriter;
import de.hirnmoritz.main.plugin.PluginSettings;
import de.hirnmoritz.main.server.Server;

public class Command_Land implements Listener{
	
	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent event) {
		final Player player = event.getPlayer();
		
		if(event.getMessage().equalsIgnoreCase("/land")) {
			
			if(PluginSettings.gui) {
				if(Server.getVersion() > 1130) {
				
					final Page p = new Page_Menu(PluginSettings.prefix+I18nUtil.getLocalizedMessage("guiTitle-main"), 5*9);
					final Gui gui = new Gui(p);
					gui.send(player);
					
					}else {
						new PrefixWriter().write(I18nUtil.getLocalizedMessage("gui-not-available")).send(player);
					}
					
				}else {
					new PrefixWriter().write(I18nUtil.getLocalizedMessage("gui-not-available")).send(player);
				}
				
			}						
		
		return;
	}
	
	
}
