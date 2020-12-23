Feature: Requisition Creation and Approval Scenarios

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



