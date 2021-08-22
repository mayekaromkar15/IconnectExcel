package com.omkar.ExcelRunning;

import java.util.*;

import org.springframework.core.io.ClassPathResource;

import java.io.File;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class LoadObjectList {
	
	static String path = "D:\\Full Stack\\Java\\java 2\\ExcelRunning\\root";
	
	public static List<CSVEntity1> load(Class<CSVEntity1> type, String fileName) 
	{
	    try {
	        CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
	        CsvMapper mapper = new CsvMapper();
	        File file = new ClassPathResource(path+fileName).getFile();
	        System.out.println(file);
	        MappingIterator<CSVEntity1> readValues = 
	          mapper.reader(type).with(bootstrapSchema).readValues(file);
	        return readValues.readAll();
	    } catch (Exception e) {
	    	System.out.println(e);
	        return Collections.emptyList();
	    }
	}
	
}
