Feature: Login into iDempiere Application


  Scenario Outline: Login to iDempiere Application
    Given I am in login Page
    And enter the user details "<user>" "<password>"
    When I click Login
    Then I should be in the home page

    Examples:
      | user                      | password              |
      | OperationsProcessor1      | OperationsProcessor1  |
#      | FinanceBP1                | FinanceBP1            |
#      | FinanceProcessor1         | FinanceProcessor1     |
#      | FinanceController1        | FinanceController1    |
#      | FinanceDirector1          | FinanceDirector1      |

