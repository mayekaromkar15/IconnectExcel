package com.omkar.ExcelRunning;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReadCSVExample3 {
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		String directory = System.getProperty("user.dir");
		String additionalFolder = "CSVFiles";
		String outputFolder = "OutputCsv";
		String path="";
		String path1 = "";
		
		path = directory+File.separator+additionalFolder;
		path1 = directory+File.separator+outputFolder;
		System.out.println("==================================================\n");
		
		
		File files = new File(path);
		try {
			if(files.mkdir()) 
			{
//				System.out.println("Input folder path created...");
			}
			else 
			{
//				System.out.println("Folder already exists");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		File outFile = new File(path1);
		try {
			if(outFile.mkdir()) {
//				System.out.println("Output folder path created...");
			}
			else {
//				System.out.println("File already exists");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("Place your file in the below path before proceeding:-- "+path);
		
		System.out.println("Press any key and enter to proceed");
		sc.nextLine();
		List<String> fileList = viewcontentindir(path);
		
		List<CSVEntity1> entityList = new ArrayList<>();
		for(String s:fileList) {
			List<CSVEntity1> tempList = CSVBusiness_Logic.m1(path+File.separator+s);
			entityList.addAll(tempList);
		}
		
		System.out.println(entityList.size());
		
		List<CSVEntity1> finalList = 
				entityList.stream().sorted((a, b)->(a.getTIMESTAMP().compareTo(b.getTIMESTAMP()))).collect(Collectors.toList());
		
		CSVBusiness_Logic.CsvWriter(finalList, path1+File.separator+"output.csv");
		
//		String path = sc.nextLine();
//		
//		 System.out.println(new File(".").getCanonicalPath());
		System.out.println("You will find the output file on the below path :--"+path1);
	}
	
	public static List<String> viewcontentindir(String path) {
		File f = new File(path);
//		System.out.println("-------------------------------------------------");
		int count = 0;
		String[] s = f.list();
		List<String> csvFiles = new ArrayList<>();
//		System.out.println(s);
		for(String s1:s) {
			if(s1.endsWith(".csv")) {
//				System.out.println("Text Document : "+s1) 
				csvFiles.add(s1);
				count++;
//				System.out.println(path+File.separator+s1);
			}
			
			
		}
		System.out.println("==================================================");
		System.out.println("The total number of files present are : "+count);
		System.out.println("==================================================");;
		
//		
//		for (int i =0;i<count;i++) {
//			
//		}
		return csvFiles;
	}
	
}