package com.ds.quandoo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends BasePage {

    public StartPage(WebDriver driver) {
        super(driver);
    }

    // page elements

    private String traitElementCSS = "h1+h2+ul";

    @FindBy(css = "a[href $= 'login']")
    private WebElement loginPageLink;

    @FindBy(css = "a[href $= 'hovers']")
    private WebElement hoversPageLink;

    @FindBy(css = "a[href $= 'tables']")
    private WebElement dataTablesPageLink;

    // page methods

    public void openLoginPage() {
        loginPageLink.click();
    }

    public void openHoversPage() {
        hoversPageLink.click();
    }

    public void openDataTablesPage() {
        dataTablesPageLink.click();
    }

    private StartPage ensurePageLoaded() {
        waitForPageToLoad();
        try {
            getElementByCSS(traitElementCSS);
        } catch (TimeoutException e) {
            System.out.println("Timeout exceeded while waiting for " + this.getClass().getSimpleName() + " to load!");
        }
        return this;
    }

    @Override
    public boolean isPageLoaded() {
        return ensurePageLoaded().isElementPresent(By.cssSelector(traitElementCSS));
    }
}
