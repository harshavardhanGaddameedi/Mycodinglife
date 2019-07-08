#Author: Harsha

Feature: Create a new maternity leave request as an employee and approve the same as LM
  Scenario Outline:Create maternity leave request as a Full/Part Time employee
    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>" "<role>"
    Then the dashboard is displayed
#    When i go to Landing Page
    And I Click on maternity Leave Request Section in landing page
    And I enter all the  leave details in maternity leave window
    |ewoc|
    |60|
    And Clicks on Submit Button
    Then maternity Leave request should be created

    Examples:
      |user|password|role|
      |MaryPoppins |MaryPoppins |Employee|

  Scenario Outline: Approve maternity leave request created by employee

    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>" "<role>"
    Then the dashboard is displayed
    When i go to Landing Page
    And click on Approve Absence Request Section
    And Select the absence request created by employee
      |user         | Type|
      |Mary Poppins|Maternity Requests|
    And I Click on the Access Request button
    And Approve the request using approve button
    Then the request will be approved
    And I enter the actual birth date
    |adob|
    |55|
    And I upload proof of maternity document
    And I click on the Save request
    Then the request will be saved with latest updates


    Examples:
      |user| password |role|
      | AlanPeters| AlanPeters | Lead GP |
