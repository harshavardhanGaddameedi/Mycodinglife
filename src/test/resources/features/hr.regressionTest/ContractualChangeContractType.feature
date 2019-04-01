#Author: Aditi Seth
  Feature: Raise a Contractual Change request for changing the contract type.
    Scenario Outline: Raise a request for change in contract type
      Given I am in login Page
      And I login to IDempiere with "<user>" "<password>" "<role>"
      Then the dashboard is displayed
      When I Click on new Team View Option from Menu
      And i click on the employee for whom i want to do the contract change
        |name|
        |Maggie Campos|
      And select Update Employee Details
      And  on the Make a change to contract page i select the following fields as
        |ReasonForChange|EffectiveDate|Comments|ContractType|
        |Change in contract type|0|Required please approve|Permanent|
      Then i Submit the request
      And i click on ok
      Examples:
        |user|password|role|
        |ElaineRichards |ElaineRichards |Finance Director|

    Scenario Outline: Approve the contract change for change in contract type

      Given I am in login Page
      And I login to IDempiere with "<user>" "<password>" "<role>"
      When i go to Landing Page
      And i go to review changes in Contract
      And search for the contract type change request
      Then i approve or reject the request
      Examples:
        |user|password|role|
        |JohnAllen |JohnAllen |COO|