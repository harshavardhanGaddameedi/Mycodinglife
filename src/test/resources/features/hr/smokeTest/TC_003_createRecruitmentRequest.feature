#Author: Sucharitha
#Created date:06-06-2018
#Last Updated date:06-06-2018
Feature: Create RR from Team View of LeadGP
Scenario: Login as Line Manager and create RR from Team View
 Given I am in login Page
 And I login to IDempiere with "<user>" "<password>"
#Given user launches the Idempiere application
#When user logs in using the <Username> and <Password>
|Username|Password|
|LeadGP1 |LeadGP1 |
And selects the role as LeadGP
And hits ok
Then the dashboard of LeadGP is displayed
And user Clicks on Menu button
And Selects 'Human resource & Payroll'
And selects 'Human resource'
And selects 'Team View'
And select the 'Clinical Pharmacist' position which was created
And clicks on the Export Example Button (right arrow) on the right hand side of the Tool Bar of iDempiere
Then Recruitment Request window opens up
And fills the 'Type of Recruitment', 'Business case'
 |Type of Recruitment|Business case|
 |External Advertisement |Test Business Case |


And fills the 'Proposed Start Date' field
And Change Request Status  from "10_Vacancy" to "15_Approval Requested"
 And hits save
Then the Recruitment Request for the 'Clinical Pharmacist' position is created awaiting approval
