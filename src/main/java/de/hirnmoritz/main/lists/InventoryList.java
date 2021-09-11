package de.hirnmoritz.main.lists;

import java.util.ArrayList;

import org.bukkit.Material;

public abstract class InventoryList {

	public static ArrayList<Material> inventory = new ArrayList<>();
	
	public static void init() {
		
		inventory.add(Material.BEACON);
		inventory.add(Material.CHEST);
		inventory.add(Material.DISPENSER);
		inventory.add(Material.DROPPER);
		inventory.add(Material.FURNACE);
		
		return;
	}
	
	
}
