package de.hirnmoritz.main.lists;

import java.util.ArrayList;

import org.bukkit.Material;

import de.hirnmoritz.main.server.Server;

public abstract class DoorList {

	public static ArrayList<Material> doors = new ArrayList<>();
	
	public static void init() {
		
		int version = Server.getVersion();
		
		if(!(version < 1129)) {
	
			doors.add(Material.DARK_OAK_DOOR);
			doors.add(Material.OAK_DOOR);
			doors.add(Material.IRON_DOOR);
			doors.add(Material.ACACIA_DOOR);
			doors.add(Material.JUNGLE_DOOR);
			doors.add(Material.BIRCH_DOOR);
			doors.add(Material.SPRUCE_DOOR);
		
		}
		
		return;
	}
	
	
}
