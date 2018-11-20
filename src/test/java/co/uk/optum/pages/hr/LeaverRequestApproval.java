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

import static co.uk.optum.utility.CommonUtility.waitForElementToBeDisplayed;
import static co.uk.optum.utility.CommonUtility.waitTime;
import static co.uk.optum.utility.FeatureContext.getStoredRequisitionNumber;

public class LeaverRequestApproval {

    private final WebDriver driver;
    private boolean assertion;


    @Inject
    public LeaverRequestApproval() {
        this.driver = DriverProvider.driver;
        PageFactory.initElements ( driver, this );
    }

    @FindBy(xpath = "//div/a[@title[contains(.,'Lookup')]]/span[@class='z-toolbarbutton-content']/img[@src[contains(.,'Find24')]]")
    WebElement lookupRecordIcon;

    @FindBy(xpath = "//input[@instancename='Description']")
    WebElement descInput;

    @FindBy(xpath = "//span[@class='z-group-icon-close z-group-icon']")
    WebElement advSearch;

    @FindBy(xpath = "//span[@instancename='HR_Employee_ID']//input[@class='z-combobox-input']")
    WebElement empNameTxt;


    @FindBy(xpath = "//span[@instancename='R_Request0he_termination_date']//input[@class='z-datebox-input']")
    WebElement terminationDateText;

    @FindBy(xpath = "//table/tbody/tr/td[3]/div/button[@title='OK']")
    WebElement okButton;

    @FindBy(xpath = "//span[@title='Request Status' and @instancename='R_Status_ID']//input")
    WebElement statusInputTxt;

    @FindBy(xpath = "//span[@title='Request Status' and @instancename='R_Request0R_Status_ID']//input")
    WebElement approveRejectStatusTxt;


    @FindBy(xpath = "//span[@instancename='R_Request0R_Status_ID']//a[@class='z-combobox-button']/i")
    WebElement statusDropdown;

    @FindBy(xpath = "//span[@instancename[contains(.,'he_leaver_checklist')]] //input[@type='checkbox']")
    WebElement leaverCheklistCheckBoxes;

    @FindBy(xpath = ".//*[@class='z-borderlayout-icon z-icon-chevron-up']")
    WebElement detailRecord;

    @FindBy(xpath = "//div[@class='adwindow-north z-div']/div/div/div[@class='z-toolbar-content z-toolbar-start']/a[@title[contains(., 'Save changes')]]/span[@class='z-toolbarbutton-content']/img[@src[contains(., 'Save')]]")
    WebElement saveButton;

    @FindBy(xpath = "//div[@class='z-toolbar-content z-toolbar-start']//a//span//img[@src[contains(.,'EditRecord16')]]")
    WebElement editTeamMember;

    @FindBy(xpath = "//span[@instancename='he_leaver_checklist0he_exit_interview']//label")
    WebElement exitInterviewTxt;

    @FindBy(xpath = ".//div//table//tr//td/a[@class='z-a']")
    WebElement request;


    public void searchLeaver(String empName) {

        System.out.println ( empName );
        waitForElementToBeDisplayed(lookupRecordIcon);
        lookupRecordIcon.click ();
        waitForElementToBeDisplayed ( descInput );
        advSearch.click ();
        waitForElementToBeDisplayed (  empNameTxt);
        empNameTxt.sendKeys ( empName.replaceAll("\\s+","_")+ Keys.TAB );
        statusInputTxt.sendKeys ( "1_Pending Approval"+Keys.TAB );
        terminationDateText.clear ();
//        terminationDateText.sendKeys ( getStoredRequisitionNumber().toString () );
        System.out.println ( getStoredRequisitionNumber() );
        okButton.click ();
        waitTime ( 2000 );


    }

    public void approveOrReject(String Status) {

        approveRejectStatusTxt.clear ();
        approveRejectStatusTxt.sendKeys ( Status + Keys.TAB );
        waitTime ( 2000 );
        saveButton.click ();
        waitTime ( 2000 );

        if (approveRejectStatusTxt.getAttribute ( "value" ).equals ( Status ))

        {
               assertion = true;


        }
            else { assertion=false;}
            Assert.assertTrue ( "Save Not Successfull!!!", assertion );

    }



    public void openLeaverCheckList() {

        try {
            if (detailRecord.isDisplayed ()) {
                detailRecord.click ();
                waitTime(2000);
            }
        }catch (Exception e)
        {
            List<WebElement> elements = driver.findElements ( By.xpath ( "//span[@instancename[contains(.,'he_leaver_checklist')]] //input[@type='checkbox']" ) );
            for (int i= 0; i<elements.size ()-1; i++)
            {
                waitForElementToBeDisplayed (  driver.findElements ( By.xpath ( "//span[@instancename[contains(.,'he_leaver_checklist')]] //input[@type='checkbox']" ) ).get ( i ));
            }
        }
        List<WebElement> elements = driver.findElements ( By.xpath ( "//span[@instancename[contains(.,'he_leaver_checklist')]] //input[@type='checkbox']" ) );
        for (int i= 0; i<elements.size ()-1; i++)
        {
            waitForElementToBeDisplayed (  driver.findElements ( By.xpath ( "//span[@instancename[contains(.,'he_leaver_checklist')]] //input[@type='checkbox']" ) ).get ( i ));
        }
    }

    public void checkItemsToBeReturedAndSave() {

        System.out.println ( "Waiting Waiting Waiting" );

        try {
            if (detailRecord.isDisplayed ()) {
                detailRecord.click ();
                waitTime(2000);
            }
        }catch (Exception e)
        {}
        editTeamMember.click();
        waitForElementToBeDisplayed (exitInterviewTxt  );
        List<WebElement> elements = driver.findElements ( By.xpath ( "//div[@instancename='form']//input[@type='checkbox']" ) );
        int size = elements.size ();

        for(int i =0; i<=size-1;i++)
        {
            elements.get ( i ).click ();;
        }
        saveButton.click ();
        waitTime ( 1000 );
        request.click();
        waitTime(1000);

    }

    public boolean isSaveSuccessful(String str) {
        if (approveRejectStatusTxt.getAttribute ( "value" ).equals ( str ))

        {
            assertion = true;


        }
        else { assertion=false;}
        return assertion;

       }
}
