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
	 
//OLD PAGE FIELDS
	 //Buttons: Hotel only || Flight only || Flight+Hotel
     @FindBy (xpath = "//*[@id=\"tab-hotel\"]")
     public WebElement hotelOnlyButton;
     
     
     @FindBy (xpath = "//*[@id=\"tab-flight\"]")
     public WebElement flightOnlyButton;
     
     
     @FindBy (xpath = "//*[@id=\"tab-package\"]")
     public WebElement flightAndHotelButton;
     
     //Hotel only fields:
     //Destination
     @FindBy (xpath = "//*[@id=\"H-destination\"]")
     public WebElement destinationBox;
 
     //Check-in
     @FindBy (xpath = "//*[@id=\"H-fromDate\"]")
     public WebElement checkInBox;
 
     //Check-out
     @FindBy (xpath = "//*[@id=\"H-toDate\"]")
     public WebElement checkOutBox;
     
     //Rooms
     @FindBy (xpath =  "//*[@id=\"H-NumRoom\"]")
     public WebElement numOfRoomsBox;
     
     //Number of adults
     //Number of children
     
     
     //Search button
     @FindBy (xpath =  "//*[@id=\"H-searchButtonExt1\"]")
     public WebElement searchButton;
     
//NEW PAGE FIELDS
     
     
     @FindBy (xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div/div/div/div/ul/li[1]/div/label/span[1]")
     public WebElement hotelsButton;
     
     
     @FindBy (xpath = "//*[@id=\"wizard-hotel-pwa-1\"]/div/form/div[2]/div[3]/div/button")
     public WebElement travelersAndRoomBox;
     
     
     @FindBy (xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div/div/div/div/ul/li[2]/div/label/span[1]")
     public WebElement packagesButton;
     
     @FindBy (xpath =  "//*[@id=\"wizard-package-pwa-1\"]/div[2]/div[1]/div/div[1]/div/div/div/button[1]")
     public WebElement packagesLeavingFromButton;
	 
     @FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/header/section/div/input")
     public WebElement packagesInputBoxLeavingFrom;
     
     @FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/header/section/div/input")
     public WebElement packagesInputBoxGoingTo;
     
     @FindBy (xpath = "//*[@id=\"wizard-package-pwa-1\"]/div[5]/div/button")
     public WebElement packagesSearchButton;
         
     
     
}
