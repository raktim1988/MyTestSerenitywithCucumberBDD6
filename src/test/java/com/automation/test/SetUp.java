package com.automation.test;

import java.awt.*;
import java.io.File;
import java.net.URI;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import com.automation.pageObjects.*;
import com.automation.utilities.PropertiesFile;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * Author:Raktim Biswas
 * Setting up the Framework
 */
public class SetUp {
    public static WebDriver driver;
    //Page Object details
    public static HomePage homePageObj;
    public static String message = "";
    public static ProductPage productPageObj;
    public static ProductSelectionPage productSelectionPage;
    public static BagPage bagPage;
    public static CheckOutPage checkOutPage;
    public static CollectionPage collectionPage;
    public static DeliveryPage deliveryPage;
    public static String ScenarioName;

    public static Properties data = null;

    //Logging details
    static {
        DOMConfigurator.configure("log4j.xml");
    }

    @Before
    public static void setupTest(Scenario scenario) throws Exception {
        ScenarioName = scenario.getName();
        data = PropertiesFile.readPropertiesFile();
        String browser = data.getProperty("Browser");

        /////****************************Chrome Browser Setup********************************/////////////////////////////

        if (browser.contains("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/exe/chromedriver.exe");
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
            //To disable the pop-up: Chrome browser is controlled by Automation Software
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability(ChromeOptions.CAPABILITY, options);
            driver = new ChromeDriver(cap);

        }
        //To improve: Multiple browser support

        //Initialize all web elements with the Page Objects
        homePageObj = PageFactory.initElements(driver, HomePage.class);
        productPageObj = PageFactory.initElements(driver, ProductPage.class);
        productSelectionPage = PageFactory.initElements(driver, ProductSelectionPage.class);
        checkOutPage = PageFactory.initElements(driver, CheckOutPage.class);
        collectionPage = PageFactory.initElements(driver, CollectionPage.class);
        bagPage = PageFactory.initElements(driver, BagPage.class);
        deliveryPage = PageFactory.initElements(driver, DeliveryPage.class);

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @After()
    public static void tearDown(Scenario result) throws Exception {
        if (result.isFailed()) {
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
        }
    }