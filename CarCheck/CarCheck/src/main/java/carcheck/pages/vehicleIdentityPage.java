package carcheck.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import carcheck.base.carcheckBase;
import carcheck.util.carcheckUtil;

public class vehicleIdentityPage extends carcheckBase{
	


	@FindBys(@FindBy(xpath="//div[@class='jsx-1488133405 m-w-1 d-w-3 p-w-1']//child::div[@class='jsx-1843467667    ']//child::div[@class='jsx-3807182525 ']//child::span[@class='jsx-2222053380']//child::div[@class='jsx-3499070155']"))
	//@FindBys(@FindBy(xpath="//div[@class='jsx-1488133405 m-w-1 d-w-3 p-w-1']//child::div[@class='jsx-1843467667    ']//child::div[@class='jsx-3807182525 ']"))
	List<WebElement> vehicleDtls;
	
	@FindBy(xpath="//div[@class='jsx-1488133405 m-w-1 d-w-3 p-w-1']//child::div[@class='jsx-1843467667    ']//child::div[@class='jsx-3807182525 ']//child::span[@class='jsx-2222053380']//child::div[@class='jsx-3499070155']//child::dl[@class='jsx-3517272246 ']//child::dt[@class='jsx-1051216822']")
	WebElement header;

	
	@FindBy(xpath="//h4[text()='Vehicle Identity']")
	WebElement headerValue;
	
	
	
	public List<WebElement> getVehicleDtls() {
		System.out.println("in fetch");
        return vehicleDtls;
    }
	
	public vehicleIdentityPage() {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
		
	}
	
	public String ValidatePageTitle() {
		return driver.getTitle();
	}
	
	
	public boolean vDtlsPrint(String iReg){
		String concat = "";
		String listToString  ="";
		carcheckUtil ccu = new carcheckUtil();
		ArrayList<String> vehicleOutput = ccu.readOutputFileValidation(iReg);
		List<WebElement> vDtls = getVehicleDtls();
		for (int i=0; i < vDtls.size(); i++) {
			listToString = vDtls.get(i).getText().substring(0,vDtls.get(i).getText().indexOf("Registered"));			
		}
		
		for (int y = 0; y<vehicleOutput.size(); y++) {						
			concat = concat + vehicleOutput.get(y) + Character.toString((char) 10);
		}
		
		if (concat.compareToIgnoreCase(listToString) == 0) {
			return true;
		} else
		{
			return false;
		}


		
		
	}

}
