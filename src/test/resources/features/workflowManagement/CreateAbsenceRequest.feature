#Author: Harshaverdhan G
# Created date:11-03-2020
#Last Updated date:11-03-2020
@smokeWFM
Feature: Create a New absence Request for CaseManagement Analyst
  Scenario Outline: Create absence Reqeust as a Lead Analyst
    Given I am in login Page
    When I login to IDempiere with "<user>" "<password>"
    Then the Landing page is displayed
    When I Click on Absence Detail Section in landing page
    And Clicks on New Button in View User Absence window
    And I enter all the absence details
      |Analyst|AbsenceType|Description|StartDate|EndDate|PartialDay|
      |   || |                                  |       ||
    And Clicks on Save Button
    Then New absence request should be created
    Examples:
      |user| password|
      |smorga26| smorga26|