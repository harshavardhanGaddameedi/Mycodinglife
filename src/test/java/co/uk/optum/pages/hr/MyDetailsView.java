package co.uk.optum.pages.hr;

import co.uk.optum.utility.DriverProvider;
import org.apache.http.util.TextUtils;
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

import static co.uk.optum.utility.CommonUtility.*;
import static co.uk.optum.utility.FeatureContext.getStoredRequisitionNumber;
import static co.uk.optum.utility.FeatureContext.setRequisitionNumber;

public class MyDetailsView {


    private final WebDriver driver;
    public String midName;

    @Inject
    public MyDetailsView() {
        this.driver = DriverProvider.driver;
        PageFactory.initElements ( driver, this );
    }

    @FindBy(xpath = ".//span[@instancename='he_detail_view0he_change_status']//a[@class='z-combobox-button']/i")
    WebElement kindOfUpdate;

    @FindBy(xpath = ".//input[@class='z-datebox-input']")
    WebElement effDateText;

    @FindBy(xpath = ".//input[@instancename='he_detail_view0he_firstname']")
    WebElement fstName;

    @FindBy(xpath = ".//input[@instancename='he_detail_view0he_lastname']")
    WebElement lstName;

    @FindBy(xpath = ".//input[@instancename='he_detail_view0he_middlename']")
    WebElement middleName;

    @FindBy(xpath = "//div[@class='adwindow-north z-div']/div/div/div[@class='z-toolbar-content z-toolbar-start']/a[@title[contains(., 'Save changes')]]/span[@class='z-toolbarbutton-content']/img[@src[contains(., 'Save')]]")
    WebElement saveButton;


    @FindBy(xpath = "//div//button[@title='OK']")
    WebElement attachmentOK;

    @FindBy(xpath = "//div/ul/li[@class[contains(.,'z-tab-selected')]]/a/span[contains(.,'My Details View')]")
    WebElement myDetailsViewTab;

    @FindBy(xpath = "//div//div[@class='adwindow-north z-div']//div/a/span/img[@src='/webui/theme/businessTeamBlue/images/Attachment24.png']")
    WebElement attachmentButton;


    @FindBy(xpath = "//div[@class='z-borderlayout']")
    WebElement attachmentWindow;

    @FindBy(xpath = "//div//table//table//tr/td/button[@title='Load']")
    WebElement browseButton;

    @FindBy(xpath = "//div[@class='z-vlayout-inner']//table[@class='z-hbox']//tr//td[9]//span[@class='z-label']")
    WebElement   fileAttached;

    @FindBy(xpath = "//input[@title='Search key for the record in the format required - must be unique']")
    WebElement empID;


    @FindBy(xpath = "//span[@instancename='he_detail_view0C_Bank_ID']/input")
    WebElement bankNameTxt;

    @FindBy(xpath = "//input[@instancename= 'he_detail_view0HE_BANK_ACCOUNT_NAME']")
    WebElement acctNameTxt;

    @FindBy(xpath = "//input[@instancename= 'he_detail_view0HE_BANK_ACCOUNT_NUMBER']")
    WebElement acctNumberTxt;

    @FindBy(xpath = "//input[@instancename[contains(.,'HE_BANK_ACCOUNT_SORTCODE')]]")
    WebElement sortCodeTxt;

    @FindBy(xpath = "//span[@instancename='he_detail_view0he_gender']//input")
    WebElement genderTxt;


    @FindBy(xpath = "//div//table//tr//td/span[@instancename='he_detail_view0he_gender']/a/i")
    WebElement genderDropdown;


    @FindBy(xpath = "//span[@instancename='he_detail_view0he_sex_orient']//input")
    WebElement sexualOrientationTxt;

    @FindBy(xpath = "//span[@instancename='he_detail_view0he_disability']//input")
    WebElement disabilityTxt;


    public void selectKindOfUpdate(String update_my_name) {

        clickKindOfUpdate();
        waitForElementToBeDisplayed ( driver.findElement( By.xpath("//li/span["+ stringToContainsTag(update_my_name)+"]"))) ;
        driver.findElement(By.xpath("//li/span["+ stringToContainsTag(update_my_name)+"]")).click();
        waitTime ( 1000 );

    }

    private void clickKindOfUpdate() {

        kindOfUpdate.click();
//        waitTime(2000);

    }

    public void waitForKindOfUpdateDropdown() {
        waitForElementToBeDisplayed (kindOfUpdate  );
    }

    public void enterEffDate() {


        effDateText.clear();
        effDateText.sendKeys(getFutureDate(0));
//        waitTime (10000 );
    }

    public boolean  areNameFieldsEditable() {
//        System.out.println ( fstName.getAttribute ( "readonly" ));
//        System.out.println ( lstName.getAttribute ( "readonly" ));
//        System.out.println ( middleName.getAttribute ( "readonly" ));

       if ( TextUtils.isEmpty(fstName.getAttribute ( "readonly" )) &&
               TextUtils.isEmpty(lstName.getAttribute ( "readonly" )) &&
               TextUtils.isEmpty(middleName.getAttribute ( "readonly" ))
           )
       {
           System.out.println("Editable");
           return  true;
       }
       else {
           System.out.println("Not Editable");
           return  false;
       }


    }

    public void editTheNameFileds() {
        middleName.clear ();
        midName = randomAccountName(6);
        setRequisitionNumber(midName);
        middleName.sendKeys ( midName );
    }

    public void clickSave() {

        saveButton.click ();
        waitTime (3000 );
    }

    public void clickOKButton() {

        attachmentOK.click();
        waitForElementToBeDisplayed ( myDetailsViewTab );
        waitTime ( 2000 );

    }


    public void clickAttachmentButton() {

        attachmentButton.click();
        waitForAttchmentWindow();


    }

    private void waitForAttchmentWindow() {
        waitForElementToBeDisplayed ( attachmentWindow );
        System.out.println ( "recognized the attachment popup" );


    }

    public void attachProofOfNameChange() throws FindFailed {

        clickBrowseButton();
        String filepath = toAbsolutePath("src//test//resources//AttachingFilesImages//");
        String inputFilePath = toAbsolutePath("src//test//resources//AttachingFilesImages//");

        System.out.println ( filepath );
        System.out.println (inputFilePath  );


        Screen s = new Screen();
        Pattern fileInputTextBox = new Pattern(filepath +"//"+"FilePath.PNG");
        Pattern openButton = new Pattern(filepath + "//"+"OpenFile.PNG");
        s.wait(fileInputTextBox, 20);
        s.type(fileInputTextBox, inputFilePath + "//"+"Proof.doc");
        s.click(openButton);
        System.out.println ( "Attachment Opened" );
        waitTime ( 5000 );
        if (!fileAttached.getText ().isEmpty ())

        {

            System.out.println ( "Attachment Attached" );
        }
    }

    private void clickBrowseButton() {

        browseButton.click ();
        System.out.println ( "Browse Button Clicked" );
        waitTime ( 5000 );
        Screen screen = new Screen();

    }

    public boolean isSaveSuccessfull() {

        String expected = getStoredRequisitionNumber();

        //input[@title='Search key for the record in the format required - must be unique']
        setRequisitionNumber (      empID.getAttribute ( "value" ));
        if (expected.equals ( middleName.getAttribute ( "value" ) ))
        {
            return  true;
        }
        else return  false;
    }

    public boolean areBankEditable() {
        if ( TextUtils.isEmpty(bankNameTxt.getAttribute ( "readonly" )) &&
                TextUtils.isEmpty(acctNameTxt.getAttribute ( "readonly" )) &&
                TextUtils.isEmpty(acctNumberTxt.getAttribute ( "readonly" )) &&
                TextUtils.isEmpty(sortCodeTxt.getAttribute ( "readonly" ))
                )
        {
            System.out.println("Editable");
            return  true;
        }
        else {
            System.out.println("Not Editable");
            return  false;
        }


    }

    public void editBankDetails() {

        sortCodeTxt.clear ();
        sortCodeTxt.sendKeys ( randomAccountNumber ( 2 )+"-"+randomAccountNumber ( 2 )+"-"+randomAccountNumber ( 2 ) );
        acctNumberTxt.clear ();
        acctNumberTxt.clear ();
        acctNumberTxt.sendKeys ( randomAccountNumber ( 8 ));
        waitTime(3000);
        setRequisitionNumber ( sortCodeTxt.getAttribute ( "value" )+acctNumberTxt.getAttribute ( "value" ) );





    }

    public boolean isBankDetailSaveSuccessfull() {

        String expectedChanges = getStoredRequisitionNumber ();

        setRequisitionNumber (      empID.getAttribute ( "value" ));
        if (expectedChanges.equals ( sortCodeTxt.getAttribute ( "value" )+acctNumberTxt.getAttribute ( "value" ) ))
        {
            return  true;
        }
        else return  false;


    }

    public boolean areDiversityFieldsEditable() {


        if ( TextUtils.isEmpty(genderTxt.getAttribute ( "readonly" )) &&
                TextUtils.isEmpty(sexualOrientationTxt.getAttribute ( "readonly" )) &&
                TextUtils.isEmpty(disabilityTxt.getAttribute ( "readonly" ))
                )
        {
            System.out.println("Editable");
            return  true;
        }
        else {
            System.out.println("Not Editable");
            return  false;
        }



    }

    public void updateDiversityInfo(String gender, String disability, String sexual_orientation) {

        genderTxt.clear ();
        genderTxt.sendKeys ( gender+ Keys.TAB );
        sexualOrientationTxt.sendKeys ( sexual_orientation+ Keys.TAB );
        disabilityTxt.sendKeys ( disability+ Keys.TAB);


        setRequisitionNumber ( genderTxt.getAttribute ( "value" )+sexualOrientationTxt.getAttribute ( "value" )+disabilityTxt.getAttribute ( "value" ) );


    }

    public boolean isSaveSuccessfullForDiversityInfo() {


        String expected = getStoredRequisitionNumber();

        //input[@title='Search key for the record in the format required - must be unique']
//        setRequisitionNumber (      empID.getAttribute ( "value" ));
        if (expected.equals (genderTxt.getAttribute ( "value" )+sexualOrientationTxt.getAttribute ( "value" )+disabilityTxt.getAttribute ( "value" )  ))
        {
            return  true;
        }
        else return  false;

    }
}
