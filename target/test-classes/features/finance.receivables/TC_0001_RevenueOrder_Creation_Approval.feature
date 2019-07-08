Feature: Receivables / Private Revenue Order Creation and Approval Scenarios.
  Scenario Outline: Create Revenue Order
    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>" "<role>"
    And I click on Receivables menu
    #And I click on Private Revenue section
    And I click on Revenue Order
    And I enter all the Revenue Order Details
      |Customer    |  |Product               |  |Quantity    |
      |Aviva Health|  |Tramadol Capsules 50mg|  |10          |

    When I Submit Document Action Receivables
    Then I should see the Revenue Order created

    Examples:
      | user                  | password              |role|
      | OperationsProcessor1     | OperationsProcessor1  |Operations Processor|

  Scenario Outline: Approve Revenue Order
    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>" "<role>"
    When I click on Workflow Activities section in Home Page
    And I Select and Approve the Revenue Order
    Then I Should see the Revenue Order Approved

    Examples:
      | user                  | password              |role|
      | FinanceProcessor1     | FinanceProcessor1  |Finance Processor|
