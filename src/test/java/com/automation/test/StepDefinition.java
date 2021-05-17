package com.automation.test;

import com.automation.pageObjects.*;
import com.automation.utilities.ActionMethods;
import com.automation.utilities.PageURLConstants;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Properties;

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
    DropDownPage dropDown = SetUp.dropDownPage;
    LoginPage loginPage = SetUp.loginPage;
    AddElementPage addElementPage = SetUp.addElementPage;
    //Shoe Details validation
    int saveQuantity;
    String shoeSelector;
    String shoeSize;
    String CollectionPointStr;
    //Utility class
    ActionMethods user = new ActionMethods();
    //Properties file reading
    public Properties data = SetUp.data;
    //Logger Implementation
    static Logger log = Logger.getLogger(StepDefinition.class);
    private int elementCount;

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
        //This method is to click on the 'Runner' link
        try {
            user.sync(driver, homePageObj.runningLink);
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
            log.error("The link is not clicked and non-navigatable");
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
            log.error("First product can't be clicked");
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
            log.error("Product page is not opened properly");
        }
    }

    @Then("^User Clicks on the Shoe Size$")
    public void user_Clicks_on_the_Shoe_Size() throws Throwable {
        //User selects the first available Shoe-Size from the Shoe size list
        user.sync(driver, productSelectionPage.productHeader);
        shoeSize = productSelectionPage.shoeSizes.get(0).getText();
        user.click(productSelectionPage.shoeSizes.get(0));
    }
    //Adding multiple times

    @Then("^User Adds the item to the Bag (\\d+) times$")
    public void user_Adds_the_item_to_the_Bag_times(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        saveQuantity = arg1;
        for (int i = 0; i < arg1; i++) {
            user.sync(driver, productSelectionPage.addToBagButton);
            user.click(productSelectionPage.addToBagButton);
            user.sync(driver, bagPage.modalClose);
            if (i < (arg1 - 1)) {
                user.click(bagPage.modalClose);
            }
        }
    }

    @When("^Customers Bag is properly populated$")
    public void bag_is_properly_populated() throws Throwable {
        // Verify if the Bag overlay is proper
        try {
            //Split the Strings with the Colon : field [ Size and quantity]
            user.sync(driver, bagPage.shoeSizeVerify);
            String shoeSizeText[] = bagPage.shoeSizeVerify.getText().split(":");
            String size = shoeSizeText[1].trim();
            String shoeQuantityText[] = bagPage.quantityChecker.getText().split(" ");
            String quantity = shoeQuantityText[0].trim();
            //Verify the Bag with the Elements [Product Name,  Size , Quantity ]
            Assert.assertEquals(shoeSelector, bagPage.selectedShoeName.getText().trim());
            Assert.assertEquals(shoeSize.trim(), size);
            Assert.assertEquals(Integer.toString(saveQuantity), quantity);
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

    @And("^Enter location as \"([^\"]*)\"$")
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
            user.takeScreenshot(driver);
            user.sync(driver, deliveryPage.selectedStore);
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
    //Before each method

    @Given("^User is on the desired page$")
    public void user_is_on_the_desired_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.navigate().to("https://the-internet.herokuapp.com");
        user.pageLoadWait(driver);
    }


    @Then("^click on the link \"([^\"]*)\"$")
    public void click_on_the_link(String linkNameGiven) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        user.sync(driver, dropDown.getLink(linkNameGiven));
        dropDown.getLink(linkNameGiven).click();
    }

    //Testing Dropdown values

    @Then("^select dropdown field value$")
    public void select_dropdown_field_value() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        Select dropDownOption = new Select(driver.findElement(By.id("dropdown")));
        dropDownOption.selectByIndex(0);
        dropDownOption.selectByVisibleText("Option 1");
    }

    @Then("^pass the value as \"([^\"]*)\"$")
    public void pass_the_value_as(String chosenValue) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Select dropDownOption = new Select(driver.findElement(By.id("dropdown")));
        dropDownOption.selectByVisibleText(chosenValue);

    }

    //Add delete elements

    @Then("^Add Element (\\d+) times$")
    public void add_Element_times(int numberOfAdd) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        elementCount = numberOfAdd;
        user.sync(driver, addElementPage.addButton);
        for (int i = 0; i < numberOfAdd; i++) {
            addElementPage.addButton.click();
        }
    }

    @Then("^Check the Delete button count$")
    public void check_the_Delete_button_count() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        user.sync(driver, addElementPage.deleteButton.get(0));
        for (int i = 0; i < elementCount; i++) {
            addElementPage.deleteButton.get(0).click();
        }
        Assert.assertEquals(addElementPage.deleteButton.size(), 0);
    }


    //Added for Scenario outline

    @Then("^User clicks on the \"([^\"]*)\" link$")
    public void user_clicks_on_the_link(String chosenLink) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        user.sync(driver, loginPage.headertext);
        System.out.println("the link is " + loginPage.getLink(chosenLink).getText());
        loginPage.getLink(chosenLink).click();
    }

    @And("^Provide \"([^\"]*)\" and \"([^\"]*)\"$")
    public void provide_and(String username, String password) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        user.sync(driver, loginPage.loginPageHeader);
        System.out.println("Username is" + username + "Password is " + password);
        loginPage.userName.sendKeys(username);
        loginPage.password.sendKeys(password);
        user.takeScreenshot(driver);
        loginPage.loginButton.click();
    }

    @Then("^Verify successful login$")
    public void verify_successful_login() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        if (!loginPage.loginSuccess.isEmpty()) {
            log.info("Successful Login");
            user.takeScreenshot(driver);
        }
        else
        {
            System.out.println("Login Error" + loginPage.loginError.getText());
            log.info(loginPage.loginError.getText());
            user.takeScreenshot(driver);
        }
    }
}