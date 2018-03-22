package co.uk.optum.stepDefinitions.finance.payables;

import co.uk.optum.pages.HomePage;
import co.uk.optum.pages.finance.payables.*;
import co.uk.optum.utility.DriverProvider;
import co.uk.optum.utility.FeatureContext;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import javax.inject.Inject;

import static co.uk.optum.utility.FeatureContext.*;

/**
 * Created by bganesa5 on 2/12/2018.
 */
public class PayablesProcurementStepDef {
    private final WebDriver driver;
    private final HomePage homePage;
    private final PayablesProcurementPage payablesProcurementPage;
    private final CustomRequisitionPage customRequisitionPage;
    private final WorkflowActivitiesPage workflowActivitiesPage;
    private final CreatePOFromRequisition createPOFromRequisition;
    private final CustomPurchaseOrderPage customPurchaseOrderPage;



    @Inject
    public PayablesProcurementStepDef(){
        this.driver = DriverProvider.driver;
        PageFactory.initElements(driver,this);
        this.homePage = new HomePage();
        this.payablesProcurementPage = new PayablesProcurementPage();
        this.customRequisitionPage = new CustomRequisitionPage();
        this.workflowActivitiesPage = new WorkflowActivitiesPage();
        this.createPOFromRequisition = new CreatePOFromRequisition();
        this.customPurchaseOrderPage = new CustomPurchaseOrderPage();
    }

    @And("^I click PayablesProcurement menu$")
    public void iClickPayablesProcurementMenu() throws Throwable {
        homePage.clickMenuIcon();
        homePage.clickFinanceMenu();
        homePage.clickPayablesProcurementMenu();
        payablesProcurementPage.waitForCustomRequisitionIconToDisplay();
    }

    @And("^I click Custom Requisition$")
    public void iClickCustomRequisition() throws Throwable {
        payablesProcurementPage.clickCustomRequisition();
    }

    @And("^I enter all the Custom Requistion Details$")
    public void iEnterAllTheCustomRequistionDetails() throws Throwable {
        customRequisitionPage.enterAllCustomRequisitionDetails();
    }

    @When("^I Submit Document Action$")
    public void iSubmitDocumentAction() throws Throwable {
        customRequisitionPage.submitCustomRequisition();
    }

    @Then("^I should see the Custom Requistion created$")
    public void iShouldSeeTheCustomRequistionCreated() throws Throwable {
        customRequisitionPage.getRequisitionNumber();
        customRequisitionPage.getTotalLines();
    }

    @When("^I Select and Approve Custom Requisition$")
    public void iSelectAndApproveCustomRequisition() throws Throwable {
        homePage.clickWorkflowActivities();
        workflowActivitiesPage.selectAndApproveCustomRequisition();
    }

    @Then("^I Should see the Custom Requisition Approved$")
    public void iShouldSeeTheCustomRequisitionApproved() throws Throwable {
        iClickPayablesProcurementMenu();
        iClickCustomRequisition();
        Assert.assertTrue("Custom Requsition Approval Failed!!!",customRequisitionPage.isCustomRequisitionApproved());
    }

    @And("^I click Create PO from Requisition$")
    public void iClickCreatePOFromRequisition() throws Throwable {
        payablesProcurementPage.clickCreatePOfromRequisition();
    }

    @And("^I Select Custom Requisition and generate PO$")
    public void iSelectCustomRequisitionAndGeneratePO() throws Throwable {
        createPOFromRequisition.selectApprovedRequisitionAndGeneratePO(getStoredRequisitionNumber());
    }

    @When("^I Submit the Generated PO$")
    public void iSubmitTheGeneratedPO() throws Throwable {
        Assert.assertTrue("Total line amount is not Correct!!!", customPurchaseOrderPage.isCorrectTotalLineAmountDisplayed());
        customPurchaseOrderPage.submitCustomPO();
    }

    @Then("^I should see the PO Successfully Submitted$")
    public void iShouldSeeThePOSuccessfullySubmitted() throws Throwable {
        Assert.assertTrue("Custom PO Status is not Correct!!!", customPurchaseOrderPage.isPOSubmittedSuccessfully());
    }
}
