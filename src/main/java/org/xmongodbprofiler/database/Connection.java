package org.xmongodbprofiler.database;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

public class Connection {

	private MongoClient client = null;
	private List<ServerAddress> seeds = new ArrayList<ServerAddress>();
	private String userName = null;
	private String password = null;
	private String database = null;

	public Connection() {

	}

	public Connection(MongoClient client) {
		this.client = client;
	}

	public void addServer(String serverName, int port)
			throws UnknownHostException {
		seeds.add(new ServerAddress(serverName, port));
	}
	
	public void addServer(String serverName)
			throws UnknownHostException {
		seeds.add(new ServerAddress(serverName, 27017));
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public DB connect() {
		List<MongoCredential> credentialsList = null;
		credentialsList.add(MongoCredential.createMongoCRCredential(userName,
				this.database, password.toCharArray()));
		client = new MongoClient(seeds, credentialsList);
		return client.getDB(this.database);
	}

	public DB connect(String database) {
		List<MongoCredential> credentialsList = null;
		credentialsList.add(MongoCredential.createMongoCRCredential(userName,
				database, password.toCharArray()));
		client = new MongoClient(seeds, credentialsList);
		return client.getDB(database);
	}

}