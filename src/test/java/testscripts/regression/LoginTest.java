package testscripts.regression;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest extends BaseTest{
	
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		String browserName=configProperties.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		} 
		else if(browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		} 
		
		driver.get(configProperties.getProperty("url"));
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(configProperties.getProperty("implicitWait"))));
		
	}
	
	
	@Test
	public void loginTest1()
	{
		
		driver.findElement(By.name("username")).sendKeys("reyaz009");
		driver.findElement(By.name("password")).sendKeys("reyaz123");
		driver.findElement(By.name("login")).click();
		
		Assert.assertEquals(driver.getTitle(), "Adactin.com - Search Hotel");
		
	}
	
	@Test
	public void loginTest2()
	{
		
		driver.findElement(By.name("username")).sendKeys("reyaz009");
		driver.findElement(By.name("password")).sendKeys("reyaz456");
		driver.findElement(By.name("login")).click();
		
		Assert.assertEquals(driver.getTitle(), "Adactin.com - Hotel Reservation System");
		
	}
	
	@Test
	public void loginTest3()
	{
		
		driver.findElement(By.name("username")).sendKeys("reyaz1245");
		driver.findElement(By.name("password")).sendKeys("reyaz123");
		driver.findElement(By.name("login")).click();
		
		Assert.assertEquals(driver.getTitle(), "Adactin.com - Hotel Reservation System");
		
	}
	
	@Test
	public void loginTest4()
	{
		
		driver.findElement(By.name("username")).sendKeys("reyaz1245");
		driver.findElement(By.name("password")).sendKeys("reyaz456");
		driver.findElement(By.name("login")).click();
		
		Assert.assertEquals(driver.getTitle(), "Adactin.com - Hotel Reservation System");
		
	}
	
	@AfterMethod
	public void teardown()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}

}
