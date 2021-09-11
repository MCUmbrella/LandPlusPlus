package de.hirnmoritz.main.messages;

import org.bukkit.entity.Player;

import de.hirnmoritz.main.plugin.PluginSettings;

public class PrefixWriter {

	private String text = null;
	
	public PrefixWriter() {  }
	
	public PrefixWriter write(String text) {
		this.text = PluginSettings.prefix+" "+text;
		return this;
	}
	
	public void send(Player player) {
		player.sendMessage(text);
		return;
	}
	
	public String getText() {
		return text;
	}
	
	
}
