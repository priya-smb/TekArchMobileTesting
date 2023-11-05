package com.mobileTesting;

import com.mobileTesting.pages.CheckOutFormPage;
import com.mobileTesting.pages.HomPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class completeOrderTest extends BaseTest {

    protected static Logger logger = LogManager.getLogger(completeOrderTest.class);

    HomPage homPage;
    CheckOutFormPage checkOutFormPage;

    @BeforeClass
    public void setUp() {
       AppiumDriver driver = getDriver();
        homPage = new HomPage(driver);
        checkOutFormPage = new CheckOutFormPage(driver);

    }

    @Test
    public void search() {
        homPage.selectSearch();
        logger.info("search selected");
        homPage.sendSearch("watch");
        logger.info("searched item is Watch ");
        homPage.hideKeyBoard();
        logger.info("keyboard is hidden");
//        homPage.selectAppleWatch();
//        logger.info("apple watch is selected");
//        homPage.clickAddToCart();
//        logger.info("clicked on add to cart");
//        homPage.sendNoOfOrders("1");
//        logger.info("1 watch ");
//        homPage.setAddToCart();
//        logger.info("one watch added to cart");
//        homPage.clickOnCart();
//        logger.info("clicked on cart");
//        Assert.assertEquals(homPage.getCartText(),"Apple watch series 3 GPS 42mm Black");
//        logger.info("assert of cart text is success");
//        homPage.checkItOut();
//        logger.info("clicked on checkout");
//        checkOutFormPage.clickName();
//        logger.info("clicked on on name text box");
//        checkOutFormPage.enterName("test");
//        logger.info("entered name");
//        checkOutFormPage.sendEmail("test1@123.com");
//        logger.info("emil entered");
//        checkOutFormPage.sendPhoneNum("1234567890");
//        logger.info("phone number entered");
//        checkOutFormPage.sendAddress("abcd road");
//        logger.info("address entered");
//        homPage.hideKeyBoard();
//        logger.info("keyboard is hidden");
//        checkOutFormPage.clickDropDown();
//        logger.info("clicked on dropdown");
//        checkOutFormPage.selectShippingOption("FedEx");
//        logger.info("selected option from dropdown");
//        checkOutFormPage.giveComment("good");
//        logger.info("written a comment");
//        homPage.hideKeyBoard();
//        logger.info("keyboard is hidden");
//        checkOutFormPage.clickProcessCheckout();
//        logger.info("selected process checkout");
//        checkOutFormPage.clickConfirmCheckout();
//        logger.info("clicked on confirm checkout");
//        Assert.assertEquals(checkOutFormPage.getCongratsMsg(),"Please wait");
//        logger.info("assert of confirm process success");
//        checkOutFormPage.clickOkCongrats();
//        logger.info("selected ok from congratulation msg");
//        homPage.hideKeyBoard();
//        logger.info("keyboard is hidden");
    }

}
