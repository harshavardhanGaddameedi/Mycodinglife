package co.uk.optum.stepDefinitions.hr.regresssionTest;

import co.uk.optum.pages.HomePage;
import co.uk.optum.pages.hr.HRAdminChangePersonalDataPage;
import co.uk.optum.pages.hr.MyDetailsView;
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


public class myDetailsViewNameChange {

    private final WebDriver driver;
    private final HomePage homePage;
    private  final MyDetailsView myDetailsView;
//    private  final NewPositionRequestPage newPositionRequestPage;
    private  final HRAdminChangePersonalDataPage hrAdminChangePersonalDataPage;




    @Inject
    public myDetailsViewNameChange() {
        this.driver = DriverProvider.driver;
        PageFactory.initElements (driver, this);
        this.homePage = new HomePage ();
        this.myDetailsView = new MyDetailsView ();
//        this.newPositionRequestPage = new NewPositionRequestPage ();
        this.hrAdminChangePersonalDataPage = new HRAdminChangePersonalDataPage();
    }

    @When("^i click on My details view$")
    public void iClickOnMyDetailsView() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        homePage.clickMyDetailsView();
        myDetailsView.waitForKindOfUpdateDropdown();



    }

    @And("^i select the kind of update as \"([^\"]*)\" i want to make from the dropdown$")
    public void iSelectTheKindOfUpdateAsIWantToMakeFromTheDropdown(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        myDetailsView.selectKindOfUpdate("Update my name");
    }

    @And("^i enter the effective date$")
    public void iEnterTheEffectiveDate() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
          myDetailsView.enterEffDate();

    }

    @Then("^Name Fileds should be Editable$")
    public void nameFiledsShouldBeEditable() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue("Name Fields Not Editable!!!",myDetailsView.areNameFieldsEditable());

//        myDetailsView.areNameFieldsEditable();

    }

//    @And("^Edit the name fileds$")
//    public void editNameFileds() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        myDetailsView.editTheNameFileds();
//
//    }

    @And("^I click on Save Button on MyDetailsView Page$")
    public void iClickOnSaveButtonOnMyDetailsViewPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        myDetailsView.clickAttachmentButton();
        myDetailsView.attachProofOfNameChange();
//        newPositionRequestPage.clickOK();
        myDetailsView.clickOKButton();
        myDetailsView.clickSave();



    }

    @And("^I Edit name fileds$")
    public void iEditNameFileds() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        myDetailsView.editTheNameFileds();

    }

    @Then("^Details Should be Saved$")
    public void detailsShouldBeSaved() throws Throwable {
        // Write code here that turns the phrase above into concrete actions


        Assert.assertTrue("Save Not Successfull!!!",myDetailsView.isSaveSuccessfull());
//        getStoredRequisitionNumber


    }

    @When("^open Change personal data page$")
    public void openChangePersonalDataPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        homePage.openChangePersonaDataPage();

    }

    @And("^Search For the request submitted in previous Scenario And Approve$")
    public void searchForTheRequestSubmittedInPreviousScenarioAndApprove() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        hrAdminChangePersonalDataPage.searchRequestAndApprove();

    }

    @Then("^I should see status as accepted$")
    public void iShouldSeeStatusAsAccepted() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue("Save Not Successfull!!!",hrAdminChangePersonalDataPage.isSaveSuccessfull());
    }

    @And("^i select the kind of update as Update my bank details i want to make from the dropdown$")
    public void iSelectTheKindOfUpdateAsUpdateMyBankDetailsIWantToMakeFromTheDropdown() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        myDetailsView.selectKindOfUpdate("Update my Bank details");

    }

    @Then("^Bank Acct Fileds should be Editable$")
    public void bankAcctFiledsShouldBeEditable() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue("Bank Fields Not Editable!!!",myDetailsView.areBankEditable());
    }

    @And("^I Edit Bank Details$")
    public void iEditBankDetails() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

       myDetailsView.editBankDetails();


    }

    @And("^I click on Save Button on MyDetailsView Page to save changes$")
    public void iClickOnSaveButtonOnMyDetailsViewPageToSaveChanges() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        myDetailsView.clickSave();

    }

    @Then("^Bank Details Should be Saved$")
    public void bankDetailsShouldBeSaved() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue("Save Not Successfull!!!",myDetailsView.isBankDetailSaveSuccessfull());
    }

    @And("^Search For the BankDetail Change request submitted in previous Scenario And Approve$")
    public void searchForTheBankDetailChangeRequestSubmittedInPreviousScenarioAndApprove() throws Throwable {
        // Write code here that turns the phrase above into concrete actions


        hrAdminChangePersonalDataPage.searchBankDetailRequestAndApprove();

    }

    @And("^i select the kind of update as Update Diversity$")
    public void iSelectTheKindOfUpdateAsUpdateDiversity() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        myDetailsView.selectKindOfUpdate("Update Diversity");
    }

    @Then("^Diversity Fileds should be Editable$")
    public void diversityFiledsShouldBeEditable() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        Assert.assertTrue("Diversity Fields Not Editable!!!",myDetailsView.areDiversityFieldsEditable());
    }

    @And("^edit the Diversity details$")
    public void editTheDiversityDetails(DataTable t) throws Throwable {

        List<Map<String,String>> data = t.asMaps(String.class,String.class);
        System.out.println(data.get (0).get("Gender"));
        System.out.println(data.get (0).get("Disability"));
        System.out.println(data.get (0).get("Sexual Orientation"));
//        receivablesPage.setRevenueOrderDetails(data.get (0).get("Customer"),data.get (0).get("Product"),data.get (0).get("Quantity"));
        myDetailsView.updateDiversityInfo(data.get (0).get("Gender"),data.get (0).get("Disability"),data.get (0).get("Sexual Orientation"));




    }

    @Then("^Diversity Fileds should be Saved$")
    public void diversityFiledsShouldBeSaved() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue("Save Not Successfull!!!",myDetailsView.isSaveSuccessfullForDiversityInfo());
    }
}
