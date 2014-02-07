package org.dedunumax.xmongodbprofiler;

import java.io.FileOutputStream;
import java.io.IOException;
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

		Row row = sheet.createRow((short) 0);

		row.createCell(0).setCellValue("Operation");
		row.createCell(1).setCellValue("Namespace");
		row.createCell(2).setCellValue("Query");
		row.createCell(3).setCellValue("No. of Scanned Docs");
		row.createCell(4).setCellValue("No. of Inserted Docs");
		row.createCell(5).setCellValue("No. of Updated Docs");
		row.createCell(6).setCellValue("No. of Deleted Docs");
		row.createCell(7).setCellValue("No. to return");
		row.createCell(8).setCellValue("No. of returned Docs");
		row.createCell(9).setCellValue("No. to skip");
		row.createCell(10).setCellValue("Key Updates");
		row.createCell(11).setCellValue("No. of Yeild");
		row.createCell(12).setCellValue("Lock Statistics");
		row.createCell(13).setCellValue("Response Length");
		row.createCell(14).setCellValue("Time in millis");
		row.createCell(15).setCellValue("Timestamp");
		row.createCell(16).setCellValue("Client Host Name");
		row.createCell(17).setCellValue("All Users");
		row.createCell(18).setCellValue("User");

		short pointer = 1;

		for (BasicDBObject obj : list) {
			row = sheet.createRow(pointer);

			try {
				row.createCell(0).setCellValue(obj.getString("op"));
			} catch (Exception e) {
			}

			try {
				row.createCell(1).setCellValue(obj.getString("ns"));
			} catch (Exception e) {
			}

			try {
				row.createCell(2).setCellValue(obj.getString("query"));
			} catch (Exception e) {
			}

			try {
				row.createCell(3).setCellValue(obj.getString("nscanned"));
			} catch (Exception e) {
			}

			try {
				row.createCell(4).setCellValue(obj.getString("ninserted"));
			} catch (Exception e) {
			}

			try {
				row.createCell(5).setCellValue(obj.getString("nupdated"));
			} catch (Exception e) {
			}

			try {
				row.createCell(6).setCellValue(obj.getString("ndeleted"));
			} catch (Exception e) {
			}

			try {
				row.createCell(7).setCellValue(obj.getString("ntoreturn"));
			} catch (Exception e) {
			}

			try {
				row.createCell(8).setCellValue(obj.getString("nreturned"));
			} catch (Exception e) {
			}

			try {
				row.createCell(9).setCellValue(obj.getString("ntoskip"));
			} catch (Exception e) {
			}
			
			try {
				row.createCell(10).setCellValue(obj.getString("keyUpdates"));
			} catch (Exception e) {
			}

			try {
				row.createCell(11).setCellValue(obj.getString("numYield"));
			} catch (Exception e) {
			}

			try {
				row.createCell(12).setCellValue(obj.getString("lockStats"));
			} catch (Exception e) {
			}

			try {
				row.createCell(13)
						.setCellValue(obj.getString("responseLength"));
			} catch (Exception e) {
			}

			try {
				row.createCell(14).setCellValue(obj.getString("millis"));
			} catch (Exception e) {
			}

			try {
				row.createCell(15).setCellValue(obj.getString("ts"));
			} catch (Exception e) {
			}

			try {
				row.createCell(16).setCellValue(obj.getString("client"));
			} catch (Exception e) {
			}

			try {
				row.createCell(17).setCellValue(obj.getString("allUsers"));
			} catch (Exception e) {
			}

			try {
				row.createCell(18).setCellValue(obj.getString("user"));
			} catch (Exception e) {
			}

			pointer++;
		}

		FileOutputStream fileOut = new FileOutputStream(fileName);
		wb.write(fileOut);
		fileOut.close();
	}
}
