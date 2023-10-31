package testscripts.regression;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.UtilKit;

public class LoginTestDataProviderExcel extends BaseTest{
	
	
		
	@Test(dataProvider="getData")
	public void loginTest1(HashMap<String, String> dataMap)
	{
		
		driver.findElement(By.name("username")).sendKeys(dataMap.get("username"));
		driver.findElement(By.name("password")).sendKeys(dataMap.get("password"));
		driver.findElement(By.name("login")).click();
		
		Assert.assertEquals(driver.getTitle(), dataMap.get("Expected Title"));
		
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		
		
		
		Object[][] data=new Object[1][1];
		
		
		data[0][0]= UtilKit.getTestData("TC-100");
	
		
		
		return data;
		
	}
	
	

}
