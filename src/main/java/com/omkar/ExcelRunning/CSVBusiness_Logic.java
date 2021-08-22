package com.omkar.ExcelRunning;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.opencsv.CSVReader;

public  class CSVBusiness_Logic {

	public static List<CSVEntity1> m1(String path) {
//		System.out.println("Inside business logic..");
		CSVReader reader = null;
		List<CSVEntity1> lst = new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-y");
//		System.out.println(path);
		try {
//parsing a CSV file into CSVReader class constructor  
//			reader = new CSVReader(new FileReader("D:\\Full Stack\\Java\\java 2\\ExcelRunning\\CSVFiles\\cm30JAN2020bhav.csv"));
			reader = new CSVReader(new FileReader(path));
			
			String[] nextLine;
			
//reads one line at a time  
			reader.readNext();
			while ((nextLine = reader.readNext()) != null) {
//				System.out.println(formatter);
				String[] dateArr= nextLine[10].split("-");
				if(dateArr[2].length() > 3) {
					dateArr[2] = dateArr[2].substring(2,4);
				}
				dateArr[1] = dateArr[1].substring(0,1).toUpperCase() + dateArr[1].substring(1,3).toLowerCase();
//				System.out.println(String.join("-", dateArr));
			
				String ts = String.join("-", dateArr);
//				System.out.println(ts);
				LocalDate timestamp = LocalDate.parse(ts, formatter);
//				System.out.println(timestamp);
				CSVEntity1 entity = new CSVEntity1(nextLine[0], nextLine[1], 
						Double.parseDouble(nextLine[2]), Double.parseDouble(nextLine[3]),
						Double.parseDouble(nextLine[4]), Double.parseDouble(nextLine[5]), 
						Double.parseDouble(nextLine[6]), Double.parseDouble(nextLine[7]),
						Integer.parseInt(nextLine[8]), Double.parseDouble(nextLine[9]),
						timestamp, Integer.parseInt(nextLine[11]), nextLine[12]);
				entity.setRANGE(entity.getHIGH() - entity.getLOW());
				
				lst.add(entity);
			}
			
			List<CSVEntity1> sortedList = 
					lst.stream().sorted((a, b)->(a.getSYMBOL().compareTo(b.getSYMBOL()))).collect(Collectors.toList());
//			System.out.println(sortedList.size());
			double tempTotal = 0.0;
			for(int i = 0; i<sortedList.size();i++) {
				//System.out.println(sortedList.get(i));
				CSVEntity1 tempEntity = sortedList.get(i);
				if(i==0) {
					tempTotal = tempEntity.getRANGE();
					tempEntity.setRunningTotal(tempTotal);
				} else {
					if(tempEntity.getSYMBOL().equals(sortedList.get(i-1).getSYMBOL())) {
						tempTotal += sortedList.get(i).getRANGE();
						tempEntity.setRunningTotal(tempTotal);
					} else {
						tempTotal = tempEntity.getRANGE();
						tempEntity.setRunningTotal(tempTotal);
					}
				}
				
			}
			
//			for(int i = 0; i<sortedList.size();i++) {
////				System.out.println(sortedList.get(i));
//			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lst;
		
	}
	
	public static void CsvWriter(List<CSVEntity1> lst, String path) throws IOException {
		String comma_delimiter = ",";
		String new_line_seperator = "\n";
		String file_header = "SYMBOL,SERIES,OPEN,HIGH,LOW,CLOSE,LAST,PREVCLOSE,TOTTRDQTY,dTOTTRDVAL,TIMESTAMP,TOTALTRADES,ISIN,RANGE,runningTotal";
		FileWriter filewriter = new FileWriter(path);
		filewriter.append(file_header);
		for(CSVEntity1 e: lst) {
			filewriter.append("\n");
			filewriter.append(e.getSYMBOL());
			filewriter.append(comma_delimiter);
			filewriter.append(e.getSERIES());
			filewriter.append(comma_delimiter);
			filewriter.append(String.valueOf(e.getOPEN()));
			filewriter.append(comma_delimiter);
			filewriter.append(String.valueOf(e.getHIGH()));
			filewriter.append(comma_delimiter);
			filewriter.append(String.valueOf(e.getLOW()));
			filewriter.append(comma_delimiter);
			filewriter.append(String.valueOf(e.getCLOSE()));
			filewriter.append(comma_delimiter);
			filewriter.append(String.valueOf(e.getLAST()));
			filewriter.append(comma_delimiter);
			filewriter.append(String.valueOf(e.getPREVCLOSE()));
			filewriter.append(comma_delimiter);
			filewriter.append(String.valueOf(e.getTOTTRDQTY()));
			filewriter.append(comma_delimiter);
			filewriter.append(String.valueOf(e.getTOTTRDVAL()));
			filewriter.append(comma_delimiter);
			filewriter.append(String.valueOf(e.getTIMESTAMP()));
			filewriter.append(comma_delimiter);
			filewriter.append(String.valueOf(e.getTOTALTRADES()));
			filewriter.append(comma_delimiter);
			filewriter.append(e.getISIN());
			filewriter.append(comma_delimiter);
			filewriter.append(String.valueOf(e.getRANGE()));
			filewriter.append(comma_delimiter);
			filewriter.append(String.valueOf(e.getRunningTotal()));
			filewriter.append(comma_delimiter);
			
		}
		
		filewriter.flush();
		filewriter.close();
	}
	
	
}
