package com.mystore.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class LoginPageTest extends BaseClass
{
	public LoginPage loginPage;
	public IndexPage indexPage;
	public HomePage homePage;
	
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
	
	@Test(dataProvider="credentials",dataProviderClass=DataProviders.class,groups={"smoke","sanity"})
	public void loginTest(String uname,String pwd)
	{
		Log.startTestCase("Starting the log testcase");
		loginPage=new LoginPage();
		indexPage=new IndexPage();
		homePage=new HomePage();
		Log.info("User is going to click on the sign in button");
		loginPage=indexPage.clickOnSignInBtn();
		Log.info("User is going to enter the username and password and click on the signin button");
		//homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		homePage=loginPage.login(uname, pwd);
		String actualUrl=homePage.getCurrentUrl();
		String expectedUrl="http://automationpractice.com/index.php?controller=my-account";
		Assert.assertEquals(actualUrl, expectedUrl);
		Log.info("navigated to the expected url");
		Log.endTestCase("Ending the testcase");
		
	}
	

}
