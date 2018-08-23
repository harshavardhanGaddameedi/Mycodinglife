package co.uk.optum.pages.hr;

import co.uk.optum.utility.DriverProvider;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.inject.Inject;

import static co.uk.optum.utility.CommonUtility.*;
import static co.uk.optum.utility.FeatureContext.getStoredRequisitionNumber;

public class NewPositonRequestApprovalPage {

    private final WebDriver driver;

    @Inject
    public NewPositonRequestApprovalPage() {
        this.driver = DriverProvider.driver;
        PageFactory.initElements ( driver, this );
    }

    @FindBy(xpath = "//div/a[@title[contains(.,'Lookup')]]/span[@class='z-toolbarbutton-content']/img[@src[contains(.,'Find24')]]")
    WebElement lookupRecordIcon;

    @FindBy(xpath = "//table/tbody/tr/td/div/div/input[@title='Document sequence number of the document']")
    WebElement nprDocNumberlookupBox;

    @FindBy(xpath = "//table/tbody/tr/td[3]/div/button[@title='OK']")
    WebElement lookupRecordOkbutton;

    @FindBy(xpath = "//div/ul/li[@class[contains(.,'z-tab-selected')]]/a/span[contains(.,'New Position Request')]")
    WebElement newPositionRequestTab;


    @FindBy(xpath = "//div//tr/td/span[@title='Request Status']/input")
    WebElement statusInput;


    @FindBy(xpath = "//div//table//tr//td[@title='Edit Record']")
    WebElement nprToApproveSelect;

    public  void searchNPR()
    {
        waitForElementToBeDisplayed ( newPositionRequestTab );
        lookupRecordIcon.click ();
        waitForElementToBeDisplayed ( nprDocNumberlookupBox );
        waitTime ( 1000 );
        nprDocNumberlookupBox.sendKeys ( getStoredRequisitionNumber () );
//        nprDocNumberlookupBox.sendKeys ( "1002986" );
//        waitTime ( 3000 );
        lookupRecordOkbutton.click ();
    }

    public void statusInputClear() {
        waitForElementToBeDisplayed ( statusInput );
        statusInput.clear();
    }

    public void requestForApproveNPR(String status) {
        statusInput.sendKeys ( status );
        statusInput.sendKeys ( Keys.TAB );
    }

    public void selectNPRtoApprove() {

        waitForElementToBeEnabled ( nprToApproveSelect );
        waitTime ( 1000 );
        nprToApproveSelect.click ();



    }

    public boolean isNPRApproved()
    {

        return statusInput.getAttribute ( "value" ).equals ( "40_Accepted" );
    }
}
