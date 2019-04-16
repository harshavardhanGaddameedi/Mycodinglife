#Author: Harsha

Feature: Create a new adoption leave request as an employee and approve the same as LM
  Scenario Outline:Create adoption leave request as a Full/Part Time employee
    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>" "<role>"
    Then the dashboard is displayed
    When i go to Landing Page
    And I Click on adoption Leave Request Section in landing page
    And I enter all the  leave details in Adoption leave window
    |DateofPlacement|StartDate|EndDate|
    |0|1|Whole Day  |Whole Day|
    And Clicks on Submit Button
    Then adoption Leave request should be created

    Examples:
      |user|password|role|
      |CyrusMathew |CyrusMathew |Employee|

  Scenario Outline: Approve adoption leave request created by employee

    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>" "<role>"
    Then the dashboard is displayed
    When i go to Landing Page
    And click on Approve Absence Request Section
    And Select the absence request created by employee
      |user         | Type|
      |Cyrus Mathew|Annual Leave Requests|
    And I Click on the Access Request button
    And Approve the request using approve button
    Then the request will be approved

    Examples:
      |user| password |role|
      | AlanPeters| AlanPeters | Lead GP |