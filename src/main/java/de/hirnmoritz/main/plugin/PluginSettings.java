package de.hirnmoritz.main.plugin;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;

import de.hirnmoritz.main.Main;
import de.hirnmoritz.main.land.border.BorderType;

public abstract class PluginSettings {
	
	public static String prefix = "error, config could not be loaded";
	
	public static boolean show_admin_info = true;
	
	public static ArrayList<String> worlds = null;
	public static int max_claims = 1;
	public static boolean border = false;
	public static Material border_material = null;
	public static BorderType border_type = null;
	
	public static boolean gui = true;
	
	public static void init() {
		prefix = ChatColor.translateAlternateColorCodes('&', Main.config.getString("prefix"));
		
		show_admin_info = Main.config.getBoolean("admin-show-info");
		
		worlds = (ArrayList<String>) Main.config.getStringList("land-allow-in-worlds");
		max_claims = Main.config.getInt("land-max-claims");
		border = Main.config.getBoolean("land-border");
		border_material = Material.getMaterial(Main.config.getString("land-border-material"));
		border_type = BorderType.fromString(Main.config.getString("land-border-type"));
		
		gui = Main.config.getBoolean("gui");
		
		return;
	}
	
	
}
