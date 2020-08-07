package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class ThingsToDoPage {

public  ThingsToDoPage() {
		
		PageFactory.initElements(Driver.getDriver(), this); // This statement is initializing the variables that are tagged
															//with @FindBy annotations	
	}
	

@FindBy (xpath = "//button[@id='activity-start-date-btn']")
public WebElement calStartDate;

@FindBy (xpath = "//span[contains(text(),\"Search\")]")
public WebElement calSearchButton;

@FindBy (xpath = "//button[@id='activity-end-date-btn']")
public WebElement calEndDate;

@FindBy (xpath = "(//div[@class='uitk-new-date-picker-month'])[2]//td")
public List<WebElement> calStartDates;

@FindBy (xpath = "(//table[@class='uitk-new-date-picker-weeks'])[2]//td")
public List<WebElement> calEndDates;

@FindBy (xpath = "//input[@id='cb-New on Expedia-categories']")
public WebElement newOnTButton;

@FindBy (xpath = "(//input[@name='sortRadioGroup'])[2]")
public WebElement sortLToH;	




}
