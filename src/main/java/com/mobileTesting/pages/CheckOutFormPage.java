package com.mobileTesting.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckOutFormPage {

    AppiumDriver driver;

    public CheckOutFormPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver) ,this);
        this.driver = driver;
    }

    //checkoutForm
    @AndroidFindBy(id = "com.solodroid.solomerce:id/edt_name")
    private MobileElement yourName;

    @AndroidFindBy(id = "com.solodroid.solomerce:id/edt_email")
    private MobileElement yourEmail;

    @AndroidFindBy(id = "com.solodroid.solomerce:id/edt_phone")
    private MobileElement phoneNum;

    @AndroidFindBy(id = "com.solodroid.solomerce:id/edt_address")
    private MobileElement yourAddress;

    @AndroidFindBy(id = "com.solodroid.solomerce:id/spinner")
    private MobileElement shippingDD;

    @AndroidFindBy(id = "android:id/text1")
    private List<MobileElement> shippingOptions;

    @AndroidFindBy(id = "com.solodroid.solomerce:id/edt_comment")
    private MobileElement comment;

    @AndroidFindBy(id = "com.solodroid.solomerce:id/btn_submit_order")
    private MobileElement processCheckout;

    @AndroidFindBy(id = "android:id/button1")
    private MobileElement confirmCheckout;

    @AndroidFindBy(id = "android:id/alertTitle")
    private MobileElement congratsPopUp;

    @AndroidFindBy(id = "android:id/button1")
    private MobileElement oKCongrats;


    //checkout form
    public void clickName() {
        yourName.click();

    }

    public void enterName(String name) {
        yourName.sendKeys(name);

    }

    public void sendEmail(String email) {
        yourEmail.click();
        yourEmail.sendKeys(email);
    }

    public void sendPhoneNum(String number) {
        phoneNum.clear();
        phoneNum.sendKeys(number);
    }

    public void sendAddress(String address) {
        yourAddress.click();
        yourAddress.clear();
        yourAddress.sendKeys(address);
    }

    public void clickDropDown() {
        shippingDD.click();
    }

    public void selectShippingOption(String shippingChoice) {
        for (MobileElement shippingOpt : shippingOptions){
            if (shippingOpt.getText().equals(shippingChoice)) {
                shippingOpt.click();
                break;
            }
        }
    }

    public void giveComment(String commentMsg) {
        comment.click();
        comment.sendKeys(commentMsg);
    }

    public void clickProcessCheckout() {
        processCheckout.click();
    }

    public void clickConfirmCheckout() {
        confirmCheckout.click();
    }

    public String getCongratsMsg() {
        return congratsPopUp.getText();
    }

    public void clickOkCongrats() {
        oKCongrats.click();

    }

}
