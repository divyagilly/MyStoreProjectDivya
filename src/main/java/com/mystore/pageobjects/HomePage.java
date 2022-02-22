package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class HomePage extends BaseClass 
{
    @FindBy(xpath="//span[text()='My wishlists']")
    WebElement wishLists;
    
    @FindBy(xpath="//span[text()='Order history and details']")
    WebElement orderHistory;
    
    
    public HomePage()
    {
    	PageFactory.initElements(getDriver(), this);
    }
    
    public boolean validateMyWishList()
    {
    	return Action.isDisplayed(wishLists);
    }
    
    public boolean validateOrderHistory()
    {
    	return  Action.isDisplayed(orderHistory);
    }
    public String getCurrentUrl()
    {
    	return Action.getCurrentURL(getDriver());
    
    }
}
