package org.example.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.*;
import org.example.Tests;
import org.example.Utils.ExtentReport;
import org.example.Utils.ReadProperties;
import org.example.page.HomePage;
import org.example.page.LoginPage;
import org.example.page.basePage;
import org.testng.annotations.*;


public class HomeTest extends Tests {


    private HomePage homePage;
    public ReadProperties readProperties;

    @Test(description ="TC01_Extract_All_Menu_From_HomePage",groups = "regression")
    public void ExtractAllMenuFromHomePage() throws InterruptedException {
        test = ExtentReport.createTest("TC01_Extract_All_Menu_From_HomePage");
        homePage=new HomePage(page);
        readProperties=new ReadProperties();
        String url=readProperties.getPropertyValue("url");
        String userName=readProperties.getPropertyValue("UserName");
        String password=readProperties.getPropertyValue("Password");
        loginPage.loginToApplication(url,userName,password);
        test.pass("Login Successfull");
        BasePage.getScreenshot(timestamp);
        homePage.getAllMenuinHomePage();
        test.pass("All menu items retrived successfully");
    }

}
