Feature: ADIDAS QA ASSIGNMENT
  Use the Feature file to complete the Assignment for Adidas QA test

  Scenario: Product Shopping-End to end
    Given User is navigated to Adidas webpage
    When Click on the running link
    Then User Clicks on the first product
    And User is navigated to Product Page
    Then User Clicks on the Shoe Size
    And User Adds the item to the Bag 2 times
    When Customers Bag is properly populated
    Then Click to check the Your Bag page
    When Customer checks out
    Then Verify if Customer is on Delivery page
    Then Customer selects From A Collection Point
    And Enter location as "London"
    And Verify the correct collection points is selected

