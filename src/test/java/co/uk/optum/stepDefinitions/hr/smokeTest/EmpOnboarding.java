package co.uk.optum.stepDefinitions.hr.smokeTest;

import co.uk.optum.pages.HomePage;
import co.uk.optum.pages.hr.*;
import co.uk.optum.utility.DriverProvider;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

import static co.uk.optum.utility.CommonUtility.waitTime;

public class EmpOnboarding {


    private final WebDriver driver;
    private final HomePage homePage;
    private final LineManagerTeamView lineManagerTeamView;
    private final NewPositionRequestPage newPositionRequestPage;
    private final NewPositonRequestApprovalPage newPositionRequestApprovalPage;
    private final RecruitmentRequestPage recruitmentRequestPage;

    private final RecruitmentRequestApprovalPage recruitmentRequestApprovalPage;


    @Inject
    public EmpOnboarding() {
        this.driver = DriverProvider.driver;
        PageFactory.initElements (driver, this);
        this.homePage = new HomePage ();
        this.newPositionRequestPage = new NewPositionRequestPage ();
        this.newPositionRequestApprovalPage = new NewPositonRequestApprovalPage();
        this.lineManagerTeamView = new LineManagerTeamView();
        this.recruitmentRequestPage = new RecruitmentRequestPage ();
        this.recruitmentRequestApprovalPage = new RecruitmentRequestApprovalPage ();


    }


    @And("^I click on New Position Request$")
    public void iClickOnNewPositionRequest() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        homePage.iClickNewPositonRequest();
        newPositionRequestPage.clickNewToolbar();
        newPositionRequestPage.waitForNewPositionRequestTab();



    }

    @And("^I enter all the New Position Request Details$")
    public void iEnterAllTheNewPositionRequestDetails(DataTable t) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<Map<String,String>> data = t.asMaps(String.class,String.class);
        System.out.println(data.get (0).get("Business case"));
        Thread.sleep ( 5000 );
//        receivablesPage.setRevenueOrderDetails(data.get (0).get("Customer"),data.get (0).get("Product"),data.get (0).get("Quantity"));
        newPositionRequestPage.setBusinessCase(data.get (0).get("Business case"));


    }

    @And("^I click on Save Button$")
    public void iClickOnSaveButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        //div//div[@class='adwindow-north z-div']//div/a/span/img[@src='/webui/theme/default/images/Save24.png']
        newPositionRequestPage.clickSaveButton();
        newPositionRequestPage.waitForElementEnablement();




    }

    @And("^I enter the following Details$")
    public void iEnterTheFollowingDetails(DataTable t) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<Map<String,String>> data = t.asMaps(String.class,String.class);
        System.out.println(data.get (0).get("Position Template"));
        Thread.sleep ( 5000 );
//        receivablesPage.setRevenueOrderDetails(data.get (0).get("Customer"),data.get (0).get("Product"),data.get (0).get("Quantity"));
        newPositionRequestPage.setPosTemplate(data.get (0).get("Position Template"));
    }

    @And("^I click on Attachment icon on the Tool bar$")
    public void iClickOnAttachmentIconOnTheToolBar() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        newPositionRequestPage.clickAttachmentButton();



    }

    @And("^I attach the Job Description of Clinical Pharmacist$")
    public void iAttachTheJobDescriptionOfClinicalPharmacist() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        newPositionRequestPage.attachJobDesc();



    }

    @And("^I click on Tick mark of the Attachment Window$")
    public void iClickOnTickMarkOfTheAttachmentWindow() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        newPositionRequestPage.clickOK();


    }

    @And("^I change the status to Pending Approval$")
    public void iChangeTheStatusToPendingApproval(DataTable t) throws Throwable {


        List<Map<String,String>> data = t.asMaps(String.class,String.class);
        System.out.println(data.get (0).get("Status"));
            waitTime ( 1000 );
            newPositionRequestPage.statusInputClear();
            newPositionRequestPage.requestForApproveNPR(data.get (0).get("Status"));



        // Write code here that turns the phrase above into concrete actions

    }

    @Then("^I Should see the New Position Request is saved and sent for approval$")
    public void iShouldSeeTheNewPositionRequestIsSavedAndSentForApproval() throws Throwable
    {
        // Write code here that turns the phrase above into concrete actions
        String expectedNPRStatus = "20_Pending Approval";
        String actualNPRStatus =newPositionRequestPage.NPRStatus();
        System.out.println (newPositionRequestPage.getNPRDocNumber ());
        System.out.println(actualNPRStatus);

    }

    @And("^I click on New Position Request created by HR Business Partner$")
    public void iClickOnNewPositionRequestCreatedByHRBusinessPartner() throws Throwable {

        homePage.iClickNewPositonRequest();
        waitTime(1000);
        homePage.waitForNewPositionTabTobeDisplayed();
        newPositionRequestApprovalPage.searchNPR();






        // Write code here that turns the phrase above into concrete actions

    }

     @And("^Select NPR and change the status to Accepted$")
    public void selectNPRAndChangeTheStatusToAccepted(DataTable t) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<Map<String,String>> data = t.asMaps(String.class,String.class);
        System.out.println(data.get (0).get("Status"));
        newPositionRequestApprovalPage.selectNPRtoApprove();
        newPositionRequestApprovalPage.statusInputClear();
        newPositionRequestApprovalPage.requestForApproveNPR(data.get (0).get("Status"));
    }

    @Then("^the New Position Request is saved$")
    public void theNewPositionRequestIsSaved() throws Throwable {
        // Write code here that turns the phrase above into concrete actions


        Assert.assertTrue("NPR Approval Failed!!!",newPositionRequestApprovalPage.isNPRApproved());
    }

    @When("^I Click Team View Option from Menu$")
    public void iClickTeamViewOptionFromMenu() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        homePage.iClickTeamView();

    }

    @Then("^the dashboard is displayed$")
    public void theDashboardIsDisplayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue("Dashboard Page not displayed!!!",homePage.isDashboradDisplayed());


    }

    @And("^select the position which was created$")
    public void selectThePositionWhichWasCreated(DataTable t) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        List<Map<String,String>> data = t.asMaps(String.class,String.class);
        System.out.println(data.get (0).get("Position"));

        lineManagerTeamView.searchPosition();

        lineManagerTeamView.enterPositionToSearch(data.get (0).get("Position"));
        lineManagerTeamView.clickOKTeamviewSearch();
        waitTime ( 2000 );

        lineManagerTeamView.selectPostionFromGrid();



    }

    @And("^clicks on the Export Example Button on the right hand side of the Tool Bar of iDempiere$")
    public void clicksOnTheExportExampleButtonOnTheRightHandSideOfTheToolBarOfIDempiere() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        lineManagerTeamView.iClickExportExamples();

    }

    @Then("^Recruitment Request window opens up$")
    public void recruitmentRequestWindowOpensUp() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
         Assert.assertTrue("Recruitment Request window not displayed!!!",lineManagerTeamView.isRecruitmentRequestPageDisplayed());
    }

    @And("^fills the Type of Recruitment and Business case$")
    public void fillsTheTypeOfRecruitmentAndBusinessCase(DataTable t) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<Map<String,String>> data = t.asMaps(String.class,String.class);
        System.out.println(data.get (0).get("Position Template"));

        recruitmentRequestPage.setData(data.get (0).get("Type of Recruitment"),data.get (0).get("Business case"),data.get (0).get("Status"));
    }

    @And("^fills the Proposed Start Date field$")
    public void fillsTheProposedStartDateField() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        recruitmentRequestPage.setProposedDate(30);
        waitTime ( 2000 );
     }

    @And("^I click on Save Button On Recruitment Request Page$")
    public void iClickOnSaveButtonOnRecruitmentRequestPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        recruitmentRequestPage.clickSaveButton();


    }

    @Then("^the Recruitment Request for the selected position is created awaiting approval$")
    public void theRecruitmentRequestForTheSelectedPositionIsCreatedAwaitingApproval(DataTable d) throws Throwable {

        List<Map<String,String>> data = d.asMaps(String.class,String.class);
        recruitmentRequestPage.setRecruitmentDocNumber();
        Assert.assertTrue("Recruitment Request Not Submitted for Approval!!!",recruitmentRequestPage.isRecruitmentRequestSentForApproval(data.get (0).get("Status")));

    }

    @When("^I Click Recruitment Request Option from Menu$")
    public void iClickRecruitmentRequestOptionFromMenu() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        homePage.iClickRecruitmentRequest();

    }

    @Then("^the recruitment request page opens$")
    public void theRecruitmentRequestPageOpens() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue("Recruitment Request Approval not displayed!!!",recruitmentRequestApprovalPage.isRecruitmentRequestApprovalPageDisplayed());
    }

    @And("^user searches the request to be approved$")
    public void userSearchesTheRequestToBeApproved() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // Write code here that turns the phrase above into concrete actions
        recruitmentRequestApprovalPage.searchRecruitmentRequest();
        recruitmentRequestApprovalPage.waitForRecordToBeDisplayed();
    }

    @And("^Select Request and change the status to Accepted by adding comments$")
    public void selectRequestAndChangeTheStatusToAcceptedByAddingComments(DataTable t) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<Map<String,String>> data = t.asMaps(String.class,String.class);
        recruitmentRequestApprovalPage.selectRequesttoApprove();
        recruitmentRequestApprovalPage.statusInputClear();
        recruitmentRequestApprovalPage.requestForApproveRecruitmentRequest(data.get (0).get("Status"),data.get ( 0 ).get ( "Comments" ));
    }

    @And("^I click on Save Button on Recruitment Request Approval Page$")
    public void iClickOnSaveButtonOnRecruitmentRequestApprovalPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        recruitmentRequestApprovalPage.clickSaveButton();
        recruitmentRequestApprovalPage.waitForRequestApproval();


    }

    @Then("^the request Should be in Approved State$")
    public void theRequestShouldBeInApprovedState(DataTable t) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<Map<String,String>> data = t.asMaps(String.class,String.class);
//        recruitmentRequestApprovalPage.setRecruitmentDocNumber();

        Assert.assertTrue("Recruitment Request Approval not done!!!",recruitmentRequestApprovalPage.isRecruitmentRequestApproved(data.get (0).get("Status")));

    }

//
//    @Then("^the Job Description is attached$")
//    public void theJobDescriptionIsAttached() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        newPositionRequestPage.isJobDescAttached();
//
//    }
}
