@jenkinsTest
Feature: Receivables / Cash Revenue Invoice Generation Scenarios
  Scenario Outline: Cash Revenue Invoice Creation

    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>" "<role>"
    And I click on Receivables menu
    #And I click on Private Revenue section
    And I click on Revenue Order
    And I enter all the Revenue Order Details
      |Customer    |  |Product               |  |Quantity    |
      |Aviva Health|  |Standard_Standard     |  |10          |

    When I Submit Document Action Receivables
    Then I should see the Revenue Order created

    Examples:
      | user                  | password              |role|
      | FinanceProcessor1     | FinanceProcessor1     |Finance Processor|

  Scenario Outline: Cash Invoice Creation
    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>" "<role>"
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
      | user                  | password              |role|
      | FinanceProcessor1     | FinanceProcessor1     |Finance Processor|
