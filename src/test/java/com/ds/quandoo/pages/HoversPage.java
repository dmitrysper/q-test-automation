package com.ds.quandoo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HoversPage extends BasePage {

    public HoversPage(WebDriver driver) {
        super(driver);
        pictureNumbers = new HashMap<>();
        pictureNumbers.put("first", 0);
        pictureNumbers.put("second", 1);
        pictureNumbers.put("third", 2);
    }

    private Map<String, Integer> pictureNumbers;

    // page elements

    private String traitElementCSS = ".figure";

    @FindBy(css = "div.figure")
    private List<WebElement> avatarDivs;

    // page methods

    public void hoverOverPicture(String pictureNumber) {
        new Actions(driver)
                .pause(SHORT_DELAY)
                .moveToElement(avatarDivs.get(pictureNumbers.get(pictureNumber)))
                .perform();
    }

    private HoversPage ensurePageLoaded() {
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
