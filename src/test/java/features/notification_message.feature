@run
Feature: Notification Message

  Scenario Outline: Visualization of successful message
    Given i am in notification message page
    When I click on button Click Here for <times> times
    Then I am alerted with <message>
    Examples:
      | message                              | times |
      | Action successful                    | 1     |
      | Action unsuccesful, please try again | 2     |