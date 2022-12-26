@run
Feature: Register in the Lambdatest Playground page

  @RegisterSuccesfully
  Scenario: As a user,  I can register into the Lambdatest PLayground page
    Given I am on the register page of Lambdatest Playground
    When I type valid personal details
    Then I should see a register account success message