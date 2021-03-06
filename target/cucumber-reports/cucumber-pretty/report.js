$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("login.feature");
formatter.feature({
  "line": 2,
  "name": "Free CRM Login Feature",
  "description": "",
  "id": "free-crm-login-feature",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@feature1"
    }
  ]
});
formatter.scenario({
  "line": 4,
  "name": "Free CRM Login Test Scenario",
  "description": "",
  "id": "free-crm-login-feature;free-crm-login-test-scenario",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "comments": [
    {
      "line": 5,
      "value": "#    Given user is already on Login Page"
    },
    {
      "line": 6,
      "value": "#    When title of login page is Free CRM"
    },
    {
      "line": 7,
      "value": "#    Then user enters \"\u003cusername\u003e\" and \"\u003cpassword\u003e\""
    },
    {
      "line": 8,
      "value": "#    Then user gets data from excel file"
    }
  ],
  "line": 9,
  "name": "Select dropdown",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDefinition.selectdropdown()"
});
formatter.result({
  "duration": 22129709200,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 10,
      "value": "#    Examples:"
    },
    {
      "line": 11,
      "value": "#      | username | password |"
    },
    {
      "line": 12,
      "value": "#      | naveenk  | test@123 |"
    }
  ],
  "line": 14,
  "name": "Rest API End To End",
  "description": "",
  "id": "free-crm-login-feature;rest-api-end-to-end",
  "type": "scenario",
  "keyword": "Scenario"
});
});