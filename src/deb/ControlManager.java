package deb;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ControlManager {

	public static ControlManager controlManager;
	File control = null;
	public static final String WORKSPACE_PATH = "src" + File.separator + "deb" + File.separator + "DEBIAN";

	private ControlManager(Control control) {
		this.control = mkControl(control);
	}

	public static ControlManager getSingletonInstance(Control control) {
		if (controlManager == null) {
			controlManager = new ControlManager(control);
		}
		return controlManager;
	}

	public void clear() {
		try (FileWriter fr = new FileWriter(control)) {
			// try with resources autocloses the stream
			fr.write("");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getText() {
		String s = "";

		try (FileReader fileReader = new FileReader(control)) { // try with resources autocloses the stream

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

	public File mkControl(Control ctrl) {
		if (control == null) // TODO: make sure this executes before any call to the file
			control = new File(WORKSPACE_PATH + File.separator + "CONTROL");
		try {
			System.out.println(control.createNewFile());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return control;
	}

}
