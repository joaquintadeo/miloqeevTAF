@checkout
Feature: User Checkout

  Scenario: Checkout as a user
    Given User is logged in
    When User attempts checkout
    Then Checkout should be successful

  Scenario: Checkout as a guest
    Given User navigates to prestashop
    When User attempts guest checkout
    Then Checkout should be successful
