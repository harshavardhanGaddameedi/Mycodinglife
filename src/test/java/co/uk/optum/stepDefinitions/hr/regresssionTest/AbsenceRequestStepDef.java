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
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

public class AbsenceRequestStepDef {

    private final WebDriver driver;
    private final HomePage homePage;
    private  final TeamView teamView;
    private final LandingPage landingPage;

    @Inject
    public AbsenceRequestStepDef() {
        this.driver = DriverProvider.driver;
        PageFactory.initElements(driver, this);
        this.homePage = new HomePage();
        this.teamView = new TeamView();
        this.landingPage = new LandingPage();
    }


    @And("^I Click on Annual Leave Request Section in landing page$")
    public void iClickOnAnnualLeaveRequestSectionInLandingPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
      landingPage.clickAnnualLeaveReqeust();
    }

    @And("^I enter all the annual leave details in Annual leave window$")
    public void iEnterAllTheAnnualLeaveDetailsInAnnualLeaveWindow(DataTable arg1) throws Throwable {
        List<Map<String,String>> data = arg1.asMaps(String.class,String.class);
        // Write code here that turns the phrase above into concrete actions
       landingPage.enterAnnualLeaveRequestDetails(Integer.parseInt(data.get (0).get("StartDate")),Integer.parseInt(data.get (0).get("EndDate")),data.get (0).get("PartialStartDate"),data.get (0).get("PartialEndDate"));
    }

    @And("^Clicks on Submit Button$")
    public void clicksOnSubmitButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
      landingPage.submitAbsenceLeaveRequest();
    }

    @Then("^Annual Leave request should be created$")
    public void annualLeaveRequestShouldBeCreated() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue("Leave applied successfully !!!",landingPage.isLeaveapplied());
    }

    @And("^click on Approve Absence Request Section$")
    public void clickOnApproveAbsenceRequestSection() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        landingPage.approveAbsence();
    }


    @And("^Select the absence request created by employee$")
    public void selectTheAbsenceRequestCreatedByEmployee(DataTable arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<Map<String,String>> data = arg1.asMaps(String.class,String.class);
        landingPage.selectAnnualLeaveRequest(data.get (0).get("user"),data.get (0).get("Type"));

    }

    @And("^I Click on the Access Request button$")
    public void iClickOnTheAccessRequestButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
   landingPage.clickAccessRequest();

    }

    @And("^Approve the request using approve button$")
    public void approveTheRequestUsingApproveButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        landingPage.approveLeaveRequest();
    }


    @Then("^the request will be approved$")
    public void theRequestWillBeApproved() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue("Leave approved successfully !!!",landingPage.isLeaveapproved());
    }

    @And("^reject the request using Reject button$")
    public void rejectTheRequestUsingRejectButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       landingPage.rejectLeaveRequest();
    }

    @Then("^the request will be rejected$")
    public void theRequestWillBeRejected() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue("Leave Rejected successfully !!!",landingPage.isLeaverejected());
    }

    @And("^I Click on adoption Leave Request Section in landing page$")
    public void iClickOnAdoptionLeaveRequestSectionInLandingPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        landingPage.clickAdoptionLeaveRequest();
    }

    @And("^I enter all the  leave details in Adoption leave window$")
    public void iEnterAllTheLeaveDetailsInAdoptionLeaveWindow(DataTable arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<Map<String,String>> data = arg1.asMaps(String.class,String.class);
        landingPage.enterAdoptionLeaveRequest(Integer.parseInt(data.get (0).get("dop")));
    }

    @Then("^adoption Leave request should be created$")
    public void adoptionLeaveRequestShouldBeCreated() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue("Leave applied successfully !!!",landingPage.isAdoptionLeaveapplied());
    }

    @And("^I enter the actual placement date$")
    public void iEnterTheActualPlacementDate(DataTable arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        List<Map<String,String>> data = arg1.asMaps(String.class,String.class);
        landingPage.enterActualAdoptionDates(Integer.parseInt(data.get (0).get("adop")));
    }

    @And("^I upload proof of Adoption document$")
    public void iUploadProofOfAdoptionDocument() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        landingPage.proofOfAdoption();
    }

    @And("^I click on the Save request$")
    public void iClickOnTheSaveRequest() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        landingPage.clickSaveRequest();
    }

    @Then("^the request will be saved with latest updates$")
    public void theRequestWillBeSavedWithLatestUpdates() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        Assert.assertTrue("Adoption Request saved successfully !!!",landingPage.saveAdoptionRequestCompletion());
    }

    @And("^I Click on paternity Leave Request Section in landing page$")
    public void iClickOnPaternityLeaveRequestSectionInLandingPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        landingPage.createPaternityLeaveRequest();
    }

    @And("^I enter all the  leave details in paternity leave window$")
    public void iEnterAllTheLeaveDetailsInPaternityLeaveWindow(DataTable arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<Map<String,String>> data = arg1.asMaps(String.class,String.class);
        landingPage.enterPaternityLeaveDetails(Integer.parseInt(data.get (0).get("duedate")));
    }

    @Then("^paternity Leave request should be created$")
    public void paternityLeaveRequestShouldBeCreated() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue("Leave applied successfully !!!",landingPage.isPaternityLeaveapplied());
    }

    @And("^I enter the actual birth date$")
    public void iEnterTheActualBirthDate(DataTable arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<Map<String,String>> data = arg1.asMaps(String.class,String.class);
        landingPage.enterActualPaternityDates(Integer.parseInt(data.get (0).get("adob")));

    }

    @And("^I upload proof of paternity document$")
    public void iUploadProofOfPaternityDocument() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       landingPage.proofOfPaternity();
    }

    @And("^I Click on shared parental Leave Request Section in landing page$")
    public void iClickOnSharedParentalLeaveRequestSectionInLandingPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        landingPage.clickSharedParentalRequest();
    }

    @And("^I enter all the shared parental leave details in Annual leave window$")
    public void iEnterAllTheSharedParentalLeaveDetailsInAnnualLeaveWindow(DataTable arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<Map<String,String>> data = arg1.asMaps(String.class,String.class);
        landingPage.enterSharedParentalDetails((Integer.parseInt(data.get (0).get("StartDate"))),Integer.parseInt(data.get (0).get("EndDate")));
    }
}
