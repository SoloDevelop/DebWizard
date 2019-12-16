package deb;

public class Control {

	public enum SECTION {
		ADMIN, COMM, DATABASE, DEBUG, DEVEL, DOC, JAVA, JAVASCRIPT, KERNEL, LIBS, LISP, MATH, METAPACKAGES, MISC, NET,
		PYTHON, SHELLS, SOUND, TASKS, TEXT, UTILS, VIDEO, WEB
	}

	public enum PRIORITY {
		REQUIRED, IMPORTANT, STANDARD, OPTIONAL, EXTRA
	}

	public enum ARCHITECTURE {
		ANY, ALL, SOURCE, DEBIAN_LINUX
	}

	String pack;
	String version;
	SECTION section;
	PRIORITY priority;
	String homepage;
	ARCHITECTURE architecture;
	String depends;
	String maintainer;
	String desc;
	int installedSize;

	public Control(String pack, String version, SECTION section, PRIORITY priority, String homepage,
			ARCHITECTURE architecture, String depends, String maintainer, String desc) {
		this.pack = pack;
		this.version = version;
		this.section = section;
		this.priority = priority;
		this.homepage = homepage;
		this.architecture = architecture;
		this.depends = depends;
		this.maintainer = maintainer;
		this.desc = desc;
	}

	@Override
	public String toString() {

		String s = "Package: " + pack + "\nVersion: " + version + "\nSection: " + section + "\nPriority: " + priority
				+ "\nHomepage: " + homepage + "\nArchitecture: " + architecture + "\nDepends: " + depends
				+ "\nMaintainter: " + maintainer + "\nInstalled-Size: " + getInstalledSize() + "\nDescription: "
				+ getDesc();

		return s;
	}

	private int getInstalledSize() {
		// TODO: calculate installed size
		return 0;
	}

	private String getDesc() {
		return desc.replace("\n", ".");
	}
}
