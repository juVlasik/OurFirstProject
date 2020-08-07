package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.BrowserUtilities;
import utilities.Driver;

public class HotelsBookingPage {

	public HotelsBookingPage() {
		PageFactory.initElements(Driver.getDriver(), this);

	}

	@FindBy(id = "primary-header-hotel")
	public WebElement buttonHotels;

	@FindBy(xpath = "//*[text()='Hotel stays, dream getaways']")
	public WebElement textHotelPage;

	@FindBy(xpath = "//button[@aria-label='Going to']")
	public WebElement hotelIstanbul;
	
	@FindBy(css = ".uitk-typeahead-results.no-bullet li button")
	List<WebElement> dropDownGoTo;
	@FindBy(id = "d1-btn")
	public WebElement checkInDateCalendar;
	

	public void verifyLandingHotelsPage() {

		buttonHotels.click();

		BrowserUtilities.waitFor(5);

		textHotelPage.isDisplayed();
		textHotelPage.getText().contentEquals("Hotel stays, dream getaways");
		System.out.println(textHotelPage.getText() + " IS DISPLAYED!");
	}

	public void searchHotelIstanbul() {

		hotelIstanbul.sendKeys(" Istanbul");
		
		BrowserUtilities.waitFor(5);
		
		
		dropDownGoTo.get(1).click();

		BrowserUtilities.waitFor(3);
		
		checkInDateCalendar.click();
        BrowserUtilities.waitFor(10);
	}
}
