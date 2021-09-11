package de.hirnmoritz.main.commandmanager.completions;

import java.util.ArrayList;
import java.util.List;

public abstract class Completions {
	
	public static final List<String> commands = new ArrayList<String>();
	
	public static void init() {
		
		commands.add("claim");
		commands.add("delete");
		commands.add("list");
		commands.add("add");
		commands.add("kick");
		commands.add("help");
		commands.add("info");
		commands.add("home");
		commands.add("reload");
		commands.add("settings");
		commands.add("setBorderHeight");
		commands.add("setBorderMaterial");
		commands.add("middle");
		commands.add("visit");
		commands.add("setHome");
		
		return;
	}
	
	
}
