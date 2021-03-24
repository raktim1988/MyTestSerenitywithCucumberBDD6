package com.automation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.test.SetUp;

public class HomePage {
	
	WebDriver driver = SetUp.driver;
	
	
	@FindBy(xpath="//button[@aria-label='Close']")
	public WebElement popupCloseBtn;

	@FindBy(xpath="//a[@data-auto-id='logo']")
	public WebElement logoIcon;
	
	@FindBy(xpath ="//a[contains(@href, 'https://www.adidas.co.uk/running')]" )
	public  WebElement runningLink;

	@FindBy(xpath="//input[@value='GB']/..//span")
	public WebElement ukBtn;

	@FindBy(xpath="//button[@aria-label='Go']")
	public WebElement goBtn;

	@FindBy(xpath="//button/span[contains(text(),'Accept tracking')]")
	public WebElement acceptTrackBtn;
}
