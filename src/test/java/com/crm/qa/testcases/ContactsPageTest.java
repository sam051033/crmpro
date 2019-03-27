
/*
 * author name : mohammad.mamun
 * */


package com.crm.qa.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	TestUtil testutil;
	LoginPage loginpg ;
	HomePage homepgobjvari;
	ContactPage contactpageOBJvari;
	
	String sheetName = "contacts";
	
	ContactsPageTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setUP() throws InterruptedException {
		initialization();
		testutil = new TestUtil();
		loginpg = new LoginPage();
		contactpageOBJvari = new ContactPage();
		homepgobjvari = loginpg.login(prop.getProperty("username"),prop.getProperty("password"));
		testutil.switchToFrame();
		contactpageOBJvari=homepgobjvari.clickOnContactsLik();
		
		
	}
	
	
	@Test(priority=1)
	public void verifyContactPageLevelTest() {
		Assert.assertTrue(contactpageOBJvari.verifyCOntactsLabel(), "contact level name is missing");;
		//Assert.assertTrue(flag, "contacts label is missing on the page");
	}
	
	
	@Test(priority=2)
	public void selectSingleContact() {
		contactpageOBJvari.selectContactsByName("moin rahman");
	}
	
	
	@Test(priority=3)
	public void selectMutipleContact() {
		contactpageOBJvari.selectContactsByName("den van");
		contactpageOBJvari.selectContactsByName("karim gazi");
	}
	
	
	
	
	@DataProvider
	public Object[][] getCRMTestData() {
		
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	
	
	
	@Test(priority=4, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title,String firstName, String LastName, String company) {
		homepgobjvari.clickOnNewContactLink();
		contactpageOBJvari.createNewContact(title, firstName, LastName, company);
	}
	
	
//	@Test(priority=4)
//	public void validateCreateNewContact() {
//		homepgobjvari.clickOnNewContactLink();
//		contactpageOBJvari.createNewContact("Mrs.", "shamsunnahar", "begum", "facebook");
//	}	
	
	
//
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
