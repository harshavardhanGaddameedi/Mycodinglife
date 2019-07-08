package co.uk.optum.pages;

import co.uk.optum.utility.DriverProvider;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.hotkey.Keys;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import javax.inject.Inject;
import java.util.List;
import java.util.Objects;

import static co.uk.optum.utility.CommonUtility.*;
import static org.openqa.selenium.Keys.ENTER;
import static org.openqa.selenium.Keys.TAB;

public class LandingPage {

    private WebDriver driver;
    private boolean assertion;

    @Inject
    public LandingPage() {
        this.driver = DriverProvider.driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//div[@class=\"landingpage-common-square z-div\"]/div/span[text()='Approve Contractual Changes']")
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
    @FindBy(xpath = "//td//div//span[contains(.,'Log My Overtime')]")
    WebElement logOverTimeRequest;

    @FindBy(xpath = "//td//div//span[contains(.,'Approve Overtime')]")
    WebElement approveOverTimeRequest;

    @FindBy(xpath = "//td//div//span[contains(.,'Log My Overtime')]")
    WebElement myTeam;

    @FindBy(xpath = "//div/span[text()='Start Date']/following::span[1]/input[@class=\"z-datebox-input\"]")
    WebElement leaveStartDate;

    @FindBy(xpath = "//div/span[text()='Back to Work Date']/following::span[1]/input[@class=\"z-datebox-input\"]")
    WebElement backToWorkDate;

    @FindBy(xpath = "//div/span[text()='End Date']/following::span[1]/input[@class=\"z-datebox-input\"]")
    WebElement leaveEndDate;

    @FindBy(xpath = "//div/span[text()='Date Overtime Completed']//following::span[1]/input[@class=\"z-datebox-input\"]")
    WebElement oTDate;

    @FindBy(xpath = "//div/span[text()='Hours Completed']//following::td[1]/div/div/div/input")
    WebElement oTHours;
    @FindBy(xpath = "//div/span[text()='Hours Absent']//following::div/input[@class=\"editor-input z-decimalbox\"]")
    WebElement sicknessHours;





    @FindBy(xpath = " //div/span[text()='Partial Date (Start)']/following::td[1]/div/select[@class=\"z-select\"]")
    WebElement annualLeavePartialDate;


    @FindBy(xpath = " //div/button[contains(.,'Submit Request')]")
    WebElement submitRequest;

    @FindBy(xpath = "//div/button[contains(.,'Submit')]")
    WebElement submit;



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
    @FindBy(xpath = "//table/tbody/tr/td/button[@title='OK']")
    WebElement acceptButton;

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

    @FindBy(xpath = "//tr/td[4]/button[@instancename='HE_Pension0opt_out']")
    WebElement pensionOptOutButton;

    @FindBy(xpath = "//span[@class='z-tab-text'][text()='Health Benefits']")
    WebElement healthBenefitTab;

    @FindBy(xpath = "//tr[4]/td[2]/span[@instancename='HR_Benifits_Management0hr_benefit_scheme_ID']/input")
    WebElement healthInsurance;

    @FindBy(xpath = "//tr/td/span[@instancename='HR_Benifits_Management0IsBenifit']/input")
    WebElement selectBenefit;

    @FindBy(xpath="//tr/td/span[@instancename='HR_Benifits_Management0HR_Membership_Option_ID']/input")
    WebElement membershipOption;

    @FindBy(xpath = "//tr/td/span[@instancename='HR_Benifits_Management0he_eff_date']/input")
    WebElement healthBenefitEffectiveDate;

    @FindBy(xpath = "//tr/td/button[@instancename='HR_Benifits_Management0apply_change']")
    WebElement benefitApplyChange;

    @FindBy(xpath = "//tr/td/button[@instancename='HR_Benifits_Management0OptOut']")
    WebElement benefitOptOut;

    @FindBy(xpath = "//div/button[@class='txt-btn btn-ok z-button']")
    WebElement healthBenefitOkButton;

    @FindBy(xpath="//tr/td/button[@class='z-messagebox-button z-button']")
    WebElement healthBenefitOKPopup;

    @FindBy(xpath = "//div/button[@class='txt-btn btn-ok z-button']")
    WebElement benefitProcessOKButton;

    @FindBy(xpath = "//button[contains(.,'Log Sickness Absence')]")
    WebElement sicknessAbsenceButton;

    @FindBy(xpath = "//div/button[contains(.,'Save')]")
    WebElement saveSicknessButton;
    @FindBy(xpath = "//div/span[text()='Notes']/following::div/textarea")
    WebElement sicknessNotes;

    @FindBy(xpath = "//div/button[contains(.,'Complete RTW')]")
    WebElement cRTWButton;

    @FindBy(xpath = "//div[@class='z-vlayout-inner']//table[@class='z-hbox']//tr//td[9]//span[@class='z-label']")
    WebElement   fileAttached;



    @FindBy(xpath = "//tbody[@class='z-rows']/tr[6][@class='benefits z-row z-grid-odd']/td[2]/div/input[@class='z-textbox z-textbox-readonly']")
    WebElement employeehealthBenefitValue;

    @FindBy(xpath = "//tr/td/div/span[@instancename='he_eff_date']/input")
    WebElement effectiveDateCheckRequest;

    @FindBy(xpath = "//div/button[text()=' OK']")
    WebElement okCheckRequest;

    @FindBy(xpath = "//div/ul/li/a/span[text()='Job Information']")
    WebElement employeeJobInformation;

    @FindBy(xpath = "//tbody[@class='z-rows']/tr[8][@class='z-row z-grid-odd']/td[2]/div/input")
    WebElement employeePayrollContract;


    @FindBy(xpath ="//tbody[@class='z-rows']/tr[8][@class='z-row z-grid-odd']/td[4]/div/input")
    WebElement employeeTimeValue;

    @FindBy(xpath = "//tbody[@class='z-rows']/tr[4][@class='z-row z-grid-odd']/td[2]/div/div/input")
    WebElement employeeContractHours;

    public void approveContractualChanges() {
        waitForElementToBeDisplayed(landingPageTab);
        waitTime(2000);
        waitForElementToBeDisplayed(approveContractualChanges);
        approveContractualChanges.click();
    }

    public void searchContractRequest() {

        WebElement baseTable = driver.findElement(By.xpath("//div[@class='z-grid-body'][@style='overflow: auto; width: 1496px;']/table"));

        List<WebElement> rows = baseTable.findElements(By.tagName("tr"));

        for(WebElement row: rows)

        {

            boolean x = row.findElement(By.xpath("//tr[@class='personal-changes-gridview z-row z-grid-odd']/td/span[text()='Sebastian Sims']")).isDisplayed();
            System.out.println("Found the row");

            if (x == true)

            {
                row.findElement(By.xpath("//td/span[text()='Change in contract type']"));
                System.out.println("The contract request has been found");

                break;
            }
        }
    }

    public void approvecontractRequest(){
        WebElement contractRequest = driver.findElement(By.xpath("//tr[@class='personal-changes-gridview z-row z-grid-odd']/td/span[text()='Sebastian Sims']/parent::td/parent::tr/td[3]/div[2]/button[text()='Approve']"));
        contractRequest.click();

    }

    public void approveTimeContractChange(){
        WebElement contractRequest1 = driver.findElement(By.xpath("//tr[@class='personal-changes-gridview z-row z-grid-odd']/td/span[text()='Sebastian Sims']/parent::td/parent::tr/td[3]/div[2]/button[text()='Approve']"));
        contractRequest1.click();

    }

    public void clickAnnualLeaveReqeust() {
        annulLeaveRequest.click();
        waitTime(2000);

    }


    public void enterAnnualLeaveRequestDetails(int startDate, int endDate, String partialStartDate, String partialEndDate) {
        waitTime(2000);
        leaveStartDate.clear();
        System.out.println(getFutureDate(startDate));
        leaveStartDate.sendKeys(getFutureDate(startDate) + TAB);
        leaveEndDate.clear();
        leaveEndDate.sendKeys(getFutureDate(endDate) + TAB);
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
        dateOfPlacement.sendKeys(getFutureDate(dop) + TAB);

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
        actualDateOfPlacement.sendKeys(getFutureDate(adop) + TAB);


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
        babyDueDate.sendKeys(getFutureDate(duedate) + TAB);

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
        actualBirthDate.sendKeys(getFutureDate(adob) + TAB);


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
        leaveStartDate.sendKeys(getFutureDate(startDate) + TAB);
        leaveEndDate.clear();
        leaveEndDate.sendKeys(getFutureDate(endDate) + TAB);

    }

    public void clickMaternityLeaveRequest() {
        waitForElementToBeDisplayed(maternityLeaveRequest);
        maternityLeaveRequest.click();
    }

    public void enterMaternityLeaveDetails(int ewoc) {
        expectedWeekOfConfinement.clear();
        expectedWeekOfConfinement.sendKeys(getFutureDate(ewoc)+ TAB);
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
        benefitOption.sendKeys(Benefit_Option + ENTER);
    }

    public void pensionPage(){
       waitForElementToBeDisplayed(pensionPageTab);
    }

    public void selectPensionSchemeDetails(String PensionBenefit,String PensionScheme, String PensionSchemeLevel, int PensionEffectiveDate){

        waitForElementToBeDisplayed(pensionBenefitsDropdown);
        pensionBenefitsDropdown.clear();
        pensionBenefitsDropdown.sendKeys(PensionBenefit + ENTER);
        waitForElementToBeDisplayed(pensionSchemeDropdown);
        pensionSchemeDropdown.clear();
        pensionSchemeDropdown.sendKeys(PensionScheme + TAB);
        waitForElementToBeDisplayed(pensionSchemeLevel);
        pensionSchemeLevel.clear();
        pensionSchemeLevel.sendKeys(PensionSchemeLevel + ENTER);
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
        empFirstName.sendKeys(FirstName + TAB);
        empLastName.sendKeys(LastName + TAB);
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
        else if(!Objects.equals(employeePensionValue.getAttribute("value"), scheme)){
            System.out.println("Benefit Doesn't Match");
        }
         //else{ assertion=false;}
         return assertion;
    }

    public void selectPensionOptOutDetails(String PensionBenefit, int PensionEffectiveDate){
        //pensionBenefitsDropdown.clear();
        pensionBenefitsDropdown.sendKeys(PensionBenefit + ENTER);
        //pensionEffectiveDate.clear();
        pensionEffectiveDate.sendKeys(getFutureDate(PensionEffectiveDate));

    }
    public void pensionOptOut(){
       waitForElementToBeDisplayed(pensionOptOutButton);
        waitTime(4000);
       pensionOptOutButton.click();

    }

    public void verifyHealthBenefitTab(){
        waitForElementToBeDisplayed(healthBenefitTab);
    }


   /* public WebElement healthBenefitPage() throws TimeoutException, InterruptedException {

      WebElement  element =driver.findElement(By.xpath("//div[@class='adwindow-toolbar z-toolbar']/div/a[3][@title='New    Alt+N']/span"));
        while (!isDisplayed(element))
        {
            Thread.sleep(3000);
            System.out.println("Element is not visible yet");
        }
        return element;
    }
    public static boolean isDisplayed(WebElement element) {
        try {
            if(element.isDisplayed())
                return element.isDisplayed();
        }catch (TimeoutException ex) {
            return false;
        }
        return false;
    }*/


    public void selectHealthBenefitDetails(String health_Insurance, String select_benefit, String membership_option, int health_effective_date){
        waitTime(2000);
       waitForElementToBeDisplayed(healthInsurance);
       healthInsurance.clear();
       healthInsurance.sendKeys(health_Insurance + Keys.TAB);
       waitForElementToBeDisplayed(selectBenefit);
       selectBenefit.clear();
       selectBenefit.sendKeys(select_benefit +Keys.TAB);
       waitForElementToBeDisplayed(membershipOption);
       membershipOption.clear();
       membershipOption.sendKeys(membership_option + Keys.TAB);
       waitForElementToBeDisplayed(healthBenefitEffectiveDate);
       healthBenefitEffectiveDate.clear();
       healthBenefitEffectiveDate.sendKeys(getFutureDate(health_effective_date));

    }

    public void applyBenefitChange(){
        waitForElementToBeDisplayed(benefitApplyChange);
        benefitApplyChange.click();
        waitForElementToBeDisplayed(healthBenefitOkButton);
        healthBenefitOkButton.click();
        waitForElementToBeDisplayed(healthBenefitOKPopup);
        healthBenefitOKPopup.click();
    }

   public void  applyBenefitManualProcess(){
       waitForElementToBeDisplayed(benefitProcessOKButton);
       benefitProcessOKButton.click();
       String Verifytext= driver.findElement(By.tagName("font")).getText().trim();
       Assert.assertEquals(Verifytext, "** null");
   }

   public boolean verifyBenefitApplied(String benefitvalue){
       if (employeehealthBenefitValue.getAttribute("value").equals(benefitvalue))

       {
           assertion = true;
           System.out.println(benefitvalue);
       }
       else if(!Objects.equals(employeehealthBenefitValue.getAttribute("value"), benefitvalue)){
           System.out.println("Doesnt Match");
       }
       return assertion;
   }

   public void selectHealthBenefitOptOut(int effect_date){
       waitForElementToBeDisplayed(healthBenefitEffectiveDate);
       healthBenefitEffectiveDate.sendKeys(getFutureDate(effect_date));
   }

   public void healthBenefitOptOut(){
       waitForElementToBeDisplayed(benefitOptOut);
       benefitOptOut.click();
       healthBenefitOkButton.click();
       healthBenefitOKPopup.click();
   }

<<<<<<< HEAD
    public void clickOTRequest() {
       waitForElementToBeDisplayed(logOverTimeRequest);
       logOverTimeRequest.click();
    }


    public void enterOverTimeDetails(int date, String hours) {

        waitTime(2000);
        System.out.println(getFutureDate(date));
        oTDate.sendKeys(getFutureDate(date) + TAB);
        System.out.println(hours);
        oTHours.sendKeys(hours);
    }

    public void submitOTRequest() {
       waitTime(1000);
       submit.click();
    }


    public boolean isOTSubmitted() {
        if ((driver.findElement(By.xpath("//div/span[contains(.,'Overtime Request has been created and sent for approval')]")).isDisplayed())) {
            acceptButton.click();
            return true;


        } else return false;
    }

    public void approveOTRequest() {
       waitForElementToBeDisplayed(approveOverTimeRequest);
       approveOverTimeRequest.click();

    }

    public void findOTRequest(int date, String username) {


        //div/table[contains(.,'Reject')]/tbody/tr//following::td[contains(.,'SR Hyderabad')][1]//following::td[contains(.,'2019-06-17')][1]//following::td[contains(.,'Approve')][1]/div/button[contains(.,'Approve')]

     System.out.println(username);
     WebElement otRequest =  driver.findElement(By.xpath("//div/table[contains(.,'Reject')]/tbody/tr/td[contains(.,'"+username+"')]//following::td[contains(.,'Approve')][1]/div/button[contains(.,'Reject')]"));
     WebElement otComment = driver.findElement(By.xpath("//div/table[contains(.,'Reject')]/tbody/tr/td[contains(.,'"+username+"')]//following::td[contains(.,'Approve')][1]/div/button[contains(.,'Reject')]/preceding::td/input"));
     otComment.sendKeys("Rejecting ot request");
     //div/table[contains(.,'Reject')]/tbody/tr//following::td[contains(.,'"+username+"')][1]//following::td[contains(.,'Approve')][1]/div/button[contains(.,'Approve')]
     System.out.println(otRequest);
     otRequest.click();
     waitTime(1000 );


    }

    public void createSicknessRequest() {
       waitForElementToBeDisplayed(sicknessAbsenceButton);
       sicknessAbsenceButton.click();
       waitTime(2000);

    }

    public void saveSicknessRequest() {
       saveSicknessButton.click();


    }

    public boolean isSicknessRequestCreaetd() {
        if ((driver.findElement(By.xpath("//div/span[contains(.,'Sickness Absence has been logged')]")).isDisplayed())) {
            okButton.click();
            waitTime(2000);
            return true;

        } else if ((driver.findElement(By.xpath("//div/span[contains(.,'Sickness Absence details have been updated.')]")).isDisplayed())) {
            okButton.click();
            waitTime(2000);
            return true;
        } else return false;
    }

    public void enterSicknessDetails(int date, String hours) {
       waitForElementToBeDisplayed(leaveStartDate);
       leaveStartDate.clear();
       leaveStartDate.sendKeys(getFutureDate(date)+TAB);
//       if (sicknessHours.isDisplayed()){
//           sicknessHours.sendKeys(hours);
//        }
//        else{
//           System.out.print("");
//       }
        try {
            sicknessHours.isDisplayed();
            System.out.print("Entering sickness hours for part time employee ");
            sicknessHours.sendKeys(hours);
        }catch (Exception e)
        {
            System.out.println("Given User is full time and can't enter sickness hours");
        }




    }

    public void submitSicknessDetails(int backtoWorkDate, String notes) {
       waitForElementToBeDisplayed(leaveStartDate);
       backToWorkDate.sendKeys(getFutureDate(backtoWorkDate)+TAB);
       sicknessNotes.sendKeys(notes);



    }

    public boolean isRTWRequiredForSickness() {
        if ((driver.findElement(By.xpath("//div/span[contains(.,'Error: : ')]")).isDisplayed())) {
            okButton.click();
            return true;


        } else return false;

    }

    public void clickRTWButton() {
       cRTWButton.click();
       waitTime(2000);
   }

    public void attachRTWDocument() throws FindFailed {

        String filepath = toAbsolutePath("src//test//resources//AttachingFilesImages//");
        String inputFilePath = toAbsolutePath("src//test//resources//AttachingFilesImages//");

        System.out.println ( filepath );
        System.out.println (inputFilePath  );


        Screen s = new Screen();
        Pattern fileInputTextBox = new Pattern(filepath +"//"+"FilePath.PNG");
        Pattern openButton = new Pattern(filepath + "//"+"OpenFile2.PNG");
        s.wait(fileInputTextBox, 20);
        s.type(fileInputTextBox, inputFilePath + "//"+"JobDescription.doc");
        s.click(openButton);
        System.out.println ( "Attachment Opened" );
        waitTime ( 5000 );
//        if (!fileAttached.getText ().isEmpty ())
//
//        {
//
//            System.out.println ( "Attachment Attached" );
//        }

    }


    public boolean documentUploadSuccessMsg() {
        if ((driver.findElement(By.xpath("//div/span[contains(.,'Document uploaded')]")).isDisplayed())) {
            okButton.click();
            return true;


        } else return false;

    }

    public boolean sicknessRequestCompleted() {

        if ((driver.findElement(By.xpath("//div/span[contains(.,'Sickness Absence details have been updated')]")).isDisplayed())) {
            okButton.click();
            return true;


        } else return false;
=======
    public void checkRequestDetails(int effe_date){

        waitForElementToBeDisplayed(effectiveDateCheckRequest);
        effectiveDateCheckRequest.sendKeys(getFutureDate(effe_date));
        okCheckRequest.click();

    }

    public void openEmployeeJobInformation(){
        waitForElementToBeDisplayed(employeeJobInformation);
        employeeJobInformation.click();
    }


    public boolean verifyContractTypeApplied(String val) {

        if (employeePayrollContract.getAttribute("value").equals(val))

        {
            assertion = true;
            System.out.println(val);


        }
        else if(!Objects.equals(employeePayrollContract.getAttribute("value"), val)){
            System.out.println("Benefit Doesn't Match");
        }
        return assertion;
    }

    public boolean verifyTimeValue(String vals){
        if (employeeTimeValue.getAttribute("value").equals(vals))

        {
            assertion = true;
            System.out.println(vals);


        }
        else if(!Objects.equals(employeeTimeValue.getAttribute("value"), vals)){
            System.out.println("Benefit Doesn't Match");
        }
        return assertion;
    }

    public void searchFullToPartTimeRequest(){


        WebElement bTable = driver.findElement(By.xpath("//div[@class='z-grid-body'][@style='overflow: auto; width: 1496px;']/table"));

        List<WebElement> rows = bTable.findElements(By.tagName("tr"));

        for(WebElement row: rows)

        {

            boolean x = row.findElement(By.xpath("//tr[@class='personal-changes-gridview z-row z-grid-odd']/td/span[text()='Sebastian Sims']")).isDisplayed();
            System.out.println("Found the row");

            if (x == true)

            {
                row.findElement(By.xpath("//td/span[text()='Full time to part time']"));
                System.out.println("The contract request has been found");

                break;
            }
        }
    }

   public void searchPartTimeChangeRequest(){
       WebElement basTable = driver.findElement(By.xpath("//div[@class='z-grid-body'][@style='overflow: auto; width: 1496px;']/table"));

       List<WebElement> rows = basTable.findElements(By.tagName("tr"));

       for(WebElement row: rows)

       {

           boolean x = row.findElement(By.xpath("//tr[@class='personal-changes-gridview z-row z-grid-odd']/td/span[text()='Maggie Campos']")).isDisplayed();
           System.out.println("Found the row");

           if (x == true)

           {
               row.findElement(By.xpath("//td/span[text()='Change in Part Time hours']"));
               System.out.println("The contract request has been found");

               break;
           }
       }
   }

   public void approvePartTimeChangeRequest(){
       WebElement contractRequest3 = driver.findElement(By.xpath("//tr[@class='personal-changes-gridview z-row z-grid-odd']/td/span[text()='Maggie Campos']/parent::td/parent::tr/td[3]/div[2]/button[text()='Approve']"));
       contractRequest3.click();

   }

    public boolean verifyPartTimeHours(String hours){

        if (employeeContractHours.getAttribute("value").equals(hours))

        {
            assertion = true;
            System.out.println(hours);


        }
        else if(!Objects.equals(employeeContractHours.getAttribute("value"), hours)){
            System.out.println("Benefit Doesn't Match");
        }
        return assertion;

>>>>>>> 4e1c505bb3f32c4e366af13677a902b4579c3c93
    }
}

