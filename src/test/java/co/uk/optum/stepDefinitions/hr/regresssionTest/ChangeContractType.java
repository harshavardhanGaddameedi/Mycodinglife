package co.uk.optum.stepDefinitions.hr.regresssionTest;

import co.uk.optum.pages.HomePage;
import co.uk.optum.pages.LandingPage;
import co.uk.optum.pages.hr.TeamView;
import co.uk.optum.utility.DriverProvider;
import com.google.inject.Inject;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import javax.xml.crypto.Data;
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

//    @When("^i go to Landing Page$")
//    public void igotoLandingPage() throws Throwable {
//      homePage.openNewLandingPage();
//
//    }

    @And("^i go to Approve Contractual Changes$")
    public void iGoToApproveContractualChanges() throws Throwable {
        landingPage.approveContractualChanges();
    }


    @And("^search for the contract type change request$")
    public void searchForTheContractTypeChangeRequest() throws Throwable {
        landingPage.searchContractRequest();
    }

    @Then("^i approve or reject the request$")
    public void i_approve_or_reject_the_request() throws Throwable {
       landingPage.approvecontractRequest();

    }

    @When("^i search for Check Request Process$")
    public void iSearchForCheckRequestProcess() throws Throwable {
        homePage.searchCheckRequestProcess();
      
    }

    @Then("^on check Request Page i enter effective date and click ok$")
    public void onCheckRequestPageIEnterEffectiveDateAndClickOk(DataTable e) throws Throwable {
        List<Map<String,String>> data = e.asMaps(String.class,String.class);
        landingPage.checkRequestDetails(Integer.parseInt(data.get (0).get("Effective Date")));
    }

    @And("^Open the Job Information Tab$")
    public void openTheJobInformationTab() throws Throwable {
       landingPage.openEmployeeJobInformation();
    }

    @Then("^i verify the Payroll Contract Type$")
    public void iVerifyThePayrollContractType(DataTable p) throws Throwable {
        List<Map<String,String>> data = p.asMaps(String.class,String.class);
        landingPage.verifyContractTypeApplied(data.get ( 0 ).get ( "Payroll Contract" ));
    }

    @And("^on the Make a change to contract page i update location details as$")
    public void onTheMakeAChangeToContractPageIUpdateLocationDetailsAs(DataTable arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<Map<String,String>> data = arg1.asMaps(String.class,String.class);
        teamView.changeContractLocation(data.get (0).get("ReasonForChange"),Integer.parseInt(data.get (0).get("EffectiveDate")),data.get (0).get("Comments"),data.get (0).get("Practice"));;
    }

    @Then("^i approve or reject the request for loction change$")
    public void iApproveOrRejectTheRequestForLoctionChange(DataTable arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<Map<String,String>> data = arg1.asMaps(String.class,String.class);
        landingPage.approveLocationChange(data.get(0).get("name"));
    }

    @And("^on the Make a change to contract page i update job grade details as$")
    public void onTheMakeAChangeToContractPageIUpdateJobGradeDetailsAs(DataTable arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<Map<String,String>> data = arg1.asMaps(String.class,String.class);
        teamView.changeContractJobGrade(data.get (0).get("ReasonForChange"),Integer.parseInt(data.get (0).get("EffectiveDate")),data.get (0).get("Comments"),data.get (0).get("Grade"));;
    }

    @Then("^i approve or reject the request for grade change$")
    public void iApproveOrRejectTheRequestForGradeChange(DataTable arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<Map<String,String>> data = arg1.asMaps(String.class,String.class);
        landingPage.approveGradeChange(data.get(0).get("name"));
    }
}
