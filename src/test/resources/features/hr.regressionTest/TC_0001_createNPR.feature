#Author: Sucharitha Revanuru
#Created date:01-06-2018
#Last Updated date:03-05-2018
Feature: Create New Position Request, Authorize NPR
Scenario Outline:Creation of New Position Request for Clinical Pharmacist
Given I am in login Page
And I login to IDempiere with "<user>" "<password>"
And I click on 'New Position Request'
And I enter all the New Position Request Details
| Field          | Value|
|Business case| New Position|
 And I click on Save Button 
 And I enter the following Details 
| Field          | Value|
|Position Template| Clinical Pharmacist|
And I click on Attachment icon on the Tool bar 
And I attach the Job Description of "Clinical Pharmacist"
And I click on Tick mark of the Attachment Window
Then the Job Description is attached. 
And I change the status to "Pending Approval "
And I click on the Save Button 
Then the New Position Request is saved.      
Examples:
|user| password |
| HRBP1| HRBP1|  
