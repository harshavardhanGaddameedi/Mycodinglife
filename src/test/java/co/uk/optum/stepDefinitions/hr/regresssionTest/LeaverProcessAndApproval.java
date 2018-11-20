package co.uk.optum.stepDefinitions.hr.regresssionTest;

import co.uk.optum.pages.HomePage;
import co.uk.optum.pages.hr.LeaverRequestApproval;
import co.uk.optum.pages.hr.TeamView;
import co.uk.optum.utility.DriverProvider;
import com.google.inject.Inject;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

public class LeaverProcessAndApproval {


    private final WebDriver driver;
    private final HomePage homePage;
    private  final TeamView teamView;

    private final LeaverRequestApproval leaverRequestApproval;



    @Inject
    public LeaverProcessAndApproval() {
        this.driver = DriverProvider.driver;
        PageFactory.initElements (driver, this);
        this.homePage = new HomePage ();
//        this.leaverProcessAndApproval = new LeaverProcessAndApproval ();
        this.teamView = new TeamView ();
        this.leaverRequestApproval = new LeaverRequestApproval ();

    }


    @And("^i click on the employee for whom i which to raise a leaver request for$")
    public void iClickOnTheEmployeeForWhomIWhichToRaiseALeaverRequestFor(DataTable table) throws Throwable {

        // Write code here that turns the phrase above into concrete actions


        List<Map<String,String>> data = table.asMaps(String.class,String.class);
        teamView.searchPositionAndEmpForLeaver(data.get (0).get("PositionName"),data.get (0).get("EmpName"));

    }

    @And("^select Start leaver process$")
    public void selectStartLeaverProcess() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        teamView.startLeaverProcess();

    }

    @And("^on the leaver request page i fill the reson for leaving and termination date$")
    public void onTheLeaverRequestPageIFillTheResonForLeavingAndTerminationDate(DataTable t) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        List<Map<String,String>> data = t.asMaps(String.class,String.class);
//        teamView.searchPositionAndEmpForLeaver(data.get (0).get("PositionName"),data.get (0).get("EmpName"));
        teamView.setLeaverDetails(data.get (0).get("Reason For Leaving"),Integer.parseInt(data.get (0).get("Notice Period")));


    }

    @And("^save the request$")
    public void saveTheRequest() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        teamView.saveChanges();
    }

    @Then("^Leaver Details Should be saved$")
    public void leaverDetailsShouldBeSaved() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        Assert.assertTrue("Save Not Successfull!!!",teamView.isSaveSuccessfull());
    }

    @When("^i go to Leavers request$")
    public void iGoToLeaversRequest() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        homePage.openLeaverRequestPage();

    }

    @And("^Search the Employee for which Leaver Request to be approved or denied$")
    public void searchTheEmployeeForWhichLeaverRequestToBeApprovedOrDenied( DataTable t) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<Map<String,String>> data = t.asMaps(String.class,String.class);

        leaverRequestApproval.searchLeaver(data.get ( 0 ).get ( "EmpName" ));




    }


    @Then("^i change Status as required to approve or reject$")
    public void iChangeStatusAsRequiredToApproveOrReject(DataTable t) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<Map<String,String>> data = t.asMaps(String.class,String.class);
        leaverRequestApproval.approveOrReject(data.get ( 0 ).get ( "Status" ));

    }



    @And("^I Update the Leaver Checklist and Save Changes$")
    public void iUpdateTheLeaverChecklistAndSaveChanges() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        leaverRequestApproval.checkItemsToBeReturedAndSave();
    }

    @Then("^Changes should be Saved$")
    public void changesShouldBeSaved(DataTable t) throws Throwable {

        List<Map<String,String>> data = t.asMaps(String.class,String.class);

        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue ( "Save Not Successfull", leaverRequestApproval.isSaveSuccessful(data.get ( 0 ).get ( "Status" )) );
    }
}
