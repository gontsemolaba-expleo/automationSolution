Feature: Buy two products online
  Scenario: User wants to buy two items
    Given User is on the Swaglab browser
    And User logs in with valid username and password
    When two items are successfully added to cart
    And personal details successfully added
    Then thank you page is displayed