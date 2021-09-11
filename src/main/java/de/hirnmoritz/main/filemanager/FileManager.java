package de.hirnmoritz.main.filemanager;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import de.hirnmoritz.main.datapacket.DataPacket;

public abstract class FileManager {
	
	public static DataPacket loadConfig(Plugin plugin, File data, String path) {
		DataPacket packet = null;
		
		data = new File(plugin.getDataFolder().getPath(), path);
		if (!data.exists()) {
		 try {
			 data.createNewFile();
		 } catch (IOException e) {
			 e.printStackTrace();
		 	}		 
		}
		 
		packet = new DataPacket(data, (FileConfiguration)YamlConfiguration.loadConfiguration(data), path);

		return packet;
	}
	
	public static boolean saveConfig(FileConfiguration config, File data) {
		
		try {
			config.save(data);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	public static boolean saveConfig(DataPacket packet) {
		
		try {
			packet.getConfig().save(packet.getFile());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
}
