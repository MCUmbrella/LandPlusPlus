package de.hirnmoritz.main.commandmanager.commands;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import de.hirnmoritz.main.messages.Chat;
import de.hirnmoritz.main.messages.PrefixWriter;


public class Command_Land_Help implements Listener {
	
	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent event) {
		final Player player = event.getPlayer();
		
		if(event.getMessage().equalsIgnoreCase("/land help")) {
		
			new PrefixWriter().write("§8"+Chat.LINE.getIndex()).send(player);
			new PrefixWriter().write("§6/land claim <name> §f>> §ato claim the land around you").send(player);
			new PrefixWriter().write("§6/land delete §f>> §ato leave your current land").send(player);
			new PrefixWriter().write("§6/land home <name> §f>> §ato go on your land").send(player);
			new PrefixWriter().write("§6/land settings §f>> §ato change land settings").send(player);
			new PrefixWriter().write("§6/land info §f>> §ato get information about the land").send(player);
			new PrefixWriter().write("§6/land list §f>> §ato to get a list with all your lands").send(player);
			new PrefixWriter().write("§6/land add <player> §f>> §ato add a member to your land").send(player);
			new PrefixWriter().write("§6/land kick <player> §f>> §ato kick a member").send(player);
			new PrefixWriter().write("§6/land setBorderHeight <height>").send(player);
			new PrefixWriter().write("§6/land setBorderMaterial <material>").send(player);
			new PrefixWriter().write("§6/land visit <name> &f>> §ato visit an other land").send(player);
			new PrefixWriter().write("§6/land middle §f>> §ato go in the middle of the land").send(player);
			new PrefixWriter().write("§6/land setHome §f>> §ato set the lands home point!").send(player);
			player.sendMessage(Chat.PLACEHOLDER.getIndex());
			new PrefixWriter().write("§aYou can short the command §6'land' §aby using §6'l'").send(player);
			new PrefixWriter().write("§fPlugin was developed by §6DasJava").send(player);
			new PrefixWriter().write("§8"+Chat.LINE.getIndex()).send(player);
		
		}
		
		return;
	}
	
	
}
