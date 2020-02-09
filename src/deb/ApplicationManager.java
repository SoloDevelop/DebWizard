package deb;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ApplicationManager {

	File desktopFile;

	public static ApplicationManager applicationManager;

	public static final String WORKSPACE_PATH = "src" + File.separator + "deb" + File.separator + "applications";

	private ApplicationManager() {
	}

	public static ApplicationManager getSingletonInstance() {
		if (applicationManager == null) {
			applicationManager = new ApplicationManager();
		}
		return applicationManager;
	}

	public void clear() {
		try (FileWriter fr = new FileWriter(desktopFile)) {
			// try with resources autocloses the stream
			fr.write("");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getText() {
		String s = "";

		try (FileReader fileReader = new FileReader(desktopFile)) { // try with resources autocloses the stream

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

	public void mkDesktop() {
		if (desktopFile == null) // TODO: make sure this executes before any call to the file
			//desktopFile = new File(WORKSPACE_PATH + File.separator + FieldManager.packageName + ".desktop");
			desktopFile = DirectoryManager.mkDesktop();
		try {
			desktopFile.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public File setDesktop(Desktop desk) {
		try (FileWriter fw = new FileWriter(desktopFile)) { // try with resources autocloses the stream.
			fw.write(desk.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return desktopFile;
	}

	public void setDesktop(File desktop) {
		this.desktopFile = desktop;
	}

}
