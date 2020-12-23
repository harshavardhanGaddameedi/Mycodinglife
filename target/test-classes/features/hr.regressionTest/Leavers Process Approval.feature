#Author: Aditi Seth
@leaver
Feature: Raise a Leavers Request, Authorize Leavers request
Scenario Outline: Raise a Leavers process request
Given I am in login Page
And I login to IDempiere with "<user>" "<password>" "<role>"
Then the dashboard is displayed
When I Click Team View Option from Menu
And i click on the employee for whom i which to raise a leaver request for
  |PositionName|EmpName|
  |Clinical Pharmacist_BA2|Joe Burns|
And select Start leaver process
And  on the leaver request page i fill the reson for leaving and termination date
  |Reason For Leaving|Notice Period|
  |Resignation                  |     30        |
And save the request
Then Leaver Details Should be saved
  Examples:
    |user|password|role|
    |LeadGP1 |LeadGP1 |Lead GP|

Scenario Outline: Approve the leavers process request
Given I am in login Page
And I login to IDempiere with "<user>" "<password>" "<role>"
When i go to Leavers request 
And Search the Employee for which Leaver Request to be approved or denied
  |EmpName|
  |Joe Burns|
Then i change Status as required to approve or reject
|Status|
|2_Accepted|
And I Update the Leaver Checklist and Save Changes
Then Changes should be Saved
  |Status|
  |2_Accepted|

 Examples:
   |user| password|role|
   | HRAdmin| HRAdmin|HR Administrator|
   
 