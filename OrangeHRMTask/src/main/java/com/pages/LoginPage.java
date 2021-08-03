package com.pages;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class LoginPage extends TestBase
{
	@FindBy(id="txtUsername")
	WebElement usernameTB;
	@FindBy(id = "txtPassword")
	WebElement passwordTB;
	@FindBy(id = "btnLogin")
	WebElement loginButton;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateTitle() {
		return driver.getTitle();
	}
	
	public DashBoardPage login(String username,String password) {
		usernameTB.sendKeys(username);
		passwordTB.sendKeys(password);
		loginButton.click();
		return new DashBoardPage();
	}
	
}
