package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import pages.EnterTimeTrackPage;
import pages.LoginPage;

public class ValidLogin extends BaseTest{

	@Test
	public void testValidLogin()
	{	//Get the Test Data
		String un = Excel.getData("./data/input.xlsx", "ValidLogin", 1, 0);
		String pw = Excel.getData("./data/input.xlsx", "ValidLogin", 1, 1);
		
		//1.Enter valid Username
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName(un);
		
		//2.Enter valid password
		loginPage.setPassword(pw);
		
		//3.Click on ‘Login’ button
		loginPage.ClickLogin();
		
		//4.Verify Home page is displayed.
		EnterTimeTrackPage ett = new EnterTimeTrackPage(driver);
		boolean result = ett.VerifyHomePageDisplayed(wait);
		Assert.assertEquals(result, true);
	}
}
