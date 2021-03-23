$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/Demo.feature");
formatter.feature({
  "line": 1,
  "name": "Title of your feature",
  "description": "I want to use this template for my feature file",
  "id": "title-of-your-feature",
  "keyword": "Feature"
});
formatter.before({
  "duration": 2671683824,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Title of your scenario",
  "description": "",
  "id": "title-of-your-feature;title-of-your-scenario",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "User is navigated to Addidas webpage",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefination.user_is_navigated_to_Addidas_webpage()"
});
formatter.result({
  "duration": 7478068137,
  "status": "passed"
});
formatter.write("");
formatter.after({
  "duration": 4231351102,
  "status": "passed"
});
});