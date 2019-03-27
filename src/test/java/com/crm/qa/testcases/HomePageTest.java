package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	TestUtil testutil;
	LoginPage loginpg ;
	HomePage homepgobjvari;
	ContactPage contactpageOBJvari;
	
	
	public HomePageTest() {
		super();
	}
	
	
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		
		initialization();
		testutil=new TestUtil();
		loginpg = new LoginPage();
		contactpageOBJvari =new ContactPage();  
		homepgobjvari=loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homepageTitle=homepgobjvari.varifyHomePageTitle();
		Assert.assertEquals(homepageTitle, "CRMPRO", "Home page title not matched");
	}
	
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		testutil.switchToFrame();
		Assert.assertTrue(homepgobjvari.verifyCorrectUserName());
	}
	
	
	@Test(priority=3)
	public void verifyContactsLinkTest() {
		testutil.switchToFrame();
		contactpageOBJvari=homepgobjvari.clickOnContactsLik();
	}
	
	//now lets verify that when i am land on contact page how coud I confirm
	
	
	
	
	
	
	

	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
