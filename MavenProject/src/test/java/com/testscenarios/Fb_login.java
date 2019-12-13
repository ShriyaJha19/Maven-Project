package com.testscenarios;

import org.testng.annotations.Test;

import com.objectrepository.Locators;
import com.utilities.CommonFunctions;
import com.utilities.StaticVariables;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Fb_login extends StaticVariables{
	//WebDriver driver;
	//Create object of Locators class
	Locators obj = new Locators();
	CommonFunctions cfn = new CommonFunctions();
	
	@Test
	public void f() throws Exception {
		
		File f = new File(".\\TestData\\input.properties");
		FileInputStream fi = new FileInputStream(f);
		Properties prop = new Properties();
		prop.load(fi);
		
		driver.get(prop.getProperty("URL"));
		cfn.sendkeysByAnyLocator(obj.email_id, prop.getProperty("Username"));
		cfn.takeScreenshot("FB_UN");
		//driver.findElement(obj.email_id).sendKeys(prop.getProperty("Username"));
		cfn.sendkeysByAnyLocator(obj.password, prop.getProperty("Password"));
		//driver.findElement(obj.password).sendKeys(prop.getProperty("Password"));
		// driver.findElement(By.id("loginbutton")).click();
		cfn.clickByAnyLocator(obj.forgot_account);
		
		//driver.findElement(obj.forgot_account).click();
	}

	@AfterMethod
	public void afterMethod() throws Exception {
		cfn.takeScreenshot("FB_login");
	}

	@BeforeClass
	public void beforeClass() {
		//cfn.chromeBrowserLaunch();
		cfn.crossBrowserTesting("ie");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
