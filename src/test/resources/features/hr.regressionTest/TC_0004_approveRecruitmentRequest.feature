#Author:Sucharitha
#Created date:06-06-2018
#Last Updated date:06-06-2018
Feature: Approve Recruitment Request
Scenario: Login as Line Manage's Manager (COO)
Given user launches the Idempiere application
When user logs in using the <Username> and <Password>
|Username|Password| 
|COO1 |COO1|
And selects the role as 'COO'
And hits ok
Then the dashboard of COO is displayed 
And user Clicks on Menu button 
And Selects 'Human resource & Payroll'
And selects 'Human resource'
And selects 'Requests'
And selects 'Recruitment Request'
Then the recruitment request page opens
And user selects and edits the request
And user fills the 'Comments' field
And the status of request is chnaged to "20_VacancyApproved"
And hits save 
Then the request is saved as approved
