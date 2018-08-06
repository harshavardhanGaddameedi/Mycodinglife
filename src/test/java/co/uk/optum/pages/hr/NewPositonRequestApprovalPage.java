package co.uk.optum.pages.hr;

import co.uk.optum.utility.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.inject.Inject;

import static co.uk.optum.utility.CommonUtility.waitForElementToBeDisplayed;
import static co.uk.optum.utility.CommonUtility.waitTime;
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


    public  void searchNPR()
    {
        lookupRecordIcon.click ();
        waitForElementToBeDisplayed ( nprDocNumberlookupBox );
        nprDocNumberlookupBox.sendKeys ( getStoredRequisitionNumber () );
        waitTime ( 3000 );
        lookupRecordOkbutton.click ();


    }

}
