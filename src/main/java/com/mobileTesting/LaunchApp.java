package com.mobileTesting;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class LaunchApp {

    private static Properties testData;

    public String getProperty(String key) {
        return testData.getProperty(key);
    }

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        /*E-comm
        package name - com.solodroid.solomerce
        activity names-.activities.MainActivity
                       .activities.ActivitySplash*/

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        //playstore app activity
//        desiredCapabilities.setCapability("packageName","com.android.vending");
//        desiredCapabilities.setCapability("activityName","com.android.vending.AssetBrowserActivity");


///https://github.com/appium/appium-uiautomator2-driver#capabilities
//        desiredCapabilities.setCapability("appium:appPackage", "com.solodroid.solomerce");
//        desiredCapabilities.setCapability("appium:appActivity", ".activities.MainActivity");

        desiredCapabilities.setCapability("appPackage", "com.solodroid.solomerce");
        desiredCapabilities.setCapability("appActivity", ".activities.MainActivity");
        desiredCapabilities.setCapability("deviceName","GooglePixel");
        desiredCapabilities.setCapability("platformVersion","13");
        desiredCapabilities.setCapability("platformName","Android");

        //  starting server through terminal require this capability
       // desiredCapabilities.setCapability("appium:automationName", "uiautomator2");


        //unlock desired capabilities
        desiredCapabilities.setCapability("appium:unlockType", "pin");
        desiredCapabilities.setCapability("appium:unlockKey", "2213");


        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement search = driver.findElement(By.id("com.solodroid.solomerce:id/search"));

        //swipe operation
       /* TouchAction swipeAction = new TouchAction(driver);
        //swipe left
        swipeAction.press(PointOption.point(880,1330)).waitAction().
                moveTo(PointOption.point(80,1330)).release().perform();

        //swipe right
        swipeAction.press(PointOption.point(80,1330)).waitAction().
                moveTo(PointOption.point(880,1330)).release().perform();*/

        //calculator app activity
        // package name - com.google.android.calculator
        // activity name - com.android.calculator2.Calculator

        //switch to calculator app
        //Activity calculator = new Activity("com.google.android.calculator","com.android.calculator2.Calculator");
        //driver.startActivity(calculator);
        //driver.pressKey(new KeyEvent(AndroidKey.CALCULATOR)); //switches to calculator, works in pixel
        //driver.pressKey(new KeyEvent(AndroidKey.BACK));

        //scrolling down to element

       /* while (true) {
            swipeAction.press(PointOption.point(650, 1330)).waitAction().
                    moveTo(PointOption.point(650, 200)).release().perform();
            if (driver.findElement(By.id("com.solodroid.solomerce:id/category_image")).isDisplayed()){
                break;
            }
        }*/

        //com.solodroid.solomerce:id/recycler_view
        //Animal Jumpsuit for Newborn Baby

       driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()." +
               "resourceId(\"com.solodroid.solomerce:id/viewpager\"))." +
               "scrollForward().scrollIntoView(new UiSelector().textContains(\"Animal Jumpsuit for Newborn Baby\"))");

         WebElement babySuit =  driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"Animal Jumpsuit for Newborn Baby\")");
         babySuit.click();

          driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.solodroid.solomerce:id/product_image\")").click();

        MultiTouchAction multiAction = new MultiTouchAction(driver);
        TouchAction touch1 = new AndroidTouchAction(driver);
        TouchAction touch2 = new AndroidTouchAction(driver);

        touch1.press(PointOption.point(290,790)).moveTo(PointOption.point(290,400)).release();
        touch2.press(PointOption.point(290,800)).moveTo(PointOption.point(290,1200)).release();

        multiAction.add(touch1).add(touch2).perform();


        //clicks on profile
        //driver.findElement(By.id("com.solodroid.solomerce:id/nav_profile")).click();

        /*clicks on search
        driver.findElement(By.id("com.solodroid.solomerce:id/search")).click();
        driver.findElement(By.id("com.solodroid.solomerce:id/search_src_text")).sendKeys("watch");
        driver.hideKeyboard();*/

        /*clicking action on element by getting its location
        WebElement category = driver.findElement(By.id("com.solodroid.solomerce:id/nav_category"));
        Point categorySize = category.getLocation();
        System.out.println(categorySize.x);
        System.out.println(categorySize.y);
        TouchAction action = new TouchAction(driver);
        action.tap(PointOption.point(categorySize.x, categorySize.y)).perform();*/

        //screen orientation
        if (driver.getOrientation().equals(ScreenOrientation.LANDSCAPE)) {
            driver.rotate(ScreenOrientation.PORTRAIT);
        }
        driver.rotate(ScreenOrientation.LANDSCAPE);
        driver.runAppInBackground(Duration.ofSeconds(5));
        driver.rotate(ScreenOrientation.PORTRAIT);

        /*lock & unlock
        driver.lockDevice();
        Thread.sleep(5000);
        driver.unlockDevice();*/


        System.out.println("Demo success");
    }
}