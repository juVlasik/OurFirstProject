package tests;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
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

import com.github.javafaker.Faker;

import pages.BookingFlightPage;
import pages.CarRentalPage;
import pages.MainPage;
import utilities.BrowserUtilities;
import utilities.ConfigReader;
import utilities.Driver;

public class MainPageTests extends TestBase {

	MainPage mp = new MainPage();
	BookingFlightPage bf = new BookingFlightPage();
	CarRentalPage crp = new CarRentalPage();
	
	protected WebDriver driver;
	protected Actions actions;

	
	    @Test
	    public void successfulMoveToCarRenetalPage() {
	    	mp.rentACar();
	    	BrowserUtilities.waitFor(5);
	    	String actual = driver.getTitle();
	    	String expected = "Rental Cars and Car Rentals in Vero Beach from Travelocity";
	    	
	    	assertEquals(actual, expected); //See if we successfully entered Car Rental Page
	    }
	
	
	
        @Test
        public void successfulMoveToFlightsPage() {
    	mp.bookingAFlight();
	    	String actual = driver.getTitle();	    	
	    	String expected = "DCA to IEV Flights | Travelocity";
	        assertEquals(actual, expected); //See if we successfully entered Flight Booking Page
	     }
	
	
	
	
//		@Test
//		public void rentingACarTest1() { //This test is checking if cars prices are ordered from low to high
//		
//			mp.rentACar(); //Calling my method that will take me to "Car rent page"
//			
//			//click on PREMIUM checkbox to narrow the search
//			BrowserUtilities.waitFor(4);
//			
//			Actions actions = new Actions(driver); 
//			actions.moveToElement(crp.premiumCheckbox).click().build().perform();
//			
//			
//			
//			List<Integer> prices = new ArrayList<Integer>();
//			
//		    for (WebElement webElement : crp.priceList) {
//			
//			prices.add(Integer.parseInt(webElement.getText().replace("$", "").replace(",", "")));
//			
//		    }
//		    
//		    System.out.println(prices);
//		    
//			List<Integer> sortedPrices = prices;
//			Collections.sort(sortedPrices);
//		
//			System.out.println(sortedPrices);
//			
//			//Check if cars are displayed sorted by price low to high
//			assertEquals(prices, sortedPrices);
//			
//		}
	
		
		
		
//		@Test
//		public void rentingACarTest2() {//Sorting cars by distance
//			
//			mp.rentACar();
//			
////			actions = new Actions (driver);
////			actions.moveToElement(crp.economyCheckbox).click().build().perform();
//			
//           // crp.economyCheckbox.click();
//			List<Integer> miles = new ArrayList<Integer>();
//			
//			for (WebElement distance : crp.distance) {
//				System.out.println(distance.getText().replace(".", "").replace(" mi from Vero Beach city center", "")
//						.replace(".", "").replace(" mi from Vero Beach city center", ""));
//				//miles.add(Integer.parseInt(distance.getText().replace(".", "").replace(" miles from Vero Beach city center", "")));
//				//System.out.println(miles);
//				System.out.println(distance.getText());
//			}
//			
//			
//			
//			
//			
//			
//			//}
//			
//			//List<Integer> sortedPercentage = percentage;
//			
//			//System.out.println(percentage);
////			Collections.sort(percentage);
////				
////			
////			//Click on Customer Rating Button
////			BrowserUtilities.waitFor(3);	
////			crp.customerRatingButton.click();	
////				
////		 //Check if cars are displayed sorted by price
////			
////			System.out.println(sortedPercentage);
////			
////			assertEquals(percentage, sortedPercentage);
//		}
		
		
			
			

		
	
	
//	@Test
//	public void bookAFlightTest1(){
//		
//		           mp.bookingAFlight(); //My Method that will bring me to "Book a Flight Page"
//		           
//			       List<String> flightPrices1 = new ArrayList<>();
//			 
//			 
//			        for (WebElement price : bf.flightPrices) {
//					if (price.getText().contains("Price is unavailable. Click to search") || (price.getText().contains("$")) || 
//							(price.getText().contains("$")) || price.getText().contains("Cheapest") || price.getText().contains("Departs")) {
//						//bf.flightPrices.remove(price);
//					
//				    flightPrices1.add(price.getText().replace("Price is unavailable. Click to search", "0").
//				    		replace("Search", "0").replace(",", "").replace("$", "").replace(",", ""));
//						
//				
//					
//					//flightPrices1.add(price.getText().substring(price.getText().indexOf(","), price.getText().indexOf(" ")).replace(",", ""));
//					}
//					
//					System.out.println(price.getText());
//			        }
//			        System.out.println(flightPrices1);
//					
//					//List<Integer> flightPrices2 = new ArrayList<Integer>();
//					
//					//flightPrices2.add(Integer.parseInt(webElement.getText().replace("$", "").replace(",", "")));
//					
//					
//					
////					List<Integer> sortedPrices = prices;
////					Collections.sort(sortedPrices);
////				
////					//Check if cars are displayed sorted by price
////					assertEquals(prices, sortedPrices);
			
	//	}
			
		
			

	
	
	
	
	
//	@Test 
//	public void negativeLogin() {
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
//	public void negativeLogin2() {
//		
//		Faker f = new Faker();
//		
//		mp.accountButton.click();
//	
//	    mp.accSignIn.click();
//	    
//	    mp.signinEmail.sendKeys(f.name().username() + "@mail.ru");
//	
//	    mp.signinPassword.sendKeys(Keys.TAB);
//	    
//	    mp.signinButton.click();
//	}
	
	
	

//	@Test
//	public void createNewAccount() throws InterruptedException { //Doesn't work, CAPTCHA pops up
//		
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
//	

}
