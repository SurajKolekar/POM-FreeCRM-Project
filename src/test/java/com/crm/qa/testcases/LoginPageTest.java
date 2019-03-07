package com.crm.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
LoginPage loginpage;
HomePage homepage;
public LoginPageTest(){
	super();
}
@BeforeMethod
public void setUp(){
	initialization();
	loginpage = new LoginPage();
}
@Test(priority=1)
public void loginPageTitleTest(){
	String title=loginpage.validateLoginPageTitle();
	Assert.assertEquals(title, "CRMPRO  - CRM software for customer relationship management, sales, and support");
}


@Test(priority=2)
public void loginTest(){
	homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	
}
@Test
public void Application_Title(){
	// Actual title
			String my_title = driver.getTitle();
			System.out.println("page title is " + my_title);
			System.out.println("..................");

			// expected title
			String expected_title = "CRMPRO";
			Assert.assertEquals(my_title, expected_title);
			System.out.println("************************");
			
	
}
@Test
public void verify_Title(){
	String stitle = driver
			.findElement(By.xpath("html/body/div[2]/div/div[1]/a/img")).getText();
	String exp = "CRMPRO";
	Assert.assertEquals(stitle, exp);
	System.out.println("Application title verify " + stitle);
	System.out.println("**********************");
}

@AfterMethod
public void teardown(){
	driver.quit();
}
}
