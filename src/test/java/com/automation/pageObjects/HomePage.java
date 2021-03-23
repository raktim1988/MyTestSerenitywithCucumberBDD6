package com.automation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.test.SetUp;

public class HomePage {
	
	WebDriver driver = SetUp.driver;
	
	
	@FindBy(xpath="//button[@aria-label='Close']")
	public WebElement popupCloseBtn;
	
	
	
}
