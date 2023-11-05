package com.mobileTesting.pages;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class HomPage {

    AppiumDriver driver;

    public HomPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver) ,this);
        this.driver = driver;
    }

    @AndroidFindBy(id = "com.solodroid.solomerce:id/search")
    private MobileElement search;

    @AndroidFindBy(id = "com.solodroid.solomerce:id/search_src_text")
    private  MobileElement searchBox;

    @AndroidFindBy(id = "com.solodroid.solomerce:id/category_image")
    private MobileElement appleWatch;

    @AndroidFindBy(id = "com.solodroid.solomerce:id/lyt_checkout")
    private MobileElement addToCart;

    @AndroidFindBy(id = "com.solodroid.solomerce:id/userInputDialog")
    private MobileElement noOfOrders;

    @AndroidFindBy(id = "android:id/button1")
    private MobileElement add;

    @AndroidFindBy(id = "com.solodroid.solomerce:id/cart")
    private MobileElement cart;

    @AndroidFindBy(id = "com.solodroid.solomerce:id/product_name")
    private MobileElement cartText;

    @AndroidFindBy(id = "com.solodroid.solomerce:id/btn_checkout")
    private MobileElement checkout;

    @AndroidFindBy(id = "android:id/button1")
    private MobileElement clearYes;


    public void selectSearch() {
        search.click();
    }

    public void sendSearch(String searchItem) {
        searchBox.sendKeys(searchItem);
    }

    public void hideKeyBoard() {
        driver.hideKeyboard();
    }

    public void selectAppleWatch() {
        appleWatch.click();
    }

    public void clickAddToCart() {
        addToCart.click();
    }

    public void sendNoOfOrders(String count) {
        noOfOrders.sendKeys(count);
    }

    public void setAddToCart() {
        add.click();
    }

    public void clickOnCart() {
        cart.click();
    }

    public String getCartText() {
       return cartText.getText();
    }

    public void checkItOut() {
        checkout.click();

    }

    public void selectYes() {
        clearYes.click();
    }





}
