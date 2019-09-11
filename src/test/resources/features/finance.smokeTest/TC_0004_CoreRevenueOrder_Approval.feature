@jenkinsTest
Feature: Receivables / Core Revenue Order Functionality Scenarios

  Scenario Outline: Create Core Revenue Order
    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>" "<role>"
    And I click on Receivables Core Revenue
    And I click on Revenue Order Core
    And I enter all the Revenue Order Details

      |Customer     |   Product             | Quantity |
      |Aviva Health | Standard_Standard     | 10       |

    When I Submit Document Action Receivables
    Then I should see the Revenue Order created

    Examples:
      | user                  | password              |role|
      | FinanceProcessor1     | FinanceProcessor1     | Finance Processor   |

  Scenario Outline: First approval of Revenue Order
    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>" "<role>"
    When I click on Workflow Activities section in Home Page
    And I Select and Approve the Revenue Order
    Then I Should see the Revenue Order Approved with status Approved

    Examples:
      | user                  | password              |role|
      | EMISProcessor         | EMISProcessor         |EMIS/BDPASS Processor|

  Scenario Outline: Second approval of Revenue Order
    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>" "<role>"
    When I click on Workflow Activities section in Home Page
    And I Select and Approve the Revenue Order
    Then I Should see the Revenue Order Approved Completed Status

    Examples:
      | user                  | password              |role|
      | FinanceController1    | FinanceController1    |Finance Controller|
