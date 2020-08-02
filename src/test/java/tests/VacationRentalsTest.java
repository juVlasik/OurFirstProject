package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.VacationRentalsPage;
import utilities.BrowserUtilities;
import utilities.Driver;

public class VacationRentalsTest extends TestBase {

	
	@Test
	public void successfulMoveToVacationRentalsPage() throws Exception {
		MainPage mp = new MainPage();
		mp.VacationRentalsButton.click();
		BrowserUtilities.waitFor(5);
		String expected = "Best Vacation Rentals: Find Cheap Rentals | Travelocity.com";
    	assertEquals(driver.getTitle(), expected); //check if title is correct
    	
	}
	
	
	@Test
	public void successfulRentalsSearch() throws Exception {
		MainPage mp = new MainPage();
		mp.VacationRentalsButton.click();
		BrowserUtilities.waitFor(5);
		VacationRentalsPage vp = new VacationRentalsPage();
		vp.destinationBox.sendKeys("New York, NY");
		BrowserUtilities.waitFor(5);
		
		vp.dateFrom.sendKeys("9/1/2020");
		vp.dateTo.sendKeys("9/2/2020");
		vp.searchButton.click();
		
		BrowserUtilities.waitFor(10);
		
		
		
		
		
	}
	
	
	
	
}
