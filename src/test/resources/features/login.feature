Feature: Login Feature

  Scenario Outline: Valid and invalid login attempts
    Given I am on the login page
    When I login with username "<username>" and password "<password>"
    Then I should see the message "<message>"

    Examples:
      | username | password   | message              |
      | student  | Password123| Logged In Successfully |
      | wrong    | wrong123   | Your username is invalid! |