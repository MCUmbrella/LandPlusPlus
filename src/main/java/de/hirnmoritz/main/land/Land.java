
package de.hirnmoritz.main.land;

import java.io.File;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

import de.hirnmoritz.main.Main;
import de.hirnmoritz.main.chunk.ChunkLocation;
import de.hirnmoritz.main.datapacket.DataPacket;
import de.hirnmoritz.main.filemanager.FileManager;
import de.hirnmoritz.main.land.border.BorderType;
import de.hirnmoritz.main.land.border.LandBorder;
import de.hirnmoritz.main.uuid.UUIDManager;

public class Land {
	
	// class //
	
	protected static DataPacket lands = FileManager.loadConfig(Main.getMain(), new File("lands.yml"), "lands.yml");
	protected static DataPacket translator = FileManager.loadConfig(Main.getMain(), new File("translator.yml"), "translator.yml");
	protected static DataPacket players = FileManager.loadConfig(Main.getMain(), new File("players.yml"), "players.yml");
	
	// object //
	
	private String name = null;
	
	private String owner = null;
	private ArrayList<String> members = new ArrayList<>();
	
	private LandID id = null;
	
	private Location middle = null;
	
	private int borderHeight = 10;
	private Material borderMaterial = Material.AIR;
	private BorderType borderType = BorderType.NULL;
	
	private LandSettings settings = new LandSettings();

	public Land(LandID id) {
		this.id = id;
		return;
	}
	
	public boolean claim(String name, Player owner, Chunk chunk, int height) {
		if(lands.getConfig().getConfigurationSection(this.id.getId()) == null) {
			this.name = name;
			this.owner = UUIDManager.getUUID(owner);
			this.middle = ChunkLocation.getMiddle(chunk, height).add(0, 1, 0);
			
			if(!players.getConfig().getBoolean(UUIDManager.getUUID(owner))){
				players.getConfig().set(UUIDManager.getUUID(owner)+".hasLand", true);
				final int lands = players.getConfig().getInt(UUIDManager.getUUID(owner)+".lands");
				players.getConfig().set(UUIDManager.getUUID(owner)+".lands", lands+1);
				FileManager.saveConfig(players);
			}else {
				final int lands = players.getConfig().getInt(UUIDManager.getUUID(owner)+".lands");
				players.getConfig().set(UUIDManager.getUUID(owner)+".lands", lands+1);
			}
			
			final ArrayList<String> names = (ArrayList<String>) players.getConfig().getStringList(UUIDManager.getUUID(owner)+".land");
			names.add(name);
			players.getConfig().set(UUIDManager.getUUID(owner)+".land",names);
			
			FileManager.saveConfig(players);
			
			return true;
			
		}else {
			load();
		}
		
		return false;
	}
	
	public boolean createBorder(BorderType type, Material material, Chunk chunk, int height) {
		LandBorder.create(type, chunk, height, material);
		this.borderHeight = height;
		this.borderMaterial = material;
		this.borderType = type;
		
		return true;
	}
	
	public void teleport(Player player) {
		player.teleport(this.middle);
		return;
	}
	
	public boolean addMember(String player) {
		if(!(this.members.contains(player))) {
			this.members.add(player);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean removeMember(String player) {
		if(this.members.contains(player)){
			this.members.remove(player);
			return true;
		}else {
			return false;
		}
	}
	
	public void load() {
		
		this.name = lands.getConfig().getString(this.id.getId()+".name");
		this.owner = lands.getConfig().getString(this.id.getId()+".owner");
		this.members = (ArrayList<String>) lands.getConfig().getStringList(this.id.getId()+".members");
		
		final World world = Bukkit.getWorld(lands.getConfig().getString(this.id.getId()+".world"));
		final double x = lands.getConfig().getDouble(this.id.getId()+".middle.x");
		final double y = lands.getConfig().getDouble(this.id.getId()+".middle.y");
		final double z = lands.getConfig().getDouble(this.id.getId()+".middle.z");
		
		final Location location = new Location(world, x, y, z);
		this.middle = location;
		
		this.borderHeight = lands.getConfig().getInt(this.id.getId()+".borderHeight");
		this.borderMaterial = Material.getMaterial(lands.getConfig().getString(this.id.getId()+".borderMaterial"));
		this.borderType = BorderType.fromString(lands.getConfig().getString(this.id.getId()+".borderType"));
	
		this.settings.load(lands, this.id.getId());
		
		return;
	}
	
	public void save() {
		translator.getConfig().set(this.name, this.id.getId());
		
		FileManager.saveConfig(translator);
		
		lands.getConfig().set(this.id.getId()+".name", this.name);
		lands.getConfig().set(this.id.getId()+".owner", this.owner);
		lands.getConfig().set(this.id.getId()+".members", this.members);
		
		lands.getConfig().set(this.id.getId()+".world", this.middle.getWorld().getName());
		lands.getConfig().set(this.id.getId()+".middle.x", this.middle.getX());
		lands.getConfig().set(this.id.getId()+".middle.y", this.middle.getY());
		lands.getConfig().set(this.id.getId()+".middle.z", this.middle.getZ());
		
		lands.getConfig().set(this.id.getId()+".borderHeight", this.borderHeight);
		lands.getConfig().set(this.id.getId()+".borderMaterial", String.valueOf(this.borderMaterial.toString()));
		lands.getConfig().set(this.id.getId()+".borderType", this.borderType.getIndex());
		
		this.settings.save(lands, this.id.getId());
		
		FileManager.saveConfig(lands);
		
		return;
	}
	
	public void delete() {
		translator.getConfig().set(this.name, null);
		lands.getConfig().set(this.id.getId(), null);
		
		final ArrayList<String> names = (ArrayList<String>) players.getConfig().getStringList(owner+".land");
		names.remove(name);
		players.getConfig().set(owner+".land",names);
		
		FileManager.saveConfig(translator);
		FileManager.saveConfig(lands);
		FileManager.saveConfig(players);
		
		return;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getOwner() {
		return owner;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public ArrayList<String> getMembers() {
		return members;
	}
	
	public LandID getID() {
		return id;
	}
	
	public Location getMiddle() {
		return middle;
	}
	
	public void setMiddle(Location middle) {
		this.middle = middle;
	}
	
	public int getBorderHeight() {
		return borderHeight;
	}
	
	public void setBorderHeight(int borderHeight) {
		this.borderHeight = borderHeight;
	}
	
	public Material getBorderMaterial() {
		return borderMaterial;
	}
	
	public void setBorderMaterial(Material borderMaterial) {
		this.borderMaterial = borderMaterial;
	}
	
	public BorderType getBorderType() {
		return borderType;
	}
	
	public LandSettings getSettings() {
		return settings;
	}
	
	public void setSettings(LandSettings settings) {
		this.settings = settings;
	}
	
	
}
