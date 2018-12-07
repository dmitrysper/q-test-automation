package com.ds.quandoo.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by dmitriisperanskii on 07/12/18
 */

public abstract class BasePage {

	private static final int WAIT_TIMEOUT = 15;
	private static final int SHORT_TIMEOUT = 3;
	private static final long DEFAULT_DELAY = 3000;
	protected static final long SHORT_DELAY = 1000;
	private static final long CHAR_TYPE_DELAY = 100;

	WebDriver driver;
	WebDriverWait wait;
	private WebDriverWait shortWait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, WAIT_TIMEOUT);
		this.shortWait = new WebDriverWait(driver, SHORT_TIMEOUT);
	}

	boolean isElementPresent(By by) {
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch(TimeoutException e) {
			return false;
		}
		return true;
	}

	WebElement getElementByCSS(String cssSelector) {
	    return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
    }

    WebElement getElementByXPath(String xPathQuery) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPathQuery)));
    }

    WebElement getElementById(String id) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
    }

    WebElement getElementByTagName(String tagName) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(tagName)));
    }

    List<WebElement> getElementsByCSS(String cssSelector) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(cssSelector)));
    }

    List<WebElement> getElementsByXPath(String xPathQuery) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xPathQuery)));
    }

    List<WebElement> getElementsById(String id) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(id)));
    }

    List<WebElement> getElementsByTagName(String tagName) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName(tagName)));
    }

	void executeJavaScript(String jSCode) {
		((JavascriptExecutor)driver).executeScript(jSCode);
	}

	void waitForPageToLoad() {
		int retryAttempts = 10, counter = 0;
		long delay = 1000;
		String jsCode = "try {" +
				"if (document.readyState !== 'complete') { return false; }" +
				"if (window.jQuery) { if (window.jQuery.active !== 0) { return false; } }" +
				"return true;" +
				"} catch (ex) { return false; }";
		while(counter < retryAttempts) {
			if(!(Boolean)((JavascriptExecutor)driver).executeScript(jsCode)) {
				System.out.println("Page is busy ...");
				try {
					Thread.sleep(delay);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			counter++;
		}
	}

	void slowType(WebElement elem, String text) {
		char[] stringChars = text.toCharArray();
		for(char c : stringChars) {
			elem.sendKeys(String.valueOf(c));
			try {
				Thread.sleep(CHAR_TYPE_DELAY);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	void delayExecution() {
		try {
			Thread.sleep(DEFAULT_DELAY);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	void shotDelayExecution() {
		try {
			Thread.sleep(SHORT_DELAY);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

    public boolean pageHasText(String text) {
	    return isElementPresent(By.xpath("//*[contains(text(), '" + text + "')]"));
    }

	public String getPageUrl() {
	    return driver.getCurrentUrl();
    }

	public abstract boolean isPageLoaded();
}
