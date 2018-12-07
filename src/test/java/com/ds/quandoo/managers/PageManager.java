package com.ds.quandoo.managers;

import com.ds.quandoo.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PageManager {

    private static final int WAIT_TIMEOUT = 15;
    private WebDriver driver;

    // pages

    public StartPage startPage;
    public LoginPage loginPage;
    public SecureAreaPage secureAreaPage;
    public HoversPage hoversPage;
    public DataTablesPage dataTablesPage;

    public PageManager(WebDriver driver) {
        this.driver = driver;
        initPageObjects();
    }

    private void initPageObjects() {
        startPage = initElements(new StartPage(driver));
        loginPage = initElements(new LoginPage(driver));
        secureAreaPage = initElements(new SecureAreaPage(driver));
        hoversPage = initElements(new HoversPage(driver));
        dataTablesPage = initElements(new DataTablesPage(driver));
    }

    private <T extends BasePage> T initElements(T page) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, WAIT_TIMEOUT), page);
        return page;
    }
}
