package co.uk.optum.pages.hr;

import co.uk.optum.utility.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.hotkey.Keys;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import javax.inject.Inject;
import java.util.List;

import static co.uk.optum.utility.CommonUtility.*;
import static co.uk.optum.utility.FeatureContext.getStoredRequisitionNumber;

public class RecruitmentAdministratorPage {

    private WebDriver driver;

    @Inject
    public RecruitmentAdministratorPage() {
        this.driver = DriverProvider.driver;
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath = "//tbody/tr/td/table/tbody/tr/td[13]/a/span[contains(.,'Log Out')]")
    WebElement logoutLink;

    @FindBy(xpath = "//span[contains(.,'Home')]")
    WebElement homeTab;

    @FindBy(xpath = "//tbody/tr/td[5]/button[@title='Menu']")
    WebElement menuIcon;

    @FindBy(xpath = "//div//tr/td/div/span [contains(.,'Human Resource & Payroll')]")
    WebElement hrpMenu;

    @FindBy(xpath= "//div//tr/td/div/span[3][contains(.,'Human Resource')]")
    WebElement hrMenu;

    @FindBy(xpath= "//div//tr/td/div/span[4][contains(.,'Requests')]")
    WebElement requestMenu;


    @FindBy(xpath = "//div//tr/td/div/a[contains (.,'Recruitment Request')]")
    WebElement recruitmentRequestMenu;


    @FindBy(xpath = "//div//tr/td/div/a[contains (.,'Long Listing Criteria')]")
    WebElement longListingCriteria;

    @FindBy(xpath = "//div//tr/td/div/a[contains (.,'Short Listing Criteria')]")
    WebElement shortListingCriteria;

    @FindBy(xpath="//div//tr/td/div/a[contains (.,'Vacancy in Assessment')]")
    WebElement vacancyAssessmentMenu;

    @FindBy(xpath = "//div/a[@title[contains(.,'Lookup')]]/span[@class='z-toolbarbutton-content']/img[@src[contains(.,'Find24')]]")
    WebElement lookupRecordIcon;

    @FindBy(xpath = "//table/tbody/tr/td/div/div/input[@title='Document sequence number of the document']")
    WebElement nprDocNumberlookupBox;

    @FindBy(xpath = "//table/tbody/tr/td[3]/div/button[@title='OK']")
    WebElement lookupRecordOkbutton;

    @FindBy(xpath = "//div/ul/li[@class[contains(.,'z-tab-selected')]]/a/span[contains(.,'Recruitment Request')]")
    WebElement recruitmentRequestTab;

    @FindBy (xpath = "//div/ul/li[@class[contains(.,'z-tab-selected')]]/a//div[@class='z-tab-button']/i")
    WebElement recruitmentRequestTabClose;

    //div/ul/li[@class[contains(.,'z-tab-selected')]]/a//div[@class='z-tab-button']/i


    @FindBy(xpath = "//div/ul/li[@class[contains(.,'z-tab-selected')]]/a/span[contains(.,'Long Listing Criteria')]")
    WebElement longListingCriteriaTab;


    @FindBy(xpath = "//div/ul/li[@class[contains(.,'z-tab-selected')]]/a/span[contains(.,'Short Listing Criteria')]")
    WebElement shortListingCriteriaTab;




    @FindBy(xpath = "//div/ul/li[@class[contains(.,'z-tab-selected')]]/a/span[contains(.,'Vacancy in Assessment')]")
    WebElement vacancyAssessmentTab;


//    vacancyAssessmentTab

    @FindBy(xpath = "//div/ul/li[@class[contains(.,'z-tab-selected')]]/a/span[contains(.,'Applicant')]")
    WebElement applicantTab;

    @FindBy(xpath = "//div[@class='adwindow-north z-div']/div/div/div[@class='z-toolbar-content z-toolbar-start']/a[@title[contains(., 'Save changes')]]/span[@class='z-toolbarbutton-content']/img[@src[contains(., 'Save')]]")
    WebElement saveButton;

    @FindBy(xpath = "//div//tr/td/span[@title='Request Status']/input")
    WebElement statusInput;

    @FindBy(xpath = "//div//div[@class='adwindow-north z-div']//div/a/span/img[@src='/webui/theme/businessTeamBlue/images/Attachment24.png']")
    WebElement attachmentButton;

    @FindBy(xpath = "//div[@class='z-borderlayout']")
    WebElement attachmentWindow;

    @FindBy(xpath = "//div//table//table//tr/td/button[@title='Load']")
    WebElement browseButton;

    @FindBy(xpath = "//div//button[@title='OK']")
    WebElement attachmentOK;


    @FindBy(xpath = ".//*[@class='z-borderlayout-icon z-icon-chevron-up']")
    WebElement detailRecord;

    @FindBy(xpath = "//div[@class='adtab-form z-vlayout']//table//td/span[@instancename='he_person0he_pass_sl']/input[@type='checkbox']")
    WebElement shortlistCheck;

    @FindBy(xpath = ".//div//table//tr//td/a[@class='z-a']")
    WebElement request;


    @FindBy(xpath = "//div[@class='adtab-form z-vlayout']//table//td/span[@instancename='he_person0he_pass_test']/input[@type='checkbox']")
    WebElement passToNextStageCheck;


    @FindBy(xpath = "//div[@class='adtab-form z-vlayout']//table//td/span[@instancename='he_person0he_pass_to_int']/input[@type='checkbox']")
    WebElement passToInterviewCheck;

    @FindBy(xpath = "//div[@instancename='R_Request0he_date_onl_test']/span/input[@class='z-datebox-input']")
    WebElement maxDateOnlineAssessment;


    @FindBy(xpath = "//div[@instancename='R_Request0he_date_onl_test']/span/input[@class='z-timebox-input']")
    WebElement getMaxDateOnlineAssessmentTime;


    @FindBy(xpath = "//div//tr//td//a[text()='Ranking Interviews']")
    WebElement rankingInterviewsMenu;

    @FindBy(xpath = "//div/ul/li[@class[contains(.,'z-tab-selected')]]/a/span[contains(.,'Ranking Interviews')]")
    WebElement rankingInterviewsTab;

    @FindBy(xpath = "//div//table//tr/td/input[@instancename='he_person0he_nat_ins_no']")
    WebElement nationalInsuranceNumText;

    @FindBy(xpath = "//div//table//tr//td/span[@instancename='he_person0he_success']/input")
    WebElement outcomeOfInterview;

    @FindBy(xpath = "//div//table//tr//td/span[@instancename='he_person0he_gender']/input")
    WebElement genderDropdown;

    @FindBy(xpath = "//div//table//tr//td/span[@instancename='he_person0he_gender']/a")
    WebElement genderDropdownButton;

    @FindBy(xpath = "//div//button[@class='z-messagebox-button z-button']")
    WebElement okButton;





    public boolean isRecruitmentAdminDashBoardDisplayed() {
        waitForElementToBeDisplayed(homeTab);

        return homeTab.isDisplayed ();




    }

    public void searchRecruitmentRequest() {

        waitForElementToBeDisplayed ( lookupRecordIcon );
        lookupRecordIcon.click ();
        waitForElementToBeDisplayed ( nprDocNumberlookupBox );
        waitTime ( 1000 );
        nprDocNumberlookupBox.sendKeys ( getStoredRequisitionNumber () );

//        nprDocNumberlookupBox.sendKeys ( "1003024" );
        waitTime ( 3000 );
        lookupRecordOkbutton.click ();
    }

    public void waitForRecordToBeDisplayed() {

        waitForElementToBeDisplayed ( recruitmentRequestTab );
        System.out.println ( "recruitmentRequestTab Opened" );

    }

    public boolean isRecruitmentRequestOpenedForEditing() {

        return recruitmentRequestTab.isDisplayed ();


    }


    public void iClickRecruitmentRequest() {

        menuIcon.click ();
        waitForElementToBeDisplayed ( hrpMenu);
//        waitForElementToBeDisplayed ( hrpMenu);
        hrpMenu.click();
        waitForElementToBeDisplayed ( hrMenu);
        hrMenu.click();
        waitForElementToBeDisplayed ( requestMenu );
        requestMenu.click();
        waitForElementToBeDisplayed ( recruitmentRequestMenu );
        recruitmentRequestMenu.click();
        waitForElementToBeDisplayed ( recruitmentRequestTab );
        System.out.println ("newRecruitmentRequestTab Opened");
        waitTime ( 2000 );
    }

    public void changeRecruitmentRequestStatus(String status) {


        waitTime ( 2000 );
        moveElementToVisibility(statusInput);
        statusInput.clear ();
        statusInput.sendKeys ( status+ Keys.TAB);



    }

    public void clickSaveButton() {
        waitForElementToBeDisplayed ( recruitmentRequestTab );
        saveButton.click ();
        System.out.println ( "Status Saved" );

    }

    public boolean isRecruitmentRequestStatusAdvert() {

        return statusInput.getAttribute ( "value" ).equals ( "40_ Advert Placed" );



    }

    public boolean isRecruitmentRequestStatusGenerateAdvert() {
        return statusInput.getAttribute ( "value" ).equals ( "30_Generate Advert" );
    }

    public void clickAttachmentButton() {

        attachmentButton.click();
        waitForAttchmentWindow();

    }

    private void waitForAttchmentWindow() {

        waitForElementToBeDisplayed ( attachmentWindow );
        System.out.println ( "recognized the attachment popup" );
    }

    public void attachJobDesc() throws FindFailed {

        clickBrowseButton();
        String filepath = toAbsolutePath("src\\test\\resources\\AttachingFilesImages\\");
        String inputFilePath = toAbsolutePath("src\\test\\resources\\AttachingFilesImages\\");

        System.out.println ( filepath );
        System.out.println (inputFilePath  );


        Screen s = new Screen();
        Pattern fileInputTextBox = new Pattern(filepath +"\\"+"FilePath.PNG");
        Pattern openButton = new Pattern(filepath + "\\"+"OpenFile.PNG");
        s.wait(fileInputTextBox, 20);
        s.type(fileInputTextBox, inputFilePath + "\\"+"1_FullAplicationExample.xml");
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

    private void clickBrowseButton() {

        browseButton.click ();
        System.out.println ( "Browse Button Clicked" );
        waitTime ( 5000 );
        Screen screen = new Screen();

    }

    public void clickOK() {
        attachmentOK.click ();
        waitForElementToBeDisplayed ( recruitmentRequestTab );

    }

    public boolean isRecruitmentRequestVacancyClosed() {
        return statusInput.getAttribute ( "value" ).equals ( "50_Vacancy Closed" );


    }

    public boolean isRecruitmentRequestLongListing() {

//        55_Vacancy in Long Listing

        if (statusInput.getAttribute ( "value" ).equals ( "55_Vacancy in Long Listing" ))
        {
            System.out.println ( "Status Changed to 55_Vacancy in Long Listing " );
        }

        String statusActual = statusInput.getAttribute ( "value" );
        closeRecruitmentRequestTab();

        return statusActual.equals ( "55_Vacancy in Long Listing" );
    }

    public void closeRecruitmentRequestTab() {

    recruitmentRequestTabClose.click ();
    }


    public void iClickLongListingMenu() {

       menuIcon.click ();
//        waitForElementToBeDisplayed ( hrpMenu);
////        waitForElementToBeDisplayed ( hrpMenu);
//        hrpMenu.click();
//        waitForElementToBeDisplayed ( hrMenu);
//        hrMenu.click();
//        waitForElementToBeDisplayed ( requestMenu );
//        requestMenu.click();
        waitForElementToBeDisplayed ( longListingCriteria );
        longListingCriteria.click();
        waitForElementToBeDisplayed ( longListingCriteriaTab );
        waitTime ( 2000 );

    }

    public boolean isLongListingCriteriaPageDisplayed() {

        return longListingCriteriaTab.isDisplayed ();
    }

    public boolean isRecruitmentRequestOpenedForLongListing() {


//        detailRecord.click();
        waitTime ( 1000 );
        return (longListingCriteriaTab.isDisplayed ()&& applicantTab.isDisplayed ());

    }

    public void shortListApplicants() {


        List<WebElement> elements = driver.findElements ( By.xpath ( "//div[@class='z-grid-body z-word-nowrap']//table/tbody/tr//td//span[text()[contains(.,'AR-')]]" ) );
        List<WebElement> shortlist = driver.findElements ( By.xpath ( "//div[@class='z-grid-body z-word-nowrap']//table/tbody/tr/td[@title='Edit Record']" ) );
        for(int i=0;i<elements.size ();i++)

        {
            int node = i + 1;
            String appSelect= "("+"//div[@class='z-grid-body z-word-nowrap']//table/tbody/tr//td//span[text()[contains(.,'AR-')]]"+")"+"["+node+"]";
            waitTime ( 2000 );
            driver.findElement(By.xpath(appSelect)).click ();
                   for (int j=0;j<shortlist.size ();j++) {

                    if (j==i)
                    {


                        int node1 = j + 1;
                        String editRec ="("+"//div[@class='z-grid-body z-word-nowrap']//table/tbody/tr/td[@title='Edit Record']"+")"+"["+node1+"]";
                        waitTime ( 2000 );
                        driver.findElement(By.xpath(editRec)).click ();



                    }
                }

            waitForElementToBeDisplayed ( shortlistCheck );
            shortlistCheck.click ();
            saveButton.click ();
            waitTime ( 1000 );
            request.click ();
            waitForElementToBeDisplayed ( longListingCriteriaTab );

        }




//        //div[@class='z-grid-body z-word-nowrap']//table/tbody/tr//td//span[text()[contains(.,'AR-')]]


    }

    public boolean isRecruitmentRequestShortListng() {

        if (statusInput.getAttribute ( "value" ).equals ( "60_Vacancy in short listing" ))
        {
            System.out.println ( "Status Changed to 60_Vacancy in short listing " );
        }

        String statusActual = statusInput.getAttribute ( "value" );
        closeRecruitmentRequestTab();

        return statusActual.equals ( "60_Vacancy in short listing" );

    }

    public void saveLongListingRec() {

        waitForElementToBeDisplayed ( longListingCriteriaTab );
        saveButton.click ();
        System.out.println ( "Status Saved" );

    }

    public void iClickShortListingMenu() {


        menuIcon.click ();
//        waitForElementToBeDisplayed ( hrpMenu);
////        waitForElementToBeDisplayed ( hrpMenu);
//        hrpMenu.click();
//        waitForElementToBeDisplayed ( hrMenu);
//        hrMenu.click();
//        waitForElementToBeDisplayed ( requestMenu );
//        requestMenu.click();
        waitForElementToBeDisplayed ( shortListingCriteria );
        shortListingCriteria.click();
        waitForElementToBeDisplayed ( shortListingCriteriaTab );
        waitTime ( 2000 );


    }

    public boolean isRecruitmentRequestOpenedForShortListing() {

        waitTime ( 1000 );
        try {
            if (detailRecord.isDisplayed ()) {
                detailRecord.click ();
            }
        }catch (Exception e){return (shortListingCriteriaTab.isDisplayed ()&& applicantTab.isDisplayed ());}
//    return (shortListingCriteriaTab.isDisplayed ()&& applicantTab.isDisplayed ());    return (shortListingCriteriaTab.isDisplayed ()&& applicantTab.isDisplayed ());
        return (shortListingCriteriaTab.isDisplayed ()&& applicantTab.isDisplayed ());



    }

    public boolean isShortListingCriteriaPageDisplayed() {

        return shortListingCriteriaTab.isDisplayed ();
    }

    public void passApplicantstoVacancyInAssessment() {

        waitTime ( 2000 );
        List<WebElement> elements = driver.findElements ( By.xpath ( "//div[@class='z-grid-body z-word-nowrap']//table/tbody/tr//td//span[text()[contains(.,'AR-')]]" ) );
        List<WebElement> shortlist = driver.findElements ( By.xpath ( "//div[@class='z-grid-body z-word-nowrap']//table/tbody/tr/td[@title='Edit Record']" ) );
        for(int i=0;i<elements.size ();i++)

        {
            int node = i + 1;
            String appSelect= "("+"//div[@class='z-grid-body z-word-nowrap']//table/tbody/tr//td//span[text()[contains(.,'AR-')]]"+")"+"["+node+"]";
            waitTime ( 2000 );
            driver.findElement(By.xpath(appSelect)).click ();
            for (int j=0;j<shortlist.size ();j++) {
                if (j==i)
                {
                    int node1 = j + 1;
                    String editRec ="("+"//div[@class='z-grid-body z-word-nowrap']//table/tbody/tr/td[@title='Edit Record']"+")"+"["+node1+"]";
                    waitTime ( 2000 );
                    driver.findElement(By.xpath(editRec)).click ();
                }
            }

            waitForElementToBeDisplayed ( passToNextStageCheck );
            passToNextStageCheck.click ();
            saveButton.click ();
            waitTime ( 1000 );
            request.click ();
            waitForElementToBeDisplayed ( shortListingCriteriaTab );

        }

    }
    public void saveShortListingRec() {
        waitForElementToBeDisplayed ( shortListingCriteriaTab );
        saveButton.click ();
        System.out.println ( "Status Saved" );

    }

    public boolean isRecruitmentRequestVacancyInAssessment() {

        if (statusInput.getAttribute ( "value" ).equals ( "70_Vacancy in Assessment" ))
        {
            System.out.println ( "Status Changed to 70_Vacancy in Assessment " );
        }

        String statusActual = statusInput.getAttribute ( "value" );
        closeRecruitmentRequestTab();

        return statusActual.equals ( "70_Vacancy in Assessment" );


    }

    public void iClickVacancyAssessmentMenu() {

        menuIcon.click ();
        waitForElementToBeDisplayed ( vacancyAssessmentMenu );
        vacancyAssessmentMenu.click ();
        waitForElementToBeDisplayed ( maxDateOnlineAssessment );
    }

    public boolean isVacancyAssessmentPageOpened() {

        return maxDateOnlineAssessment.isDisplayed () && getMaxDateOnlineAssessmentTime.isDisplayed ();
    }

    public boolean isVacancyAssessmentPageOpenedForEditing() {
        return maxDateOnlineAssessment.isDisplayed () && getMaxDateOnlineAssessmentTime.isDisplayed ();
    }

    public void saveMaxDateOnlineTestDate(int i) {

        maxDateOnlineAssessment.clear();
        maxDateOnlineAssessment.sendKeys(getFutureDate(i));
        saveButton.click ();
    }

    public void passApplicantsToInterviewStage() {


//        waitForElementToBeDisplayed (  statusInput);
        waitTime ( 2000 );

        try {
            if (detailRecord.isDisplayed ()) {
                detailRecord.click ();
            }
        }catch (Exception e){
            List<WebElement> elements = driver.findElements ( By.xpath ( "//div[@class='z-grid-body z-word-nowrap']//table/tbody/tr//td//span[text()[contains(.,'AR-')]]" ) );
            List<WebElement> shortlist = driver.findElements ( By.xpath ( "//div[@class='z-grid-body z-word-nowrap']//table/tbody/tr/td[@title='Edit Record']" ) );
            for(int i=0;i<elements.size ();i++)

            {
                int node = i + 1;
                String appSelect= "("+"//div[@class='z-grid-body z-word-nowrap']//table/tbody/tr//td//span[text()[contains(.,'AR-')]]"+")"+"["+node+"]";
                waitTime ( 2000 );
                driver.findElement(By.xpath(appSelect)).click ();
                for (int j=0;j<shortlist.size ();j++) {
                    if (j==i)
                    {
                        int node1 = j + 1;
                        String editRec ="("+"//div[@class[@class='z-grid-body z-word-nowrap']//table/tbody/tr/td[@title='Edit Record']"+")"+"["+node1+"]";
                        waitTime ( 2000 );
                        driver.findElement(By.xpath(editRec)).click ();
                    }
                }

                waitForElementToBeDisplayed ( passToInterviewCheck );
                passToInterviewCheck.click ();
                saveButton.click ();
                waitTime ( 1000 );
                request.click ();
                waitForElementToBeDisplayed ( vacancyAssessmentTab );

            }

        }


        List<WebElement> elements = driver.findElements ( By.xpath ( "//div[@class='z-grid-body z-word-nowrap']//table/tbody/tr//td//span[text()[contains(.,'AR-')]]" ) );
        List<WebElement> shortlist = driver.findElements ( By.xpath ( "//div[@class='z-grid-body z-word-nowrap']//table/tbody/tr/td[@title='Edit Record']" ) );
        for(int i=0;i<elements.size ();i++)

        {
            int node = i + 1;
            String appSelect= "("+"//div[@class='z-grid-body z-word-nowrap']//table/tbody/tr//td//span[text()[contains(.,'AR-')]]"+")"+"["+node+"]";
            waitTime ( 2000 );
            driver.findElement(By.xpath(appSelect)).click ();
            for (int j=0;j<shortlist.size ();j++) {
                if (j==i)
                {
                    int node1 = j + 1;
                    String editRec ="("+"//div[@class='z-grid-body z-word-nowrap']//table/tbody/tr/td[@title='Edit Record']"+")"+"["+node1+"]";
                    waitTime ( 2000 );
                    driver.findElement(By.xpath(editRec)).click ();
                }
            }

            waitForElementToBeDisplayed ( passToInterviewCheck );
            passToInterviewCheck.click ();
            saveButton.click ();
            waitTime ( 1000 );
            request.click ();
            waitForElementToBeDisplayed ( vacancyAssessmentTab );

        }



    }

    public boolean isRecruitmentRequestOpenedForEnterningAssesmentDetails() {

        waitTime ( 1000 );
        try {
            if (detailRecord.isDisplayed ()) {
                detailRecord.click ();
            }
        }catch (Exception e){return (applicantTab.isDisplayed ());}
        return ( applicantTab.isDisplayed ());



    }



    public boolean isRecruitmentRequestStatusInterview() {


        if (statusInput.getAttribute ( "value" ).equals ( "71_Interviews" ))
        {
            System.out.println ( "Status Changed to 71_Interviews " );
        }

        String statusActual = statusInput.getAttribute ( "value" );
        closeRecruitmentRequestTab();

        return statusActual.equals ( "71_Interviews" );



    }

    public void changeRecruitmentRequestStatusInterview(String status) {

                  recruitmentRequestTabClose.click ();
                  menuIcon.click ();
                  waitForElementToBeDisplayed (recruitmentRequestMenu  );
                  recruitmentRequestMenu.click ();
                  waitForElementToBeDisplayed ( recruitmentRequestTab );
                  searchRecruitmentRequest ();
                  waitForElementToBeDisplayed ( recruitmentRequestTab );
                  changeRecruitmentRequestStatus(status);
                  saveButton.click ();

    }

    public void iClickRankingInterviewMenu() {

        menuIcon.click ();
        waitForElementToBeDisplayed ( rankingInterviewsMenu );
        rankingInterviewsMenu.click ();
        waitForElementToBeDisplayed ( rankingInterviewsTab );




    }

    public boolean isRankingInterviewPageOpened() {

        return rankingInterviewsTab.isDisplayed ();

    }

    public boolean isRankingPageOpenedForRanking() {


        waitTime ( 1000 );
        try {
            if (detailRecord.isDisplayed ()) {
                detailRecord.click ();
            }
        }catch (Exception e){return (rankingInterviewsTab.isDisplayed () && applicantTab.isDisplayed ());}

        return (rankingInterviewsTab.isDisplayed () && applicantTab.isDisplayed ());

    }

    public void passApplicantsFromRankingStage() {

        waitTime ( 1000 );
        try {
            if (detailRecord.isDisplayed ()) {
                detailRecord.click ();
            }
        }catch (Exception e)
        {
            List<WebElement> elements = driver.findElements ( By.xpath ( "//div[@class='z-grid-body z-word-nowrap']//table/tbody/tr//td//span[text()[contains(.,'AR-')]]" ) );
            List<WebElement> shortlist = driver.findElements ( By.xpath ( "//div[@class='z-grid-body z-word-nowrap']//table/tbody/tr/td[@title='Edit Record']" ) );
            for(int i=0;i<elements.size ();i++)

            {
                int node = i + 1;
                String appSelect= "("+"//div[@class='z-grid-body z-word-nowrap']//table/tbody/tr//td//span[text()[contains(.,'AR-')]]"+")"+"["+node+"]";
                waitTime ( 2000 );
                driver.findElement(By.xpath(appSelect)).click ();
                for (int j=0;j<shortlist.size ();j++) {
                    if (j==i)
                    {
                        int node1 = j + 1;
                        String editRec ="("+"//div[@class[@class='z-grid-body z-word-nowrap']//table/tbody/tr/td[@title='Edit Record']"+")"+"["+node1+"]";
                        waitTime ( 2000 );
                        driver.findElement(By.xpath(editRec)).click ();
                    }
                }
                waitForElementToBeDisplayed ( nationalInsuranceNumText );
                String nationalInsNum= "NIN"+ randomAlphaNumeric ( 6 );
                nationalInsuranceNumText.sendKeys ( nationalInsNum );
//                genderDropdown.clear ();
//                genderDropdownButton.click ();
//                waitForElementToBeDisplayed ( driver.findElement(By.xpath("//li/span["+ stringToContainsTag("Male")+"]"))) ;
                genderDropdown.clear ();
                genderDropdown.sendKeys ( "Male"+Keys.TAB );
                waitTime ( 1000 );
//                driver.findElement(By.xpath("//li/span["+ stringToContainsTag("Male")+"]")).click();
//                waitTime ( 3000 );
//                /*
                outcomeOfInterview.clear();
                waitTime ( 1000 );
                outcomeOfInterview.sendKeys ( "Successful"+ Keys.TAB );
                waitTime ( 1000 );
                saveButton.click ();
                waitTime ( 2000 );
                if (genderDropdown.getAttribute ( "value" ).equals ( "Male" ))

                {
                    request.click ();
                    waitForElementToBeDisplayed ( applicantTab );

                }
                else
                {
                    genderDropdown.sendKeys ( "Male"+Keys.TAB );
                    saveButton.click ();
                    waitTime ( 2000 );
                }
                request.click ();
                waitForElementToBeDisplayed ( applicantTab );



            }

        }


        List<WebElement> elements = driver.findElements ( By.xpath ( "//div[@class='z-grid-body z-word-nowrap']//table/tbody/tr//td//span[text()[contains(.,'AR-')]]" ) );
        List<WebElement> shortlist = driver.findElements ( By.xpath ( "//div[@class='z-grid-body z-word-nowrap']//table/tbody/tr/td[@title='Edit Record']" ) );
        for(int i=0;i<elements.size ();i++)

        {
            int node = i + 1;
            String appSelect= "("+"//div[@class='z-grid-body z-word-nowrap']//table/tbody/tr//td//span[text()[contains(.,'AR-')]]"+")"+"["+node+"]";
            waitTime ( 2000 );
            driver.findElement(By.xpath(appSelect)).click ();
            for (int j=0;j<shortlist.size ();j++) {
                if (j==i)
                {
                    int node1 = j + 1;
                    String editRec ="("+"//div[@class='z-grid-body z-word-nowrap']//table/tbody/tr/td[@title='Edit Record']"+")"+"["+node1+"]";
                    waitTime ( 2000 );
                    driver.findElement(By.xpath(editRec)).click ();
                }
            }
            waitForElementToBeDisplayed ( nationalInsuranceNumText );
            String nationalInsNum= "NIN"+ randomAlphaNumeric ( 6 );
            nationalInsuranceNumText.sendKeys ( nationalInsNum );
//                genderDropdown.clear ();
            genderDropdown.clear ();
            genderDropdown.sendKeys ( "Male"+Keys.TAB );
            waitTime ( 1000 );
            outcomeOfInterview.clear();
            waitTime ( 1000 );
            outcomeOfInterview.sendKeys ( "Successful"+ Keys.TAB );
            waitTime ( 1000 );
            saveButton.click ();
            waitTime ( 2000 );
            if (genderDropdown.getAttribute ( "value" ).equals ( "Male" ))

            {
                request.click ();
                waitForElementToBeDisplayed ( applicantTab );

            }
            else
            {
                genderDropdown.sendKeys ( "Male"+Keys.TAB );
                saveButton.click ();
                waitTime ( 2000 );
            }



            request.click ();
            waitForElementToBeDisplayed ( applicantTab );

        }




    }

    public void saveRankingPage() {

        saveButton.click ();
        waitForElementToBeDisplayed ( okButton );
        okButton.click();
        waitForElementToBeDisplayed ( rankingInterviewsTab );
    }

    public boolean isRecruitmentRequestStatusUnderOffer() {


        if (statusInput.getAttribute ( "value" ).equals ( "72_Under offer" ))
        {
            System.out.println ( "Status Changed to 72_Under offer " );
        }

        String statusActual = statusInput.getAttribute ( "value" );
        closeRecruitmentRequestTab();

        return statusActual.equals ( "72_Under offer" );




    }
}
