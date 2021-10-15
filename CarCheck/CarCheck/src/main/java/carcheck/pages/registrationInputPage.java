package carcheck.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.google.common.annotations.VisibleForTesting;

import carcheck.base.carcheckBase;

public class registrationInputPage extends carcheckBase{

	//Defining the page objects 
	// As this task involves usage of only 2 elements, not all objects available in this page are defined
	
	@FindBy(xpath = "//input[@id='vrm-input']")
	WebElement regInput;
	
	@FindBy(xpath = "//button[text()='Free Car Check']")
	WebElement checkBtn;
	
	@FindBy(className = "jsx-562149321")
	WebElement errAlert;
	
	@FindBy(xpath = "//span[text()='Vehicle Not Found']")
	WebElement vehicleNotFound;
	
	public registrationInputPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String ValidatePageTitle() {
		return driver.getTitle();
	}
	
	public vehicleIdentityPage freeCheck(String rInput) {
		regInput.sendKeys(rInput);
		checkBtn.click();
		return new vehicleIdentityPage();
	}
	
	public boolean freeCheckError(String rInput) {
		regInput.sendKeys(rInput);
		checkBtn.click();
		wait.until(ExpectedConditions.titleContains("Car Tax Check | Free Vehicle Check | " + rInput));
		wait.until(ExpectedConditions.visibilityOf(vehicleNotFound));
		return true;
		
		
	}
}
