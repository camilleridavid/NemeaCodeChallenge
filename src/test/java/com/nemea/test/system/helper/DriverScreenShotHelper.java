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

        String cucumberFailureScreenShotPath;
        // This handles screen shot paths when test is run on Jenkins
        String buildURL = System.getenv("BUILD_URL");
        if (buildURL != null) {
            // Replaces the build number with ws/ in, for example, http://40.85.141.124:8080/job/Nemea%20Run%20System%20Tests/1/
            buildURL = buildURL.replaceAll("\\d+/$", "ws/");
            String absoluteImagePath = buildURL + screenShotPath;
            cucumberFailureScreenShotPath = absoluteImagePath.replace(" ", "%20");
        } else {
            // This is the path for tests executed on local machine
            cucumberFailureScreenShotPath = imageName;
        }
        scenario.write("<a href=\"" + cucumberFailureScreenShotPath + "\" target=\"_blank\">Click to reveal screenshot at time of failure</a>");
    }
}