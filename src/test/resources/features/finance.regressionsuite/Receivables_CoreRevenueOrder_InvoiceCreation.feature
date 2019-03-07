
Feature: Receivables / Core Revenue Order Functionality Scenarios

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

  Scenario Outline: Core Revenue Invoice Generation
    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>" "<role>"
    And I click on Receivables Core Revenue
    And I click on Revenue Invoice core section
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
