package com.automation.test;

import com.automation.pages.*;
import com.automation.utilities.PropertiesFile;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

/**
 * Author:Raktim Biswas
 * Setting up the Framework
 */
public class SetUp {
    public static WebDriver driver;
    //Page Object details
    public static HomePage homePage;
    public static String message = "";
    public static CustomerDetailsPage customerDetailsPage;
    public static CustomerContactPage customerContactPage;
    public static String ScenarioName;
    public static ClosingQuestionPage closingQuestionPage;
    public static Properties data = null;

    //Logging details
    static {
        DOMConfigurator.configure("log4j.xml");
    }

    @Before
    public static void setupTest(Scenario scenario) throws Exception {
        ScenarioName = scenario.getName();
        data = PropertiesFile.readPropertiesFile("input");
        DesiredCapabilities cap = new DesiredCapabilities();
        String browser = data.getProperty("Browser");
        ChromeOptions options = new ChromeOptions();// You can set this property elsewhere
        String headless = data.getProperty("headless");
        //Chrome options setup
        if (browser.contains("chrome")) {
            cap.setCapability("browserVersion", "97");
            cap.setCapability("platformName", "Windows XP");
        //Check for headless run
        if (headless=="true")
        {
            options.addArguments("--headless");
        }
            cap.setCapability(ChromeOptions.CAPABILITY, options);
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(cap);
            String Url = data.getProperty("baseUrl");
            driver.navigate().to(Url);
            driver.manage().window().maximize();
        }
        //Initialize all web elements with the Page Objects
        homePage = PageFactory.initElements(driver, HomePage.class);
        customerDetailsPage=PageFactory.initElements(driver,CustomerDetailsPage.class);
        customerContactPage=PageFactory.initElements(driver,CustomerContactPage.class);
        closingQuestionPage=PageFactory.initElements(driver,ClosingQuestionPage.class);
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