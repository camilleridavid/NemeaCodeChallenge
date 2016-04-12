package com.nemea.test.system.helper;

import org.openqa.selenium.WebDriver;

/**
 * The <code>Driver</code> class allows all Selenium WebDriver interactions to be done through the WebDriver object that was initialised by Spring at startup.
 */
public class Driver {

    /**
     * The <code>WebDriver</code> instance that is loaded through Spring and stored in a static context.
     */
    private static WebDriver driver;

    /**
     * Sets the <code>WebDriver</code> instance and configures it.
     *
     * @param driverArg The <code>WebDriver</code> instance that was loaded by Spring.
     */
    public static void setWebDriver(WebDriver driverArg) {
        driver = driverArg;
    }

    /**
     * Returns the <code>WebDriver</code> instance in a static context.
     *
     * @return The <code>WebDriver</code> instance.
     */
    public static WebDriver getWebDriver() {
        if (driver == null) {
            throw new RuntimeException("Selenium WebDriver has not been initialized!");
        }
        return driver;
    }
}
