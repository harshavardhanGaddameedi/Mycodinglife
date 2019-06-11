#Author: Aditi Seth
Feature: Raise a Contractual Change request for changing an employee from Full time to Part time
  Scenario Outline: Raise a request to change employee from full time to part time
    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>" "<role>"
    Then the dashboard is displayed
    When I Click on new Team View Option from Menu
    And i click on the employee for whom i want to do the contract change
      |name|
      |Sebastian Sims|
    And select Update Employee Details
    And  on the Make a change to contract page i update the full time to part time details as
      |ReasonForChange|EffectiveDate|Comments|Multiplier Hours/Week|
      |Full time to part time|0|Required please approve|0.3|
    Then i Submit the request
    And i click on ok
    Examples:
      |user|password|role|
      |ElaineRichards |ElaineRichards |Finance Director|

  Scenario Outline: Approve the contract change for change in contract type
    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>" "<role>"
    And i go to Approve Contractual Changes
    And search for the fulltime to part time  request
    Then i approve or reject the request for full time to part time
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
      |Sebastian|Sims|
    And Open the Job Information Tab
    Then i verify the Full Time or Part time Value
      |Full/Part Time|
      |Part Time|
    Examples:
      |user|password|role|
      |AditiRevanuru|AditiRevanuru|HR Administrator|