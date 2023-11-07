package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BasePage {
	
	public RegistrationPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//input[@name='username']")
	WebElement usernameTextbox;
	
	public void usernameTextbox(String text)
	{
		usernameTextbox.sendKeys(text);
	}

}
