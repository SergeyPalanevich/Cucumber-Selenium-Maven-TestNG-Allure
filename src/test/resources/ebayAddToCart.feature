Feature: User add product to cart on Ebay

  Background:
    Given User navigates to Ebay page

  Scenario Outline: user can add product to cart
    When User enter search criteria as "<query>"
    And User click on the Search button
    And User select first product
    And User add the product to cart
    Then Product count in cart should be 1
    Examples:
      | query                |
      | Apple MacBook Pro    |
      | Apple MacBook Air 15 |