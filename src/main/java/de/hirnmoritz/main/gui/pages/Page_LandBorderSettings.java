package de.hirnmoritz.main.gui.pages;

import org.bukkit.Material;

import de.hirnmoritz.main.gui.Page;
import de.hirnmoritz.main.item.Item;
import de.hirnmoritz.main.messages.Chat;

public class Page_LandBorderSettings extends Page {

	public Page_LandBorderSettings(String name, int size) {
		super(name, size);
		
		for(int i=0; i<45; i++) {
			setItem(i, new Item(Material.GRAY_STAINED_GLASS_PANE).setName(Chat.PLACEHOLDER.getIndex()));
		}
		
		for(int i=10; i<17; i++) {
			setItem(i, new Item(Material.AIR));
		}
		
		for(int i=19; i<26; i++) {
			setItem(i, new Item(Material.AIR));
		}
		
		for(int i=28; i<35; i++) {
			setItem(i, new Item(Material.AIR));
		}
		
		setItem(40, new Item(Material.ARROW).setName("§6Exit"));
		
		setItem(10, new Item(Material.SANDSTONE).setName("§6Sandstone").setLore("§aChange to: §6Sandstone"));
		setItem(11, new Item(Material.STONE).setName("§6Sandstone").setLore("§aChange to: §6STONE"));
		setItem(12, new Item(Material.BARRIER).setName("§6Air").setLore("§aChange to: §6Air"));
		setItem(13, new Item(Material.DIRT).setName("§6Dirt").setLore("§aChange to: §6Dirt"));
		setItem(14, new Item(Material.DIAMOND_BLOCK).setName("§6Diamond").setLore("§aChange to: §6Diamond"));
		setItem(15, new Item(Material.GOLD_BLOCK).setName("§6Gold").setLore("§aChange to: §6Gold"));
		setItem(16, new Item(Material.EMERALD_BLOCK).setName("§6Emerald").setLore("§aChange to: §6Emerald"));
		setItem(19, new Item(Material.GLASS).setName("§6GLASS").setLore("§aChange to: §6Glass"));
		setItem(20, new Item(Material.SLIME_BLOCK).setName("§6Slime").setLore("§aChange to: §6Slime"));

		
		return;
	}

	
}
