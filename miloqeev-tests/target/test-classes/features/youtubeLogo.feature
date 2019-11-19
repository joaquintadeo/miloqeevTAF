@SecondTest
Feature: YouTube logo validation
  Scenario: YouTube logo should appear on YouTube Web Page
    Given User opens a browser
    When User navigates to YouTube Web Page
    Then User must see YouTube logo
