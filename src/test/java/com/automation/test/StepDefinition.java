package com.automation.test;

import java.util.Properties;

import com.automation.pageObjects.ProductPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.automation.pageObjects.*;
import com.automation.utilities.ActionMethods;

import cucumber.api.java.en.Given;

public class StepDefinition {
	
	
	   // Driver
		WebDriver driver = SetUp.driver;
		
		//pages
		HomePage homePageObj = SetUp.homePageObj;
		ProductPage productPageObj= SetUp.productPageObj;
		ProductSelectionPage productSelectionPage=SetUp.productSelectionPage;
		BagPage  bagPage = SetUp.bagPage;
		CheckOutPage checkOutPage=SetUp.checkOutPage;
		CollectionPage collectionPage=SetUp.collectionPage;

		//Utility
		ActionMethods user = new ActionMethods();
		
		//Properties file read
		public Properties data = SetUp.data;
		
		//Logger Implementation
		static Logger log = Logger.getLogger(StepDefinition.class);
		
		@Given("^User is navigated to Adidas webpage$")
		public void user_is_navigated_to_Adidas_webpage() throws Throwable {
		 
			try {
				String Url = data.getProperty("URL");
				 driver.navigate().to(Url);
				 user.pageLoadWait(driver);
				 log.info("Test Log info");
				user.sync(driver, homePageObj.ukBtn);
				user.highlightElement(driver, homePageObj.ukBtn);
				user.click(homePageObj.ukBtn);

				user.sync(driver, homePageObj.goBtn);
				homePageObj.goBtn.click();
				homePageObj.goBtn.click();

				user.sync(driver, homePageObj.acceptTrackBtn);
				homePageObj.acceptTrackBtn.click();

				user.highlightElement(driver,homePageObj.logoIcon);
				Assert.assertEquals(homePageObj.logoIcon.isDisplayed(),true);
				user.takeScreenshot(driver);

				
			} catch (Exception e) {
				log.error(e.getMessage());
		    	throw e;
			}


		}
	@When("^Click on the running link$")
	public void click_on_the_running_link() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
          user.scrollToElement(driver, homePageObj.runningLink);
          user.click(homePageObj.runningLink);
          Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://www.adidas.co.uk/running"));
	}

	@Then("^User Clicks on the first product$")
	public void user_Clicks_on_the_first_product() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("^User is navigated to Product Page$")
	public void user_is_navigated_to_Product_Page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	

}
