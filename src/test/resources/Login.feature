Feature: Testing Login validation using scenario Outline

  Scenario Outline: LoginValidation
    Given User is on the desired page
    Then User clicks on the "Form Authentication" link
    And Provide "<username>" and "<password>"
    Then Verify successful login
    Examples:
      | username | password             |
      | tomsmith | SuperSecretPassword! |
      | tomsmith | testfail             |
      | test     | test                 |