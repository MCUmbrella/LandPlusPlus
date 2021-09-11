package de.hirnmoritz.main.uuid;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public abstract class UUIDManager {
	
	public static String getUUID(Player player) {
		return String.valueOf(player.getUniqueId());
	}
	
	public static Player getPlayer(UUID uuid) {
		return Bukkit.getPlayer(uuid);
	}

	
}
