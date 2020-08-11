package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.testng.annotations.*;

import pages.MainPage;
import pages.TravelDealsPage;
import utilities.BrowserUtilities;

public class TravelDealsTests extends TestBase {
	
	//Anna's code
	
	@Test (groups = {"newTest"})
	
	public void succesfulMoveToTravelDealsPage () {
		MainPage mp = new MainPage();
		mp.TravelDealsButton.click();
		BrowserUtilities.waitFor(5);
		String actual = driver.getTitle();
		System.out.println(actual);
		String expected = "Travel Deals: Find Cheap Flights Plus Hotel Discounts | Travelocity";
    	assertEquals(driver.getTitle(), expected); //check if title is correct	
	}
	
	
	@Test (groups = {"newTest"})
	public void testTravelDealsOldPage () { //When clicking on Travel Deals, user is randomly re-directed to two different pages
		MainPage mp = new MainPage();
		mp.TravelDealsButton.click();
		TravelDealsPage td = new TravelDealsPage();
		System.out.println(driver.getTitle());
	
		td.hotelOnlyButton.click();
		td.flightAndHotelButton.click();
		td.flightOnlyButton.click();
		
	}


	
	@Test (groups = {"newTest"})
	public void testTravelDealsPageHotels () { //Check Hotel Only option + default room/travelers
		MainPage mp = new MainPage();
		mp.TravelDealsButton.click();
		TravelDealsPage td = new TravelDealsPage();
		System.out.println(driver.getTitle());
	
		td.hotelsButton.click();
		String s = td.travelersAndRoomBox.getText();
		
		System.out.println(s);
		String expectedDefault = "1 room, 2 travelers";
		assertEquals(s, expectedDefault);
	}
	
	
	@Test (groups = {"newTest"})
	public void testTravelDealsPagePackges () { //Check Deals  option 
		MainPage mp = new MainPage();
		mp.TravelDealsButton.click();
		TravelDealsPage td = new TravelDealsPage();
		System.out.println(driver.getTitle());
		
		td.packagesButton.click();
		td.packagesLeavingFromButton.click();
		td.packagesSearchButton.click();
		
		
	}
	
	
	
	
	
	
	
	
	
}
