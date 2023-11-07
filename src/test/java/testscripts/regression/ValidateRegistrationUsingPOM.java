package testscripts.regression;

import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.RegistrationPage;
import utils.UtilKit;

public class ValidateRegistrationUsingPOM extends BaseTest {
	
	@Test(dataProvider = "getData")
	public void validateRegistrationTest(HashMap<String, String> dataMap) throws InterruptedException
	{
		
		//LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		
		LoginPage loginPage=new LoginPage();
		
		loginPage.registrationLink();
		
		Thread.sleep(3000);
		
		RegistrationPage registrationPage=new RegistrationPage();
		
		registrationPage.validateTitle(dataMap.get("Expected Title"));
		
		registrationPage.usernameTextbox(dataMap.get("Username"));
		
		Assert.assertTrue(false);
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[1][1];
				
		data[0][0]=UtilKit.getTestData("TC-101");
		
		return data;
		
	}


}
