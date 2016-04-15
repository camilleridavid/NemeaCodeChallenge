package com.nemea.test.system.helper;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.io.File;
import java.io.FilenameFilter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/**
 * The <code>CucumberBeforeAfter</code> class provides means for executing code before and after each test.
 */
@ContextConfiguration("classpath:cucumber.xml")
public class CucumberBeforeAfter {

    /**
     * The autowired <code>WebDriver</code> instance that is loaded through Spring.
     */
    @Autowired
    private WebDriver driver;

    /**
     * A boolean flagging whether setup has been executed.
     */
    private static boolean isSetupExecuted = false;

    /**
     * Setup method that is triggered at the beginning of each test.
     * Images of failing tests from the previous execution are cleared, URLs from config file are loaded and singleton WebDriver is set.
     * These setup steps are only executed prior to the first test.
     */
    @Before()
    public void setup() {
        if (!isSetupExecuted) {
            File reportsDirectory = new File("reports/html-reports");

            // Lists all files in the html-reports directory that have a file name extension of .jpeg
            final File[] files = reportsDirectory.listFiles(new FilenameFilter() {
                public boolean accept(File directory, String name) {
                    return name.toLowerCase().endsWith(".jpeg");
                }
            });

            // Deletes the matched files
            for (final File file : files) {
                file.delete();
            }

            // Loads URLs from the url.xml config file
            URL.loadURLs();

            // Maximises the browser and sets timeouts for page load and implicit waits
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            // Sets the WebDriver instantiated by Spring into a static context
            Driver.setWebDriver(driver);
            // Retrieves main window handle in case new windows are opened - in order to be able to refocus on main window
            DriverWindowHelper.retrieveMainWindowHandle();

            isSetupExecuted = true;
        }
    }

    /**
     * Tear down method that is triggered at the end of each test.
     * If a Cucumber scenario fails, the time of failure is written in the report
     * and a screen shot at the point of failure is taken and embedded in the report.
     *
     * @param scenario The current Cucumber scenario that has just finished executing.
     */
    @After()
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // If there was a failure in the scenario, embed the time of failure and screenshot inside the HTML report.
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            scenario.write("Time of failure: " + dateFormat.format(Calendar.getInstance().getTime()));
            DriverScreenShotHelper.takeScreenShot(scenario);
        }
    }
}
