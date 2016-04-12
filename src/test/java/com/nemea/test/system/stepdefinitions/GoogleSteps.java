package com.nemea.test.system.stepdefinitions;

import com.nemea.test.system.pageobjectmodels.google.GoogleSearchPage;
import com.nemea.test.system.pageobjectmodels.google.GoogleSearchResultsPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * The <code>GoogleSteps</code> class holds all the Google-related Cucumber step definition methods.
 */
public class GoogleSteps {
    /**
     * Enters text into the Google Search text box and clicks the Search button.
     *
     * @param searchText The text to be entered in the Google Search text box.
     */
    @When("^I search for '(.*)' on Google Search$")
    public void iSearchForSearchText(String searchText) {
        new GoogleSearchPage().enterSearchText(searchText)
                .clickSearchButton();
    }

    /**
     * Asserts that the Google Calculator component is displayed.
     */
    @Then("^the Google Calculator component is displayed$")
    public void theGoogleCalculatorComponentIsDisplayed() {
        String errorMessage = "Google Calculator should be displayed but is not!";
        assertTrue(errorMessage, new GoogleSearchResultsPage().getCalculatorComponent().isDisplayed());
    }

    /**
     * Asserts that the Google Calculator result is equal to the expected result.
     *
     * @param expectedCalculationResult The expected calculation result.
     */
    @Then("^the result on Google Calculator is '(.*)'$")
    public void theResultOnGoogleCalendar(String expectedCalculationResult) {
        String actualCalculationResult = new GoogleSearchResultsPage().getCalculatorResult();
        String errorMessage = "Expected a Google Calculator result of " + expectedCalculationResult + " but got " + actualCalculationResult;
        assertEquals(errorMessage, expectedCalculationResult, actualCalculationResult);
    }

}