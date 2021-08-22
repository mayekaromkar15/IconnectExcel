package com.omkar.ExcelRunning;

import java.io.*;

import org.apache.poi.xssf.usermodel.*;


public class POIframe {
	public static void main(String[] args) throws IOException {
		
		String excelpath = "D:\\Full Stack\\New Learning\\codingtesticonnectjava\\a.xlsx";
		FileInputStream fis = new FileInputStream(excelpath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(1).getLastCellNum();
		
		for(int r = 1; r<rows; r++) 
		{
			XSSFRow row = sheet.getRow(r);
			for(int c = 0; c<cols; c++) 
			{
				XSSFCell cell = row.getCell(c);
				switch(cell.getCellType()) 
				{
				case STRING:System.out.print(cell.getStringCellValue());break;
				case NUMERIC:System.out.print(cell.getNumericCellValue());break;
				case BOOLEAN:System.out.print(cell.getBooleanCellValue());break;
				}
				System.out.print(" | ");
			}System.out.println();
			
		}
	}
}
