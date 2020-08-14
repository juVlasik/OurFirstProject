package tests;

import java.io.IOException;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.ListYourPropertyPage;
import pages.MainPage;
import utilities.BrowserUtilities;
import utilities.CSVUtility;
import utilities.Driver;

public class ListPropertyPageTests extends TestBase{

	
	@Test (groups = {"sprint3"}, dataProvider = "file")
	public void listYourPropertyDDTest(String firstName, String lastName, String email, String phoneNo) throws InterruptedException  {
	
	ListYourPropertyPage lp = new ListYourPropertyPage();
	
	lp.listYourProperty();
	
		lp.firstNameInput.sendKeys(firstName);
		lp.lastNameInput.sendKeys(lastName);
		lp.emailInput.sendKeys(email);
		lp.phoneNoInput.sendKeys(phoneNo);
		lp.submitButton.click();
		BrowserUtilities.waitFor(5);
		
		String actualTitle = Driver.getDriver().getTitle();
		String expectedTitle = "Property Info - Join Expedia";
		
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	
	
	@DataProvider (name ="file")

	public Object[][] getDataFromCSV() throws IOException{
			
			return CSVUtility.extractData("MOCK_DATA.csv");
	
	}
}
