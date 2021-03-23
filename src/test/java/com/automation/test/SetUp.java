package com.automation.test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.automation.pageObjects.*;
import com.automation.utilities.PropertiesFile;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class SetUp {
	
public static WebDriver driver;
	

public static HomePage homePageObj;
	
	
	
	
	public static Actions action;
	public static String message = "";
	FileOutputStream fop = null;
	public static String ScenarioName;
	static Scenario Sc;
	File file;
	public static byte[][] screenshotsArray = new byte[10][10000];
	public static Date date;
	public static String BrowserName = "";
	public static Properties data = null;
	static int i=0;
	
	static{
		DOMConfigurator.configure("log4j.xml");
	}
	@Before
	
	
	public static void setupTest(Scenario scenario) throws Exception
	{
		System.out.println(i);
	
		Sc = scenario; 
		ScenarioName =scenario.getName();
		data =PropertiesFile.readPropertiesFile();
		String browser = data.getProperty("Browser");
		
	/////****************************Chrome Setup********************************/////////////////////////////	
		
		if(browser.contains("chrome"))	
		{	
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/exe/chromedriver.exe" );
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--allow-running-insecure-content");
			options.addArguments("--allow-insecure-websocket-from-https-origin");
			options.addArguments("disable-extensions");
			options.addArguments("allow-running-insecure-content");
			options.addArguments("--start-maximized");
			options.addArguments("disable-extensions");			
			options.addArguments("disable-plugins");
			options.addArguments("--enable-precise-memory-info"); 
			options.addArguments("--disable-popup-blocking");
			options.addArguments("--disable-default-apps");
			options.addArguments("test-type=browser");
			options.addArguments("disable-infobars");
			options.setExperimentalOption("useAutomationExtension", false);
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			driver =  new ChromeDriver(cap);
		
		}	
	/////////**************************PhantomJs Setup*************************************//////////////////////////
		
		else
		{
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setJavascriptEnabled(true);
			caps.setCapability("takesScreenshot", true);
			caps.setCapability(
					PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
					"\\phantomjs.exe"
			);
			WebDriver driver = new PhantomJSDriver(caps);
		}  

		
		homePageObj=PageFactory.initElements(driver, HomePage.class);

		
		driver.manage().deleteAllCookies();
		
		driver.manage().window().maximize();
		
		action = new Actions(driver);
		
		Capabilities cap1 = ((RemoteWebDriver) driver).getCapabilities();
		BrowserName = cap1.getBrowserName().toLowerCase();
		
		System.out.println("BrowserName == "+BrowserName);

		
	}
	
	@After()
	public static void tearDown(Scenario result) throws Exception
	{
		if(result.isFailed()){
			result.write(result.toString());
			result.write(result.getStatus());
			result.write("ScreenShot taken for failed step ");
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			result.write(message);
			result.embed(screenshot, "image/png");
			
		
		}
		result.write(message);
		driver.close();
		driver.quit();
		
		Thread.sleep(1000);
	}
	

}
