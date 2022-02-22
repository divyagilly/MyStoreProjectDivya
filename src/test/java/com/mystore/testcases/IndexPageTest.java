package com.mystore.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;

public class IndexPageTest extends BaseClass
{
	
	@Parameters("browser")
	@BeforeMethod(groups= {"smoke","sanity","regression"})
	public void setUp(String browsername)
	{
		launchApp(browsername);
	}
	@AfterMethod(groups= {"smoke","sanity","regression"})
	public void tearDown()
	{
		getDriver().quit();
	}
	
	@Test(groups="smoke")
	public void verifyTitle()
	{
		IndexPage indexpage=new IndexPage();
		String storeTitle=indexpage.getMyStoreTitle();
		Assert.assertEquals(storeTitle, "My Store");
	}
	@Test(groups="smoke")
	public void verifyLogo()
	
	{
		IndexPage indexpage=new IndexPage();
		boolean valid=indexpage.validateLogo();
		Assert.assertTrue(valid);
	}
}
