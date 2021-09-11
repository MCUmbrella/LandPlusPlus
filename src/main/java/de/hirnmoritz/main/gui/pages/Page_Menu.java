package de.hirnmoritz.main.gui.pages;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;

import de.hirnmoritz.main.gui.Page;
import de.hirnmoritz.main.item.Item;
import de.hirnmoritz.main.messages.Chat;

public class Page_Menu extends Page {

	public Page_Menu(String name, int size) {
		super(name, size);
		
		for(int i=0; i<size; i++) {
			setItem(i, new Item(Material.GRAY_STAINED_GLASS_PANE).setName(Chat.PLACEHOLDER.getIndex()));
		}
		
		setItem(10, new Item(Material.REDSTONE_TORCH).setName("§a§lHelp").setLore("§6to get help").setEnchantment(Enchantment.ARROW_DAMAGE, 100));
		setItem(28, new Item(Material.NAME_TAG).setName("§a§lInformation").setLore("§6to get information about the current land").setEnchantment(Enchantment.ARROW_DAMAGE, 100));
		setItem(16, new Item(Material.LIME_DYE).setName("§a§lAdd").setLore("§6to add a member").setEnchantment(Enchantment.ARROW_DAMAGE, 100));
		setItem(34, new Item(Material.PINK_DYE).setName("§a§lKick").setLore("§6to kick a member").setEnchantment(Enchantment.ARROW_DAMAGE, 100));
		setItem(22, new Item(Material.NETHER_STAR).setName("§a§lLands").setLore("§6to go, on once of your lands"));
		setItem(21, new Item(Material.COBBLESTONE_WALL).setName("§a§lBorder Material").setLore("§6to change borders material"));
		setItem(23, new Item(Material.COMPARATOR).setName("§a§lSettings").setLore("§6to open the settings"));
		setItem(40, new Item(Material.ARROW).setName("§c§lExit").setLore("§6exit"));
		
		return;
	}

	
}
