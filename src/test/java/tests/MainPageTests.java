package tests;

import static org.testng.Assert.assertEquals;



import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import pages.MainPage;


import utilities.ConfigReader;
import utilities.Driver;

public class MainPageTests extends TestBase{
	
	
	@Test
	public void runButtonTest() {
		MainPage mp = new MainPage();
		mp.runButton.click();
		
		String expected = "Hello World";
		String actual = mp.outputText.getText();
		
		Assert.assertEquals(actual, expected);
	}
	
	
	@Test
	
	public void shareButtonTest() {
		
		MainPage mp = new MainPage();
		mp.shareButton.click();
		String shareLink = "https://dotnetfiddle.net/";
		
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.attributeContains(mp.shareFieldInput, "value", shareLink))); 
		
		String link = mp.shareFieldInput.getAttribute("value");
		
		
		Assert.assertTrue(link.contains(shareLink));
		
	}
	


	
}


