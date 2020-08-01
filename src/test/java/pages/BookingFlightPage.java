package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class BookingFlightPage {
	
	
public  BookingFlightPage() {
		
		PageFactory.initElements(Driver.getDriver(), this); // This statement is initializing the variables that are tagged
															//with @FindBy annotations
		
	}

	@FindBy (xpath = "//input[@id='airlineRowContainer_AF']")
	public WebElement airfranceChBox;
	
	@FindBy (xpath = "//tr[2]//td[@data-test-id='flexible-search-cell']")
	public List<WebElement> flightPrices;
	
	@FindBy (xpath = "//select[@id='sortDropdown']")
	public WebElement sortMenuButton;
	
	@FindBy (xpath = "//input[@value='Kyiv, Ukraine (IEV)']")
	public WebElement arrivalAirport;
	
	@FindBy (xpath = "//input[@value='Washington, DC, United States (DCA)']")
	public WebElement departureAirport;
	
	@FindBy (xpath = "//a[@data-click-handler='forcedChoiceNoThanks']")
	public WebElement noThanksButton;
	
	@FindBy (xpath = "(//button[@class='btn-secondary btn-action t-select-btn'])[1]")
	public WebElement selectButton;
	
}
