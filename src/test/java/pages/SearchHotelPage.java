package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SearchHotelPage extends BasePage {
	
	@FindBy(xpath="//select[@name='location']")
	WebElement locationDropdown;
	
	@FindBy(xpath="//select[@name='hotels']")
	WebElement hotelDropdown;
	
	@FindBy(xpath="//select[@name='room_type']")
	WebElement roomTypeDropdown;
	
	@FindBy(xpath="//select[@name='room_nos']")
	WebElement noOfRoomsDropdown;
	
	@FindBy(xpath="//input[@name='datepick_in']")
	WebElement checkInDateTextbox;
	
	@FindBy(xpath="//input[@name='datepick_out']")
	WebElement checkOutDateTextbox;
	
	@FindBy(xpath="//select[@name='adult_room']")
	WebElement adultsPerRoomDropdown;
	
	@FindBy(xpath="//select[@name='child_room']")
	WebElement childrenPerRoomDropdown;
	
	public void locationDropdown(String option)
	{
		new Select(locationDropdown).selectByVisibleText(option);
	}
	
	public void hotelDropdown(String option)
	{
		new Select(hotelDropdown).selectByVisibleText(option);
	}
	
	public void roomTypeDropdown(String option)
	{
		new Select(roomTypeDropdown).selectByVisibleText(option);
	}
	
	public void noOfRoomsDropdown(String option)
	{
		new Select(noOfRoomsDropdown).selectByVisibleText(option);
	}
	
	public void adultsPerRoomDropdown(String option)
	{
		new Select(adultsPerRoomDropdown).selectByVisibleText(option);
	}
	
	public void childrenPerRoomDropdown(String option)
	{
		new Select(childrenPerRoomDropdown).selectByVisibleText(option);
	}
	
	public void checkInDateTextbox(String date)
	{
		checkInDateTextbox.clear();
		
		checkInDateTextbox.sendKeys(date);
	}
	
	public void checkOutDateTextbox(String date)
	{
		checkInDateTextbox.clear();
		
		checkInDateTextbox.sendKeys(date);
	}

}
