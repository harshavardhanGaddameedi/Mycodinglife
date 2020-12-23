#Author: Harshaverdhan G
# Created date:21-01-2020
#Last Updated date:18-02-2020
@smokeWFM
Feature: Create a New Adhoc Case Management Request
 Scenario Outline: Create CaseMangement Request as a LeadAnalst
    Given I am in login Page
    When I login to IDempiere with "<user>" "<password>"
    Then the Landing page is displayed
    When I Click on New Adhoc and pending Request Section in landing page
    And Clicks on New Button in View CM request Window
    And I enter all the request details in the Create Request popup
      |RequesterName|Organisation|TelNo|DateAndTime|EmailSubject|MailBoxRequestFrom|Description|RType|LeadSME|SSME|RequestCompletionDate|
      |TestHarsha   |04D-NHS Lincolnshire West CCG|2323232323 | 0  |  ViaAutomatedScript| Lincs AQP - ohs.LincsAQP@nhs.net|creating a new request |Data management development|Ramesh Prema|Sian Morgan| 2|
    And Clicks on Save Button
    Then New Adhoc request should be created
    Examples:
      |user| password|
      |smorga26| smorga26|

  Scenario Outline: Accept CaseMangement Request by approval user
    Given I am in login Page
    When I login to IDempiere with "<user>" "<password>"
    Then the Landing page is displayed
    And I Click on New Adhoc and pending Request Section in landing page
    When I Accept the Request created by LeadAnalyst.
    Then I should see the request accepted message
    And I Click on OK button
    And I Navigate back to landing page
    And I navigate to Current Request window
    Then I should see the accepted request
    Examples:
    |user|password|
    |Ramesh Prema|Ramesh Prema|












