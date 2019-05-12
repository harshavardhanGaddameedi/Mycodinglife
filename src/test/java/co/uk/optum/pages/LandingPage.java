package co.uk.optum.pages;

import co.uk.optum.utility.DriverProvider;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import javax.inject.Inject;

import static co.uk.optum.utility.CommonUtility.*;
import static co.uk.optum.utility.FeatureContext.getStoredRequisitionNumber;

public class LandingPage {

    private WebDriver driver;
    private boolean assertion;

    @Inject
    public LandingPage() {
        this.driver = DriverProvider.driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//td//div//span[contains(.,'Approve Contractual Changes')]")
    WebElement approveContractualChanges;

    @FindBy(xpath = "//tr//td//div//button[contains(.,'Approve')]")
    WebElement approveContract;

    @FindBy(xpath = "//td//div//span[contains(.,'Make an Annual Leave Request')]")
    WebElement annulLeaveRequest;

    @FindBy(xpath = "//td//div//span[contains(.,'Make an Adoption Leave Request')]")
    WebElement adoptionLeaveRequest;
    @FindBy(xpath = "//td//div//span[contains(.,'Make a Paternity Leave Request')]")
    WebElement paternityLeaveRequest;
    @FindBy(xpath = "//td//div//span[contains(.,'Make a Maternity Leave Request')]")
    WebElement maternityLeaveRequest;
    @FindBy(xpath = "//td//div//span[contains(.,'Shared Parental Leave Request')]")
    WebElement sharedParentalLeaveRequest;


    @FindBy(xpath = "//div/span[text()='Start Date']/following::span[1]/input[@class=\"z-datebox-input\"]")
    WebElement leaveStartDate;


    @FindBy(xpath = "//div/span[text()='End Date']/following::span[1]/input[@class=\"z-datebox-input\"]")
    WebElement leaveEndDate;

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

    @FindBy(xpath = "//div/button[contains(.,'Reject')]")
    WebElement rejectButton;

    @FindBy(xpath = "//div/span[text()='Date of Placement']/following::td[1]/div/span/input")
    WebElement dateOfPlacement;

    @FindBy(xpath = "//div/span[text()='Actual Placement Date']/following::td[1]/div/span/input")
    WebElement actualDateOfPlacement;

    @FindBy(xpath = "//div/span[text()='Expected Week of Confinement']/following::td[1]/div/span/input")
    WebElement expectedWeekOfConfinement;

    @FindBy(xpath = "//div/span[text()='Actual Birth Date']/following::td[1]/div/span/input")
    WebElement actualBirthDate;


    @FindBy(xpath = "//div/span[text()=\"Baby's Due Date\"]//following::td[1]/div/span/input")
    WebElement babyDueDate;


    @FindBy(xpath = "//table/tbody/tr/td/button[contains(.,'OK')]")
    WebElement okButton;

    @FindBy(xpath = "//tr/td/div/button[contains(.,'Upload Proof of Adoption')]")
    WebElement uploadProofButton;


    @FindBy(xpath = "//tr/td/div/button[contains(.,'Upload MAT B1')]")
    WebElement paternityProofButton;

    @FindBy(xpath = "//tr/td/div/button[contains(.,'Save Request')]")
    WebElement saveRequestButton;

    @FindBy(xpath="//div[@class=\"landingpage-common-square z-div\"]/div/span[contains(.,'My Benefits')]")
    WebElement myBenefits;

    @FindBy(xpath="//div/ul/li/a[contains(.,'My Benefits:')]")
    WebElement myBenefitsTab;

    @FindBy(xpath = "//tr/td/span[@instancename='my_benefits0benefit_options']/input")
    WebElement benefitOption;

    @FindBy(xpath = "//ul/li/a/span[contains(.,'Landing Page')]")
    WebElement landingPageTab;

    @FindBy(xpath = "//div/ul/li[4][@class='z-tab z-tab-selected']/a/span[text()='Pension']")
    WebElement pensionPageTab;

    @FindBy(xpath="//tr/td/span[@instancename='HE_Pension0he_pension_benefit']/input[@class='z-combobox-input']")
    WebElement pensionBenefitsDropdown;

    @FindBy(xpath="//tr/td/span[@instancename='HE_Pension0HE_Pension_Scheme_ID']/input[@class='z-combobox-input']")
    WebElement pensionSchemeDropdown;

    @FindBy(xpath="//tr/td/span[@instancename='HE_Pension0he_pension_scheme_level_ID']/input[@class='z-combobox-input']")
    WebElement pensionSchemeLevel;

    @FindBy(xpath="//tr/td/span[@instancename='HE_Pension0he_eff_date']/input[@class='z-datebox-input']")
    WebElement pensionEffectiveDate;

    @FindBy(xpath = "//tr/td/button[contains(.,'Apply Change')]")
    WebElement pensionApplyChange;

    @FindBy(xpath = "//div/button[@class='txt-btn btn-ok z-button'][contains(.,'OK')]")
    WebElement pensionProcessOkButton;

    @FindBy(xpath="//div/span[contains(.,'Employee Search')]")
    WebElement employeeSearch;

    @FindBy(xpath="//tr[@class='search-crit-grid z-row']/td[3]/div/input[@class='z-textbox']")
    WebElement empFirstName;

    @FindBy(xpath="//tr[@class='search-crit-grid z-row']/td[5]/div/input[@class='z-textbox']")
    WebElement empLastName;

    @FindBy(xpath="//td/div/button[contains(.,'Employee Details')]")
    WebElement empDetailsButton;

    @FindBy(xpath = "//div/ul[@class='z-tabs-content']/li[8]/a/span[contains(.,'Benefits')]")
    WebElement empViewBenefitsTab;

    @FindBy(xpath = "//tbody[@class='z-rows']/tr[2][@class='benefits z-row z-grid-odd']/td[2]/div/input")
    WebElement employeePensionValue;

    public void approveContractualChanges() {
        waitTime(2000);
        waitForElementToBeDisplayed(approveContractualChanges);
        approveContractualChanges.click();
    }

    public void searchContractRequest() {
        waitTime(2000);
        System.out.println(getStoredRequisitionNumber());
        waitTime(2000);
        System.out.println("got request number");
        approveContract.click();
        waitTime(2000);
    }

    public void clickAnnualLeaveReqeust() {
        annulLeaveRequest.click();
        waitTime(2000);

    }


    public void enterAnnualLeaveRequestDetails(int startDate, int endDate, String partialStartDate, String partialEndDate) {
        waitTime(2000);
        leaveStartDate.clear();
        System.out.println(getFutureDate(startDate));
        leaveStartDate.sendKeys(getFutureDate(startDate) + Keys.TAB);
        leaveEndDate.clear();
        leaveEndDate.sendKeys(getFutureDate(endDate) + Keys.TAB);
        Select partialDate = new Select(driver.findElement(By.xpath("//div/span[text()='Partial Date (Start)']/following::td[1]/div/select")));
        partialDate.selectByVisibleText(partialStartDate);
        Select partialDate1 = new Select(driver.findElement(By.xpath("//div/span[text()='Partial Date (End)']/following::td[1]/div/select")));
        partialDate1.selectByVisibleText(partialEndDate);


    }

    public void submitAbsenceLeaveRequest() {
        waitTime(1000);
        submitRequest.click();
    }

    public boolean isLeaveapplied() {

        if ((driver.findElement(By.xpath("//div/span[contains(.,'Absence Request has been created and submitted')]")).isDisplayed())) {
            return true;

        } else return false;

    }

    public void approveAbsence() {
        waitForElementToBeDisplayed(approveAbsenceRequests);
        waitTime(1000);
        approveAbsenceRequests.click();
        waitTime(1000);
    }

    public void selectAnnualLeaveRequest(String user, String type) {
        waitTime(1000);
        Select userName = new Select(driver.findElement(By.xpath("//div/span[contains(.,'Employee')]/following::select[1]")));
        // userName.selectByValue(user);
        userName.selectByVisibleText(user);
        Select leaveType = new Select(driver.findElement(By.xpath("//div/span[contains(.,'Type')]/following::select[1]")));
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

        if ((driver.findElement(By.xpath("//div/span[contains(.,'Absence Request has been accepted')]")).isDisplayed())) {
            okButton.click();
            return true;


        } else return false;

    }

    public void rejectLeaveRequest() {
        waitForElementToBeDisplayed(rejectButton);
        rejectButton.click();

    }

    public boolean isLeaverejected() {
        if ((driver.findElement(By.xpath("//div/span[contains(.,'Absence Request Rejected')]")).isDisplayed())) {
            return true;

        } else return false;

    }


    public void clickAdoptionLeaveRequest() {

        adoptionLeaveRequest.click();
        waitTime(2000);
    }


    public void enterAdoptionLeaveRequest(int dop) {

        waitTime(2000);
        dateOfPlacement.sendKeys(getFutureDate(dop) + Keys.TAB);

    }

    public boolean isAdoptionLeaveapplied() {

        if ((driver.findElement(By.xpath("//div/span[contains(.,'Absence Request has been created and submitted')]")).isDisplayed())) {
            return true;

        } else if ((driver.findElement(By.xpath("//div/span[contains(.,'Absence Request has been updated and re-submitted')]")).isDisplayed())) {
            return true;
        } else return false;
    }


    public void enterActualAdoptionDates(int adop) {

        waitTime(2000);
        actualDateOfPlacement.sendKeys(getFutureDate(adop) + Keys.TAB);


    }

    public void proofOfAdoption() throws FindFailed {
        {
            waitForElementToBeDisplayed(uploadProofButton);
            uploadProofButton.click();
            String filepath = toAbsolutePath("src//test//resources//AttachingFilesImages//");
            String inputFilePath = toAbsolutePath("src//test//resources//AttachingFilesImages//");

            System.out.println(filepath);
            System.out.println(inputFilePath);


            Screen s = new Screen();
            Pattern fileInputTextBox = new Pattern(filepath + "//" + "FilePath.PNG");
            Pattern openButton = new Pattern(filepath + "//" + "OpenFile1.PNG");
            s.wait(fileInputTextBox, 20);
            s.type(fileInputTextBox, inputFilePath + "//" + "ProofOfAdoption.Docx");
            s.click(openButton);
            waitTime(1000);
            if ((driver.findElement(By.xpath("//div/span[contains(.,'ProofOfAdoption.docx Document uploaded')]")).isDisplayed())) {
                okButton.click();
            }

            System.out.println("Proof of Adoption uploaded");
            waitTime(10000);

        }
    }

    public void clickSaveRequest() {
        waitTime(1000);
        saveRequestButton.click();

    }


    public boolean saveRequestCompletion() {
        if ((driver.findElement(By.xpath("//div/span[contains(.,'Absence Request has been updated')]")).isDisplayed())) {
            okButton.click();
            return true;

        } else return false;
    }

    public void createPaternityLeaveRequest() {

        waitForElementToBeDisplayed(paternityLeaveRequest);
        paternityLeaveRequest.click();
        waitTime(1000);
    }

    public void enterPaternityLeaveDetails(int duedate) {
        waitTime(1000);
        babyDueDate.sendKeys(getFutureDate(duedate) + Keys.TAB);

    }

    public boolean isPaternityLeaveapplied() {

        if ((driver.findElement(By.xpath("//div/span[contains(.,'Absence Request has been created and submitted')]")).isDisplayed())) {
            return true;

        } else if ((driver.findElement(By.xpath("//div/span[contains(.,'Absence Request has been updated and re-submitted')]")).isDisplayed())) {
            return true;
        } else return false;
    }

    public void enterActualBirthDates(int adob) {
        waitTime(1000);
        actualBirthDate.clear();
        actualBirthDate.sendKeys(getFutureDate(adob) + Keys.TAB);


    }

    public void proofOfPaternity()throws FindFailed {

        waitForElementToBeDisplayed(paternityProofButton);
        paternityProofButton.click();
        String filepath = toAbsolutePath("src//test//resources//AttachingFilesImages//");
        String inputFilePath = toAbsolutePath("src//test//resources//AttachingFilesImages//");

        System.out.println(filepath);
        System.out.println(inputFilePath);


        Screen s = new Screen();
        Pattern fileInputTextBox = new Pattern(filepath + "//" + "FilePath.PNG");
        Pattern openButton = new Pattern(filepath + "//" + "OpenFile1.PNG");
        s.wait(fileInputTextBox, 20);
        s.type(fileInputTextBox, inputFilePath + "\\" + "ProofOfPaternity.docx");
        s.click(openButton);
        if ((driver.findElement(By.xpath("//div/span[contains(.,'ProofOfPaternity.docx Document uploaded')]")).isDisplayed())) {
            okButton.click();
        }

        System.out.println("Proof of Paternity uploaded");
        waitTime(10000);
    }

    public void clickSharedParentalRequest() {
        waitForElementToBeDisplayed(sharedParentalLeaveRequest);
        sharedParentalLeaveRequest.click();

    }


    public void enterSharedParentalDetails(int startDate, int endDate) {

        waitTime(2000);
        leaveStartDate.clear();
        System.out.println(getFutureDate(startDate));
        leaveStartDate.sendKeys(getFutureDate(startDate) + Keys.TAB);
        leaveEndDate.clear();
        leaveEndDate.sendKeys(getFutureDate(endDate) + Keys.TAB);

    }

    public void clickMaternityLeaveRequest() {
        waitForElementToBeDisplayed(maternityLeaveRequest);
        maternityLeaveRequest.click();
    }

    public void enterMaternityLeaveDetails(int ewoc) {
        expectedWeekOfConfinement.clear();
        expectedWeekOfConfinement.sendKeys(getFutureDate(ewoc)+Keys.TAB);
    }


    public boolean isMaternityLeaveApplied() {
        if ((driver.findElement(By.xpath("//div/span[contains(.,'Absence Request has been created and submitted')]")).isDisplayed())) {
            return true;

        } else if ((driver.findElement(By.xpath("//div/span[contains(.,'Absence Request has been updated and re-submitted')]")).isDisplayed())) {
            return true;
        } else return false;

    }

    public void proofOfMaternity() throws FindFailed {
        waitForElementToBeDisplayed(paternityProofButton);
        paternityProofButton.click();
        String filepath = toAbsolutePath("src//test//resources//AttachingFilesImages//");
        String inputFilePath = toAbsolutePath("src//test//resources//AttachingFilesImages//");

        System.out.println(filepath);
        System.out.println(inputFilePath);


        Screen s = new Screen();
        Pattern fileInputTextBox = new Pattern(filepath + "//" + "FilePath.PNG");
        Pattern openButton = new Pattern(filepath + "//" + "OpenFile1.PNG");
        s.wait(fileInputTextBox, 20);
        s.type(fileInputTextBox, inputFilePath + "\\" + "ProofOfMaternity.docx");
        s.click(openButton);
        if ((driver.findElement(By.xpath("//div/span[contains(.,'ProofOfMaternity.docx Document uploaded')]")).isDisplayed())) {
            okButton.click();
        }

        System.out.println("Proof of Maternity uploaded");
        waitTime(10000);

    }

    public void openMyBenefits()
    {
        waitForElementToBeDisplayed(landingPageTab);
        waitTime(2000);
        waitForElementToBeDisplayed(myBenefits);
        myBenefits.click();
    }

    public void selectPensionBenefit(String Benefit_Option)
    {

        waitForElementToBeDisplayed(myBenefitsTab);
        waitForElementToBeDisplayed(benefitOption);
        benefitOption.sendKeys(Benefit_Option +Keys.ENTER);
    }

    public void pensionPage(){
       waitForElementToBeDisplayed(pensionPageTab);
    }
    public void selectPensionSchemeDetails(String PensionBenefit,String PensionScheme, String PensionSchemeLevel, int PensionEffectiveDate){

        waitForElementToBeDisplayed(pensionBenefitsDropdown);
        pensionBenefitsDropdown.clear();
        pensionBenefitsDropdown.sendKeys(PensionBenefit + Keys.ENTER);
        waitForElementToBeDisplayed(pensionSchemeDropdown);
        pensionSchemeDropdown.clear();
        pensionSchemeDropdown.sendKeys(PensionScheme + Keys.TAB);
        waitForElementToBeDisplayed(pensionSchemeLevel);
        pensionSchemeLevel.clear();
        pensionSchemeLevel.sendKeys(PensionSchemeLevel + Keys.ENTER);
        waitForElementToBeDisplayed(pensionEffectiveDate);
        pensionEffectiveDate.clear();
        pensionEffectiveDate.sendKeys(getFutureDate(PensionEffectiveDate));
    }

    public void pensionApply(){
        pensionApplyChange.click();
    }



    public void applyPensionProcess(){
        waitForElementToBeDisplayed(pensionProcessOkButton);
        pensionProcessOkButton.click();
        String Verifytext= driver.findElement(By.tagName("font")).getText().trim();
        Assert.assertEquals(Verifytext, "** null");


    }

    public void searchEmployee(String FirstName, String LastName){
        waitForElementToBeDisplayed(employeeSearch);
        employeeSearch.click();
        empFirstName.sendKeys(FirstName +Keys.TAB);
        empLastName.sendKeys(LastName +Keys.TAB);
        waitTime(2000);
        empDetailsButton.click();

    }

    public void openEmployeeBenefitTab(){
        waitForElementToBeDisplayed(empViewBenefitsTab);
        empViewBenefitsTab.click();
    }

    public boolean verifySchemeApplied(String scheme) {

        if (employeePensionValue.getAttribute("value").equals(scheme))

        {
            assertion = true;
            System.out.println(scheme);

        }
         else{ assertion=false;}
         return assertion;
    }

}