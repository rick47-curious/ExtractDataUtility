package com.extractdata.util;


import java.io.FileOutputStream;
import java.util.HashMap;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

	public static void writeData(Object[][] data) {
		
		int count = 0;
		HashMap<String,String> mapData;
		String[] oldHeaders = {"Project_ID","Associate_ID","Associate_Name","Designation","ClaimMonth","TotalMonth","BU_Head","BU_Coo","DongleProvided"};
		String[] newHeaders = {"Project ID","Associate ID","Associate Name","Designation","Claim Month","Total Months","Associate ID BU_Head","Associate ID BU_COO","Dongle Provided"};
		
		XSSFWorkbook wb = new XSSFWorkbook();
		
		XSSFSheet sheet = wb.createSheet("FormattedData");
		
		//Creating the headers
		Row headerRow = sheet.createRow(0);
		for (int i=0;i<9;i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(newHeaders[i]);
		}
		for (int i=0;i<data.length;i++) {
			mapData = (HashMap<String, String>) data[i][0];
			Row dataRow = sheet.createRow(i+1);
			for (int j=0;j<oldHeaders.length;j++) {
				dataRow.createCell(count).setCellValue(mapData.get(oldHeaders[j]));
				count++;
			}
			count = 0;
		}
		
		try {
			FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir")+"/target/"+"SampleOutput.xlsx");
			wb.write(fos);
			wb.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
}
