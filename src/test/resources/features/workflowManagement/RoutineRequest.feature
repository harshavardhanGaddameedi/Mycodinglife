Feature: Create a New Routine Case Management Request

  Scenario Outline: Create Routine CaseMangement Request as a LeadAnalst.

    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>"
    Then the Landing page is displayed
    And I Click on Create Routine Request Section in landing page
    And I enter all the request details in the Create Request popup
      |Project|SelectReport|Description|ReportName|Client|RequestType|DataSource|LeadSME|SecSME|Process|Frquency||StartDate|DeliveryDate|
      ||                         |           |            |                  |           ||     |       |          ||       |    |                     |
    And Clicks on Save Button
    Then New Routine request should be created

    Examples:
      |user|password|
      |smorga26|smorga26|

  Scenario: : Add a new task for the routine request
    Given a New routine Request is created
    And I Click on Add Task button to create a new sub task
    And I Enter all the sub task details in popup window
      |Description|NetworkLoc |RType|RStatus|Client|DataSource|LSME|SSME|
      ||||||                                                  |    |    |
    And I click on Save button
    Then I should see the subtask created for the routine request

  Scenario: Run Routine Request process to activate the submitted request.
    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>"
    And I click on Apply standard report on workflow in the menu section
    And I enter the date for which i wanted to run the report
    And I click on Start button
    Then Process should run successfully

    Scenario: Verify that Routine request is reflected in Pending Request window after running the process
      Given I am in login Page
      And I login to IDempiere with "<user>" "<password>"
      Then the Landing page is displayed
      And I Click on New and Pendign Request Section in landing page
      Then I should see the routine request

      Examples:
      |user|password|
      |smorga26|smorga26|



