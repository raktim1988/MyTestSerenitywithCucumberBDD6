package com.automation.pageObjects;

import com.automation.test.SetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoginPage {

    WebDriver driver = SetUp.driver;

    @FindBy(xpath = "//li/a[contains(text(),'Form Authentication')]")
    public WebElement link;

    @FindBy(xpath = "//h1[@class='heading']")
    public WebElement headertext;

    public WebElement getLink(String linkName) {
        WebElement link=driver.findElement(By.xpath("//li/a[contains(text(),'"+linkName+"')]"));
        return link;
    }
    @FindBy(xpath = "//h2[contains(text(),'Login Page')]")
    public WebElement loginPageHeader;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement userName;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@class='flash success']")
    public List<WebElement> loginSuccess;

    @FindBy(xpath = "//div[@class='flash error']")
    public WebElement loginError;
}

