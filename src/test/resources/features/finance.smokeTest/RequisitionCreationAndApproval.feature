@smoke
Feature: Requisition Creation and Approval Scenarios

  Scenario Outline: Create Custom Requisition
    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>"
    And I click PayablesProcurement menu
    And I click Custom Requisition
    And I enter all the Custom Requistion Details
    When I Submit Document Action
    Then I should see the Custom Requistion created

    Examples:
      | user                  | password              |
      | OperationsProcessor1  | OperationsProcessor1  |

  Scenario: Approve Custom Requisition
    Given I am in login Page
    And I login to IDempiere with Approval user
    When I Select and Approve Custom Requisition
    Then I Should see the Custom Requisition Approved
