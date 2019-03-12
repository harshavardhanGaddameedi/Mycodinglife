package co.uk.optum.pages.hr;

import static co.uk.optum.utility.CommonUtility.waitForElementToBeDisplayed;
import static co.uk.optum.utility.CommonUtility.waitTime;
import co.uk.optum.pages.HomePage;
//import co.uk.optum.pages.hr.ContractSalaryPoint;
import co.uk.optum.pages.hr.LeaverRequestApproval;
import co.uk.optum.pages.hr.TeamView;
import co.uk.optum.utility.DriverProvider;
import com.google.inject.Inject;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

public class ContractChangeSalaryPoint {

    private final WebDriver driver;
    private final HomePage homePage;
    private  final TeamView teamView;


    @Inject
    public ContractChangeSalaryPoint() {
        this.driver = DriverProvider.driver;
        PageFactory.initElements (driver, this);
        this.homePage = new HomePage ();
        this.teamView = new TeamView ();

    }

    @When("^i click on the employee for whom i want the salary change$")
    public void iclickontheemployeeforwhomiwantthesalary_change(DataTable table) throws Throwable {
        List<Map<String,String>> data = table.asMaps(String.class,String.class);
        teamView.searchPositionAndEmpForContract(data.get (0).get("PositionName"),data.get (0).get("EmpName"));

    }

    @And("^select Change Employee Details$")
    public void selectChangeEmployeeDetails() throws Throwable {


        teamView.OpenChangeEmployeeDetails();

    }

    @And("^on the Amend Details view page i select the following fields as$")
    public void ontheAmendDetailsviewpageiselectthefollowingfieldsas(DataTable d) throws Throwable {
        System.out.println("page started");
        List<Map<String,String>> data = d.asMaps(String.class,String.class);
        teamView.setSalaryChangeDetails(data.get (0).get("ReasonForChange"),Integer.parseInt(data.get (0).get("EffectiveDate")),data.get (0).get("RoleBandSalaryPoint"));
        //   teamView.setNewSalaryPoint(data.get(0).get("RoleBandSalaryPoint"));

    }

    @Then("^i save the request$")
    public void i_save_the_request() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        teamView.saveChanges();
    }

    @When("^i go Contract Changes$")
    public void i_go_Contract_Changes() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        homePage.openContractRequestPage();
    }

    @When("^Search for the contract change request raised$")
    public void search_for_the_contract_change_request_raised() throws Throwable {
        System.out.println("Search Successful");

    }





}