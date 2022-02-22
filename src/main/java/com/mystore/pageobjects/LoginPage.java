package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass 
{
  @FindBy(id="email")
  WebElement username;
  
  @FindBy(id="passwd")
  WebElement password;
  
  @FindBy(id="SubmitLogin")
  WebElement loginBtn;
  
  @FindBy(id="email_create")
  WebElement emailForNewAccount;
  
  @FindBy(id="SubmitCreate")
  WebElement createNewAccountBtn;
  
  public LoginPage()
  {
  	PageFactory.initElements(getDriver(), this);
  }
  public HomePage login(String uname,String pwd)
  {
	  Action.type(username,uname);
	  Action.type(password, pwd);
	  Action.click(getDriver(), loginBtn);
	  return new HomePage();
  }
  public AddressPage login1(String uname,String pwd)
  {
	  Action.type(username,uname);
	  Action.type(password, pwd);
	  Action.click(getDriver(), loginBtn);
	  return new AddressPage();
  }
  
  public AccountCreationPage createNewAccount(String email)
  {
	  Action.type(emailForNewAccount,email);
	  Action.click(getDriver(), createNewAccountBtn);
	  return new AccountCreationPage();
  }
  
}



