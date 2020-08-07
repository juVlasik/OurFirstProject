package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.MainPage;

public class MobilePageTest extends TestBase {

	
	
	@Test 
	public void mobileTabTest() throws Exception { //TEST WILL CLICK ON MOBILE TAB AND PASS A RANDOM NUMBER TO A PHONE NUMBER TAB
	MainPage mp = new MainPage();
	mp.mobileButton.click();
	
	Thread.sleep(2000);
	
	WebElement phoneNumBox = driver.findElement(By.xpath("//*[@id=\"appDLPhoneNumber\"]"));
	
	int randomFour = (int)(Math.random()*9000)+1000;
	String phoneNum = "570899" + randomFour;
       
       
	phoneNumBox.sendKeys(phoneNum + Keys.ENTER);
	driver.findElement(By.xpath("//*[@id=\"appDL-btn-action\"]")).click();
	WebElement message = driver.findElement(By.xpath("//*[@id=\"successMessage\"]/span"));
	String m = message.getText();
	
	System.out.println(m);
	
	assertTrue(m.contains("We’ve sent you a text message"));
	}

	
	
	
	
}
