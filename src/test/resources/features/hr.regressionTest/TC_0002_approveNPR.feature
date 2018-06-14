#Author: Sucharitha Revanuru
#Created date:01-06-2018
#Last Updated date:03-06-2018
Feature: Create New Position Request, Authorize NPR
Scenario Outline: Approve of New Position Request for Clinical Pharmacist
Given I am in login Page
And I login to IDempiere with "<user>" "<password>"
And I click on New Position Request created by HR Business Partner
And I change the status to "Accepted"
And I enter the following Details
|Field| Value|
|Comments| Approved|
And I click on Save Button  
Then the New Position Request is saved.      
Examples:
|user | password |
| FinanceDirector1| FinanceDirector1|  
