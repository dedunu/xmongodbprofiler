package org.xmongodbprofiler.database;

import java.net.UnknownHostException;

import junit.framework.TestCase;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;

public class ConnectionTest extends TestCase {

	public void testConnectionWithoutAuth() throws UnknownHostException {
		Connection con = new Connection();
		con.setDatabase("test1");
		con.setPassword("1234");
		con.setUserName("testUser");
		con.addServer("localhost", 27017);
		DB database = con.connect();
		database.getCollection("testCon").insert(
				new BasicDBObject("testAuth", "done"));
		assertTrue(true);
	}

	public void testConnectionWithAuth() throws UnknownHostException {
		Connection con = new Connection();
		con.setDatabase("test1");
		con.setPassword("");
		con.setUserName("");
		con.addServer("localhost", 27017);
		DB database = con.connectWithNoAuth();
		database.getCollection("testCon").insert(
				new BasicDBObject("testAuth", "done"));
		assertTrue(true);
	}
}
