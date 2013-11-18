package org.xmongodbprofiler.database;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;

public class MainTest {

	public static void main(String[] args) throws UnknownHostException  {
		Connection con = new Connection();
		con.setDatabase("test1");
		con.setPassword("");
		con.setUserName("");
		con.addServer("localhost",27017);
		DB database = con.connectWithNoAuth();
		database.getCollection("testCon").insert(
				new BasicDBObject("testAuth", "done"));

	}
}