package com.nemea.test.system.pageobjectmodels.amazon;

import com.nemea.test.system.helper.Driver;
import org.openqa.selenium.By;

/**
 * The <code>AmazonItemPage</code> class is a Page Object modelling the Amazon Item web page.
 */
public class AmazonItemPage {

    /**
     * Returns the item title.
     *
     * @return <code>String</code> containing the item title.
     */
    public String getItemTitle() {
        return Driver.getWebDriver().findElement(By.id("productTitle")).getText();
    }

    /**
     * Clicks on the 'Add to Cart' button, which adds the item to the Basket.
     *
     * @return The <code>AmazonItemPage</code> instance.
     */
    public AmazonItemPage addItemToBasket() {
        Driver.getWebDriver().findElement(By.id("add-to-cart-button")).click();
        return this;
    }
}
