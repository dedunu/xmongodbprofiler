package org.xmongodbprofiler.database;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.ServerAddress;

public class ConnectionStringBuilder {
	private String userName = null;
	private String password = null;
	private String database = null;
	private List<String> seeds = new ArrayList<String>();

	public void addSeed(String hostname, int port) {
		seeds.add(hostname + Integer.toString(port));
	}

	public void addSeed(String hostname) {
		seeds.add(hostname);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getCredential() {
		String credentialString = null;

		if (userName != null && !userName.equals("") && password != null
				&& !password.equals("")) {
			credentialString = userName + ":" + password;
		} else {
			credentialString = null;
		}

		return credentialString;
	}
	
	public String getServerList(){
		String serverList = null;
		
		
		
		return serverList;
	}

}
