@feature1
Feature: Free CRM Login Feature

  Scenario Outline: Free CRM Login Test Scenario
    Given user is already on Login Page
    When title of login page is Free CRM
    Then user enters "<username>" and "<password>"
    Then user gets data from excel file

    Examples:
      | username | password |
      | naveenk  | test@123 |
		