#Author: Aditi Seth
Feature: Raise a request as an employee to opt out of existing Pension Scheme
  Scenario Outline: Raise a request to opt out of pension scheme
    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>" "<role>"
    When I Click on My Benefits section from landing page
    And i select the benefit from the Benefit Options Dropdown
      |BenefitOption|
      |My Pension|
    Then i am redirected to Pension Page
    When i opt out of Pension Benefits as
      |PensionBenefits|Effective Date|
      |Opt Out|0|
    Then i hit Opt Out
    Examples:
      |user|password|role|
      |SerenaWilliams|SerenaWilliams|Employee|


  Scenario Outline: Verify that the changes are reflected to employee profile
    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>" "<role>"
    When i search for apply Pension Change Process
    Then on Apply pension chnage page i click on OK
    When i search for employee in Employee view for Admin
      |FirstName|LastName|
      |Serena|Williams|
    And Open the Benefit Tab
    Then i verify the pension scheme applied
      |Employee Pension|
      ||
    Examples:
      |user|password|role|
      |AditiRevanuru|AditiRevanuru|HR Administrator|