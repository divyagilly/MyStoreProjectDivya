package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass

{
	@FindBy(xpath = "//a[@class='login']")
	WebElement signinBtn;

	@FindBy(xpath = "//img[@class='logo img-responsive']")	
	WebElement myStoreLogo;

	@FindBy(id = "search_query_top")
	WebElement searchProductBox;

	@FindBy(xpath = "//button[@class='btn btn-default button-search']")
	WebElement searchProductButton;

	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public LoginPage clickOnSignInBtn() {
		Action.click(getDriver(), signinBtn);
		return new LoginPage();
	}

	public boolean validateLogo() {
		return Action.isDisplayed(myStoreLogo);
	}

	public String getMyStoreTitle() {
		return Action.getTitle(getDriver());
	}

	public SearchResultPage searchProduct(String productName) {
		Action.type(searchProductBox, productName);
		Action.click(getDriver(), searchProductButton);
		return new SearchResultPage();
	}
}
