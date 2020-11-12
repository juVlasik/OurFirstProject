package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utilities.ConfigReader;
import utilities.Driver;

public abstract class TestBase {

	protected WebDriver driver;
	protected Actions actions;


		@BeforeMethod (alwaysRun = true)
		@Parameters ("browser")
		public void setUpMethod(@Optional String browser) {
			
			driver = Driver.getDriver(browser);
			actions = new Actions(driver);
			driver.manage().timeouts().implicitlyWait(
					Long.parseLong(ConfigReader.getProperty("implicitWait")), TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(ConfigReader.getProperty("url"));
			
		}
		

		
		
		@AfterMethod (alwaysRun = true)
		public void tearDownMethod()  {
			
			Driver.quit();
		}
	
	
}
