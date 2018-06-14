#Author:Sucharitha
#Created date:08-06-2018
#Last Updated date:08-06-2018
Feature: Onboarding Request
Scenario: Login as HRAdmin
Given user launches the Idempiere application
When user logs in using the <Username> and <Password>
|Username|Password| 
|HRAdmin |HRAdmin|
And selects the role as 'HRAdministrator'
And hits ok
Then the dashboard of HRAdmin is displayed 
And user Clicks on Menu button 
And Selects 'Human resource & Payroll'
And selects 'Human resource'
And selects 'Requests'
And selects 'Onboarding Request'
Then the 'Onboarding requests'grid view page opens
And user selects and edits the 'Onboarding request'
And user clicks on the 'Detail Record' at the bottom of the window
Then the Applicant Tab opens with Applicant name, Open Payroll Contract Letter Button 
and Open New Starter Checklist Window Button
And User clicks on 'edit Record'
Then the 'Request > Applicant' window opens
And User clicks on 'Open Payroll Contract Letter' button
And Click on Ok button 
Then Contract window opens with all details and Contract Letter Upload button at the bottom
And User click on Contract Letter Upload Button 
And User hits ok 
When User clicks on Attachemnt icon in the Toolbar
Then PayrollContract Letter is generated
And User reviews the details in the letter 
And hits Ok 


