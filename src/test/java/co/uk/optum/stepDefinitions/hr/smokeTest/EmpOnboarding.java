package co.uk.optum.stepDefinitions.hr.smokeTest;

import co.uk.optum.pages.HomePage;
import co.uk.optum.pages.hr.NewPositionRequestPage;
import co.uk.optum.utility.DriverProvider;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

public class EmpOnboarding {


    private final WebDriver driver;
    private final HomePage homePage;
    private final NewPositionRequestPage newPositionRequestPage;

    @Inject
    public EmpOnboarding() {
        this.driver = DriverProvider.driver;
        PageFactory.initElements (driver, this);
        this.homePage = new HomePage ();
        this.newPositionRequestPage = new NewPositionRequestPage ();
        



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

        homePage.searchNPRAndApprove();


        // Write code here that turns the phrase above into concrete actions

    }
//
//    @Then("^the Job Description is attached$")
//    public void theJobDescriptionIsAttached() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        newPositionRequestPage.isJobDescAttached();
//
//    }
}
