package org.example.page;
import com.aventstack.extentreports.ExtentReports;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;


import java.nio.file.Paths;
import java.util.UUID;

public class basePage{
    protected Page page;

    public basePage(Page page) {

        this.page = page;
    }

    //dynamic xpath string for dropdown - will suit for all dropdown in this application
    //%s will be replaced accordingly with the name of the dropdown
    String dynamicXPathforDropdown="//label[contains(text(),'%s')]/parent::div/following-sibling::div/child::div";
    String dynamciXpathforTextFieldBasedOnName="//label[text()='%s']/parent::div/following-sibling::div/input";
    String locAlertMsg="//span[contains(@class,'oxd-input-field-error-message')]";
    String locErrorMsg="//p[contains(@class,'oxd-alert-content-text')]";
    String locLoadingSpinner="//div[@class='oxd-loading-spinner']";

    //Framework Specific Common methods
    public void navigateToURL(String strURL) {
        page.navigate(strURL);
    }

    public void getScreenshot(String strFoldername){
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("Screenshots/" + strFoldername + "/" + UUID.randomUUID().toString() + ".png")));
    }

    public void waitForElementVisible(Locator loc){
        try{
            loc.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        }
        catch(Exception e){
            System.out.println("Desired Element Not Visible");
        }
    }

    public void waitForElementDisappear(Locator loc){
        try{
            loc.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.HIDDEN));
        }catch(Exception e){
            System.out.println("Desired Element did not disappear");
        }
    }

    public void clickButton(String eleName){
        try{
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(eleName)).first().click();
            waitForPageload();
        }
        catch(Exception e){
            System.out.println("Button not clicked as expected");
        }

    }

    public void clickElement(Locator loc){
       try{
           loc.click();
        waitForPageload();
       }
       catch(Exception e){
            System.out.println("Element not clicked as expected");
       }
    }

    public void clickByText(String text){
        try{
            page.getByText(text).first().click();
            waitForPageload();
        }
        catch(Exception e){
            System.out.println("Text not entered as expected");
        }
    }

    public void verifyTitle(String ActualTitle,String ExpectedTitle) {
        try{
            if(ActualTitle.equalsIgnoreCase(ExpectedTitle)){
                System.out.println("Titles matched");
            }
        }
        catch(Exception e){
            System.out.println("Title mismatch");
        }
    }

    public void fillInTextFieldwithPlaceHolder(String PlaceHolder,String Input){
        try{
            page.getByPlaceholder(PlaceHolder).click();
            page.getByPlaceholder(PlaceHolder).fill(Input);
        }catch(Exception e){
            System.out.println("Text not entered as expected");
        }
    }

    public void getListofTextFromLocator(Locator loc,int count){
        try{
            for (int i = 0; i < count; i++) {
            // Get the text of each element
            String text = loc.nth(i).innerText();
            System.out.println("Text of element " + (i + 1) + ": " + text);
        }
        }catch(Exception e){
            System.out.println("Text not entered as expected");
         }
    }

    public String generateNewStringByReplace(String str,String oldChar,String newChar){
        return str.replace(oldChar,newChar);
    }

    public boolean isDisplayed(String str){
        try{
            return page.locator(str).first().isVisible();
        }catch(Exception e){
            System.out.println("element not visible as expected");
            return false;
        }
    }

    public String getText(String str){
       try{
           return page.locator(str).textContent();
       }
        catch(Exception e){
            System.out.println("Text not retrived as expected");
            return null;
        }
    }
     public void waitForPageload(){
         page.waitForLoadState(LoadState.LOAD);
     }

    //Application specific common methods

    public void selectDropdown(String DropdownName,String input){
        //dropdown in DOM is given without select tag
        String generatedXpath=generateNewStringByReplace(dynamicXPathforDropdown,"%s",DropdownName);
        Locator locDD=page.locator(generatedXpath);
        waitForElementVisible(locDD);
        locDD.click();
        clickByText(input);
        //locDD.selectOption(input);
    }

    public void fillinTextBoxBasedonName(String textFieldName,String input){
        String generatedXpath=generateNewStringByReplace(dynamciXpathforTextFieldBasedOnName,"%s",textFieldName);
        Locator locTxtField=page.locator(generatedXpath);
        waitForElementVisible(locTxtField);
        locTxtField.fill(input);
    }

    public void waitforSpinnerDisappear(){
        try {
            Locator locSpinner=page.locator(locLoadingSpinner);
            waitForElementVisible(locSpinner);
            waitForElementDisappear(locSpinner);
        } catch (Exception e) {
            System.out.println("Spinner not disappear");
        }
    }

    public boolean captureErroMsg(){
        boolean flag=false;
        if(isDisplayed(locAlertMsg)){
            flag= true;
            Locator loc=page.locator(locAlertMsg);
            getListofTextFromLocator(loc,loc.count());
        }
        if(isDisplayed(locErrorMsg)){
            flag= true;
            Locator loc=page.locator(locErrorMsg);
            getListofTextFromLocator(loc,loc.count());
        }
        return flag;
    }

}
