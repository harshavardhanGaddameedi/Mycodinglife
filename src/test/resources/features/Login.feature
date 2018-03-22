Feature: Login into iDempiere Application


  Scenario Outline: Login to iDempiere Application
    Given I am in login Page
    And enter the user details "<user>" "<password>"
    When I click Login
    Then I should be in the home page

    Examples:
      | user          | password  |
      | ErpAdmin      | ErpAdmin  |


  Scenario Outline: Login into iDempiere With different Roles
    Given I am in login Page
    And enter the user details "<user>" "<password>"
    And Select Role and click Login
    And I Select Role and Org "<role>" "<org>"
    When I click login in Role page
    Then I should be in the home page

    Examples:
      | user      | password  | role                 | org         |
      | ErpAdmin  | ErpAdmin  | HR Business Partner  | ErpPractice |
