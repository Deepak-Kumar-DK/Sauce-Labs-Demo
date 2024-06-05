@FeatureTest
Feature: Automated Test Suite for Sauce labs demo website
  Description: The purpose of this feature to test Sauce labs demo website.

  @ScenarioTest
  Scenario Outline: Customer flow of selecting 3 items and completing the checkout flow
    Given User navigate to login page
    Then Enter the Credentials "<UserName>" and "<Password>"
    And User click the login button and moves to inventory page
    Then User add the inventory items "<Item_1>;<Item_2>;<Item_3>" to shopping cart and verify item added
    And User click the shopping cart icon and moves to cart page
    Then User moves to checkout from shopping cart
    And Enter "<Customer>" personal details on Checkout: Your Information page
    And User click the continue button and moves to Checkout: Overview page
    Then Verify items "<Item_1>;<Item_2>;<Item_3>" in Checkout: Overview page
    And User click the finish button and moves to Checkout: Complete! page
    And User click the back Home button and moves to inventory page

    Examples:
      | UserName      | Password     | Item_1              | Item_2                | Item_3                  | Customer |
      | standard_user | secret_sauce | Sauce Labs Backpack | Sauce Labs Bike Light | Sauce Labs Bolt T-Shirt | Deepak   |