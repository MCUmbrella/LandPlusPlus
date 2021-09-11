package de.hirnmoritz.main.commandmanager.commands;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import de.hirnmoritz.main.land.LandManager;
import de.hirnmoritz.main.messages.Chat;
import de.hirnmoritz.main.messages.PrefixWriter;

public class Command_Land_List implements Listener {
	
	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent event) {
		final Player player = event.getPlayer();
		
		if(event.getMessage().equalsIgnoreCase("/land list")) {
			final ArrayList<String> contents = LandManager.getLandNames(player);
			final String[] lands = contents.toArray(new String[contents.size()]);
			
			new PrefixWriter().write("§8"+Chat.LINE.getIndex()).send(player);
			new PrefixWriter().write("§3Your lands:").send(player);
			for(int i=0; i<lands.length; i++) {
				new PrefixWriter().write(" §f- §6"+lands[i]).send(player);
			}
			new PrefixWriter().write("§8"+Chat.LINE.getIndex()).send(player);
			
		}
		
		return;
	}
	
	
}
