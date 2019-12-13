package com.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

public class CommonFunctions extends StaticVariables {

	/******************* Browser Launch **************************/
	public void fireFoxBrowserLaunch() {
		System.setProperty("webdriver.gecko.driver", ".\\BrowserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	public void chromeBrowserLaunch() {
		System.setProperty("webdriver.chrome.driver", ".\\BrowserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public void ieBrowserLaunch() {
		System.setProperty("webdriver.ie.driver", ".\\BrowserDrivers\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
	}

	/************** SendKeys ********************/
	public void sendkeysByAnyLocator(By locator, String inputdata) {

		try {
			WebElement element = driver.findElement(locator);
			if (element.isDisplayed()) {
				if (element.isEnabled()) {
					element.clear();
					element.sendKeys(inputdata);
				} else {
					System.out.println("Element is NOT enabled");
				}

			} else {
				System.out.println("Element is NOT displayed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/************** Click ********************/
	public void clickByAnyLocator(By locator) {

		try {
			WebElement element = driver.findElement(locator);
			if (element.isDisplayed()) {
				if (element.isEnabled()) {
					element.click();
				} else {
					System.out.println("Element is NOT enabled");
				}

			} else {
				System.out.println("Element is NOT displayed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String timeStamp() {
		Date d = new Date();
		System.out.println(d);// Thu Nov 21 19:30:43 EST 2019
		DateFormat df = new SimpleDateFormat("yyyyMMMdd_HHmmss");
		String timestamp = df.format(d);
		System.out.println(timestamp);
		return timestamp;
	}
	public void takeScreenshot(String name) throws Exception {
		String path = ".\\screenshots\\";
		File abc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(abc, new File(path + name +timeStamp()+".png"));
	}
	
	public void crossBrowserTesting(String browser){
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\BrowserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", ".\\BrowserDrivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\BrowserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			System.out.println("Please enter valid browser name***");

		}
	}
}
