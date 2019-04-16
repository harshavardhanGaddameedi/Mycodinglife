package co.uk.optum.pages;

import co.uk.optum.utility.DriverProvider;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.inject.Inject;

import static co.uk.optum.utility.CommonUtility.*;
import static co.uk.optum.utility.FeatureContext.getStoredRequisitionNumber;

public class LandingPage {

    private WebDriver driver;

    @Inject
    public LandingPage() {
        this.driver = DriverProvider.driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//td//div//span[contains(.,'Review Changes To Contract')]")
    WebElement reviewChangesToContract;

    @FindBy(xpath = "//tr//td//div//button[contains(.,'Approve')]")
    WebElement approveContract;

    @FindBy(xpath = "//td//div//span[contains(.,'Make an Annual Leave Request')]")
    WebElement annulLeaveRequest;

    @FindBy(xpath = "//div/span[text()='Start Date']/following::span[1]/input[@class=\"z-datebox-input\"]")
    WebElement annualLeaveStartDate;


    @FindBy(xpath = "//div/span[text()='End Date']/following::span[1]/input[@class=\"z-datebox-input\"]")
    WebElement annualLeaveEndDate;

    @FindBy(xpath = " //div/span[text()='Partial Date (Start)']/following::td[1]/div/select[@class=\"z-select\"]")
    WebElement annualLeavePartialDate;


    @FindBy(xpath = " //div/button[contains(.,'Submit Request')]")
    WebElement submitRequest;

    @FindBy(xpath = "//div/span[contains(.,'Absence Request has been created and submitted')]")
    WebElement successMsg;

    @FindBy(xpath = "//td//div//span[contains(.,'Approve Absence Requests')]")
    WebElement approveAbsenceRequests;

    @FindBy(xpath = "//div/span[contains(.,'Employee')]/following::select[1]")
    WebElement absenceEmployee;

    @FindBy(xpath = "//div/span[contains(.,'Type')]/following::select[1]")
    WebElement absenceType;


    @FindBy(xpath = "//table/tbody/tr[1]/td/div/button[contains(.,'Access Request')]")
    WebElement accessRequest;


    @FindBy(xpath = "//div/button[contains(.,'Approve')]")
    WebElement approveButton;


    @FindBy(xpath = "//div/span[contains(.,'Absence Request has been accepted')]")
    WebElement approveMsg;





    public void openReviewChangesToContract()
    {
        waitTime(2000);
        waitForElementToBeDisplayed(reviewChangesToContract);
        reviewChangesToContract.click();
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

    public void clickAnnualLeaveReqeust() {
    annulLeaveRequest.click();
    waitTime(2000);

    }


    public void enterAnnualLeaveRequestDetails(int startDate, int endDate, String partialStartDate, String partialEndDate) {
        waitTime(2000);
        annualLeaveStartDate.clear();
        System.out.println(getFutureDate(startDate));
        annualLeaveStartDate.sendKeys(getFutureDate(startDate)+Keys.TAB);
        annualLeaveEndDate.clear();
        annualLeaveEndDate.sendKeys(getFutureDate(endDate)+Keys.TAB);
        Select partialDate = new Select (driver.findElement(By.xpath("//div/span[text()='Partial Date (Start)']/following::td[1]/div/select")));
        partialDate.selectByVisibleText(partialStartDate);
        Select partialDate1 =new Select (driver.findElement(By.xpath("//div/span[text()='Partial Date (End)']/following::td[1]/div/select")));
        partialDate1.selectByVisibleText(partialEndDate);


    }

    public void submitAnnualLeaveRequest() {
        waitTime(1000);
        submitRequest.click();
    }

    public boolean isLeaveapplied() {

if ((driver.findElement(By.xpath("//div/span[contains(.,'Absence Request has been created and submitted')]")).isDisplayed()))
        {
            return  true;

        }

        else return  false;

    }

    public void approveAbsence() {
        waitForElementToBeDisplayed(approveAbsenceRequests);
        waitTime(1000);
        approveAbsenceRequests.click();
        waitTime(1000);
    }

    public void selectAnnualLeaveRequest(String user, String type) {
        waitTime(1000  );
          Select userName = new Select (driver.findElement(By.xpath("//div/span[contains(.,'Employee')]/following::select[1]")));
         // userName.selectByValue(user);
          userName.selectByVisibleText(user);
        Select leaveType = new Select (driver.findElement(By.xpath("//div/span[contains(.,'Type')]/following::select[1]")));
        leaveType.selectByVisibleText(type);
//        driver.findElement(By.xpath("//li/span["+ stringToContainsTag(update_my_name)+"]")).click();
    }

    public void clickAccessRequest() {
    waitForElementToBeDisplayed(accessRequest);
    waitTime(1000);
        accessRequest.click();
    }

    public void approveLeaveRequest() {
        waitForElementToBeDisplayed(approveButton);
        approveButton.click();

    }

    public boolean isLeaveapproved() {

        if ((driver.findElement(By.xpath("//div/span[contains(.,'Absence Request has been accepted')]")).isDisplayed()))
        {
            return  true;

        }

        else return  false;

    }
}
