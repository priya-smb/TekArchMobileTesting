package com.mobileTesting;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static Logger logger = LogManager.getLogger(BaseTest.class);

//    private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
//
//    private static Properties testData;
//
//    //Extent Report
//    static ExtentReports extent = new ExtentReports();
//    static ExtentSparkReporter spark = null;
//    public static ExtentTest test = null;

    public DesiredCapabilities capabilities() {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability("appPackage", "com.solodroid.solomerce");
        desiredCapabilities.setCapability("appActivity", ".activities.MainActivity");
        desiredCapabilities.setCapability("deviceName", "GooglePixel");
        desiredCapabilities.setCapability("platformVersion", "13");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:unlockType", "pin");
        desiredCapabilities.setCapability("appium:unlockKey", "2213");

        return desiredCapabilities;
    }

    public AndroidDriver getAndroidDriver() {

        AndroidDriver driver = null;
        try {
            driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities());
            logger.info("capabilities set ");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.unlockDevice();
            logger.info("devise unlocked");
        } catch (MalformedURLException e) {
            e.printStackTrace();

        }
        return driver;

    }

    public IOSDriver getIOSDriver() {
        IOSDriver driver = null;
        try {
            driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities());
            logger.info("capabilities set ");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.unlockDevice();
            logger.info("devise unlocked");
        } catch (MalformedURLException e) {
            e.printStackTrace();

        }
        return driver;

    }

    public AppiumDriver getDriver() {
//        Read config from property file
        String os = System.getProperty("TEST_OS", "Android");
        AppiumDriver driver = null;
        if (os.equals("Android")) {
            driver = getAndroidDriver();
        } else {
            driver = getIOSDriver();
        }
        return driver;
    }


}
