@delete
Feature: Delete User

  Scenario: Delete User
    Given User sends request to delete user
    Then User should be deleted
