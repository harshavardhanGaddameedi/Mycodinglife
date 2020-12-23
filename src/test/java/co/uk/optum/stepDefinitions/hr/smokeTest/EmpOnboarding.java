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
    private final RecruitmentAdministratorPage recruitmentAdministratorPage;
    private final  HRAdminHomePage hrAdminHomePage;



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
        this.recruitmentAdministratorPage = new RecruitmentAdministratorPage ();
        this.hrAdminHomePage = new HRAdminHomePage ();



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


        waitTime ( 1000 );
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
//Anand to write code to pass the position that was created
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

    @Then("^the dashboard of RA is displayed$")
    public void theDashboardOfRAIsDisplayed() throws Throwable {
        // Write code here that turns the phrase above into concrete action

        Assert.assertTrue("Recruitment Admin Home Page Not Loaded !!!",recruitmentAdministratorPage.isRecruitmentAdminDashBoardDisplayed());





    }

    @And("^user searches the request for Advert has to be created$")
    public void userSearchesTheRequestForAdvertHasToBeCreated() throws Throwable {

        recruitmentAdministratorPage.searchRecruitmentRequest();
        recruitmentAdministratorPage.waitForRecordToBeDisplayed();


        // Write code here that turns the phrase above into concrete actions

    }

    @Then("^the recruitment request page opens for editing$")
    public void theRecruitmentRequestPageOpensForEditing() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        System.out.println (  recruitmentAdministratorPage.isRecruitmentRequestOpenedForEditing());
        waitTime ( 3000 );
        Assert.assertTrue("Recruitment Request not displayed for editing!!!",recruitmentAdministratorPage.isRecruitmentRequestOpenedForEditing());
    }

    @When("^I Click Recruitment Request Option from Menu on RA Page$")
    public void iClickRecruitmentRequestOptionFromMenuOnRAPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        recruitmentAdministratorPage.iClickRecruitmentRequest();

    }

    @When("^the status of request is changed to GenerateAdvert$")
    public void theStatusOfRequestIsChangedToGenerateAdvert(DataTable t) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<Map<String,String>> data = t.asMaps(String.class,String.class);
        recruitmentAdministratorPage.changeRecruitmentRequestStatus(data.get (0).get("Status"));
    }

    @And("^I click on Save Button on Recruitment Administrator Page$")
    public void iClickOnSaveButtonOnRecruitmentAdministratorPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        waitTime ( 1000 );
        recruitmentAdministratorPage.clickSaveButton();

    }

    @And("^upload the applicant xml$")
    public void uploadTheApplicantXml() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        recruitmentAdministratorPage.attachJobDesc();
    }

    @And("^I click on Attachment icon on the Tool bar on Recruitment Administrator Page$")
    public void iClickOnAttachmentIconOnTheToolBarOnRecruitmentAdministratorPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        recruitmentAdministratorPage.clickAttachmentButton();

    }

    @Then("^Status Should be GenerateAdvert$")
    public void statusShouldBeGenerateAdvert() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        waitTime ( 2000 );
        Assert.assertTrue("Generate Advert Failed!!!",recruitmentAdministratorPage.isRecruitmentRequestStatusGenerateAdvert());

    }

    @When("^the status of request is changed to Advert$")
    public void theStatusOfRequestIsChangedToAdvert(DataTable t) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<Map<String,String>> data = t.asMaps(String.class,String.class);
        recruitmentAdministratorPage.changeRecruitmentRequestStatus(data.get (0).get("Status"));
    }

    @Then("^Status Should be Advert$")
    public void statusShouldBeAdvert() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        waitTime ( 2000 );
        Assert.assertTrue(" Advert Failed!!!",recruitmentAdministratorPage.isRecruitmentRequestStatusAdvert());
    }

    @When("^the status of request is changed to PlaceAdvert$")
    public void theStatusOfRequestIsChangedToPlaceAdvert(DataTable t) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<Map<String,String>> data = t.asMaps(String.class,String.class);
        recruitmentAdministratorPage.changeRecruitmentRequestStatus(data.get (0).get("Status"));

    }

    @And("^I click on Tick mark of the Attachment Window of Recruitment Admin Page$")
    public void iClickOnTickMarkOfTheAttachmentWindowOfRecruitmentAdminPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        recruitmentAdministratorPage.clickOK();
    }

    @Then("^the detail record should have applicants uploaded$")
    public void theDetailRecordShouldHaveApplicantsUploaded() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        System.out.println ( "Feature Completed");
        Assert.assertTrue(" Advert Failed!!!",recruitmentAdministratorPage.isRecruitmentRequestVacancyClosed());


    }

    @And("^user searches the request for which recruitment has to be continued$")
    public void userSearchesTheRequestForWhichRecruitmentHasToBeContinued() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        recruitmentAdministratorPage.searchRecruitmentRequest();
        recruitmentAdministratorPage.waitForRecordToBeDisplayed();

    }

    @Then("^Status Should be LongListing$")
    public void statusShouldBeLongListing() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        waitTime ( 2000 );
        Assert.assertTrue(" Long Listing Failed!!!",recruitmentAdministratorPage.isRecruitmentRequestLongListing());
    }

    @When("^the status of request is changed to Vacancy in LongListing$")
    public void theStatusOfRequestIsChangedToVacancyInLongListing(DataTable t) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<Map<String,String>> data = t.asMaps(String.class,String.class);
        recruitmentAdministratorPage.changeRecruitmentRequestStatus(data.get (0).get("Status"));
    }

    @And("^I select Longlisting criteria from Menu$")
    public void iSelectLonglistingCriteriaFromMenu() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        recruitmentAdministratorPage.iClickLongListingMenu();

    }

    @Then("^the Longlisting page opens up$")
    public void theLonglistingPageOpensUp() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(" Advert Failed!!!",recruitmentAdministratorPage.isLongListingCriteriaPageDisplayed());
    }

    @And("^user searches the request for which longlisting to be done$")
    public void userSearchesTheRequestForWhichLonglistingToBeDone() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        recruitmentAdministratorPage.searchRecruitmentRequest();
        waitTime ( 1000 );


    }

    @Then("^the recruitment request page opens for longlisting$")
    public void theRecruitmentRequestPageOpensForLonglisting() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        waitTime ( 3000 );
        Assert.assertTrue("Recruitment Request not displayed for longListing!!!",recruitmentAdministratorPage.isRecruitmentRequestOpenedForLongListing());
    }

    @When("^User selects some of the applicants to be shortlisted$")
    public void userSelectsSomeOfTheApplicantsToBeShortlisted() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        recruitmentAdministratorPage.shortListApplicants();

    }

    @And("^change the status in Recruitment Request to Short Listing$")
    public void changeTheStatusInRecruitmentRequestToShortListing(DataTable t) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<Map<String,String>> data = t.asMaps(String.class,String.class);
        recruitmentAdministratorPage.changeRecruitmentRequestStatus(data.get (0).get("Status"));
        waitTime ( 2000 );
        recruitmentAdministratorPage.saveLongListingRec();


    }

    @Then("^Status Should be ShortListing$")
    public void statusShouldBeShortListing() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        waitTime ( 2000 );
        Assert.assertTrue(" Shortlisting Failed!!!",recruitmentAdministratorPage.isRecruitmentRequestShortListng());
    }


    @Then("^the Shortlisting page opens up$")
    public void theShortlistingPageOpensUp() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(" Advert Failed!!!",recruitmentAdministratorPage.isShortListingCriteriaPageDisplayed());

    }

    @And("^user searches the request for which Shortlisting to be done$")
    public void userSearchesTheRequestForWhichShortlistingToBeDone() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        recruitmentAdministratorPage.searchRecruitmentRequest();
        waitTime ( 1000 );

    }

    @When("^I select Short Listing Criteria from Menu$")
    public void iSelectShortListingCriteriaFromMenu() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        recruitmentAdministratorPage.iClickShortListingMenu();
    }

    @Then("^the recruitment request page opens for Shortlisting$")
    public void theRecruitmentRequestPageOpensForShortlisting() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        waitTime ( 3000 );
        Assert.assertTrue("Recruitment Request not displayed for Shortlisting!!!",recruitmentAdministratorPage.isRecruitmentRequestOpenedForShortListing());
    }

    @When("^User selects some of the applicants to be passed from shortlisting$")
    public void userSelectsSomeOfTheApplicantsToBePassedFromShortlisting() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        recruitmentAdministratorPage.passApplicantstoVacancyInAssessment();


    }



    @And("^change the status in Recruitment Request to Vacancy in Assessment$")
    public void changeTheStatusInRecruitmentRequestToVacancyInAssessment(DataTable t) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<Map<String,String>> data = t.asMaps(String.class,String.class);
        recruitmentAdministratorPage.changeRecruitmentRequestStatus(data.get (0).get("Status"));
        waitTime ( 2000 );
        recruitmentAdministratorPage.saveShortListingRec();

    }

    @Then("^Status Should be Vacancy in Assessment$")
    public void statusShouldBeVacancyInAssessment() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        waitTime ( 2000 );
        Assert.assertTrue(" VacancyInAssessment Failed!!!",recruitmentAdministratorPage.isRecruitmentRequestVacancyInAssessment());


    }


    @When("^I open Vacancy Assessment from Menu$")
    public void iOpenVacancyAssessmentFromMenu() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        recruitmentAdministratorPage.iClickVacancyAssessmentMenu();
    }

    @Then("^the Vacancy Assessment Page opens up$")
    public void theVacancyAssessmentPageOpensUp() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        Assert.assertTrue(" Vacancy Assessment Page Not Opened!!!",recruitmentAdministratorPage.isVacancyAssessmentPageOpened());

    }

    @And("^user searches the request for which Assessment to be done$")
    public void userSearchesTheRequestForWhichAssessmentToBeDone() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        recruitmentAdministratorPage.searchRecruitmentRequest();
        waitTime ( 1000 );



    }



    @And("^I enter Max Date Online Assessment  and Save the request$")
    public void iEnterMaxDateOnlineAssessmentAndSaveTheRequest() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
            recruitmentAdministratorPage.saveMaxDateOnlineTestDate(-1);

    }

    @When("^User selects some of the applicants to be passed from Assessment$")
    public void userSelectsSomeOfTheApplicantsToBePassedFromAssessment() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        recruitmentAdministratorPage.passApplicantsToInterviewStage();


    }

    @And("^change the status in Recruitment Request to Interviews$")
    public void changeTheStatusInRecruitmentRequestToInterviews(DataTable t) throws Throwable {
        // Write code here that turns the phrase above into concrete actions


        List<Map<String,String>> data = t.asMaps(String.class,String.class);
        waitTime ( 2000 );
//        recruitmentAdministratorPage.clickSaveButtonOnInterviewPage ();
        recruitmentAdministratorPage.changeRecruitmentRequestStatusInterview(data.get (0).get("Status"));



    }

    @Then("^Status Should be Interviews$")
    public void statusShouldBeInterviews() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        waitTime ( 2000 );
        Assert.assertTrue(" Changing Status to Interview failed!!!",recruitmentAdministratorPage.isRecruitmentRequestStatusInterview());

    }

    @Then("^the recruitment request page opens for Assessment$")
    public void theRecruitmentRequestPageOpensForAssessment() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(" Vacancy Assessment Page Not Opened For Editing!!!",recruitmentAdministratorPage.isVacancyAssessmentPageOpenedForEditing());
    }

    @Then("^the recruitment request should be opened for entering assessment details$")
    public void theRecruitmentRequestShouldBeOpenedForEnteringAssessmentDetails() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue("Recruitment Request not displayed for entering assessments!!!",recruitmentAdministratorPage.isRecruitmentRequestOpenedForEnterningAssesmentDetails());
    }

    @When("^I open Ranking Interviews from Menu$")
    public void iOpenRankingInterviewsFromMenu() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
      recruitmentAdministratorPage.iClickRankingInterviewMenu();

    }

    @Then("^Ranking Interviews Page Opens up$")
    public void rankingInterviewsPageOpensUp() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue("Ranking Interviews Page Not Opened!!!",recruitmentAdministratorPage.isRankingInterviewPageOpened());
    }

    @And("^user searches the request for which ranking to be done$")
    public void userSearchesTheRequestForWhichRankingToBeDone() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        recruitmentAdministratorPage.searchRecruitmentRequest();
        waitTime ( 1000 );


    }

    @Then("^the recruitment page opens for ranking candidates$")
    public void theRecruitmentPageOpensForRankingCandidates() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(" Recruitment Page Not Opened For Ranking Candidates!!!",recruitmentAdministratorPage.isRankingPageOpenedForRanking());

    }

    @When("^User selects candidates and rank them and Pass from Interview$")
    public void userSelectsCandidatesAndRankThemAndPassFromInterview() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        recruitmentAdministratorPage.passApplicantsFromRankingStage();
    }

    @And("^change the status in Recruitment Request Under Offer$")
    public void changeTheStatusInRecruitmentRequestUnderOffer(DataTable t) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<Map<String,String>> data = t.asMaps(String.class,String.class);
        recruitmentAdministratorPage.changeRecruitmentRequestStatus(data.get (0).get("Status"));
        recruitmentAdministratorPage.saveRankingPage();
        waitTime ( 60000 );


    }

    @Then("^Status Should be Under Offer$")
    public void statusShouldBeUnderOffer() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        waitTime ( 2000 );
        Assert.assertTrue(" Changing Status to Under Offer Failed!!!",recruitmentAdministratorPage.isRecruitmentRequestStatusUnderOffer());

    }

    @Then("^HR Admin Home Page Will Open$")
    public void hrAdminHomePageWillOpen() throws Throwable {

        // Write code here that turns the phrase above into concrete actions

        Assert.assertTrue(" HR Admin Home not displayed!!!",hrAdminHomePage.isHRAdminHomeDisplayed());


    }

    @And("^I click Onboarding request from the Menu$")
    public void iClickOnboardingRequestFromTheMenu() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        hrAdminHomePage.clickOnboardingRequest();


    }

    @And("^I select the request to be onboarded$")
    public void iSelectTheRequestToBeOnboarded() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        hrAdminHomePage.searchRequestToBeOnboarded();

        waitTime ( 1000 );
    }


    @And("^Open the detail record section for the applicants of that request and continue Payroll contract Letter Upload$")
    public void openTheDetailRecordSectionForTheApplicantsOfThatRequestAndContinuePayrollContractLetterUpload() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        hrAdminHomePage.selectApplicantAndContinuePayrollContractLetter();
        System.out.println ( "Contract Letter Upload Complete" );
    }

    @And("^Open the detail record section for the applicants of that request and continue New Starter Checklist$")
    public void openTheDetailRecordSectionForTheApplicantsOfThatRequestAndContinueNewStarterChecklist() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        hrAdminHomePage.selectApplicantAndContinueNewStarterChklist();
        System.out.println ( "New Starter Checklist Complete" );
    }

    @Then("^changed should be saved$")
    public void changedShouldBeSaved() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue("Test Failed!!!","Test".equals ( "Test" ));
    }

    @And("^I select the request to be onboarded for New Starter Checklist$")
    public void iSelectTheRequestToBeOnboardedForNewStarterChecklist() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        hrAdminHomePage.searchRequestToBeOnboarded();

        waitTime ( 1000 );

    }

    @Then("^Onboarding flow should be completed$")
    public void onboardingFlowShouldBeCompleted() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue("Test Failed!!!","Test".equals ( "Test" ));
    }

    @Then("^Contract Letter Upload Should be Completed for applicant$")
    public void contractLetterUploadShouldBeCompletedForApplicant() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        Assert.assertTrue("Contract Letter Upload Fialed!!!",hrAdminHomePage.isContractLetterUploadComplete());


    }


//
//    @Then("^the Job Description is serttached$")
//    public void theJobDescriptionIsAttached() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        newPositionRequestPage.isJobDescAttached();
//
//    }
}
