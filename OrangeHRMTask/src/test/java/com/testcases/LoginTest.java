package com.testcases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.google.common.io.Files;
import com.pages.DashBoardPage;
import com.pages.LoginPage;

import com.utils.Screenshot;

public class LoginTest extends TestBase {
	LoginPage lp;

	public static String name;
	public static int status;

	public LoginTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		lp = new LoginPage();

	}

	@Test(priority = 1)
	public void TitleValidate() {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actTitle = lp.validateTitle();
		String expTitle = "OrangeHRM";
		Assert.assertEquals(actTitle, expTitle);
		
	}

	@Test(priority = 2)
	public void loginpageTest() {
		lp.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@AfterMethod
	public void setupClose() {
		teardown();
	}

}
