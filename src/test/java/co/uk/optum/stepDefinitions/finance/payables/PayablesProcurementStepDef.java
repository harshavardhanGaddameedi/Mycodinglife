package co.uk.optum.stepDefinitions.finance.payables;

import co.uk.optum.pages.HomePage;
import co.uk.optum.pages.finance.payables.*;
import co.uk.optum.utility.DriverProvider;
import co.uk.optum.utility.FeatureContext;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
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
    private final GoodsReceivedNotePage goodsReceivedNotePage;
    private final CreatePOFromRequisition createPOFromRequisition;
    private final CustomPurchaseOrderPage customPurchaseOrderPage;
    private final InvoiceSupplier invoiceSupplier;
    private final CustomPaymentPage customPaymentPage;


    @Inject
    public PayablesProcurementStepDef(){
        this.driver = DriverProvider.driver;
        PageFactory.initElements(driver,this);
        this.homePage = new HomePage();
        this.payablesProcurementPage = new PayablesProcurementPage();
        this.customRequisitionPage = new CustomRequisitionPage();
        this.workflowActivitiesPage = new WorkflowActivitiesPage();
        this.createPOFromRequisition = new CreatePOFromRequisition();
        this.goodsReceivedNotePage= new GoodsReceivedNotePage();
        this.customPurchaseOrderPage = new CustomPurchaseOrderPage();
        this.invoiceSupplier = new InvoiceSupplier();
        this.customPaymentPage=new CustomPaymentPage();

    }

    @And("^I click PayablesProcurement menu$")
    public void iClickPayablesProcurementMenu() throws Throwable {
        waitTime(2000);
        homePage.clickMenuIcon();
        homePage.clickFinanceMenu();
        homePage.clickPayablesProcurementMenu();
        payablesProcurementPage.waitForCustomRequisitionIconToDisplay();
    }

    @And("^I click Custom Requisition$")
    public void iClickCustomRequisition() throws Throwable {
        payablesProcurementPage.clickCustomRequisition();
    }
    public void iClickGoodsReceivedNote() throws Throwable{
        payablesProcurementPage.clickGoodsReceivedNote();

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

    @When("^I Select and Reject the Custom Requisition$")
    public void iSelectAndRejectTheCustomRequisition() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        homePage.clickWorkflowActivities();
        workflowActivitiesPage.selectAndRejectCustomRequisition();
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

    @Then("^I Should see the Custom Requisition Rejected$")
    public void iShouldSeeTheCustomRequisitionRejected() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        iClickPayablesProcurementMenu();
        iClickCustomRequisition();
        Assert.assertTrue("Custom Requsition Not Approved!!!",customRequisitionPage.isCustomRequisitionRejected());
    }

    @And("^I Click on Goods Received Note$")
    public void iClickOnGoodsReceivedNote() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        payablesProcurementPage.clickGoodsReceivedNote();
    }

    @And("^I enter all the required details in Material Receipt Page$")
    public void iEnterAllTheRequiredDetailsInMaterialReceiptPage(DataTable arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<Map<String,String>> data = arg1.asMaps(String.class,String.class);
        System.out.println(data.get (0).get("DocumentType"));
        // System.out.println(data.get (0).get("Practice"));
        System.out.println(data.get (0).get("SupplierName"));
        goodsReceivedNotePage.enterCustomRequisitionDetails(data.get (0).get("DocumentType"),data.get (0).get("SupplierName"));

    }

    @And("^I Select the Purchase Order in CreateLines window$")
    public void iSelectThePurchaseOrderInCreateLinesWindow() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        goodsReceivedNotePage.selectPurchaseOrderforReceipt();
    }

    @Then("^I Should see the Purchase Order$")
    public void iShouldSeeThePurchaseOrder() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        goodsReceivedNotePage.isPurchaseOrderDisplayed();
    }

    @And("^I select the Purchase Order and Click on OK Button$")
    public void iSelectThePurchaseOrderAndClickOnOKButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        goodsReceivedNotePage.selectPurchaseOrder();
        goodsReceivedNotePage.clickOk();
    }

    @Then("^Material Receipt will be generated$")
    public void materialReceiptWillBeGenerated() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        goodsReceivedNotePage.getDocumentNumber();
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue("material receipt generation Failed!!!",goodsReceivedNotePage.isMaterialReceiptGenerated());
    }

    @And("^I select Material Receipt and approve$")
    public void iSelectMaterialReceiptAndApprove() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
                System.out.println ( "APPROVAL PROCESS STARTING" );
        workflowActivitiesPage.selectAndApproveMaterialReceipt();
    }

    @Then("^I should see the Material Receipt approved$")
    public void iShouldSeeTheMaterialReceiptApproved() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        iClickPayablesProcurementMenu();
        iClickGoodsReceivedNote();
        Assert.assertTrue("Material Receipt Approval Failed!!!",goodsReceivedNotePage.isMaterialReceiptApproved());
    }

    @And("^I select Material Receipt and reject it$")
    public void iSelectMaterialReceiptAndRejectIt() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println ( "APPROVAL PROCESS STARTING" );
        workflowActivitiesPage.selectAndRejectMaterialReceipt();
    }

    @Then("^I should see the Material Receipt status as Not Approved$")
    public void iShouldSeeTheMaterialReceiptStatusAsNotApproved() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        iClickPayablesProcurementMenu();
        iClickGoodsReceivedNote();
        Assert.assertTrue("Material Receipt Approval Failed!!!",goodsReceivedNotePage.isMaterialReceiptNotApproved());
    }

    @And("^I click on Invoice Supplier$")
    public void iClickOnInvoiceSupplier() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       invoiceSupplier.clickInvoiceSupplier();
    }

    @And("^I enter all the required details in Invoice page$")
    public void iEnterAllTheRequiredDetailsInInvoicePage(DataTable arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<Map<String,String>> data = arg1.asMaps(String.class,String.class);
        System.out.println(data.get (0).get("Supplier"));
        // System.out.println(data.get (0).get("Practice"));
        System.out.println(data.get (0).get("Target Document Type"));
        System.out.println(data.get (0).get("Practice"));
        invoiceSupplier.enterMaterialReceiptDetails(data.get (0).get("Supplier"),data.get (0).get("Target Document Type"),data.get (0).get("Practice"));

    }

    @Then("^I should see the Invoice generated with status as Submitted$")
    public void iShouldSeeTheInvoiceGeneratedWithStatusAsSubmitted() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        invoiceSupplier.getDocumentNumber();
        Assert.assertTrue("Custom PO Status is not Correct!!!", invoiceSupplier.isInvoiceGeneratedSuccessfully());
    }

    @And("^I Click on  Custom Payment$")
    public void iClickOnCustomPayment() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        customPaymentPage.clickCustomPayment();
    }

    @And("^I select all the required details in the Custom Payment page$")
    public void iSelectAllTheRequiredDetailsInTheCustomPaymentPage(DataTable arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<Map<String,String>> data = arg1.asMaps(String.class,String.class);
        System.out.println(data.get (0).get("Document Type"));
        // System.out.println(data.get (0).get("Practice"));
        System.out.println(data.get (0).get("Supplier"));
        System.out.println(data.get (0).get("Practice"));
        System.out.println(data.get (0).get("Bank Account"));
        customPaymentPage.enterInvoiceDetails(data.get (0).get("Document Type"),data.get (0).get("Supplier"),data.get (0).get("Practice"),data.get (0).get("Bank Account"));

    }

    @And("^I Select Invoice icon$")
    public void iSelectInvoiceIcon() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        customPaymentPage.clickInvoiceIcon();
    }

    @And("^I enter Document No in Invoice Info page$")
    public void iEnterDocumentNoInInvoiceInfoPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        customPaymentPage.enterDocumentNumber(getStoredDocumentNumber());
    }

    @Then("^I should see the Invoice Order$")
    public void iShouldSeeTheInvoiceOrder() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        customPaymentPage.isInvoiceRecordDisplayed();
    }

    @And("^I select the record and Click on OK Button$")
    public void iSelectTheRecordAndClickOnOKButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        customPaymentPage.selectDocumentRecordandClickOK();
        customPaymentPage.clickOk();
    }

    @Then("^I should see the Payment Completed with Status as In Progress$")
    public void iShouldSeeThePaymentCompletedWithStatusAsInProgress() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue("Custom PO Status is not Correct!!!", customPaymentPage.isPaymentCompletedSuccessfully());
    }

    @And("^I Select Payment record and approve$")
    public void iSelectPaymentRecordAndApprove() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println ( "APPROVAL PROCESS STARTING" );
        workflowActivitiesPage.selectAndApprovePaymentReceipt();
    }

    @Then("^I Should see the Payment record as approved with status as Completed$")
    public void iShouldSeeThePaymentRecordAsApprovedWithStatusAsCompleted() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        iClickPayablesProcurementMenu();
        iClickOnCustomPayment();
        Assert.assertTrue("Payment Approval Failed!!!",customPaymentPage.isCustomPaymentApproved());
    }

    @And("^I Select Payment record and reject$")
    public void iSelectPaymentRecordAndReject() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println ( "APPROVAL PROCESS STARTING" );
        workflowActivitiesPage.selectAndRejectPaymentReceipt();
    }

    @Then("^I Should see the Payment record as approved with status as Not Approved$")
    public void iShouldSeeThePaymentRecordAsApprovedWithStatusAsNotApproved() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        iClickPayablesProcurementMenu();
        iClickOnCustomPayment();
        Assert.assertTrue("Payment Approval Failed!!!",customPaymentPage.isCustomPaymentRejected());
    }
}
