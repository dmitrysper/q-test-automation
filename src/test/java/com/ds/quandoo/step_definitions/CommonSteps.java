package com.ds.quandoo.step_definitions;

import com.ds.quandoo.world.World;
import io.cucumber.java8.En;
import org.junit.Assert;

/**
 * CommonSteps
 * Class with common step definitions
 *
 * @author Dmitrii Speranskii
 */
public class CommonSteps implements En {

    public CommonSteps(World world) {

        Given("^I am on the \"([^\"]*)\" page$", (String page) -> {
            switch(page) {
                case "Start":
                    world.setCurrentPage(world.getPm().startPage);
                    world.getCurrentPage().isPageLoaded();
                    break;
            }
        });

        Then("^I should see \"([^\"]*)\" page$", (String page) -> {
            switch(page) {
                case "Start":
                    world.setCurrentPage(world.getPm().startPage);
                    break;
                case "Login":
                    world.setCurrentPage(world.getPm().loginPage);
                    break;
                case "Secure Area":
                    world.setCurrentPage(world.getPm().secureAreaPage);
                    break;
                case "Hovers":
                    world.setCurrentPage(world.getPm().hoversPage);
                    break;
                case "Data Tables":
                    world.setCurrentPage(world.getPm().dataTablesPage);
                    break;
            }
            Assert.assertTrue(world.getCurrentPage().isPageLoaded());
        });

        When("^I click on \"([^\"]*)\" button$", (String button) -> {
            switch(button) {
                case "Login":
                    world.getPm().loginPage.performLogin();
                    break;
            }
        });

        When("^I click on \"([^\"]*)\" link$", (String link) -> {
            switch(link) {
                case "Form Authentication":
                    world.getPm().startPage.openLoginPage();
                    break;
                case "Hovers":
                    world.getPm().startPage.openHoversPage();
                    break;
                case "Sortable Data Tables":
                    world.getPm().startPage.openDataTablesPage();
                    break;
            }
        });

        Then("^I should see \"([^\"]*)\" (message|error message|text)$", (String text, String messageType) -> {
            Assert.assertTrue(world.getCurrentPage().pageHasText(text));
        });

    }
}
