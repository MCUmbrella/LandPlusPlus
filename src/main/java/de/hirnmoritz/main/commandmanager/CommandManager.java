package de.hirnmoritz.main.commandmanager;

import de.hirnmoritz.main.messages.I18nUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import de.hirnmoritz.main.commandmanager.commands.Command_Land;
import de.hirnmoritz.main.commandmanager.commands.Command_Land_Add;
import de.hirnmoritz.main.commandmanager.commands.Command_Land_Claim;
import de.hirnmoritz.main.commandmanager.commands.Command_Land_Delete;
import de.hirnmoritz.main.commandmanager.commands.Command_Land_Help;
import de.hirnmoritz.main.commandmanager.commands.Command_Land_Home;
import de.hirnmoritz.main.commandmanager.commands.Command_Land_Info;
import de.hirnmoritz.main.commandmanager.commands.Command_Land_Kick;
import de.hirnmoritz.main.commandmanager.commands.Command_Land_List;
import de.hirnmoritz.main.commandmanager.commands.Command_Land_Middle;
import de.hirnmoritz.main.commandmanager.commands.Command_Land_Reload;
import de.hirnmoritz.main.commandmanager.commands.Command_Land_SetBorderHeight;
import de.hirnmoritz.main.commandmanager.commands.Command_Land_SetBorderMaterial;
import de.hirnmoritz.main.commandmanager.commands.Command_Land_SetHome;
import de.hirnmoritz.main.commandmanager.commands.Command_Land_Settings;
import de.hirnmoritz.main.commandmanager.commands.Command_Land_Visit;
import de.hirnmoritz.main.messages.PrefixWriter;
import de.hirnmoritz.main.plugin.PluginSettings;

public class CommandManager implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String string, String[] args) {
		if(sender instanceof Player) {
			final Player player = (Player)sender;
			
			if(command.getName().equalsIgnoreCase("land")) {
				
				if(args.length == 1) {
					if(args[0].equalsIgnoreCase("reload")) {
						new Command_Land_Reload().onCommand(new PlayerCommandPreprocessEvent(player, "/land reload"));
						return true;	
					}
				}
				
				
				if(PluginSettings.worlds.contains(player.getWorld().getName())) {
				
					if(args.length == 0) {
						new Command_Land().onCommand(new PlayerCommandPreprocessEvent(player, "/land"));
					
					} else if(args.length == 1) {
						
						if(args[0].equalsIgnoreCase("claim")) {
							new Command_Land_Claim().onCommand(new PlayerCommandPreprocessEvent(player, "/land claim"));
							return true;
						}
						
						else if(args[0].equalsIgnoreCase("delete")) {
							new Command_Land_Delete().onCommand(new PlayerCommandPreprocessEvent(player, "/land delete"));
							return true;
						}
						
						else if(args[0].equalsIgnoreCase("home")) {
							new Command_Land_Home().onCommand(new PlayerCommandPreprocessEvent(player, "/land home"));
							return true;
						}
						
						else if(args[0].equalsIgnoreCase("add")) {
							new Command_Land_Add().onCommand(new PlayerCommandPreprocessEvent(player, "/land add"));
							return true;
						}
						
						else if(args[0].equalsIgnoreCase("kick")) {
							new Command_Land_Kick().onCommand(new PlayerCommandPreprocessEvent(player, "/land kick"));
							return true;
						}
						
						else if(args[0].equalsIgnoreCase("info")) {
							new Command_Land_Info().onCommand(new PlayerCommandPreprocessEvent(player, "/land info"));
							return true;
						}
	
						else if(args[0].equalsIgnoreCase("help")) {
							new Command_Land_Help().onCommand(new PlayerCommandPreprocessEvent(player, "/land help"));
							return true;
						}
						
						
						else if(args[0].equalsIgnoreCase("list")) {
							new Command_Land_List().onCommand(new PlayerCommandPreprocessEvent(player, "/land list"));
							return true;
							
						}
						
						else if(args[0].equalsIgnoreCase("settings")) {
							new Command_Land_Settings().onCommand(new PlayerCommandPreprocessEvent(player, "/land settings"));
							return true;
							
						}
						
						else if(args[0].equalsIgnoreCase("setborderheight")) {
							new Command_Land_SetBorderHeight().onCommand(new PlayerCommandPreprocessEvent(player, "/land setBorderHeight"));
							return true;	
						}
						
						else if(args[0].equalsIgnoreCase("setBorderMaterial")) {
							new Command_Land_SetBorderMaterial().onCommand(new PlayerCommandPreprocessEvent(player, "/land setBorderMaterial"));
							return true;	
						}
						
						else if(args[0].equalsIgnoreCase("middle")) {
							new Command_Land_Middle().onCommand(new PlayerCommandPreprocessEvent(player, "/land middle"));
							return true;	
						}
						
						else if(args[0].equalsIgnoreCase("visit")) {
							new Command_Land_Visit().onCommand(new PlayerCommandPreprocessEvent(player, "/land visit"));
							return true;	
						}
							
						else if(args[0].equalsIgnoreCase("sethome")) {
							new Command_Land_SetHome().onCommand(new PlayerCommandPreprocessEvent(player, "/land sethome"));
							return true;	
						}
							
						else {
							new PrefixWriter().write(I18nUtil.getLocalizedMessage("cmd-not-found")).send(player);
							return false;
						}
				
						
					}else if(args.length == 2) {
						
						if(args[0].equalsIgnoreCase("kick")) {
							new Command_Land_Kick().onCommand(new PlayerCommandPreprocessEvent(player, "/land kick "+args[1]));
							return true;
						}
						
						else if(args[0].equalsIgnoreCase("add")) {
							new Command_Land_Add().onCommand(new PlayerCommandPreprocessEvent(player, "/land add "+args[1]));
							return true;
						}
						
						if(args[0].equalsIgnoreCase("claim")) {
							new Command_Land_Claim().onCommand(new PlayerCommandPreprocessEvent(player, "/land claim "+args[1]));
							return true;
							
						}
						
						else if(args[0].equalsIgnoreCase("home")) {
							new Command_Land_Home().onCommand(new PlayerCommandPreprocessEvent(player, "/land home "+args[1]));
							return true;
						}
						
						else if(args[0].equalsIgnoreCase("settings")) {
							new Command_Land_Settings().onCommand(new PlayerCommandPreprocessEvent(player, "/land settings "+args[1]));
							return true;
						}
						
						else if(args[0].equalsIgnoreCase("setborderheight")) {
							new Command_Land_SetBorderHeight().onCommand(new PlayerCommandPreprocessEvent(player, "/land setBorderHeight "+args[1]));
							return true;
						}
						
						else if(args[0].equalsIgnoreCase("setBorderMaterial")) {
							new Command_Land_SetBorderMaterial().onCommand(new PlayerCommandPreprocessEvent(player, "/land setBorderMaterial "+args[1]));
							return true;
							
						}
						
						else if(args[0].equalsIgnoreCase("visit")) {
							new Command_Land_Visit().onCommand(new PlayerCommandPreprocessEvent(player, "/land visit "+args[1]));
							return true;	
						}	
						
						else {
							new PrefixWriter().write(I18nUtil.getLocalizedMessage("cmd-not-found")).send(player);
							return false;
						}
						
						}else {
							new PrefixWriter().write(I18nUtil.getLocalizedMessage("cmd-not-found")).send(player);
							return false;
						}
				
					}else {
						new PrefixWriter().write(I18nUtil.getLocalizedMessage("land-disabled")).send(player);
						return false;
					}
				
				}
					
			}else {
				System.out.println(I18nUtil.getLocalizedMessage("player-only"));
			}
		
		return false;
	}

}
