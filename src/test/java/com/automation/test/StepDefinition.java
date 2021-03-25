package com.automation.test;

import java.util.Properties;

import com.automation.utilities.PageURLConstants;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import com.automation.pageObjects.*;
import com.automation.utilities.ActionMethods;
import cucumber.api.java.en.Given;

/**
 * Author : Raktim Biswas
 * Purpose : Test Automation of Adidas e-commerce site; an End to End flow
 */
public class StepDefinition {

    //Driver
    WebDriver driver = SetUp.driver;
    //Page Models instantiation
    HomePage homePageObj = SetUp.homePageObj;
    ProductPage productPageObj = SetUp.productPageObj;
    ProductSelectionPage productSelectionPage = SetUp.productSelectionPage;
    BagPage bagPage = SetUp.bagPage;
    CheckOutPage checkOutPage = SetUp.checkOutPage;
    CollectionPage collectionPage = SetUp.collectionPage;
    DeliveryPage deliveryPage = SetUp.deliveryPage;
    //Shoe Details validation
    String shoeSelector;
    String shoeSize;
    String CollectionPointStr;
    //Utility class
    ActionMethods user = new ActionMethods();
    //Properties file reading
    public Properties data = SetUp.data;
    //Logger Implementation
    static Logger log = Logger.getLogger(StepDefinition.class);

    @Given("^User is navigated to Adidas webpage$")
    public void user_is_navigated_to_Adidas_webpage() throws Throwable {

        try {
            //Move to the desired Link of the Adidas-UK home page
            String Url = data.getProperty("URL");
            driver.navigate().to(Url);
            user.pageLoadWait(driver);
            user.sync(driver, homePageObj.ukBtn);
            user.highlightElement(driver, homePageObj.ukBtn);
            user.click(homePageObj.ukBtn);

            user.sync(driver, homePageObj.goBtn);
            homePageObj.goBtn.click();
            homePageObj.goBtn.click();

            user.sync(driver, homePageObj.acceptTrackBtn);
            homePageObj.acceptTrackBtn.click();
            Assert.assertEquals(homePageObj.logoIcon.isDisplayed(), true);
            user.takeScreenshot(driver);
        } catch (AssertionError ex) {
            log.error("The Home page is not displayed properly");
            throw ex;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }
    }

    @When("^Click on the running link$")
    public void click_on_the_running_link() throws Throwable {
        //This method is to click on the 'Runner'link
        try {
            user.scrollToElement(driver, homePageObj.runningLink);
            user.click(homePageObj.runningLink);
            user.sync(driver, productPageObj.shoeSelector);

            //Change
            Assert.assertTrue("The runner link is not navigated",
                    driver.getCurrentUrl().equalsIgnoreCase(PageURLConstants.PAGE_URL_RUNNER));
            user.takeScreenshot(driver);
        } catch (AssertionError ex) {
            log.error("The link is not clicked and non-navigatable");
            throw ex;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @Then("^User Clicks on the first product$")
    public void user_Clicks_on_the_first_product() throws Throwable {
        //This method is to verify if the User clicked on the first product --- need to check X-Path
        try {
            user.sync(driver, productPageObj.shoeSelector);
            shoeSelector = productPageObj.shoeSelector.getText().trim();
            log.info("Check if the selector is clicked " + shoeSelector);
            user.takeScreenshot(driver);
            user.click(productPageObj.shoeSelector);
        } catch (Exception ex) {
            log.error("FIrst product can't be clicked");
            throw ex;
        }

    }

    @Then("^User is navigated to Product Page$")
    public void user_is_navigated_to_Product_Page() throws Throwable {
        //To verify if user is navigated to the Product page
        try {
            user.sync(driver, productSelectionPage.landingPopUp);
            productSelectionPage.bodyLanding.sendKeys(Keys.ESCAPE);

            Assert.assertEquals(shoeSelector, productSelectionPage.productHeader.getText());
            user.takeScreenshot(driver);
        } catch (AssertionError ex) {
            log.error("Product page is not opened properly");
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("^User Clicks on the Shoe Size$")
    public void user_Clicks_on_the_Shoe_Size() throws Throwable {
        //User selects the first available Shoe-Size from the Shoe size list
        user.sync(driver, productSelectionPage.productHeader);
        shoeSize = productSelectionPage.shoeSizes.get(0).getText();
        user.click(productSelectionPage.shoeSizes.get(0));
    }

    @Then("^User Adds the item to the Bag$")
    public void user_Adds_the_item_to_the_Bag() throws Throwable {
        user.sync(driver, productSelectionPage.addToBagButton);
        user.click(productSelectionPage.addToBagButton);
    }

    @When("^Customers Bag is properly populated$")
    public void bag_is_properly_populated() throws Throwable {
        // Verify if the Bag overlay is proper
        try {
            user.sync(driver, bagPage.bagPopUp);
            //Split the Strings with the Colon : field [ Size and quantity]
            String shoeSizeText[] = bagPage.shoeSizeVerify.getText().split(":");
            String shoeText = shoeSizeText[0];
            String size = shoeSizeText[1].trim();
            String shoeQuantityText[] = bagPage.shoeQuantityVerify.getText().split(":");
            String quantityTest = shoeQuantityText[0];
            String quantity = shoeQuantityText[1].trim();
            //Verify the Bag with the Elements [Product Name,  Size , Quantity ]
            Assert.assertEquals(shoeSelector.trim(), bagPage.selectedShoeName.getText().trim());
            Assert.assertEquals(shoeSize.trim(), size);
            Assert.assertEquals("1", quantity);
            user.takeScreenshot(driver);
        } catch (AssertionError ex) {
            log.error("Elements are not matched");
            throw ex;
        } catch (Exception ex) {
            log.error("Exception triggered " + ex.getCause());
            throw ex;
        }

    }

    @Then("^Click to check the Your Bag page$")
    public void click_to_check_the_Your_Bag_page() throws Throwable {
        // This method is to check if the Bag Page is properly populated
        try {
            user.sync(driver, bagPage.bagPopUp);
            user.click(bagPage.bagButton);
            user.sync(driver, bagPage.yourBagText);
            Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase(PageURLConstants.PAGE_URL_KART));
            Assert.assertEquals("YOUR BAG", bagPage.yourBagText.getText());
            user.takeScreenshot(driver);
        } catch (AssertionError ex) {
            log.error("Assertion failed to check the Bag page");
            throw ex;
        } catch (Exception ex) {
            log.error("Assertion failed to check the Bag page");
            throw ex;
        }
    }

    @When("^Customer checks out$")
    public void customer_checks_out() throws Throwable {
        // Customer checkout the item
        user.sync(driver, bagPage.yourBagText);
        user.click(checkOutPage.checkOutButton);
    }

    @Then("^Verify if Customer is on Delivery page$")
    public void verify_if_Customer_is_on_Delivery_page() throws Throwable {
        // This method is to verify if customer is navigated to the Delivery page
        user.sync(driver, checkOutPage.validationText);
        try {
            Assert.assertTrue(user.isElementPrsent(checkOutPage.validationText));
            Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase(PageURLConstants.PAGE_URL_CHECKOUT));
            user.takeScreenshot(driver);
        } catch (AssertionError ex) {
            log.error("Ässertion error to check customer is in the delivery page");
            throw ex;
        } catch (Exception e) {
            log.error("Ässertion error to check customer is in the delivery page");
            throw e;
        }

    }

    @Then("^Customer selects From A Collection Point$")
    public void customer_selects_From_A_Collection_Point() throws Throwable {
        user.sync(driver, deliveryPage.pickUpLoc);
        user.click(deliveryPage.pickUpLoc);
    }

    @Then("^Enter location as \"([^\"]*)\"$")
    public void enter_location_as(String location) throws Throwable {
        //This method is to choose the Location as "London"- which is parameterized from the feature file
        user.sync(driver, deliveryPage.locationField);
        user.type(deliveryPage.locationField, location);
        user.sync(driver, deliveryPage.scrCollectionPntBtn);
        user.click(deliveryPage.scrCollectionPntBtn);

    }

    @And("^Verify the correct collection points is selected$")
    public void verify_the_correct_collection_points_is_selected() throws Throwable {
        // This method is to verify if the correct collection point was selected
        try {
            user.sync(driver, deliveryPage.storeName);
            CollectionPointStr = deliveryPage.storeName.getText().trim();
            user.click(deliveryPage.collectHereBtn);
            user.sync(driver, deliveryPage.storeName);
            Assert.assertEquals(collectionPage.storeAddress.getText().trim(), deliveryPage.storeAddressValidated.getText().trim());
            user.takeScreenshot(driver);
        } catch (AssertionError ex) {
            log.error("Collection points is not properly selected");
            throw ex;
        } catch (Exception ex) {
            log.error("Collection points is not properly selected");
            throw ex;
        }
    }

}