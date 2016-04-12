package com.nemea.test.system.pageobjectmodels.amazon;

import com.nemea.test.system.helper.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * The <code>AmazonBasketPage</code> class is a Page Object modelling the Amazon Basket web page.
 */
public class AmazonBasketPage {

    /**
     * Returns the number of items present in the Basket (main section).
     *
     * @return <code>String</code> with the number of items.
     */
    public String getNumberOfItemsInMainSection() {
        return Driver.getWebDriver().findElement(By.cssSelector("#activeCartViewForm .sc-subtotal")).getText();
    }

    /**
     * Returns the number of items present in the Basket (checkout section).
     *
     * @return <code>String</code> with the number of items.
     */
    public String getNumberOfItemsInCheckoutSection() {
        return Driver.getWebDriver()
                .findElement(By.xpath("//*[@id='gutterCartViewForm']//*[@class='a-box-group']//*[contains(@class,'sc-subtotal')]//span[contains(@class,'sc-price')]/preceding-sibling::span"))
                .getText();
    }

    /**
     * Returns a <code>List&lt;String&gt;</code> containing all the item titles in the Basket.
     *
     * @return <code>List&lt;String&gt;</code> containing all the item titles in the Basket.
     */
    public List<String> getTitlesOfAllItemsInBasket() {
        List<WebElement> items = Driver.getWebDriver().findElements(By.cssSelector(".sc-list-item-content .a-list-item .sc-product-link"));
        List<String> itemTitles = new ArrayList<>(items.size());
        for (WebElement item : items) {
            itemTitles.add(item.getText());
        }
        return itemTitles;
    }
}
