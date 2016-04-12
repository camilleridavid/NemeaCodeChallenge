package com.nemea.test.system.pageobjectmodels.amazon;

import com.nemea.test.system.helper.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * The <code>AmazonHomePage</code> class is a Page Object modelling the Amazon home web page.
 */
public class AmazonHomePage {

    /**
     * Clicks on the Today's Deals link.
     *
     * @return The <code>AmazonHomePage</code> instance.
     */
    public AmazonHomePage clickTodaysDeals() {
        Driver.getWebDriver().findElement(By.id("nav-xshop")).findElement(By.linkText("Today's Deals")).click();
        return this;
    }

    /**
     * Locates the Amazon search box and types the search text into it.
     *
     * @param searchText The text to be searched.
     * @return The <code>AmazonHomePage</code> instance.
     */
    public AmazonHomePage enterSearchText(String searchText) {
        getSiteSearch().findElement(By.id("twotabsearchtextbox")).sendKeys(searchText);
        return this;
    }

    /**
     * Locates and clicks on the Amazon search button.
     *
     * @return The <code>AmazonHomePage</code> instance.
     */
    public AmazonHomePage clickSearchButton() {
        getSiteSearch().findElement(By.className("nav-input")).click();
        return this;
    }

    /**
     * Locates and clicks on the Amazon nav cart (Basket) button.
     *
     * @return The <code>AmazonHomePage</code> instance.
     */
    public AmazonHomePage clickBasket() {
        Driver.getWebDriver().findElement(By.id("nav-cart")).click();
        return this;
    }

    /**
     * Returns the number of items present in the nav cart (Basket).
     *
     * @return <code>String</code> containing the number of items.
     */
    public String getNumberOfItemsInTopNavBasket() {
        return Driver.getWebDriver().findElement(By.id("nav-cart-count")).getText();
    }

    /**
     * Retrieves and returns the Amazon site search element.
     *
     * @return A <code>WebElement</code> with the site search element.
     */
    private WebElement getSiteSearch() {
        return Driver.getWebDriver().findElement(By.name("site-search"));
    }
}
