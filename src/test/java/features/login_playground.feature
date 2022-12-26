@run
Feature: login in the Lambdatest Playground page

  @LogInPlayground
  Scenario Outline: As a user,  I can log into the member's area
    Given I am on the login page of Lambdatest Playground
    When I type <email> as email and <password> as password
    Then I should see my account dashboard

    Examples:
    |email|password|
    |selenium@testdata.com|Colombia+2022|
    |jared.graham@hotmail.com |htgrxu5m2y                 |