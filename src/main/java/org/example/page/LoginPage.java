package org.example.page;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.internal.shadowed.jackson.databind.ser.Serializers;
import org.example.Utils.ExtentReport;

import java.util.logging.Logger;


public class LoginPage extends basePage{
    public LoginPage(Page page) {
        super(page);
    }
    public Locator locUsernameDropdown=page.locator("//p[@class='oxd-userdropdown-name']");
    private basePage BasePage=new basePage(page);
    public void loginToApplication(String Url,String Username,String Password){
        navigateToURL(Url);
        BasePage.fillInTextFieldwithPlaceHolder("Username",Username);
        BasePage.fillInTextFieldwithPlaceHolder("Password",Password);
        BasePage.clickButton("Login");
        String title = page.title();
        BasePage.verifyTitle(title,"OrangeHRM");
    }

    public boolean captureAlertError(){
       return BasePage.captureErroMsg();
    }

    public void waitForLoad(){
        BasePage.waitForPageload();
    }

    public void logout(){
        clickElement(locUsernameDropdown);
        clickByText("Logout");
    }

}
