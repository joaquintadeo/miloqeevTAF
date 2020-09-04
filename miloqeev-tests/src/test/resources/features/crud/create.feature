@create
Feature: Create User

  Scenario: Create User
    Given User sends post request to create user
    Then New user should be created
