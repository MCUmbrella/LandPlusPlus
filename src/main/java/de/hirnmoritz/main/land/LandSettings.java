package de.hirnmoritz.main.land;

import de.hirnmoritz.main.datapacket.DataPacket;
import de.hirnmoritz.main.filemanager.FileManager;

public class LandSettings {

	private boolean allowTnT = false;
	private boolean allowPvP = false;
	private boolean allowBreak = false;
	private boolean allowBuild = false;
	private boolean allowInteractEntity = false;
	private boolean allowUseButton = true;
	private boolean allowUseDoor = true;
	private boolean allowUseChest = true;
	private boolean allowUseTrappedChest = true;
	private boolean allowUseFurnace = true;
	
	public LandSettings() {
		return;
	}
	
	public void load(DataPacket config, String path) {
		this.allowTnT = config.getConfig().getBoolean(path+".settings.allowTnT");
		this.allowPvP = config.getConfig().getBoolean(path+".settings.allowPvP");
		this.allowBreak = config.getConfig().getBoolean(path+".settings.allowBreak");
		this.allowBuild = config.getConfig().getBoolean(path+".settings.allowBuild");
		this.allowInteractEntity = config.getConfig().getBoolean(path+".settings.allowInteractEntity");
		this.allowUseButton= config.getConfig().getBoolean(path+".settings.allowUseButton");
		this.allowUseDoor = config.getConfig().getBoolean(path+".settings.allowUseDoor");
		this.allowUseChest = config.getConfig().getBoolean(path+".settings.allowUseChest");
		this.allowUseTrappedChest = config.getConfig().getBoolean(path+".settings.allowUseTrappedChest");
		this.allowUseFurnace = config.getConfig().getBoolean(path+".settings.allowUseFurnace");
		
		return;
	}
	
	public void save(DataPacket config, String path) {
		config.getConfig().set(path+".settings.allowTnT", allowTnT);
		config.getConfig().set(path+".settings.allowPvP", allowPvP);
		config.getConfig().set(path+".settings.allowBreak", allowBreak);
		config.getConfig().set(path+".settings.allowBuild", allowBuild);
		config.getConfig().set(path+".settings.allowInteractEntity", allowInteractEntity);
		config.getConfig().set(path+".settings.allowUseButton", allowUseButton);
		config.getConfig().set(path+".settings.allowUseDoor", allowUseDoor);
		config.getConfig().set(path+".settings.allowUseChest", allowUseChest);
		config.getConfig().set(path+".settings.allowUseTrappedChest", allowUseTrappedChest);
		config.getConfig().set(path+".settings.allowUseFurnace", allowUseFurnace);
		
		FileManager.saveConfig(config);
		
		return;
	}

	public boolean isAllowTnT() {
		return allowTnT;
	}

	public void setAllowTnT(boolean allowTnT) {
		this.allowTnT = allowTnT;
	}

	public boolean isAllowPvP() {
		return allowPvP;
	}

	public void setAllowPvP(boolean allowPvP) {
		this.allowPvP = allowPvP;
	}

	public boolean isAllowBreak() {
		return allowBreak;
	}

	public void setAllowBreak(boolean allowBreak) {
		this.allowBreak = allowBreak;
	}

	public boolean isAllowBuild() {
		return allowBuild;
	}

	public void setAllowBuild(boolean allowBuild) {
		this.allowBuild = allowBuild;
	}

	public boolean isAllowInteractEntity() {
		return allowInteractEntity;
	}

	public void setAllowInteractEntity(boolean allowInteractEntity) {
		this.allowInteractEntity = allowInteractEntity;
	}

	public boolean isAllowUseButton() {
		return allowUseButton;
	}

	public void setAllowUseButton(boolean allowUseButton) {
		this.allowUseButton = allowUseButton;
	}

	public boolean isAllowUseDoor() {
		return allowUseDoor;
	}

	public void setAllowUseDoor(boolean allowUseDoor) {
		this.allowUseDoor = allowUseDoor;
	}

	public boolean isAllowUseChest() {
		return allowUseChest;
	}

	public void setAllowUseChest(boolean allowUseChest) {
		this.allowUseChest = allowUseChest;
	}

	public boolean isAllowUseTrappedChest() {
		return allowUseTrappedChest;
	}

	public void setAllowUseTrappedChest(boolean allowUseTrappedChest) {
		this.allowUseTrappedChest = allowUseTrappedChest;
	}

	public boolean isAllowUseFurnace() {
		return allowUseFurnace;
	}

	public void setAllowUseFurnace(boolean allowUseFurnace) {
		this.allowUseFurnace = allowUseFurnace;
	}
	
	
	
	
	
}
