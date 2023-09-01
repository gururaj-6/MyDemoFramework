package generic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
	public WebDriver driver;
	public WebDriverWait wait;
	
	@Parameters({"browser","url", "timeout"})
	@BeforeMethod
	public void openApp(String browser, String url, String timeout)
	{
		Reporter.log("Open the Browser"+browser, true);
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver= new ChromeDriver();
		}
		else
			{
			driver= new FirefoxDriver();
			}
		Reporter.log("Maximize the Browser", true);
		driver.manage().window().maximize();
		
		Reporter.log("Enter the URL"+url, true);
		driver.get(url);
		
		Reporter.log("Set the Implicit and Explicit Timeout"+timeout, true);
		long intTimeOut=Long.parseLong(timeout);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(intTimeOut));	
		wait= new WebDriverWait(driver, Duration.ofSeconds(intTimeOut));
	}
	
	@AfterMethod
	public void closeApp()
	{
		driver.quit();
	}
}
