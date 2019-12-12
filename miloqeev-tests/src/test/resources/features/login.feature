@Login
Feature: Testing Login Page

  Scenario: Login With Valid Credentials
    Given User navigates to login page
    When User enters valid credentials
    And User clicks login button
    Then User should see success message

  Scenario: Login With Invalid Credentials
    Given User navigates to login site
    When User enters invalid credentials
    And User clicks login button
    Then User should see failure message
