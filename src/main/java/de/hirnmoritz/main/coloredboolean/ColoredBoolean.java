package de.hirnmoritz.main.coloredboolean;

public abstract class ColoredBoolean {

	public static String get(boolean b) {
		
		if(b == true) {
			return String.valueOf("§a"+b);
		}
		
		if(b == false) {
			return String.valueOf("§c"+b);
		}

		return String.valueOf(b);
	}
	
	
}
