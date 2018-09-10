package co.uk.optum.pages.hr;

import co.uk.optum.utility.DriverProvider;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.hotkey.Keys;

import javax.inject.Inject;
import java.util.List;

import static co.uk.optum.utility.CommonUtility.*;
import static co.uk.optum.utility.FeatureContext.getStoredRequisitionNumber;

public class HRAdminHomePage {


    private WebDriver driver;

    @Inject
    public HRAdminHomePage() {
        this.driver = DriverProvider.driver;
        PageFactory.initElements ( driver, this );

    }

    @FindBy(xpath = "//span[contains(.,'Home')]")
    WebElement homeTab;

    @FindBy(xpath = "//tbody/tr/td[5]/button[@title='Menu']")
    WebElement menuIcon;

    @FindBy(xpath = "//div//tr/td/div/span [contains(.,'Human Resource & Payroll')]")
    WebElement hrpMenu;

    @FindBy(xpath = "//div//tr/td/div/span[3][contains(.,'Human Resource')]")
    WebElement hrMenu;

    @FindBy(xpath = "//div//tr/td/div/span[4][contains(.,'Requests')]")
    WebElement requestMenu;

    @FindBy(xpath = "//div//tr/td/div/a[contains (.,'On Boarding Request')]")
    WebElement onBoardingRequestMenu;

    @FindBy(xpath = "//div/ul/li[@class[contains(.,'z-tab-selected')]]/a/span[contains(.,'On Boarding Request')]")
    WebElement onBoardingRequestTab;

    @FindBy(xpath = "//div/ul/li[@class[contains(.,'z-tab-selected')]]/a/span[contains(.,'New Starter')]")
    WebElement newStarterCheckListTab;

    @FindBy(xpath = "//div/ul/li[@class[contains(.,'z-tab-selected')]]/a/span[contains(.,'Payroll ')]")
    WebElement payrollContractTab;

    @FindBy(xpath = "//div/a[@title[contains(.,'Lookup')]]/span[@class='z-toolbarbutton-content']/img[@src[contains(.,'Find24')]]")
    WebElement lookupRecordIcon;

    @FindBy(xpath = "//table/tbody/tr/td/div/div/input[@title='Textual summary of this request']")
    WebElement nprDocNumberlookupBox;

    @FindBy(xpath = "//table/tbody/tr/td[3]/div/button[@title='OK']")
    WebElement lookupRecordOkbutton;

    @FindBy(xpath = "(.//*[@class='z-borderlayout-icon z-icon-chevron-up'])[last()]")
    WebElement detailRecord;


    @FindBy(xpath = "//table//tr[ @class='adtab-grid z-row highlight']//button[@title='Open Payroll Contract Letter Window']")
    WebElement openPayrollContractLetter;

    @FindBy(xpath = "//div[text()='OpenWindow_PayrollContract']")
    WebElement openPayrollContractLetterWindow;


//    @FindBy(xpath = "//div[text()='OpenWindow_PayrollContract']")
//    WebElement openPayrollContractLetterWindow;

    @FindBy(xpath = "//div[@class='z-window-header z-window-header-move' and text()='Open New Starter Checklist Window']")
    WebElement openNewStarterChecklistWindow;

    @FindBy(xpath = "//div//button[@class='txt-btn btn-ok z-button']")
    WebElement okButton;

    @FindBy(xpath = "//div//table//button[@title='ContractLetterUploadProcess Description']")
    WebElement contractLetterUpload;

    @FindBy(xpath = "//table//tr[ @class='adtab-grid z-row highlight']//button[@title='This process will initialise the checklist and present the window to tick all the boxes.']")
    WebElement     openNewStarterCheckListWindowButton;


    @FindBy(xpath = "//div[text()='ContractLetterUploadProcess']")
    WebElement contractLetterUploadProcess;


    @FindBy (xpath = "//div/ul/li[@class[contains(.,'z-tab-selected')]]/a//div[@class='z-tab-button']/i")
    WebElement payrollContractClose;

    @FindBy(xpath = "//span[text()='Checklist']")
    WebElement checkListLink;

    @FindBy(xpath = "//div[@instancename='breadcrumb']//a[text()='New Starter Checklist']")
    WebElement newStarterCheckListLink;

    @FindBy(xpath = "//input[@instancename='HE_PERSON_CHECKLIST0HE_BANK_ACCOUNT_NAME']")
    WebElement accountName;

    @FindBy(xpath = "//input[@instancename='HE_PERSON_CHECKLIST0HE_BANK_ACCOUNT_NUMBER']")
    WebElement accountNumber;


//    HE_PERSON_CHECKLIST0HE_BANK_ACCOUNT_SORTCODE

    @FindBy(xpath = "//input[@instancename='HE_PERSON_CHECKLIST0HE_BANK_ACCOUNT_SORTCODE']")
    WebElement sortCode;

    @FindBy(xpath = "//span[@instancename='HE_PERSON_CHECKLIST0HE_RIGHT_TO_WORK_VERIFIED']/input")
    WebElement rightToWork;

    @FindBy(xpath = "//div//table//tr[@class='grid-layout adwindow-form z-row']//td//span[@title='Bank']//a[@class='z-combobox-button']//i[@class='z-combobox-icon z-icon-caret-down']")
    WebElement bankDropdown;


    @FindBy(xpath = "//button[@instancename='HE_PERSON_CHECKLIST0AD_CLEARED_TO_START_BUTTON']")
    WebElement clearedToStart;
    @FindBy(xpath = "//div[text()='CreateEmployeeInformation']")
    WebElement createEmpInfoPopup;

    @FindBy(xpath = "//span[@instancename='HE_PERSON_CHECKLIST0HR_Employee_ID']/input")
    WebElement payrollEmpGenerated;

    @FindBy(xpath = "//input[@instancename='HE_PERSON_CHECKLIST0UserName']")
    WebElement userName;





    public boolean isHRAdminHomeDisplayed() {

        waitForElementToBeDisplayed(homeTab);
        menuIcon.click ();
        waitForElementToBeDisplayed(hrpMenu);
        hrpMenu.click ();
        waitForElementToBeDisplayed(hrMenu);
        hrMenu.click ();
        waitForElementToBeDisplayed ( requestMenu );
        requestMenu.click ();
        waitForElementToBeDisplayed (onBoardingRequestMenu  );
        return onBoardingRequestMenu.isDisplayed ();



    }

    public void clickOnboardingRequest() {
        onBoardingRequestMenu.click ();
        waitForElementToBeDisplayed ( onBoardingRequestTab );

    }

    public void searchRequestToBeOnboarded() {

        waitForElementToBeDisplayed ( lookupRecordIcon );
        lookupRecordIcon.click ();
        waitForElementToBeDisplayed ( nprDocNumberlookupBox );
        waitTime ( 1000 );
        nprDocNumberlookupBox.sendKeys ( "RR:"+getStoredRequisitionNumber () );
//        nprDocNumberlookupBox.sendKeys ( "%"+"1003152"+"%" );


//        nprDocNumberlookupBox.sendKeys ( "1003065" );
        waitTime ( 3000 );
        lookupRecordOkbutton.click ();
        waitForElementToBeDisplayed ( onBoardingRequestTab );


    }

    public  void selectApplicantAndContinuePayrollContractLetter() throws Throwable {

//         //div[@class='z-grid-body z-word-nowrap']//table/tbody/tr//td//span[text()[contains(.,'"+ getStoredRequisitionNumber() +"')]]

//        "//div/table[contains(@id, 'cave')]/tbody/tr/td[3]/div[contains(.,'"+ customRequisitionNumber +"')]")

        String xpathstr1 = "//div[@class='z-grid-body z-word-nowrap']//table/tbody/tr//td//span[text()[contains(.,";
        String xpathstr2 = "'"+getStoredRequisitionNumber()+"')]]";
//        String xpathstr2 = "'"+1003152+"')]]";
        String xpath=xpathstr1+xpathstr2;
        System.out.println ( xpath );

        List<WebElement> elements = driver.findElements ( By.xpath ( xpath));

//        List<WebElement> shortlist = driver.findElements ( By.xpath ( "//div[@class='z-grid-body z-word-nowrap']//table/tbody/tr/td[@title='Edit Record']" ) );



        for(int i=0;i<elements.size ();i++)

        {
            int node = i + 1;
            String appSelect = "(" + xpath  + ")" + "[" + node + "]";
            waitTime ( 2000 );


            if (i==0)
            {

            }
            else  driver.findElement ( By.xpath ( appSelect ) ).click ();

            try {
                if (detailRecord.isDisplayed ()) {
                    detailRecord.click ();
                }

            }catch (Exception e)
            {

                repeatedCode();
//                driver.findElement ( By.xpath ( appSelect ) ).click ();
//                openNewStarterCheckListWindowButton.click ();
//                waitForElementToBeDisplayed ( openNewStarterChecklistWindow  );
//                okButton.click ();
//                waitForElementToBeDisplayed ( newStarterCheckListTab );

            }

            repeatedCode ();
//            driver.findElement ( By.xpath ( appSelect ) ).click ();
//            openNewStarterCheckListWindowButton.click ();
//            waitForElementToBeDisplayed ( openNewStarterChecklistWindow  );
//            okButton.click ();
//            waitForElementToBeDisplayed ( newStarterCheckListTab );


        }
        payrollContractClose.click ();




    }

    private void repeatedCode() throws Throwable {

        waitTime ( 1000 );
        openPayrollContractLetter.click();
        waitForElementToBeDisplayed (  openPayrollContractLetterWindow);
        okButton.click ();

        waitForElementToBeDisplayed ( payrollContractTab );
        System.out.println ( "payroll Contract Tab Opened" );
        contractLetterUpload.click();
        waitForElementToBeDisplayed (contractLetterUploadProcess  );
        okButton.click ();
        waitForAttachmentToBeHighlighted();
        payrollContractClose.click ();
        waitForElementToBeDisplayed ( openNewStarterCheckListWindowButton );

    }

    private void waitForAttachmentToBeHighlighted() throws  Throwable {

        waitTime (3000  );




    }

    public void selectApplicantAndContinueNewStarterChklist() {


        String xpathstr1 = "//div[@class='z-grid-body z-word-nowrap']//table/tbody/tr//td//span[text()[contains(.,";
        String xpathstr2 = "'"+getStoredRequisitionNumber()+"')]]";
//        1003130
//        String xpathstr2 = "'"+"1003152"+"')]]";
        String xpath=xpathstr1+xpathstr2;
        System.out.println ( xpath );

        List<WebElement> elements = driver.findElements ( By.xpath ( xpath));

//        List<WebElement> shortlist = driver.findElements ( By.xpath ( "//div[@class='z-grid-body z-word-nowrap']//table/tbody/tr/td[@title='Edit Record']" ) );



        for(int i=0;i<elements.size ();i++)

        {
            int node = i + 1;
            String appSelect = "(" + xpath  + ")" + "[" + node + "]";
            waitTime ( 2000 );


            if (i==0)
            {

            }
            else  driver.findElement ( By.xpath ( appSelect ) ).click ();

            try {
                if (detailRecord.isDisplayed ()) {
                    detailRecord.click ();
                }

            }catch (Exception e)
            {

                repeatedCode1();
//                driver.findElement ( By.xpath ( appSelect ) ).click ();
//                openNewStarterCheckListWindowButton.click ();
//                waitForElementToBeDisplayed ( openNewStarterChecklistWindow  );
//                okButton.click ();
//                waitForElementToBeDisplayed ( newStarterCheckListTab );

            }

            repeatedCode1 ();
//


    }

}

    private void repeatedCode1() {
        waitTime ( 1000 );
        openNewStarterCheckListWindowButton.click ();
        waitForElementToBeDisplayed (  openNewStarterChecklistWindow);
        okButton.click ();
        waitForElementToBeDisplayed ( newStarterCheckListTab );
        try {
            if (detailRecord.isDisplayed ()) {
                detailRecord.click ();
            }

        }catch (Exception e)
        {

            newStarterChkListRepeatedCode();

        }

        newStarterChkListRepeatedCode();

        Assert.assertTrue(" Payroll Emp Not Generated!!!",isPayrollEmpGenerated());




//        waitTime ( 1000 );
//        openPayrollContractLetter.click();
//        waitForElementToBeDisplayed (  openPayrollContractLetterWindow);
//        okButton.click ();
//
//        waitForElementToBeDisplayed ( payrollContractTab );
//        System.out.println ( "payroll Contract Tab Opened" );
//        contractLetterUpload.click();
//        waitForElementToBeDisplayed (contractLetterUploadProcess  );
//        okButton.click ();
//        waitForAttachmentToBeHighlighted();
//        payrollContractClose.click ();
//        waitForElementToBeDisplayed ( openNewStarterCheckListWindowButton );




    }

    private boolean isPayrollEmpGenerated() {


        System.out.println ( !payrollEmpGenerated.getAttribute ( "value" ).equals ( "" ) && ! userName.getAttribute ( "value" ).equals ( "" ) );

        return (
                !payrollEmpGenerated.getAttribute ( "value" ).equals ( "" ) && ! userName.getAttribute ( "value" ).equals ( "" )
                );




    }

    private void newStarterChkListRepeatedCode() {


            checkListLink.click ();
            waitForElementToBeDisplayed ( newStarterCheckListLink );
            accountName.sendKeys ( randomAccountName ( 12 ));
            waitTime(3000);
            sortCode.clear ();
            sortCode.sendKeys ( randomAccountNumber ( 6 ) );
            accountNumber.sendKeys ( randomAccountNumber ( 8 ));
            rightToWork.sendKeys ( "Applicant has permanent right to work in UK" + Keys.TAB );
            waitTime ( 1000 );
            clearedToStart.click ();
            waitForElementToBeDisplayed ( createEmpInfoPopup );
            okButton.click ();
            waitTime ( 20000 );
            payrollContractClose.click ();



    }

}
