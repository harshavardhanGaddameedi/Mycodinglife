package co.uk.optum.stepDefinitions.wfm;

import co.uk.optum.pages.WFM.AdhocRequest;
import co.uk.optum.pages.hr.HRAdminHomePage;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import co.uk.optum.pages.*;
import co.uk.optum.pages.hr.TeamView;
import co.uk.optum.utility.DriverProvider;
import cucumber.api.PendingException;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

import static co.uk.optum.utility.FeatureContext.*;


public class WFMAdhocRequest {
    private final WebDriver driver;
    private final AdhocRequest adhocRequest;

    @Inject
    public WFMAdhocRequest() {
        this.driver = DriverProvider.driver;
        PageFactory.initElements(driver, this);
        this.adhocRequest=new AdhocRequest();

    }

    @When("^I Click on New Adhoc and pending Request Section in landing page$")
    public void IClickonNewAdhocandpendingRequestSectioninlandingpage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        adhocRequest.clickCreateNewAdhocRequest();

    }

    @And("^Clicks on New Button in View CM request Window$")
    public void clicksOnNewButtonInViewCMRequestWindow() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        adhocRequest.clickNewButton();

    }

    @And("^I enter all the request details in the Create Request popup$")
    public void iEnterAllTheRequestDetailsInTheCreateRequestPopup(DataTable r) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<Map<String,String>> data = r.asMaps(String.class,String.class);
        setRequisitionNumber(data.get (0).get("EmailSubject"));
        adhocRequest.createNewAdhocRequest(data.get (0).get("RequesterName"),data.get (0).get("Organisation"),data.get (0).get("TelNo"),Integer.parseInt(data.get (0).get("DateAndTime")),data.get (0).get("EmailSubject"),data.get (0).get("MailBoxRequestFrom"),data.get (0).get("Description"),data.get (0).get("RType"),data.get (0).get("LeadSME"),data.get (0).get("SSME"),Integer.parseInt(data.get (0).get("RequestCompletionDate")));
    }

    @And("^Clicks on Save Button$")
    public void clicksOnSaveButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       adhocRequest.submitAdhocRequest();
    }

    @Then("^New Adhoc request should be created$")
    public void newAdhocRequestShouldBeCreated() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue("Login page is not diaplayed", adhocRequest.isRequestSubmittedSuccesfully());

    }

    @When("^I Accept the Request created by LeadAnalyst.$")
    public void iAcceptTheRequestCreatedByLeadAnalyst() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        adhocRequest.acceptRequest(getStoredRequisitionNumber());
    }

    @Then("^I should see the request accepted message$")
    public void iShouldSeeTheRequestAcceptedMessage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue("Request is not accepted",adhocRequest.isRequestAcceptedbySME());
    }

    @And("^I Click on OK button$")
    public void iClickOnOKButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        adhocRequest.clickOKButtton();
    }

    @And("^I navigate to Current Request window$")
    public void iNavigateToCurrentRequestWindow() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    adhocRequest.navigateToCurrentRequestWindow();
    }

    @And("^I Navigate back to landing page$")
    public void iNavigateBackToLandingPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        adhocRequest.navigateBacktoLandingPage();
    }

    @Then("^I should see the accepted request$")
    public void iShouldSeeTheAcceptedRequest() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        adhocRequest.verifyAcceptedAdhocRequest(getAdhocNumber());
    }
}




