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

    Scenario Outline: : Edit Created Absence Request.
      Given a User created the absence request for any user
      When I login to IDempiere with "<user>" "<password>"
      Then the Landing page is displayed
      When I Click on Absence Detail Section in landing page
      And Clicks on New Button in View User Absence window
      Then I should be able to see the absence request created
      And I should be able to Edit and update the  absence Details
      |AbsenceType|StartDate|EndDate|PartialDays|
      |           |         |       |           |

      Examples:
        |user| password|
        |smorga26| smorga26|

      Scenario: Delete Absence Request
        Given I have a  absence Request
        When I Navigate to Absence Detail window
        And I Verify the absence Request
        Then I should be Able to delete the Reqeust
        When I click on Delete button
        Then Absence Record should be deleted




