#Author: Harsha

Feature: Create a new shared parental request as an employee and approve the same as LM
  Scenario Outline:Create shared parental leave request as a Full/Part Time employee
    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>" "<role>"
    Then the dashboard is displayed
#    When i go to Landing Page
    And I Click on shared parental Leave Request Section in landing page
    And I enter all the shared parental leave details in Annual leave window
    |StartDate|EndDate|
    |15|25|
    And Clicks on Submit Button
    Then Annual Leave request should be created

    Examples:
      |user|password|role|
      |CyrusMathew |CyrusMathew |Employee|

  Scenario Outline: Approve shared parental leave request created by employee

    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>" "<role>"
    Then the dashboard is displayed
    When i go to Landing Page
    And click on Approve Absence Request Section
    And Select the absence request created by employee
      |user         | Type|
      |Cyrus Mathew|Shared Parental Requests|
    And I Click on the Access Request button
    And Approve the request using approve button
    Then the request will be approved

    Examples:
      |user| password |role|
      | AlanPeters| AlanPeters | Lead GP |
