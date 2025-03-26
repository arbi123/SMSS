
package Listeners;


import ConfigPagesTest.AssertInfo;
import Utilities.BaseInformation;
import Utilities.ExtentReporterNG;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends BaseInformation implements ITestListener {

    ExtentTest test;
    ExtentReports extent = ExtentReporterNG.getReportObject();
    @Override
    public void onFinish(ITestContext Result)
    {
        extent.flush();

    }

    @Override
    public void onStart(ITestContext context) {
        // Log suite-level details such as OS and user info
        extent.setSystemInfo("Operating System", System.getProperty("os.name"));
        extent.setSystemInfo("User", System.getProperty("user.name"));
        extent.setSystemInfo("Environment", "QA"); // or dynamically retrieve from BaseInformation if available
    }


    @Override
    public void onTestFailure(ITestResult Result)
    {
        AssertInfo assertInfo = Result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(AssertInfo.class);
        if (assertInfo != null) {
            for (String info : assertInfo.value()) {
                test.log(Status.INFO, "Assert Info: " + info);
            }
        }
        test.fail(Result.getThrowable());
        String filepath = null;
        try {
            filepath = getScreenShot();
        } catch (IOException e) {
            e.printStackTrace();
        }
        test.addScreenCaptureFromPath(filepath,Result.getName());


        System.out.println("The name of the testcase failed is :"+Result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult Result)
    {

        test.log(Status.SKIP,"Test skipped");
        System.out.println("The name of the testcase Skipped is :"+Result.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getMethod().getMethodName());
        test.log(Status.INFO, "Starting test case : " + result.getMethod().getMethodName());
        test.log(Status.INFO, "Running on: " + System.getProperty("os.name"));

        // Log test parameters if any exist
        if (result.getParameters().length > 0) {
            StringBuilder params = new StringBuilder("Parameters: ");
            for (Object param : result.getParameters()) {
                params.append(param).append(" ");
            }
            test.log(Status.INFO, params.toString().trim());
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        AssertInfo assertInfo = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(AssertInfo.class);
        if (assertInfo != null) {
            for (String info : assertInfo.value()) {
                test.log(Status.INFO, "Assert Info: " + info);
            }
        }

        test.log(Status.PASS, "Test passed successfully.");
        test.log(Status.INFO, "Test case finished: " + result.getMethod().getMethodName());

        System.out.println("The name of the testcase passed is: " + result.getName());
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
    }


}
