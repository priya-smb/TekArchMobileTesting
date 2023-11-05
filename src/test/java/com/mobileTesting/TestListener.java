//package com.mobileTesting;
//
//import com.aventstack.extentreports.markuputils.ExtentColor;
//import com.aventstack.extentreports.markuputils.MarkupHelper;
//import com.mobileTesting.BaseTest;
//import com.mobileTesting.utils.CommonUtils;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//import java.io.IOException;
//
//public class TestListener implements ITestListener {
//
//    protected Logger logger = LogManager.getLogger(getClass().getName());
//
//    @Override
//    public void onTestSuccess(ITestResult result) {
//        Object testClass = result.getInstance();
//        BaseTest baseTest = (BaseTest) testClass;
//        baseTest.test.pass(MarkupHelper.createLabel(result.getName()+ " PASSED", ExtentColor.GREEN));
//
//    }
//
//    @Override
//    public void onTestFailure(ITestResult result) {
//        logger.info("Test failed : " + result.getTestName());
//
//        Object testClass = result.getInstance();
//        BaseTest baseTest = (BaseTest) testClass;
//        baseTest.test.fail(MarkupHelper.createLabel(result.getName() + " FAILED", ExtentColor.RED));
//
//        try {
//            baseTest.test.addScreenCaptureFromPath(CommonUtils.getScreenshot(baseTest.getDriver()));
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//    }
//}
