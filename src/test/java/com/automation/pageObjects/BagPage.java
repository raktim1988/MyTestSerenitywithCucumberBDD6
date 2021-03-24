package com.automation.pageObjects;

import com.automation.test.SetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BagPage {

    WebDriver driver= SetUp.driver;
    @FindBy(xpath = "//div[@class='info___1Gm7E']/div[contains(text(), 'Size:')]")
    public WebElement shoeSizeVerify;

    @FindBy(xpath = "//div[@class='info___1Gm7E']/div[contains(text(), 'Quantity:')]")
    public WebElement shoeQuantityVerify;


    @FindBy (xpath = "//div[@class='gl-modal__main-content']")
    public WebElement bagPopUp;


}
