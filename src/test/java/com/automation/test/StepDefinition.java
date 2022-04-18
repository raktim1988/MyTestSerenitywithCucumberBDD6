package com.automation.test;

import com.automation.pages.ClosingQuestionPage;
import com.automation.pages.CustomerContactPage;
import com.automation.pages.CustomerDetailsPage;
import com.automation.pages.HomePage;
import com.automation.utilities.ActionMethods;
import com.automation.utilities.PropertiesFile;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

    /**
     * Author : Raktim Biswas
     * Purpose : Test Automation of Abn-Amro Private account opening; an End to End flow
     */
    public class StepDefinition {

        SetUp setUp;
        
        //Page Models instantiation
        HomePage homePage = SetUp.homePage;
        CustomerDetailsPage customerDetailsPage = SetUp.customerDetailsPage;
        CustomerContactPage customerContactPage= SetUp.customerContactPage;
        ClosingQuestionPage closingQuestionPage=SetUp.closingQuestionPage;
        
        
        ActionMethods actions = new ActionMethods();
        
        //Properties file reading
        public Properties data = SetUp.data;
        
        //Logger Implementation
        static Logger log = Logger.getLogger(StepDefinition.class);

        @Given("^User is navigated to ABNAmro webpage$")
        public void userMovesToOpenAccountPage() throws Throwable {

            try {
                actions.sync(SetUp.driver,homePage.getCookieOption());
                if (homePage.getCookieOption().isDisplayed()){
                    homePage.getCookieOption().click();
                }
            } catch (AssertionError ex) {
                log.error("The Account Opening page is not displayed properly");
                throw ex;
            } catch (Exception e) {
                log.error(e.getMessage());
                throw e;
            }
        }
        @When("^User Selects all required fields$")
        public void userSelectsTheOptions() throws Throwable {

                actions.sync(SetUp.driver, homePage.getAccountType());
                homePage.getAccountType().click();
                actions.sync(SetUp.driver, homePage.getAccountFor());
                actions.scrollToElement(SetUp.driver, homePage.getAccountFor());
                homePage.getAccountFor().click();

        }
        @And("^User inputs his \"([^\"]*)\" and \"([^\"]*)\"$")
        public void user_inputs_his_and(String postalCode, String houseNumber) throws Throwable {
                actions.sync(SetUp.driver, homePage.getPostalCode());
                actions.scrollToElement(SetUp.driver, homePage.getPostalCode());
                homePage.getPostalCode().sendKeys(postalCode);
                actions.scrollToElement(SetUp.driver, homePage.getHouseNumber());
                homePage.getHouseNumber().sendKeys(houseNumber);
                homePage.getHouseNumber().sendKeys(Keys.TAB);
        }

        @Then("^Verify \"([^\"]*)\" and \"([^\"]*)\" is autopopulated$")
        public void verifyStreetAndTownIsAutoPopulated(String streetName, String town) throws Throwable {
            SetUp.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            if (homePage.getFilledStreet().isDisplayed()){
                    Assert.assertEquals(streetName,homePage.getFilledStreet().getText());
                    Assert.assertEquals(town,homePage.getFilledTown().getText());
                }

        }

        @When("^User Clicks on the button$")
        public void userClicksbutton() throws Throwable {
            actions.scrollToElement(SetUp.driver,homePage.getSubmitButton());
            homePage.getSubmitButton().click();
        }

        @Then("^Verify customer details page is opened$")
        public void verifyCustomerDetailsPage() throws Throwable {
            SetUp.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            Assert.assertTrue(customerDetailsPage.getSalutation().isDisplayed());
        }

        @When("^Customers \"([^\"]*)\" inputs all his details and submit$")
        public void customersInputsHisData(String customerDetails) throws Throwable {
            data = PropertiesFile.readPropertiesFile(customerDetails);
            customerDetailsPage.getSalutation().click();

            SetUp.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            actions.scrollToElement(SetUp.driver,customerDetailsPage.getInitials());
            customerDetailsPage.getInitials().sendKeys(data.getProperty("initials"));

            actions.scrollToElement(SetUp.driver,customerDetailsPage.getFirstName());
            SetUp.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            customerDetailsPage.getFirstName().sendKeys(data.getProperty("firstName"));

            SetUp.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            customerDetailsPage.getLastName().sendKeys(data.getProperty("lastName"));

            actions.scrollToElement(SetUp.driver,customerDetailsPage.getDOB());
            SetUp.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            customerDetailsPage.getDOB().sendKeys(data.getProperty("dOB"));

            actions.scrollToElement(SetUp.driver,customerDetailsPage.getUsaBorn());
            SetUp.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            customerDetailsPage.getUsaBorn().click();

            actions.scrollToElement(SetUp.driver,customerDetailsPage.getPersonalIDNo());
            SetUp.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            customerDetailsPage.getPersonalIDNo().sendKeys(data.getProperty("bsn"));

            actions.scrollToElement(SetUp.driver,customerDetailsPage.getPayTaxInNL());
            SetUp.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            customerDetailsPage.getPayTaxInNL().click();

            actions.scrollToElement(SetUp.driver,customerDetailsPage.getSubmitButton());
            SetUp.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            customerDetailsPage.getSubmitButton().click();
        }

        @Then("^Verify Customer is on the identification page$")
        public void verifyCustomerIDPage() throws Throwable {
            SetUp.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            Assert.assertTrue(customerContactPage.getCustomerIdType().isDisplayed());

        }

        @When("^Customer inputs his \"([^\"]*)\" and \"([^\"]*)\" and submit$")
        public void customerInputsHisContact(String email, String phoneNumber) throws Throwable {
            SetUp.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            actions.scrollToElement(SetUp.driver,customerContactPage.getCustomerIdType());
            customerContactPage.getCustomerIdType().click();

            actions.scrollToElement(SetUp.driver,customerContactPage.getEmailID());
            customerContactPage.getEmailID().sendKeys(email);

            SetUp.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            customerContactPage.getPhoneNumber().sendKeys(phoneNumber);

            SetUp.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            actions.scrollToElement(SetUp.driver,customerContactPage.getClosingButton());
            customerContactPage.getClosingButton().click();
        }


        @Then("^Verify customer is in the closing page$")
        public void verifyCustomerInClosingPage() throws Throwable {
        

        }

        @When("^Customer selects all necessary questions and click overview$")
        public void customerSelectsAndOverview() throws Throwable {


        }

        @Then("^Verify Customers input details page is displayed$")
        public void verifyCustomerEnteredPage() throws Throwable {


        }

        @Then("^Verify Customers values are matched$")
        public void verifyCustomerValues() throws Throwable {


        }

        //Dummy implementation[Prod data]
        @When("^Customer clicks on Apply Now$")
        public void customerAppliesForAccount() throws Throwable {
            
            log.info("User is successfully applied for private account opening");

        }
        
        //Dummy Implementation[Prod data]
        @Then("^Customers account should be created$")
        public void customersAccountIsCreated() throws Throwable {

            log.info("Customer's account creation is successfully submitted with the Bank");
        }

    }