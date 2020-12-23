
Feature: Receivables / Core Revenue Order Creation and Rejection scenarios
  Scenario Outline: Create Core Revenue Order
    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>" "<role>"
    And I click on Receivables Core Revenue
    And I click on Revenue Order Core
    And I enter all the Revenue Order Details

      |Customer     |   Product             | Quantity |
      |Aviva Health | Tramadol Capsules 50mg| 10       |

    When I Submit Document Action Receivables
    Then I should see the Revenue Order created

    Examples:
      | user                  | password              |role|
      | FinanceProcessor1     | FinanceProcessor1     | Finance Processor   |

  Scenario Outline:  Revenue Order Rejection
    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>" "<role>"
    When I click on Workflow Activities section in Home Page
    And I Select and Reject the Revenue Order
    Then I Should see the Revenue Order Rejected

    Examples:
      | user                  | password              |role|
      | EMISProcessor         | EMISProcessor         |EMIS/BDPASS Processor|

