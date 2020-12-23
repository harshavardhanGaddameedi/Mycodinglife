#Author: Aditi Seth
Feature: Raise a request as an employee to change the Pension Scheme
  Scenario Outline: Raise a request to change pension scheme
    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>" "<role>"
    When I Click on My Benefits section from landing page
    And i select the benefit from the Benefit Options Dropdown
    |BenefitOption|
    |My Pension|
    Then i am redirected to Pension Page
    When i select  Pension Benefits as
    |PensionBenefits|Pension Scheme|Pension Scheme Level|Effective Date|
    |Change Pension Scheme|Pension Scheme B|Level 3|0|
    Then i hit Apply Change
    Examples:
      |user|password|role|
      |DeborahFrench|DeborahFrench|Employee|


    Scenario Outline: Verify that the changes are reflected to employee profile
      Given I am in login Page
      And I login to IDempiere with "<user>" "<password>" "<role>"
      When i search for apply Pension Change Process
      Then on Apply pension chnage page i click on OK
      When i search for employee in Employee view for Admin
      |FirstName|LastName|
      |Deborah|French|
      And Open the Benefit Tab
      Then i verify the pension scheme applied
      |Employee Pension|
      |Pension Scheme B|
      Examples:
        |user|password|role|
        |AditiRevanuru|AditiRevanuru|HR Administrator|