package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


import com.mystore.actiondriver.Action;
import com.mystore.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass
{
	public static  Properties prop;
	public static ThreadLocal<RemoteWebDriver> driver=new ThreadLocal<>();
	public static WebDriver getDriver()
	{
		return driver.get();
	}
	@BeforeSuite(groups= {"smoke","sanity","regression"})
	public void loadConfig() throws Exception
	{
		DOMConfigurator.configure("log4j.xml");
		ExtentManager.setExtent();
		prop=new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\Config.properties");
			prop.load(fis);
		    } 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	public static void launchApp(String browsername)
	{
		
		//String browsername=prop.getProperty("browser");
		if(browsername.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		}
		else if(browsername.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		}
		else if(browsername.equalsIgnoreCase("IE"))
		{
			WebDriverManager.iedriver().setup();
			driver.set(new InternetExplorerDriver());
		}
		getDriver().manage().window().maximize();
		Action.implicitWait(getDriver(), 10);
		Action.pageLoadTimeOut(getDriver(), 30);
		getDriver().get(prop.getProperty("url"));
		}
	@AfterSuite
	public void afterSuite()
	{
		ExtentManager.endReport();
	}

}
