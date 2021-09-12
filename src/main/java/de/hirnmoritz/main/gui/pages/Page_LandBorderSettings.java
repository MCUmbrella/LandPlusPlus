package de.hirnmoritz.main.gui.pages;

import de.hirnmoritz.main.messages.I18nUtil;
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
		
		setItem(40, new Item(Material.ARROW).setName(I18nUtil.getLocalizedMessage("gui-exit")));
		
		setItem(10, new Item(Material.SANDSTONE).setName(I18nUtil.getLocalizedMessage("guiBorder-sandstone")).setLore(I18nUtil.getLocalizedMessage("guiBorder-sandstone-lore")));
		setItem(11, new Item(Material.STONE).setName(I18nUtil.getLocalizedMessage("guiBorder-stone")).setLore(I18nUtil.getLocalizedMessage("guiBorder-stone-lore")));
		setItem(12, new Item(Material.BARRIER).setName(I18nUtil.getLocalizedMessage("guiBorder-air")).setLore(I18nUtil.getLocalizedMessage("guiBorder-air-lore")));
		setItem(13, new Item(Material.DIRT).setName(I18nUtil.getLocalizedMessage("guiBorder-dirt")).setLore(I18nUtil.getLocalizedMessage("guiBorder-dirt-lore")));
		setItem(14, new Item(Material.DIAMOND_BLOCK).setName(I18nUtil.getLocalizedMessage("guiBorder-diamond")).setLore(I18nUtil.getLocalizedMessage("guiBorder-diamond-lore")));
		setItem(15, new Item(Material.GOLD_BLOCK).setName(I18nUtil.getLocalizedMessage("guiBorder-gold")).setLore(I18nUtil.getLocalizedMessage("guiBorder-gold-lore")));
		setItem(16, new Item(Material.EMERALD_BLOCK).setName(I18nUtil.getLocalizedMessage("guiBorder-emerald")).setLore(I18nUtil.getLocalizedMessage("guiBorder-emerald-lore")));
		setItem(19, new Item(Material.GLASS).setName(I18nUtil.getLocalizedMessage("guiBorder-glass")).setLore(I18nUtil.getLocalizedMessage("guiBorder-glass-lore")));
		setItem(20, new Item(Material.SLIME_BLOCK).setName(I18nUtil.getLocalizedMessage("guiBorder-slime")).setLore(I18nUtil.getLocalizedMessage("guiBorder-slime-lore")));

		
		return;
	}

	
}
