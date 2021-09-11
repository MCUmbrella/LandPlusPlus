package de.hirnmoritz.main.server;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public abstract class Server {
	
	public static int getVersion() {
		
		final String bukkitVersion = Bukkit.getServer().getVersion();
		
		final String[] rawVersion = bukkitVersion.split(" ");
		rawVersion[2] = rawVersion[rawVersion.length-1].replace(")", "");
		rawVersion[2] = rawVersion[rawVersion.length-1].replace(".", "x");
		
		final String[] index = rawVersion[rawVersion.length-1].split("x");
		
		String v = "";
		for(int i=0; i<index.length; i++) {
			v = v+index[i];
		}
	
		if(v.length() == 2) {
			v = v+"0";
		}
		
		final int version= Integer.parseInt(v);
			
		return version;
	}
	
	public static ArrayList<Player> getOperators(){
	
		final ArrayList<Player> operators = new ArrayList<>();
		
		for(Player p : Bukkit.getOnlinePlayers()) {
			if(p.isOp()) {
				operators.add(p);
			}
		}
		
		return operators;
	}
	
	public static ArrayList<OfflinePlayer> getOfflinePlayers(){
		
		final ArrayList<OfflinePlayer> offlineplayers = new ArrayList<>();
				
		for(OfflinePlayer p : Bukkit.getOfflinePlayers()) {
			offlineplayers.add(p);
		}
		
		return offlineplayers;
	}
	
	public static ArrayList<Player> getOnlinePlayers(){
		
		final ArrayList<Player> players = new ArrayList<>();
				
		for(Player p : Bukkit.getOnlinePlayers()) {
			players.add(p);
		}
		
		return players;
	}
	
	
}
