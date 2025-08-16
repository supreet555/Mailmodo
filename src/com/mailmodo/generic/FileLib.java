package com.mailmodo.generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
	public String getPropertyData(String key) throws IOException {
		String path = "./data/commondata.property";
		FileInputStream fin = new FileInputStream(path);
		Properties p = new Properties();
		p.load(fin);
		String data = p.getProperty(key);
		return data;
	}
	
	public String getExcelData(String sheetName, int row, int cell) throws EncryptedDocumentException, IOException {
		String path = "./data/testscript.xlsx";
		FileInputStream fin = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fin);
		String data = wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();;
		return data;
	}
	
	public void setExcelData(String sheetName, int row, int cell, String data) throws EncryptedDocumentException, IOException {
		String path = "./data/testscript.xlsx";
		FileInputStream fin = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fin);
		wb.getSheet(sheetName).getRow(row).getCell(cell).setCellValue(data);
		FileOutputStream fout = new FileOutputStream(path);
		wb.write(fout);
	}
}
