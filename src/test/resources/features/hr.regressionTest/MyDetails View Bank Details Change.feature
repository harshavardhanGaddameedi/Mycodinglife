#Author: Aditi Seth
@mydetailsview
Feature: Raise a Personal Data Change request, Authorize personal data change request
Scenario Outline: Raise request for Personal data Change bank details change
Given I am in login Page
And I login to IDempiere with "<user>" "<password>" "<role>"
When i click on My details view
And i select the kind of update as Update my bank details i want to make from the dropdown
Then Bank Acct Fileds should be Editable
And i enter the effective date
And I Edit Bank Details
And I click on Save Button on MyDetailsView Page to save changes
Then Bank Details Should be Saved
  Examples:
    |user| password|role|
    | RohitSharma| RohitSharma|Employee|
   
Scenario Outline: Approve the personal Data Change
Given I am in login Page
And I login to IDempiere with "<user>" "<password>" "<role>"
When open Change personal data page
And Search For the BankDetail Change request submitted in previous Scenario And Approve
Then I should see status as accepted

Examples:
   |user| password|role|
   |HRAdmin| HRAdmin|HR Administrator|