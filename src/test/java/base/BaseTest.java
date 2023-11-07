package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import extentreports.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	public FileInputStream fis;
	public static Properties configProperties;
	public FileInputStream fis2;
	public static Properties locatorProperties;
	
	public static ExtentReports reports;
	
	public static ExtentTest test;
	
	
	@BeforeTest
	public void beforeTest() throws IOException
	{
		fis=new FileInputStream("src\\test\\resources\\properties\\config.properties");
		configProperties=new Properties();
		configProperties.load(fis);
		
		fis2=new FileInputStream("src\\test\\resources\\properties\\locators.properties");
		locatorProperties=new Properties();
		locatorProperties.load(fis2);
		
		reports=ExtentManager.getReports();
		
	}
	
	@AfterTest
	public void closeReports()
	{
		reports.flush();
	}
	
	@BeforeMethod
	public void setUp(ITestContext context)
	{
		test=reports.createTest(context.getCurrentXmlTest().getName());
		
		String browserName=configProperties.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			test.info("Chrome browser started");
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
		
		test.info("Applictaion is launched using url "+configProperties.getProperty("url"));
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(configProperties.getProperty("implicitWait"))));
		
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
