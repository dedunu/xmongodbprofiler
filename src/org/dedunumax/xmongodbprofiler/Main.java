package org.dedunumax.xmongodbprofiler;

import org.dedunumax.xmongodbprofiler.ui.ProfilerWindow;

public class Main {

	public static void main(String[] args) {
		ProfilerWindow window = new ProfilerWindow();
		System.out.println("Program Started");
		window.setVisible(true);
	}

}