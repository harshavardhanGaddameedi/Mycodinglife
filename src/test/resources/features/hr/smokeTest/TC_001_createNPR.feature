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
  And I change the status to "Accepted"
  And I click on Save Button
  Then the New Position Request is saved.
  Examples:
   |user | password |
   |HRDirector|HRDirector|

# C:\GP_Empower_Automation1\src\test\java\co\uk\optum\stepDefinitions\hr\smokeTest