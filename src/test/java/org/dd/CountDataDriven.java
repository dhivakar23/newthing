package org.dd;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellAlignment;

public class CountDataDriven {
	public static void main(String[] args) throws IOException {
		File f=new File("C:\\DataDriven\\excel\\datadriven.xlsx");
		FileInputStream fis=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fis);
		
		Sheet st = w.getSheet("count");
		int count = 0;
		for (int i = 0; i < st.getPhysicalNumberOfRows(); i++) {
			Row rw = st.getRow(i);
			int cl = rw.getPhysicalNumberOfCells();
			count=count+cl;
				
			}
		System.out.println(count);
	}
}
