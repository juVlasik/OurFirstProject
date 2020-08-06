package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.*;

import pages.MainPage;
import utilities.BrowserUtilities;

public class TravelDealsTests extends TestBase {
	
	@Test
	
	public void succesfulMoveToTravelDealsPage () {
		MainPage mp = new MainPage();
		mp.TravelDealsButton.click();
		BrowserUtilities.waitFor(5);
		String actual = driver.getTitle();
		System.out.println(actual);
		String expected = "Travel Deals: Find Cheap Flights Plus Hotel Discounts | Travelocity";
    	assertEquals(driver.getTitle(), expected); //check if title is correct	
	}

}
