package deb;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ChangelogManager {

	public static ChangelogManager changelogManager;
	File changelog;
	protected static final String WORKSPACE_PATH = "src" + File.separator + "deb" + File.separator + "Doc";

	private ChangelogManager() {
		changelog = DocPanel.changelog; // TODO: This ugly
	}

	public static ChangelogManager getSingletonInstance() {
		if (changelogManager == null) {
			changelogManager = new ChangelogManager();
		}
		return changelogManager;
	}

	public void createChangelog() {
		if (changelog == null) // TODO: make sure this executes before any call to the file
			changelog = new File(WORKSPACE_PATH + File.separator + "changelog");
		try {
			// System.out.println(WORKSPACE_PATH + File.separator + "changelog");
			System.out.println(changelog.createNewFile());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void add(ChangelogEntry changelogEntry) {

		try (FileWriter fw = new FileWriter(changelog, true)) { // try with resources autocloses the stream. Opens in
																// append mode
			fw.write(changelogEntry.toString() + "\n");
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public String getText() {
		String s = "";

		try (FileReader fileReader = new FileReader(changelog)) { // try with resources autocloses the stream

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

	public void clear() {
		try (FileReader fileReader = new FileReader(changelog)) { // try with resources autocloses the stream
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setChangeLog(File changelog) {
		this.changelog = changelog;
	}

}