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

public class ChangeFullTimeToPartTime {

    private final WebDriver driver;
    private final HomePage homePage;
    private  final TeamView teamView;
    private final LandingPage landingPage;

    @Inject
    public ChangeFullTimeToPartTime() {
        this.driver = DriverProvider.driver;
        PageFactory.initElements (driver, this);
        this.homePage = new HomePage ();
        this.teamView = new TeamView ();
        this.landingPage=new LandingPage ();
    }

    @When("^on the Make a change to contract page i update the full time to part time details as$")
    public void on_the_Make_a_change_to_contract_page_i_update_the_full_time_to_part_time_details_as(DataTable p) throws Throwable {

        List<Map<String,String>> data = p.asMaps(String.class,String.class);
        teamView.changefulltimetoparttime(data.get (0).get("ReasonForChange"),Integer.parseInt(data.get (0).get("EffectiveDate")),data.get (0).get("Comments"),data.get (0).get("Multiplier Hours/Week"));

    }

    @And("^search for the fulltime to part time  request$")
    public void searchForTheFulltimeToPartTimeRequest() throws Throwable {
        landingPage.searchFullToPartTimeRequest();
    }

    @Then("^i verify the Full Time or Part time Value$")
    public void iVerifyTheFullTimeOrPartTimeValue(DataTable c) throws Throwable {
        List<Map<String,String>> data = c.asMaps(String.class,String.class);
        landingPage.verifyTimeValue(data.get ( 0 ).get ( "Full/Part Time" ));
    }

    @Then("^i approve or reject the request for full time to part time$")
    public void iApproveOrRejectTheRequestForFullTimeToPartTime() throws Throwable {
        landingPage.approveTimeContractChange();
    }

    @And("^search for the Part time hours  change request$")
    public void searchForThePartTimeHoursChangeRequest() throws Throwable {
        landingPage.searchPartTimeChangeRequest();
    }

    @Then("^i approve the request$")
    public void iApproveTheRequest() throws Throwable {
        landingPage.approvePartTimeChangeRequest();
    }

    @Then("^i verify the contractual hours to check hour change is implemented$")
    public void iVerifyTheContractualHoursToCheckHourChangeIsImplemented(DataTable m) throws Throwable {
        List<Map<String,String>> data = m.asMaps(String.class,String.class);
        landingPage.verifyPartTimeHours(data.get ( 0 ).get ( "Contractual Hours" ));
    }
}
