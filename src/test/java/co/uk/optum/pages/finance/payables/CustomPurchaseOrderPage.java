package co.uk.optum.pages.finance.payables;

import co.uk.optum.utility.CommonUtility;
import co.uk.optum.utility.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.inject.Inject;

import static co.uk.optum.utility.CommonUtility.*;
import static co.uk.optum.utility.FeatureContext.*;

/**
 * Created by bganesa5 on 3/20/2018.
 */
public class CustomPurchaseOrderPage {
    private final WebDriver driver;
    String poStatusBeforeSubmit;
    @Inject
    public CustomPurchaseOrderPage(){
        this.driver = DriverProvider.driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@title='Document sequence number of the document']")
    WebElement purchaseOrderNumberTextbox;

    @FindBy(xpath = "//div[@title='Identifies a Business Partner']/input")
    WebElement businessPartnerTextBox;

    @FindBy(xpath = "//div[@title='Total of all document lines']/input")
    WebElement totalLinesTextBox;

    @FindBy(xpath = "//span[@title='The current status of the document']/input")
    WebElement poStatusTextbox;

    @FindBy(xpath = "//button[@instancename='C_Order0DocAction']")
    WebElement documentActionButton;

    @FindBy(xpath = "//select[@class='z-select']")
    WebElement documentActionDropDown;

    @FindBy(xpath = "//select[@class='z-select']/option[contains(., 'Submit')]")
    WebElement submitOption;

    @FindBy(xpath = "//button[@title='OK']")
    WebElement okButton;

    public void waitForPurchaseOrderTextBox(){
        waitForElementToBeDisplayed(purchaseOrderNumberTextbox);
    }

    public void submitCustomPO(){
//        clickDocumentAction();
//        clickDocumentActionDropDown();
//        selectSubmitOption();
//        clickOk();
        setPurchaseOrderNumber(retrievePurchaseOrderNumber());
        setBusinessPartner(retrieveBusinessPartner());
        waitTime(6000);
    }

    public boolean isPOSubmittedSuccessfully(){
        System.out.println("PO Status : " + retrievePOStatus());
//        if(retrievePOStatus().equalsIgnoreCase("Completed")){
        //updating due to the change in expected status to Susbmitted instead of Completed.
        if(retrievePOStatus().equalsIgnoreCase("Submitted")){
            return true;
        }
        return false;
    }

    public void clickOk(){
        okButton.click();
    }

    public void selectSubmitOption(){
        submitOption.click();
    }

    public void clickDocumentActionDropDown(){
        documentActionDropDown.click();
        waitForElementToBeDisplayed(submitOption);
    }

    public void clickDocumentAction(){
        moveElementToVisibility(documentActionButton);
        documentActionButton.click();
        CommonUtility.waitForElementToBeDisplayed(documentActionDropDown);
    }

    public String retrievePOStatus(){
        moveElementToVisibility(poStatusTextbox);
        poStatusBeforeSubmit = poStatusTextbox.getAttribute("value");
        return poStatusBeforeSubmit;
    }

    public String retrieveTotalLines(){
        moveElementToVisibility(totalLinesTextBox);
        return totalLinesTextBox.getAttribute("value");
    }

    public String retrievePurchaseOrderNumber(){
        moveElementToVisibility(purchaseOrderNumberTextbox);
        return purchaseOrderNumberTextbox.getAttribute("value");
    }

    public String retrieveBusinessPartner(){
        return businessPartnerTextBox.getAttribute("value");
    }

    public boolean isCorrectTotalLineAmountDisplayed(){

        System.out.println("Total line Amt in PO screen : "+ retrieveTotalLines());
        System.out.println("Total line Amt from Stored Value : "+ getTotalLineAmount());

        if(retrieveTotalLines().contains(getTotalLineAmount())){
            return true;
        }
        return false;
    }


}
