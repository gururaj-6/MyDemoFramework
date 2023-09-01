package dayTwentyEight;
//Working with Excel file code2
//Retriveing values from Rows and Cells 

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Demo3 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	
		String path = "./data/Selenium.xlsx";
		Workbook wb = WorkbookFactory.create(new File(path));  //Open the Excel File
		
		for(int i=0; i<4; i++)
		{
			for(int j=0; j<2; j++)
			{
				String val = wb.getSheet("Versions").getRow(i).getCell(j).getStringCellValue();
				System.out.println(val+" ");
			}
			System.out.println();
		}
		wb.close();
	}
}