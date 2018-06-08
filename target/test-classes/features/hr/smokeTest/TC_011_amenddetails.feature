#Author: Aditi Seth
#Created date:06-06-2018
#Last Updated date:06-06-2018

Feature: Amend Details View 

Scenario: Requesting Amending details view 

Given that any <Line Manager> logs in
|Line Manager|
|Lead GP|
|Finance Director|
|HR Director|
|Advanced Nurse Practitioner|
When the manager opens the team view 
And edits the selected applicant
And opens Managers window of employee
And opens change employee details 
Then the request page will open up
And user can choose the <Reason for Change>
|Reason for Change|
|Change in contract type|
|Change in fixed term end date|
|Change in part time hours|
|Change in salary point|
|Full time to part time|
|Part time to full time|
And Update the request as required 
And hit save 
Then the request will be sent for approval

Scenario: Approving through contractual changes

Given that the COO logs in 
When he opens the contractual change window through menu
And clicks on the request to edit
And changes the <status>
|Status|
|10_Accepted|
|20_Rejected|
Then the changes should be reflected in Emloyee view for admin window