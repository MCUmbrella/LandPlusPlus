package de.hirnmoritz.main.gui.function;

import java.util.ArrayList;

import de.hirnmoritz.main.messages.I18nUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import de.hirnmoritz.main.commandmanager.commands.Command_Land_Help;
import de.hirnmoritz.main.commandmanager.commands.Command_Land_Home;
import de.hirnmoritz.main.commandmanager.commands.Command_Land_Info;
import de.hirnmoritz.main.commandmanager.commands.Command_Land_SetBorderMaterial;
import de.hirnmoritz.main.commandmanager.commands.Command_Land_Settings;
import de.hirnmoritz.main.gui.Gui;
import de.hirnmoritz.main.gui.pages.Page_LandBorderSettings;
import de.hirnmoritz.main.gui.pages.Page_Lands;
import de.hirnmoritz.main.gui.pages.Page_LandSettings;
import de.hirnmoritz.main.land.LandManager;
import de.hirnmoritz.main.messages.PrefixWriter;
import de.hirnmoritz.main.plugin.PluginSettings;

public class GuiFunction implements Listener {

	@EventHandler
	public void onEvenet(InventoryClickEvent event) {
		if(event.getWhoClicked() instanceof Player) {
			Player player = (Player)event.getWhoClicked();

			if(event.getView().getTitle().startsWith(PluginSettings.prefix)) {

				event.setCancelled(true);
				if(event.getSlot() == 40) {
					player.closeInventory();
				}

				if(event.getView().getTitle().equals(PluginSettings.prefix+I18nUtil.getLocalizedMessage("guiTitle-main"))) {
					switch (event.getSlot()) {
					case 22: final Page_Lands lands = new Page_Lands(PluginSettings.prefix+I18nUtil.getLocalizedMessage("guiTitle-lands"), player); final Gui gui = new Gui(lands); gui.send(player); break;
					case 21: final Gui g = new Gui(new Page_LandBorderSettings(PluginSettings.prefix+I18nUtil.getLocalizedMessage("guiTitle-border"), 45)); g.send(player);  break;
					case 23: final Gui g2 = new Gui(new Page_LandSettings(PluginSettings.prefix+I18nUtil.getLocalizedMessage("guiTitle-settings")));  g2.send(player); break;
					case 10: new Command_Land_Help().onCommand(new PlayerCommandPreprocessEvent(player, "/land help")); player.closeInventory(); break;
					case 28: new Command_Land_Info().onCommand(new PlayerCommandPreprocessEvent(player, "/land info")); player.closeInventory(); break;
					case 16: new PrefixWriter().write(I18nUtil.getLocalizedMessage("help-add")).send(player); player.closeInventory(); break;
					case 34: new PrefixWriter().write(I18nUtil.getLocalizedMessage("help-kick")).send(player); player.closeInventory(); break;

					default: break;

					}
				}

				if(event.getView().getTitle().equals(PluginSettings.prefix+I18nUtil.getLocalizedMessage("guiTitle-lands"))) {
					final ArrayList<String> lands = LandManager.getLandNames(player);
					final String[] names = lands.toArray(new String[5]);

					switch (event.getSlot()) {
					case 20: teleport(names[0], player); break;
					case 21: teleport(names[1], player); break;
					case 22: teleport(names[2], player); break;
					case 23: teleport(names[3], player); break;
					case 24: teleport(names[4], player); break;

					default: break;
					}
				}

				if(event.getView().getTitle().equals(PluginSettings.prefix+I18nUtil.getLocalizedMessage("guiTitle-settings"))) {
					switch (event.getSlot()) {
					case 12: new Command_Land_Settings().onCommand(new PlayerCommandPreprocessEvent(player, "/land settings allowPvP")); player.closeInventory(); break;
					case 14: new Command_Land_Settings().onCommand(new PlayerCommandPreprocessEvent(player, "/land settings allowTnT")); player.closeInventory(); break;
					case 24: new Command_Land_Settings().onCommand(new PlayerCommandPreprocessEvent(player, "/land settings allowBreak")); player.closeInventory(); break;
					case 20: new Command_Land_Settings().onCommand(new PlayerCommandPreprocessEvent(player, "/land settings allowBuild")); player.closeInventory(); break;
					case 32: new Command_Land_Settings().onCommand(new PlayerCommandPreprocessEvent(player, "/land settings allowInteractEntity")); player.closeInventory(); break;
					case 30: new Command_Land_Settings().onCommand(new PlayerCommandPreprocessEvent(player, "/land settings allowUseChest")); player.closeInventory(); break;
					case 10: new Command_Land_Settings().onCommand(new PlayerCommandPreprocessEvent(player, "/land settings allowUseDoor")); player.closeInventory(); break;
					case 28: new Command_Land_Settings().onCommand(new PlayerCommandPreprocessEvent(player, "/land settings allowUseTrappedChest")); player.closeInventory(); break;
					case 16: new Command_Land_Settings().onCommand(new PlayerCommandPreprocessEvent(player, "/land settings allowUseButton")); player.closeInventory(); break;
					case 34: new Command_Land_Settings().onCommand(new PlayerCommandPreprocessEvent(player, "/land settings allowUseFurnace")); player.closeInventory(); break;

					default: break;
					}
				}

				if(event.getView().getTitle().equals(PluginSettings.prefix+I18nUtil.getLocalizedMessage("guiTitle-border"))) {
					switch (event.getSlot()) {
					case 10: new Command_Land_SetBorderMaterial().onCommand(new PlayerCommandPreprocessEvent(player, "/land setBorderMaterial SANDSTONE")); player.closeInventory(); break;
					case 11: new Command_Land_SetBorderMaterial().onCommand(new PlayerCommandPreprocessEvent(player, "/land setBorderMaterial STONE")); player.closeInventory(); break;
					case 12: new Command_Land_SetBorderMaterial().onCommand(new PlayerCommandPreprocessEvent(player, "/land setBorderMaterial AIR")); player.closeInventory(); break;
					case 13: new Command_Land_SetBorderMaterial().onCommand(new PlayerCommandPreprocessEvent(player, "/land setBorderMaterial DIRT")); player.closeInventory(); break;
					case 14: new Command_Land_SetBorderMaterial().onCommand(new PlayerCommandPreprocessEvent(player, "/land setBorderMaterial DIAMOND_BLOCK")); player.closeInventory(); break;
					case 15: new Command_Land_SetBorderMaterial().onCommand(new PlayerCommandPreprocessEvent(player, "/land setBorderMaterial GOLD_BLOCK")); player.closeInventory(); break;
					case 16: new Command_Land_SetBorderMaterial().onCommand(new PlayerCommandPreprocessEvent(player, "/land setBorderMaterial EMERALD_BLOCK")); player.closeInventory(); break;
					case 19: new Command_Land_SetBorderMaterial().onCommand(new PlayerCommandPreprocessEvent(player, "/land setBorderMaterial GLASS")); player.closeInventory(); break;
					case 20: new Command_Land_SetBorderMaterial().onCommand(new PlayerCommandPreprocessEvent(player, "/land setBorderMaterial SLIME_BLOCK")); player.closeInventory(); break;

					default: break;
					}
				}

				return;
			}

		}

		return;
	}

	private void teleport(String name, Player player) {
		if(name != null) {
			new Command_Land_Home().onCommand(new PlayerCommandPreprocessEvent(player, "/land home "+name));;
		}

		return;
	}

}
