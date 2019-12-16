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

	@Override
	public String toString() {

		String s = "Package: " + pack + "\nVersion: " + version + "\nSection: " + section + "\nPriority: " + priority
				+ "\nHomepage: " + homepage + "\nArchitecture: " + architecture + "\nDepends: " + depends
				+ "\nMaintainter: " + maintainer + "\nInstalled-Size: " + installedSize + "\nDescription: " + getDesc();

		return s;
	}

	private String getDesc() {
		return desc.replace("\n", ".");
	}
}
