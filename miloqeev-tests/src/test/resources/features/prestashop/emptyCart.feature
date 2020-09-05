@empty
Feature: Empty cart

  Scenario: Empty cart with one product
    Given User adds product
    When User attempts to empty cart
    Then Cart should be empty

  Scenario: Empty cart with multiple products
    Given User adds multiple products
    When User attempts to empty cart
    Then Cart should be empty
