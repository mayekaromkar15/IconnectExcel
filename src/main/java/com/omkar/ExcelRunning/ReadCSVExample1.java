package com.omkar.ExcelRunning;

import java.io.File;
import java.util.Scanner;

public class ReadCSVExample1 {
	public static void main(String[] args) throws Exception {
//parsing a CSV file into Scanner class constructor  
		Scanner sc = 
		new Scanner
		(new File("D:\\Full Stack\\New Learning\\codingtesticonnectjava\\cm29JAN2020bhav.csv"));
		sc.useDelimiter(","); // sets the delimiter pattern
		while (sc.hasNext()) // returns a boolean value
		{
			System.out.print(sc.next()); // find and returns the next complete token from this scanner
		}
		sc.close(); // closes the scanner
	}
}