package testListeners;

import com.aventstack.extentreports.ExtentReports;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class testListener extends extentReportListener implements ITestListener {

    private static ExtentReports extent;

    public void onTestStart(ITestResult iTestResult) {
    }

    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("PASS");
    }

    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("FAIL");
    }

    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("SKIP");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {
        System.out.println("Execution started");
        extent = setUp();
    }

    public void onFinish(ITestContext iTestContext) {
        System.out.println("Execution finished");
        extent.flush();
        System.out.println("Report generated");
    }
}
