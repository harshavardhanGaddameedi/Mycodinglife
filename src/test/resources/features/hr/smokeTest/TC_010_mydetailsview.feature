#Author: Aditi Seth
#Created date:30-05-2018
#Last Updated date:30-05-2018

Feature: My Details View
Scenario : Changing the bank details for an employee 

Given the user logs in as applicant 
When the user selects "My Details View" from the Menu
And selects the "Update Bank details" from the kind of update dropdown
And update the bank details 
And Hit save 
Then the request is made
When the HR admin Logs in 
And selects the "Change Personal Data" from the menu
And selects the respective request
And edits it 
And changes the <status> as required
|status|
|10_Accepted|
|20_Reject|
Then the request will be accepted or rejected

Scenario: Changing the name details for an employee
Given the user selects "Updatng my name " 
When the <name details> are Updated with <value set> 
|name details|value set|
|First name  |Andrew   |
|Middle name |Moore    |
|Last name   |Banks    |
And saved 
When the HR admin Logs in 
And selects the "Change Personal Data" from the menu
And selects the respective request
And edits it 
And changes the <status> as required
|status|
|10_Accepted|
|20_Reject|
Then the request will be accepted or rejected

Scenario: Changing the Diversity 
Given the users selects "Update Diversity"
When the user updates "Disability" with any of the <Values>
|Values|
|Yes|
|No|
|I do not wish to disclose whether or not I have a disability|
And changes the "Gender" to any of the <outcome>
|outcome|
|Female|
|Male|
|I do not wish to Disclosed|
And hit save 
Then the Page should be updated with new values 

Scenario: Changing the contact details of the emlployee 
iven the user selects "Update my contact details " 
When the <contact details> are Updated with <valuesets> 
|contact details|valuesets|
|phone          |03338094904   |
|Personal Email Address |Moore@gmail.com    |
And hit save 
Then the Page should be updated with new contact details


 



 

 
