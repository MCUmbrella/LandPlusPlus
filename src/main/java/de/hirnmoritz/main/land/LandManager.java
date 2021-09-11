package de.hirnmoritz.main.land;

import java.util.ArrayList;

import org.bukkit.entity.Player;

import de.hirnmoritz.main.filemanager.FileManager;
import de.hirnmoritz.main.uuid.UUIDManager;

public class LandManager {
	
	private LandID id = null;
	private Land land = null;
	
	public LandManager(LandID id) {
		this.id = id;
		this.land = new Land(id);
		
		if(isClaimed()) {
			this.land = new Land(id);
			land.load();
		}
		
		return;
	}
	
	public boolean isClaimed() {
		if(Land.lands.getConfig().getConfigurationSection(this.id.getId()) != null) {
			return true;
		}
		
		return false;
	}
	
	public static int getLands(Player player) {
		final int lands = Land.players.getConfig().getInt(UUIDManager.getUUID(player)+".lands");
		return lands;
	}
	
	public static void setLands(Player player, int amount) {
		Land.players.getConfig().set(UUIDManager.getUUID(player)+".lands", amount);
		FileManager.saveConfig(Land.players);
		return;
	}
	
	public static ArrayList<String> getLandNames(Player player) {
		final ArrayList<String> names = (ArrayList<String>) Land.players.getConfig().getStringList(UUIDManager.getUUID(player)+".land");
		return names;
	}
	
	public static void setLandNames(Player player, ArrayList<String> list) {
		Land.players.getConfig().set(UUIDManager.getUUID(player)+".land", list);
		FileManager.saveConfig(Land.players);
		return;
	}
	
	public static LandID getLandID(String name) {
		return new LandID(Land.translator.getConfig().getString(name));
	}
	
	public static boolean nameIsSet(String name) {
		if(Land.translator.getConfig().getString(name) != null) {
			return true;
	}
		
		return false;
	}
	
	public Land getLand() {
		return this.land;
	}
	
	public LandID getID() {
		return id;
	}
	
	
}
