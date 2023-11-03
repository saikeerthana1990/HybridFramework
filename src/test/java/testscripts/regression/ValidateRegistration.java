package testscripts.regression;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import keywords.ApplicationKeywords;
import utils.UtilKit;

public class ValidateRegistration extends BaseTest {
	
	@Test(dataProvider = "getData")
	public void validateRegistrationTest(HashMap<String, String> dataMap) throws InterruptedException
	{
		ApplicationKeywords app=new ApplicationKeywords();
		
		app.openBrowser();
		
		app.launchApp();
		
		app.click("newUserRegisterLink_linktext");
		
		Thread.sleep(3000);
		
		//Assert.assertTrue(false);
		app.validateTitle(dataMap.get("Expected Title"));
		
		app.type("register_username_textbox", dataMap.get("Username"));
		app.type("register_password_textbox", dataMap.get("Password"));
		app.type("register_confirmPassword_textbox", dataMap.get("Confirm Password"));
		app.type("register_fullName_textbox", dataMap.get("Full Name"));
		app.type("register_email_textbox", dataMap.get("Email Address"));
		app.type("register_captcha_textbox", dataMap.get("Captcha Text"));
		app.click("register_termsAndConditions_checkbox");
		app.click("register_button");
		
		Thread.sleep(3000);
		
		app.close();
		
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[1][1];
				
		data[0][0]=UtilKit.getTestData("TC-101");
		
		return data;
		
	}

}
