package com.testscenarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.objectrepository.Locators;
import com.utilities.CommonFunctions;
import com.utilities.StaticVariables;

public class Gmail_crossBrowserTesting extends StaticVariables{
	//WebDriver driver;
	CommonFunctions cfn = new CommonFunctions();
	Locators l = new Locators();

	@Test
	public void f() throws InterruptedException, Exception {
		File f = new File(".\\TestData\\input.properties");
		FileInputStream fi = new FileInputStream(f);
		Properties prop = new Properties();
		prop.load(fi); 
		driver.findElement(l.gmail_email).sendKeys(prop.getProperty("Username"));
		driver.findElement(l.gmail_next).click();
		Thread.sleep(6000);
		driver.findElement(l.gmail_Password).sendKeys(prop.getProperty("Password"));
		driver.findElement(l.gmail_next).click();
		Thread.sleep(5000);
	}

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(@Optional("Chrome") String browser) {
		// browser ="ie";

		cfn.crossBrowserTesting("Chrome");
		driver.get("https://www.gmail.com/");
	}
}