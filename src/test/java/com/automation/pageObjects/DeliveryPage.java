package com.automation.pageObjects;

import com.automation.test.SetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeliveryPage {
    WebDriver driver= SetUp.driver;

    @FindBy(xpath = "//div[@data-auto-id='delivery-option-name']//strong[text()='From a collection point']")
    public WebElement pickUpLoc;

    @FindBy(xpath = "//input[@id='pickpoint-search-input']")
    public WebElement locationField;

    @FindBy(xpath = "//span[text()='Search for collection points']")
    public WebElement scrCollectionPntBtn;

    @FindBy(xpath = "//div/h4[@data-auto-id='selected-store-header']")
    public WebElement selectedStore;

    @FindBy(xpath = "//div[@data-auto-id='store-name']/strong")
    public WebElement storeName;

    @FindBy(xpath = "//div[@data-auto-id='store-address']")
    public WebElement storeAddressValidated;

    @FindBy(xpath = "//span[text()='Collect here']")
    public WebElement collectHereBtn;


}
