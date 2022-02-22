package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

public class SearchResultPageTest extends BaseClass
{
	IndexPage indexPage;
	SearchResultPage searchPageResult;
	
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
	@Test(dataProvider="searchProduct", dataProviderClass=DataProviders.class,groups="smoke")
	public void isProductAvailableTest(String product)
	{
		indexPage=new IndexPage();
		searchPageResult=indexPage.searchProduct(product);
		boolean result=searchPageResult.isProductAvailable();
		Assert.assertTrue(result);
	}
}
