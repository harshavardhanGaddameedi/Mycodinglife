#Author: Aditi Seth
#Created date:30-05-2018
#Last Updated date:30-05-2018

Feature: Generate and place advert
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