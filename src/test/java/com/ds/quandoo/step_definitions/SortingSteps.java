package com.ds.quandoo.step_definitions;

import com.ds.quandoo.world.World;
import cucumber.api.java8.En;
import org.junit.Assert;

public class SortingSteps implements En {

    public SortingSteps(World world) {

        When("^I change sorting order of the last names$", () -> {
           world.getPm().dataTablesPage.changeSortingOrder();
        });

        Then("^I should see that last names are sorted in (ascending|descending) order$", (String order) -> {
            boolean namesSorted = false;
            switch (order) {
                case "ascending":
                    namesSorted = world.getPm().dataTablesPage.namesSortedInAscendingOrder();
                    break;
                case "descending":
                    namesSorted = world.getPm().dataTablesPage.namesSortedInDescendingOrder();
                    break;
            }
            Assert.assertTrue(namesSorted);
        });

        Then("^I should see that last names are not sorted$", () -> {
            Assert.assertFalse(world.getPm().dataTablesPage.namesAreSorted());
        });
    }
}
