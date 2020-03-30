package EXCEL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_excel {
	public static  String[][] testdata=new String[1][15];
	public static int r,c;
	
	public String[][] get_data()  {
		
	String filepath="C:\\Users\\V.GIRI BABU\\eclipse-workspace\\Jpetstore_845097_Giribabuv\\Excelfile\\jpetstore.xlsx";	
	String sheetnum="Sheet1";	
	File f=new File(filepath);
	FileInputStream fis;
	try {
		fis = new FileInputStream(f);
	
	XSSFWorkbook wb = null;
	try {
		wb = new XSSFWorkbook(fis);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	XSSFSheet sh=wb.getSheet(sheetnum);
	for(r=0;r<1;r++) {
	XSSFRow row=sh.getRow(r);
	for(c=0;c<15;c++) {

	XSSFCell cell =row.getCell(c);
	testdata[r][c]=cell.getStringCellValue();
   	System.out.println(testdata[r][c]);
   	
	}
	}
	
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	
	
	return testdata;
	}

}
