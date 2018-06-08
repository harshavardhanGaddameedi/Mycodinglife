#Author: Aditi Seth
#Created date:30-05-2018
#Last Updated date:30-05-2018

Feature: Generate and place advert
Scenario: Login as Line Manager and generate Advert
Given user launches the Idempiere application
When user logs in using the <Username> and <Password>
 |Username|Password| 
 |LeadGP1 |LeadGP1 |
And selects the role as Recruitment Administrator
And hits ok
Then the dashboard of RA is displayed 
And user Clicks on Menu button 
And Selects 'Human resource & Payroll'
And selects 'Human resource'
And selects 'Requests'
And selects 'Recruitment Request'
Then the recruitment request page opens
And user selects and edits the request
When the status of request is chnaged to "30_GenerateAdvert"
And hits save 
Then a file will be downloaded 
When the status of request is changed to '40_Advert' 
And upload the applicant xml 
And hit save 
And change the status to '50_PlaceAdvert'
And hit save 
Then the detail record should have applicants uploaded


 