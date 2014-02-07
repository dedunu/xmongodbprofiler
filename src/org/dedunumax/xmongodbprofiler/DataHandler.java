package org.dedunumax.xmongodbprofiler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.mongodb.BasicDBObject;

public class DataHandler {
	
	public static void saveDataXLS(String fileName, List<BasicDBObject> list)
			throws IOException {
		Workbook wb = new HSSFWorkbook();
	    Sheet sheet = wb.createSheet("Profiler_Result");
	    Row row = sheet.createRow((short)0);
	    
	    row.createCell(1).setCellValue(1.2);

	    FileOutputStream fileOut = new FileOutputStream(fileName);
	    wb.write(fileOut);
	    fileOut.close();
	}
	
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
