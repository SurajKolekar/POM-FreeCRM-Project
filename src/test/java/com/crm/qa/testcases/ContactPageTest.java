/*author-- suraj kolekar*/
package com.crm.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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

public class ContactPageTest  extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testUtil;
	ContactPage contactPage;
	String sheetName ="Contacts";
	 
	public ContactPageTest(){ 
		super();
	}
	@BeforeMethod
	public void setUp(){
		initialization();
		testUtil=new TestUtil();
		contactPage= new ContactPage();
		loginpage = new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactPage=homepage.clickOnContactLinks();
	} 

	@Test(priority=3)
	public void verifyContactPageLabel(){
		Assert.assertTrue(contactPage.verifyContactsLabel(),"contact label is missing on the page");	
		}
	@Test(priority=2)
	public void selectContactTest(){
		 contactPage.SelectContactByName("suraj gorawade");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() throws InvalidFormatException{
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=1, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title,String ftName,String ltName,String comp){
		 homepage.ClickOnNewContactList(); 
		 //contactPage.CreateNewContact("Mr.", "suraj", "kolekar", "BNP paribas");
		 contactPage.CreateNewContact(title, ftName, ltName, comp);
	}
	@AfterMethod
	public void teardown(){
		driver.quit(); 
	}
	
}
	
	
	

