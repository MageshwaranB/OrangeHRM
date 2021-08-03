package com.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.base.TestBase;
import com.google.common.io.Files;

public class Screenshot extends TestBase
{
	public static String takeSS(String methodname) 
	{
		TakesScreenshot ss=(TakesScreenshot) driver;
		File src = ss.getScreenshotAs(OutputType.FILE);
		String destPath=System.getProperty("user.dir")+"/NewSS/"+methodname+".jpg";
		File dest=new File(destPath);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destPath;
	}
}
