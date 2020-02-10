package deb;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;

public abstract class DirectoryManager {

	public static File rootDir = null;
	public static String PATH = null;
	public static boolean treeReady = false;
	public static HashMap<String, String> pathDictionary = new HashMap<String, String>();

	public static void createDirTree() {
		File f;

		f = new File(rootDir.getAbsolutePath() + File.separator + "DEBIAN");
		f.mkdir();
		pathDictionary.put("DEBIAN", f.getAbsolutePath());

		f = new File(rootDir.getAbsolutePath() + File.separator + "usr");
		f.mkdir();
		pathDictionary.put("usr", f.getAbsolutePath());

		f = new File(pathDictionary.get("usr") + File.separator + "bin");
		f.mkdir();
		pathDictionary.put("bin", f.getAbsolutePath());

		f = new File(pathDictionary.get("usr") + File.separator + "share");
		f.mkdir();
		pathDictionary.put("share", f.getAbsolutePath());

		f = new File(pathDictionary.get("share") + File.separator + "applications");
		f.mkdir();
		pathDictionary.put("applications", f.getAbsolutePath());

		f = new File(pathDictionary.get("share") + File.separator + "doc");
		try {
			f.mkdir();
			FileUtils.cleanDirectory(f);
			pathDictionary.put("doc", f.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}

		f = new File(pathDictionary.get("share") + File.separator + "man");
		f.mkdir();
		pathDictionary.put("man", f.getAbsolutePath());

		f = new File(pathDictionary.get("share") + File.separator + FieldManager.packageName);
		f.mkdir();
		pathDictionary.put(FieldManager.packageName, f.getAbsolutePath());

		f = new File(pathDictionary.get("doc") + File.separator + FieldManager.packageName);
		f.mkdir();
		pathDictionary.put("doc." + FieldManager.packageName, f.getAbsolutePath());

		f = new File(pathDictionary.get("man") + File.separator + "man" + FieldManager.manSection);
		f.mkdir();
		pathDictionary.put("man" + FieldManager.manSection, f.getAbsolutePath());

	}

	public static File mkDesktop() {

		String dirName = PATH + File.separator + "usr" + File.separator + "share" + File.separator + "applications"
				+ File.separator + FieldManager.packageName + ".desktop";

		if (treeReady)
			return new File(dirName);
		return null;
	}

	public static void setPath(String path) { // TODO: apply method
		PATH = path;
	}

	public static void SetRootDir(File dir) {
		rootDir = dir;
		setPath(dir.getAbsolutePath());
	}
}
