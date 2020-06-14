import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import pageObjects.Base;
import pageObjects.Reports;

import java.io.IOException;

public class Listeners extends Base implements ITestListener {

    ExtentTest test;
    ExtentReports exte = Reports.getReportObj();
    ThreadLocal<ExtentTest> exteTest = new ThreadLocal<ExtentTest>();

    public void onTestStart(ITestResult result) {
        test = exte.createTest(result.getMethod().getMethodName());
        exteTest.set(test);

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        //Report for Pass testcase here
        exteTest.get().log(Status.PASS, "Test Pass");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver =null;
        //Reports for Fail testcase here
        exteTest.get().fail(result.getThrowable());
        //ScreenShot code here
        //testcaseName is name of testcase/class failed
        String testcaseName = result.getMethod().getMethodName();
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (Exception e) {

        }
        try {
            exteTest.get().addScreenCaptureFromPath(getScreenShotPath(testcaseName, driver), testcaseName);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        exte.flush();

    }
}
