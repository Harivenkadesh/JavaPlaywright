package org.example.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class HomePage extends basePage{
    public HomePage(Page page) {
        super(page);
    }
    //Object creation
    private basePage BasePage=new basePage(page);
    //xpaths
    Locator locAvailableMenus=page.locator("//ul[@class='oxd-main-menu']");


    public void getAllMenuinHomePage() {
        waitForElementVisible(locAvailableMenus);
        locAvailableMenus=page.locator("//ul[@class='oxd-main-menu']/li");
        int Count=locAvailableMenus.count();
        BasePage.getListofTextFromLocator(locAvailableMenus,Count);
    }


}
