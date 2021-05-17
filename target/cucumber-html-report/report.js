$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Login.feature");
formatter.feature({
  "line": 1,
  "name": "Testing Login validation using scenario Outline",
  "description": "",
  "id": "testing-login-validation-using-scenario-outline",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": "LoginValidation",
  "description": "",
  "id": "testing-login-validation-using-scenario-outline;loginvalidation",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "User is on the desired page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "User clicks on the \"Form Authentication\" link",
  "keyword": "Then "
});
formatter.step({
  "line": 6,
  "name": "Provide \"\u003cusername\u003e\" and \"\u003cpassword\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "Verify successful login",
  "keyword": "Then "
});
formatter.examples({
  "line": 8,
  "name": "",
  "description": "",
  "id": "testing-login-validation-using-scenario-outline;loginvalidation;",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ],
      "line": 9,
      "id": "testing-login-validation-using-scenario-outline;loginvalidation;;1"
    },
    {
      "cells": [
        "tomsmith",
        "SuperSecretPassword!"
      ],
      "line": 10,
      "id": "testing-login-validation-using-scenario-outline;loginvalidation;;2"
    },
    {
      "cells": [
        "tomsmith",
        "testfail"
      ],
      "line": 11,
      "id": "testing-login-validation-using-scenario-outline;loginvalidation;;3"
    },
    {
      "cells": [
        "test",
        "test"
      ],
      "line": 12,
      "id": "testing-login-validation-using-scenario-outline;loginvalidation;;4"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 3671308900,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "LoginValidation",
  "description": "",
  "id": "testing-login-validation-using-scenario-outline;loginvalidation;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "User is on the desired page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "User clicks on the \"Form Authentication\" link",
  "keyword": "Then "
});
formatter.step({
  "line": 6,
  "name": "Provide \"tomsmith\" and \"SuperSecretPassword!\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "Verify successful login",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.user_is_on_the_desired_page()"
});
formatter.result({
  "duration": 4252292900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Form Authentication",
      "offset": 20
    }
  ],
  "location": "StepDefinition.user_clicks_on_the_link(String)"
});
formatter.result({
  "duration": 943386200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "tomsmith",
      "offset": 9
    },
    {
      "val": "SuperSecretPassword!",
      "offset": 24
    }
  ],
  "location": "StepDefinition.provide_and(String,String)"
});
formatter.result({
  "duration": 1889489200,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.verify_successful_login()"
});
formatter.result({
  "duration": 429276000,
  "status": "passed"
});
formatter.write("");
formatter.after({
  "duration": 3430946000,
  "status": "passed"
});
formatter.before({
  "duration": 2247768600,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "LoginValidation",
  "description": "",
  "id": "testing-login-validation-using-scenario-outline;loginvalidation;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "User is on the desired page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "User clicks on the \"Form Authentication\" link",
  "keyword": "Then "
});
formatter.step({
  "line": 6,
  "name": "Provide \"tomsmith\" and \"testfail\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "Verify successful login",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.user_is_on_the_desired_page()"
});
formatter.result({
  "duration": 2368435800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Form Authentication",
      "offset": 20
    }
  ],
  "location": "StepDefinition.user_clicks_on_the_link(String)"
});
formatter.result({
  "duration": 1007152000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "tomsmith",
      "offset": 9
    },
    {
      "val": "testfail",
      "offset": 24
    }
  ],
  "location": "StepDefinition.provide_and(String,String)"
});
formatter.result({
  "duration": 2153022100,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.verify_successful_login()"
});
formatter.result({
  "duration": 691673700,
  "status": "passed"
});
formatter.write("");
formatter.after({
  "duration": 2231223600,
  "status": "passed"
});
formatter.before({
  "duration": 2353555000,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "LoginValidation",
  "description": "",
  "id": "testing-login-validation-using-scenario-outline;loginvalidation;;4",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "User is on the desired page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "User clicks on the \"Form Authentication\" link",
  "keyword": "Then "
});
formatter.step({
  "line": 6,
  "name": "Provide \"test\" and \"test\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "Verify successful login",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.user_is_on_the_desired_page()"
});
formatter.result({
  "duration": 3700310900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Form Authentication",
      "offset": 20
    }
  ],
  "location": "StepDefinition.user_clicks_on_the_link(String)"
});
formatter.result({
  "duration": 873471100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "test",
      "offset": 9
    },
    {
      "val": "test",
      "offset": 20
    }
  ],
  "location": "StepDefinition.provide_and(String,String)"
});
formatter.result({
  "duration": 1340044900,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.verify_successful_login()"
});
formatter.result({
  "duration": 612751700,
  "status": "passed"
});
formatter.write("");
formatter.after({
  "duration": 3122368000,
  "status": "passed"
});
formatter.uri("TestAssignment.feature");
formatter.feature({
  "line": 1,
  "name": "ADIDAS QA ASSIGNMENT",
  "description": "Use the Feature file to complete the Assignment for Adidas QA test",
  "id": "adidas-qa-assignment",
  "keyword": "Feature"
});
formatter.before({
  "duration": 2140547600,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Product Shopping-End to end",
  "description": "",
  "id": "adidas-qa-assignment;product-shopping-end-to-end",
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
  "name": "User Adds the item to the Bag 2 times",
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
  "keyword": "And "
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
  "duration": 11749500400,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.click_on_the_running_link()"
});
formatter.result({
  "duration": 8229996500,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.user_Clicks_on_the_first_product()"
});
formatter.result({
  "duration": 4567784700,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.user_is_navigated_to_Product_Page()"
});
formatter.result({
  "duration": 6013848400,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.user_Clicks_on_the_Shoe_Size()"
});
formatter.result({
  "duration": 157054300,
  "error_message": "java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0\r\n\tat java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)\r\n\tat java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)\r\n\tat java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)\r\n\tat java.base/java.util.Objects.checkIndex(Objects.java:372)\r\n\tat java.base/java.util.ArrayList.get(ArrayList.java:459)\r\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.base/java.lang.reflect.Method.invoke(Method.java:566)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementListHandler.invoke(LocatingElementListHandler.java:39)\r\n\tat com.sun.proxy.$Proxy41.get(Unknown Source)\r\n\tat com.automation.test.StepDefinition.user_Clicks_on_the_Shoe_Size(StepDefinition.java:137)\r\n\tat ✽.Then User Clicks on the Shoe Size(TestAssignment.feature:9)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 30
    }
  ],
  "location": "StepDefinition.user_Adds_the_item_to_the_Bag_times(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "StepDefinition.bag_is_properly_populated()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "StepDefinition.click_to_check_the_Your_Bag_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "StepDefinition.customer_checks_out()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "StepDefinition.verify_if_Customer_is_on_Delivery_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "StepDefinition.customer_selects_From_A_Collection_Point()"
});
formatter.result({
  "status": "skipped"
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
  "status": "skipped"
});
formatter.match({
  "location": "StepDefinition.verify_the_correct_collection_points_is_selected()"
});
formatter.result({
  "status": "skipped"
});
formatter.write("cucumber.runtime.ScenarioImpl@5737d116");
formatter.write("failed");
formatter.write("ScreenShot taken for failed step ");
formatter.write("");
formatter.embedding("image/png", "embedded0.png");
formatter.write("");
formatter.after({
  "duration": 4368857700,
  "status": "passed"
});
formatter.uri("TestPOC.feature");
formatter.feature({
  "line": 1,
  "name": "Testing elements for POC",
  "description": "Select deselect item values with multiple selectors",
  "id": "testing-elements-for-poc",
  "keyword": "Feature"
});
formatter.before({
  "duration": 2194252500,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "User is on the desired page",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinition.user_is_on_the_desired_page()"
});
formatter.result({
  "duration": 3873383900,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "Dropdown Selection",
  "description": "",
  "id": "testing-elements-for-poc;dropdown-selection",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "click on the link \"Dropdown\"",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "select dropdown field value",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "pass the value as \"Option 2\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "Dropdown",
      "offset": 19
    }
  ],
  "location": "StepDefinition.click_on_the_link(String)"
});
formatter.result({
  "duration": 559295200,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.select_dropdown_field_value()"
});
formatter.result({
  "duration": 300149800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Option 2",
      "offset": 19
    }
  ],
  "location": "StepDefinition.pass_the_value_as(String)"
});
formatter.result({
  "duration": 183428800,
  "status": "passed"
});
formatter.write("");
formatter.after({
  "duration": 2212014300,
  "status": "passed"
});
formatter.before({
  "duration": 2260796200,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "User is on the desired page",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinition.user_is_on_the_desired_page()"
});
formatter.result({
  "duration": 3778126000,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Checkbox Selection",
  "description": "",
  "id": "testing-elements-for-poc;checkbox-selection",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 13,
  "name": "click on the link \"Checkboxes\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Checkboxes",
      "offset": 19
    }
  ],
  "location": "StepDefinition.click_on_the_link(String)"
});
formatter.result({
  "duration": 744988900,
  "status": "passed"
});
formatter.write("");
formatter.after({
  "duration": 2150774500,
  "status": "passed"
});
formatter.before({
  "duration": 2017144900,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "User is on the desired page",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinition.user_is_on_the_desired_page()"
});
formatter.result({
  "duration": 3769826800,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 15,
      "value": "##Add delete button"
    }
  ],
  "line": 17,
  "name": "AddDelete Button",
  "description": "",
  "id": "testing-elements-for-poc;adddelete-button",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 18,
  "name": "click on the link \"Add/Remove Elements\"",
  "keyword": "Then "
});
formatter.step({
  "line": 19,
  "name": "Add Element 3 times",
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "Check the Delete button count",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "Add/Remove Elements",
      "offset": 19
    }
  ],
  "location": "StepDefinition.click_on_the_link(String)"
});
formatter.result({
  "duration": 568323900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 12
    }
  ],
  "location": "StepDefinition.add_Element_times(int)"
});
formatter.result({
  "duration": 296312400,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.check_the_Delete_button_count()"
});
formatter.result({
  "duration": 408199500,
  "status": "passed"
});
formatter.write("");
formatter.after({
  "duration": 1796673700,
  "status": "passed"
});
});