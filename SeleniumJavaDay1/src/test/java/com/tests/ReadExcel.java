package com.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.stream.FileImageInputStream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcel {
	
	 Object obj=null;
	
	public static Object testexcel(){
		
		File file = new File("C:\\Users\\Training_b6b.00.03\\workspace\\test\\SeleniumJavaDay1\\src\\test\\resources\\TestData.xlsx");
		try {
			InputStream stream = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(file);//get workbbook
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			Object[][] obj= new Object[sheet.getLastRowNum()][];
			for(int i=1;i<sheet.getLastRowNum();i++){
				obj[i-1]=new Object[2];
				for(int j=0;j<sheet.getRow(i).getPhysicalNumberOfCells();j++){
					obj[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
			}
		}
			workbook.close();
			stream.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
}
