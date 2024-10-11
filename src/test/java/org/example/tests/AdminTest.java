package org.example.tests;

import com.microsoft.playwright.Page;
import org.example.Tests;
import org.example.Utils.ExtentReport;
import org.example.Utils.ReadProperties;
import org.example.page.HomePage;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.util.UUID;

public class AdminTest extends Tests {

    public ReadProperties readProperties;

    @Test(description ="TC01_Verify_Adding_User_without_UserRole_ErrorMsg",groups = "regression")
    public void TC01_Verify_Adding_User_without_UserRole_ErrorMsg() throws InterruptedException {
        test = ExtentReport.createTest("TC01_Verify_Adding_User_without_UserRole_ErrorMsg");
        readProperties=new ReadProperties();
        String url=readProperties.getPropertyValue("url");
        String userName=readProperties.getPropertyValue("UserName");
        String password=readProperties.getPropertyValue("Password");
        loginPage.loginToApplication(url,userName,password);
        BasePage.waitForPageload();
        test.pass("Login Successfull");
        BasePage.clickByText("Admin");
        test.pass("Navigated to Admin screen");
        BasePage.clickButton("ADD");
        BasePage.fillInTextFieldwithPlaceHolder("Type for hints...","Rohini K user");
        BasePage.clickByText("Rohini K user");
        BasePage.selectDropdown("Status","Enabled");
        BasePage.fillinTextBoxBasedonName("Username","$Po99");
        BasePage.fillinTextBoxBasedonName("Password","qwerty1");
        BasePage.fillinTextBoxBasedonName("Confirm Password","qwerty1");
        BasePage.clickButton("SAVE");
        Thread.sleep(2000);
        BasePage.getScreenshot(timestamp);
        if(loginPage.captureAlertError()){
            test.pass("Alerts/Errors fetched and printed in console");
        }
        test.pass("Alert/Error Validation for Admin Add flow completed");
        if(loginPage.locUsernameDropdown.isVisible()) {
            loginPage.logout();
        }
        test.pass("logout completed");
    }
    @Test(description ="TC02_Verify_Adding_User_with_InvalidEmployeeName_ErrorMsg",groups = "regression")
    public void TC02_Verify_Adding_User_with_InvalidEmployeeName_ErrorMsg() throws InterruptedException {
        test = ExtentReport.createTest("TC02_Verify_Adding_User_with_InvalidEmployeeName_ErrorMsg");
        readProperties=new ReadProperties();
        String url=readProperties.getPropertyValue("url");
        String userName=readProperties.getPropertyValue("UserName");
        String password=readProperties.getPropertyValue("Password");
        loginPage.loginToApplication(url,userName,password);
        BasePage.waitForPageload();
        test.pass("Login Successfull");
        BasePage.clickByText("Admin");
        BasePage.clickButton("ADD");
        BasePage.selectDropdown("User Role","ESS");
        BasePage.fillInTextFieldwithPlaceHolder("Type for hints...","Harvey");
        BasePage.selectDropdown("Status","Enabled");
        BasePage.fillinTextBoxBasedonName("Username","$Po99");
        BasePage.fillinTextBoxBasedonName("Password","qwerty1");
        BasePage.fillinTextBoxBasedonName("Confirm Password","qwerty1");
        BasePage.clickButton("SAVE");
        Thread.sleep(2000);
        BasePage.getScreenshot(timestamp);
        if(loginPage.captureAlertError()){
            test.pass("Alerts/Errors fetched and printed in console");
        }
        test.pass("Alert/Error Validation for Admin Add flow completed");
        if(loginPage.locUsernameDropdown.isVisible()) {
            loginPage.logout();
        }
        test.pass("logout completed");
    }
    @Test(description ="TC02a_Verify_Adding_User_without_EmployeeName_ErrorMsg",groups = "regression")
    public void TC02a_Verify_Adding_User_without_EmployeeName_ErrorMsg() throws InterruptedException {
        test = ExtentReport.createTest("TC02a_Verify_Adding_User_without_EmployeeName_ErrorMsg");
        readProperties=new ReadProperties();
        String url=readProperties.getPropertyValue("url");
        String userName=readProperties.getPropertyValue("UserName");
        String password=readProperties.getPropertyValue("Password");
        loginPage.loginToApplication(url,userName,password);
        BasePage.waitForPageload();
        test.pass("Login Successfull");
        BasePage.clickByText("Admin");
        BasePage.clickButton("ADD");
        BasePage.selectDropdown("User Role","ESS");
        BasePage.selectDropdown("Status","Enabled");
        BasePage.fillinTextBoxBasedonName("Username","$Po99");
        BasePage.fillinTextBoxBasedonName("Password","qwerty1");
        BasePage.fillinTextBoxBasedonName("Confirm Password","qwerty1");
        BasePage.clickButton("SAVE");
        Thread.sleep(2000);
        BasePage.getScreenshot(timestamp);
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("Screenshots/" + timestamp + "/" + UUID.randomUUID().toString() + ".png")));
        if(loginPage.captureAlertError()){
            test.pass("Alerts/Errors fetched and printed in console");
        }
        test.pass("Alert/Error Validation for Admin Add flow completed");
        if(loginPage.locUsernameDropdown.isVisible()) {
            loginPage.logout();
        }
        test.pass("logout completed");
    }
    @Test(description ="TC03a_Verify_Adding_User_with_Username_Lessthan_five_characters_ErrorMsg",groups = "regression")
    public void TC03a_Verify_Adding_User_with_Username_Lessthan_five_characters_ErrorMsg() throws InterruptedException {
        test = ExtentReport.createTest("TC03a_Verify_Adding_User_with_Username_Lessthan_five_characters_ErrorMsg");
        readProperties=new ReadProperties();
        String url=readProperties.getPropertyValue("url");
        String userName=readProperties.getPropertyValue("UserName");
        String password=readProperties.getPropertyValue("Password");
        loginPage.loginToApplication(url,userName,password);
        BasePage.waitForPageload();
        test.pass("Login Successfull");
        BasePage.clickByText("Admin");
        BasePage.clickButton("ADD");
        BasePage.selectDropdown("User Role","ESS");
        BasePage.fillInTextFieldwithPlaceHolder("Type for hints...","Rohini K user");
        BasePage.clickByText("Rohini K user");
        BasePage.selectDropdown("Status","Enabled");
        BasePage.fillinTextBoxBasedonName("Username","Pol");
        BasePage.fillinTextBoxBasedonName("Password","qwerty1");
        BasePage.fillinTextBoxBasedonName("Confirm Password","qwerty1");
        BasePage.clickButton("SAVE");
        Thread.sleep(2000);
        BasePage.getScreenshot(timestamp);
        if(loginPage.captureAlertError()){
            test.pass("Alerts/Errors fetched and printed in console");
        }
        test.pass("Alert/Error Validation for Admin Add flow completed");
        if(loginPage.locUsernameDropdown.isVisible()) {
            loginPage.logout();
        }
        test.pass("logout completed");
    }
    @Test(description ="TC03b_Verify_Adding_User_with_Already_Existing_Username_ErrorMsg",groups = "regression")
    public void TC03b_Verify_Adding_User_with_Already_Existing_Username_ErrorMsg() throws InterruptedException {
        test = ExtentReport.createTest("TC03b_Verify_Adding_User_with_Already_Existing_Username_ErrorMsg");
        readProperties=new ReadProperties();
        String url=readProperties.getPropertyValue("url");
        String userName=readProperties.getPropertyValue("UserName");
        String password=readProperties.getPropertyValue("Password");
        loginPage.loginToApplication(url,userName,password);
        BasePage.waitForPageload();
        test.pass("Login Successfull");
        BasePage.clickByText("Admin");
        BasePage.clickButton("ADD");
        BasePage.selectDropdown("User Role","ESS");
        BasePage.fillInTextFieldwithPlaceHolder("Type for hints...","Rohini K user");
        BasePage.clickByText("Rohini K user");
        BasePage.selectDropdown("Status","Enabled");
        BasePage.fillinTextBoxBasedonName("Username","Admin");
        BasePage.fillinTextBoxBasedonName("Password","qwerty1");
        BasePage.fillinTextBoxBasedonName("Confirm Password","qwerty1");
        BasePage.clickButton("SAVE");
        Thread.sleep(2000);
        BasePage.getScreenshot(timestamp);
        if(loginPage.captureAlertError()){
            test.pass("Alerts/Errors fetched and printed in console");
        }
        test.pass("Alert/Error Validation for Admin Add flow completed");
        if(loginPage.locUsernameDropdown.isVisible()) {
            loginPage.logout();
        }
        test.pass("logout completed");
    }
    @Test(description ="TC03c_Verify_Adding_User_without_Username_ErrorMsg",groups = "regression")
    public void TC03c_Verify_Adding_User_without_Username_ErrorMsg() throws InterruptedException {
        test = ExtentReport.createTest("TC03c_Verify_Adding_User_without_Username_ErrorMsg");
        readProperties=new ReadProperties();
        String url=readProperties.getPropertyValue("url");
        String userName=readProperties.getPropertyValue("UserName");
        String password=readProperties.getPropertyValue("Password");
        loginPage.loginToApplication(url,userName,password);
        BasePage.waitForPageload();
        test.pass("Login Successfull");
        BasePage.clickByText("Admin");
        BasePage.clickButton("ADD");
        BasePage.selectDropdown("User Role","ESS");
        BasePage.fillInTextFieldwithPlaceHolder("Type for hints...","Rohini K user");
        BasePage.clickByText("Rohini K user");
        BasePage.selectDropdown("Status","Enabled");
        BasePage.fillinTextBoxBasedonName("Password","qwerty1");
        BasePage.fillinTextBoxBasedonName("Confirm Password","qwerty1");
        BasePage.clickButton("SAVE");
        Thread.sleep(2000);
        BasePage.getScreenshot(timestamp);
        if(loginPage.captureAlertError()){
            test.pass("Alerts/Errors fetched and printed in console");
        }
        test.pass("Alert/Error Validation for Admin Add flow completed");
        if(loginPage.locUsernameDropdown.isVisible()) {
            loginPage.logout();
        }
        test.pass("logout completed");
    }
    @Test(description ="TC04_Verify_Adding_User_without_Status_ErrorMsg",groups = "regression")
    public void TC04_Verify_Adding_User_without_Status_ErrorMsg() throws InterruptedException {
        test = ExtentReport.createTest("TC04_Verify_Adding_User_without_Status_ErrorMsg");
        readProperties=new ReadProperties();
        String url=readProperties.getPropertyValue("url");
        String userName=readProperties.getPropertyValue("UserName");
        String password=readProperties.getPropertyValue("Password");
        loginPage.loginToApplication(url,userName,password);
        BasePage.waitForPageload();
        test.pass("Login Successfull");
        BasePage.clickByText("Admin");
        BasePage.clickButton("ADD");
        BasePage.selectDropdown("User Role","ESS");
        BasePage.fillInTextFieldwithPlaceHolder("Type for hints...","Rohini K user");
        BasePage.clickByText("Rohini K user");
        BasePage.fillinTextBoxBasedonName("Username","Admin123");
        BasePage.fillinTextBoxBasedonName("Password","qwerty1");
        BasePage.fillinTextBoxBasedonName("Confirm Password","qwerty1");
        BasePage.clickButton("SAVE");
        Thread.sleep(2000);
        BasePage.getScreenshot(timestamp);
        if(loginPage.captureAlertError()){
            test.pass("Alerts/Errors fetched and printed in console");
        }
        test.pass("Alert/Error Validation for Admin Add flow completed");
        if(loginPage.locUsernameDropdown.isVisible()) {
            loginPage.logout();
        }
        test.pass("logout completed");
    }
    @Test(description ="TC05a_Verify_Adding_User_with_Password_Field_empty_ErrorMsg",groups = "regression")
    public void TC05a_Verify_Adding_User_with_Password_Field_empty_ErrorMsg() throws InterruptedException {
        test = ExtentReport.createTest("TC05a_Verify_Adding_User_with_Password_Field_empty_ErrorMsg");
        readProperties=new ReadProperties();
        String url=readProperties.getPropertyValue("url");
        String userName=readProperties.getPropertyValue("UserName");
        String password=readProperties.getPropertyValue("Password");
        loginPage.loginToApplication(url,userName,password);
        BasePage.waitForPageload();
        test.pass("Login Successfull");
        BasePage.clickByText("Admin");
        BasePage.clickButton("ADD");
        BasePage.selectDropdown("User Role","ESS");
        BasePage.fillInTextFieldwithPlaceHolder("Type for hints...","Rohini K user");
        BasePage.clickByText("Rohini K user");
        BasePage.selectDropdown("Status","Enabled");
        BasePage.fillinTextBoxBasedonName("Username","Admin123");
        BasePage.fillinTextBoxBasedonName("Confirm Password","qwerty1");
        BasePage.clickButton("SAVE");
        Thread.sleep(2000);
        BasePage.getScreenshot(timestamp);
        if(loginPage.captureAlertError()){
            test.pass("Alerts/Errors fetched and printed in console");
        }
        test.pass("Alert/Error Validation for Admin Add flow completed");
        if(loginPage.locUsernameDropdown.isVisible()) {
            loginPage.logout();
        }
        test.pass("logout completed");
    }
    @Test(description ="TC05b_Verify_Adding_User_with_Password_with_Lessthan_seven_characters_ErrorMsg",groups = "regression")
    public void TC05b_Verify_Adding_User_with_Password_with_Lessthan_seven_characters_ErrorMsg() throws InterruptedException {
        test = ExtentReport.createTest("TC05b_Verify_Adding_User_with_Password_with_Lessthan_seven_characters_ErrorMsg");
        readProperties=new ReadProperties();
        String url=readProperties.getPropertyValue("url");
        String userName=readProperties.getPropertyValue("UserName");
        String password=readProperties.getPropertyValue("Password");
        loginPage.loginToApplication(url,userName,password);
        BasePage.waitForPageload();
        test.pass("Login Successfull");
        BasePage.clickByText("Admin");
        BasePage.clickButton("ADD");
        BasePage.selectDropdown("User Role","ESS");
        BasePage.fillInTextFieldwithPlaceHolder("Type for hints...","Rohini K user");
        BasePage.clickByText("Rohini K user");
        BasePage.selectDropdown("Status","Enabled");
        BasePage.fillinTextBoxBasedonName("Username","Admin123");
        BasePage.fillinTextBoxBasedonName("Password","qwer");
        BasePage.fillinTextBoxBasedonName("Confirm Password","qwerty1");
        BasePage.clickButton("SAVE");
        Thread.sleep(2000);
        BasePage.getScreenshot(timestamp);
        if(loginPage.captureAlertError()){
            test.pass("Alerts/Errors fetched and printed in console");
        }
        test.pass("Alert/Error Validation for Admin Add flow completed");
        if(loginPage.locUsernameDropdown.isVisible()) {
            loginPage.logout();
        }
        test.pass("logout completed");
    }
    @Test(description ="TC05c_Verify_Adding_User_with_Password_with_No_Numerical_ErrorMsg",groups = "regression")
    public void TC05c_Verify_Adding_User_with_Password_with_No_Numerical_ErrorMsg() throws InterruptedException {
        test = ExtentReport.createTest("TC05c_Verify_Adding_User_with_Password_with_No_Numerical_ErrorMsg");
        readProperties=new ReadProperties();
        String url=readProperties.getPropertyValue("url");
        String userName=readProperties.getPropertyValue("UserName");
        String password=readProperties.getPropertyValue("Password");
        loginPage.loginToApplication(url,userName,password);
        BasePage.waitForPageload();
        test.pass("Login Successfull");
        BasePage.clickByText("Admin");
        BasePage.clickButton("ADD");
        BasePage.selectDropdown("User Role","ESS");
        BasePage.fillInTextFieldwithPlaceHolder("Type for hints...","Rohini K user");
        BasePage.clickByText("Rohini K user");
        BasePage.selectDropdown("Status","Enabled");
        BasePage.fillinTextBoxBasedonName("Username","Admin123");
        BasePage.fillinTextBoxBasedonName("Password","qwertyui");
        BasePage.fillinTextBoxBasedonName("Confirm Password","qwerty1");
        BasePage.clickButton("SAVE");
        Thread.sleep(2000);
        BasePage.getScreenshot(timestamp);
        if(loginPage.captureAlertError()){
            test.pass("Alerts/Errors fetched and printed in console");
        }
        test.pass("Alert/Error Validation for Admin Add flow completed");
        if(loginPage.locUsernameDropdown.isVisible()) {
            loginPage.logout();
        }
        test.pass("logout completed");
    }
    @Test(description ="TC06_Verify_Adding_User_with_Confirm_Password_Field_empty_ErrorMsg",groups = "regression")
    public void TC06_Verify_Adding_User_with_Confirm_Password_Field_empty_ErrorMsg() throws InterruptedException {
        test = ExtentReport.createTest("TC06_Verify_Adding_User_with_Confirm_Password_Field_empty_ErrorMsg");
        readProperties=new ReadProperties();
        String url=readProperties.getPropertyValue("url");
        String userName=readProperties.getPropertyValue("UserName");
        String password=readProperties.getPropertyValue("Password");
        loginPage.loginToApplication(url,userName,password);
        BasePage.waitForPageload();
        test.pass("Login Successfull");
        BasePage.clickByText("Admin");
        BasePage.clickButton("ADD");
        BasePage.selectDropdown("User Role","ESS");
        BasePage.fillInTextFieldwithPlaceHolder("Type for hints...","Rohini K user");
        BasePage.clickByText("Rohini K user");
        BasePage.selectDropdown("Status","Enabled");
        BasePage.fillinTextBoxBasedonName("Username","Admin123");
        BasePage.fillinTextBoxBasedonName("Password","qwerty1");
        BasePage.clickButton("SAVE");
        Thread.sleep(2000);
        BasePage.getScreenshot(timestamp);
        if(loginPage.captureAlertError()){
            test.pass("Alerts/Errors fetched and printed in console");
        }
        test.pass("Alert/Error Validation for Admin Add flow completed");
        if(loginPage.locUsernameDropdown.isVisible()) {
            loginPage.logout();
        }
        test.pass("logout completed");
    }

    @Test(description ="TC07_Verify_Adding_User_with_Mismatch_Passwords_ErrorMsg",groups = "regression")
    public void TC07_Verify_Adding_User_with_Mismatch_Passwords_ErrorMsg() throws InterruptedException {
        test = ExtentReport.createTest("TC07_Verify_Adding_User_with_Mismatch_Passwords_ErrorMsg");
        readProperties=new ReadProperties();
        String url=readProperties.getPropertyValue("url");
        String userName=readProperties.getPropertyValue("UserName");
        String password=readProperties.getPropertyValue("Password");
        loginPage.loginToApplication(url,userName,password);
        BasePage.waitForPageload();
        test.pass("Login Successfull");
        BasePage.clickByText("Admin");
        BasePage.clickButton("ADD");
        BasePage.selectDropdown("User Role","ESS");
        BasePage.fillInTextFieldwithPlaceHolder("Type for hints...","Rohini K user");
        BasePage.clickByText("Rohini K user");
        BasePage.selectDropdown("Status","Enabled");
        BasePage.fillinTextBoxBasedonName("Username","Admin123");
        BasePage.fillinTextBoxBasedonName("Password","qwerty1");
        BasePage.fillinTextBoxBasedonName("Confirm Password","qwerty2");
        BasePage.clickButton("SAVE");
        Thread.sleep(2000);
        BasePage.getScreenshot(timestamp);
        if(loginPage.captureAlertError()){
            test.pass("Alerts/Errors fetched and printed in console");
        }
        test.pass("Alert/Error Validation for Admin Add flow completed");
        if(loginPage.locUsernameDropdown.isVisible()) {
            loginPage.logout();
        }
        test.pass("logout completed");

    }
    @Test(description ="TC08_Verify_Adding_User",groups = "regression")
    public void TC08_Verify_Adding_User() throws InterruptedException {
        test = ExtentReport.createTest("TC08_Verify_Adding_User");
        readProperties=new ReadProperties();
        String url=readProperties.getPropertyValue("url");
        String userName=readProperties.getPropertyValue("UserName");
        String password=readProperties.getPropertyValue("Password");
        loginPage.loginToApplication(url,userName,password);
        BasePage.waitForPageload();
        test.pass("Login Successfull");
        BasePage.clickByText("Admin");
        BasePage.clickButton("ADD");
        BasePage.selectDropdown("User Role","ESS");
        BasePage.fillInTextFieldwithPlaceHolder("Type for hints...","Rohini K user");
        BasePage.clickByText("Rohini K user");
        BasePage.selectDropdown("Status","Enabled");
        BasePage.fillinTextBoxBasedonName("Username","Admin123");
        BasePage.fillinTextBoxBasedonName("Password","qwerty1");
        BasePage.fillinTextBoxBasedonName("Confirm Password","qwerty1");
        BasePage.getScreenshot(timestamp);
        BasePage.clickButton("SAVE");
        BasePage.waitforSpinnerDisappear();
        test.pass("User addition Validation - Admin Add flow completed");
        BasePage.getScreenshot(timestamp);
        if(loginPage.locUsernameDropdown.isVisible()) {
            loginPage.logout();
        }
        test.pass("logout completed");
    }

}
