package listeners;

import org.testng.*;

import com.aventstack.extentreports.*;

import reports.ExtentManager;

public class ExtentListener
implements ITestListener {

    ExtentReports extent =
            ExtentManager.getReport();

    ExtentTest test;

    public void onTestStart(
            ITestResult result) {

        test = extent.createTest(
                result.getName());
    }

    public void onTestSuccess(
            ITestResult result) {

        test.pass("Test Passed");
    }

    public void onTestFailure(
            ITestResult result) {

        test.fail(result.getThrowable());
    }

    public void onFinish(
            ITestContext context) {

        extent.flush();
    }
}