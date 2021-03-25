package com.automation.pageObjects;

import com.automation.test.SetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CollectionPage {
    WebDriver driver = SetUp.driver;

    @FindBy(xpath = "//div[@data-auto-id='store-address']")
    public WebElement storeAddress;

}
