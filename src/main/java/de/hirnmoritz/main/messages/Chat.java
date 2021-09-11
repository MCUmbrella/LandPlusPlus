package de.hirnmoritz.main.messages;

public enum Chat {

	LINE("======================"),
	DEVELOPER("DasJava"),
	SEPERATOR("§f>>"),
	PLACEHOLDER(" ");
	
	private String index;

	private Chat(String index) {
		this.index = index;
	}
	
	public String getIndex() {
		return index;
	}
	
	
}
