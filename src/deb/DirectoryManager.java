package deb;

import java.io.File;

public abstract class DirectoryManager {

	private static String PATH = null;

	public static File mkDesktop() {
		// TODO Auto-generated method stub
		return new File(PATH + File.separator + FieldManager.packageName + ".desktop");
	}

	public static void  setPath(String path) { //TODO: apply method
		PATH = path;
	}

	
	
	
}
