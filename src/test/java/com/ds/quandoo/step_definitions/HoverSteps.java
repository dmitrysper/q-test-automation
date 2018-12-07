package com.ds.quandoo.step_definitions;

import com.ds.quandoo.world.World;
import cucumber.api.java8.En;

public class HoverSteps implements En {

    public HoverSteps(World world) {

        When("^I hover over (first|second|third) avatar picture$", (String pictureNumber) -> {
           world.getPm().hoversPage.hoverOverPicture(pictureNumber);
        });
    }
}
