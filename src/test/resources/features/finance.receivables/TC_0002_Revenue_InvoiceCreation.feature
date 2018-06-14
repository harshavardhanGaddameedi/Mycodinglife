Feature: Receivables / Print Revenue Order Functionality Scenarios

Scenario Outline: Revenue Invoice Creation
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
       | OperationsProcessor1  | OperationsProcessor1  |

     Scenario: Approve Revenue Order
      Given I am in login Page
      And I login to IDempiere with "<user>" "<password>"
      When I click on Workflow Activities section in Home Page
      And I Select and Approve the Revenue Order
      Then I Should see the Revenue Order Approved

Examples:
       | user                  | password              |
       | FinanceProcessor1    | FinanceProcessor1|

     Scenario: Revenue Invoice Generation
      Given I logged in to Idempiere
      When I click on Receivables menu
      And I click on Print Revenue section
      And I click on Revenue Invoice section
      Then I should see the Revenue Invoice window
      When I click on the New Revenue Invoice Icon
      And I enter the customer information

      |Customer             |
      | Aviva Health        |

      And I Click on CreateLinesFrom button
      Then Invoice popup will be opened
      And I Select and Revenue Order number
      Then I Should see the Revenue Order
      And I select the revenue Order
      And I click on Ok button
      And I submit Document Action button
      Then Revenue invoice will be generated
