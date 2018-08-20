#Author: Aditi Seth
Feature: Longlisting,shortlisting and Interview of the candidates

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

    When I select Longlisting criteria from Menu
    Then the Longlisting page opens up
    And I click on the applicant tab in detail record
    Then the LongListing tab is visible
    And I clicks on the longlisting criteria tab
    And Update the Longlisting criteria for a particular applicant
    And updates the  longlisting criteria for all the required applicants
    And the User Update the applicants to be carried forward to shortlisting stage
    And change the status in Recruitment Request to Short Listing
      |Status|
      |60_Vacancy in ShortListing|
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
    When the user opens up vacancy assessmnt tab in the detail record
    And clicks on the edit button of "Max Date Online Assessment"
    And enters the Max Date Online Assessment
    And hits Save
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







