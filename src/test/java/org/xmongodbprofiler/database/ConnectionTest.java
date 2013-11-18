package org.xmongodbprofiler.database;

import java.net.UnknownHostException;

import junit.framework.TestCase;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;

import org.xmongodbprofiler.database.Connection;

public class ConnectionTest extends TestCase {

	public void testConnectionWithoutAuth() throws UnknownHostException {
		Connection con = new Connection();
		con.addServer("localhost", 27017);
		con.setDatabase("test1");
		con.setUserName("");
		con.setPassword("");
		DB database = con.connect();
		database.getCollection("testCon").insert(
				new BasicDBObject("testAuth", "done"));

			assertTrue(false);
	}

	public void testConnectionWithAuth() throws UnknownHostException {
		Connection con = new Connection();
		con.addServer("localhost", 27017);
		con.setDatabase("test1");
		con.setUserName("testUser");
		con.setPassword("1234");
		DB database = con.connect();

		database.getCollection("testCon").insert(
				new BasicDBObject("testAuth", "done"));
		
		assertTrue(true);

	}
}
