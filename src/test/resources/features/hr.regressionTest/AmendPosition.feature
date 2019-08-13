#Author: Harsha
Feature: Raise a request as an employee to change the Health Insurance Benefit Plan
  Scenario Outline: Create a request for Amend Position
    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>" "<role>"
    Then the dashboard is displayed
    When I Click on View and Edit Job from landing page
    And Selects the job to be amended
    |PayrollJob|
    |Advanced Nurse Practitioner A|
    And I update the position with below changes
    |Grade|Business Case|EffectiveDate|
    |Band C|updating grade please approve|0|
    And I Click on Create Request Button
    Then a request will be created for amend position

  Examples:
    |user|password|role|
    |PaulAndrews |PaulAndrews |HR Business Partner|

  Scenario Outline: Approve the amend payroll job
    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>" "<role>"
    And i go to Approve Amend Payroll Job
    Then i approve or reject the request for Amend Payroll Job
     |PayrollJob|
     |Advanced Nurse Practitioner A|
    Examples:
      |user|password|role|
      |ElaineRichards |ElaineRichards |Finance Director|

  Scenario Outline: To verify the above has been implemented
    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>" "<role>"
    When i search for Amend Position process
    And i run the process by Clicking OK Button
    Then Process should run successfully
    And i navigate to landing Page and click on view Job
    And I selects the position to be verified
      |PositionName|
      |Advanced Nurse Practitioner A|
    Then i verify the updated details
      |Grade|
      |Band 8|
    Examples:
      |user|password|role|
      |AditiRevanuru|AditiRevanuru|HR Administrator|