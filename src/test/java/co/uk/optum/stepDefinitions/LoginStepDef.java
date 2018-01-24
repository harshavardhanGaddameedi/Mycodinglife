package co.uk.optum.stepDefinitions;

import co.uk.optum.pages.HomePage;
import co.uk.optum.pages.LoginPage;
import co.uk.optum.pages.SelectRolePage;
import co.uk.optum.pages.StartPage;
import co.uk.optum.utility.CommonUtility;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static co.uk.optum.utility.CommonUtility.*;


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
        loginPage.enterPassword(password);
        waitTime(2000);
    }


    @Given("^I login to IDempiere with \"([^\"]*)\" \"([^\"]*)\"$")
    public void iLoginToIDempiereWith(String username, String password) throws Throwable {
        enterTheUserDetails(username, password);
        iClickLogin();
        iShouldBeInTheHomePage();
        waitTime(2000);
    }
}
