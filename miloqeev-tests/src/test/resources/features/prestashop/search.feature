@search
Feature: Product Search

  Scenario: Search of existing product
    Given User opens browser
    When User searches for existing product
    Then Product should appear

  Scenario: Search of non existing product
    Given User opens another browser
    When User searches for non existing product
    Then Product should not appear
