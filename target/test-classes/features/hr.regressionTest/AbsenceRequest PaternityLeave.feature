#Author: Harsha

Feature: Create a new paternity leave request as an employee and approve the same as LM
  Scenario Outline:Create paternity leave request as a Full/Part Time employee
    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>" "<role>"
    Then the dashboard is displayed
#    When i go to Landing Page
    And I Click on paternity Leave Request Section in landing page
    And I enter all the  leave details in paternity leave window
    |duedate|
    |45|
    And Clicks on Submit Button
    Then paternity Leave request should be created

    Examples:
      |user|password|role|
      |MittalJI |MittalJI |Employee|

  Scenario Outline: Approve paternity leave request created by employee

    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>" "<role>"
    Then the dashboard is displayed
    #When i go to Landing Page
    And click on Approve Absence Request Section
    And Select the absence request created by employee
      |user         | Type|
      |Mittal JI|Paternity Requests|
    And I Click on the Access Request button
    And Approve the request using approve button
    Then the request will be approved
    And I enter the actual birth date
    |adob|
    |55|
    And I upload proof of paternity document
    And I click on the Save request
    Then the request will be saved with latest updates


    Examples:
      |user| password |role|
      | AlanPeters| AlanPeters | Lead GP |
