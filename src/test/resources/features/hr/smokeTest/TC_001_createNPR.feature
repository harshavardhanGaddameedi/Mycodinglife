#Author: Sucharitha Revanuru
#Created date:01-06-2018
#Last Updated date:03-05-2018
Feature: Create New Position Request, Authorize NPR
 Scenario Outline:Creation of New Position Request for Clinical Pharmacist
  Given I am in login Page
  And I login to IDempiere with "<user>" "<password>"
  And I click on New Position Request
  And I enter all the New Position Request Details
   |Business case|
   |New Position|
  And I click on Save Button
  And I enter the following Details
   |Position Template|
   |Clinical Pharmacist|
  And I click on Attachment icon on the Tool bar
  And I attach the Job Description of Clinical Pharmacist
  And I click on Tick mark of the Attachment Window
#  Then the Job Description is attached
  And I change the status to Pending Approval
  |Status|
  |20_Pending Approval|

  And I click on Save Button
  Then I Should see the New Position Request is saved and sent for approval
  Examples:
   |user| password|
   | HRBP1| HRBP1|

 Scenario Outline: Approve of New Position Request for Clinical Pharmacist
  Given I am in login Page
  And I login to IDempiere with "<user>" "<password>"
  And I click on New Position Request created by HR Business Partner
  And Select NPR and change the status to Accepted
   |Status|
   |40_Accepted|

  And I click on Save Button
  Then the New Position Request is saved
  Examples:
   |user | password |
   |HRDirector|HRDirector|

 Scenario Outline: Login as Line Manager and create RR from Team View
  Given I am in login Page
  And I login to IDempiere with "<user>" "<password>" "<role>"
  Then the dashboard is displayed
#  And user Clicks on Menu button
#  And Selects Human resource & Payroll
#  And selects Human resource
#  And selects Team View
  When I Click Team View Option from Menu
  And select the position which was created
   |Position|
   |Clinical Pharmacist|
  And clicks on the Export Example Button on the right hand side of the Tool Bar of iDempiere
  Then Recruitment Request window opens up
  And fills the Type of Recruitment and Business case
   |Type of Recruitment|Business case|Status|
   |External Advertisement|Test Business Case|15_Approval Requested|
  And fills the Proposed Start Date field
  And I click on Save Button On Recruitment Request Page
  Then the Recruitment Request for the selected position is created awaiting approval
   |Status|
   |15_Approval Requested|
 Examples:
 |user|password|role|
 |LeadGP1 |LeadGP1 |Lead GP|

# C:\GP_Empower_Automation1\src\test\java\co\uk\optum\stepDefinitions\hr\smokeTest

 Scenario Outline: Login as Line Manage's Manager (COO)
#  Given user launches the Idempiere application
#When user logs in using the <Username> and <Password>
  Given I am in login Page
  And I login to IDempiere with "<user>" "<password>" "<role>"
  Then the COO dashboard is displayed
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
  Examples:
   |user |password |role|
   |COO1 |COO1|COO      |