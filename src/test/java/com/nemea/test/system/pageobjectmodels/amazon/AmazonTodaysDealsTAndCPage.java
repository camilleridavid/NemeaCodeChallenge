package com.nemea.test.system.pageobjectmodels.amazon;

import com.nemea.test.system.helper.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * The <code>AmazonTodaysDealsTAndCPage</code> class is a Page Object modelling the Amazon Today's Deals Terms and Conditions web page.
 */
public class AmazonTodaysDealsTAndCPage {

    /**
     * Returns a <code>List&lt;String&gt;</code> containing all the terms and conditions.
     *
     * @return <code>List&lt;String&gt;</code> containing all the terms and conditions.
     */
    public List<String> getTermsAndConditionsList() {
        List<WebElement> tAndCElementList = Driver.getWebDriver().findElements(By.cssSelector(".help-content .a-list-item"));
        List<String> tAndCList = new ArrayList<>(tAndCElementList.size());
        for (WebElement tAndCElement : tAndCElementList) {
            tAndCList.add(tAndCElement.getText());
        }
        return tAndCList;
    }
}
