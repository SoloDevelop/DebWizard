package deb;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ControlManager {

	public static ControlManager controlManager;
	File control = null;
	public static final String WORKSPACE_PATH = "src" + File.separator + "deb" + File.separator + "DEBIAN";

	private ControlManager() {
	}

	public static ControlManager getSingletonInstance() {
		if (controlManager == null) {
			controlManager = new ControlManager();
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

	public void mkControl() {
		if (control == null) // TODO: make sure this executes before any call to the file
			control = new File(WORKSPACE_PATH + File.separator + "CONTROL");
		try {
			control.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public File setControl(Control ctrl) {
		try (FileWriter fw = new FileWriter(control)) { // try with resources autocloses the stream.
			fw.write(ctrl.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return control;
	}

	public void setControl(File control) {
		this.control = control;
	}

}
