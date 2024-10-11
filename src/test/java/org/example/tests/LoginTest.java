package org.example.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.example.Tests;
import org.example.Utils.ExtentReport;
import org.example.page.LoginPage;
import org.example.Utils.ReadProperties;
import com.microsoft.playwright.*;
import org.example.page.basePage;
import org.testng.annotations.*;

public class LoginTest extends Tests {
    public ReadProperties readProperties;

    @Test(description ="TC01_Verify_Login_with_Incorrect_UserName",groups = "regression")
    public void TC01_Verify_Login_with_Incorrect_UserName() throws InterruptedException {
        test=extent.createTest("TC01_Verify_Login_with_Incorrect_UserName"); /*= ExtentReport.createTest();*/
        readProperties=new ReadProperties();
        String url=readProperties.getPropertyValue("url");
        String userName="ad";
        String password="admin123";
        loginPage.loginToApplication(url,userName,password);
        //loginPage.waitforPageload();
        Thread.sleep(5000);
        if(loginPage.captureAlertError()){
            test.pass("Alerts/Errors fetched and printed in console");
        }
        BasePage.getScreenshot(timestamp);
    }

    @Test(description ="TC02_Verify_Login_with_Incorrect_Password",groups = "regression")
    public void TC02_Verify_Login_with_Incorrect_Password() throws InterruptedException {
        test=extent.createTest("TC02_Verify_Login_with_Incorrect_Password"); /*= ExtentReport.createTest();*/
        readProperties=new ReadProperties();
        String url=readProperties.getPropertyValue("url");
        String userName="Admin";
        String password="admin1";
        loginPage.loginToApplication(url,userName,password);
        Thread.sleep(5000);
        if(loginPage.captureAlertError()){
            test.pass("Alerts/Errors fetched and printed in console");
        }
        BasePage.getScreenshot(timestamp);
    }

    @Test(description ="TC03_Verify_Login_with_Either_Field_Empty",groups = "regression")
    public void TC03_Verify_Login_with_Either_Field_Empty() {
        test=extent.createTest("TC03_Verify_Login_with_Either_Field_Empty"); /*= ExtentReport.createTest();*/
        readProperties=new ReadProperties();
        String url=readProperties.getPropertyValue("url");
        String userName="";
        String password="admin123";
        loginPage.loginToApplication(url,userName,password);
        loginPage.waitForLoad();
        if(loginPage.captureAlertError()){
            test.pass("Alerts/Errors fetched and printed in console");
        }
        userName="Admin";
        password="";
        loginPage.loginToApplication(url,userName,password);
        loginPage.waitForLoad();
        if(loginPage.captureAlertError()){
            test.pass("Alerts/Errors fetched and printed in console");
        }
        BasePage.getScreenshot(timestamp);
    }
    @Test(description ="TC04_Verify_Login_with_Both_Field_Empty",groups = "regression")
    public void TC04_Verify_Login_with_Both_Field_Empty() {
        test=extent.createTest("TC04_Verify_Login_with_Both_Field_Empty");
        readProperties=new ReadProperties();
        String url=readProperties.getPropertyValue("url");
        String userName="";
        String password="admin123";
        loginPage.loginToApplication(url,userName,password);
        loginPage.waitForLoad();
        if(loginPage.captureAlertError()){
            test.pass("Alerts/Errors fetched and printed in console");
        }
        userName="";
        password="";
        loginPage.loginToApplication(url,userName,password);
        loginPage.waitForLoad();
        if(loginPage.captureAlertError()){
            test.pass("Alerts/Errors fetched and printed in console");
        }
        BasePage.getScreenshot(timestamp);
    }

    @Test(description ="TC05_Verify_Login",groups = "regression")
    public void TC05_Verify_Login() throws InterruptedException {
        test=extent.createTest("TC05_Verify_Login"); /*= ExtentReport.createTest();*/
        readProperties=new ReadProperties();
        String url=readProperties.getPropertyValue("url");
        String userName=readProperties.getPropertyValue("UserName");
        String password=readProperties.getPropertyValue("Password");
        loginPage.loginToApplication(url,userName,password);
        test.pass("Navigated to URL Successfully");
        Thread.sleep(5000);
        BasePage.getScreenshot(timestamp);
        if(loginPage.locUsernameDropdown.isVisible()) {
            loginPage.logout();
        }
        test.pass("logout completed");
    }




}

