package com.extractdata.util;

import java.io.FileInputStream;
import java.util.*;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	
	public static Object[][] readData() {
		
		int nextID = 0;
		int count =0;
		HashSet<Integer> projID;
		
		try {
			
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/downloads/MonthlyData.xlsx");
			
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			
			XSSFSheet sheet = wb.getSheetAt(0);
		
			projID = new HashSet<Integer>();
			DataFormatter df = new DataFormatter();
			
			for (int i=1;i<sheet.getLastRowNum();i++) {
				 projID.add(Integer.parseInt(df.formatCellValue(sheet.getRow(i).getCell(3))));
			}
			Object[][] result = new Object[sheet.getLastRowNum()-1][1];
			Iterator<Integer> it =projID.iterator(); 
			while (it.hasNext()) {
				
				nextID = it.next();
				
				for (int i=0;i<sheet.getLastRowNum()-1;i++) {
					HashMap<String,String> map = new HashMap<String,String>();
					Row row = sheet.getRow(i+1);
					if (nextID == Integer.parseInt(df.formatCellValue(row.getCell(3)))) {
					for (int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
						map.put(df.formatCellValue(sheet.getRow(0).getCell(j)), df.formatCellValue(sheet.getRow(i+1).getCell(j)));
					}
					result[count][0] = map;
					count++;
				}	
			}
		}
			wb.close();
			return result;
		}catch(Exception e) {
		e.printStackTrace();
	}
		return null;
 }
}
