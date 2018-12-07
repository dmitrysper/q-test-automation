package com.ds.quandoo.managers;

import com.ds.quandoo.util.PropertyLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.IOException;

public class AppManager {

    private WebDriver driver;

    /* Browsers constants */
    private static final String FIREFOX = "firefox";
    private static final String FIREFOX_HEADLESS = "firefox_headless";
    private static final String CHROME = "chrome";
    private static final String CHROME_HEADLESS = "chrome_headless";

    private static AppManager am;

    public static AppManager getAppManager() {
        if(am == null) {
            am = new AppManager();
        }
        return am;
    }

    private AppManager() {}

    public void startApp() {
        startWebDriver();
        driver.manage().window().maximize();
        loadStartPage();
    }

    public WebDriver getDriver() {
        return driver;
    }

    private void startWebDriver() {
        String browserName = PropertyLoader.loadProperty("browser.name");
        String driverPath = System.getProperty("user.dir") + PropertyLoader.loadProperty("driver.path");
        System.out.println(System.getProperty("os.name"));
        if(System.getProperty("os.name").startsWith("Linux")) {
            driverPath = driverPath + "_linux";
            try {
                Runtime.getRuntime().exec("chmod +x " + driverPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(System.getProperty("os.name").startsWith("Mac")) {
            driverPath = driverPath + "_osx";
        }
        switch(browserName) {
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", driverPath);
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setAcceptInsecureCerts(true);
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case FIREFOX_HEADLESS:
                FirefoxBinary firefoxBinary = new FirefoxBinary();
                firefoxBinary.addCommandLineOptions("--headless");
                System.setProperty("webdriver.gecko.driver", driverPath);
                FirefoxOptions firefoxOptions2 = new FirefoxOptions();
                firefoxOptions2.setBinary(firefoxBinary);
                firefoxOptions2.setAcceptInsecureCerts(true);
                driver = new FirefoxDriver(firefoxOptions2);
                break;
            case CHROME:
                System.setProperty("webdriver.chrome.driver", driverPath);
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--ignore-certificate-errors");
                options.addArguments("–-disable-application-cache");
                options.addArguments("--disable-default-apps");
                options.addArguments("--disable-infobars");
                options.addArguments("--disable-popup-blocking");
                options.addArguments("--ignore-certificate-errors");
                options.addArguments("--no-sandbox");
                options.addArguments("--window-size=1920,1080");
                driver = new ChromeDriver(options);
                break;
            case CHROME_HEADLESS:
                System.setProperty("webdriver.chrome.driver", driverPath);
                ChromeOptions options2 = new ChromeOptions();
                options2.addArguments("--headless");
                options2.addArguments("--ignore-certificate-errors");
                options2.addArguments("–-disable-application-cache");
                options2.addArguments("--disable-default-apps");
                options2.addArguments("--disable-infobars");
                options2.addArguments("--disable-popup-blocking");
                options2.addArguments("--ignore-certificate-errors");
                options2.addArguments("--no-sandbox");
                options2.addArguments("--window-size=1920,1080");
                driver = new ChromeDriver(options2);
                break;
        }
    }

    private void loadStartPage() {
        driver.get(PropertyLoader.loadProperty("site.url"));
    }

    public void closeApp() {
        driver.quit();
    }
}