package pages;

import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class ListYourPropertyPage {
	
public  ListYourPropertyPage() {
		
		PageFactory.initElements(Driver.getDriver(), this); // This statement is initializing the variables that are tagged
															//with @FindBy annotations
		 
	}

	@FindBy (xpath = "(//span[.=\"List your property\"])[1]")
	public WebElement listPropertyButton; 
	
	@FindBy (xpath = "//button[@id='containDetailSubmit']")
	public WebElement submitButton; 
	
	@FindBy (xpath = "//input[@name='localFirstName']")
	public WebElement firstNameInput; 
	
	@FindBy (xpath = "//input[@name='localLastName']")
	public WebElement lastNameInput;  
	
	@FindBy (xpath = "//input[@name='emailAddress']")
	public WebElement emailInput; 
	
	@FindBy (xpath = "//input[@id='phoneNumber']")
	public WebElement phoneNoInput; 
	
//	@FindBy (xpath = "")
//	public WebElement listPropertyButton; 
	
	
	
	public void listYourProperty() {
		
		MainPage mp = new MainPage();
		
		
		mp.listYourProperty.click();
		
		//Switching handle
	    String parentWindowHandle=Driver.getDriver().getWindowHandle();

	    Set<String> allHandles = Driver.getDriver().getWindowHandles();


	    for (String handle : allHandles) {
		if(!handle.equals(parentWindowHandle)) {
			Driver.getDriver().switchTo().window(handle);
			
		}
	}
	    String currentWindowHandle = Driver.getDriver().getWindowHandle();
	    
		listPropertyButton.click();
		
		//Switching handle again
		    //String mostCurrent = Driver.getDriver().getWindowHandle();
			for (String handle : Driver.getDriver().getWindowHandles()) {
				if (!(currentWindowHandle.equals(handle)) && !(currentWindowHandle.equals(parentWindowHandle))) {
					Driver.getDriver().switchTo().window(handle);	
				}	
			}

			submitButton.click();
	}
	
	
	
	
	
}
