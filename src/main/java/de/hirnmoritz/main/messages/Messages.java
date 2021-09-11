package de.hirnmoritz.main.messages;

import java.io.File;

import de.hirnmoritz.main.Main;
import de.hirnmoritz.main.datapacket.DataPacket;
import de.hirnmoritz.main.filemanager.FileManager;

public abstract class Messages {
	
	protected static DataPacket messages = FileManager.loadConfig(Main.getMain(), new File("messages.yml"), "messages.yml");
	
	public static void init() {
		
		FileManager.saveConfig(messages);
	}
	
	
}
