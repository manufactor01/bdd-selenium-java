@run
Feature: Login

  @Login
  Scenario Outline: Scenario Outline: As a user <username>, I can log into the member's area

    Given I am on the login page
    When I login with <username> and <password>
    Then I should see a flash message saying <message>

    Examples:
      | username | password             | message                        |
      | tomsmith | SuperSecretPassword! | You logged into a secure area! |
      | foobar   | barfoo               | Your username is invalid!      |
      | prueba   | pruebacontra         | Mensaje falso                  |