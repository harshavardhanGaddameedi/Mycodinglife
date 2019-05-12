
package co.uk.optum.stepDefinitions.hr.regresssionTest;

import co.uk.optum.pages.HomePage;
import co.uk.optum.pages.LandingPage;
import co.uk.optum.pages.hr.TeamView;
import co.uk.optum.utility.DriverProvider;
import com.google.inject.Inject;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;


public class PensionSchemeChange {
    private final WebDriver driver;
    private final HomePage homePage;
    private final TeamView teamView;
    private final LandingPage landingPage;

    @Inject
    public PensionSchemeChange() {
        this.driver = DriverProvider.driver;
        PageFactory.initElements(driver, this);
        this.homePage = new HomePage();
        this.teamView = new TeamView();
        this.landingPage = new LandingPage();

    }

    @When("^I Click on My Benefits section from landing page$")
    public void i_Click_on_My_Benefits_section_from_landing_page() throws Throwable {
            landingPage.openMyBenefits();
    }

    @And("^i select the benefit from the Benefit Options Dropdown$")
    public void iSelectTheBenefitFromTheBenefitOptionsDropdown(DataTable L) throws Throwable {
        List<Map<String,String>> data = L.asMaps(String.class,String.class);
        landingPage.selectPensionBenefit(data.get (0).get("BenefitOption"));
    }

    @Then("^i am redirected to Pension Page$")
    public void i_am_redirected_to_Pension_Page() throws Throwable {
        landingPage.pensionPage();
    }

    @When("^i select  Pension Benefits as$")
    public void iSelectPensionBenefitsAs(DataTable s) throws Throwable {
        List<Map<String,String>> data = s.asMaps(String.class,String.class);
       landingPage.selectPensionSchemeDetails(data.get (0).get("PensionBenefits"),data.get (0).get("Pension Scheme"),data.get (0).get("Pension Scheme Level"),Integer.parseInt(data.get (0).get("Effective Date")));
    }

    @Then("^i hit Apply Change$")
    public void iHitApplyChange() throws Throwable {
        landingPage.pensionApply();
    }


    @When("^i search for apply Pension Change Process$")
    public void iSearchForApplyPensionChangeProcess() throws Throwable {
        homePage.searchPensionProcess();
    }

    @Then("^on Apply pension chnage page i click on OK$")
    public void onApplyPensionChnagePageIClickOnOK() throws Throwable {
       landingPage.applyPensionProcess();

    }

    @When("^i search for employee in Employee view for Admin$")
    public void iSearchForEmployeeInEmployeeViewForAdmin(DataTable y) throws Throwable {
        List<Map<String,String>> data = y.asMaps(String.class,String.class);
        homePage.openNewLandingPage();
        landingPage.searchEmployee(data.get (0).get("FirstName"),data.get (0).get("LastName"));
    }

    @And("^Open the Benefit Tab$")
    public void openTheBenefitTab() throws Throwable {
        landingPage.openEmployeeBenefitTab();
    }

    @Then("^i verify the pension scheme applied$")
    public void iVerifyThePensionSchemeApplied(DataTable f) throws Throwable {
        List<Map<String,String>> data = f.asMaps(String.class,String.class);
        landingPage.verifySchemeApplied(data.get ( 0 ).get ( "Employee Pension" ));

    }

    @When("^i opt out of Pension Benefits as$")
    public void iOptOutOfPensionBenefitsAs(DataTable n) throws Throwable {
        List<Map<String,String>> data = n.asMaps(String.class,String.class);
        landingPage.selectPensionOptOutDetails(data.get (0).get("PensionBenefits"),Integer.parseInt(data.get (0).get("Effective Date")));
    }

    @Then("^i hit Opt Out$")
    public void iHitOptOut() throws Throwable {
        landingPage.pensionOptOut();
    }
}