package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class File_Utility {
	
	public static String getPropertyData(String key) {
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("./src/main/resources/commonData.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties property = new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return property.getProperty(key);
	}
	
	public static String getExcelData(String sheetName, int rowNum, int cellNum) {
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("./src/test/resources/testScriptData.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Workbook book = null;
		try {
			book = WorkbookFactory.create(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNum-1);
		Cell cell = row.getCell(cellNum-1);
		
		return cell.getStringCellValue();
	}
	
	public static String[][] getMultipleDataFromExcel(String sheetName) {
		
		FileInputStream fis = null;
		Workbook book = null;
		try {
			fis = new FileInputStream("./src/test/resources/testScriptData.xlsx");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Sheet sheet = book.getSheet(sheetName);
		int rowNum = sheet.getPhysicalNumberOfRows();
		int cellNum = sheet.getRow(0).getPhysicalNumberOfCells();
		
		String data[][] = new String[rowNum-1][cellNum];
		for (int i = 1; i < rowNum; i++) {
			for (int j = 0; j < cellNum; j++) {
				
				data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return data;
	}

}
