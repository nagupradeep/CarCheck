package carcheck.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import carcheck.base.carcheckBase;
import carcheck.pages.registrationInputPage;


public class registrationInputPageTest extends carcheckBase{

		// Defining registrationInputPage Object
		registrationInputPage ripg;
		
		public registrationInputPageTest() {
			super();			
		}
		
		@BeforeMethod
		public void setup() {
			initialiaztion();
			ripg = new registrationInputPage();
		}
		
		@Test
		public void validateTitleTest() {
			Assert.assertEquals(ripg.ValidatePageTitle(),"Car Tax Check | Free Car Check");			
		}
		
		@Test
		public void inputRegistration(String reg) {
			ripg.freeCheck(reg);			
		}
		
		@AfterMethod
		public void teardown() {
			driver.quit();
		}
}
