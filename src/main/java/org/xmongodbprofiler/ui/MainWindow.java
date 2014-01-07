package org.xmongodbprofiler.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainWindow extends JFrame implements ActionListener {

	private static final long serialVersionUID = -1095356087304062346L;

	JDesktopPane desktop = new JDesktopPane();
	JMenuBar menuBar = new JMenuBar();
	JMenu menu = new JMenu("File");
	JMenuItem menuProfiler = new JMenuItem("Profiler");
	JMenuItem menuViewer = new JMenuItem("Viewer");
	JMenuItem menuExit = new JMenuItem("Exit");
	ProfilerWindow profiler = new ProfilerWindow();

	public MainWindow() {
		desktop.add(profiler);
		this.setContentPane(desktop);
		this.setVisible(true);
		this.setSize(700, 700);

		this.setTitle("XMongoDBProfiler");
		menuBar.add(menu);
		menu.add(menuProfiler);
		menu.add(menuViewer);
		menu.add(menuExit);

		this.setJMenuBar(menuBar);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		menuProfiler.addActionListener(this);
		menuExit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menuExit) {
			System.exit(0);
		}
		if (e.getSource() == menuProfiler) {
			ProfilerWindow profiler = new ProfilerWindow();
			this.add(profiler);
			profiler.setVisible(true);
		}
	}
}
