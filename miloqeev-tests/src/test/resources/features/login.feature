@Login
Feature: Testing Login Page

  Scenario: Login With Valid Credentials
    Given User navigates to login page
    When User enters valid credentials
    Then User should see success message

  Scenario: Login With Invalid Credentials
    Given User navigates to login page
    When User enters invalid credentials
    Then User should see failure message