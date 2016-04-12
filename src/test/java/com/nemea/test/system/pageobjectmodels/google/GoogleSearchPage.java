package com.nemea.test.system.pageobjectmodels.google;

import com.nemea.test.system.helper.Driver;
import org.openqa.selenium.By;

/**
 * The <code>GoogleSearchPage</code> class is a Page Object modelling the Google Search web page.
 */
public class GoogleSearchPage {
    /**
     * Locates the Google Search search box and types the search text into it.
     *
     * @param searchText The text to be searched.
     * @return The <code>GoogleSearchPage</code> instance.
     */
    public GoogleSearchPage enterSearchText(String searchText) {
        Driver.getWebDriver().findElement(By.id("lst-ib")).sendKeys(searchText);
        return this;
    }

    /**
     * Locates and clicks on the Google Search search button.
     *
     * @return The <code>GoogleSearchPage</code> instance.
     */
    public GoogleSearchPage clickSearchButton() {
        Driver.getWebDriver().findElement(By.name("btnG")).click();
        return this;
    }
}
