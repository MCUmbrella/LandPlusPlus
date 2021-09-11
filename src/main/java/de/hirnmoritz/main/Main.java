package de.hirnmoritz.main;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import de.hirnmoritz.main.admininfo.AdminInfo;
import de.hirnmoritz.main.commandmanager.CommandManager;
import de.hirnmoritz.main.commandmanager.completions.Completions;
import de.hirnmoritz.main.commandmanager.CommandComplete;
import de.hirnmoritz.main.gui.function.GuiFunction;
import de.hirnmoritz.main.land.border.BorderMaterial;
import de.hirnmoritz.main.land.function.Function_Break;
import de.hirnmoritz.main.land.function.Function_Build;
import de.hirnmoritz.main.land.function.Function_InteractEntity;
import de.hirnmoritz.main.land.function.Function_InteractUse;
import de.hirnmoritz.main.land.function.Function_PvP;
import de.hirnmoritz.main.land.function.Function_TnT;
import de.hirnmoritz.main.land.function.border.BorderProtection_Break;
import de.hirnmoritz.main.land.function.border.BorderProtection_Build;
import de.hirnmoritz.main.land.function.border.BorderProtection_Piston;
import de.hirnmoritz.main.land.function.border.BorderProtection_TnT;
import de.hirnmoritz.main.lists.BlockList;
import de.hirnmoritz.main.lists.ButtonList;
import de.hirnmoritz.main.lists.DoorList;
import de.hirnmoritz.main.lists.EntityList;
import de.hirnmoritz.main.lists.InventoryList;
import de.hirnmoritz.main.messages.Messages;
import de.hirnmoritz.main.plugin.PluginSettings;
import de.hirnmoritz.main.server.Server;

public class Main extends JavaPlugin {
	
	private static Main main; 
	public static FileConfiguration config;
	
	@Override
	public void onEnable() {
		main = this;
		saveDefaultConfig();
		config = this.getConfig();
		
		PluginSettings.init();
		Messages.init();
		
		BorderMaterial.init();
		
		EntityList.init();
		BlockList.init();
		InventoryList.init();
		DoorList.init();
		ButtonList.init();
		
		Completions.init();
		
		// commands //
		
		this.getCommand("land").setExecutor(new CommandManager());
		this.getCommand("l").setExecutor(new CommandManager());
		
		// functions //
		
		getFunction(new Function_TnT());
		getFunction(new Function_PvP());
		getFunction(new Function_Build());
		getFunction(new Function_Break());
		getFunction(new Function_InteractUse());
		getFunction(new Function_InteractEntity());
		
		this.getFunction(new BorderProtection_Piston());
		this.getFunction(new BorderProtection_Break());
		this.getFunction(new BorderProtection_Build());
		this.getFunction(new BorderProtection_TnT());
		
		this.getFunction(new AdminInfo());
		
		this.getFunction(new GuiFunction());
		if(Server.getVersion() > 1129) {
			this.getFunction(new CommandComplete());
		}
		
		return;
	}
	
	private void getFunction(Listener listener) {
		Bukkit.getPluginManager().registerEvents(listener, this);
	}
	
	public static Main getMain() {
		return main;
	}
	
	
}
