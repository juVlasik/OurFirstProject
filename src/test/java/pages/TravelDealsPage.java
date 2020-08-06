package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class TravelDealsPage {
	
	
	
	 public  TravelDealsPage() {
			PageFactory.initElements(Driver.getDriver(), this); 
			// This statement is initializing the variables that are tagged with @FindBy annotations		
		}
	 
	 //Buttons: Hotel only || Flight only || Flight+Hotel
     @FindBy (xpath = "//*[@id=\"tab-hotel\"]")
     public WebElement hotelOnlyButton;
     
     
     @FindBy (xpath = "//*[@id=\"tab-flight\"]")
     public WebElement flightOnlyButton;
     
     
     @FindBy (xpath = "//*[@id=\"tab-package\"]")
     public WebElement flightAndHotelButton;
     
     
     //Flight only radio buttons: Round trip || One Way || Multiple destinations
     
     
	 

}
