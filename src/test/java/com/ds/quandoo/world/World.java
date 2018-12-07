package com.ds.quandoo.world;

import com.ds.quandoo.managers.PageManager;
import com.ds.quandoo.model.User;
import com.ds.quandoo.pages.BasePage;
import org.openqa.selenium.WebDriver;

public class World {

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public PageManager getPm() {
        return pm;
    }

    public void setPm(PageManager pm) {
        this.pm = pm;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BasePage getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(BasePage currentPage) {
        this.currentPage = currentPage;
    }


    private WebDriver driver;
    private PageManager pm;
    private User user;
    private BasePage currentPage;
}
