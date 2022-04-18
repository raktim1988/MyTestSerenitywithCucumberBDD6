package com.automation.pages;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
@Setter
public class CustomerDetailsPage extends BasePage{

    @FindBy(xpath = "//*[@id='P390-C2-C0-C1-C2-F0-0']")
    private WebElement salutation;

    @FindBy(xpath = "//*[@id='P390-C2-C0-C1-C3-F0']")
    private WebElement initials;

    @FindBy(xpath = "//*[@id='P390-C2-C0-C1-C4-F0']")
    private WebElement firstName;

    @FindBy(xpath = "//*[@id='P390-C2-C0-C1-C6-C0-F0']")
    private WebElement lastName;

    @FindBy(xpath = "//*[@id='P390-C2-C0-C1-C8-F0']")
    private WebElement dOB;

    @FindBy(xpath = "//*[@id='P390-C2-C0-C1-F9-1']")
    private WebElement usaBorn;

    @FindBy(xpath = "//*[@id='P390-C2-C0-C4-C3-F0']")
    private WebElement personalIDNo;

    @FindBy(xpath = "//*[@id='P390-C2-C0-C4-F5-0']")
    private WebElement payTaxInNL;

    @FindBy(xpath = "//span[contains(text(),'identification')]")
    private WebElement submitButton;


}
