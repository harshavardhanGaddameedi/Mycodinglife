#Author:Sucharitha
#Created date:06-06-2018
#Last Updated date:06-06-2018
Feature: Approve Recruitment Request
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
