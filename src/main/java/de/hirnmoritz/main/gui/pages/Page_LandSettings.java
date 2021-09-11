package de.hirnmoritz.main.gui.pages;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;

import de.hirnmoritz.main.gui.Page;
import de.hirnmoritz.main.item.Item;
import de.hirnmoritz.main.messages.Chat;

public class Page_LandSettings extends Page{
	
	public Page_LandSettings(String name) {
		super(name, 45);
		
		for(int i=0; i<45; i++) {
			setItem(i, new Item(Material.GRAY_STAINED_GLASS_PANE).setName(Chat.PLACEHOLDER.getIndex()));
		}
		
		setItem(40, new Item(Material.ARROW).setName("§c§lExit").setLore("§6Exit"));
		setItem(12, new Item(Material.DIAMOND_SWORD).setName("§a§lPVP").setLore("§6Allow/Forbid PVP").setEnchantment(Enchantment.ARROW_DAMAGE, 50));
		setItem(14, new Item(Material.TNT).setName("§a§lTnT").setLore("§6Allow/Forbid TnT").setEnchantment(Enchantment.ARROW_DAMAGE, 50));
		setItem(24, new Item(Material.IRON_PICKAXE).setName("§a§lBreak").setLore("§6Allow/Forbid players to break blocks on your land").setEnchantment(Enchantment.ARROW_DAMAGE, 50));
		setItem(20, new Item(Material.BRICK).setName("§a§lBuild").setLore("§6Allow/Forbid players to build on your land").setEnchantment(Enchantment.ARROW_DAMAGE, 50));
		setItem(32, new Item(Material.CREEPER_HEAD).setName("§a§lInteract with Mobs").setLore("§6Allow/Forbid players to interact with mobs").setEnchantment(Enchantment.ARROW_DAMAGE, 50));
		setItem(30, new Item(Material.CHEST).setName("§a§lUse Chests").setLore("§6Allow/Forbid players to use chests").setEnchantment(Enchantment.ARROW_DAMAGE, 50));
		setItem(10, new Item(Material.OAK_DOOR).setName("§a§lUse Doors").setLore("§6Allow/Forbid players to use doors").setEnchantment(Enchantment.ARROW_DAMAGE, 50));
		setItem(28, new Item(Material.TRAPPED_CHEST).setName("§a§lUse TrappedChests").setLore("§6Allow/Forbid players to use redstone chests").setEnchantment(Enchantment.ARROW_DAMAGE, 50));
		setItem(16, new Item(Material.STONE_BUTTON).setName("§a§lUse Buttons").setLore("§6Allow/Forbid players to use buttons").setEnchantment(Enchantment.ARROW_DAMAGE, 50));
		setItem(34, new Item(Material.FURNACE).setName("§a§lUse Furnace").setLore("§6Allow/Forbid players to use furnaces").setEnchantment(Enchantment.ARROW_DAMAGE, 50));
		
		
		return;
	}

	
}
