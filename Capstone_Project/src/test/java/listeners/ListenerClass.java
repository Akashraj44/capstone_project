package listeners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;
import utilities.ScreenshotUtil;

public class ListenerClass
implements ITestListener {

    @Override
    public void onTestStart(
            ITestResult result) {

        System.out.println("Test Started : " + result.getName());
    }

    @Override
    public void onTestSuccess(
            ITestResult result) {
        System.out.println("Test Passed : " + result.getName());
    }

    @Override
    public void onTestFailure(
            ITestResult result) {
        System.out.println("Test Failed : " + result.getName());

        try {
            ScreenshotUtil.captureScreenshot(BaseTest.driver,result.getName());
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}