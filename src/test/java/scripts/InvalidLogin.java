package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import pages.LoginPage;

public class InvalidLogin extends BaseTest {
	
	@Test(priority=2)
	public void testInvalidLogin() {
		
		String un = Excel.getData("./data/input.xlsx", "InvalidLogin", 1, 0);
		String pw = Excel.getData("./data/input.xlsx", "InvalidLogin", 1, 1);
		
		//1.Enter invalid Username
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName(un);
		
		//2.Enter invalid password
		loginPage.setPassword(pw);
		
		//3.Click on ‘Login’ button
		loginPage.ClickLogin();
		
		//4.Verify Error message is displayed.
		boolean result = loginPage.VerifyErrorMessage(wait);
		Assert.assertEquals(result, true);
		
	}

}
