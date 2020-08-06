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
import pages.MainPage;
import pages.ThingsToDoPage;
import utilities.BrowserUtilities;
import utilities.ConfigReader;
import utilities.Driver;

public class MainPageTests extends TestBase {
	

	
//	    @Test (priority = 1)
//	    public void successfulMoveToCarRenetalPage() {
//	    	MainPage mp = new MainPage();
//	    	mp.rentACar();
//	    	BrowserUtilities.waitFor(5);
//	    	
//	    	String actual = Driver.getDriver().getTitle();
//	    	String expected = "Rental Cars and Car Rentals in Vero Beach from Travelocity";
//	    	
//	    	assertEquals(actual, expected); //See if we successfully entered Car Rental Page
//	    }
//	
//	
//	
//        @Test (priority = 2)
//        public void successfulMoveToFlightsPage() {
//        	MainPage mp = new MainPage();
//    	mp.bookingAFlight();
//    	
//    	BrowserUtilities.waitFor(10);
//    	
//	    	String actual = Driver.getDriver().getTitle();
//	    	System.out.println(actual);
//	    	String expected = "DCA to IEV Flights | Travelocity";
//	        assertEquals(actual, expected); //See if we successfully entered Flight Booking Page
//	     }
//	
//	
//	
//	
//		@Test (priority = 3)
//		public void checkCarRentalPricesOrder1() { //This test is checking if cars prices are ordered from low to high
//			MainPage mp = new MainPage();
//			CarRentalPage crp = new CarRentalPage();
//			
//			mp.rentACar(); //Calling my method that will take me to "Car rent page"
//			
//			//click on PREMIUM checkbox to narrow the search
//			
//			BrowserUtilities.waitFor(4);
//			actions = new Actions(Driver.getDriver()); 
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
//		    Collections.sort(prices);
//		    
//		    //Click on "Total Prices" to sort cars by price in ascending order
//		    BrowserUtilities.waitFor(5);
//		    
//		     
//			crp.totalPriceButton.click();
//		    //crp.customerRatingButton.click();
//		    
//		    
//		    
//            List<Integer> sortedPrices = new ArrayList<Integer>();
//			
//		    for (WebElement webElement : crp.sortedPriceList) {
//			
//			sortedPrices.add(Integer.parseInt(webElement.getText().replace("$", "").replace(",", "")));
//			
//		    }
//		    
//		    System.out.println(sortedPrices);
//		   
//			
//			//Check if cars are displayed sorted by price low to high
//			assertEquals(prices, sortedPrices);
//			
//	}
	
		
		
		
	
	
//	@Test (priority = 4)
//	public void bookAFlightTest1(){ //2 TESTS: Checking departure/destination 
//		                            //&& Making sure switching to the next page once click "Select Flight"
//		
//		           MainPage mp = new MainPage();
//		           BookingFlightPage bf = new BookingFlightPage();
//		           
//		           mp.bookingAFlight(); //My Method that will bring me to "Book a Flight Page"
//		           
//			       //Pick sort by duration
//		           Select s = new Select(bf.sortMenuButton);
//		       	
//		       	   s.selectByValue("leg0departuretime:asc");
//		       	   
//		       	   //Confirm arrival airport
//		       	   SoftAssert sa = new SoftAssert();
//		       	   
//		       	   String expected = "Kyiv, Ukraine (IEV)";
//		       	   String actual = bf.arrivalAirport.getAttribute("value");
//		       	   
//			
//		       	   sa.assertEquals(actual, expected);
//		       	   
//		       	//Confirm departure airport
//		       	   
//		       	   String expected1 = "Washington, DC, United States (DCA)";
//		       	   String actual1 = bf.departureAirport.getAttribute("value");
//		       	   
//			
//		       	   sa.assertEquals(actual1, expected1);
//		       	   
//		       	   
//		       	   //Click on select first flight
//		       	   
//		       	   bf.selectButton.click();
//		       	   
//		       	   
//		       	   
//		       	   //Turn off the pop up
//		       	   BrowserUtilities.waitFor(5);
//		       	actions = new Actions(Driver.getDriver()); 
//         		actions.moveToElement(bf.noThanksButton).click().build().perform();
//		       	   
//		       //Check if successfully switch to next page
//         		
//         		BrowserUtilities.waitFor(5);
//         		
//         		//System.out.println("current handle" + Driver.getDriver().getWindowHandle());
//		       	   String currentHandle = "CDwindow-1F09F91102C01BF8919F2D2C17C94BB6";
//		       	   
//		       	String parentWindowHandle=driver.getWindowHandle();
//				
//				Set<String> allHandles = driver.getWindowHandles();
//				
//				
//				for (String handle : allHandles) {
//					if(!handle.equals(parentWindowHandle)) {
//						driver.switchTo().window(handle);
//						
//					}
//					
//				}
//				
//				String actualTitle = Driver.getDriver().getTitle();  
//				String expectedTitle = "Trip Detail | Travelocity";
//				
//				sa.assertEquals(actualTitle, expectedTitle);
//		}
			
		
			
//
//	@Test (priority = 5)
//	public void negativeLogin2() { //trying to Login with wrong username and NO password
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
//	    mp.signinPassword.sendKeys(Keys.TAB);
//	    
//	    mp.signinButton.click();
//	    
//	    String actual = mp.errorMessage.getText();
//	    String expected = "Please enter a password";
//	    
//	    assertEquals(actual, expected); //Checking if error message pops up if we don't provide a password for Login
//	}
	
	                                                                                                                                        
	
	
//	@Test (priority = 6)
//	public void travelInspirationlinks() {
//		
//		MainPage mp = new MainPage();
//		
//		JavascriptExecutor js=(JavascriptExecutor)Driver.getDriver();
//        js.executeScript("window.scrollBy(0,1200)");
//		
//        List<String> actualLinks = new ArrayList<String>();
//        
//        //looping through my list of links and making sure they're all functional
//        
//        for (int i = 1; i <= mp.travelInspiration.size(); i++) {
//		
//            mp.travelInspiration = Driver.getDriver().findElements(By.xpath(
//        			"//figure[@class='image aspect-ratio16-9']"));
//            Driver.getDriver().findElement(By.xpath("(//figure[@class='image aspect-ratio16-9'])[" +i+ "]")).click();
//			
//			BrowserUtilities.waitFor(5);
//			
//			//System.out.println(Driver.getDriver().getTitle());
//			actualLinks.add(Driver.getDriver().getTitle());
//			
//			Driver.getDriver().navigate().back();
//			
//			BrowserUtilities.waitFor(5);
//			
//			//come up with assertion
//		}
//		 
//		 
//		 List<String> expectedLinks = Arrays.asList("Hit the Roam Sale | Travelocity", "Roam near home | Travelocity", "Family Hotel Offers | Travelocity",
//				 "8 ways to ease back into travel—when the time comes | Inspire | Travelocity.com", "Vacation Rentals | Travelocity", "The most Instagrammable lakes in the US | Inspire | Travelocity.com");
//	
//	     Assert.assertEquals(actualLinks, expectedLinks);
//	
//	}
	
	
	
	
	

//	@Test (priority = 7)
//	public void thingsToDoButtonTest() { //Skips calendars and goes to another page after LOCATION input
//		
//	    MainPage mp = new MainPage();
//	    ThingsToDoPage ttd = new ThingsToDoPage(); 
//		
//		mp.thingsToDoButton.click();
//		
//		mp.activityDestButton.sendKeys("Colorado" + Keys.ENTER);
//		BrowserUtilities.waitFor(5);
//		
//		Driver.getDriver().findElement(By.xpath("//input[@id='activity-start-hp-activity']")).click();
//		
//		ttd.sortLToH.click();
//		
//		JavascriptExecutor js=(JavascriptExecutor)Driver.getDriver();
//        js.executeScript("window.scrollBy(0,200)");
//        
//        BrowserUtilities.waitFor(5);
//        
//		ttd.newOnTButton.click();
//		
//		ttd.calStartDate.click();
//		
//		
//		//Picking calendar date
//		
//        for (int i = 0; i < ttd.calStartDates.size(); i++) {
//		    
//			String date = ttd.calStartDates.get(i).getCssValue("aria-label");
//			
//			System.out.println(date);
//
//			if (date.contains("10")) {
//			
//				ttd.calStartDates.get(i).click();
//				break;
//			}
//        }
//		
//
//       mp.calSearchButton.click();
//
//        mp.calEndDate.click();
//        
//        //Picking calendar date
//		
//        for (int i = 0; i < mp.calEndDates.size(); i++) {
//		    
//			String date = mp.calEndDates.get(i).getText();
//			
//			System.out.println(date);
//
//			if (date.contains("17")) {
//			
//				mp.calEndDates.get(i).click();
//				break;
//			}
//			
//		}
//	}
	
	
//	@Test (priority = 8)
//	public void reserveAFlightButtonCheck() {
//		   MainPage mp = new MainPage();
//           BookingFlightPage bf = new BookingFlightPage();
//           
//           mp.bookingAFlight(); //My Method that will bring me to "Book a Flight Page"
//           
//	       //Pick sort by duration
//           
//           BrowserUtilities.waitFor(5);
//           
//           JavascriptExecutor js=(JavascriptExecutor)Driver.getDriver();
//            js.executeScript("window.scrollBy(0,100)");
//            
//           Select s = new Select(bf.sortMenuButton);
//       	
//       	   s.selectByValue("leg0departuretime:asc");
//		
//		       
//        //Click on select first flight
//       	   
//       	   bf.selectButton.click();
//       	   
//       	//Turn off the pop up
//       	   BrowserUtilities.waitFor(5);
//       	actions = new Actions(Driver.getDriver()); 
//		    actions.moveToElement(bf.noThanksButton2).click().build().perform(); 
//		    BrowserUtilities.waitFor(5);
//		    
//		    //Switching handle
//		    String parentWindowHandle=driver.getWindowHandle();
//		
//		Set<String> allHandles = driver.getWindowHandles();
//		
//		
//		for (String handle : allHandles) {
//			if(!handle.equals(parentWindowHandle)) {
//				driver.switchTo().window(handle);
//				
//			}
//		}
//		BrowserUtilities.waitFor(5);
//       	js.executeScript("arguments[0].scrollIntoView(true);", bf.contBookingButton);
//       	
//       	//js.executeScript("window.scrollBy(0,700)"); //Does NOT scroll!! WHY??
//		
//		//Confirm that we landed on Flight Details Page
//		
//		String expected = "Trip Detail | Travelocity";
//		String actual = Driver.getDriver().getTitle();
//		
//		SoftAssert sa = new SoftAssert();
//		sa.assertEquals(actual, expected);
//		
//		//Press Continue Booking Button, Confirm we go to another page
//		BrowserUtilities.waitFor(5);
//		Actions actions = new Actions(driver);
//		actions.moveToElement(bf.contBookingButton);
//		actions.perform();
//		BrowserUtilities.waitFor(10);
//		
//		String expected1 = "Travelocity: Payment";
//		String actual1 = Driver.getDriver().getTitle();
//		sa.assertEquals(actual1, expected1);
//       	 
//	}
	


	@Test (priority = 9)
	public void flightPaymentTest() {
		   MainPage mp = new MainPage();
           BookingFlightPage bf = new BookingFlightPage();
           mp.bookingAFlight(); //My Method that will bring me to "Book a Flight Page"
           
	       //Pick sort by duration
           BrowserUtilities.waitFor(5);
           JavascriptExecutor js=(JavascriptExecutor)Driver.getDriver();
            js.executeScript("window.scrollBy(0,100)");
           Select s = new Select(bf.sortMenuButton);
       	   s.selectByValue("price:asc");
       	   //Change flight options to 3 adults
       	   actions.moveToElement(bf.showOptions).click().build().perform(); 
		   BrowserUtilities.waitFor(5);
       	   //bf.showOptions.click();
//           Select s1 = new Select(bf.selectAdultsNo);
//    	   s.selectByValue("3");
		   bf.selectAdultsNo.click();
		   Driver.getDriver().findElement(By.xpath("(//select//option[@value='3'])[1]")).click();
		   
		       
        //Click on select first flight
       	   bf.selectButton.click();
       	//Turn off the pop up Alert
       	   BrowserUtilities.waitFor(5);
       	   actions = new Actions(Driver.getDriver()); 
		   actions.moveToElement(bf.noThanksButton2).click().build().perform(); 
		   BrowserUtilities.waitFor(5);
		    
		    //Switching handle
		    String parentWindowHandle=driver.getWindowHandle();
		    Set<String> allHandles = driver.getWindowHandles();
		
		for (String handle : allHandles) {
			if(!handle.equals(parentWindowHandle)) {
				driver.switchTo().window(handle);
			}
		}
		BrowserUtilities.waitFor(5);
       	js.executeScript("arguments[0].scrollIntoView(true);", bf.contBookingButton);
       	
		//Press Continue Booking Button
		BrowserUtilities.waitFor(5);
		Actions actions = new Actions(driver);
		actions.moveToElement(bf.contBookingButton);
		actions.perform();
		BrowserUtilities.waitFor(5);
		
		//Using Data Provider
		
		
			
			
		}
		

	
//
//        @DataProvider (name = "booking info")
//		public Object[][] get(){
//			return new Object[][] {
//				{, , ,}
//				{, , ,}
//				{, , ,}
//			};
//        }
	
	
	
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
	

	
}
