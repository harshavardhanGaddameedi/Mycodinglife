#Author: Harsha
Feature: Raise a sickness absence request for  a part time  employee
  Scenario Outline: Raise sickness absence request for an employee
    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>" "<role>"
    Then the dashboard is displayed
    When I Click on new Team View Option from Menu
    And i click on the employee for whom i want to do raise the sickness request
      |name|
      |RC Banglore|
    And select Log Sickness Absence button
    And  I enter the sickness absence details
      |Date|Hours|
      | -1   |   2  |
    And i Save the request
    Then sickness absence request will be created
    And I enter backtowork date
    |BacktoWorkDate|Notes|
    |      1        | Employee is not well   |
    And i Save the request
    Then I should get message to attach RTW form
    And I click on CompleteRTW button
    And I Upload RTW document
    Then I should get upload successful msg
    And i Save the request
    Then Sickness Absence will be updated

     Examples:
      |user|password|role|
      |AlanPeters |AlanPeters |Lead GP|

