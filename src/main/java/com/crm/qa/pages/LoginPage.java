package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//page factory or object repository(OR)
	//=====================================
	
	@FindBy(name="username") 
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginButton;
	
	@FindBy(css="a[href='https://classic.crmpro.com/register/']")
	WebElement signup;
	
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]") 
	WebElement crmLogo;
	
	
	
	
	//initializing the page elements thru constractor
	public LoginPage() {
		PageFactory.initElements(driver, this); //we can also put "this" instead of LoginPage.class
	}
	
	
	//Actions
	public String validateLoginPageTitle() {
		 return driver.getTitle();
		
	}
	
	
	
	public boolean validateCrmImage() {
		return crmLogo.isDisplayed();
	}
	
	

	
	public HomePage login(String uname ,String pass) throws InterruptedException {
		username.sendKeys(uname);
		password.sendKeys(pass);
		Thread.sleep(2000);
		loginButton.click();
		//after login it is going to home page .so it will return homepage object
		
		
		return new HomePage();
	}
	
	
	
	
	
	
	
	
	

}
