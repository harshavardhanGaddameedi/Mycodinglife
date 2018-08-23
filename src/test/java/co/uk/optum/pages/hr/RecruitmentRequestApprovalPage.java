package co.uk.optum.pages.hr;

import co.uk.optum.utility.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.hotkey.Keys;

import javax.inject.Inject;

import static co.uk.optum.utility.CommonUtility.*;
import static co.uk.optum.utility.FeatureContext.setRequisitionNumber;

public class RecruitmentRequestApprovalPage {



    private final WebDriver driver;

    @Inject
    public RecruitmentRequestApprovalPage() {
        this.driver = DriverProvider.driver;
        PageFactory.initElements ( driver, this );
    }


    @FindBy(xpath = "//div/ul/li[@class[contains(.,'z-tab-selected')]]/a/span[contains(.,'Recruitment Request')]")
    WebElement recruitmentRequestTab;

    @FindBy(xpath = "//div/a[@title[contains(.,'Lookup')]]/span[@class='z-toolbarbutton-content']/img[@src[contains(.,'Find24')]]")
    WebElement lookupRecordIcon;

    @FindBy(xpath = "//table/tbody/tr/td/div/div/input[@title='Document sequence number of the document']")
    WebElement nprDocNumberlookupBox;

    @FindBy(xpath = "//table/tbody/tr/td[3]/div/button[@title='OK']")
    WebElement lookupRecordOkbutton;

    @FindBy(xpath = "//div//table//tr//td[@title='Edit Record']")
    WebElement recruitmentRequestToApproveSelect;

    @FindBy(xpath = "//div//tr/td/span[@title='Request Status']/input")
    WebElement statusInput;

    @FindBy(xpath = "//div//tr/td/textarea[@title='Result of the action taken']")
    WebElement commentText;

    @FindBy(xpath = "//div[@class='adwindow-north z-div']/div/div/div[@class='z-toolbar-content z-toolbar-start']/a[@title[contains(., 'Save changes')]]/span[@class='z-toolbarbutton-content']/img[@src[contains(., 'Save')]]")
    WebElement saveButton;


    @FindBy(xpath = "//div//div//table//tr//td/input[@title='Document sequence number of the document']")
    WebElement recruitmentDocNumber;






    public boolean isRecruitmentRequestApprovalPageDisplayed() {

        return recruitmentRequestTab.isDisplayed ();
    }

    public void searchRecruitmentRequest() {

        waitForElementToBeDisplayed ( lookupRecordIcon );
        lookupRecordIcon.click ();
        waitForElementToBeDisplayed ( nprDocNumberlookupBox );
        waitTime ( 1000 );
//        nprDocNumberlookupBox.sendKeys ( getStoredRequisitionNumber () );
//        1003007
        nprDocNumberlookupBox.sendKeys ( "1003011" );
//        waitTime ( 3000 );
        lookupRecordOkbutton.click ();
    }

    public void waitForRecordToBeDisplayed() {
        waitForElementToBeDisplayed ( recruitmentRequestTab );
        System.out.println ( "recruitmentRequestTab Opened" );


    }

    public void selectRequesttoApprove() {


        waitForElementToBeEnabled ( recruitmentRequestToApproveSelect );
        waitTime ( 1000 );
        recruitmentRequestToApproveSelect.click ();

    }

    public void statusInputClear() {

        waitForElementToBeDisplayed ( statusInput );
        statusInput.clear ();
        waitTime ( 2000 );
    }

    public void requestForApproveRecruitmentRequest(String status, String comments) {


        moveElementToVisibility(commentText);
                commentText.sendKeys ( comments ) ;
                waitTime ( 2000 );
        moveElementToVisibility(statusInput);
                statusInput.sendKeys ( status+ Keys.TAB);

                waitTime ( 2000 );
    }

    public void clickSaveButton() {


        saveButton.click();
        }

    public void waitForRequestApproval() {

        waitForElementToBeDisplayed ( recruitmentRequestTab );

    }

    public boolean isRecruitmentRequestApproved(String expStatus) {

        System.out.println ( expStatus );
        System.out.println ( statusInput.getAttribute ( "value" ));


        return statusInput.getAttribute ( "value" ).equals ( expStatus );
    }

    public void setRecruitmentDocNumber() {

        setRequisitionNumber ( recruitmentDocNumber.getAttribute ( "value" ) );
    }
}
