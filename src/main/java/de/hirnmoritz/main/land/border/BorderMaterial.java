package de.hirnmoritz.main.land.border;

import java.util.ArrayList;

import org.bukkit.Material;

public abstract class BorderMaterial {

	public static ArrayList<Material> types = new ArrayList<>();
	
	public static void init() {
		
		types.add(Material.SANDSTONE);
		types.add(Material.AIR);
		types.add(Material.STONE);
		types.add(Material.BEACON);
		types.add(Material.DIRT);
		types.add(Material.GLOWSTONE);
		types.add(Material.DIAMOND_BLOCK);
		types.add(Material.GOLD_BLOCK);
		types.add(Material.EMERALD_BLOCK);
		types.add(Material.GLASS);
		types.add(Material.SLIME_BLOCK);
		
		return;
	}
	
	
}
