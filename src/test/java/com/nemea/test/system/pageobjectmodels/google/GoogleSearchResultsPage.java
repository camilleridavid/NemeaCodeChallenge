package com.nemea.test.system.pageobjectmodels.google;

import com.nemea.test.system.helper.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * The <code>GoogleSearchResultsPage</code> class is a Page Object modelling the Google Search Results web page.
 */
public class GoogleSearchResultsPage {
    /**
     * Returns a <code>WebElement</code> with the Calculator component.
     *
     * @return The <code>WebElement</code> pointing to the Calculator component.
     */
    public WebElement getCalculatorComponent() {
        return Driver.getWebDriver().findElement(By.id("cwmcwd"));
    }

    /**
     * Returns the Google Calculator result.
     *
     * @return <code>String</code> containing the Google Calculator result.
     */
    public String getCalculatorResult() {
        return Driver.getWebDriver().findElement(By.id("cwos")).getText();
    }
}
