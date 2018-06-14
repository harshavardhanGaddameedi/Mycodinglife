Feature: Receivables / Cash Revenue Invoice Functionality Scenarios

  Scenario Outline: Cash Revenue Invoice Creation

    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>"
    And I click on Receivables menu
    And I click on Print Revenue section
    And I click on Revenue Order

      |Customer     |   Product             | Quantity |

      |Aviva Health | Tramadol Capsules 50mg| 10       |
    And I enter all the Revenue Order Details
    When I Submit Document Action
    Then I should see the Revenue Order created

    Examples:
      | user                  | password              |
      | FinanceProcessor1     | FinanceProcessor1     |
  Scenario: Cash Invoice Creation
    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>"
    And I click on Receivables menu
    And I click on CashDesk section
    And I click on Revenue Invoice Cash
    And I Click on New button
    And I enter customer information
      |Customer     |

      |Aviva Health |
    And I Click on CreateLinesFrom button
    And I selected the revenue Order
    And I click on Ok button
    And I submit Document Action button
    Then Revenue invoice will be generated

  Examples:
  | user                  | password              |
  | FinanceProcessor1     | FinanceProcessor1     |
