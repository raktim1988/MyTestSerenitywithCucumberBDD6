Feature: Testing elements for POC
  Select deselect item values with multiple selectors

  Background:
    Given User is on the desired page

  Scenario:Dropdown Selection
    Then  click on the link "Dropdown"
    Then select dropdown field value
    And pass the value as "Option 2"

  Scenario:Checkbox Selection
    Then  click on the link "Checkboxes"

   ##Add delete button

  Scenario: AddDelete Button
    Then  click on the link "Add/Remove Elements"
    Then Add Element 3 times
    And Check the Delete button count
