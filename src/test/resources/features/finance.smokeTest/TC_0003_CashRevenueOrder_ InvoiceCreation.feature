@smoke
Feature: Receivables / Cash Revenue Invoice Generation Scenarios

  Scenario Outline: Cash Revenue Invoice Creation

    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>"
    And I click on Receivables menu
    #And I click on Private Revenue section
    And I click on Revenue Order
    And I enter all the Revenue Order Details
      |Customer    |  |Product               |  |Quantity    |
      |Aviva Health|  |Tramadol Capsules 50mg|  |10          |

    When I Submit Document Action Receivables
    Then I should see the Revenue Order created

    Examples:
      | user                  | password              |
      | FinanceProcessor1     | FinanceProcessor1     |

  Scenario Outline: Cash Invoice Creation
    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>"
    And I click on ReceivablesCashDesk
    And I click on Revenue Invoice Cash
    And I Click on New button
    And I enter the customer information
      |Customer    |
      |Aviva Health|

    And I Click on CreateLinesFrom button
    Then Invoice popup will be opened
    And I Select and Revenue Order number
    Then I Should see the Revenue Order
    And I select the revenue Order and Click on OK Button
    And I Submit Document Action RevenueInvoice
    Then Cash Revenue invoice will be generated

    Examples:
      | user                  | password              |
      | FinanceProcessor1     | FinanceProcessor1     |
