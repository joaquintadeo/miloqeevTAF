@read
Feature: Read User

  Scenario: Read User
    Given User sends get request to read user
    Then User should see all users
