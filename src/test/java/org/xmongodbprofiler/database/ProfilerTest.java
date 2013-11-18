package org.xmongodbprofiler.database;

import java.net.UnknownHostException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.mongodb.DB;
import com.mongodb.MongoClient;

import org.xmongodbprofiler.database.Profiler;

/**
 * Unit test for simple App.
 */
public class ProfilerTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ProfilerTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ProfilerTest.class );
    }

    public void testStartProfiler() throws UnknownHostException
    {
    	MongoClient client = new MongoClient("localhost");
    	DB db = client.getDB("test1");
    		
    	assertTrue(Profiler.startProfiler(db));
    	//assertTrue(true);
    }
    
    public void testStopProfiler() throws UnknownHostException
    {
    	MongoClient client = new MongoClient("localhost");
    	DB db = client.getDB("test1");
    	   	
    	Profiler.stopProfiler(db);
    	assertTrue(true);
    }
}
