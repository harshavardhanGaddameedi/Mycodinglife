
package co.uk.optum.stepDefinitions.hr.regresssionTest;


import co.uk.optum.pages.HomePage;
import co.uk.optum.pages.LandingPage;
import co.uk.optum.pages.hr.TeamView;
import co.uk.optum.utility.DriverProvider;
import com.google.inject.Inject;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

public class HealthInsuranceBenefitChange {

    private final WebDriver driver;
    private final HomePage homePage;
    private final TeamView teamView;
    private final LandingPage landingPage;

    @Inject
    public HealthInsuranceBenefitChange() {
        this.driver = DriverProvider.driver;
        PageFactory.initElements(driver, this);
        this.homePage = new HomePage();
        this.teamView = new TeamView();
        this.landingPage = new LandingPage();
    }

    @Then("^i am redirected to Health Benefits Page$")
    public void i_am_redirected_to_Health_Benefits_Page() throws Throwable {
        landingPage.verifyHealthBenefitTab();
    }

   /* @And("^i select a new request$")
    public void iSelectANewRequest() throws Throwable {
        landingPage.healthBenefitPage();
    }*/

    @When("^i select  Health Benefits as$")
    public void i_select_Health_Benefits_as(DataTable a) throws Throwable {
        List<Map<String,String>> data = a.asMaps(String.class,String.class);
        landingPage.selectHealthBenefitDetails(data.get (0).get("Health Insurance"),data.get (0).get("Select Benefit"),data.get (0).get("Membership Option"),Integer.parseInt(data.get (0).get("Effective Date")));
    }

    @Then("^i hit Benefits Apply change$")
    public void i_hit_Benefits_Apply_change() throws Throwable {
        landingPage.applyBenefitChange();
    }


    @When("^i search for apply Benefit Change Process$")
    public void iSearchForApplyBenefitChangeProcess() throws Throwable {
        homePage.searchBenefitChangeProcess();
    }

    @Then("^on Apply benefit change page i click on OK$")
    public void onApplyBenefitChangePageIClickOnOK() throws Throwable {
      landingPage.applyBenefitManualProcess();
    }

    @Then("^i verify the health benefit applied$")
    public void iVerifyTheHealthBenefitApplied(DataTable f) throws Throwable {
        List<Map<String,String>> data = f.asMaps(String.class,String.class);
        landingPage.verifyBenefitApplied(data.get ( 0 ).get ( "Private Health Insurance" ));
    }

    @When("^i select  the effective date to opt out$")
    public void iSelectTheEffectiveDateToOptOut(DataTable n) throws Throwable {
        List<Map<String,String>> data = n.asMaps(String.class,String.class);
        landingPage.selectHealthBenefitOptOut(Integer.parseInt(data.get (0).get("Effective Date")));
    }

    @Then("^i hit employee benefits opt out$")
    public void iHitEmployeeBenefitsOptOut() throws Throwable {
        landingPage.healthBenefitOptOut();
    }


}
