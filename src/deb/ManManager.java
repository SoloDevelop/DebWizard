package deb;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ManManager {

	File manFile;

	public enum SECTION {
		USER, SYSTEM, LIBRARY, SPECIAL, FILE_FORMATS, GAMES, MISC, COMMANDS
	}

	// https://stackoverflow.com/questions/6692664/how-to-get-enum-value-from-index-in-java

	SECTION manSection;

	public static ManManager manManager;

	public static final String WORKSPACE_PATH = "src" + File.separator + "deb" + File.separator + "man";

	private ManManager() {
	}

	public static ManManager getSingletonInstance() {
		if (manManager == null) {
			manManager = new ManManager();
		}
		return manManager;
	}

	public void clear() {
		try (FileWriter fr = new FileWriter(manFile)) {
			// try with resources autocloses the stream
			fr.write("");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getText() {
		String s = "";

		try (FileReader fileReader = new FileReader(manFile)) { // try with resources autocloses the stream

			int data = fileReader.read();
			while (data != -1) {
				s += (char) data;
				data = fileReader.read();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	public void mkMan() {
		if (manFile == null && manSection != null) { // TODO: make sure this executes before any call to the file
			manFile = new File(WORKSPACE_PATH + File.separator + FieldManager.packageName + "." + manSection.ordinal());
			try {
				manFile.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else
			System.out.println("Section is NULL");
	}

	public File add(ManEntry man) {
		try (FileWriter fw = new FileWriter(manFile, true)) { // try with resources autocloses the stream.
			fw.write(man.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return manFile;
	}

	public void setMan(File man) {
		this.manFile = man;
	}

	public void setSection(SECTION section) {
		this.manSection = section;
		FieldManager.manSection = section.ordinal();
	}

}
