Feature: Login into iDempiere Application

  Scenario Outline: Login to iDempiere Application
    Given I am in login Page
#    And enter the user details "<user>", "<password>"
#    When I click Login
#    Then I should be in the home page
    And I login to IDempiere with "<user>" "<password>"

    Examples:
      | user          | password  |
      | ErpAdmin      | ErpAdmin  |



  Scenario Outline: Login into iDempiere With different Roles
    Given I am in login Page
    And I login to IDempiere with "<user>" "<password>"
    And Select Role and click Login
    And I Select Role and Org "<role>","<org>"9
    When I click login in Role page
    Then I should be in the home page

    Examples:
      | user      | password  | role                 | org         |
      | ErpAdmin  | ErpAdmin  | HR Business Partner  | ErpPractice |
