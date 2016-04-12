package com.nemea.test.system.pageobjectmodels.amazon;

import com.nemea.test.system.helper.Driver;
import org.openqa.selenium.By;

/**
 * The <code>AmazonBasketConfirmationPage</code> class is a Page Object modelling the Amazon Basket Confirmation web page.
 */
public class AmazonBasketConfirmationPage {
    /**
     * Returns the message when an item is added to Basket.
     *
     * @return <code>String</code> with the item added to Basket message.
     */
    public String getItemAddedToBasketMessage() {
        return Driver.getWebDriver().findElement(By.id("huc-v2-order-row-confirm-text")).getText();
    }

    /**
     * Returns the Basket subtotal text.
     *
     * @return <code>String</code> with the Basket subtotal.
     */
    public String getBasketSubtotal() {
        return Driver.getWebDriver().findElement(By.cssSelector("#hlb-subcart span.huc-subtotal")).getText();
    }
}
