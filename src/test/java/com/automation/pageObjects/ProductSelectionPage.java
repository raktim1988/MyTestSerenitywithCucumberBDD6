package com.automation.pageObjects;

import com.automation.test.SetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductSelectionPage {

    @FindBy(xpath="//div[contains(@class,'sidebar')]//h1[@data-auto-id='product-title']/span")
    public WebElement productHeader;


    @FindBy(xpath= "//div[@data-auto-id='size-selector']/button [@class='gl-label size___TqqSo']")
    public List<WebElement> shoeSizes;

    @FindBy(xpath= "//div[@data-auto-id='cstudio-component-landing']")
    public WebElement landingPopUp;

    @FindBy(xpath= "//body")
    public WebElement bodyLanding;

    @FindBy(xpath="//div[@class='add-to-bag___3wgQk gl-vspace-bpall-medium']/button[@data-auto-id='add-to-bag']")
    public WebElement addToBagButton;
}
