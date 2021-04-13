package com.automation.pageObjects;

import com.automation.test.SetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BagPage {

    @FindBy(xpath = "//h5[@data-auto-id='bag-modal-product-name']")
    public WebElement selectedShoeName;

    @FindBy(xpath = "//div[contains(text(), 'Size:')]")
    public WebElement shoeSizeVerify;

    @FindBy(xpath = "//div[contains(text(), 'Quantity:')]")
    public WebElement shoeQuantityVerify;


    @FindBy (xpath = "//div[@class='gl-modal__main-content']")
    public WebElement bagPopUp;

    @FindBy(xpath = "//a[@data-auto-id='view-bag-desktop']")
    public WebElement bagButton;

    @FindBy(xpath = "//div/h3[@data-auto-id='glass-cart-title']")
    public WebElement yourBagText;

    @FindBy (xpath = "//button[@class='gl-modal__close']")
    public WebElement modalClose;

    @FindBy(xpath = "//h5[contains(text(),'Your Bag')]/following-sibling::div[contains(text(),'item')]")
    public WebElement quantityChecker;

}
