package deb;

import java.io.File;

public class ControlManager {
	
	public static ControlManager controlManager;
	File control = null;
	public static final String WORKSPACE_PATH = "src" + File.separator + "deb" + File.separator + "DEBIAN";

	private ControlManager(File control) {
		this.control = control;
	}

	public static ControlManager getSingletonInstance(File control) {
		if (controlManager == null) {
			controlManager = new ControlManager(control);
		}
		return controlManager;
	}

	public void setControl(File control) {
		this.control = control;
	}

}
