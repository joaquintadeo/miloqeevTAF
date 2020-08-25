@cart
Feature: Add product to cart

  Scenario: From quick view
    Given User finds product on quick view
    When User attempts to add to cart
    Then Product should be added to cart

  Scenario: From full view
    Given User finds product
    When User selects and adds to cart
    Then Product should be added to cart
