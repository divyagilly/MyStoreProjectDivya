package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.AddtoCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummary;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;
import com.mystore.utility.Log;

public class EndToEndTest extends BaseClass
{
	IndexPage indexPage;
	SearchResultPage searchPageResult;
	AddtoCartPage addToCartPage;
	OrderPage orderPage;
	LoginPage loginPage;
	AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummary orderSummary;
	OrderConfirmationPage orderConfirmation;
	
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
	@Test(groups="regression")
	public void endToEndTestCase() throws Throwable
	{
		indexPage=new IndexPage();
		searchPageResult=indexPage.searchProduct("dress");
		addToCartPage=searchPageResult.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.enterSize("L");
		addToCartPage.clickOnaddtoCart();
		orderPage=addToCartPage.clickOnCheckOut();
		loginPage=orderPage.clickOnCheckOut();
		addressPage=loginPage.login1(prop.getProperty("username"), prop.getProperty("password"));
		shippingPage=addressPage.clickOnCheckOut();
		shippingPage.checkTheTerms();
		paymentPage=shippingPage.clickOnProceedToCheckOut();
		orderSummary=paymentPage.clickOnPaymentMethod();
		orderConfirmation=orderSummary.clickOnConfirmBtn();
		String actualMessage=orderConfirmation.validateConfirmMessage();
		String expectedMsg="Your order on My Store is complete.";
		Assert.assertEquals(actualMessage, expectedMsg);
		Log.endTestCase("Ending the endToEndTestCase");
		
		
	}

}
