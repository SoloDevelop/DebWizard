package deb;

import java.nio.file.Path;

public class Desktop {

	public enum TYPE {
		APPLICATION, LINK, DRECTORY
	}

	public enum CATEGORIES {
		UTILITY, AUDIO, VIDEO, DEVELOPMENT, EDUCATION, GAME, GRAPHICS, NETWORK, OFFICE, SCIENCE, SETTINGS, SYSTEM
	}

	final String HEADER = "[Desktop Entry]\n";
	String name;
	String exec;
	Path icon;
	TYPE type;
	CATEGORIES cat;
	String comment;

	public Desktop(String name, String exec, Path icon, TYPE type, CATEGORIES cat, String comment) {
		this.name = name;
		this.exec = exec;
		this.icon = icon;
		this.type = type;
		this.cat = cat;
		this.comment = comment;
	}

	@Override
	public String toString() {
		String s = HEADER + "Name= " + name + "\nExec= " + exec + "\nIcon= " + icon + "\nType= " + type
				+ "\nCategories= " + cat + "\nComment= " + comment;
		return s;
	}

}
