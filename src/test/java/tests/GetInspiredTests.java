package tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import pages.GetInspiredPage;
import pages.MainPage;
import utilities.BrowserUtilities;
import utilities.Driver;

public class GetInspiredTests extends TestBase {

	
	
//	@Test (groups = {"sprint3"})//sprint 3
//	public void mostPopularLinksVarification() {
//		
//		GetInspiredPage gi = new GetInspiredPage();
//		MainPage mp = new MainPage();
//		
//		mp.getInspiredButton.click();
//		BrowserUtilities.waitFor(5);
//		
//		
//		
//		
//	JavascriptExecutor js=(JavascriptExecutor)Driver.getDriver();
//    js.executeScript("window.scrollBy(0,400)");
//    BrowserUtilities.waitFor(5);
//    //List<String> actualLinks = new ArrayList<String>();
//    
//    //looping through my list of links and making sure they're all functional
//    
//        for (int i = 1; i <= gi.mostPolpularLinks.size(); i++) {
//	
//        gi.mostPolpularLinks = Driver.getDriver().findElements(By.xpath(
//        		"//a[@class='entry-featured-image-url']"));
//        Driver.getDriver().findElement(By.xpath("(//a[@class='entry-featured-image-url'])[" + i + "]")).click();
//		
//		BrowserUtilities.waitFor(10);
//		
//		System.out.println(Driver.getDriver().getTitle());
//		//actualLinks.add(Driver.getDriver().getTitle());
//		
//		Driver.getDriver().navigate().back();
//		
//		BrowserUtilities.waitFor(10);
//		js.executeScript("window.scrollBy(0,100)");
//		
//		//come up with assertion
//	}
//	
//	}
//	
	
	
}
