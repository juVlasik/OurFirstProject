package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class GetInspiredPage {

public  GetInspiredPage() {
		
		PageFactory.initElements(Driver.getDriver(), this); // This statement is initializing the variables that are tagged
															//with @FindBy annotations
		 
	}


    @FindBy (xpath = "//a[@class='entry-featured-image-url']")
    public List<WebElement> mostPolpularLinks;
	
	
	@FindBy (xpath = "//span[@data-lbl='thingstodolbl']")
	public WebElement thingsToDoButton;
	
	@FindBy (xpath = "//input[@id='action-Destination']")
	public WebElement destInputBox;
	
	@FindBy (xpath = "//input[@id='action-startDate']")
	public WebElement checkInputField;
	
	@FindBy (xpath = "//input[@id='action-endDate']")
	public WebElement outInputField;
	
	@FindBy (xpath = "//button[@id='action-searchButton']")
	public WebElement serchButton;
	
//	@FindBy ()
//	public WebElement ; 
	
	@FindBy (xpath = "(//table[@class='ui-datepicker-calendar'])[2]//td")
	public List<WebElement> inCalDates;
	
	@FindBy (xpath = "(//table[@class='ui-datepicker-calendar'])[2]//td")
	public List<WebElement> outCalDates;
	
//	@FindBy (xpath = "//button[@id='H-searchButtonExt1']")
//	public WebElement serchButton;
	
}
