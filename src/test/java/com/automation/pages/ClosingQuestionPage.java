package com.automation.pages;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
@Setter
public class ClosingQuestionPage extends BasePage{
    
    @FindBy(xpath = "//*[@id='P388-C2-C0-C0-C2-F1-2']")
    private WebElement otherIncome;
    
    @FindBy(xpath = "//*[@id='P388-C2-C0-C0-C2-F4-1']")
    private WebElement ownerOrDirector;
    
    @FindBy(xpath = "//span[contains(text(),'No')]")
    private WebElement isHugeAmount;
    
    @FindBy(xpath = "//*[@id='P388-C2-C0-C0-C2-F7-1']")
    private WebElement isBankRejected;

    @FindBy(xpath = "//span[contains(text(),'Overview')]")
    private WebElement overviewButton;

}
