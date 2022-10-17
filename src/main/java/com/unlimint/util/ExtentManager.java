package com.unlimint.util;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.unlimint.base.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Parameters;

import java.io.Console;
import java.io.IOException;
import java.util.Properties;

import static com.unlimint.base.Constants.EXTENT_REPORT_PATH;


public class ExtentManager {

    private static ExtentReports extent;
    public static Logger log = LogManager.getLogger(ExtentManager.class);

    private ExtentManager() {

    }

    /**
     * This method provides the instance of the ExtentReports
     * takes nothing as parameter and return type is ExtentReports
     *
     * @return ExtentReports
     */
    public static ExtentReports getExtentReportInstance() {
         log.info(" : ExtentManager : getInstance called");
        if (extent == null)
            createExtentReportInstance();

        return extent;
    }

    /**
     * This method creates the instance of the ExtentReport using the app.properties file.
     * Set the report Title and Name as specified in the app.properties ReportTitle and ReportName property.
     *
     * @return ExtentReports
     */

    public static ExtentReports createExtentReportInstance() {

        log.info(" : ExtentManager : createExtentReportInstance called");
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(EXTENT_REPORT_PATH);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("ExtentReport_Unlimint");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Single Test");


        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        return extent;
    }


}

