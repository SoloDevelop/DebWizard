package deb;

import java.util.ArrayList;

class OptEntry {
	String opt;
	String desc;

	public OptEntry(String opt, String desc) {
		super();
		this.opt = opt;
		this.desc = desc;
	}

}

public class ManEntry {

	String name;

	String synopsis;

	String desc;

	ArrayList<OptEntry> options;

	public ManEntry(String name, String synopsis, String desc) {
		this.name = name;
		this.synopsis = synopsis;
		this.desc = desc;
	}

	public void setOptions(String opt, String desc) {
		options.add(new OptEntry(opt, desc));
	}
}
