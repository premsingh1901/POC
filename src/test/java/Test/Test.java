package Test;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.IllegalFormatException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;

import org.openqa.selenium.JavascriptExecutor;
import org.apache.commons.*;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import poc.com.base.Base;

public class Test extends Base {
	
		

	static Workbook book;
	static Sheet sheet;
	static String currentDirectory = System.getProperty("user.dir");
	static String TESTDATA_SHEET_PATH=currentDirectory+"\\src\\main\\java\\poc\\com\\testdata\\ExcelData.xlsx";									
	static String sheetName="add"; 
	public static void main(String []args) throws InvalidFormatException
	{
	
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IllegalFormatException  e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		System.out.println(sheet);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		System.out.println(sheet.getLastRowNum() + "--------" +	sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			System.out.println();
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				System.out.print(" "+data[i][k]);
			}
		}
	
	}
	
	
	

}

