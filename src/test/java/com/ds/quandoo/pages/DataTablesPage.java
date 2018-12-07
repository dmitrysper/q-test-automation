package com.ds.quandoo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DataTablesPage extends BasePage {

    public DataTablesPage(WebDriver driver) {
        super(driver);
    }

    // page elements

    private String traitElementCSS = "#table1";

    @FindBy(css = "#table2 span.last-name")
    private WebElement lastNameTableHeader;

    @FindBy(css = "#table2 td.last-name")
    private List<WebElement> lastNameTableCells;

    // page methods

    public void changeSortingOrder() {
        lastNameTableHeader.click();
    }

    public boolean namesSortedInAscendingOrder() {
        List<String> sortedNames = getLastNames()
                .stream()
                .sorted()
                .collect(Collectors.toList());
        return sortedNames.equals(getLastNames());
    }

    public boolean namesSortedInDescendingOrder() {
        List<String> sortedNames = getLastNames()
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        return sortedNames.equals(getLastNames());
    }

    public boolean namesAreSorted() {
        return namesSortedInAscendingOrder() || namesSortedInDescendingOrder();
    }

    private List<String> getLastNames() {
        return lastNameTableCells
                .stream()
                .map(elem -> elem.getText())
                .collect(Collectors.toList());
    }

    private DataTablesPage ensurePageLoaded() {
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
