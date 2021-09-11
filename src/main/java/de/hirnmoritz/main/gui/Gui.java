package de.hirnmoritz.main.gui;

import org.bukkit.entity.Player;

public class Gui {

	private Page page; 
	
	public Gui(Page page) {
		this.page = page;
		return;
	}
	
	public void send(Player player) {
		player.openInventory(this.page.getInventory());
		return;
	}
	
	public Page getPage() {
		return page;
	}
	
	public void setPage(Page page) {
		this.page = page;
	}
	
	
}
