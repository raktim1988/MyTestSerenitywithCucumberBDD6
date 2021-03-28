package com.automation.utilities;

import com.automation.test.SetUp;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

/**
 * Author : Raktim Biswas
 * Purpose: All utility methods needed to do smooth automation on Web elements
 */
public class ActionMethods {

    public void sync(WebDriver driver, WebElement element) {
        try {
            Wait<WebDriver> wait = new WebDriverWait(driver, 30)
                    .ignoring(StaleElementReferenceException.class);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void type(WebElement element, String str) {
        element.clear();
        element.sendKeys(str.toString());

    }

    public void click(WebElement element) {
        element.click();
    }

    public boolean isElementPrsent(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }

    }

    public void highlightElement(WebDriver driver, WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].setAttribute('style', 'background: LightGreen; border: 2px solid yellow;' )", element);
            Thread.sleep(1000);
            js.executeScript("arguments[0].setAttribute('style', 'border: 2px white')", element);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void takeScreenshot(WebDriver driver) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(currentDir + "\\screenshots\\" + "\\" + SetUp.ScenarioName + "\\" + System.currentTimeMillis() + ".png"));

    }

    public void scrollToElement(WebDriver driver, WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

    }

    //Important method - wait until the driver with JS is ready
    public void pageLoadWait(final WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, 180);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver wdriver) {
                return ((JavascriptExecutor) driver).executeScript(
                        "return document.readyState"
                ).equals("complete");
            }
        });
    }

}
