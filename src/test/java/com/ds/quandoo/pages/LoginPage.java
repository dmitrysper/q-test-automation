package com.ds.quandoo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // page elements

    private String traitElementCSS = "#username";

    @FindBy(id = "username")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(css = "button[type = 'submit']")
    private WebElement submitButton;

    @FindBy(css = "div#flash")
    private WebElement errorMessageDiv;

    // page methods

    public void enterUserName(String userName) {
        userNameInput.sendKeys(userName);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void performLogin() {
        submitButton.click();
    }

    public String getErrorMessage() {
        return errorMessageDiv.getText().trim();
    }

    private LoginPage ensurePageLoaded() {
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
