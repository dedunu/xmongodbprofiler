package org.xmongodbprofiler.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import org.xmongodbprofiler.DataHandler;
import org.xmongodbprofiler.database.Connection;
import org.xmongodbprofiler.database.Profiler;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;

public class ProfilerWindow extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 5481142824468689746L;
	
	private Connection connection = new Connection();
	private DB database = null;
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
		lblPort.setBounds(365, 15, 80, 10);
		lblDatabase.setBounds(10, 45, 80, 10);
		lblUserName.setBounds(10, 75, 100, 10);
		lblPassword.setBounds(10, 105, 80, 10);
		lblPath.setBounds(10, 135, 80, 10);

		txtServer.setBounds(120, 10, 230, 20);
		txtPort.setBounds(400, 10, 80, 20);
		txtDatabase.setBounds(120, 40, 360, 20);
		txtUserName.setBounds(120, 70, 360, 20);
		txtPassword.setBounds(120, 100, 360, 20);
		txtPath.setBounds(120, 130, 360, 20);

		Date date = new Date();
		String timestamp = (new Timestamp(date.getTime())).toString()
				.replace(" ", "").replace("-", "").replace(":", "")
				.replace(".", "");
		txtPath.setText(System.getProperty("user.home") + "/mongodb_profiler_"
				+ timestamp + ".xls");

		btnStop.setEnabled(false);

		btnStart.setBounds(310, 155, 80, 30);
		btnStop.setBounds(400, 155, 80, 30);

		btnStart.addActionListener(this);
		btnStop.addActionListener(this);
		
		this.setClosable(true);
		this.setTitle("MongoDB Profiler");
		this.setSize(500, 230);
		//this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnStart) {
			if (txtDatabase.getText().equals("")) {
				JOptionPane.showMessageDialog(this,
						"Please enter a database name.");
				return;
			}
			if (txtServer.getText().equals("")) {
				JOptionPane.showMessageDialog(this,
						"Please enter a server name.");
				return;
			}
			if (txtPort.getText().equals("")) {
				JOptionPane.showMessageDialog(this,
						"Please enter a port number.");
				return;
			}
			if (txtPath.getText().equals("")) {
				JOptionPane.showMessageDialog(this,
						"Please enter a valid file path.");
				return;
			}
			try {
				connection.setDatabase(txtDatabase.getText());
				connection.setPassword(txtPassword.getText());
				connection.setUserName(txtUserName.getText());
				connection.addServer(txtServer.getText(),
						Integer.parseInt(txtPort.getText()));
			} catch (UnknownHostException uhe) {
				JOptionPane
						.showMessageDialog(this,
								"Host not found. Please enter a valid hostname and port number.");
				return;
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(this,
						"Please enter a valid port number.");
				return;
			} catch (Exception ue) {
				JOptionPane.showMessageDialog(this, "Unknown error occured: "
						+ ue.getMessage());
				return;
			}

			try {
				if (txtUserName.getText().equals("")) {
					database = connection.connectWithNoAuth();
				} else {
					database = connection.connect();
				}
				if (Profiler.startProfiler(database)) {
					JOptionPane.showMessageDialog(this,
							"Profiler started successfully.");
					btnStart.setEnabled(false);
					btnStop.setEnabled(true);
				} else {
					JOptionPane
							.showMessageDialog(this,
									"Profiler did not start. Please check connection details");
				}
			} catch (Exception err) {

			}

		}
		if (e.getSource() == btnStop) {
			try {
				List<BasicDBObject> obj = Profiler.stopProfiler(database);
				DataHandler.saveData(txtPath.getText(), obj);

				Date date = new Date();
				String timestamp = (new Timestamp(date.getTime())).toString()
						.replace(" ", "").replace("-", "").replace(":", "")
						.replace(".", "");
				txtPath.setText(System.getProperty("user.home")
						+ "/mongodb_profiler_" + timestamp + ".xls");

				btnStart.setEnabled(true);
				btnStop.setEnabled(false);
			} catch (IOException ioe) {
				JOptionPane.showMessageDialog(this, "Error with File path.");
			} catch (Exception ue) {
				JOptionPane.showMessageDialog(this, "Unknown error occured: "
						+ ue.getMessage());
			}
		}
	}
}
