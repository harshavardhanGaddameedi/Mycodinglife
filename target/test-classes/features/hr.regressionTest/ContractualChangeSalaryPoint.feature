#Author: Aditi Seth
Feature: Raise a contract change for changing the salary point, Authorize contract change
Scenario Outline: Raise a Change in Salary Point contract change 
Given I am in login Page
And I login to IDempiere with "<user>" "<password>" "<role>"
Then the dashboard is displayed
When I Click Team View Option from Menu
And i click on the employee for whom i want the salary change
  |PositionName|EmpName|
  |Advanced Nurse Practitioner|Quentin  West|
And select Change Employee Details
And  on the Amend Details view page i select the following fields as 
  |ReasonForChange|EffectiveDate|RoleBandSalaryPoint|
  |Change in salary point|0|67247.00|
And save the request
  Examples:
    |user|password|role|
    |AlanPeters |AlanPeters |Lead GP|

  Scenario Outline: Approve the contract change for change in salary point
    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>" "<role>"
    When i go Contract Changes
    And Search for the contract change request raised
    Then i change Status as required to approve or reject
      |Status|
      |15_Pre-Approved|
    And Changes should be Saved
      |Status|
      |15_Pre-Approved|

    Examples:
      |user| password|role|
      | JohnAllen| JohnAllen|COO|


   
 