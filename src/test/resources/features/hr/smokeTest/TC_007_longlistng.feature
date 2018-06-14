#Author: Aditi Seth
#Created date:30-05-2018
#Last Updated date:30-05-2018

Feature: Longlisting,shortlisting and Interview of the candidates
Scenario: Compare the applicants on the basis of longlisting, shortlisting and Interviews

Given the recruitment request has the status "55_Vacancy in Long Listing"
And the applicant tabs has the applicants loaded through XML
When the User clicks on the Menu button
And Selects 'Human resource & Payroll'
And selects 'Human resource'
And selects 'Requests'
And selects 'LongListing Criteria'
Then the Longlisting page opens up
And click on the applicant tab
And clicks on the detail record
And clicks on the longlisting criteria tab
And Updates the Longlisting criteria for a particular applicant
And updates the  longlisting criteria for all the required applicants
And the User Updates the applicants to be carried forward to shortlisting stage 
And changes the status in RR to "60_Vacancy in Short Listing"
When the User clicks on the Menu button
And Selects 'Human resource & Payroll'
And selects 'Human resource'
And selects 'Requests'
And selects 'Short Listing Criteria'
Then the Shortlisting page opens up
And user clicks on the applicant tab
And clicks on the detail record
And clicks on the shortlisting criteria tab
And Updates the Shortlisting criteria for a particular applicant
And updates the  shortlisting criteria for all the required applicants
And the User Updates the applicants to be carried forward to next stage
And changes the status in RR to "70_Vacancy in Assessment"
When the user opens up vacancy assessmnt tab in the detail record
And clicks on the edit button of "Max Date Online Assessment"
And enters the Max Date Online Assessment
And hits Save 
And opens the applicant tab again 
And Updates the Test Schedule tab for each applicant
Then the applicants to be taken forward to next stage are selected 
When the User changes the statud of RR to "71_Interviews"
And hits save 
And opens the detail record
And the user goes to Panel Interviewer selection in Menu
Then the Panel Interviewer page opens up 
When the user Opens the Panel interviewer tab on  Panel interviewer tab 
And sets the initial and Final date of assessment 
And hits save 
Then the Member tab in the detail record secin would get enabled with the interviewer as LeadGP1
 








