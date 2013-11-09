package org.xmongodbprofiler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import com.mongodb.BasicDBObject;

public class DataHandler {
	public static void saveData(String fileName, List<BasicDBObject> list)
			throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				fileName));
		oos.writeObject(list);
		oos.flush();
		oos.close();
	}

	public static List<BasicDBObject> loadData(String fileName)
			throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
				fileName));
		List<BasicDBObject> list = (List<BasicDBObject>) ois.readObject();
		ois.close();
		return list;
	}
}
