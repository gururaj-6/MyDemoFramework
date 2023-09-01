package dayTwentyEight;
//Working with Excel file code2
//Handling Exception for BLANK Rows and BLANK Cells

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Demo4 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	
		String path = "./data/Selenium.xlsx";
		Workbook wb = WorkbookFactory.create(new File(path));  //Open the Excel File
		int rc = wb.getSheet("Versions").getLastRowNum();
		
		for(int i=0; i<=rc; i++)
		{
			try {
					int cc = wb.getSheet("Versions").getRow(i).getLastCellNum();
					for(int j=0; j<cc; j++)
					{
						try
						{
							String val = wb.getSheet("Versions").getRow(i).getCell(j).getStringCellValue();
							System.out.println(val+" ");
						}
						catch (NullPointerException e)
						{
							System.out.println("--");
						}
						
					}
				}
			catch (NullPointerException e)
			{
				System.out.println("== ==");
			}
			System.out.println();
		}
	wb.close();
	}
}