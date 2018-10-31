package co.uk.optum.pages.hr;

import co.uk.optum.utility.DriverProvider;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import javax.inject.Inject;

import static co.uk.optum.utility.CommonUtility.*;
import static co.uk.optum.utility.FeatureContext.setPosistionName;
import static co.uk.optum.utility.FeatureContext.setRequisitionNumber;

//import org.sikuli.api.Screen;

public class NewPositionRequestPage {

    private final WebDriver driver;

    @Inject
    public NewPositionRequestPage() {
        this.driver = DriverProvider.driver;
        PageFactory.initElements ( driver, this );
    }

    @FindBy(xpath = "//div/a[@title[contains(.,'New')]]/span[@class='z-toolbarbutton-content']/img[@src[contains(.,'New24')]]")
    WebElement newToolbarIcon;

    @FindBy(xpath = "//div/ul/li[@class[contains(.,'z-tab-selected')]]/a/span[contains(.,'New Position Request')]")
    WebElement newPositionRequestTab;

    @FindBy(xpath = "//div//div//table//tr//td/textarea[@title='Textual summary of this request']")
    WebElement businessCase;

    @FindBy(xpath = "//div[@class='adwindow-north z-div']/div/div/div[@class='z-toolbar-content z-toolbar-start']/a[@title[contains(., 'Save changes')]]/span[@class='z-toolbarbutton-content']/img[@src[contains(., 'Save')]]")
    WebElement saveButton;

    //div[@class='adwindow-north z-div']/div/div/div[@class='z-toolbar-content z-toolbar-start']/a[@title[contains(., 'Save changes')]]/span[@class='z-toolbarbutton-content']/img[@src[contains(., 'Save')]]


    @FindBy(xpath = "//div//div//table//tr//td/span[@instancename='R_Request0he_pos_id']/a[@class='z-combobox-button']/i")
    WebElement posTemplateCombo;

    @FindBy(xpath = "//div//div//table//tr//td/span[@instancename='R_Request0he_pos_id']/input[@class='z-combobox-input']")
    WebElement posTemplateTxt;

    @FindBy(xpath = "//div//div[@class='adwindow-north z-div']//div/a/span/img[@src='/webui/theme/businessTeamBlue/images/Attachment24.png']")
    WebElement attachmentButton;


    @FindBy(xpath = "//div//div[@class='adwindow-north z-div']//div/a[@title='Attachment']/span")
    WebElement attachmentButton1;

    @FindBy(xpath = "//div[@class='z-borderlayout']")
    WebElement attachmentWindow;

    @FindBy(xpath = "//div//table//table//tr/td/button[@title='Load']")
    WebElement browseButton;


    @FindBy(xpath = "//div[@class='z-vlayout-inner']//table[@class='z-hbox']//tr//td[9]//span[@class='z-label']")
    WebElement   fileAttached;


    @FindBy(xpath = "//div//button[@title='OK']")
    WebElement attachmentOK;

    @FindBy(xpath = "//div//tr/td/span[@title='Request Status']/input")
    WebElement statusInput;


    @FindBy(xpath = "//div//div//table//tr//td/input[@title='Document sequence number of the document']")
    WebElement nprDocNumber;

    @FindBy(xpath = "//div//input[@instancename='R_Request0he_pos_name']")
    WebElement positionName;


    public void setBusinessCase(String business_case) {

        businessCase.sendKeys ( business_case );
        waitTime(5000);

    }

    public void clickNewToolbar() {
        waitForElementToBeDisplayed (newToolbarIcon  );
        newToolbarIcon.click ();




    }

    public void waitForNewPositionRequestTab() {
        waitForElementToBeDisplayed (newPositionRequestTab );
        System.out.println("Waiting for the new Position Request Tab" );
    }

    public void clickSaveButton() {

        saveButton.click();;
        waitTime(2000);





    }


    public void waitForElementEnablement() {
        //div//div//table//tr//td/span/input[@value='Specialist GP']
        waitForElementToBeDisplayed (newPositionRequestTab );
        //        waitForElementEnabled(posTemplateCombo);


    }

    public void setPosTemplate(String position_template)
    {

        posTemplateTxt.sendKeys ( position_template );
        posTemplateTxt.sendKeys ( Keys.TAB );
        waitTime ( 1000 );
        positionName.clear ();
        positionName.sendKeys ( position_template+"_"+randomAlphaNumeric ( 3 ) );



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
        s.type(fileInputTextBox, inputFilePath + "\\"+"JobDescription.doc");
        s.click(openButton);
        System.out.println ( "Attachment Opened" );
        waitTime ( 5000 );
        if (!fileAttached.getText ().isEmpty ())

        {

            System.out.println ( "Attachment Attached" );
        }
    }

    public void clickBrowseButton() {
        //div//table//table//tr/td/button[@title='Load']
        browseButton.click ();
        System.out.println ( "Browse Button Clicked" );
        waitTime ( 5000 );
        Screen screen = new Screen();
    }

    public void clickOK() {
        attachmentOK.click ();
        waitForElementToBeDisplayed ( newPositionRequestTab );




    }

    public void isJobDescAttached() {


    }

    public void statusInputClear() {
        waitForElementToBeDisplayed ( statusInput );
        statusInput.clear();

    }

    public void requestForApproveNPR(String status) {

        statusInput.sendKeys ( status );
        statusInput.sendKeys ( Keys.TAB );

    }

    public String NPRStatus() {

        return statusInput.getAttribute ( "value" );

    }

    public String getNPRDocNumber() {


        System.out.println ( nprDocNumber.getText () );
        setRequisitionNumber ( nprDocNumber.getAttribute ( "value" ) );
        System.out.println ( positionName.getText() );
        System.out.println ( positionName.getAttribute ("value") );
        setPosistionName(positionName.getAttribute ("value"));

        return nprDocNumber.getAttribute ( "value" );

    }


}
