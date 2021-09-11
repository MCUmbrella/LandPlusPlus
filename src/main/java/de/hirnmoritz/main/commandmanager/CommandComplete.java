package de.hirnmoritz.main.commandmanager;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.TabCompleteEvent;

import de.hirnmoritz.main.commandmanager.completions.Completions;

public class CommandComplete implements Listener {

	@EventHandler
	public void onEvent(TabCompleteEvent event) {
		final CommandSender sender = event.getSender();
		if(sender instanceof Player) {
				
			final String[] args = event.getBuffer().split(" ");
			
			if(args.length < 2) {
			
				event.setCompletions(Completions.commands);
				
			}
			
			return;
		}
		
		return;
	}
	
	
}
