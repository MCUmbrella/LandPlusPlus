package de.hirnmoritz.main.gui.pages;

import java.util.ArrayList;

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
		
		setItem(40, new Item(Material.ARROW).setName("§c§lExit").setLore("§6exit"));
		
		final ArrayList<String> lands = LandManager.getLandNames(player);
		final String[] names = lands.toArray(new String[5]);
		
		for(int i=0; i<names.length; i++) {
			if(names[i] == null) {
				names[i] = "§aDo §6/land claim <name>!";
			}
		}
		
		setItem(20, new Item(Material.GRASS_BLOCK).setName("§a"+names[0]).setLore("§aClick to teleport!"));
		setItem(21, new Item(Material.GRASS_BLOCK).setName("§a"+names[1]).setLore("§aClick to teleport!"));
		setItem(22, new Item(Material.GRASS_BLOCK).setName("§a"+names[2]).setLore("§aClick to teleport!"));
		setItem(23, new Item(Material.GRASS_BLOCK).setName("§a"+names[3]).setLore("§aClick to teleport!"));
		setItem(24, new Item(Material.GRASS_BLOCK).setName("§a"+names[4]).setLore("§aClick to teleport!"));
		
		return;
	}

	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	
}
