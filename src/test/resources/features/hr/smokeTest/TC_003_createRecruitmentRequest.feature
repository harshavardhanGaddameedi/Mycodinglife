#Author: Sucharitha
#Created date:06-06-2018
#Last Updated date:06-06-2018
Feature: Create RR from Team View of LeadGP
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
