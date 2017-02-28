$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("myFeatures.feature");
formatter.feature({
  "line": 1,
  "name": "Ebay stranica odabiranje mobitela",
  "description": "",
  "id": "ebay-stranica-odabiranje-mobitela",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Search category on ebay and selecting lowest apple phone from Canada",
  "description": "",
  "id": "ebay-stranica-odabiranje-mobitela;search-category-on-ebay-and-selecting-lowest-apple-phone-from-canada",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I want to go to ebay page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I click on All Categories dropdown ,select product and I want to search for it",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "we validate that we are on a rigt page and click on link for Cell phone and smartphone",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "we select brand apple",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "validate that we are on right tab",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "we are on apple page select by sorting higest price from first page",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "find lowest price from Canada",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "validate that we are on right page",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.OpenEbayPage()"
});
formatter.result({
  "duration": 7072764358,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.SearchForProductInAllCategoriesDropdown()"
});
formatter.result({
  "duration": 4532345443,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.titleValidationAndSelectingCellphone()"
});
formatter.result({
  "duration": 3004541229,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.SelectingBrand()"
});
formatter.result({
  "duration": 1564296417,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.validateRightTab()"
});
formatter.result({
  "duration": 42596690,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.SelectHighestPrice()"
});
formatter.result({
  "duration": 172925425,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.find_lowest_price_from_Canada()"
});
formatter.result({
  "duration": 13322780852,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.WeAreOnRightPage()"
});
formatter.result({
  "duration": 1622216744,
  "status": "passed"
});
});