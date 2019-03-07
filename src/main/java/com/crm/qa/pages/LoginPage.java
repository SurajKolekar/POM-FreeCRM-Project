package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	 // object repositry / pagefactory
	
	@FindBy(name ="username")
	WebElement Username;

	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement LoginBtn;

	
	@FindBy(xpath="//a[@href='https://classic.crmpro.com/register/']")
	WebElement Signup;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	//Actions
	public  String validateLoginPageTitle(){
		return driver.getTitle();
		
	}
	
	public HomePage login(String un,String pwd){
		Username.sendKeys(un);
		Password.sendKeys(pwd);
		LoginBtn.click();
		return new HomePage();
		
	}
}

