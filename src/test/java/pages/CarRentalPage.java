package pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.Driver;

public class CarRentalPage{

	
public  CarRentalPage() {
		
		PageFactory.initElements(Driver.getDriver(), this); // This statement is initializing the variables that are tagged
															//with @FindBy annotations
		
	}
	
@FindBy(xpath = "//span[@class='full-price bold ']")
public List<WebElement> priceList;

@FindBy(xpath = "//span[@class='full-price bold ']")
public List<WebElement> sortedPriceList;

//@FindBy (xpath = "//span[contains(text(), \"Total Price\")]")   
//public WebElement totalPriceButton;

@FindBy (xpath = "(//button[@class='btn-sort tab'])[1]")   
		public WebElement totalPriceButton;

@FindBy(xpath = "//span[@id='filter-carClass-economy-label']")
public WebElement economyCheckbox;


@FindBy(xpath = "//span[@class='distance large-screen-only tablet-only']")
public List<WebElement> distance;

@FindBy (xpath = "//div[@class='img-review-container']")
public List<WebElement> rating;

@FindBy (xpath = "//input[@id='carClass-premium']")
public WebElement premiumCheckbox;

@FindBy (xpath = "//button[@aria-label='Sort by: Customer Rating']")
public WebElement customerRatingButton;

@FindBy (xpath = "//a[@data-book-button='book-ET-XX-Car']")
public WebElement reserveButton; 

@FindBy (xpath = "//a[@data-book-button='book-ET-XX-Car']")
public WebElement reserveButton2; 

@FindBy (xpath = "//input[@placeholder='First and last name']")
public WebElement nameField;

@FindBy (xpath = "//input[@data-tealeaf-name='phoneNumber']")
public WebElement phoneField;

@FindBy (xpath = "(//input[@name='email'])[2]")
public WebElement emailField;

@FindBy (xpath = "(//input[@class='cko-account-creation-field'])[1]")
public WebElement passwordField;

@FindBy (xpath = "(//input[@class='cko-account-creation-field'])[2]")
public WebElement passwordConfirmField;

@FindBy (xpath = "//input[@id='no_insurance']")
public WebElement radioButton;

@FindBy (xpath = "//button[@id='complete-booking']")
public WebElement reserveNowButton;



@FindBy (xpath = "//button[@class='btn-primary btn-close']")
public WebElement noThanksButton;

@FindBy (xpath = "//h1[contains(text(), \"Thank you! Your trip is booked.\")]")
public WebElement confirmationMessage;
	
	
	
	
}

      