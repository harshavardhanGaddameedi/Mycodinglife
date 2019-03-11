
Feature: Payables / Procurement Order creation to Material Receipt Creation
  Scenario Outline: Create Custom Requisition
    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>" "<role>"
    And I click PayablesProcurement menu
    And I click Custom Requisition
    And I enter all the Custom Requistion Details
    When I Submit Document Action
    Then I should see the Custom Requistion created

    Examples:
      | user                  | password              |role|
      | OperationsProcessor1  | OperationsProcessor1  |Operations Processor|

  Scenario: Approve Custom Requisition
    Given I am in login Page
    And I login to IDempiere with Approval user
    When I Select and Approve Custom Requisition
    Then I Should see the Custom Requisition Approved

  Scenario Outline: Create Purchase Order from Requisition
    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>" "<role>"
    And I click PayablesProcurement menu
    And I click Create PO from Requisition
    And I Select Custom Requisition and generate PO
    When I Submit the Generated PO
    Then I should see the PO Successfully Submitted

    Examples:
      | user                  | password              |role|
      | FinanceProcessor1     | FinanceProcessor1     |Finance Processor|

  Scenario Outline: Create Material from Purchase Order
    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>" "<role>"
    And I click PayablesProcurement menu
    And I Click on Goods Received Note
    And I Click on New button
    And I enter all the required details in Material Receipt Page
      |DocumentType|SupplierName|
      |MM Receipt   |800100216|
    And I Click on CreateLinesFrom button
    And I Select the Purchase Order in CreateLines window
    Then I Should see the Purchase Order
    And I select the Purchase Order and Click on OK Button
    When I Submit Document Action
    Then Material Receipt will be generated

    Examples:
      | user                  | password               |role |
      | OperationsProcessor1     | OperationsProcessor1 |Operations Processor|
