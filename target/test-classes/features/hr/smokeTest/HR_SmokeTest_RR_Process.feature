#Author: Sucharitha Revanuru
#Created date:01-06-2018
#Last Updated date:03-05-2018
@smokeHR
Feature: Create New Position Request, Authorize NPR
 Scenario Outline:Creation of New Position Request for Clinical Pharmacist
  Given I am in login Page
  And I login to IDempiere with "<user>" "<password>" "<role>"
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
   |user| password|role|
   | HRBP1| HRBP1|HR Business Partner|


 Scenario Outline: Approve of New Position Request for Clinical Pharmacist
  Given I am in login Page
  And I login to IDempiere with "<user>" "<password>" "<role>"
  And I click on New Position Request created by HR Business Partner
  And Select NPR and change the status to Accepted
   |Status|
   |40_Accepted|
  And I click on Save Button
  Then the New Position Request is saved
  Examples:
   |user | password |role|
   |FinanceDirector1|FinanceDirector1|Finance Director|



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

 Scenario Outline: Login as Line Manager's Manager (COO)
  #  Given user launches the Idempiere application
  #When user logs in using the <Username> and <Password>
  Given I am in login Page
  And I login to IDempiere with "<user>" "<password>" "<role>"
  Then the dashboard is displayed
  When I Click Recruitment Request Option from Menu
  Then the recruitment request page opens
  And user searches the request to be approved
  And Select Request and change the status to Accepted by adding comments
   |Status|Comments|
   |20_ Vacancy Approved|Test Comments|
  And I click on Save Button on Recruitment Request Approval Page
  Then the request Should be in Approved State
   |Status|
   |20_ Vacancy Approved|

  Examples:
   |user |password |role|
   |COO1 |COO1|COO|

 Scenario Outline: Login as Line Manager and generate Advert
 #Given user launches the Idempiere application
 #When user logs in using the "<Username>" and "<Password>"
  Given I am in login Page
  And I login to IDempiere with "<user>" "<password>" "<role>"
  Then the dashboard of RA is displayed
  When I Click Recruitment Request Option from Menu on RA Page
  Then the recruitment request page opens
  And user searches the request for Advert has to be created
  Then the recruitment request page opens for editing

  When the status of request is changed to GenerateAdvert
   |Status|
   |30_Generate Advert|
  And I click on Save Button on Recruitment Administrator Page
  Then Status Should be GenerateAdvert

  When the status of request is changed to Advert
   |Status|
   |40_ Advert Placed|

  And I click on Save Button on Recruitment Administrator Page
  Then Status Should be Advert

  When the status of request is changed to PlaceAdvert
   |Status|
   |50_Vacancy Closed|

  And I click on Attachment icon on the Tool bar on Recruitment Administrator Page
  And upload the applicant xml
  And I click on Tick mark of the Attachment Window of Recruitment Admin Page

  And I click on Save Button on Recruitment Administrator Page
  Then the detail record should have applicants uploaded


  Examples:
   |user |password |role|
   |LeadGP1 |LeadGP1|Recruitment Administrator|

 Scenario Outline: Compare the applicants on the basis of longlisting, shortlisting and etc

  Given I am in login Page
  And I login to IDempiere with "<user>" "<password>" "<role>"
  Then the dashboard of RA is displayed
  When I Click Recruitment Request Option from Menu on RA Page
  Then the recruitment request page opens
  And user searches the request for which recruitment has to be continued
  Then the recruitment request page opens for editing
  When the status of request is changed to Vacancy in LongListing
   |Status|
   |55_Vacancy in Long Listing|
  And I click on Save Button on Recruitment Administrator Page
  Then Status Should be LongListing

  And I select Longlisting criteria from Menu
  Then the Longlisting page opens up
  And user searches the request for which longlisting to be done
  Then the recruitment request page opens for longlisting
  When User selects some of the applicants to be shortlisted
  And change the status in Recruitment Request to Short Listing
   |Status|
   |60_Vacancy in short listing|
  Then Status Should be ShortListing

  When I select Short Listing Criteria from Menu
  Then the Shortlisting page opens up
  And user searches the request for which Shortlisting to be done
  Then the recruitment request page opens for Shortlisting
  When User selects some of the applicants to be passed from shortlisting
  And change the status in Recruitment Request to Vacancy in Assessment
   |Status|
   |70_Vacancy in Assessment|
  Then Status Should be Vacancy in Assessment


 # When the user opens up vacancy assessmnt tab in the detail record
 #  And clicks on the edit button of "Max Date Online Assessment"
 #  And enters the Max Date Online Assessment
 #  And hits Save
 #
  When I open Vacancy Assessment from Menu
  Then the Vacancy Assessment Page opens up
  And user searches the request for which Assessment to be done
  Then the recruitment request page opens for Assessment
  And I enter Max Date Online Assessment  and Save the request
  Then the recruitment request should be opened for entering assessment details
  When User selects some of the applicants to be passed from Assessment
  And change the status in Recruitment Request to Interviews
   |Status|
   |71_Interviews|
  Then Status Should be Interviews

  When I open Ranking Interviews from Menu
  Then Ranking Interviews Page Opens up
  And user searches the request for which ranking to be done
  Then the recruitment page opens for ranking candidates
  When User selects candidates and rank them and Pass from Interview
  And change the status in Recruitment Request Under Offer
   |Status|
   |72_Under offer|
  Then Status Should be Under Offer

  Examples:
   |user |password |role|
   |LeadGP1 |LeadGP1|Recruitment Administrator|


 Scenario Outline: Generating Payroll Contract letter
  Given I am in login Page
  And I login to IDempiere with "<user>" "<password>" "<role>"
  Then HR Admin Home Page Will Open
  And I click Onboarding request from the Menu
  And I select the request to be onboarded
  And Open the detail record section for the applicants of that request and continue Payroll contract Letter Upload
  Then Contract Letter Upload Should be Completed for applicant
  Examples:
   |user |password |role|
   |HRAdmin| HRAdmin| HR Administrator  |