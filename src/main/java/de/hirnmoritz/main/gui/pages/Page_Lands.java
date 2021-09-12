package de.hirnmoritz.main.gui.pages;

import java.util.ArrayList;

import de.hirnmoritz.main.messages.I18nUtil;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import de.hirnmoritz.main.gui.Page;
import de.hirnmoritz.main.item.Item;
import de.hirnmoritz.main.land.LandManager;
import de.hirnmoritz.main.messages.Chat;

public class Page_Lands extends Page {

	private Player player = null;
	
	public Page_Lands(String name, Player player) {
		super(name, 45);
		this.player = player;
		
		for(int i=0; i<45; i++) {
			setItem(i, new Item(Material.GRAY_STAINED_GLASS_PANE).setName(Chat.PLACEHOLDER.getIndex()));
		}
		
		for(int i=10; i<17; i++) {
			setItem(i, new Item(Material.AIR));
		}
		
		for(int i=28; i<35; i++) {
			setItem(i, new Item(Material.AIR));
		}
		
		setItem(25, new Item(Material.AIR));
		setItem(19, new Item(Material.AIR));
		
		setItem(40, new Item(Material.ARROW).setName(I18nUtil.getLocalizedMessage("gui-exit")).setLore(I18nUtil.getLocalizedMessage("gui-exit-lore")));
		
		final ArrayList<String> lands = LandManager.getLandNames(player);
		final String[] names = lands.toArray(new String[5]);
		
		for(int i=0; i<names.length; i++) {
			if(names[i] == null) {
				names[i] = I18nUtil.getLocalizedMessage("guiLands-slot-empty");
			}
		}
		
		setItem(20, new Item(Material.GRASS_BLOCK).setName(I18nUtil.getLocalizedMessage("guiLands-slot1").replace("{NAME}",names[0])).setLore(I18nUtil.getLocalizedMessage("guiLands-slot1-lore")));
		setItem(21, new Item(Material.GRASS_BLOCK).setName(I18nUtil.getLocalizedMessage("guiLands-slot2").replace("{NAME}",names[1])).setLore(I18nUtil.getLocalizedMessage("guiLands-slot2-lore")));
		setItem(22, new Item(Material.GRASS_BLOCK).setName(I18nUtil.getLocalizedMessage("guiLands-slot3").replace("{NAME}",names[2])).setLore(I18nUtil.getLocalizedMessage("guiLands-slot3-lore")));
		setItem(23, new Item(Material.GRASS_BLOCK).setName(I18nUtil.getLocalizedMessage("guiLands-slot4").replace("{NAME}",names[3])).setLore(I18nUtil.getLocalizedMessage("guiLands-slot4-lore")));
		setItem(24, new Item(Material.GRASS_BLOCK).setName(I18nUtil.getLocalizedMessage("guiLands-slot5").replace("{NAME}",names[4])).setLore(I18nUtil.getLocalizedMessage("guiLands-slot5-lore")));
		
		return;
	}

	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	
}
