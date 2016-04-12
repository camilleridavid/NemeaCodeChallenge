package com.nemea.test.system.stepdefinitions;

import com.nemea.test.system.helper.Driver;
import com.nemea.test.system.helper.URL;
import cucumber.api.java.en.Given;

/**
 * The <code>NavigationSteps</code> class holds the Cucumber step definition method for navigation that is common throughout all tests.
 */
public class NavigationSteps {
    /**
     * Retrieves the URL and navigates to the page.
     *
     * @param siteName The name of the site URL to be retrieved.
     */
    @Given("^I navigate to '(.*)'$")
    public void iNavigateTo(String siteName) {
        String siteURL = URL.getURL(siteName);
        Driver.getWebDriver().get(siteURL);
    }
}
