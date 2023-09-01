package generic;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {

	public static String getData(String path,String sheet,int row,int col)
	{
		String val="";
		try
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			val = wb.getSheet(sheet).getRow(row).getCell(col).getStringCellValue();
		}
		catch (Exception e)
		{
			System.out.println("Catch Block");
		}
		return val;
	}
}
