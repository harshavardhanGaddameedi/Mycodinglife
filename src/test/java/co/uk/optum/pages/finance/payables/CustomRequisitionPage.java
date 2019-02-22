package co.uk.optum.pages.finance.payables;

import co.uk.optum.utility.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.inject.Inject;

import static co.uk.optum.utility.CommonUtility.*;
import static co.uk.optum.utility.FeatureContext.*;

/**
 * Created by bganesa5 on 2/14/2018.
 */
public class CustomRequisitionPage {
    private final WebDriver driver;
    private final CustomRequisitionRequisitionLinePage customRequisitionRequisitionLinePage;

    @Inject
    public CustomRequisitionPage(){
        this.driver = DriverProvider.driver;
        PageFactory.initElements(driver, this);
        this.customRequisitionRequisitionLinePage = new CustomRequisitionRequisitionLinePage();
    }

    @FindBy(xpath = "//div/a[@title[contains(.,'New')]]/span[@class='z-toolbarbutton-content']/img[@src[contains(.,'New24')]]")
    WebElement newToolbarIcon;

    @FindBy(xpath = "//span[@title='Document type or rules']/a[@class='z-combobox-button']")
    WebElement documentTypeDropDownIcon;

    @FindBy (xpath = "//span[@title='Document type or rules']/input[@value='Purchase Requisition']")
    WebElement documentTypeTextBox;

    @FindBy (xpath = "//span[@title='Date when required']/input")
    WebElement dateRequiredTextBox;

    @FindBy(xpath = "//a[@title[contains(., 'Detail record')]]")
    WebElement detailRecordDownArrowToolbarIcon;

   // updating xpath to match with the document action button in all instances
   // @FindBy(xpath = "//button[@instancename='M_Requisition0DocAction']"
    @FindBy(xpath = "//button[@instancename[contains(.,'DocAction')]]")
    WebElement documentActionButton;

    @FindBy(xpath = "//select[@class='z-select']")
    WebElement documentActionDropDown;

    @FindBy(xpath = "//select[@class='z-select']/option[contains(., 'Submit')]")
    WebElement submitOption;

    @FindBy(xpath = "//button[@title='OK']")
    WebElement okButton;

    @FindBy(xpath = "//input[@title='Document sequence number of the document']")
    WebElement requisitionNumber;

    @FindBy(xpath = "//div[@title='Total of all document lines']/input")
    WebElement totalLines;

    @FindBy(xpath = "//div/a[@title[contains(.,'Lookup')]]/span[@class='z-toolbarbutton-content']/img[@src[contains(.,'Find24')]]")
    WebElement lookupRecordIcon;

    @FindBy(xpath = "//table/tbody/tr/td/div/div/input[@title='Document sequence number of the document']")
    WebElement requisitionNumberlookupBox;

    @FindBy(xpath = "//table/tbody/tr/td[3]/div/button[@title='OK']")
    WebElement lookupRecordOkbutton;

    @FindBy(xpath = "//td/span[@title='Indicates if this document requires approval']/input[@type='checkbox']")
    WebElement approvedCheckbox;

    public boolean isCustomRequisitionApproved(){
        waitTime(3000);
        clickLookupRecordIcon();
        enterRequisitionNumForLookup();
        clickLookupRecordOkbutton();
        return isApprovedCheckboxChecked();
    }

    public boolean isApprovedCheckboxChecked(){
        return Boolean.parseBoolean(approvedCheckbox.getAttribute("checked"));
    }

    public void enterRequisitionNumForLookup(){
        requisitionNumberlookupBox.sendKeys(getStoredRequisitionNumber());
        waitTime(3000);
    }

    public void clickLookupRecordOkbutton(){
        lookupRecordOkbutton.click();
        waitForElementToBeDisplayed(approvedCheckbox);
    }

    public void clickLookupRecordIcon(){
        lookupRecordIcon.click();
        waitForElementToBeDisplayed(requisitionNumberlookupBox);
    }

    public String getRequisitionNumber(){
        System.out.println(requisitionNumber.getAttribute("value"));
        setRequisitionNumber(requisitionNumber.getAttribute("value"));
        return requisitionNumber.getAttribute("value");
    }

    public String getTotalLines(){
        System.out.println(totalLines.getAttribute("value"));
        setTotalLineAmount(totalLines.getAttribute("value"));
        return totalLines.getAttribute("value");
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
        documentActionButton.click();
        waitForElementToBeDisplayed(documentActionDropDown);
    }

    public void submitCustomRequisition(){
        clickDocumentAction();
        clickDocumentActionDropDown();
        selectSubmitOption();
        clickOk();
        waitTime(6000);
    }

    public void clickDetailRecordDownArrowIcon(){
        detailRecordDownArrowToolbarIcon.click();
        customRequisitionRequisitionLinePage.waitForRequisitionLineText();
    }

    public void setRequiredDate(int days){
        dateRequiredTextBox.clear();
        dateRequiredTextBox.sendKeys(getFutureDate(days));
    }

    public void clickNewToolBarIcon(){
        waitForElementToBeDisplayed(newToolbarIcon);
        newToolbarIcon.click();
        waitForElementToBeDisplayed(documentTypeTextBox);
    }

    public void clickDocumentTypeDropDwonIcon(){

    }

    public void enterDocumentType(String documentType){
        documentTypeTextBox.clear();
        documentTypeTextBox.sendKeys(documentType);
    }

    public void enterAllCustomRequisitionDetails() throws InterruptedException {
        clickNewToolBarIcon();
        waitTime(2000);
        enterDocumentType("Purchase Requisition");
        setRequiredDate(5);
        clickDetailRecordDownArrowIcon();
        customRequisitionRequisitionLinePage.selectAProduct();
        waitForElementToBeDisplayed(documentActionButton);
    }

    public boolean isCustomRequisitionRejected() {
        waitTime(3000);
        clickLookupRecordIcon();
        enterRequisitionNumForLookup();
        clickLookupRecordOkbutton();
        return isApprovedCheckboxUnChecked();
    }

    private boolean isApprovedCheckboxUnChecked() {

        return Boolean.parseBoolean(approvedCheckbox.getAttribute("unchecked"));
    }
}
