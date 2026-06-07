package reports;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    public static ExtentReports getReport() {

        ExtentSparkReporter reporter =
                new ExtentSparkReporter(
                        "./Reports/ExtentReport.html");

        ExtentReports extent =
                new ExtentReports();

        extent.attachReporter(reporter);

        extent.setSystemInfo(
                "Tester",
                "Akash");

        return extent;
    }
}