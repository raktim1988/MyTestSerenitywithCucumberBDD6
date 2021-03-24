package com.automation.test;

import java.util.Properties;

import com.automation.utilities.PageURLConstants;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.automation.pageObjects.*;
import com.automation.utilities.ActionMethods;

import cucumber.api.java.en.Given;
import org.openqa.selenium.WebElement;

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
		//Shoe Details validation
		String shoeSelector;
		String shoeSize;
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
          Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase(PageURLConstants.PAGE_URL_RUNNER));
	}

	@Then("^User Clicks on the first product$")
	public void user_Clicks_on_the_first_product() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		user.sync(driver, productPageObj.shoeSelector);
		shoeSelector = productPageObj.shoeSelector.getText().trim();
		log.info("Check if the selector is clicked "+ shoeSelector);
		user.takeScreenshot(driver);
		user.click(productPageObj.shoeSelector);

	}

	@Then("^User is navigated to Product Page$")
	public void user_is_navigated_to_Product_Page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
       user.sync(driver, productSelectionPage.landingPopUp);
       productSelectionPage.bodyLanding.sendKeys(Keys.ESCAPE);
       Assert.assertEquals(shoeSelector, productSelectionPage.productHeader.getText());

	}

	@Then("^User Clicks on the Shoe Size$")
	public void user_Clicks_on_the_Shoe_Size() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		user.sync(driver, productSelectionPage.productHeader);
		System.out.println("Check the element " +productSelectionPage.shoeSizes.get(0).getText());
		shoeSize =   productSelectionPage.shoeSizes.get(0).getText();
		user.click(productSelectionPage.shoeSizes.get(0));

	}

	@Then("^User Adds the item to the Bag$")
	public void user_Adds_the_item_to_the_Bag() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		System.out.println("Check the element " + productSelectionPage.addToBagButton.getText());
		user.click(productSelectionPage.addToBagButton);
	}

	@When("^Bag is properly populated$")
	public void bag_is_properly_populated() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		user.sync(driver, bagPage.bagPopUp);

		//Split the Strings with the Colon field [ Size and quantity]
		String shoeSizeText[] = bagPage.shoeSizeVerify.getText().split(":");
		String shoeText = shoeSizeText[0];
		String size = shoeSizeText[1].trim();

		String shoeQuantityText[] = bagPage.shoeQuantityVerify.getText().split(":");
		String quantityTest = shoeQuantityText[0];
		String quantity = shoeQuantityText[1].trim();

		System.out.print("Check the first element " + quantity + "2nd element:1");

        //Verify the elements [ Size , Quantity ]
		Assert.assertEquals(shoeSize.trim(), size );
		Assert.assertEquals("1" , quantity);
	}

	@Then("^Click to check the Your Bag page$")
	public void click_to_check_the_Your_Bag_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}


}