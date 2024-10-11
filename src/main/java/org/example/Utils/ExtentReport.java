package org.example.Utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReport {
    private static ExtentReports extent;
    private static ExtentTest test;

    public static ExtentReports getInstance() {
        if (extent == null) {
            String timestamp = new SimpleDateFormat("yyyy_MM_dd_HH-mm-ss").format(new Date());
            String reportName = "ExtentReport_" + timestamp + ".html";
            ExtentSparkReporter spark = new ExtentSparkReporter("test-output/" + reportName);
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }

    public static ExtentTest createTest(String testName) {
        test = extent.createTest(testName);
        return test;
    }

    public static void flush() {
        if (extent != null) {
            extent.flush();
        }
    }
}

