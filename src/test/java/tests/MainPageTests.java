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
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;

import pages.BookingFlightPage;
import pages.CarRentalPage;
import pages.HotelsBookingPage;
import pages.MainPage;
import utilities.BrowserUtilities;
import utilities.ConfigReader;
import utilities.Driver;

public class MainPageTests extends TestBase {

/*JULIAS CODE
	
	    @Test (priority = 1)
	    public void successfulMoveToCarRenetalPage() {
	    	MainPage mp = new MainPage();
	    	mp.rentACar();
	    	BrowserUtilities.waitFor(5);
	    	
	    	String actual = Driver.getDriver().getTitle();
	    	String expected = "Rental Cars and Car Rentals in Vero Beach from Travelocity";
	    	
	    	assertEquals(actual, expected); //See if we successfully entered Car Rental Page
	    }
	
	
	
        @Test (priority = 2)
        public void successfulMoveToFlightsPage() {
        	MainPage mp = new MainPage();
    	mp.bookingAFlight();
    	
    	BrowserUtilities.waitFor(10);
    	
	    	String actual = Driver.getDriver().getTitle();
	    	System.out.println(actual);
	    	String expected = "DCA to IEV Flights | Travelocity";
	        assertEquals(actual, expected); //See if we successfully entered Flight Booking Page
	     }
	
	
	
	
		@Test (priority = 3)
		public void checkCarRentalPricesOrder1() { //This test is checking if cars prices are ordered from low to high
			MainPage mp = new MainPage();
			CarRentalPage crp = new CarRentalPage();
			
			mp.rentACar(); //Calling my method that will take me to "Car rent page"
			
			//click on PREMIUM checkbox to narrow the search
			
			BrowserUtilities.waitFor(4);
			actions = new Actions(Driver.getDriver()); 
			actions.moveToElement(crp.premiumCheckbox).click().build().perform();
			
			
			
			List<Integer> prices = new ArrayList<Integer>();
			
		    for (WebElement webElement : crp.priceList) {
			
			prices.add(Integer.parseInt(webElement.getText().replace("$", "").replace(",", "")));
			
		    }
		    
		    System.out.println(prices);
		    
		    Collections.sort(prices);
		    
		    //Click on "Total Prices" to sort cars by price in ascending order
		    BrowserUtilities.waitFor(5);
		    
		     
			crp.totalPriceButton.click();
		    //crp.customerRatingButton.click();
		    
		    
		    
            List<Integer> sortedPrices = new ArrayList<Integer>();
			
		    for (WebElement webElement : crp.sortedPriceList) {
			
			sortedPrices.add(Integer.parseInt(webElement.getText().replace("$", "").replace(",", "")));
			
		    }
		    
		    System.out.println(sortedPrices);
		   
			
			//Check if cars are displayed sorted by price low to high
			assertEquals(prices, sortedPrices);
			
	}
	
		
		
		
	
	
	@Test (priority = 4)
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
		       	   
		       	String parentWindowHandle=driver.getWindowHandle();
				
				Set<String> allHandles = driver.getWindowHandles();
				
				
				for (String handle : allHandles) {
					if(!handle.equals(parentWindowHandle)) {
						driver.switchTo().window(handle);
						
					}
					
				}
				
				String actualTitle = Driver.getDriver().getTitle();  
				String expectedTitle = "Trip Detail | Travelocity";
				
				sa.assertEquals(actualTitle, expectedTitle);
		}
			
		
			



	@Test (priority = 5)
	public void negativeLogin2() { //trying to Logun with wrong username and NO password
		MainPage mp = new MainPage();
	
		Faker f = new Faker();
		
		mp.accountButton.click();
	
	    mp.accSignIn.click();
	    
	    mp.signinEmail.sendKeys(f.name().username() + "@mail.ru");
	
	    mp.signinPassword.sendKeys(Keys.TAB);
	    
	    mp.signinButton.click();
	    
	    String actual = mp.errorMessage.getText();
	    String expected = "Please enter a password";
	    
	    assertEquals(actual, expected); //Checking if error message pops up if we don't provide a password for Login
	}JULIAS CODE END
	*/
	
	
	
	
	
//	@Test 
//	public void negativeLogin() { //try to Login with wrong name AND password
//		
//		MainPage mp = new MainPage();
//		
//		Faker f = new Faker();
//		
//		mp.accountButton.click();
//	
//	    mp.accSignIn.click();
//	    
//	    mp.signinEmail.sendKeys(f.name().username() + "@mail.ru");
//	
//	    mp.signinPassword.sendKeys("hjhjhjhj");
//	    
//	    mp.signinButton.click();
//	}
	
	
	
	
	
//	@Test
//	public void createNewAccount() throws InterruptedException { //Doesn't work, CAPTCHA pops up
//		MainPage mp = new MainPage();
//		Faker f = new Faker();
//		
//		
//	mp.accountButton.click();
//	Thread.sleep(2000);
//	mp.accSignUp.click();
//	
//	mp.firstNameField.sendKeys(f.name().firstName());
//	mp.lastNameField.sendKeys(f.name().lastName());
//	mp.emailField.sendKeys( f.name().username()+"@mail.ru");
//	mp.passwordField.sendKeys("jjjnnn89");
//	mp.signUpButton.click();
//	}

	
//	@Test
//	public void rentingACarTest2() {//Sorting cars by Customer rating
//		
//		MainPage mp = new MainPage();
//		CarRentalPage crp = new CarRentalPage();
//		
//    mp.rentACar();
//		
//	actions = new Actions(Driver.getDriver()); 
//	actions.moveToElement(crp.premiumCheckbox).click().build().perform();
//	
////		actions = new Actions (driver);
////		actions.moveToElement(crp.economyCheckbox).click().build().perform();
//       // crp.economyCheckbox.click();
//	
//	crp.customerRatingButton.click();
//	
//		List<Integer> percentage = new ArrayList<Integer>();
//		
//		for (WebElement rating : crp.rating) {
//			System.out.println(rating.getText().replace("%", "").replace("recommend", ""));
//			
//			percentage.add(Integer.parseInt(rating.getText().replace("%", "").replace("recommend", "").replace(" ", "")));
//		}
//		
//		System.out.println(percentage);
//		
//		
//		
//		
//		
//		
//		
//		
//		//}
//		
//		//List<Integer> sortedPercentage = percentage;
//		
//		//System.out.println(percentage);
////		Collections.sort(percentage);
////			
////		
////		
////			
////	 //Check if cars are displayed sorted by price
////		
////		System.out.println(sortedPercentage);
////		
////		assertEquals(percentage, sortedPercentage);
//	}
	
	@Test (priority = 1)
	public void successfulMoveToHotelsPage()  {
		
		HotelsBookingPage hpg = new HotelsBookingPage();
		
		hpg.verifyLandingHotelsPage();
		
		hpg.searchHotelIstanbul();
	}

	}



