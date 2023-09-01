package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class LoginPage {

	@FindBy(id="username")
	private WebElement unTB;
	
	@FindBy(name="pwd")
	private WebElement pwTB;
	
	@FindBy(id="loginButton")
	private WebElement loginBtn;
	
	@FindBy(xpath="//span[contains(text(), 'invalid')]")
	private WebElement errMsg;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void setUserName(String un)
	{
		unTB.sendKeys(un);
	}
	
	public void setPassword(String pw)
	{
		pwTB.sendKeys(pw);
	}
	
	public void ClickLogin()
	{
		loginBtn.click();
	}
	
	public boolean VerifyErrorMessage(WebDriverWait wait)
	{
		try {
		wait.until(ExpectedConditions.visibilityOf(errMsg));
		Reporter.log("The Error message is displayed", true);
		return true;
	}
		catch (Exception e) {
			Reporter.log("The Error message is Not displayed", true);
			return false;
		}
	}
}
