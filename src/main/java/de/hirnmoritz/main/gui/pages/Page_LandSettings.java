package de.hirnmoritz.main.gui.pages;

import de.hirnmoritz.main.messages.I18nUtil;
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
		
		setItem(40, new Item(Material.ARROW).setName(I18nUtil.getLocalizedMessage("gui-exit")).setLore(I18nUtil.getLocalizedMessage("gui-exit-lore")));
		setItem(12, new Item(Material.DIAMOND_SWORD).setName(I18nUtil.getLocalizedMessage("guiSettings-pvp")).setLore(I18nUtil.getLocalizedMessage("guiSettings-pvp-lore")).setEnchantment(Enchantment.ARROW_DAMAGE, 1));
		setItem(14, new Item(Material.TNT).setName(I18nUtil.getLocalizedMessage("guiSettings-tnt")).setLore(I18nUtil.getLocalizedMessage("guiSettings-tnt-lore")).setEnchantment(Enchantment.ARROW_DAMAGE, 1));
		setItem(24, new Item(Material.IRON_PICKAXE).setName(I18nUtil.getLocalizedMessage("guiSettings-break")).setLore(I18nUtil.getLocalizedMessage("guiSettings-break-lore")).setEnchantment(Enchantment.ARROW_DAMAGE, 1));
		setItem(20, new Item(Material.BRICK).setName(I18nUtil.getLocalizedMessage("guiSettings-build")).setLore(I18nUtil.getLocalizedMessage("guiSettings-build-lore")).setEnchantment(Enchantment.ARROW_DAMAGE, 1));
		setItem(32, new Item(Material.CREEPER_HEAD).setName(I18nUtil.getLocalizedMessage("guiSettings-interact")).setLore(I18nUtil.getLocalizedMessage("guiSettings-interact-lore")).setEnchantment(Enchantment.ARROW_DAMAGE, 1));
		setItem(30, new Item(Material.CHEST).setName(I18nUtil.getLocalizedMessage("guiSettings-chest")).setLore(I18nUtil.getLocalizedMessage("guiSettings-chest-lore")).setEnchantment(Enchantment.ARROW_DAMAGE, 1));
		setItem(10, new Item(Material.OAK_DOOR).setName(I18nUtil.getLocalizedMessage("guiSettings-door")).setLore(I18nUtil.getLocalizedMessage("guiSettings-door-lore")).setEnchantment(Enchantment.ARROW_DAMAGE, 1));
		setItem(28, new Item(Material.TRAPPED_CHEST).setName(I18nUtil.getLocalizedMessage("guiSettings-trapchest")).setLore(I18nUtil.getLocalizedMessage("guiSettings-trapchest-lore")).setEnchantment(Enchantment.ARROW_DAMAGE, 1));
		setItem(16, new Item(Material.STONE_BUTTON).setName(I18nUtil.getLocalizedMessage("guiSettings-button")).setLore(I18nUtil.getLocalizedMessage("guiSettings-button-lore")).setEnchantment(Enchantment.ARROW_DAMAGE, 1));
		setItem(34, new Item(Material.FURNACE).setName(I18nUtil.getLocalizedMessage("guiSettings-furnace")).setLore(I18nUtil.getLocalizedMessage("guiSettings-furnace-lore")).setEnchantment(Enchantment.ARROW_DAMAGE, 1));
		
		
		return;
	}

	
}
