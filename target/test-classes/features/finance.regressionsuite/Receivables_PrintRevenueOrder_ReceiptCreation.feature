Feature: Receivables / Private Revenue Order Creation and receipt generation for Revenue invoice.

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

  Scenario Outline: Revenue Invoice Generation
    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>" "<role>"
    And I click on Receivables menu
    #And I click on Private Revenue section
    And I click on Revenue Invoice section
    Then I should see the Revenue Invoice window
    When I click on the New Revenue Invoice Icon
    And I enter the customer information
      |Customer    |
      |Aviva Health|

    And I Click on CreateLinesFrom button
    Then Invoice popup will be opened
    And I Select and Revenue Order number
    Then I Should see the Revenue Order
    And I select the revenue Order and Click on OK Button
    And I Submit Document Action RevenueInvoice
    Then Revenue invoice will be generated

    Examples:
      | user                  | password              |role|
      | FinanceProcessor1     | FinanceProcessor1  |Finance Processor|

  Scenario Outline: Receipt Creation

    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>" "<role>"
    And I click on Receivables menu
    And I click on receipt icon
    Then I should see the Revenue Receipt window
    When I click on the New Revenue Invoice Icon
    And I enter all the required information in Receipt window
      |Customer    |Bank Account|
      |Aviva Health|Alan|
    And I Select Invoice icon
    And I enter revenue invoice details in Invoice Info page
    Then I should see the Invoice Order
    And I select the record and Click on OK Button
    When I Submit Document Action
    Then I should see the Receipt created with Submitted Status

    Examples:
      | user                  | password              |role|
      | FinanceProcessor1     | FinanceProcessor1  |Finance Processor|