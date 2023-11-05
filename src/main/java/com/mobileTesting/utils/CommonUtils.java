package com.mobileTesting.utils;

import com.mobileTesting.constants.FileConstants;
import com.mobileTesting.constants.WaitConstants;
import org.openqa.selenium.*;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CommonUtils {
    public static String getStringDateAndTimeStamp() {
        String value = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        return value;
    }

    public static String getScreenshot(WebDriver driver) throws IOException {
        String path = FileConstants.SCREENSHOT_PATH;
        TakesScreenshot screen = (TakesScreenshot) driver;
        if (screen != null) {
            File src = screen.getScreenshotAs(OutputType.FILE);
            File dst = new File(path);
            FileUtils.copyFile(src, dst);
        }
        return path;
    }

    public static boolean waitForElement(WebDriver driver, WebElement element) {
        boolean isElementClickable = false;
        WebDriverWait wait = new WebDriverWait(driver, 10000);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            isElementClickable = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isElementClickable;
    }

    public static void waitForAll(WebDriver driver) {

        FluentWait wait = new FluentWait(driver);

        //Specify the timout of the wait

        wait.withTimeout(Duration.ofSeconds(5));

        //Specify polling time
        wait.pollingEvery(Duration.ofMillis(250));

        //Specify what exceptions to ignore
        wait.ignoring(NoSuchElementException.class);

//        wait.until(ExpectedConditions.vis());
    }


    public static boolean waitForElementToDisappear(WebDriver driver, WebElement element) {
        boolean isElementFound = false;
        WebDriverWait wait = new WebDriverWait(driver, 10000);
        try {
            wait.until(ExpectedConditions.invisibilityOf(element));
            isElementFound = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isElementFound;
    }

    public static void moveToElement(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    public static boolean isAlertPresent(WebDriver driver){
        boolean foundAlert = false;
        WebDriverWait wait = new WebDriverWait(driver,10000 /*timeout in seconds*/);
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            foundAlert = true;
        } catch (TimeoutException eTO) {
            foundAlert = false;
        }
        return foundAlert;
    }


}
