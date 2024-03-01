package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import factory.TestFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.ExtentReporterNG;

public class Listeners implements ITestListener {

    ExtentReports report = ExtentReporterNG.getReports();
    ExtentTest test;

    TestFactory testFactory = new TestFactory();


    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        this.test = this.report.createTest(result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);

    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        this.report.flush();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        this.test.log(Status.PASS,"TEST PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        this.test.fail(result.getThrowable());
        this.test.log(Status.FAIL, "TEST FAILED");
        this.test.addScreenCaptureFromPath(testFactory.getScreenshot(result.getName()));
    }
}
