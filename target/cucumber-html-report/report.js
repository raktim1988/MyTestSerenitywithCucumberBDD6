$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/TestAssignment.feature");
formatter.feature({
  "line": 1,
  "name": "ADIDAS QA ASSIGNMENT",
  "description": "Use the Feature file to complete the Assignment for Adidas QA test",
  "id": "adidas-qa-assignment",
  "keyword": "Feature"
});
formatter.before({
  "duration": 6204572700,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Product Shopping End to End",
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
  "name": "User Adds the item to the Bag",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "Bag is properly populated",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "Click to check the Your Bag page",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.user_is_navigated_to_Adidas_webpage()"
});
formatter.result({
  "duration": 13271764300,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.click_on_the_running_link()"
});
formatter.result({
  "duration": 5141660100,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.user_Clicks_on_the_first_product()"
});
formatter.result({
  "duration": 4051969400,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.user_is_navigated_to_Product_Page()"
});
formatter.result({
  "duration": 5908637700,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.user_Clicks_on_the_Shoe_Size()"
});
formatter.result({
  "duration": 514200600,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.user_Adds_the_item_to_the_Bag()"
});
formatter.result({
  "duration": 314722500,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.bag_is_properly_populated()"
});
formatter.result({
  "duration": 2667955400,
  "error_message": "java.lang.AssertionError: expected:\u003c1\u003e but was:\u003c[[ChromeDriver: chrome on WINDOWS (e3ec25396b86f8c39f5c2377352614bf)] -\u003e xpath: //div[@class\u003d\u0027info___1Gm7E\u0027]/div[contains(text(), \u0027Quantity:\u0027)]]\u003e\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.failNotEquals(Assert.java:743)\r\n\tat org.junit.Assert.assertEquals(Assert.java:118)\r\n\tat org.junit.Assert.assertEquals(Assert.java:144)\r\n\tat com.automation.test.StepDefinition.bag_is_properly_populated(StepDefinition.java:134)\r\n\tat ✽.When Bag is properly populated(src/test/resources/TestAssignment.feature:11)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "StepDefinition.click_to_check_the_Your_Bag_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.write("cucumber.runtime.ScenarioImpl@302edb74");
formatter.write("failed");
formatter.write("ScreenShot taken for failed step ");
formatter.write("");
formatter.embedding("image/png", "embedded0.png");
formatter.write("");
formatter.after({
  "duration": 2204098700,
  "status": "passed"
});
});