package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage  extends TestBase {

	@FindBy(xpath="//td[contains(text(),'User: suraj gorawade')]")
	WebElement UserNameLabel;
	
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement taskLinks;
	
	//initialize
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();		
	}
	
	public  boolean verifyCorrectUsername(){
		return UserNameLabel.isDisplayed();
		
	}
	public  ContactPage clickOnContactLinks(){
		contactsLink.click();
		return new ContactPage();
	}
	public  DealsPage clickOnDealsLinks(){
		dealsLink.click();
		return new DealsPage();
	
}
	public  TasksPage clickOnTaskPageLinks(){
		taskLinks.click();
		return new TasksPage();
	
}
	public void ClickOnNewContactList(){
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
	}

}
