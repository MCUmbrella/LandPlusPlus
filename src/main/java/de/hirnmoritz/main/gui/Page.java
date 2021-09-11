package de.hirnmoritz.main.gui;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

import de.hirnmoritz.main.item.Item;

public class Page {

	private Inventory inventory; 
	private String name = " "; 
	
	public Page(String name, int size) {
		
		this.inventory = Bukkit.createInventory(null, size, name);	
		
		return;
	}
	
	public Page setItem(int slot, Item item) {
		this.inventory.setItem(slot, item.save());
		return this;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Inventory getInventory() {
		return inventory;
	}
	
	
}


