
Feature: Payables / Procurement Order to Payment Creation & Rejection
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

  Scenario Outline: Material Receipt Approval

    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>" "<role>"
    When I click on Workflow Activities section in Home Page
    And I select Material Receipt and approve
    Then I should see the Material Receipt approved
    Examples:
      | user                  | password              |role|
      | FinanceProcessor1     | FinanceProcessor1|Finance Processor|

  Scenario Outline: Invoice Generation
    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>" "<role>"
    And I click PayablesProcurement menu
    And I click on Invoice Supplier
    And I Click on New button
    And I enter all the required details in Invoice page
      |Supplier|Target Document Type|Practice|
      |800100216|AP Invoice          |ErpPractice|
    And I Click on CreateLinesFrom button
    And I Select the Purchase Order in CreateLines window
    Then I Should see the Purchase Order
    And I select the Purchase Order and Click on OK Button
    When I Submit Document Action
    Then I should see the Invoice generated with status as Submitted
    Examples:
      | user                  | password              |role|
      | FinanceProcessor1     | FinanceProcessor1|Finance Processor|

  Scenario Outline: Custom Payment
    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>" "<role>"
    And I click PayablesProcurement menu
    And I Click on  Custom Payment
    And I Click on New button
    And I select all the required details in the Custom Payment page
      |Document Type|Supplier|Practice|Bank Account|
      | AP Payment  |800100216| ErpPractice| Alan Peters_TSB_60 60 40 |
    And I Select Invoice icon
    And I enter Document No in Invoice Info page
    Then I should see the Invoice Order
    And I select the record and Click on OK Button
    When I Submit Document Action
    Then I should see the Payment Completed with Status as In Progress
    Examples:
      | user                  | password              |role|
      | FinanceProcessor1     | FinanceProcessor1|Finance Processor|

  Scenario Outline: Custom Payment Approval
    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>" "<role>"
    And I click on Workflow Activities section in Home Page
    And I Select Payment record and reject
    Then I Should see the Payment record as approved with status as Not Approved
    Examples:
      | user                  | password              |role|
      | FinanceController1     | FinanceController1|Finance Controller|