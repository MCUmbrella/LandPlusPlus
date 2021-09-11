package de.hirnmoritz.main.admininfo;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.hirnmoritz.main.messages.PrefixWriter;
import de.hirnmoritz.main.plugin.PluginSettings;

public class AdminInfo implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		final Player player = event.getPlayer();
		
		if(PluginSettings.show_admin_info) {
			if(player.isOp() || player.hasPermission("land.admin")) {
					
				event.setJoinMessage(null);
				
				player.sendMessage(" ");
				player.sendMessage(" ");
				
				new PrefixWriter().write("§c >> Thanks for using Land++ <<").send(player);
				new PrefixWriter().write("§6www.spigotmc.org/resources/land.82664").send(player);
				new PrefixWriter().write("§fOnly Admins can read this message!").send(player);
			
				player.sendMessage(" ");
				player.sendMessage(" ");
			}
		}
		
		return;
	}
	
	
}
