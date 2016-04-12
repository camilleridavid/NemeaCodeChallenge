package com.nemea.test.system.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * The runner class that instantiates the Cucumber test run.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/com/nemea/test/features/",
        glue = "com.nemea.test",
        plugin = {"pretty", "junit:reports/junit.xml", "json:reports/cucumber.json", "html:reports/html-reports"},
        monochrome = true)
public class RunCukesTest {
}
