package de.hirnmoritz.main.gui.pages;

import de.hirnmoritz.main.messages.I18nUtil;
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
		
		setItem(10, new Item(Material.REDSTONE_TORCH).setName(I18nUtil.getLocalizedMessage("gui-help")).setLore(I18nUtil.getLocalizedMessage("gui-help-lore")).setEnchantment(Enchantment.ARROW_DAMAGE, 1));
		setItem(28, new Item(Material.NAME_TAG).setName(I18nUtil.getLocalizedMessage("gui-info")).setLore(I18nUtil.getLocalizedMessage("gui-info-lore")).setEnchantment(Enchantment.ARROW_DAMAGE, 1));
		setItem(16, new Item(Material.LIME_DYE).setName(I18nUtil.getLocalizedMessage("gui-addmember")).setLore(I18nUtil.getLocalizedMessage("gui-addmember-lore")).setEnchantment(Enchantment.ARROW_DAMAGE, 1));
		setItem(34, new Item(Material.PINK_DYE).setName(I18nUtil.getLocalizedMessage("gui-kickmember")).setLore(I18nUtil.getLocalizedMessage("gui-kickmember-lore")).setEnchantment(Enchantment.ARROW_DAMAGE, 1));
		setItem(22, new Item(Material.NETHER_STAR).setName(I18nUtil.getLocalizedMessage("gui-lands")).setLore(I18nUtil.getLocalizedMessage("gui-lands-lore")));
		setItem(21, new Item(Material.COBBLESTONE_WALL).setName(I18nUtil.getLocalizedMessage("gui-border")).setLore(I18nUtil.getLocalizedMessage("gui-border-lore")));
		setItem(23, new Item(Material.COMPARATOR).setName(I18nUtil.getLocalizedMessage("gui-settings")).setLore(I18nUtil.getLocalizedMessage("gui-settings-lore")));
		setItem(40, new Item(Material.ARROW).setName(I18nUtil.getLocalizedMessage("gui-exit")).setLore(I18nUtil.getLocalizedMessage("gui-exit-lore")));
		
		return;
	}

	
}
