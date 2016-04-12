package com.nemea.test.system.pageobjectmodels.amazon;

import com.nemea.test.system.helper.Driver;
import org.openqa.selenium.By;

/**
 * The <code>AmazonTodaysDealsPage</code> class is a Page Object modelling the Amazon Today's Deals web page.
 */
public class AmazonTodaysDealsPage {

    /**
     * Clicks on the first Terms and Conditions link inside the Today's Deals page.
     *
     * @return The <code>AmazonTodaysDealsPage</code> instance.
     */
    public AmazonTodaysDealsPage clickTermsAndConditions() {
        Driver.getWebDriver().findElement(By.xpath("//*[contains(@class,'pageBanner')]//a[contains(text(), 'Terms and conditions')][1]")).click();
        return this;
    }
}
