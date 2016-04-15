package com.nemea.test.system.helper;

/**
 * The <code>DriverWindowHelper</code> class is a helper class that handles focus on different browser windows.
 */
public class DriverWindowHelper {

    /**
     * The handle on the original main window.
     */
    private static String mainWindowHandle;

    /**
     * Retrieves a handle on the original main window, so that focus can be set back on it if focus changes.
     */
    public static void retrieveMainWindowHandle() {
        mainWindowHandle = Driver.getWebDriver().getWindowHandle();
    }

    /**
     * Sets WebDriver focus on original main window.
     */
    public static void focusOnMainWindowHandle() {
        Driver.getWebDriver().switchTo().window(mainWindowHandle);
    }

    /**
     * Sets WebDriver focus on next available window, which is not the original main window.
     */
    public static void focusOnNextAvailableWindowHandle() {
        for (String windowHandle : Driver.getWebDriver().getWindowHandles()) {
            if (!mainWindowHandle.equals(windowHandle)) {
                Driver.getWebDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }
}