package org.xmongodbprofiler.database;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;

import org.xmongodbprofiler.ui.*;
public class MainTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException  {
/*		Connection con = new Connection();
		con.setDatabase("test1");
		con.setPassword("");
		con.setUserName("");
		con.addServer("localhost",27017);
		DB database = con.connectWithNoAuth();
		Profiler.startProfiler(database);
		database.getCollection("testCon").insert(
				new BasicDBObject("testAuth", "done"));
		database.getCollection("testCon").insert(
				new BasicDBObject("testAuth", "done1"));
		database.getCollection("testCon").insert(
				new BasicDBObject("testAuth", "done2"));
		List<BasicDBObject> obj = Profiler.stopProfiler(database);
		
		DataHandler.saveData("/home/dedunu/test.data", obj);
		
		List<BasicDBObject> obj2 = DataHandler.loadData("/home/dedunu/test.data");
		
		System.out.println(obj2.toString());*/

		ProfilerWindow pw = new ProfilerWindow();
		
		
	}
}