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
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;


//@Listeners(com.crm.qa.testcases.TestNGListener.class)
public class LoginPageTest extends TestBase{
	
	LoginPage loginpg;
	HomePage homepgobj;
	
	
	public LoginPageTest() {
		super();//this will call the TestBase class constructor .will initialize super class constructor properties
	}
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginpg=new LoginPage();
	}
	
	
	
	@Test(priority=1)
	public void loginPageTitleTest() {
	
		String title=loginpg.validateLoginPageTitle();
		System.out.println("Page Title :"+title);
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	
	@Test(priority=2)
	public void crmLogoImageTest() {
		boolean flag=loginpg.validateCrmImage();
		Assert.assertTrue(flag);
	}
	
	
	@Test(priority=3)
	public void loginTest() throws InterruptedException {
		homepgobj =loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	

	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
}
