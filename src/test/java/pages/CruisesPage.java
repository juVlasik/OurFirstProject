package pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BrowserUtilities;
import utilities.Driver;

public class CruisesPage {

	public CruisesPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	@FindBy(xpath = "//button[@id='tab-cruise-tab-hp']")
	public WebElement cruisePageMenu;
	@FindBy(id = "cruise-destination-hp-cruise")
	public WebElement cruiseDestination;
	@FindBy(id = "cruise-start-date-hp-cruise")
	public WebElement DepartsAsEarlyAs;
	@FindBy(id = "cruise-end-date-hp-cruise")
	public WebElement DepartsAsLateAs;
	@FindBy(xpath = "(//div//table[@class='datepicker-cal-weeks'])[2]//td")
	public List<WebElement> picktUpDateButton;
	@FindBy(xpath = "(//div//table[@class='datepicker-cal-weeks'])[2]//td")
	public List<WebElement> dropOffDateButton;
	@FindBy(id = "cruise-adults-hp-cruise")
	public WebElement AdultsNum;
	@FindBy(id = "cruise-children-hp-cruise")
	public WebElement ChildrenNum;
	@FindBy(id = "cruise-children-age-select-1-hp-cruise")
	public WebElement ChildrenAge;
	@FindBy(xpath = "//*[@id=\"gcw-cruises-form-hp-cruise\"]/div[3]/label/button")
	public WebElement SearchButton;
	
	
	public void BookCruises() {
		cruisePageMenu.click();
		BrowserUtilities.waitFor(2);
		cruiseDestination.sendKeys("Alaska");
		BrowserUtilities.waitFor(2);
		JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
		js.executeScript("window.scrollBy(0,400)");
		DepartsAsEarlyAs.click();
		for (int i = 0; i < picktUpDateButton.size(); i++) {
			String date = picktUpDateButton.get(i).getText();
			if (date.contains("20")) {
				picktUpDateButton.get(i).click();
				break;
			}
		}
		DepartsAsLateAs.click();
		for (int i = 0; i < dropOffDateButton.size(); i++) {
			String date = dropOffDateButton.get(i).getText();
			if (date.contains("18")) {
				dropOffDateButton.get(i).click();
				break;
			}
		}
		AdultsNum.sendKeys("1");
		BrowserUtilities.waitFor(2);
		ChildrenNum.sendKeys("1");
		BrowserUtilities.waitFor(2);
		ChildrenAge.sendKeys("6");
		BrowserUtilities.waitFor(2);
		SearchButton.click();
	}
	
	
	
	
}
