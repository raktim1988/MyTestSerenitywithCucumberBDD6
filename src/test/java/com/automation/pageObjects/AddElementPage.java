package com.automation.pageObjects;

import com.automation.test.SetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddElementPage {

    WebDriver driver = SetUp.driver;
    @FindBy(xpath = "//button[contains(text(), 'Add Element')]")
    public WebElement addButton;

    @FindBy(xpath = "//button[contains(text(), 'Delete')]")
    public List<WebElement> deleteButton;

    @FindBy(xpath = "//h2[contains(text(), 'Available Examples')]")
    public WebElement elementHeader;

    public WebElement getLink(String linkName) {
        WebElement link=driver.findElement(By.xpath("//li/a[contains(text(),'"+linkName+"')]"));
        return link;
    }
}
