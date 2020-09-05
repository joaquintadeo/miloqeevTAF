@update
Feature: Update User

  Scenario: Update User
    Given User sends put request to update user
    Then User should be updated
