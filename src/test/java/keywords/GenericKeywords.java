package keywords;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GenericKeywords extends BaseTest {

	public void openBrowser() {

		String browserName = configProperties.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
	}
	
	public void launchApp()
	{
		driver.get(configProperties.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(configProperties.getProperty("implicitWait"))));
	}
	
	public WebElement getElement(String locatorKey)
	{
		WebElement element=null;
		
		element=driver.findElement(getLocator(locatorKey));
		
		
		return element;
		
	}
	
	public By getLocator(String locatorKey)
	{
		By by=null;
		
		if(locatorKey.endsWith("_id"))
		{
			by=By.id(locatorProperties.getProperty(locatorKey));
		}
		else if(locatorKey.endsWith("_name"))
		{
			by=By.name(locatorProperties.getProperty(locatorKey));
		}
		else if(locatorKey.endsWith("_linktext"))
		{
			by=By.linkText(locatorProperties.getProperty(locatorKey));
		}
		else if(locatorKey.endsWith("_xpath"))
		{
			by=By.xpath(locatorProperties.getProperty(locatorKey));
		}
		else
		{
			by=By.xpath(locatorProperties.getProperty(locatorKey));
		}
		
		return by;
		
	}
	
	public void click(String locatorKey)
	{
		getElement(locatorKey).click();
	}
	
	public void clear(String locatorKey)
	{
		getElement(locatorKey).clear();
	}
	
	public void type(String locatorKey, String text)
	{
		getElement(locatorKey).sendKeys(text);
	}
	
	public void selectOptionFromDropdown(String locatorKey,String option)
	{
		new Select(getElement(locatorKey)).selectByVisibleText(option);
	}

	public void close()
	{
		driver.quit();
	}
}
