package com.unlimint.util;



import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;



//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
import com.unlimint.base.TestSuiteBase;
import com.unlimint.workflow.Registration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;


public class ExtentTestNGITestListener implements ITestListener, ISuiteListener {

    Date currentDate;
    SimpleDateFormat formattedDate;
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static Logger log = LogManager.getLogger(ExtentTestNGITestListener.class);
    public static ExtentReports extent = ExtentManager.createExtentReportInstance();
    private static ThreadLocal parentTest = new ThreadLocal();
    private static ThreadLocal test = new ThreadLocal();
    final String tstStrtMsg = " <-- {Test End} Ended the execution of ";



    public ExtentTestNGITestListener() {
        super();
        currentDate = new Date();
        formattedDate = new SimpleDateFormat("_MM-dd-yyyy__hh.mm.ss_zzz");
        log.info(" : ExtentTestNGITestListener Constructor called");

    }

    /**
     * Invoked after the test class is instantiated and before any configuration
     * method is called. set the parent ExtentTest
     */
    public synchronized void onStart(ITestContext context) {
        ExtentTest parent = extent.createTest(context.getName());
        parentTest.set(parent);
        log.info(" : ITestListener onStart called - ParentTest instantiated"+parent);

         }

    /**
     * Invoked after all the tests have run and all their Configuration methods
     * have been called. flush the ExtentReport
     */
    public synchronized void onFinish(ITestContext context) {
        log.info(" : ITestListener onFinish called");
        extent.flush();
    }

    /**
     * Invoked each time before a test will be invoked. set the child ExtentTest
     * to the parent and initialize the name to test method name
     */
    public synchronized void onTestStart(ITestResult result) {


        String nodeName = result.getMethod().getMethodName();



        try {
            nodeName = result.getMethod().getDescription();
        } catch (Exception e) {
            nodeName = result.getMethod().getMethodName();
        } finally {

            System.out.println("node name "+nodeName);
            System.out.println("node name "+((ExtentTest) parentTest.get()).createNode(nodeName));
            ExtentTest child = ((ExtentTest) parentTest.get()).createNode(nodeName);
            //ExtentTest child = ((ExtentTest) parentTest.get()).createNode(result.getMethod().getDescription());
            test.set(child);
            log.info(" : onTestStart called - ChildTest instantiated" + child);
            log.info(" --> {Test Start} Starting the execution of " + result.getMethod().getMethodName());
            System.out.println(ANSI_GREEN + "--> {Test Start} Starting the execution of " + ANSI_RESET);
        }
    }

    /**
     * Invoked each time a test succeeds. set the child Test to passed status
     */
    public synchronized void onTestSuccess(ITestResult result) {

        log.info(tstStrtMsg+ result.getMethod().getMethodName());
        ((ExtentTest) test.get()).pass("Test passed");

    }

    /**
     * Invoked each time a test fails. set the child Test to fail status.
     * And takes the screenshot of the browser window using the {@link Screenshots}.takeScreenshot method
     */
    public synchronized void onTestFailure(ITestResult result) {

        log.info(" : onTestFailure called");
        log.info(tstStrtMsg + result.getMethod().getMethodName());

        String imageName = result.getName() + formattedDate.format(currentDate);
        String imagepath;

        log.warn("screenshot captured");

        try {
            imagepath = Screenshots.takeScreenshot(((WebDriverProvider) result.getInstance()).driver, imageName);
            ((ExtentTest) test.get()).fail(result.getName() + " TEST FAILED..",
                    MediaEntityBuilder.createScreenCaptureFromPath(imagepath, imageName).build());
            log.error(result.getName() + " TEST FAILED due to "+result.getThrowable());
            log.error(result.toString());
            ((ExtentTest) test.get()).fail(result.getThrowable());

        } catch (IOException e) {
            e.printStackTrace();

        }
    }


    /**
     * Invoked each time a test is skipped. set the child Test to skip status
     */
    public synchronized void onTestSkipped(ITestResult result) {
        log.info(" : onTestSkipped called");
        log.info(" <-- {Test End} Ended the execution of "+ result.getMethod().getMethodName());
        ((ExtentTest) test.get()).skip(result.getName() + " SKIPPED");
       // readData.addDataToUnUsedContracts(rowData);
    }

    /**
     * Invoked each time a method fails but has been annotated with
     * successPercentage and this failure still keeps it within the success
     * percentage requested.
     */
    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        //not being used as of now
    }

    /**
     * This method is invoked before the SuiteRunner starts. Called at Start of
     * the Test Suite
     */
    public void onStart(ISuite suite) {
        //log.info(" : ISuite onStart called");

    }

    /**
     * This method is invoked after the SuiteRunner has run all the test suites.
     * Called at End of the Test Suite
     */
    public void onFinish(ISuite suite) {
        //log.info(" : ISuite onFinish called");
        Screenshots.sshotSetRelativePath();
    }

    /**
     * get the child Test instance
     *
     * @return ExtentTest
     */
    public static ExtentTest getTestExtent() {
        //log.info(" : getTestExtent called"+(ExtentTest) test.get());

        return (ExtentTest) test.get();

    }

    public static ExtentTest getParentTest() {
        return (ExtentTest) parentTest.get();
    }

    public static ExtentTest getChildTest() {
        return (ExtentTest) test.get();
    }

}

