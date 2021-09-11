package de.hirnmoritz.main.lists;

import java.util.ArrayList;

import org.bukkit.entity.EntityType;

public abstract class EntityList {
	
	public static ArrayList<EntityType> mob = new ArrayList<>();
	
	public static void init() {
	
		for(EntityType entity : EntityType.values()) {
			if(entity.isAlive()) {
				mob.add(entity);
			}
		}
		
		mob.remove(EntityType.PLAYER);
		
		return;
	}
	
	
}
