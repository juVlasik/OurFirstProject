package pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.Driver;

public class CarRentalPage {

	
public  CarRentalPage() {
		
		PageFactory.initElements(Driver.getDriver(), this); // This statement is initializing the variables that are tagged
															//with @FindBy annotations
		
	}
	

	
	@FindBy(xpath = "//span[@class='full-price bold ']")
	public List<WebElement> priceList;
	
	@FindBy(xpath = "//span[@id='filter-carClass-economy-label']")
	public WebElement economyCheckbox;
	
//	@FindBy(id = "filter-carClass-economy-label")
//	public WebElement economyCheckbox;
	
	
	@FindBy(xpath = "//span[@class='distance large-screen-only tablet-only']")
	public List<WebElement> distance;
	
	@FindBy (xpath = "//input[@id='carClass-premium']")
	public WebElement premiumCheckbox;
	
	@FindBy (xpath = "//button[@aria-label='Sort by: Customer Rating']")
	public WebElement customerRatingButton;
	
	
	
	
}

      