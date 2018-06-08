#Author: Aditi Seth
#Created date:30-05-2018
#Last Updated date:30-05-2018

Feature: Interviews 
Scenario: Interviews of candidates

Given that RA logs in for the same RR
When the User changes the status of RR to "71_Interviews"
And hits save 
And opens the detail record
And the user goes to Panel Interviewer selection in Menu
Then the Panel Interviewer page opens up 
When the user Opens the Panel interviewer tab on  Panel interviewer tab 
And sets the initial and Final date of assessment 
And hits save 
Then the Member tab in the detail record secin would get enabled with the interviewer as LeadGP1
 