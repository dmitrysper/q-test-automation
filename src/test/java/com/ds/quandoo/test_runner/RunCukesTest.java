package com.ds.quandoo.test_runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features	= "features",
        glue 		= "com.ds.quandoo.step_definitions",
		plugin = {
                "html:target/reports",
				"json:target/reports/cucumber.json",
                "junit:target/reports/cucumber-results.xml",
				"pretty"
        },
        strict 		= false,
        tags 		= "@web")
public class RunCukesTest {}
