#Author: Harsha
Feature: Raise a contract change for changing the location and Authorize contract change
Scenario Outline: Raise a Change in Location contract change
  Given I am in login Page
  And I login to IDempiere with "<user>" "<password>" "<role>"
  Then the dashboard is displayed
  When I Click on new Team View Option from Menu
  And i click on the employee for whom i want to do the contract change
    |name|
    |Mumbai Indians|
  And select Update Employee Details
  And  on the Make a change to contract page i update location details as
    |ReasonForChange|EffectiveDate|Comments|Practice|
    |Location|0|Required please approve|*|
  Then i Submit the request
  And i click on ok
  Examples:
    |user|password|role|
    |AlanPeters |AlanPeters |Lead GP|

  Scenario Outline: Approve the contract change for change in location
    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>" "<role>"
    And i go to Approve Contractual Changes
    Then i approve or reject the request for loction change
    |name|
    |Mumbai Indians|
    Examples:
      |user|password|role|
      |JohnAllen |JohnAllen |COO|
