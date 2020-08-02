package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class VacationRentalsPage {
	
	
	
	
	 public  VacationRentalsPage() {
			PageFactory.initElements(Driver.getDriver(), this); 
			// This statement is initializing the variables that are tagged with @FindBy annotations		
		}
	 
	 
	 
	 @FindBy (xpath = "//*[@id=\"VR-destination\"]")
     public WebElement destinationBox;
     
     @FindBy (xpath = "//*[@id=\"VR-fromDate\"]")
     public WebElement dateFrom;
     
     @FindBy (xpath = "//*[@id=\"VR-toDate\"]")
     public WebElement dateTo;
      
     @FindBy (xpath = "//*[@id=\"VR-NumAdult\"]")
     public WebElement guestsNumber;
     
     @FindBy (xpath = "//*[@id=\"VR-searchButtonExt1\"]")
     public WebElement searchButton;
  
    

}
