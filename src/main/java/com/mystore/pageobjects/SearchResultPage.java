package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class SearchResultPage extends BaseClass
{
	@FindBy(xpath="//*[@id=\"center_column\"]//img")
	WebElement productResult;
	
	public SearchResultPage()
	{
		PageFactory.initElements(getDriver(), this);
		
	}
    public boolean isProductAvailable()
    {
     return Action.isDisplayed(productResult);
    }
    
    public AddtoCartPage clickOnProduct()
    {
    	Action.click(getDriver(), productResult);
    	return new AddtoCartPage();
    }
}
