package co.uk.optum.stepDefinitions.finance.payables;

import co.uk.optum.pages.HomePage;
import co.uk.optum.pages.finance.payables.CustomRequisitionPage;
import co.uk.optum.pages.finance.payables.PayablesProcurementPage;
import co.uk.optum.utility.DriverProvider;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import javax.inject.Inject;

/**
 * Created by bganesa5 on 2/12/2018.
 */
public class PayablesProcurementStepDef {
    private final WebDriver driver;
    private final HomePage homePage;
    private final PayablesProcurementPage payablesProcurementPage;
    private final CustomRequisitionPage customRequisitionPage;


    @Inject
    public PayablesProcurementStepDef(){
        this.driver = DriverProvider.driver;
        PageFactory.initElements(driver,this);
        this.homePage = new HomePage();
        this.payablesProcurementPage = new PayablesProcurementPage();
        this.customRequisitionPage = new CustomRequisitionPage();

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
}
