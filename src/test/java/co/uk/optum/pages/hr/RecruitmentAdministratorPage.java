package co.uk.optum.pages.hr;

import co.uk.optum.utility.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.hotkey.Keys;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import javax.inject.Inject;

import static co.uk.optum.utility.CommonUtility.*;

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


    @FindBy(xpath = "//div/a[@title[contains(.,'Lookup')]]/span[@class='z-toolbarbutton-content']/img[@src[contains(.,'Find24')]]")
    WebElement lookupRecordIcon;

    @FindBy(xpath = "//table/tbody/tr/td/div/div/input[@title='Document sequence number of the document']")
    WebElement nprDocNumberlookupBox;

    @FindBy(xpath = "//table/tbody/tr/td[3]/div/button[@title='OK']")
    WebElement lookupRecordOkbutton;

    @FindBy(xpath = "//div/ul/li[@class[contains(.,'z-tab-selected')]]/a/span[contains(.,'Recruitment Request')]")
    WebElement recruitmentRequestTab;

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





    public boolean isRecruitmentAdminDashBoardDisplayed() {
        waitForElementToBeDisplayed(homeTab);

        return homeTab.isDisplayed ();




    }

    public void searchRecruitmentRequest() {

        waitForElementToBeDisplayed ( lookupRecordIcon );
        lookupRecordIcon.click ();
        waitForElementToBeDisplayed ( nprDocNumberlookupBox );
        waitTime ( 1000 );
//        nprDocNumberlookupBox.sendKeys ( getStoredRequisitionNumber () );
        nprDocNumberlookupBox.sendKeys ( "1002897" );
//        waitTime ( 3000 );
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


//        waitTime ( 2000 );
        moveElementToVisibility(statusInput);
        statusInput.clear ();
        statusInput.sendKeys ( status+ Keys.TAB);
        waitTime ( 2000 );

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
}
