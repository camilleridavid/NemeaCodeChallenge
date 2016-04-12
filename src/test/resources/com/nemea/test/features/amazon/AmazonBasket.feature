@nemea @amazon @basket
Feature: Amazon Basket

  Scenario: Amazon UK search and basket functionality
    Given I navigate to 'Amazon'
    When I search for 'Notepad'
    Then a number of results are returned
      # I had to choose the 3rd result rather than the 2nd, because the 2nd was a free app and it had no 'Add to Basket' button
    When I select the 3rd result
    And I add the current item to the Basket
    Then a message confirming item is added to Basket is shown
    When I access the Basket
    Then the Basket contains '1' items
    And the current item is displayed inside the Basket