package oct28th;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppLaunch {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp() throws IOException
	{
		
		//WebDriverManager.chromedriver().setup();
		//driver=new ChromeDriver();
		
		//WebDriverManager.firefoxdriver().setup();
		//driver=new FirefoxDriver();
		
		FileInputStream fis=new FileInputStream("Properties\\config.properties");
		Properties pr=new Properties();
		pr.load(fis);
		
		String browserName=pr.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		else if(browserName.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}
		else if(browserName.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			
		}
		
		driver.get(pr.getProperty("url"));
		driver.manage().window().maximize();
		
	}

	@Test
	public void appLaunch()
	{
		
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}
	
}
