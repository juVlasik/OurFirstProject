package tests;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;

import pages.BookingFlightPage;
import pages.CarRentalPage;
import pages.CruisesPage;
import pages.GetInspiredPage;
import pages.HotelsBookingPage;
import pages.MainPage;
import pages.ThingsToDoPage;
import utilities.BrowserUtilities;
import utilities.ConfigReader;
import utilities.Driver;

public class MainPageTests extends TestBase {
	
	

    @Test  (groups = {"sprint3"})//sprint 3 test
    public void thingsToDoDatesVafification () { //Things to Do through Get Inspired Page
    	                                         //This Test fails due to the bug at the website
   	 
   	 MainPage mp = new MainPage();
   	 GetInspiredPage gi = new GetInspiredPage();
   	 ThingsToDoPage ttd = new ThingsToDoPage();
   	 
   	 
   	 mp.getInspiredButton.click();
   	 BrowserUtilities.waitFor(5);
   	 
   	 JavascriptExecutor js=(JavascriptExecutor)Driver.getDriver();
   	 js.executeScript("window.scrollBy(0,900)");
   	 
   	 
   	 gi.thingsToDoButton.click();
   	 BrowserUtilities.waitFor(5);
   	 gi.destInputBox.click();
   	 gi.destInputBox.sendKeys("New Orleans" + Keys.DOWN + Keys.DOWN + Keys.ENTER);
   	 
   	 gi.checkInputField.click();
   	 
   	 for (int i = 0; i < gi.inCalDates.size(); i++) {
				String date = gi.inCalDates.get(i).getText();
				if (date.contains("27")) {
					gi.inCalDates.get(i).click();
					break;
				}
			}
   	
   	 BrowserUtilities.waitFor(5);
        gi.outInputField.click();
   	 
   	 for (int i = 0; i < gi.outCalDates.size(); i++) {
				String date = gi.outCalDates.get(i).getText();
				if (date.contains("3")) {
					gi.outCalDates.get(i).click();
					break;
				}
			}
   	gi.serchButton.click();
   	
   	//Switching handle
	    String parentWindowHandle=Driver.getDriver().getWindowHandle();
	
	    Set<String> allHandles = Driver.getDriver().getWindowHandles();
	
	
	    for (String handle : allHandles) {
		if(!handle.equals(parentWindowHandle)) {
			Driver.getDriver().switchTo().window(handle);
			
		}
	}
   	
   	//Compare dates at the next page
   	BrowserUtilities.waitFor(5);
   	
   	String actualDates = ttd.actualDates.getText();
   	System.out.println(actualDates);
   	
   	 String expectedDates = "Sun, Sep 27 - Sat, Oct 3";
   	 Assert.assertEquals(actualDates, expectedDates);
    }
    
    
       
	
	@Test   (groups = {"sprint3"})//sprint 3 test
	public void covidMenuVerification() {
		MainPage mp = new MainPage();
		
		mp.covidMenuButton.click();
		BrowserUtilities.waitFor(5);
		List <String> actual = BrowserUtilities.getElementsText(mp.covidMenu);
		
		
		List <String> expected = Arrays.asList("Cancel a trip", "Check the status of a refund", "Use an airline credit", 
				"Use a hotel or vacation rental coupon", "Get help with something else");
		
		Assert.assertEquals(actual, expected);
	}




	@Test   (groups = {"sprint3"})//sprint 3 test
	public void saleLinkVerification() {
		MainPage mp = new MainPage();
		String text = mp.saleLink.getText();
		
		mp.saleLink.click();
		//Checking if link took us to the correct page
		String actualTitle = Driver.getDriver().getTitle();
		BrowserUtilities.waitFor(5);
		Assert.assertTrue(actualTitle.contains(text));
	}
	
    
    
    

//  @Test 
//  public void ThingsToDoDates1varification () { //Does not check the calendar dates, just goes straight to the next page!
// 	 
//      MainPage mp = new MainPage();
// 	
//         mp.thingsToDoButton.click();
//			
//			mp.activityDestButton.sendKeys("Colorado" + Keys.ENTER);
//			BrowserUtilities.waitFor(5);
//			
//			ThingsToDoPage ttd = new ThingsToDoPage();
//			
//			ttd.calStartDate.click();
// 	 
//  }
	
	
	
	

	@Test  //test 1
    public void successfulMoveToCarRenetalPage() {
    	MainPage mp = new MainPage();
    	mp.rentACar();
    	BrowserUtilities.waitFor(5);
    	
    	String actual = Driver.getDriver().getTitle();
    	String expected = "Rental Cars and Car Rentals in Vero Beach from Travelocity";
    	
    	assertEquals(actual, expected); //See if we successfully entered Car Rental Page
    }



    @Test //test2
    public void successfulMoveToFlightsPage() {
    	MainPage mp = new MainPage();
	mp.bookingAFlight();
	
	BrowserUtilities.waitFor(10);
	
    	String actual = Driver.getDriver().getTitle();
    	System.out.println(actual);
    	String expected = "DCA to IEV Flights | Travelocity";
        assertEquals(actual, expected); //See if we successfully entered Flight Booking Page
     }
    
    
    
    

     @Test  (groups = {"sprint2"})  //test 3 //Does not check the calendar dates, just goes straight to the next page!
     public void successfulMoveToThingsToDoPage() {
    	 MainPage mp = new MainPage();
    	 
    	 mp.thingsToDoButtonTest();
    	 
     }


	

     
     


@Test (groups = {"sprint2"})//test 7
public void travelInspirationlinks() { //Checking if all the links are clickable and take to the correct page
	
	MainPage mp = new MainPage();
	
	JavascriptExecutor js=(JavascriptExecutor)Driver.getDriver();
    js.executeScript("window.scrollBy(0,1200)");
	
    List<String> actualLinks = new ArrayList<String>();
    
    //looping through my list of links and making sure they're all functional
    
    for (int i = 1; i <= mp.travelInspiration.size(); i++) {
	
        mp.travelInspiration = Driver.getDriver().findElements(By.xpath(
    			"//figure[@class='image aspect-ratio16-9']"));
        Driver.getDriver().findElement(By.xpath("(//figure[@class='image aspect-ratio16-9'])[" +i+ "]")).click();
		
		BrowserUtilities.waitFor(5);
		
		//System.out.println(Driver.getDriver().getTitle());
		actualLinks.add(Driver.getDriver().getTitle());
		
		Driver.getDriver().navigate().back();
		
		BrowserUtilities.waitFor(5);
		
		//come up with assertion
	}
	 
	 
	 List<String> expectedLinks = Arrays.asList("Hit the Roam Sale | Travelocity", "Roam near home | Travelocity", "Family Hotel Offers | Travelocity",
			 "8 ways to ease back into travel—when the time comes | Inspire | Travelocity.com", "Vacation Rentals | Travelocity", "The most Instagrammable lakes in the US | Inspire | Travelocity.com");

     Assert.assertEquals(actualLinks, expectedLinks);

}







//Shahana's test
    
    @Test (groups = {"sprint2"})
    public void successfulMoveToCruisesPage() {
    	CruisesPage cp = new CruisesPage();
    	cp.BookCruises();
    	
    	BrowserUtilities.waitFor(5);
    	
    	String actual = Driver.getDriver().getTitle();
    	BrowserUtilities.waitFor(5);
    	String expected = "Alaska Cruises | Travelocity";
    	
    	assertEquals(actual, expected);

    }
    
    
  //Saha's test 
    
	@Test (groups = {"sprint2"})
    
	public void successfulMoveToHotelsPage()  {
		
		HotelsBookingPage hpg = new HotelsBookingPage();
		
		hpg.verifyLandingHotelsPage();
		
		hpg.searchHotelIstanbul();
	}

	
	
}


