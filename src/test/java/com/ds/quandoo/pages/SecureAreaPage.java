package com.ds.quandoo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SecureAreaPage extends BasePage {

    public SecureAreaPage(WebDriver driver) {
        super(driver);
    }

    // page elements

    private String traitElementCSS = "a[href $= 'logout']";

    @FindBy(css = "a[href $= 'logout']")
    private WebElement logoutLink;

    @FindBy(css = "div#flash")
    private WebElement messageDiv;

    // page methods

    public void performLogout() {
        logoutLink.click();
    }

    public String getErrorMessage() {
        return messageDiv.getText().trim();
    }

    private SecureAreaPage ensurePageLoaded() {
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
