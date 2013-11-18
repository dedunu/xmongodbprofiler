package org.xmongodbprofiler.database;

import java.util.List;
import java.net.UnknownHostException;
import java.util.ArrayList;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

public class Connection {

	private String userName = null;
	private String password = null;
	private String database = null;
	private List<ServerAddress> serverList = new ArrayList<ServerAddress>();

	public Connection() {

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

	public List<ServerAddress> getServerList() {
		return serverList;
	}

	public void addServer(String serverName, int port)
			throws UnknownHostException {
		serverList.add(new ServerAddress(serverName, port));
	}

	public void addServer(String serverName) throws UnknownHostException {
		serverList.add(new ServerAddress(serverName));
	}

	public DB connect() {
		List<MongoCredential> credentials = new ArrayList<MongoCredential>();
		credentials.add(MongoCredential.createMongoCRCredential(userName,
				database, password.toCharArray()));
		MongoClient client = new MongoClient(serverList, credentials);
		return client.getDB(database);
	}
	public DB connectWithNoAuth() {
		MongoClient client = new MongoClient(serverList);
		return client.getDB(database);
	}
}