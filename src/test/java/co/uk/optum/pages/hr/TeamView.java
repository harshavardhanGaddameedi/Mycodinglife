package co.uk.optum.pages.hr;

import co.uk.optum.utility.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.hotkey.Keys;

import javax.inject.Inject;
import java.util.List;

import static co.uk.optum.utility.CommonUtility.*;
import static co.uk.optum.utility.FeatureContext.setRequisitionNumber;

public class TeamView {

    private final WebDriver driver;


    @Inject
    public TeamView() {
        this.driver = DriverProvider.driver;
        PageFactory.initElements ( driver, this );
    }

    @FindBy(xpath = "//div/a[@title[contains(.,'Lookup')]]/span[@class='z-toolbarbutton-content']/img[@src[contains(.,'Find24')]]")
    WebElement lookupRecordIcon;


    @FindBy(xpath = "//table/tbody/tr/td/div/div/input[@instancename='subordinate']")
    WebElement lookupPosition;

    @FindBy(xpath = "//button[@title='OK']")
    WebElement okButton;

    @FindBy(xpath = ".//*[@class='z-borderlayout-icon z-icon-chevron-up']")
    WebElement detailRecord;

    @FindBy(xpath = "//div[@class='z-grid-body z-word-nowrap' ]//table//tr/td//input[@instancename='he_smj_teamview0subordinate']")
    WebElement searchReturned;

    @FindBy(xpath = "//div[@class='z-toolbar-content z-toolbar-start']//a//span//img[@src[contains(.,'EditRecord16')]]")
    WebElement editTeamMember;

    @FindBy(xpath = "//button[@instancename='he_smj_teamview_detail0he_button_manager']")
    WebElement openMgrWinOfEmp;

    @FindBy(xpath = "//div[text()='Open Manager Window of Employee']")
    WebElement openMgrWinOfEmpWindow;

    @FindBy(xpath = "//div//button[@class='txt-btn btn-ok z-button']")
    WebElement okButton1;


    @FindBy(xpath = "//div/ul/li[@class[contains(.,'z-tab-selected')]]/a/span[contains(.,'Manager View of Employee:')]")
    WebElement mngrViewOfEmpTab;

    @FindBy(xpath = "//div/ul/li[@class[contains(.,'z-tab-selected')]]/a/span[contains(.,'Leaver Request')]")
    WebElement leaverRequestTab;

    @FindBy(xpath = "//div/ul/li[@class[contains(.,'z-tab-selected')]]/a/span[contains(.,'Amend Details View')]")
    WebElement amendDetailsTab ;

    @FindBy(xpath="//button[ @instancename='he_manager_employee0he_change_emp_details'] ")
    WebElement 	changeEmployeeDetails ;

    @FindBy(xpath = "//button[ @instancename='he_manager_employee0start_leave_proc']")
    WebElement startLeaverProcessButton;


    @FindBy(xpath = "//span[@instancename='R_Request0he_leaving_reason']//input[@class='z-combobox-input']")
    WebElement reasonForLeavingDropdwon;

    @FindBy(xpath = "//span[@instancename='R_Request0he_termination_date']//input[@class='z-datebox-input']")
    WebElement terminationDate;

    @FindBy(xpath = "//*[@instancename='R_Request0he_eff_date']//input[@class='z-datebox-input']")
    WebElement effectiveDate;

    @FindBy(xpath = "//span[@instancename='R_Request0he_rea_for_ch']//input[@class='z-combobox-input']")
    WebElement reasonForChange ;

    @FindBy(xpath = "//span[@instancename='R_Request0HE_GRADE_SALARY_ID']//input[@class='z-combobox-input']")
    WebElement roleBandSalaryPoint;
    //div[@class='z-grid-body z-word-nowrap']//table[@id[contains(.,'-cave')]]//tr//td[3]//span[text()[contains(.,'Joe')]]/../span[text()[contains(.,'Burns')]]


    //div[@class='z-grid-body z-word-nowrap']//table[@id[contains(.,'-cave')]]//tr//td[3]//span[text()[contains(., 'Joe') and contains(., 'Burns')]]

    public void searchPositionAndEmpForLeaver(String positionName, String empName) {

        searchPosition(positionName);

        initiateLeaverProcess(empName);
        

    }

    public void searchPositionAndEmpForContract(String positionName, String empName)
    {
        searchPosition(positionName);
        initiateSalaryChange(empName);
    }

    private void initiateLeaverProcess(String empName) {

        System.out.println ( empName );

        //div[@class='z-grid-body z-word-nowrap']//table[@id[contains(.,'-cave')]]//tr//td[3]//span[text()[contains(., 'Joe') and contains(., 'Burns')]]

//        driver.findElement(By.xpath("//li/span["+ stringToContainsTag("Male")+"]")).click();

//        driver.findElement(By.xpath("//div[@class='z-grid-body z-word-nowrap']//table[@id[contains(.,'-cave')]]//tr//td[3]//span[text()["+ stringToContainsTag(empName)+"]]")).click();

        try {
            if (detailRecord.isDisplayed ()) {
                detailRecord.click ();
                waitTime(2000);
            }
        }catch (Exception e)
        {
            waitForElementToBeDisplayed (driver.findElement(By.xpath("//div[@class='z-grid-body z-word-nowrap']//table[@id[contains(.,'-cave')]]//tr//td[3]//span[text()["+ stringToContainsTag(empName)+"]]")));
            System.out.println ( driver.findElement(By.xpath("//div[@class='z-grid-body z-word-nowrap']//table[@id[contains(.,'-cave')]]//tr//td[3]//span[text()["+ stringToContainsTag(empName)+"]]")).getText () );
            driver.findElement(By.xpath("//div[@class='z-grid-body z-word-nowrap']//table[@id[contains(.,'-cave')]]//tr//td[3]//span[text()["+ stringToContainsTag(empName)+"]]")).click ();
            editTeamMember.click ();
            waitForElementToBeDisplayed ( openMgrWinOfEmp );
            openMgrWinOfEmp.click ();
            waitForElementToBeDisplayed ( openMgrWinOfEmpWindow );




        }

        waitTime(2000);
        waitForElementToBeDisplayed (driver.findElement(By.xpath("//div[@class='z-grid-body z-word-nowrap']//table[@id[contains(.,'-cave')]]//tr//td[3]//span[text()["+ stringToContainsTag(empName)+"]]")));
        System.out.println ( driver.findElement(By.xpath("//div[@class='z-grid-body z-word-nowrap']//table[@id[contains(.,'-cave')]]//tr//td[3]//span[text()["+ stringToContainsTag(empName)+"]]")).getText ());
        driver.findElement(By.xpath("//div[@class='z-grid-body z-word-nowrap']//table[@id[contains(.,'-cave')]]//tr//td[3]//span[text()["+ stringToContainsTag(empName)+"]]")).click ();
        editTeamMember.click ();
        waitForElementToBeDisplayed ( openMgrWinOfEmp );
        openMgrWinOfEmp.click ();
        waitForElementToBeDisplayed ( openMgrWinOfEmpWindow );


    }

    private void initiateSalaryChange(String empName) {

        System.out.println ( empName );

        //div[@class='z-grid-body z-word-nowrap']//table[@id[contains(.,'-cave')]]//tr//td[3]//span[text()[contains(., 'Joe') and contains(., 'Burns')]]

//        driver.findElement(By.xpath("//li/span["+ stringToContainsTag("Male")+"]")).click();

//        driver.findElement(By.xpath("//div[@class='z-grid-body z-word-nowrap']//table[@id[contains(.,'-cave')]]//tr//td[3]//span[text()["+ stringToContainsTag(empName)+"]]")).click();

        try {
            if (detailRecord.isDisplayed ()) {
                detailRecord.click ();
                waitTime(2000);
            }
        }catch (Exception e)
        {
            waitForElementToBeDisplayed (driver.findElement(By.xpath("//div[@class='z-grid-body z-word-nowrap']//table[@id[contains(.,'-cave')]]//tr//td[3]//span[text()["+ stringToContainsTag(empName)+"]]")));
            System.out.println ( driver.findElement(By.xpath("//div[@class='z-grid-body z-word-nowrap']//table[@id[contains(.,'-cave')]]//tr//td[3]//span[text()["+ stringToContainsTag(empName)+"]]")).getText () );
            driver.findElement(By.xpath("//div[@class='z-grid-body z-word-nowrap']//table[@id[contains(.,'-cave')]]//tr//td[3]//span[text()["+ stringToContainsTag(empName)+"]]")).click ();
            editTeamMember.click ();
            waitForElementToBeDisplayed ( openMgrWinOfEmp );
            openMgrWinOfEmp.click ();
            waitForElementToBeDisplayed ( openMgrWinOfEmpWindow );

        }

        waitTime(2000);
        waitForElementToBeDisplayed (driver.findElement(By.xpath("//div[@class='z-grid-body z-word-nowrap']//table[@id[contains(.,'-cave')]]//tr//td[3]//span[text()["+ stringToContainsTag(empName)+"]]")));
        System.out.println ( driver.findElement(By.xpath("//div[@class='z-grid-body z-word-nowrap']//table[@id[contains(.,'-cave')]]//tr//td[3]//span[text()["+ stringToContainsTag(empName)+"]]")).getText ());
        driver.findElement(By.xpath("//div[@class='z-grid-body z-word-nowrap']//table[@id[contains(.,'-cave')]]//tr//td[3]//span[text()["+ stringToContainsTag(empName)+"]]")).click ();
        editTeamMember.click ();
        waitForElementToBeDisplayed ( openMgrWinOfEmp );
        openMgrWinOfEmp.click ();
        waitForElementToBeDisplayed ( openMgrWinOfEmpWindow );


    }


    private void searchPosition(String positionName) {
        System.out.println ( positionName );
        lookupRecordIcon.click ();
        waitForElementToBeDisplayed ( lookupPosition );
        lookupPosition.sendKeys ( positionName );
        okButton.click ();
        waitTime(2000);
        List<WebElement> elements = driver.findElements ( By.xpath ( "//table//tr/td//input[@instancename='he_smj_teamview0subordinate']" ) );

        System.out.println ( elements.size () );


               if (elements.get ( 0 ).getAttribute ( "value" ).equals ( positionName ))
        {
            System.out.println ( "Search Successful" );

        }

        else
        {
            System.out.println ( "Search Failed" );

        }
    }

    public void startLeaverProcess() {

        okButton1.click ();
        waitForElementToBeDisplayed ( mngrViewOfEmpTab );
        startLeaverProcessButton.click ();
        waitForElementToBeDisplayed ( leaverRequestTab );

    }

    public void setLeaverDetails(String reason_for_leaving, int notice_period) {

        reasonForLeavingDropdwon.sendKeys ( reason_for_leaving.trim ()+ Keys.TAB );
        waitTime(2000);
        terminationDate.clear ();
        terminationDate.sendKeys ( getFutureDate(notice_period)+Keys.TAB );
        setRequisitionNumber(getFutureDate(notice_period));


    }

    public void OpenChangeEmployeeDetails()
    {
        okButton1.click ();
        waitForElementToBeDisplayed ( mngrViewOfEmpTab );
        changeEmployeeDetails.click();
        waitForElementToBeDisplayed ( amendDetailsTab );
    }


    public void setSalaryChangeDetails(String reason_for_change, int effective_date,String newSalaryPoint){
        waitForElementToBeDisplayed ( reasonForChange );
        reasonForChange.sendKeys(reason_for_change.trim ()+ Keys.TAB);
        waitTime(2000);
        effectiveDate.sendKeys(getFutureDate(effective_date)+Keys.TAB);
        roleBandSalaryPoint.clear ();
        roleBandSalaryPoint.sendKeys(newSalaryPoint.trim()+ Keys.TAB);

    }

    public void saveChanges() {

        waitTime(1000);
        List<WebElement> elements = driver.findElements ( By.xpath ( "//div[@class='adwindow-north z-div']/div/div/div[@class='z-toolbar-content z-toolbar-start']/a[@title[contains(., 'Save changes')]]/span[@class='z-toolbarbutton-content']/img[@src[contains(., 'Save')]]" ) );
        elements.get(elements.size ()-1).click ();
        waitTime(1000);



    }

    public boolean isSaveSuccessfull() {

        if (!reasonForLeavingDropdwon.getAttribute ( "value" ).equals ( "" ))
        {
            return  true;

        }

        else return  false;

    }
}
