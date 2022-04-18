package com.automation.pages;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
@Setter
public class CustomerContactPage extends BasePage{

    @FindBy(xpath = "//*[@id='P389-C2-C0-C0-F2-1']")
    private WebElement customerIdType;

    @FindBy(xpath = "//*[@id='P389-C2-C0-C1-C1-C1-F0']")
    private WebElement emailID;

    @FindBy(xpath = "//*[@id='P389-C2-C0-C1-C1-C2-F0']")
    private WebElement phoneNumber;

    @FindBy(xpath = "//span[contains(text(),'To closing questions')]")
    private WebElement closingButton;
}
