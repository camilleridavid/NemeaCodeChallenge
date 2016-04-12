package com.nemea.test.system.pageobjectmodels.amazon;

import com.nemea.test.system.helper.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * The <code>AmazonSearchResultPage</code> class is a Page Object modelling the Amazon Search Result web page.
 */
public class AmazonSearchResultPage {

    /**
     * Returns a <code>List&lt;WebElement&gt;</code> containing all the search results.
     *
     * @return <code>List&lt;WebElement&gt;</code> containing all the search results.
     */
    public List<WebElement> getResultList() {
        return Driver.getWebDriver().findElements(By.xpath("//*[@id=\"s-results-list-atf\"]//li[starts-with(@id,\"result\")]"));
    }

    /**
     * Returns the title of the item located by index.
     *
     * @param index The index of the item required.
     * @return <code>String</code> with the item title.
     */
    public String getResultItemTitleWithIndex(int index) {
        WebElement titleLink = getResultItem(index);
        return titleLink.findElement(By.tagName("h2")).getText();
    }

    /**
     * Clicks on the item located by index.
     *
     * @param index The index of the item required.
     * @return The <code>AmazonSearchResultPage</code> instance.
     */
    public AmazonSearchResultPage clickResultItemWithIndex(int index) {
        getResultItem(index).click();
        return this;
    }

    /**
     * Returns the item located by index.
     *
     * @param index The index of the item required.
     * @return <code>WebElement</code> with the item.
     */
    private WebElement getResultItem(int index) {
        return getResultList().get(index - 1).findElement(By.xpath("//a[contains(@class, \"s-access-detail-page\")]"));
    }
}
