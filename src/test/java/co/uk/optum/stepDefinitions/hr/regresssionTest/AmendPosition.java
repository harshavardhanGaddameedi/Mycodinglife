package co.uk.optum.stepDefinitions.hr.regresssionTest;

import cucumber.api.PendingException;
import cucumber.api.java.en.When;
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
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Map;

public class AmendPosition {
    private final WebDriver driver;
    private final HomePage homePage;
    private final TeamView teamView;
    private final LandingPage landingPage;

    @Inject
    public AmendPosition() {
        this.driver = DriverProvider.driver;
        PageFactory.initElements(driver, this);
        this.homePage = new HomePage();
        this.teamView = new TeamView();
        this.landingPage = new LandingPage();
    }

    @When("^I Click on View and Edit Job from landing page$")
    public void iClickOnViewAndEditJobFromLandingPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        landingPage.clickViewandEditJobs();
    }


    @And("^Selects the job to be amended$")
    public void selectsTheJobToBeAmended(DataTable c) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<Map<String,String>> data = c.asMaps(String.class,String.class);
        landingPage.selectPositionToUpdate(data.get ( 0 ).get ( "PayrollJob"));
    }

    @And("^I update the position with below changes$")
    public void iUpdateThePositionWithBelowChanges(DataTable c) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<Map<String,String>> data = c.asMaps(String.class,String.class);
        landingPage.updatePosition(data.get (0).get("Grade"),data.get (0).get("Business Case"),Integer.parseInt(data.get (0).get("EffectiveDate")));

    }

    @And("^I Click on Create Request Button$")
    public void iClickOnCreateRequestButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        landingPage.submitAmendPositionRequest();
    }


    @Then("^a request will be created for amend position$")
    public void aRequestWillBeCreatedForAmendPosition() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue("Amend Position request created successfully !!!",landingPage.isAmendPositionRequestCreated());
    }

    @And("^i go to Approve Amend Payroll Job$")
    public void iGoToApproveAmendPayrollJob() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
      landingPage.viewAmendedPayrollJob();
    }

    @Then("^i approve or reject the request for Amend Payroll Job$")
    public void iApproveOrRejectTheRequestForAmendPayrollJob(DataTable c) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<Map<String,String>> data = c.asMaps(String.class,String.class);
        landingPage.approveAmendPosition(data.get (0).get("PayrollJob"));

    }

    @When("^i search for Amend Position process$")
    public void iSearchForAmendPositionProcess() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       landingPage.searchAmendPositionProcess();
    }

    @And("^i run the process by Clicking OK Button$")
    public void iRunTheProcessByClickingOKButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       landingPage.runAmendPositionProcess();
    }

    @Then("^Process should run successfully$")
    public void processShouldRunSuccessfully() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(" Amend Position Process ran successfully!!! ", landingPage.checkProcessStatus());
    }

    @And("^i navigate to landing Page and click on view Job$")
    public void iNavigateToLandingPageAndClickOnViewJob() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        landingPage.verifyAmendedPositionDetails();
    }

    @And("^I selects the position to be verified$")
    public void iSelectsThePositionToBeVerified(DataTable c) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<Map<String,String>> data = c.asMaps(String.class,String.class);
        landingPage.viewPositionToBeVerified(data.get (0).get("PayrollJob"));
    }

    @Then("^i verify the updated details$")
    public void iVerifyTheUpdatedDetails(DataTable c) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<Map<String,String>> data = c.asMaps(String.class,String.class);
        landingPage.verifyUpdatedPositionDetails(data.get (0).get("Grade"));

    }
}
