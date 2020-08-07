package pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
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
	@FindBy(css =".uitk-new-date-picker-weeks tbody tr td button")
	List <WebElement> calendarDates;
	@FindBy(xpath = "//span[text()='Done']")
	public WebElement buttonDone;
    @FindBy(xpath = ".//*[@id=\"wizard-hotel-pwa-v2-1\"]/div[4]/div/button")
    public WebElement clickSearchButton;
    @FindBy(id = "sort")
    public WebElement sortBy;
    @FindBy(xpath = "//*[@id=\"sort\"]/option[2]")
    public WebElement sortByprice;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div/div/div/div[1]/main/div[2]/div/div[1]/section/form/fieldset[1]/div/div/button")
    public WebElement searchByPropertyName;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/header/section/div/input")
    public WebElement searchByPropertyNameWindow;
    @FindBy(xpath = "//*[text()='Your filter options are not showing a match.']")
	public WebElement displayedNotification;
    public void verifyLandingHotelsPage() {

		buttonHotels.click();

		BrowserUtilities.waitFor(5);

		textHotelPage.isDisplayed();
		textHotelPage.getText().contentEquals("Hotel stays, dream getaways");
		System.out.println(textHotelPage.getText() + " IS DISPLAYED!");
	}

	public void searchHotelIstanbul() {

		hotelIstanbul.sendKeys(" Istanbul");
		
		BrowserUtilities.waitFor(3);
		
		dropDownGoTo.get(1).click();

		BrowserUtilities.waitFor(3);
		
		checkInDateCalendar.click();
        BrowserUtilities.waitFor(3);
        
	}
	
	public void pickCheckinDate() {
		
		
		for (WebElement date:calendarDates) {
			if (date.getAttribute("data-day").contains("20")) {
				
				date.click();
				
				break;
			}
		}
		System.out.println("User picked the August 20th 2020 as a check in date ");
		
	}
	
public void pickCheckoutDate() {
		
		for (WebElement date:calendarDates) {
			if (date.getAttribute("data-day").contains("27")) {
				
				date.click();
				
				break;
			}
			
			
		}
		
		System.out.println("User picked the August 27th 2020 as a check out date ");
	}
public void sortByButton() {
	 sortBy.click();
     sortByprice.click();
     BrowserUtilities.waitFor(5);
    
}
public void searchByProperty() {
	searchByPropertyName.click();
	searchByPropertyNameWindow.sendKeys("Marriott"+ Keys.ENTER);
    BrowserUtilities.waitFor(5);
    
    if (displayedNotification.isDisplayed()) {
	System.out.println(displayedNotification.getText());	
	}
    else {
    	
    }System.out.println("Marriott displayed in listed options!");
}
}
