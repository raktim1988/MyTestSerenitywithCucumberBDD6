package com.automation.pageObjects;

import com.automation.test.SetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Set;

public class CheckOutPage {

    WebDriver driver = SetUp.driver;

    @FindBy(xpath = "//div/button[@data-auto-id='glass-checkout-button-bottom']")
    public WebElement checkOutButton;

    @FindBy(xpath = "//div/h4[@aria-label='Get your order']")
    public WebElement validationText;
}


