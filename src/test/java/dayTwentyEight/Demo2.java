package dayTwentyEight;

//Working with Excel file

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Demo2 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	
		String path = "./data/Selenium.xlsx";
		Workbook wb = WorkbookFactory.create(new File(path));  //Open the Excel File
		Sheet s1 = wb.getSheet("sheet1");
		Row r1 = s1.getRow(0);
		Cell c1 = r1.getCell(0);
		
		String val = c1.getStringCellValue();
		System.out.println(val);
		wb.close();
	}

}
