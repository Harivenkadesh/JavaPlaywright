package org.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.*;
import org.example.Utils.ExtentReport;
import org.example.page.LoginPage;
import org.example.page.basePage;
import org.testng.annotations.*;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


public class Tests {
    public Playwright playwright;
    public Browser browser;
    public Page page;
    public LoginPage loginPage;
    public basePage BasePage;
    public ExtentReports extent;
    public ExtentTest test;
    BrowserContext context;
    public String timestamp = new SimpleDateFormat("yyyy_MM_dd_HH-mm-ss").format(new Date());
    @BeforeSuite
    public void startReport(){
        playwright = Playwright.create();
        extent = ExtentReport.getInstance();
    }
    @BeforeTest
    public void setUp() {

        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos/"+timestamp)));
        page = context.newPage();
        loginPage = new LoginPage(page);
        BasePage=new basePage(page);
    }
    @AfterTest
    public void tearDown() {
        context.close();
        browser.close();

    }

    @AfterSuite
    public void stopReport(){
        playwright.close();
        ExtentReport.flush();
    }
}
