package org.xmongodbprofiler.database;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class Profiler {
	public static boolean startProfiler(DB database) {
		try {
			if (database.getCollection("system.profile").getCount() > 0) {
				Date date = new Date();
				String timestamp = (new Timestamp(date.getTime())).toString();
				BasicDBObject commandObject = new BasicDBObject(
						"renameCollection", "system.profile");
				commandObject.append("to", "profile_purge_" + timestamp);
				database.command(commandObject);
			}

			database.command(new BasicDBObject("profile", 2));
			return true;
		} catch (Exception e) {
		}

		return false;

	}

	public static List<BasicDBObject> stopProfiler(DB database) {
		try {
			database.command(new BasicDBObject("profile", 0));

			List<BasicDBObject> list = null;

			DBCollection collection = database.getCollection("system.profile");
			DBCursor cursor = collection.find();

			while (cursor.hasNext()) {
				list.add((BasicDBObject) cursor.next());
			}

			return list;
		} catch (Exception e) {
		}

		return null;
	}
}
