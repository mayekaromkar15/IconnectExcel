package com.omkar.ExcelRunning;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVReaderTest {
	


	public static void main(String[] args) throws IOException {
		
		String path = "D:\\Full Stack\\New Learning\\codingtesticonnectjava\\cm29JAN2020bhav.csv";
		String line = "";
		
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		
		while((line = br.readLine())!= null) {
			String [] values = line.split(",");
			System.out.println(values[0]);
			
		}
	}
	
	
}
