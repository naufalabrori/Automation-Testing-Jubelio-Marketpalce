@All
Feature: login

  @ValidLogin
  Scenario: Enter valid login details
    Given User in login page
    When User fill email and password
    And User click button login
    Then User in homepage

  @InvalidLogin
  Scenario: Enter invalid email and password
    Given User in login page
    When User fill invalid email and password
    And User click button login
    Then User get error message
