package co.uk.optum.stepDefinitions.hr.regresssionTest;

import cucumber.api.PendingException;
import cucumber.api.java.en.When;
import co.uk.optum.pages.HomePage;
import co.uk.optum.pages.LandingPage;
import co.uk.optum.pages.hr.TeamView;
import co.uk.optum.utility.DriverProvider;
import com.google.inject.Inject;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

public class AmendPosition {
    private final WebDriver driver;
    private final HomePage homePage;
    private final TeamView teamView;
    private final LandingPage landingPage;

    @Inject
    public AmendPosition() {
        this.driver = DriverProvider.driver;
        PageFactory.initElements(driver, this);
        this.homePage = new HomePage();
        this.teamView = new TeamView();
        this.landingPage = new LandingPage();
    }

    @When("^I Click on View and Edit Job from landing page$")
    public void iClickOnViewAndEditJobFromLandingPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        landingPage.clickViewandEditJobs();
    }


    @And("^Selects the job to be amended$")
    public void selectsTheJobToBeAmended(DataTable c) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<Map<String,String>> data = c.asMaps(String.class,String.class);
        landingPage.selectPositionToUpdate(data.get ( 0 ).get ( "PayrollJob"));
    }
}
