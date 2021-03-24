package com.automation.pageObjects;

import com.automation.test.SetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage {

WebDriver driver= SetUp.driver;

    @FindBy(xpath="//div[@class='gl-product-card__details']//span")
    public WebElement shoeSelector;

}
