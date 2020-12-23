package co.uk.optum.pages.finance.payables;

import co.uk.optum.utility.DriverProvider;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.hotkey.Keys;

import javax.inject.Inject;

import static co.uk.optum.utility.CommonUtility.waitForElementToBeDisplayed;
import static co.uk.optum.utility.CommonUtility.waitTime;
import static co.uk.optum.utility.FeatureContext.getStoredDocumentNumber;

public class CustomPaymentPage {
    private final WebDriver driver;


    @Inject
    public CustomPaymentPage() {
        this.driver = DriverProvider.driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//tr/td/img[@title[contains(.,'The Process Payments Window allows you to enter payments and reaipts for invoices')]]")
    WebElement customPaymentIcon;

    @FindBy(xpath = "//div/ul/li[@class[contains(.,'z-tab-selected')]]/a/span[contains(.,'Custom Payment')]")
    WebElement customPaymentTab;

    @FindBy(xpath = "//tbody/tr/td/div[@title='Identifies a Business Partner']/input")
    WebElement supplierName;

    @FindBy(xpath = "//tr//td//span[@title[contains(.,'Organizational entity within client')]]/input")
    WebElement practiceName;

    @FindBy(xpath = "//tbody/tr/td/span[@title='Document type or rules']/input")
    WebElement documentType;

    @FindBy(xpath = "//td/span[@title[contains(.,'Account at the Bank')]]/input")
    WebElement bankaccount;

    @FindBy(xpath = "//tbody/tr/td/div[@title='Invoice Identifier']/button")
    WebElement invoiceIcon;

    @FindBy(xpath = "//tr//td//div//input[@title[contains(.,'Document sequence number of the')]]")
    WebElement documentNum;

    @FindBy(xpath = "//div//button[@title[contains(.,'ReQuery')]]")
    WebElement reQuery;

    @FindBy(xpath = "//div//button[@title='OK']")
    WebElement buttonOK;

    @FindBy(xpath = "//table//tr//td[@instancename=' ']//div//span[@class[contains(.,'listitem-radio')]]")
    WebElement documentRecordRadioButton;

    @FindBy(xpath = "//span[@title='The current status of the document']/input")
    WebElement paymentStatus;

    @FindBy(xpath = "//table/tbody/tr/td/div/div/input[@title='Document sequence number of the document']")
    WebElement documentNumberlookupBox;


    @FindBy(xpath = "//div/a[@title[contains(.,'Lookup')]]/span[@class='z-toolbarbutton-content']/img[@src[contains(.,'Find24')]]")
    WebElement lookupRecordIcon;



    @FindBy(xpath = "//table/tbody/tr/td[3]/div/button[@title='OK']")
    WebElement lookupRecordOkbutton;

    @FindBy(xpath = "//td/span[@title='Indicates if this document requires approval']/input[@type='checkbox']")
    WebElement approvedCheckbox;

    public void clickCustomPayment() {
    customPaymentIcon.click();
    waitForElementToBeDisplayed(customPaymentTab);

    }

    public void enterInvoiceDetails(String document_type, String supplier, String practice, String bank_account) {
        waitTime(1000);
        documentType.sendKeys(document_type+ Keys.TAB);
        waitTime(1000);
        supplierName.sendKeys(supplier+Keys.TAB);
        waitTime(1000);
        practiceName.clear();
        practiceName.sendKeys(practice+Keys.TAB);
        waitTime(1000);
        bankaccount.sendKeys(bank_account+Keys.TAB);
        waitTime(1000);
    }

    public void clickInvoiceIcon() {
        waitForElementToBeDisplayed(invoiceIcon);
        invoiceIcon.click();
        waitTime(3000);


    }

    public void enterDocumentNumber(String storedDocumentNumber) {
        waitForElementToBeDisplayed(documentNum);

       documentNum.sendKeys(storedDocumentNumber);
      //  documentNum.sendKeys("100172");
        reQuery.click();
        waitTime(1000);

    }

    public void selectDocumentRecordandClickOK() {
        documentRecordRadioButton.click();

        waitTime(1000);


    }

    public void clickOk() {
        if( buttonOK.isEnabled ()) {
            buttonOK.click ();
            waitTime ( 5000 );
        }
        else {System.out.println ( "Please Select document number radio button Box for which payment to be done" );}


    }

    public void isInvoiceRecordDisplayed() {
        if (documentRecordRadioButton.isDisplayed())
            System.out.println("invoice record FOund ");
        Assert.assertTrue("Invoice record Not Found!!!", documentRecordRadioButton.isDisplayed());

    }

    public boolean isPaymentCompletedSuccessfully() {
        System.out.println ( paymentStatus.getAttribute ( "value" ) );
        waitTime(2000);
        return paymentStatus.getAttribute ( "value" ).equals ( "In Progress" );

    }

    public boolean isCustomPaymentApproved() {
        waitTime(3000);
        clickLookupRecordIcon();
        enterRequisitionNumForLookup();
        clickLookupRecordOkbutton();
        return isPaymentStatusApproved();


    }

    private boolean isPaymentStatusApproved() {
        return Boolean.parseBoolean(paymentStatus.getAttribute("Submitted"));

    }

    private void clickLookupRecordOkbutton() {

        lookupRecordOkbutton.click();
        waitForElementToBeDisplayed(paymentStatus);
    }

    private void enterRequisitionNumForLookup() {

        documentNumberlookupBox.sendKeys(getStoredDocumentNumber());
        waitTime(3000);
    }

    private void clickLookupRecordIcon() {
        lookupRecordIcon.click();
        waitForElementToBeDisplayed(documentNumberlookupBox);
    }

    public boolean isCustomPaymentRejected() {
        waitTime(3000);
        clickLookupRecordIcon();
        enterRequisitionNumForLookup();
        clickLookupRecordOkbutton();
        return isPaymentStatusRejected();

    }

    private boolean isPaymentStatusRejected() {
        return Boolean.parseBoolean(paymentStatus.getAttribute("Not Approved"));

    }

//    public void enterDocumentNumber() {
//        waitForElementToBeDisplayed(documentNum);
//        documentNum.sendKeys(getStoredDocumentNumber);
//
//    }
}
