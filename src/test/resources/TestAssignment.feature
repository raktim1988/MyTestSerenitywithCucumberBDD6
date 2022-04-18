Feature: ABNAmro QA ASSIGNMENT
  Use the Feature file for ABN-Amro Private Account opening E2E test flow

  Scenario Outline: Abn Amro E2E Private Account Opening
    Given User is navigated to ABNAmro webpage
    When User Selects all required fields
    And User inputs his "<postalCode>" and "<houseNumber>"
    Then Verify "<streetName>" and "<town>" is autopopulated
    When User Clicks on the button
    Then Verify customer details page is opened
    When Customers "<customerName>" inputs all his details and submit
    Then Verify Customer is on the identification page
    When  Customer inputs his "<email>" and "<phoneNumber>" and submit
    Then Verify customer is in the closing page
    When Customer selects all necessary questions and click overview
    Then Verify Customers input details page is displayed
    And Verify Customers values are matched
    ##Not tried the below step considering this is Production data
    When Customer clicks on Apply Now
    Then Customers account should be created
    Examples:
      | postalCode | houseNumber | streetName        | town      | customerName |  | email         | phoneNumber |
      | 1082 PP    | 10          | Gustav Mahlerlaan | Amsterdam | testCustomer |  | test@test.com | 0620794190  |

