package org.example.page;

import com.microsoft.playwright.Page;

public class AdminPage extends basePage{
    public AdminPage(Page page) {
        super(page);
    }
    //Object creation
    private basePage BasePage=new basePage(page);
}
