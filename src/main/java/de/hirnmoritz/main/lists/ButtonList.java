package de.hirnmoritz.main.lists;

import java.util.ArrayList;

import org.bukkit.Material;

import de.hirnmoritz.main.server.Server;

public abstract class ButtonList {

	public static ArrayList<Material> buttons = new ArrayList<>();
	
	public static void init() {
	
		final int version = Server.getVersion();
		
		if(version >= 1129) {
			buttons.add(Material.STONE_BUTTON);
			buttons.add(Material.OAK_BUTTON);
			buttons.add(Material.DARK_OAK_BUTTON);
			buttons.add(Material.SPRUCE_BUTTON);
			buttons.add(Material.BIRCH_BUTTON);
			buttons.add(Material.JUNGLE_BUTTON);
			buttons.add(Material.ACACIA_BUTTON);
		}
		
		return;
	}
	
	
}
