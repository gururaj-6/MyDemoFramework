package dayTwentyEight;
/*
 * Reading from Excel
 * Using Excel data in Selenium coding
 * Writing data back to Excel and saving Excel
 * 
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Demo5 {
	public static void main(String[] args) throws EncryptedDocumentException, FileNotFoundException, IOException
	{
		//Reading from Excel
		Workbook wb = WorkbookFactory.create(new FileInputStream("./data/Selenium.xlsx"));
		String un = wb.getSheet("login").getRow(0).getCell(0).getStringCellValue();
		String pw = wb.getSheet("login").getRow(0).getCell(1).getStringCellValue();
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://demo.actitime.com/login.do");
		
		//Using Excel data in Selenium coding
		driver.findElement(By.id("username")).sendKeys(un);
		driver.findElement(By.name("pwd")).sendKeys(pw);
		driver.findElement(By.id("loginButton")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.titleContains("Enter"));
		String actualTitle= driver.getTitle();
		driver.quit();
		
		//Writing Data back to Excel
		wb.getSheet("login").getRow(0).createCell(2).setCellValue(actualTitle);
		wb.write(new FileOutputStream("./data/Selenium.xlsx")); //Saving Excel 
		wb.close();	
		
	}
}
