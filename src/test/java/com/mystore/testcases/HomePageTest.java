package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class HomePageTest extends BaseClass
{
	private IndexPage indexPage;
	private LoginPage loginPage;
	private HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"smoke","sanity","regression"})
	public void setUp(String browserName)
	{
		launchApp(browserName);
	}
	@AfterMethod(groups= {"smoke","sanity","regression"})
	public void tearDown()
	{
		getDriver().quit();
	}
	
	@Test(groups="smoke")
	public void verifyMyWishList()
	{
		 homePage=new HomePage();
		 loginPage=new LoginPage();
		 indexPage=new IndexPage();
		 loginPage=indexPage.clickOnSignInBtn();
		 homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		 boolean result=homePage.validateMyWishList();
		Assert.assertTrue(result);
	}
	@Test(groups="smoke")
	public void verifyOrderHistory()
	{
		homePage=new HomePage();
		 loginPage=new LoginPage();
		 indexPage=new IndexPage();
		 loginPage=indexPage.clickOnSignInBtn();
		 homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		 boolean result=homePage.validateOrderHistory();
		 Assert.assertTrue(result);
	}
	
	
}
