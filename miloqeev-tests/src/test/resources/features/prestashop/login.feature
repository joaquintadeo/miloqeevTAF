@login
Feature: User Login

  Scenario: Login with valid credentials
    Given User navigates to url scenario 1
    When User attempts to login with valid credentials
    Then Login should be successful

  Scenario: Login with invalid credentials
    Given User navigates to url scenario 2
    When User attempts to login with invalid credentials
    Then Login should be unsuccessful
