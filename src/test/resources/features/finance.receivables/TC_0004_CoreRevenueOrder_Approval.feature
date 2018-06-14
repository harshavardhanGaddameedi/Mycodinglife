Feature: Receivables / Core Revenue Order Functionality Scenarios

  Scenario Outline: Create Core Revenue Order
    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>"
    And I click on Receivables menu
    And I click on Core Revenue section
    And I click on Revenue Order Core
    And I enter all the Revenue Order Details

      |Customer     |   Product             | Quantity |
      |Aviva Health | Tramadol Capsules 50mg| 10       |
    When I Submit Document Action
    Then I should see the Core Revenue Order created
    Examples:
      | user                  | password              |
      | FinanceProcessor1     | FinanceProcessor1     |

  Scenario: First approval of Revenue Order
    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>"
    When I click on Workflow Activities section in Home Page
    And I Select and Approve the Revenue Order
    Then I Should see the Revenue Order Approved

  Examples:
  | user                  | password              |
  | EMISProcessor         | EMISProcessor         |

  Scenario: Second approval of Revenue Order
    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>"
    When I click on Workflow Activities section in Home Page
    And I Select and Approve the Revenue Order
    Then I Should see the Revenue Order Approved

  Examples:
  | user                  | password              |
  | FinanceController1    | FinanceController1    |
