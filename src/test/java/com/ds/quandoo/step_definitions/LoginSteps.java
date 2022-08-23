package com.ds.quandoo.step_definitions;

import com.ds.quandoo.world.World;
import io.cucumber.java8.En;

public class LoginSteps implements En {

    public LoginSteps(World world) {

        When("^I enter (correct|incorrect) user name$", (String userNameType) -> {
            String userName = "";
            switch(userNameType) {
                case "correct":
                    userName = world.getUser().getCorrectCredentials().getUserName();
                    break;
                case "incorrect":
                    userName = world.getUser().getCredentialsWithIncorrectUserName().getUserName();
                    break;
            }
            world.getPm().loginPage.enterUserName(userName);
        });

        When("^I enter (correct|incorrect) password$", (String passwordType) -> {
            String password = "";
            switch(passwordType) {
                case "correct":
                    password = world.getUser().getCorrectCredentials().getPassword();
                    break;
                case "incorrect":
                    password = world.getUser().getCredentialsWithIncorrecPassword().getPassword();
                    break;
            }
            world.getPm().loginPage.enterPassword(password);
        });
    }
}
