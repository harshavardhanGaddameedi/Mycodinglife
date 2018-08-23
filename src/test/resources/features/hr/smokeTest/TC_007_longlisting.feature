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
        And Select NPR and change the status to Accepted
            |Status|
            |40_Accepted|
        And I click on Save Button
        Then the New Position Request is saved
        Examples:
            |user | password |
            |HRDirector|HRDirector|

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
            |COO1 |COO1|COO      |

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

    Scenario Outline: Compare the applicants on the basis of longlisting, shortlisting and Interviews

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

    When i select "Short Listingcriteria" from Menu
    Then the Shortlisting page opens up
    And i click on the applicant tab in detail record
    Then the ShortListing tab is visible
    And i clicks on the shortlisting criteria tab
    And Update the shortlisting criteria for a particular applicant
    And updates the  shortlisting criteria for all the required applicants
    Then the User Update the applicants to be carried forward to assessment stage
    And changes the status in Recruitment Request to Vacancy in Assessment
      |Status|
      |70_Vacancy in Assessment|
#    When the user opens up vacancy assessmnt tab in the detail record
#    And clicks on the edit button of "Max Date Online Assessment"
#    And enters the Max Date Online Assessment
#    And hits Save
     And opens the applicant tab again
    And Updates the Test Schedule tab for each applicant
    Then the applicants to be taken forward to Interview stage are selected
    When the User changes the status of RR to Interviews
      |Status|
      |71_Interviews|
    And hits save
    And opens the detail record
    And the user goes to Panel Interviewer selection in Menu
    Then the Panel Interviewer page opens up
    When the user Opens the Panel interviewer tab on  Panel interviewer tab
    And sets the initial and Final date of assessment
    And hits save
    Then the Member tab in the detail record secin would get enabled with the interviewer


        Examples:
            |user |password |role|
            |LeadGP1 |LeadGP1|Recruitment Administrator|







