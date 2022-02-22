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
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;

public class OrderPageTest extends BaseClass
{
	IndexPage indexPage;
	SearchResultPage searchPageResult;
	AddtoCartPage addToCartPage;
	OrderPage orderPage;
	
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
	@Test(dataProvider="getProduct",dataProviderClass=DataProviders.class,groups="regression")
	public void verifyTotalPrice(String product,String qty,String size)
	{
		indexPage=new IndexPage();
		searchPageResult=indexPage.searchProduct(product);
		addToCartPage=searchPageResult.clickOnProduct();
		addToCartPage.enterQuantity(qty);
		addToCartPage.enterSize(size);
		addToCartPage.clickOnaddtoCart();
		orderPage=addToCartPage.clickOnCheckOut();
		Double unitPrice=orderPage.getUnitPrice();
		System.out.println(unitPrice);
		Double totalPrice=orderPage.getTotalPrice();
		Double qty1=Double.parseDouble(qty);
		System.out.println(totalPrice);
		Double actualPrice=(unitPrice*qty1)+2;
		Assert.assertEquals(totalPrice,actualPrice);
	}
}
