package org.dedunumax.xmongodbprofiler.database;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class Profiler {
	public static boolean startProfiler(DB database) {
		try {
			if (database.getCollection("system.profile").getCount() > 0) {
				Date date = new Date();
				String timestamp = (new Timestamp(date.getTime())).toString()
						.replace(" ", "").replace("-", "").replace(":", "")
						.replace(".", "");
				database.getCollection("system.profile").rename(
						"sysprofile" + timestamp);
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

			List<BasicDBObject> list = new ArrayList<BasicDBObject>();

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
