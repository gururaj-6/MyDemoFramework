package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class EnterTimeTrackPage {

	@FindBy(id="logoutLink")
	private WebElement logoutLink;
	
	public EnterTimeTrackPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean VerifyHomePageDisplayed(WebDriverWait wait)
	{
		try {
		wait.until(ExpectedConditions.visibilityOf(logoutLink));
		Reporter.log("The Login is Successfull and Home page is displayed", true);
		return true;
		}
		catch (Exception e)
		{
			Reporter.log("The Login is failed", true);
			return false;
		}
	}
	
}
