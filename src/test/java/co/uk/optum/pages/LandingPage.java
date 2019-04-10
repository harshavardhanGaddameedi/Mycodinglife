package co.uk.optum.pages;

import co.uk.optum.utility.DriverProvider;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.inject.Inject;

import static co.uk.optum.utility.CommonUtility.waitForElementToBeDisplayed;
import static co.uk.optum.utility.CommonUtility.waitTime;
import static co.uk.optum.utility.FeatureContext.getStoredRequisitionNumber;

public class LandingPage {

    private WebDriver driver;

    @Inject
    public LandingPage() {
        this.driver = DriverProvider.driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//td//div//span[contains(.,'Approve Contractual Changes')]")
    WebElement approveContractualChanges;

    @FindBy(xpath = "//tr//td//div//button[contains(.,'Approve')]")
    WebElement approveContract;


    public void approveContractualChanges()
    {
        waitTime(2000);
        waitForElementToBeDisplayed(approveContractualChanges);
        approveContractualChanges.click();
    }

    public void searchContractRequest()
    {
        waitTime(2000);
        System.out.println ( getStoredRequisitionNumber() );
        waitTime(2000);
        System.out.println("got request number");
        approveContract.click();
        waitTime ( 2000 );
    }
}
