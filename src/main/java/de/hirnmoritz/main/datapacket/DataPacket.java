package de.hirnmoritz.main.datapacket;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;

public class DataPacket {

	private FileConfiguration config;
	private File file;
	private String path; 
	
	public DataPacket(File file, FileConfiguration config, String path) {
		this.file = file;
		this.config = config;
		this.path = path;
		
		return;
	}
	
	public FileConfiguration getConfig() {
		return config;
	}
	
	public File getFile() {
		return file;
	}
	
	public String getPath() {
		return path;
	}
	
	
}
