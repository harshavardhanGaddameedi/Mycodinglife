package co.uk.optum.pages.hr;

import static co.uk.optum.utility.CommonUtility.stringToContainsTag;
import static co.uk.optum.utility.CommonUtility.waitForElementToBeDisplayed;
import static co.uk.optum.utility.CommonUtility.waitTime;
import co.uk.optum.pages.HomePage;
import co.uk.optum.pages.LandingPage;
import co.uk.optum.pages.hr.LeaverRequestApproval;
import co.uk.optum.pages.hr.TeamView;
import co.uk.optum.utility.DriverProvider;
import com.google.inject.Inject;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

public class ChangeContractType {
    private final WebDriver driver;
    private final HomePage homePage;
    private  final TeamView teamView;
    private final LandingPage landingPage;

    @Inject
    public ChangeContractType() {
        this.driver = DriverProvider.driver;
        PageFactory.initElements (driver, this);
        this.homePage = new HomePage ();
        this.teamView = new TeamView ();
        this.landingPage=new LandingPage ();

    }

    @When("^I Click on new Team View Option from Menu$")
    public void i_Click_on_new_Team_View_Option_from_Menu() throws Throwable {
        homePage.iclicknewTeamView();
    }

    @When("^i click on the employee for whom i want to do the contract change$")
    public void iclickontheemployeeforwhomiwanttodothecontractchange(DataTable r) throws Throwable {
        List<Map<String,String>> data = r.asMaps(String.class,String.class);
        teamView.selectEmployeetoUpdate(data.get (0).get("name"));
           }

    @When("^select Update Employee Details$")
    public void select_Update_Employee_Details() throws Throwable {
     teamView.selectUpdateEmployeeDetails();
    }

    @When("^on the Make a change to contract page i select the following fields as$")
    public void ontheMakeachangetocontractpageiselectthefollowingfieldsas(DataTable r) throws Throwable {
        List<Map<String,String>> data = r.asMaps(String.class,String.class);
     teamView.changeContractType(data.get (0).get("ReasonForChange"),Integer.parseInt(data.get (0).get("EffectiveDate")),data.get (0).get("Comments"),data.get (0).get("ContractType"));
    }

    @When("^i Submit the request$")
    public void iSubmittherequest() throws Throwable {
       teamView.SubmitChanges();
    }

    @Then("^i click on ok$")
    public void iclickonok() throws Throwable {
     teamView.clickOk();
    }

    @When("^i go to Landing Page$")
    public void igotoLandingPage() throws Throwable {
      homePage.openNewLandingPage();

    }

    @When("^i go to review changes in Contract$")
    public void igotoreviewchangesinContract() throws Throwable {
        landingPage.openReviewChangesToContract();
    }


    @And("^search for the contract type change request$")
    public void searchForTheContractTypeChangeRequest() throws Throwable {
        landingPage.searchContractRequest();
    }

    @Then("^i approve or reject the request$")
    public void i_approve_or_reject_the_request() throws Throwable {
        System.out.println("Request Approved");

    }



}
