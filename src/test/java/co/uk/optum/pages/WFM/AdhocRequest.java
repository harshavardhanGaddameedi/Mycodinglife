package co.uk.optum.pages.WFM;
import co.uk.optum.utility.DriverProvider;
import co.uk.optum.utility.FeatureContext;
import com.sun.net.httpserver.Authenticator;
import org.jruby.RubyBoolean;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import static co.uk.optum.utility.CommonUtility.*;

import javax.inject.Inject;

public class AdhocRequest {
    private WebDriver driver;
    private boolean assertion;

    @Inject
    public AdhocRequest() {
        this.driver = DriverProvider.driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//td//div//span[contains(.,'Create and Edit a pending')]")
    WebElement newAdhocRequestSection;
    @FindBy(xpath = "//div//button[contains(.,'New')]")
    WebElement newButton;

    @FindBy(xpath = "//div//span[contains(.,'Requester Name')]//following::td[1]//div//input")
    WebElement reqName;

    @FindBy(xpath = "//div//span[contains(.,'Requester Organisation')]//following::td[1]//div//select")
    WebElement rOrganization;

    @FindBy(xpath = "//div//span[contains(.,'Requester Contact Telephone Number')]//following::td[1]//div//input")
    WebElement phoneNum;


    @FindBy(xpath = "//div//span[contains(.,'Requester Email Received Date')]//following::td[1]//div[1]//span[1]//input[@class='z-datebox-input']")
    WebElement dateAndtime ;
    @FindBy(xpath = "//div//span[contains(.,'Requester Email Subject')]//following::td[1]//div//input")
    WebElement emailSub;

    @FindBy(xpath = "//div//span[contains(.,'Mailbox Request Received From')]//following::td[1]//div//select")
    WebElement mailBoxRequestFrm ;
    @FindBy(xpath = "//div//span[contains(.,'Description')]//following::td[1]//div//textarea")
    WebElement desc ;
    @FindBy(xpath = "//div//span[contains(.,'Request Type')]//following::td[1]//div//select")
    WebElement reqType ;

    @FindBy(xpath = "//div//span[contains(.,'Lead SME')]//following::td[1]//div//select")
    WebElement ldSME;


    @FindBy(xpath = "//div//span[contains(.,'Secondary SME')]//following::td[1]//div//select")
     WebElement sSME;


    @FindBy(xpath = "//div//span[contains(.,'Requested Completion Date')]//following::td[1]//div//input[@class='z-datebox-input']")
    WebElement rCompletionDate ;

    @FindBy(xpath = "//div//button[contains(.,'Save')]")
    WebElement saveButton;

   @FindBy(xpath = "//div//span[contains(.,'Saved Succesfully')]")
   WebElement successMsg;

   @FindBy(xpath = "//div//span[contains(.,'Request Accepted')]")
   WebElement requestAcceptMsg;


   @FindBy(xpath ="//table//tbody//tr//td//button[contains(@title,'OK')]" )
   WebElement acceptOK;

    @FindBy(xpath = "//div[contains(@class,'desktop-tabpanel z-tabpanel')]//div[contains(@class,'z-div')]//a[contains(.,'Landing Page')]")
    WebElement landingPageHyperLink;


    @FindBy(xpath = "//td//div//span[contains(.,'Current Requests')]")
    WebElement currentRequestSection;

    public void clickCreateNewAdhocRequest() {
        waitForElementToBeDisplayed(newAdhocRequestSection);
        if (newAdhocRequestSection.isDisplayed()) {
            System.out.println("clicking on new adhoc request section");
        //   teamview.click();
           waitTime(1000);
            newAdhocRequestSection.click();


        }
        else
        {
            System.out.println("Specified Section doesn't exists ");
        }
    }

    public void clickNewButton() {
        newButton.click();

    }

    public void createNewAdhocRequest(String requesterName, String organisation, String telNo, int dateAndTime, String emailSubject, String mailBoxRequestFrom, String description, String rType, String leadSME, String ssme, int requestCompletionDate) {
        reqName.sendKeys(requesterName);
        phoneNum.sendKeys(telNo);
        Select org=new Select(rOrganization);
        org.selectByVisibleText(organisation);
        dateAndtime.sendKeys(getFutureDate(dateAndTime));
        emailSub.sendKeys(emailSubject);
        mailBoxRequestFrm.sendKeys(mailBoxRequestFrom);
        desc.sendKeys(description);
        Select requestType=new Select(reqType);
        requestType.selectByVisibleText(rType);
        rCompletionDate.sendKeys(getFutureDate(requestCompletionDate));
        waitForElementToBeDisplayed(ldSME);
        Select leadSME1=new Select(ldSME);
        waitTime(1000);
        leadSME1.selectByVisibleText(leadSME);
        waitForElementToBeDisplayed(sSME);
        Select secSME1=new Select(sSME);
        waitTime(1000);
        secSME1.selectByVisibleText(ssme);

   }

    public void submitAdhocRequest() {
        waitForElementToBeDisplayed(saveButton);
        waitTime(1000);
        saveButton.click();
            }

    public boolean isRequestSubmittedSuccesfully() {
        waitTime(1000);
        if(successMsg.isDisplayed()){
            acceptOK.click();
            return true;
        }
        else{
            return false;
        }


    }


    public String acceptRequest(String storedRequisitionNumber) {
//        WebElement acceptRequest =driver.findElement(By.xpath("//div//table//tbody//tr//td[contains(.,"+storedRequisitionNumber+")]/following::td[9]//button[2]"));
//         Boolean ar=acceptRequest.isDisplayed();
//        System.out.println(ar);
        WebElement acceptRequest1 =driver.findElement(By.xpath("//div//table//tbody//tr//td[contains(.,'deletethisreq')]/following::td[9]//button[2]"));
        WebElement adhocID=driver.findElement(By.xpath("//div//table//tbody//tr//td[contains(.,'deletethisreq')]//preceding::td[1]"));
        String adhocNum=adhocID.getText();
        FeatureContext.setAdhochNumber(adhocNum);
        System.out.println(adhocNum);
        waitTime(1000);
        acceptRequest1.click();
        waitTime(1000);
        return adhocNum;
}

    public boolean isRequestAcceptedbySME() {
        waitTime(1000);
         return requestAcceptMsg.isDisplayed();



    }

    public void clickOKButtton() {
        acceptOK.click();
    }

    public void navigateBacktoLandingPage() {

        landingPageHyperLink.click();
        waitTime(1000);
    }

    public void navigateToCurrentRequestWindow() {
        try{
        currentRequestSection.click();


    }catch (Exception e)
        {
    System.out.println("unable to find the current Request section");
        }
}

    public void verifyAcceptedAdhocRequest(String adhocNumber) {


        WebElement acceptedReqeust=driver.findElement(By.xpath("//div//table//tbody//tr//td[contains(.,"+adhocNumber+")]"));
        try{
            acceptedReqeust.isDisplayed();
            System.out.println("Accpeted request found in Current Request window and the request number is "+adhocNumber);
        }
        catch (Exception e){
            System.out.println("Accepted Request Doesn't exist in current Request Window");
        }
    }


}