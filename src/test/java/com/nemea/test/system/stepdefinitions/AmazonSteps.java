package com.nemea.test.system.stepdefinitions;

import com.nemea.test.system.pageobjectmodels.amazon.*;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * The <code>AmazonSteps</code> class holds all the Amazon-related Cucumber step definition methods.
 */
public class AmazonSteps {
    /**
     * A <code>String</code> used to store the title of the chosen Amazon item.
     */
    private String titleInSearchResults;

    /**
     * Clicks on Amazon's Today's Deals link.
     */
    @When("^I select Today's Deals$")
    public void iSelectTodaysDeals() {
        new AmazonHomePage().clickTodaysDeals();
    }

    /**
     * Clicks on Amazon's Today's Deals Terms and Conditions link.
     */
    @When("^I select Terms and Conditions$")
    public void iSelectTermsAndConditions() {
        new AmazonTodaysDealsPage().clickTermsAndConditions();
    }

    /**
     * Retrieves and prints out all of Amazon's Today's Deals Terms and Conditions.
     */
    @Then("^I print out all points from \"Deal of the Day and Deal of the Week Terms & Conditions\"$")
    public void iPrintOutAllPoints() {
        System.out.println("Deal of the Day and Deal of the Week Terms & Conditions:");
        for (String termsAndConditionsPoint : new AmazonTodaysDealsTAndCPage().getTermsAndConditionsList()) {
            System.out.println(termsAndConditionsPoint);
        }
    }

    /**
     * Enters item search text into the Amazon Search text box and clicks the Search button.
     *
     * @param item The search term for the item.
     */
    @When("^I search for '(.*)'$")
    public void iSearchFor(String item) {
        new AmazonHomePage().enterSearchText(item)
                .clickSearchButton();
    }

    /**
     * Asserts that a number of results are returned after item search.
     */
    @Then("^a number of results are returned$")
    public void aNumberOfResultsAreReturned() {
        assertTrue("No results were returned!", new AmazonSearchResultPage().getResultList().size() > 0);
    }

    /**
     * Stores the chosen item title and clicks on it to open the item detail page.
     *
     * @param resultIndex The index of the item to be selected from the results.
     */
    @When("^I select the (\\d+)(?:st|nd|rd|th) result$")
    public void iSelectTheFirstResult(int resultIndex) {
        AmazonSearchResultPage amazonSearchResultPage = new AmazonSearchResultPage();
        titleInSearchResults = amazonSearchResultPage.getResultItemTitleWithIndex(resultIndex);
        amazonSearchResultPage.clickResultItemWithIndex(resultIndex);
    }

    /**
     * Asserts that the item title from the result list matches the item title in the item detail page, then adds the item to basket.
     */
    @When("^I add the current item to the Basket$")
    public void iAddTheCurrentItemToTheBasket() {
        AmazonItemPage amazonItemPage = new AmazonItemPage();
        assertEquals(titleInSearchResults, amazonItemPage.getItemTitle());
        amazonItemPage.addItemToBasket();
    }

    /**
     * Asserts that the a message confirming the item is added to the basket is shown and that the basket contains 1 item.
     */
    @Then("^a message confirming item is added to Basket is shown$")
    public void aMessageConfirmingItemIsAddedToBasketIsShown() {
        AmazonBasketConfirmationPage amazonBasketConfirmationPage = new AmazonBasketConfirmationPage();
        assertEquals("Added to Basket", amazonBasketConfirmationPage.getItemAddedToBasketMessage());
        assertTrue(amazonBasketConfirmationPage.getBasketSubtotal().contains("(1 item)"));
    }

    /**
     * Clicks on the Shopping Cart to access the Basket.
     */
    @When("^I access the Basket$")
    public void iAccessTheBasket() {
        new AmazonHomePage().clickBasket();
    }

    /**
     * Asserts 3 distinct placeholders for the number of items contained in the basket.
     *
     * @param numberOfItems The number of items expected to be found in the basket.
     */
    @Then("^the Basket contains '(\\d+)' items$")
    public void theBasketContainsItems(int numberOfItems) {
        // Basket items number in trolley sign (top right)
        assertEquals(String.valueOf(numberOfItems), new AmazonHomePage().getNumberOfItemsInTopNavBasket());

        String numberOfItemsText;
        if (numberOfItems <= 1) {
            numberOfItemsText = "(" + numberOfItems + " item)";
        } else {
            numberOfItemsText = "(" + numberOfItems + " items)";
        }

        AmazonBasketPage amazonBasketPage = new AmazonBasketPage();

        // Basket items number in shopping basket
        assertTrue(amazonBasketPage.getNumberOfItemsInMainSection().contains(numberOfItemsText));

        // This section is only visible when there are items in the Basket
        if (numberOfItems > 0) {
            // Basket items number in Subtotal above 'Proceed to Checkout' button
            assertTrue(amazonBasketPage.getNumberOfItemsInCheckoutSection().contains(numberOfItemsText));
        }
    }

    /**
     * Asserts that the item added to the Basket is indeed the one displayed in the Basket.
     */
    @Then("^the current item is displayed inside the Basket$")
    public void theCurrentItemIsDisplayedInsideTheBasket() {
        boolean titleFound = false;
        // This handles the possibility of having more than 1 item in the basket.
        // It loops through all items and if any of them match with the recently added item, then it breaks the loop and asserts.
        for (String itemTitle : new AmazonBasketPage().getTitlesOfAllItemsInBasket()) {
            if (titleInSearchResults.equals(itemTitle)) {
                titleFound = true;
                break;
            }
        }
        assertTrue(titleFound);
    }
}