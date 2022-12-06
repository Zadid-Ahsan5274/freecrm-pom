package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;

	public ContactPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}

	@Test(priority = 1)
	public void verifyContactPageLabelTest() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contacts Label is missing on the page");
	}

	@Test(priority = 2)
	public void selectSingleContactsTest() {
		contactsPage.selectContactsByName("aaa der");
	}

	@Test(priority = 3)
	public void selectMultipleContactsTest() {
		contactsPage.selectContactsByName("aaa der");
		contactsPage.selectContactsByName("abc ae");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
