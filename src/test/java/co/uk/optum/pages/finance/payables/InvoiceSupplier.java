package co.uk.optum.pages.finance.payables;

import co.uk.optum.utility.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.hotkey.Keys;

import javax.inject.Inject;

import static co.uk.optum.utility.CommonUtility.waitForElementToBeDisplayed;
import static co.uk.optum.utility.CommonUtility.waitTime;
import static co.uk.optum.utility.FeatureContext.setDocumentNumber;


public class InvoiceSupplier {
    private final WebDriver driver;


    @Inject
    public InvoiceSupplier() {
        this.driver = DriverProvider.driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//tr/td/img[@title[contains(.,'The Supplier Invoice Window allows you to display and enter Invoices from a Supplier')]]")
    WebElement invoiceSupplierIcon;

    @FindBy(xpath = "//div/ul/li[@class[contains(.,'z-tab-selected')]]/a/span[contains(.,'Invoice Supplier')]")
    WebElement invoiceSupplierTab;

    @FindBy(xpath = "//tbody/tr/td/div[@title='Identifies a Business Partner']/input")
    WebElement supplierName;

    @FindBy(xpath = "//tr//td//span[@title[contains(.,'Organizational entity within client')]]/input")
    WebElement practiceName;

    @FindBy(xpath = "//tbody/tr/td/span[@title='Document type or rules']/input")
    WebElement documentType;

    @FindBy(xpath = "//tbody/tr/td/span[@title='Target document type for conversing documents']/input")
    WebElement targetDocumentType;


    @FindBy(xpath = "//span[@title='The current status of the document']/input")
    WebElement invoiceStatus;

    @FindBy(xpath = " //div//input[@ title='Document sequence number of the document']")
    WebElement documentNumber;



    public  void clickInvoiceSupplier() {
        invoiceSupplierIcon.click();
        waitForElementToBeDisplayed(invoiceSupplierTab);

    }


    public void enterMaterialReceiptDetails(String supplier, String target_document_type, String practice) {

            waitTime(2000);
            supplierName.sendKeys(supplier+ Keys.TAB);
            waitTime(1000);
        targetDocumentType.sendKeys(target_document_type+ Keys.TAB);
            practiceName.sendKeys(practice+ Keys.TAB);

        }

    public boolean isInvoiceGeneratedSuccessfully() {

        System.out.println ( invoiceStatus.getAttribute ( "value" ) );
        return invoiceStatus.getAttribute ( "value" ).equals ( "Submitted" );



    }

    public void getDocumentNumber() {

        System.out.println ( documentNumber.getText () );
        setDocumentNumber ( documentNumber.getAttribute ( "value" ) );
    }
}

