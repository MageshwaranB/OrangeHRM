package com.testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import com.pages.RecruitmentPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.google.common.io.Files;
import com.pages.DashBoardPage;
import com.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UserManagementTest extends TestBase
{		
	DashBoardPage dp;
	LoginPage lp;
	RecruitmentPage recruitmentPage;
	@BeforeMethod
	public void setup() {
		initialization();
		lp=new LoginPage();
		dp=lp.login(prop.getProperty("username"), prop.getProperty("password"));
		recruitmentPage=new RecruitmentPage();
	}
	
	@Test(priority = 1)
	public void titleValidationTest() {
		String actText=dp.validatePageText();
		String expText="Dashboard";
		Assert.assertEquals(actText, expText);
		
	}
	@Test(priority = 2)
	public void navigationToUserManagement() 
	{
		dp.clickonAdmin();
	}
	@Test
	public void addingUser() {
		dp.clickonAdmin();
		dp.clickonAdd();
		try {
			Thread.sleep(3000);
			dp.enterDetails(prop.getProperty("ename"), prop.getProperty("epassword"), prop.getProperty("cpassword"));
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

	@Test
	public void addingACandidateForAJobVacancyTest(){
		recruitmentPage.clickOnRecruitmentButton();
		recruitmentPage.clickOnRecruitmentOptions();
		recruitmentPage.clickOnAddCandidate();
		String statusMessage=recruitmentPage.addingACandidate(prop.getProperty("jobRole"));
		Assert.assertEquals(statusMessage,"Status: Application Initiated","Oops, there's some problem in your code, expected result doesn't match with the actual result");
	}
	@AfterMethod
	public void setupClose()
	{
		
		teardown();
	}
}
