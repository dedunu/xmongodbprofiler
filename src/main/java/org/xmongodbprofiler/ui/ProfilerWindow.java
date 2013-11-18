package org.xmongodbprofiler.ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class ProfilerWindow extends JFrame {
	private JLabel lblServer = new JLabel("Server Name");
	private JLabel lblPort = new JLabel("Port");
	private JLabel lblDatabase = new JLabel("Database");
	private JLabel lblUserName = new JLabel("Username");
	private JLabel lblPassword = new JLabel("Password");
	private JLabel lblPath = new JLabel("Path");

	private JTextField txtServer = new JTextField();
	private JTextField txtPort = new JTextField("27017");
	private JTextField txtDatabase = new JTextField();
	private JTextField txtUserName = new JTextField();
	private JTextField txtPassword = new JTextField();
	private JTextField txtPath = new JTextField();
	
	private JButton btnStart = new JButton("Start");
	private JButton btnStop = new JButton("Stop");

	public ProfilerWindow() {
		
		this.setLayout(null);
		
		this.add(lblServer);
		this.add(lblPort);
		this.add(lblDatabase);
		this.add(lblUserName);
		this.add(lblPassword);
		this.add(lblPath);
		
		this.add(txtServer);
		this.add(txtPort);
		this.add(txtDatabase);
		this.add(txtUserName);
		this.add(txtPassword);
		
		this.add(txtPath);
		this.add(btnStart);
		this.add(btnStop);
		
		lblServer.setBounds(10, 15, 100, 10);
		lblPort.setBounds(325, 15, 80, 10);
		lblDatabase.setBounds(10, 45, 80, 10);
		lblUserName.setBounds(10, 75, 100, 10);
		lblPassword.setBounds(10, 105, 80, 10);
		lblPath.setBounds(10, 135, 80, 10);
		
		txtServer.setBounds(120, 10, 200, 20);
		txtPort.setBounds(400, 10, 80, 20);
		txtDatabase.setBounds(120, 40, 200, 20);
		txtUserName.setBounds(120, 70, 200, 20);
		txtPassword.setBounds(120, 100, 200, 20);
		txtPath.setBounds(120, 130, 200, 20);
		
		btnStart.setBounds(180, 155, 80, 30);
		btnStop.setBounds(300, 155, 80, 30);
		
		this.setTitle("MongoDB Profiler");
		this.setSize(500, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}
}
