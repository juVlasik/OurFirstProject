package tests;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.CarRentalPage;
import pages.MainPage;
import utilities.BrowserUtilities;
import utilities.Driver;

public class CarRentalPageTests extends TestBase{


	//test 10 //Inserting info at Car Rental Payment Page

	@Test (dataProvider="car booking info", groups = {"sprint2"})   

	public void fcarRentPaymentPageWithdataProvider(String name, String phoneNo, 
			String email, String password, String password2)throws InterruptedException {   
		
		MainPage mp = new MainPage();
		CarRentalPage cr = new CarRentalPage();
		
		mp.rentACar();  //calling my car rental method
		BrowserUtilities.waitFor(5);
		
		cr.reserveButton.click(); // Landing on car review page and clicking Reserve button
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
				
				{"John Doe","5711234567" ,"jdoe.11@gmail.com" , "jdoejdoe", "jdoejdoe"},
				{"Jane Doe", "5714567890", "jdoe.01@gmail.com", "blahblah", "blahblah"}
				
			};
	    }
	
	
	


@Test (groups = {"sprint2"})//test 8

public void carRentPaymentPageVerification() {
	
	MainPage mp = new MainPage();
	CarRentalPage cr = new CarRentalPage();
	
	mp.rentACar();
	BrowserUtilities.waitFor(5);
	
	cr.reserveButton.click();
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

cr.reserveButton2.click();

String expected = "Travelocity: payment";
String actual = Driver.getDriver().getTitle();
	
SoftAssert sa = new SoftAssert();
sa.assertEquals(actual, expected);

	
	
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



	    
	    
	    
	
}
