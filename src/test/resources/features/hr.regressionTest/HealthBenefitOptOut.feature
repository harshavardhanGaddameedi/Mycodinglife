#Author: Aditi Seth
Feature: Raise a request as an employee to change the Health Insurance Benefit Plan
  Scenario Outline: Raise a request to change health insurance benefit
    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>" "<role>"
    When I Click on My Benefits section from landing page
    And i select the benefit from the Benefit Options Dropdown
      |BenefitOption|
      |My Private Health Insurance|
    Then i am redirected to Health Benefits Page
    When i select  the effective date to opt out
      |Effective Date|
      |0|
    Then i hit employee benefits opt out
    Examples:
      |user|password|role|
      |TinaDesai|TinaDesai|Employee|

  Scenario Outline: Verify that the changes are reflected to employee profile
    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>" "<role>"
    When i search for apply Benefit Change Process
    Then on Apply benefit change page i click on OK
    When i search for employee in Employee view for Admin
      |FirstName|LastName|
      |Tina|Desai|
    And Open the Benefit Tab
    Then i verify the health benefit applied
      |Private Health Insurance|
      |Family membership|
    Examples:
      |user|password|role|
      |AditiRevanuru|AditiRevanuru|HR Administrator|