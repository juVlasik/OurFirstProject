package pages;

import java.util.List;

import org.apache.xerces.impl.xpath.XPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import utilities.Driver;

public class MainPage {

        public  MainPage() {
		
		PageFactory.initElements(Driver.getDriver(), this); 
		 
	}
	
        
        
        
        @FindBy (id = "run-button")
        public WebElement runButton;
        
        @FindBy (xpath = "//div[@id='output']")
        public WebElement outputText;
        
        @FindBy (xpath = "//button[@id='Share']")
        public WebElement shareButton;
        
        @FindBy (xpath = "//input[@id='ShareLink']")
        public WebElement shareFieldInput;  
        
        
}

        
