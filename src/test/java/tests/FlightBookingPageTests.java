package tests;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.BookingFlightPage;
import pages.MainPage;
import utilities.BrowserUtilities;
import utilities.Driver;

public class FlightBookingPageTests extends TestBase {


@Test (groups = {"sprint2"})//test 9
public void reserveAFlightButtonCheck() {
	     MainPage mp = new MainPage();
       BookingFlightPage bf = new BookingFlightPage();
       
       mp.bookingAFlight(); //My Method that will bring me to "Book a Flight Page"
       
       //Pick sort by duration
       
       BrowserUtilities.waitFor(5);
       
       JavascriptExecutor js=(JavascriptExecutor)Driver.getDriver();
        js.executeScript("window.scrollBy(0,100)");
        
       Select s = new Select(bf.sortMenuButton);
   	
   	   s.selectByValue("leg0departuretime:asc");
	
	       
    //Click on select first flight
   	   
   	   bf.selectButton.click();
   	   
   	//Turn off the pop up
   	BrowserUtilities.waitFor(5);
   	actions = new Actions(Driver.getDriver()); 
	    actions.moveToElement(bf.noThanksButton2).click().build().perform(); 
	    BrowserUtilities.waitFor(5);
	    
	    //Switching handle
	    String parentWindowHandle=Driver.getDriver().getWindowHandle();
	
	Set<String> allHandles = Driver.getDriver().getWindowHandles();
	
	
	for (String handle : allHandles) {
		if(!handle.equals(parentWindowHandle)) {
			Driver.getDriver().switchTo().window(handle);
			
		}
	}
	
	BrowserUtilities.waitFor(5);
   	js.executeScript("arguments[0].scrollIntoView(true);", bf.contBookingButton);
   	bf.contBookingButton.click();
 	
	
	//Confirm that we landed on Flight Details Page
	
	String expected = "Trip Detail | Travelocity";
	String actual = Driver.getDriver().getTitle();
	
	SoftAssert sa = new SoftAssert();
	sa.assertEquals(actual, expected);
	
	//Press Continue Booking Button, Confirm we go to another page
	BrowserUtilities.waitFor(5);
	Actions actions = new Actions(driver);
	actions.moveToElement(bf.contBookingButton);
	actions.perform();
	BrowserUtilities.waitFor(10);
	
	String expected1 = "Travelocity: Payment";
	String actual1 = Driver.getDriver().getTitle();
	sa.assertEquals(actual1, expected1);
   	 
}






@Test //test 5
public void bookAFlightTest1(){ //2 TESTS: Checking departure/destination 
	                            //&& Making sure switching to the next page once click "Select Flight"
	
	           MainPage mp = new MainPage();
	           BookingFlightPage bf = new BookingFlightPage();
	           
	           mp.bookingAFlight(); //My Method that will bring me to "Book a Flight Page"
	           
		       //Pick sort by duration
	           Select s = new Select(bf.sortMenuButton);
	       	
	       	   s.selectByValue("leg0departuretime:asc");
	       	   
	       	   //Confirm arrival airport
	       	   SoftAssert sa = new SoftAssert();
	       	   
	       	   String expected = "Kyiv, Ukraine (IEV)";
	       	   String actual = bf.arrivalAirport.getAttribute("value");
	       	   
		
	       	   sa.assertEquals(actual, expected);
	       	   
	       	//Confirm departure airport
	       	   
	       	   String expected1 = "Washington, DC, United States (DCA)";
	       	   String actual1 = bf.departureAirport.getAttribute("value");
	       	   
		
	       	   sa.assertEquals(actual1, expected1);
	       	   
	       	   
	       	   //Click on select first flight
	       	   
	       	   bf.selectButton.click();
	       	   
	       	   
	       	   
	       	   //Turn off the pop up
	       	   BrowserUtilities.waitFor(5);
	       	actions = new Actions(Driver.getDriver()); 
     		actions.moveToElement(bf.noThanksButton).click().build().perform();
	       	   
	       //Check if successfully switch to next page
     		
     		BrowserUtilities.waitFor(5);
     		
     		//System.out.println("current handle" + Driver.getDriver().getWindowHandle());
	       	   String currentHandle = "CDwindow-1F09F91102C01BF8919F2D2C17C94BB6";
	       	   
	       	String parentWindowHandle=Driver.getDriver().getWindowHandle();
			
			Set<String> allHandles = Driver.getDriver().getWindowHandles();
			
			
			for (String handle : allHandles) {
				if(!handle.equals(parentWindowHandle)) {
					Driver.getDriver().switchTo().window(handle);
					
				}
				
			}
			
			String actualTitle = Driver.getDriver().getTitle();  
			String expectedTitle = "Trip Detail | Travelocity";
			
			sa.assertEquals(actualTitle, expectedTitle);
	}
		
	
		
                                                                     
	
	
	
	
}
