package com.objectrepository;

import org.openqa.selenium.By;

public class Locators {
	public final By email_id = By.name("email");
	public final By password = By.name("pass");
	public final By forgot_account = By.linkText("Forgot account?");
	public final By gmail_email = By.id("identifierId");
	public final By gmail_Password = By.name("password");
	public final By gmail_next = By.xpath("//*[text()='Next']");
}
