#Author: Aditi Seth
Feature: Raise a Contractual Change request for change in hours of a part time employee
  Scenario Outline: Raise a request to change employee from full time to part time
    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>" "<role>"
    Then the dashboard is displayed
    When I Click on new Team View Option from Menu
    And i click on the employee for whom i want to do the contract change
      |name|
      |Maggie Campos|
    And select Update Employee Details
    And  on the Make a change to contract page i update the full time to part time details as
      |ReasonForChange|EffectiveDate|Comments|Multiplier Hours/Week|
      |Change in Part Time hours|0|Required please approve|0.8|
    Then i Submit the request
    And i click on ok
    Examples:
      |user|password|role|
      |ElaineRichards|ElaineRichards|Finance Director|

  Scenario Outline: Approve the contract change for change in contract type
    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>" "<role>"
    And i go to Approve Contractual Changes
    And search for the Part time hours  change request
    Then i approve the request
    Examples:
      |user|password|role|
      |JohnAllen |JohnAllen |COO|

  Scenario Outline: To verify the above has been implemented

    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>" "<role>"
    When i search for Check Request Process
    Then on check Request Page i enter effective date and click ok
      |Effective Date|
      |1|
    When i search for employee in Employee view for Admin
      |FirstName|LastName|
      |Maggie|Campos|
    And Open the Job Information Tab
    Then i verify the contractual hours to check hour change is implemented
      |Contractual Hours|
      |30.00|
    Examples:
      |user|password|role|
      |AditiRevanuru|AditiRevanuru|HR Administrator|