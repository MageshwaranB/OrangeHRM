package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class DashBoardPage extends TestBase
{
	@FindBy(id = "menu_admin_viewAdminModule")
	WebElement admin;
	@FindBy(id = "btnAdd")
	WebElement addButton;
	@FindBy(id = "systemUser_employeeName_empName")
	WebElement empName;
	@FindBy(xpath = "(//div/ul/li)[19]")
	WebElement name;
	@FindBy(id = "systemUser_userName")
	WebElement username;
	@FindBy(id = "systemUser_password")
	WebElement password;
	@FindBy(id = "systemUser_confirmPassword")
	WebElement confirmpassword;
	@FindBy(id = "btnSave")
	WebElement saveBtn;
	@FindBy(xpath = "//h1[text()='Dashboard']")
	WebElement dashText;
	
	public DashBoardPage() {
		PageFactory.initElements(driver, this);
	}
	public String validatePageText() {
		return dashText.getText();
	}
	
	public void clickonAdmin() {
		admin.click();
	}
	
	public void clickonAdd() {
		addButton.click();
	}
	
	public void enterDetails(String uname,String pass,String conPass) throws InterruptedException {
		empName.sendKeys("a");
		Thread.sleep(4000);
		name.click();
		Thread.sleep(3000);
		username.sendKeys(uname);
		password.sendKeys(pass);
		confirmpassword.sendKeys(conPass);
		saveBtn.click();
		Thread.sleep(2000);
	}
	
}
