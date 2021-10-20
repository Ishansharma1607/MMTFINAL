package com.makemytrip;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class sampleExcel {
	
	public static void main(String[] args) throws IOException {

	
	FileInputStream fs = new FileInputStream("src\\test\\resources\\Data1.xlsx");
	//Creating a workbook
	XSSFWorkbook workbook = new XSSFWorkbook(fs);
	XSSFSheet sheet = workbook.getSheetAt(1);
	Row row = sheet.getRow(0);
	Cell cell = row.getCell(0);
	System.out.println(sheet.getRow(1).getCell(0));
	System.out.println(sheet.getRow(1).getCell(1));
	System.out.println(sheet.getRow(1).getCell(4));
	System.out.println(sheet.getRow(1).getCell(5));






	}

}
