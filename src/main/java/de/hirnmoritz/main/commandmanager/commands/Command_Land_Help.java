package de.hirnmoritz.main.commandmanager.commands;

import de.hirnmoritz.main.messages.I18nUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import de.hirnmoritz.main.messages.Chat;
import de.hirnmoritz.main.messages.PrefixWriter;


public class Command_Land_Help implements Listener {
	
	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent event) {
		final Player player = event.getPlayer();
		
		if(event.getMessage().equalsIgnoreCase("/land help")) {
		
			new PrefixWriter().write("§8"+Chat.LINE.getIndex()).send(player);
			new PrefixWriter().write(I18nUtil.getLocalizedMessage("help-claim")).send(player);
			new PrefixWriter().write(I18nUtil.getLocalizedMessage("help-delete")).send(player);
			new PrefixWriter().write(I18nUtil.getLocalizedMessage("help-home")).send(player);
			new PrefixWriter().write(I18nUtil.getLocalizedMessage("help-settings")).send(player);
			new PrefixWriter().write(I18nUtil.getLocalizedMessage("help-info")).send(player);
			new PrefixWriter().write(I18nUtil.getLocalizedMessage("help-list")).send(player);
			new PrefixWriter().write(I18nUtil.getLocalizedMessage("help-add")).send(player);
			new PrefixWriter().write(I18nUtil.getLocalizedMessage("help-kick")).send(player);
			new PrefixWriter().write(I18nUtil.getLocalizedMessage("help-setBorderHeight")).send(player);
			new PrefixWriter().write(I18nUtil.getLocalizedMessage("help-setBorderMaterial")).send(player);
			new PrefixWriter().write(I18nUtil.getLocalizedMessage("help-visit")).send(player);
			new PrefixWriter().write(I18nUtil.getLocalizedMessage("help-middle")).send(player);
			new PrefixWriter().write(I18nUtil.getLocalizedMessage("help-setHome")).send(player);
			player.sendMessage(Chat.PLACEHOLDER.getIndex());
			new PrefixWriter().write(I18nUtil.getLocalizedMessage("plugin-developer")).send(player);
			new PrefixWriter().write("§8"+Chat.LINE.getIndex()).send(player);
		
		}
		
		return;
	}
	
	
}
