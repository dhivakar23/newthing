package org.dd;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetdataFromXel {
	public static String main(String[] args) throws IOException {
		File f=new File("C:\\DataDriven\\excel\\datadriven.xlsx");
		FileInputStream fis=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fis);
		Sheet oldSheet = w.getSheet("details");
		Row oldRow = oldSheet.getRow(1);
		Cell oldCell = oldRow.getCell(3);
		int type = oldCell.getCellType();
		String value="";
		if(type==1) {
			value = oldCell.getStringCellValue();
			System.out.println(value);
		}else if(DateUtil.isCellDateFormatted(oldCell)) {
			 Date dateValue  = oldCell.getDateCellValue();
			 SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yy");
			 value=sdf.format(dateValue);
			 System.out.println(value);
		}
		else {
			double d=oldCell.getNumericCellValue();
			long l=(long)d;
			value = String.valueOf(1);
			System.out.println(value);
			}
		
		return value;
		
		
	}
}