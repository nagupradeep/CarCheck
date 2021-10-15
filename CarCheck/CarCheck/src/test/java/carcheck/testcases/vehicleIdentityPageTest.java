package carcheck.testcases;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import carcheck.base.carcheckBase;
import carcheck.pages.registrationInputPage;
import carcheck.pages.vehicleIdentityPage;
import carcheck.util.carcheckUtil;

public class vehicleIdentityPageTest extends carcheckBase{

	registrationInputPage ripg;
	vehicleIdentityPage vipg;
	carcheckUtil ccu;
	
	public vehicleIdentityPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialiaztion();
		ripg = new registrationInputPage();
		vipg = new vehicleIdentityPage();
		ccu = new carcheckUtil();
	}
	
	@DataProvider
	public static Iterator<String> passRegNumbers(){
		 ArrayList<String> registrationL = carcheckUtil.readInputFile("Input");		 
		 return registrationL.iterator();
	}
	
	@Test (dataProvider="passRegNumbers")
	public void vehicleTestOne(String regNum) {		
			ripg.freeCheck(regNum);	
			//The space in the input has been removed here because the site does not take in the space and so the title is displayed with out space
			//to progress the title check the space is removed, but since the test output file does not have the space the test still fails
			//it would be better to remove the space as part of test data validation and pass it to code, i have tested that and commented it 
			//so 2 tests fail and 2 tests pass now. if we reove the space 3 tests would pass and 1 would fail
			wait.until(ExpectedConditions.titleContains("Car Tax Check | Free Vehicle Check | " + regNum.replace(" ", "")));
			boolean status = vipg.vDtlsPrint(regNum);
			Assert.assertEquals(status, true);			
	}		

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
}
