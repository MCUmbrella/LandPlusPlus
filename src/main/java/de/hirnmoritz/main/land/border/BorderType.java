package de.hirnmoritz.main.land.border;

public enum BorderType {

	CORNER("corner"),
	WALL("wall"),
	NULL("null");
	
	private String index;
	
	BorderType(String index){
		this.index = index;
	}
	
	public static BorderType fromString(String index) {
		for(BorderType type : BorderType.values()){
			if(index.equalsIgnoreCase(type.getIndex())) {
				return type;
			}
		}
		
		return null;
	}
	
	public String getIndex() {
		return index;
	}
	
	
}
