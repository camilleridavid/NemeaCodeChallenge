@nemea @amazon @todaysDeals
Feature: Amazon Today's Deal

  Scenario: Amazon UK search and basket functionality
    Given I navigate to 'Amazon'
    When I select Today's Deals
    And I select Terms and Conditions
    Then I print out all points from "Deal of the Day and Deal of the Week Terms & Conditions"