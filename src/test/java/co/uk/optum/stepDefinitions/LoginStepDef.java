package co.uk.optum.stepDefinitions;

import co.uk.optum.pages.HomePage;
import co.uk.optum.pages.LoginPage;
import co.uk.optum.pages.SelectRolePage;
import co.uk.optum.pages.StartPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static co.uk.optum.utility.CommonUtility.waitTime;


public class LoginStepDef {

    private LoginPage loginPage;
    private SelectRolePage selectRolePage;
    private StartPage startPage;
    private HomePage homePage;

    public LoginStepDef() {
        this.loginPage = new LoginPage();
        this.selectRolePage = new SelectRolePage();
        this.startPage = new StartPage();
        this.homePage = new HomePage();
    }


    @Given("^I am in login Page$")
    public void iAmInLoginPage() throws Throwable {
        startPage.load();
        loginPage.waitForUserNameFieldToBeDisplayed();

    }


    @When("^I click Login$")
    public void iClickLogin() throws Throwable {
//        loginPage.clickSelectRoleCheckbox();

//        if(loginPage.isSelectRoleChecked()){
//            loginPage.clickLogin();
//            selectRolePage.waitForSelectRolePageOkBtnToBeDisplayed();
//            waitTime(1000);
//            selectRolePage.clickSelectRolePageOkBtn();
//        }else{
            loginPage.clickLogin();
//        }
        homePage.waitForHomePageLoad();
    }

    @Then("^I should be in the home page$")
    public void iShouldBeInTheHomePage() throws Throwable {
        Assert.assertTrue("Home page is not loaded!!!", homePage.isHomeTabDispalyed());
    }


    @And("^enter the user details \"([^\"]*)\" \"([^\"]*)\"$")
    public void enterTheUserDetails(String username, String password) throws Throwable {
        loginPage.enterUserName(username);
        waitTime(2000);
        loginPage.enterPassword(password);        waitTime(2000);

    }


    @Given("^I login to IDempiere with \"([^\"]*)\" \"([^\"]*)\"$")
    public void iLoginToIDempiereWith(String username, String password) throws Throwable {
        enterTheUserDetails(username, password);

        iClickLogin();
        iShouldBeInTheHomePage();
        waitTime(2000);
    }

    @And("^I login to IDempiere with Approval user$")
    public void iLoginToIDempiereWithApprovalUser() throws Throwable {
        iLoginToIDempiereWith(loginPage.getApprovalUser()[0],loginPage.getApprovalUser()[1],loginPage.getApprovalUser()[2]);
    }

    @And("^Select Role and click Login$")
    public void selectRoleAndClickLogin() throws Throwable {
        loginPage.clickSelectRoleCheckbox();
        loginPage.clickLogin();
        waitTime(3000);
    }

//    @And("^I Select Role and Org \"([^\"]*)\" \"([^\"]*)\"$")
//    public void iSelectRoleAndOrg(String role, String org) throws Throwable {
//        selectRolePage.selectRole(role);
//        selectRolePage.selectOrganisation(org);
//    }

    @When("^I click login in Role page$")
    public void iClickLoginInRolePage() throws Throwable {
        selectRolePage.clickSelectRolePageOkBtn();
    }

    @And("^I Select Role and Org \"([^\"]*)\",\"([^\"]*)\"$")
    public void iSelectRoleAndOrg(String role, String org) throws Throwable {
        selectRolePage.selectRole(role);
        selectRolePage.selectOrganisation(org);
    }

    @And("^I login to IDempiere with \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void iLoginToIDempiereWith(String username, String password, String role) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        enterTheUserDetails(username, password);
        selectRole();
        clickLogin();
        iShouldBeInSelectRolePage();
        waitTime(2000);
        selectRolePage.selectRole(role);
        selectRolePage.selectOrganisation("ErpPractice");
        selectRolePage.clickSelectRolePageOkBtn ();
        System.out.println ( "Login with Role Successful" );
        iShouldBeInTheHomePage();



   }

    public void clickLogin() {
        loginPage.clickLogin();


    }

    public  void iShouldBeInSelectRolePage() {
        Assert.assertTrue("Role page is not loaded!!!", selectRolePage.isRolePageDispalyed());


    }

    public void selectRole() {

        loginPage.selectRole();
    }
}
