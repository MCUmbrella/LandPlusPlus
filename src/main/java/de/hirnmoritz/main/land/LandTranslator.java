package de.hirnmoritz.main.land;

public abstract class LandTranslator {
	
	public static LandID getLandID(String name) {
		final LandID id = new LandID(Land.translator.getConfig().getString(name));
		
		return id;
	}
	
	public static boolean available(String name) {
		if(Land.translator.getConfig().getString(name) == null) {
			return true;
		}else {
			return false;
		}
	}
	
	
}
