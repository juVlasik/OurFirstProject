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
import pages.HotelsBookingPage;
import pages.MainPage;
import pages.ThingsToDoPage;
import utilities.BrowserUtilities;
import utilities.ConfigReader;
import utilities.Driver;

public class MainPageTests extends TestBase {

<<<<<<< HEAD
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
=======
	@Test  //test 1
    public void successfulMoveToCarRenetalPage() {
    	MainPage mp = new MainPage();
    	mp.rentACar();
    	BrowserUtilities.waitFor(5);
>>>>>>> 965f96ba1ad16e6f4c10e393bec658608d0dcee8
    	
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
    
    
    
    

     @Test  (groups = {"newTest"})  //test 3 
     public void successfulMoveToThingsToDoPage() {
    	 MainPage mp = new MainPage();
    	 
    	 mp.thingsToDoButtonTest();
    	 
     }


	@Test    //test 4
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
		
	
		

@Test
//test 6
public void negativeLogin2() { //trying to Login with wrong username and NO password
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
}

                                                                                                                                        


@Test (groups = {"newTest"})//test 7
public void travelInspirationlinks() {
	
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








@Test (groups = {"newTest"})//test 8

public void carRentPaymentPageVerification() {
	
	MainPage mp = new MainPage();
	CarRentalPage cr = new CarRentalPage();
	
	mp.rentACar();
	BrowserUtilities.waitFor(5);
	
	cr.reserveButton.click();
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

cr.reserveButton2.click();

String expected = "Travelocity: payment";
String actual = Driver.getDriver().getTitle();
	
SoftAssert sa = new SoftAssert();
sa.assertEquals(actual, expected);

	
<<<<<<< HEAD
	    mp.signinPassword.sendKeys(Keys.TAB);
	    
	    mp.signinButton.click();
	    
	    String actual = mp.errorMessage.getText();
	    String expected = "Please enter a password";
	    
	    assertEquals(actual, expected); //Checking if error message pops up if we don't provide a password for Login
	}
	JULIAS CODE END
	    */
	
=======
>>>>>>> 965f96ba1ad16e6f4c10e393bec658608d0dcee8
	
}





@Test (groups = {"newTest"})//test 9
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
	    String parentWindowHandle=driver.getWindowHandle();
	
	Set<String> allHandles = driver.getWindowHandles();
	
	
	for (String handle : allHandles) {
		if(!handle.equals(parentWindowHandle)) {
			driver.switchTo().window(handle);
			
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



@Test (dataProvider="car booking info", groups = {"newTest"})   //test 10 //Inserting info at Car Rental Payment Page

public void fcarRentPaymentPageWithdataProvider(String name, String phoneNo, 
		String email, String password, String password2)throws InterruptedException {   
	
	MainPage mp = new MainPage();
	CarRentalPage cr = new CarRentalPage();
	
<<<<<<< HEAD
	@Test //(priority = )
	public void successfulMoveToHotelsPage()  {
		
		HotelsBookingPage hpg = new HotelsBookingPage();
		
		hpg.verifyLandingHotelsPage();
		
		hpg.searchHotelIstanbul();
		hpg.pickCheckinDate();
		BrowserUtilities.waitFor(3);
		hpg.pickCheckoutDate();
		hpg.buttonDone.click();
		hpg.clickSearchButton.click();
	    BrowserUtilities.waitFor(5);
	    hpg.sortBy.click();
	    BrowserUtilities.waitFor(3);
	    hpg.sortByprice.click();
	    BrowserUtilities.waitFor(10);
	    hpg.searchByProperty();
	    
	
=======
	mp.rentACar();  //calling my car rental method
	BrowserUtilities.waitFor(5);
	
	cr.reserveButton.click(); // Landing on car review page and clicking Reserve button
	BrowserUtilities.waitFor(5);
	
    //Switching handle
    String parentWindowHandle=driver.getWindowHandle();

Set<String> allHandles = driver.getWindowHandles();


for (String handle : allHandles) {
	if(!handle.equals(parentWindowHandle)) {
		driver.switchTo().window(handle);
		
>>>>>>> 965f96ba1ad16e6f4c10e393bec658608d0dcee8
	}
}

BrowserUtilities.waitFor(5);

cr.reserveButton2.click(); //Switched handles and landing on Car Rental Payment page
	//Passing my values from Data Provider

	cr.nameField.sendKeys(name);
	cr.phoneField.sendKeys(phoneNo);
	cr.emailField.sendKeys(email);	
	cr.passwordField.sendKeys(password);	
	cr.passwordConfirmField.sendKeys(password2);	
	
	cr.radioButton.click();
	cr.reserveNowButton.click();
	
	BrowserUtilities.waitFor(5);
	//cr.noThanksButton.click();
	
	Actions actions = new Actions(driver);
	actions.moveToElement(cr.noThanksButton);
	BrowserUtilities.waitFor(5);
	SoftAssert sa = new SoftAssert();
	
	String expectedText = "Thank you! Your trip is booked.";
	String actualText = cr.confirmationMessage.getText();
	sa.assertEquals(actualText, expectedText);
	
	String actualTitle = Driver.getDriver().getTitle();
	String expectedTitle = "Travelocity: Confirmation";
	BrowserUtilities.waitFor(5);
	sa.assertEquals(actualTitle, expectedTitle);
	}
	



    @DataProvider (name = "car booking info")
	public Object[][] get(){
		return new Object[][] {
			{"John Doe","5711234567" ,"jdoe.11@gmail.com" , "jdoejdoe", "jdoejdoe"}
			
		};
    }



	
//	@Test //Saha's test
//    
//	public void successfulMoveToHotelsPage()  {
//		
//		HotelsBookingPage hpg = new HotelsBookingPage();
//		
//		hpg.verifyLandingHotelsPage();
//		
//		hpg.searchHotelIstanbul();
//	}
//
}


