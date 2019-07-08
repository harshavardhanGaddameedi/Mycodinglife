#Author: Harsha

Feature: Create a new overtime request as an employee and approve the same as LM
  Scenario Outline: Create over time request as an employee.
    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>" "<role>"
    When I click on log My Over time section
    And I enter all the Over time details
    |Date|Hours|
    | -1   |   2  |
    And I Click on Submit  Button
    Then Overtime Request will be created

    Examples:
      |user|password|role|
      |SRHyderabad|SRHyderabad|Employee|

  Scenario Outline: Approve Overtime request created by employee

    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>" "<role>"
    And I click on Approve Overtime Section
    And I Select the over time request created by employee and approve
    |Date|UserName|
    |  -1  |SR Hyderabad       |

    Examples:
      |user| password |role|
      | AlanPeters| AlanPeters | Lead GP |
