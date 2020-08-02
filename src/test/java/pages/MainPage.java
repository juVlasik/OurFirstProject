package pages;

import java.util.List;

import org.apache.xerces.impl.xpath.XPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import utilities.BrowserUtilities;
import utilities.Driver;

public class MainPage {

        public  MainPage() {
		
		PageFactory.initElements(Driver.getDriver(), this); // This statement is initializing the variables that are tagged
															//with @FindBy annotations
		
	}
	
        
        
        
        
        @FindBy (xpath = "(//span[@class='icon icon-cars'])[1]")
        public WebElement carsButton;
        
        @FindBy (xpath = "//input[@id='car-pickup-hp-car']")
        public WebElement pickUpButton;
        
        @FindBy (xpath = "//input[@id='car-dropoff-hp-car']")
        public WebElement dropOffButton;
        
        @FindBy (id = "car-pickup-time-hp-car")
        public WebElement pickUpTime;
        
        @FindBy (id = "car-dropoff-time-hp-car")
        public WebElement dropOffTime;
        
        @FindBy (xpath = "//input[@id ='car-pickup-date-hp-car']")
        public WebElement calPickUp;
        
        @FindBy (xpath = "//input[@id ='car-dropoff-date-hp-car']")
        public WebElement calDropOff;
        
        @FindBy(xpath = "(//div//table[@class='datepicker-cal-weeks'])[2]//td")
		public List<WebElement> picktUpDateButton;
        
        @FindBy(xpath = "(//div//table[@class='datepicker-cal-weeks'])[2]//td")
		public List<WebElement> dropOffDateButton;
        
        @FindBy (id = "search-button-hp-car")
        public WebElement carsSeachButton;
        
      
        
        @FindBy (xpath = "//*[text()='Flights ']")
        public WebElement flightsButton;
        
//        @FindBy (id = "tab-flight-tab-hp")
//        public WebElement flightButton;
        
        @FindBy (id = "flight-type-one-way-label-hp-flight")
        public WebElement oneWayButton;
        
        @FindBy (id = "flight-origin-hp-flight")
        public WebElement flyingFromButton;
        
        @FindBy (id = "flight-destination-hp-flight")
        public WebElement flyingToButton;
        
        @FindBy (xpath = "//input[@id='flight-departing-single-hp-flight']")
        public WebElement calDepartureButton;
        
        @FindBy (xpath = "(//tbody[@class='datepicker-cal-dates'])[2]//td")
        public List<WebElement> calDepartureDates;
        
        @FindBy (id = "flight-adults-hp-flight")
        public WebElement adultNoButton;
        
        @FindBy (xpath = "(//*[text()='Search'])[1]")
        public WebElement searchFlightButton;
        
        @FindBy (xpath = "//div[@class='datepicker-close']//button")
        public WebElement calCloseButton;
        
        
        @FindBy (xpath = "//div[@class='alert-message']")
        public WebElement alertLink;
       
        @FindBy (xpath = "//a[@id='primary-header-tripsforme']")
	    public WebElement TripsForMe;
        
       
        @FindBy (xpath = "//*[@id=\"all-in-vacationRental-header-link\"]")
        public WebElement VacationRentalsButton;
        
        
        
        
//        @FindBy (xpath = "//button[@id='header-account-menu']")
//	    public WebElement accountButton;
//        
//        
//        
//        
//        @FindBy (id = "gss-signup-submit" )
//        public WebElement accSignUp;
//        
//        @FindBy (id = "gss-signup-first-name")
//        public WebElement firstNameField;
//
//        @FindBy (id = "gss-signup-last-name")
//        public WebElement lastNameField;
//        
//        
//        @FindBy (id = "gss-signup-email")
//        public WebElement emailField;
//        
//        @FindBy (id = "gss-signup-password")
//        public WebElement passwordField;
//        
//        @FindBy (id = "gss-signup-submit")
//        public WebElement signUpButton;
//        
//        
//        
//        
//        @FindBy (id = "account-signin" )
//        public WebElement accSignIn;
//        
//        @FindBy (id = "gss-signin-email")
//        public WebElement signinEmail;
//        
//        @FindBy (id = "gss-signin-password")
//        public WebElement signinPassword;
//        
//        @FindBy (id = "gss-signin-submit")
//        public WebElement signinButton;
        
        
        
        
        //Renting a car method
        public void rentACar() {
    		
    		
    	carsButton.click();
    	
    	//To-From
    	pickUpButton.sendKeys("Vero Beach" + Keys.ENTER);
    	dropOffButton.sendKeys("Vero Beach" + Keys.ENTER);
    	
    	
    	//Time
        Select s = new Select(pickUpTime);
    	
    	s.selectByValue("0930AM");

    	//Pick Up Calendar
    	
    	    JavascriptExecutor js=(JavascriptExecutor)Driver.getDriver();
            js.executeScript("window.scrollBy(0,400)");
            
            
    				calPickUp.click();

    				//BrowserUtilities.waitFor(2);
    				
    				
    			    for (int i = 0; i < picktUpDateButton.size(); i++) {
    			    	
    				String date = picktUpDateButton.get(i).getText();
    				
    				if (date.contains("29")) {
    				
    					picktUpDateButton.get(i).click();
    					break;
    				}
    			}
    	//Drop Off calendar
    			    
    			    calDropOff.click();
    			    
                    //BrowserUtilities.waitFor(2);
    				
    			    for (int i = 0; i < dropOffDateButton.size(); i++) {
    				String date = dropOffDateButton.get(i).getText();
    				if (date.contains("10")) {
    					dropOffDateButton.get(i).click();
    					break;
    				}
    			}
    			    
    	//Time
        s = new Select(dropOffTime);
    	
    	s.selectByValue("0930PM");
    	
//    	//Drop Off Calendar
    //	
//    	mp.calDropOff.click();
    	
    	//Search
    	carsSeachButton.click();
    	
    	
    	
    	}
        
        
        
        
        
      //Booking a flight
        
		public void bookingAFlight() {
			
		flightsButton.click();
		oneWayButton.click();
		
		JavascriptExecutor js=(JavascriptExecutor)Driver.getDriver();
        js.executeScript("window.scrollBy(0,300)");
		
		flyingFromButton.sendKeys("Dulles" + Keys.ENTER);
		flyingToButton.sendKeys("Kyiv" + Keys.ENTER);
		
		calDepartureButton.click();
	
//Picking a departure date		
		
		 for (int i = 0; i < calDepartureDates.size(); i++) {
		    
			String date = calDepartureDates.get(i).getText();
//			System.out.println(date);

			if (date.contains("13")) {
			
				calDepartureDates.get(i).click();
				break;
			}
			
		}
		 
		
		
	//Selection one adult
		 
		 Select s = new Select(adultNoButton);
		 s.selectByValue("1");
		
		 js.executeScript("window.scrollBy(0,200)");
//		 BrowserUtilities.waitFor(4);
//		mp.calCloseButton.click();
		 
		 BrowserUtilities.waitFor(10);
		 
		Actions actions = new Actions(Driver.getDriver()); 
		actions.moveToElement(searchFlightButton).click().build().perform();
		 
		 //mp.searchFlightButton.click();
		 
		
}
}
        
