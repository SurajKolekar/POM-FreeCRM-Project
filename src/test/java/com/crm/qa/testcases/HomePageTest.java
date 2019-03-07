package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

import junit.framework.Assert;

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testUtil;
	ContactPage contactPage;
	public HomePageTest(){
		super();
}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		testUtil=new TestUtil();
		loginpage = new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	} 
		
	@Test
	public void verifyHomePageTitleTest(){
		 String homePageTitle = homepage.verifyHomePageTitle();
		 Assert.assertEquals(homePageTitle, "CRMPRO","Home Page title not matched");
		
	}
	
	@Test
	public void verifyUserName(){
		testUtil.switchToFrame();
		Assert.assertTrue(homepage.verifyCorrectUsername());
	}
	
	@Test(priority=1)
	public void verifyContactsLinkTest(){ 
		testUtil.switchToFrame();
		contactPage =homepage.clickOnContactLinks();
		
	}
	
	
	
	
		@AfterMethod
		public void teardown(){
			driver.quit();
		}
		
	}