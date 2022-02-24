package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class AccountCreationPageTest extends BaseClass
{
	public AccountCreationPage accountCreation;
	public LoginPage loginPage;
	public IndexPage indexPage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"smoke","sanity","regression"})
	public void setUp(String browserName)
	{
		launchApp(browserName);
	}
	@AfterMethod(groups= {"smoke","sanity","regression"})
	public void tearDown()
	{
		getDriver().close();
	}
	@Test(dataProvider="email",dataProviderClass=DataProviders.class,groups="sanity")
	public void verifyAccountCreation(String email) throws Throwable
	{
		loginPage=new LoginPage();
		indexPage=new IndexPage();
		loginPage=indexPage.clickOnSignInBtn();
		//accountCreation=loginPage.createNewAccount("divyagilly@gmail.com");
		accountCreation=loginPage.createNewAccount("divyagilly@gmail.com");
		boolean result=accountCreation.validateAcountCreatePage();
		Assert.assertTrue(result);
		
	}

}
