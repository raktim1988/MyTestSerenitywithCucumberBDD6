$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/TestAssignment.feature");
formatter.feature({
  "line": 1,
  "name": "ADIDAS QA ASSIGNMENT",
  "description": "Use the Feature file to complete the Assignment for Adidas QA test",
  "id": "adidas-qa-assignment",
  "keyword": "Feature"
});
formatter.before({
  "duration": 1726724200,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Product Shopping-Adding item to Bag",
  "description": "",
  "id": "adidas-qa-assignment;product-shopping-adding-item-to-bag",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "User is navigated to Adidas webpage",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Click on the running link",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "User Clicks on the first product",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "User is navigated to Product Page",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "User Clicks on the Shoe Size",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "User Adds the item to the Bag",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "Customers Bag is properly populated",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "Click to check the Your Bag page",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "Customer checks out",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "Verify if Customer is on Delivery page",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "Customer selects From A Collection Point",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "Enter location as \"London\"",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "Verify the correct collection points is selected",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition.user_is_navigated_to_Adidas_webpage()"
});
formatter.result({
  "duration": 6496856900,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.click_on_the_running_link()"
});
formatter.result({
  "duration": 3370088100,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.user_Clicks_on_the_first_product()"
});
formatter.result({
  "duration": 1556448300,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.user_is_navigated_to_Product_Page()"
});
formatter.result({
  "duration": 1982570000,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.user_Clicks_on_the_Shoe_Size()"
});
formatter.result({
  "duration": 161100900,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.user_Adds_the_item_to_the_Bag()"
});
formatter.result({
  "duration": 154395300,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.bag_is_properly_populated()"
});
formatter.result({
  "duration": 2259439600,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.click_to_check_the_Your_Bag_page()"
});
formatter.result({
  "duration": 1210122200,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.customer_checks_out()"
});
formatter.result({
  "duration": 231958800,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.verify_if_Customer_is_on_Delivery_page()"
});
formatter.result({
  "duration": 992126000,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.customer_selects_From_A_Collection_Point()"
});
formatter.result({
  "duration": 243043400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "London",
      "offset": 19
    }
  ],
  "location": "StepDefinition.enter_location_as(String)"
});
formatter.result({
  "duration": 407865100,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.verify_the_correct_collection_points_is_selected()"
});
formatter.result({
  "duration": 2914151700,
  "status": "passed"
});
formatter.write("");
formatter.after({
  "duration": 1542895500,
  "status": "passed"
});
});