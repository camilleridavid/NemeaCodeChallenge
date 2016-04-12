package com.nemea.test.system.helper;

import cucumber.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

/**
 * The <code>DriverScreenShotHelper</code> class is a helper class that takes a screenshot of the screen upon failure of a test.
 */
public class DriverScreenShotHelper {
    /**
     * Takes a screenshot of the current state of the browser, copies it to the relevant HTML report directory and finally embeds the image link in the report.
     *
     * @param scenario The current Cucumber scenario that has just finished executing.
     */
    public static void takeScreenShot(Scenario scenario) {
        // Take screen shot
        File sourceImageFile = ((TakesScreenshot) Driver.getWebDriver()).getScreenshotAs(OutputType.FILE);

        if (sourceImageFile == null) {
            throw new RuntimeException("Source Image File cannot be null - screen shot not taken!");
        }

        String htmlReportsPath = "reports/html-reports/";
        String imageName = System.currentTimeMillis() + ".jpeg";
        String screenShotPath = htmlReportsPath + imageName;
        try {
            // Copy original image file created by Selenium WebDriver to the file specified
            FileUtils.copyFile(sourceImageFile, new File(screenShotPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Embed screenshot link in Cucumber HTML Report
        scenario.write("<a href=\"" + imageName + "\" target=\"_blank\">Click to reveal screenshot at time of failure</a>");
    }
}