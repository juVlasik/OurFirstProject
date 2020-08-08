package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.MainPage;

public class LoginPageTests extends TestBase{

	

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

                                                           
	
	
	
}
