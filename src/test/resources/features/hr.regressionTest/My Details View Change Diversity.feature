#Author: Aditi Seth
@mydetailsview
Feature: Raise a Personal Data Change request, Authorize personal data change request
Scenario Outline: Raise request for Personal data Change for diversity 
Given I am in login Page
And I login to IDempiere with "<user>" "<password>" "<role>"
When i click on My details view
And i select the kind of update as Update Diversity
Then Diversity Fileds should be Editable
And i enter the effective date
And edit the Diversity details
  |Gender|    |Disability||Sexual Orientation|
  |Male|  |I do not wish to disclose whether or not I have a disability||I do not wish to disclose my sexual orientation|

  And I click on Save Button on MyDetailsView Page to save changes
  Then Diversity Fileds should be Saved

  Examples:
   |user| password|role|
   | RohitSharma| RohitSharma|Employee|
   
