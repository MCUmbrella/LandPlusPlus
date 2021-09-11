package de.hirnmoritz.main.commandmanager.commands;

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
		
		if(event.getMessage().equalsIgnoreCase("/land") || event.getMessage().equalsIgnoreCase("/l")) {
			
			if(PluginSettings.gui) {
				if(Server.getVersion() > 1130) {
				
					final Page p = new Page_Menu(PluginSettings.prefix+" §3Menu", 5*9);					
					final Gui gui = new Gui(p);
					gui.send(player);
					
					}else {
						new PrefixWriter().write("§cGui is not available in this minecraft version, do:       §6/land help §cto open a list with commnads!").send(player);
					}
					
				}else {
					new PrefixWriter().write("§cGui is not enabled on this server, do §6/land help §cto get a list with commands!").send(player);
				}
				
			}						
		
		return;
	}
	
	
}
