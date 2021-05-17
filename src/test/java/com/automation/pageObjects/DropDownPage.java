package com.automation.pageObjects;

import com.automation.test.SetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DropDownPage {

    WebDriver driver = SetUp.driver;
@FindBy(xpath = "//div[@id='content']")
    public WebElement dropDown;

    public WebElement getLink(String linkName) {
        WebElement link=driver.findElement(By.xpath("//li/a[contains(text(),'"+linkName+"')]"));
        return link;
    }
}
