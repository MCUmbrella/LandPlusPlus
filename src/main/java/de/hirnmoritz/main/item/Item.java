package de.hirnmoritz.main.item;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class Item {

	private ItemStack item = null;
	private ItemMeta meta = null;
	
	public Item(Material material) {
		this.item = new ItemStack(material);		
		this.meta = item.getItemMeta();
		return;
	}
	
	public Item setAmount(int amount) {
		this.item.setAmount(amount);
		return this;
	}
	
	public Item setEnchantment(Enchantment enchantment, int level) {
		this.meta.addEnchant(enchantment, level, true);
		return this;
	}
	
	public Item setLore(String... lore) {
		this.meta.setLore(Arrays.asList(lore));
		return this;
	}
	
	@SuppressWarnings("deprecation")
	public Item setDurability(short durability) {
		item.setDurability(durability);
		return this;
	}
	
	public Item setName(String name) {
		this.meta.setDisplayName(name);
		return this;
	}
	
	public ItemStack save() {
		this.item.setItemMeta(this.meta);
		return item;
	}
	
	
}
