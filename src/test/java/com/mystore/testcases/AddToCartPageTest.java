package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AddtoCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

public class AddToCartPageTest extends BaseClass
{
	IndexPage indexPage;
	SearchResultPage searchPageResult;
	AddtoCartPage addToCartPage;
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
	@Test(dataProvider="getProduct",dataProviderClass=DataProviders.class,groups={"regression","sanity"})
	
	public void addToCartTest(String product,String qty,String size)
	{
		indexPage=new IndexPage();
		//searchPageResult=indexPage.searchProduct("t-shirt");
		searchPageResult=indexPage.searchProduct(product);
		addToCartPage=searchPageResult.clickOnProduct();
		//addToCartPage.enterQuantity("2");
		addToCartPage.enterQuantity(qty);
		//addToCartPage.enterSize("L");
		addToCartPage.enterSize(size);
		addToCartPage.clickOnaddtoCart();
		boolean result=addToCartPage.validateAddToCartMessage();
		Assert.assertTrue(result);
		
	}
}
