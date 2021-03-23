package com.automation.test;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.automation.pageObjects.HomePage;
import com.automation.utilities.ActionMethods;

import cucumber.api.java.en.Given;

public class StepDefination {
	
	
	// Driver
		WebDriver driver = SetUp.driver;
		
		//pages
		HomePage homePageObj = SetUp.homePageObj;
		
		
		//Utility
		ActionMethods user = new ActionMethods();
		
		//Properties file read
		public Properties data = SetUp.data;
		
		//Logger Implementation
		static Logger Log = Logger.getLogger(StepDefination.class);
		
		@Given("^User is navigated to Addidas webpage$")
		public void user_is_navigated_to_Addidas_webpage() throws Throwable {
		 
			try {
				String Url = data.getProperty("URL");
				 driver.navigate().to(Url);
				 user.pageLaodWait(driver);
				 
				 
				 user.sync(driver, homePageObj.popupCloseBtn);
				 user.highlightElement(driver, homePageObj.popupCloseBtn);
				 user.click(homePageObj.popupCloseBtn);
				
				
			} catch (Exception e) {
				Log.error(e.getMessage());
		    	throw e;
			}
			
		}


	

}
