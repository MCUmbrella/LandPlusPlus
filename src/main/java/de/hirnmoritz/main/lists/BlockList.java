package de.hirnmoritz.main.lists;

import java.util.ArrayList;

import org.bukkit.Material;

public abstract class BlockList {

	public static ArrayList<Material> material = new ArrayList<>();
	
	public static void init() {
	
		for(Material m : Material.values()) {
			material.add(m);
		}
		
		return;
	}
	
	
}
