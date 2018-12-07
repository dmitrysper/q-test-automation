package com.ds.quandoo.step_definitions;


import com.ds.quandoo.managers.AppManager;
import com.ds.quandoo.managers.PageManager;
import com.ds.quandoo.model.User;
import com.ds.quandoo.world.World;
import cucumber.api.Scenario;
import cucumber.api.java8.En;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import static com.ds.quandoo.util.PropertyLoader.loadProperty;

/**
 * Hooks
 * Cucumber hooks for web tests
 *
 * @author Dmitrii Speranskii
 */
public class Hooks implements En {

    private AppManager am;

	public Hooks(World world) {

        // Before web tests hooks
        Before(new String[]{"@web"}, (Scenario scenario) -> {
            am = AppManager.getAppManager();
            am.startApp();
            world.setDriver(am.getDriver());
            world.setPm(new PageManager(world.getDriver()));
        });

        // Scenario specific hooks
        Before(new String[]{"@login"}, (Scenario scenario) -> {
            String userName = loadProperty("username");
            String password = loadProperty("password");
            world.setUser(new User().setUserCredentials(userName, password));
        });

        // After web tests hooks
        After(new String[]{"@web"}, (Scenario scenario) -> {
            if (scenario.isFailed()) {
                // Takes a screenshot and embeds it in the report...
                final byte[] screenshot = ((TakesScreenshot) am.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            }
            am.closeApp();
        });

    }

}
