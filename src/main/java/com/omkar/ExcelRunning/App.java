package com.omkar.ExcelRunning;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.*;

public class App 
{
    public static void main( String[] args ) throws IOException	
    {
//    	String excel_path = "D:\\Full Stack\\New Learning\\codingtesticonnectjava\\a.xlsx";
//    	FileInputStream fis = new FileInputStream(excel_path);
//    	
//    	XSSFWorkbook workbook = new XSSFWorkbook(fis);
//    	XSSFSheet sheet = workbook.getSheetAt(0);
//    	int rows = sheet.getLastRowNum();
//    	short cols = sheet.getRow(1).getLastCellNum();
//    	for(int r=1; r<=rows;r++) 
//    	{
//    		XSSFRow row = sheet.getRow(r);
//    		for(int c=0; c<cols;c++) 
//    		{
//    			XSSFCell cell = row.getCell(c);
//    			switch(cell.getCellType()) {
//    			
//    			case STRING: System.out.print(cell.getStringCellValue());break;
//    			case NUMERIC: System.out.print(cell.getNumericCellValue());break;
//    			case BOOLEAN: System.out.print(cell.getBooleanCellValue());break;
//    			
//    			}
//    				System.out.print(" | ");
//    		}
//    		System.out.println();
//    	}
    	
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter the file name :");
    	String filename = sc.nextLine();
    	
    	List<CSVEntity1> load = LoadObjectList.load(CSVEntity1.class, filename);
    	System.out.println(load.size());
    	load.forEach(System.out::println);
    	System.out.println("file loaded successfully");
    }
}
