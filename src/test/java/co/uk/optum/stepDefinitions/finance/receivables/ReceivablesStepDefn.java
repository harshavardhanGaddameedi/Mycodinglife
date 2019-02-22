package co.uk.optum.stepDefinitions.finance.receivables;

import co.uk.optum.pages.HomePage;
import co.uk.optum.pages.finance.receivables.ReceivablesPage;
import co.uk.optum.pages.finance.receivables.WorkflowActivitiesPage;
import co.uk.optum.utility.DriverProvider;
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

public class ReceivablesStepDefn {

    private  final WebDriver driver;
    private final HomePage homePage;
    private final ReceivablesPage receivablesPage;
    private final WorkflowActivitiesPage workflowActivitiesPage;
//    private final ReceivablesPage receivablesPage;

    @Inject
    public ReceivablesStepDefn() {
        this.driver = DriverProvider.driver;
        PageFactory.initElements (driver, this);
        this.homePage = new HomePage ();
        this.receivablesPage = new ReceivablesPage();
        this.workflowActivitiesPage = new WorkflowActivitiesPage ();

        
    }

    @And("^I click on Receivables menu$")
    public void iClickOnReceivablesMenu() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        homePage.clickMenuIcon();
        homePage.clickFinanceMenu();
        homePage.clickReceivablesPrivateRevenueMenu ();
        receivablesPage.waitForCustomRevenueOrderToDisplay ();
    }

//    @And("^I click on Private Revenue section$")
//    public void iClickOnPrivateRevenueSection() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException ();
//    }

    @And("^I click on Revenue Order$")
    public void iClickOnRevenueOrder() throws Throwable
    {
        // Write code here that turns the phrase above into concrete actions
        receivablesPage.clickCustomRevenueOrder ();
    }

    

    @Then("^I should see the Revenue Order created$")
    public void iShouldSeeTheRevenueOrderCreated() throws Throwable {
        // Write code here that turns the phrase above into concrete
//        int revenueOrderNum;
//        revenueOrderNum = Integer.parseInt (receivablesPage.getRevenueOrderNumber());
        String expectedRevenueOrderStatus = "InProgress";
        String actualRevenueOrderStatus =receivablesPage.revenueOrderStatus();
        System.out.println (receivablesPage.getRevenueOrderNumber ());
        System.out.println(actualRevenueOrderStatus);


    }


    @And("^I enter all the Revenue Order Details$")
    public void iEnterAllTheRevenueOrderDetails(DataTable arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        List<Map<String,String>> data = arg1.asMaps(String.class,String.class);
        System.out.println(data.get (0).get("Customer"));
        System.out.println(data.get (0).get("Product"));
        System.out.println(data.get (0).get("Quantity"));
        receivablesPage.setRevenueOrderDetails(data.get (0).get("Customer"),data.get (0).get("Product"),data.get (0).get("Quantity"));
    }

    @When("^I Submit Document Action Receivables$")
    public void iSubmitDocumentActionReceivables() throws Throwable {

        receivablesPage.clickDocumentAction();

        // Write code here that turns the phrase above into concrete actions

    }

    @When("^I click on Workflow Activities section in Home Page$")
    public void iClickOnWorkflowActivitiesSectionInHomePage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        homePage.clickWorkflowActivities ();

    }

    @And("^I Select and Approve the Revenue Order$")
    public void iSelectAndApproveTheRevenueOrder() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println ( "APPROVAL PROCESS STARTING" );
        workflowActivitiesPage.selectAndApproveRevenueOrder();
    }

    @Then("^I Should see the Revenue Order Approved$")
    public void iShouldSeeTheRevenueOrderApproved() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        iClickOnReceivablesMenu();
        iClickOnRevenueOrder();
        Assert.assertTrue("Revenue Order Approval Failed!!!",receivablesPage.isRevenueOrderApproved());

    }

    @And("^I click on Revenue Invoice section$")
    public void iClickOnRevenueInvoiceSection() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        receivablesPage.clickRevenueInvoice ();



    }

    @Then("^I should see the Revenue Invoice window$")
    public void iShouldSeeTheRevenueInvoiceWindow() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        receivablesPage.waitForRevenueInvoiceWindow();

    }

    @When("^I click on the New Revenue Invoice Icon$")
    public void iClickOnTheNewRevenueInvoiceIcon() throws Throwable {

        receivablesPage.newToolbarIconClick();



        // Write code here that turns the phrase above into concrete actions

    }

    @And("^I enter the customer information$")
    public void iEnterTheCustomerInformation(DataTable arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

         List<Map<String,String>> data = arg1.asMaps(String.class,String.class);
        receivablesPage.setInvoiceDeatils(data.get (0).get("Customer"));



    }

    @And("^I Click on CreateLinesFrom button$")
    public void iClickOnCreateLinesFromButton() throws Throwable {


        receivablesPage.clickCreateLinesFromButton();
        receivablesPage.waitForTheCreateLinesFromPopup();



        // Write code here that turns the phrase above into concrete actions

    }

    @Then("^Invoice popup will be opened$")
    public void invoicePopupWillBeOpened() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        receivablesPage.waitForOrderDropdown();

    }

    @And("^I Select and Revenue Order number$")
    public void iSelectAndRevenueOrderNumber() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        receivablesPage.selectRevenueOrderForInvoice();

    }

    @Then("^I Should see the Revenue Order$")
    public void iShouldSeeTheRevenueOrder() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        receivablesPage.isRevenueOrderDetailsDisplayed();



    }

    @And("^I select the revenue Order and Click on OK Button$")
    public void iSelectTheRevenueOrderAndClickOnOKButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        receivablesPage.selectOrder();

        receivablesPage.clickOK();
    }

    @And("^I Submit Document Action RevenueInvoice$")
    public void iSubmitDocumentActionRevenueInvoice() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        receivablesPage.waitForRevenueInvoiceTab();
        receivablesPage.waitUntilDocumentActionInvoiceIsEnabled();
        receivablesPage.clickDocumentActionInvoice();
        receivablesPage.waitForRevenueInvoiceTab ();


      }

    @Then("^Revenue invoice will be generated$")
    public void revenueInvoiceWillBeGenerated() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

         Assert.assertTrue("Revenue Invoice Creation Failed!!!",receivablesPage.isRevenueInvoiceCreated());



    }

    @And("^I click on ReceivablesCashDesk$")
    public void iClickOnReceivablesCashDesk() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        homePage.clickMenuIcon();
        homePage.clickFinanceMenu();
        homePage.clickReceivablesCashDesk ();



    }

    @And("^I click on Revenue Invoice Cash$")
    public void iClickOnRevenueInvoiceCash() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        receivablesPage.clickRevenueInvoiceCash();


    }

    @And("^I Click on New button$")
    public void iClickOnNewButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        receivablesPage.newToolbarIconClick();
        System.out.println ( "Clicked New Toolbar" );

    }

    @And("^I click on Receivables Core Revenue$")
    public void iClickOnReceivablesCoreRevenue() throws Throwable {


        homePage.clickMenuIcon ();
        homePage.clickFinanceMenu ();
        homePage.clickReceivablesCoreRevenue();



        // Write code here that turns the phrase above into concrete actions

    }

    @And("^I click on Revenue Order Core$")
    public void iClickOnRevenueOrderCore() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        receivablesPage.clickRevenueOrderCore();


    }

    @Then("^I Should see the Revenue Order Approved with status Approved$")
    public void iShouldSeeTheRevenueOrderApprovedWithStatusApproved() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        iClickOnReceivablesCoreRevenue ();
        iClickOnReceivablesCoreRevenueOrder ();
                Assert.assertTrue("Core Revenue Order Approval Failed!!!",receivablesPage.isCoreRevenueOrderApprovedByEMISProcessor());



    }

    private void iClickOnReceivablesCoreRevenueOrder() {
        receivablesPage.clickRevenueOrderCore ();
    }

    @Then("^I Should see the Revenue Order Approved Completed Status$")
    public void iShouldSeeTheRevenueOrderApprovedCompletedStatus() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        iClickOnReceivablesCoreRevenue ();
        iClickOnReceivablesCoreRevenueOrder ();
        Assert.assertTrue("Core Revenue Order Approval Failed!!!",receivablesPage.isCoreRevenueOrderApprovedByFinController());

//        System.out.println ( "Completedddddddddddddd feature" );
    }

    @Then("^Cash Revenue invoice will be generated$")
    public void cashRevenueInvoiceWillBeGenerated() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//         Assert.assertTrue("Revenue Invoice Creation Failed!!!",receivablesPage.isRevenueInvoiceCreated());
        Assert.assertTrue("Revenue Invoice Creation Failed!!!",receivablesPage.isCashRevenueInvoiceCreated());
    }


    @And("^I Select and Reject the Revenue Order$")
    public void iSelectAndRejectTheRevenueOrder() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println ( "REJECTION PROCESS STARTING" );
        workflowActivitiesPage.selectAndRejectRevenueOrder();
    }

    @Then("^I Should see the Revenue Order Rejected$")
    public void iShouldSeeTheRevenueOrderRejected() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        iClickOnReceivablesMenu();
        iClickOnRevenueOrder();
        Assert.assertTrue("Revenue Order Approval Failed!!!",receivablesPage.isRevenueOrderRejected());
    }

    @And("^I click on Revenue Invoice core section$")
    public void iClickOnRevenueInvoiceCoreSection() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
      receivablesPage.clickCoreRevenueInvoice();
    }
}
