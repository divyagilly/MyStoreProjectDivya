package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddtoCartPage extends BaseClass
{
   @FindBy(id="quantity_wanted")
   private WebElement quantity;
   
   @FindBy(id="group_1")
   private WebElement size;
   
   @FindBy(xpath="//span[text()='Add to cart']")
   private WebElement addToCartBtn;
   
   @FindBy(xpath="//*[@id=\"layer_cart\"]//h2/i")
   private WebElement addToCartMessag;
   
   @FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
   private WebElement proceedToCheckOutBtn;
   
   
   public AddtoCartPage()
   {
	   PageFactory.initElements(getDriver(), this);
   }
   
   public void enterQuantity(String quantity1)
   {
	   Action.type(quantity, quantity1);
   }
   
   public void enterSize(String size1)
   {
	   Action.selectByVisibleText(size1, size);
   }
   
   public void clickOnaddtoCart()
   {
	   Action.click(getDriver(), addToCartBtn);
   }
   
   public boolean validateAddToCartMessage()
   {
	   Action.fluentWait(getDriver(), addToCartMessag, 10);
	   System.out.println(addToCartMessag.getAttribute("innerText"));
	   return Action.isDisplayed(addToCartMessag);
   }
   
   public OrderPage clickOnCheckOut()
   {
	   Action.fluentWait(getDriver(), proceedToCheckOutBtn, 10);
	   Action.JSClick(getDriver(), proceedToCheckOutBtn);
	   return new OrderPage();
   }
   
}
