package co.uk.optum.pages.finance.receivables;

import co.uk.optum.utility.DriverProvider;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.inject.Inject;
import java.util.List;

import static co.uk.optum.utility.CommonUtility.waitForElementToBeDisplayed;
import static co.uk.optum.utility.CommonUtility.waitTime;
import static co.uk.optum.utility.FeatureContext.getStoredRequisitionNumber;
import static co.uk.optum.utility.FeatureContext.setRequisitionNumber;

public class ReceivablesPage {
    private final WebDriver driver;

    @Inject
    public ReceivablesPage() {
        this.driver = DriverProvider.driver;
        PageFactory.initElements ( driver, this );
    }

    @FindBy(xpath = "//tr/td/img[@title[contains(.,'enter and modify Sales Orders.')]]")
    WebElement customRevenueOrder;

    @FindBy(xpath = " //tr/td/img[@title[contains(.,'The Customer Invoice Window allows you to display and enter invoices for a customer')]]")
    WebElement revenueInvoice;

    @FindBy(xpath = "//div/ul/li[@class[contains(.,'z-tab-selected')]]/a/span[contains(.,'Revenue Order')]")
    WebElement revenueOrderTab;


    @FindBy(xpath = "//div/ul/li[@class[contains(.,'z-tab-selected')]]/a/span[contains(.,'Revenue Invoice')]")
    WebElement revenueInvoiceTab;


    @FindBy(xpath = "//div/a[@title[contains(.,'New')]]/span[@class='z-toolbarbutton-content']/img[@src[contains(.,'New24')]]")
    WebElement newToolbarIcon;

    @FindBy(xpath = "//div/div[@class[contains(.,'z-grid-body')]]//table//tr//td/div[@title[contains(.,'Identifies a Business Partner')]]//input")
    WebElement customerTxt;

    @FindBy(xpath = "//div[@class='z-toolbar-content z-toolbar-start']/a/span/img[@src='/webui/theme/businessTeamBlue/images/Detail24.png']")
    WebElement detailRecordAltDown;

    @FindBy(xpath = "//div//span[@title[contains(.,'Identifies the (ship to) address for this Business Partner')]]/input[@class[contains(.,'z-combobox-input')]]")
    WebElement customerAddress;

    @FindBy(xpath = "//div//div[@title='Product, Service, Item']/input")
    WebElement productDesc;

    @FindBy(xpath = "//div//div[@title='The Quantity Entered is based on the selected UoM']/input")
    WebElement quantityVal;

    @FindBy(xpath = "//div//div/table//tr//td//span[@title='Organizational entity within client']/input")
    WebElement practiceName;

    @FindBy(xpath = "//div//div/table//tr//td//span[@title='Storage Warehouse and Service Point']/input[@class='z-combobox-input']")
    WebElement warehouseName;

    @FindBy(xpath = "//div/a//span[@class='z-toolbarbutton-content']//img[@src[contains(.,'/webui/theme/businessTeamBlue/images/Parent24.png')]]")
    WebElement parentRecAltUp;

    @FindBy(xpath = "//button[@instancename='C_Order0DocAction']")
    WebElement documentActionButton;


    @FindBy(xpath = "//button[@instancename='C_Invoice0DocAction']")
    WebElement documentActionButtonInvoice;

    @FindBy(xpath = "//select[@class='z-select']")
    WebElement documentActionDropDown;

    @FindBy(xpath = "//select[@class='z-select']/option[contains(., 'Submit')]")
    WebElement submitOption;

    @FindBy(xpath = "//button[@title='OK']")
    WebElement okButton;

    @FindBy(xpath = "//div//input[@ title='Document sequence number of the document']")
    WebElement revenueOrderNumber;

    @FindBy(xpath = "//div//span[@title='The current status of the document']/input")
    WebElement revenueOrderStatus;

    @FindBy(xpath = "//div//span[@title='The current status of the document']/input")
    WebElement coreRevenueOrderStatus;

    @FindBy(xpath = "//div//span[@title='The current status of the document']/input")
    WebElement revenueInvoiceStatus;


    @FindBy(xpath = "//div/a[@title[contains(.,'Lookup')]]/span[@class='z-toolbarbutton-content']/img[@src[contains(.,'Find24')]]")
    WebElement lookupRecordIcon;

    @FindBy(xpath = "//table/tbody/tr/td/div/div/input[@title='Document sequence number of the document']")
    WebElement requisitionNumberlookupBox;

    @FindBy(xpath = "//table/tbody/tr/td[3]/div/button[@title='OK']")
    WebElement lookupRecordOkbutton;


    @FindBy(xpath = "//div//button[@title='Process which will generate a new document lines based on an existing document']")
    WebElement createLinesFrom;

    @FindBy(xpath = "//div[@instancename='Invoice____Create_lines_from']")
    WebElement theCreateLinesFromPopup;


    @FindBy(xpath = "//div/table//tr[1]//td[@instancename='Select']/div//input[@type='checkbox']")
    WebElement orderLinesChk;


    @FindBy(xpath = "//div//button[@title='OK']")
    WebElement orderLinesOK;

    @FindBy(xpath = "//div[@class[contains(.,'desktop-tabpa')]]//tr/td[1]/img")
    WebElement revenueInvoiceCash;

    @FindBy(xpath = "//div/ul/li[@class[contains(.,'z-tab-selected')]]/a/span[contains(.,'Revenue Invoice Cash')]")
    WebElement revenueInvoiceCashTab;

    @FindBy(xpath = "//div/div[@class[contains(.,'desktop-tabpanel z-tabpanel')]]//table//tr/td[1]/img")
    WebElement revenueOrderCore;
    @FindBy(xpath = "//div/ul/li[@class[contains(.,'z-tab-selected')]]/a/span[contains(.,'Revenue Order Core')]")
    WebElement revenueOrderCoreTab;

//    @FindBy(xpath ="//div/table[contains(@id, '-cave')]/tbody/tr/td[4]//div/select/option[contains(text(),'50091')]")
//    WebElement orderDropdown;


    public void waitForCustomRevenueOrderToDisplay() throws InterruptedException {
        waitForElementToBeDisplayed ( customRevenueOrder );

    }

    public void clickCustomRevenueOrder() {
        customRevenueOrder.click ();
        waitForElementToBeDisplayed ( revenueOrderTab );
    }

    public void setRevenueOrderDetails(String customer, String product, String quantity) throws InterruptedException {

        System.out.println ( "Clicking New button" );
        waitForElementToBeDisplayed ( revenueOrderTab );
        try {
            Thread.sleep ( 5000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
        newToolbarIcon.click ();
        waitForElementToBeDisplayed ( revenueOrderTab );
        try {
            Thread.sleep ( 6000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
        practiceName.clear ();
        practiceName.sendKeys ( "ErpPractice" );
        practiceName.sendKeys ( Keys.TAB );
        Thread.sleep ( 5000 );
        warehouseName.clear ();
        warehouseName.sendKeys ( "Standard" );
        warehouseName.sendKeys ( Keys.TAB );
        Thread.sleep ( 5000 );

        customerTxt.sendKeys ( customer );
        detailRecordAltDown.click ();
        System.out.println ( "NEXT PAGE" );
        waitForElementToBeDisplayed ( productDesc );
        productDesc.click ();
        productDesc.sendKeys ( product );
        quantityVal.click ();
        quantityVal.clear ();
        quantityVal.sendKeys ( quantity );
        System.out.println ( "Clicking ParentRecAltUp" );
        parentRecAltUp.click ();
        System.out.println ( "Clicked ParentRecAltUp" );
        waitForElementToBeDisplayed ( revenueOrderTab );


    }

    public void clickDocumentAction() {
        waitForElementToBeDisplayed ( documentActionButton );
        documentActionButton.click ();
        waitForElementToBeDisplayed ( documentActionDropDown );
        documentActionDropDown.click ();
        waitForElementToBeDisplayed ( submitOption );
        submitOption.click ();
        okButton.click ();
        waitTime ( 6000 );

    }

    public String getRevenueOrderNumber() {
        System.out.println ( revenueOrderNumber.getText () );
        setRequisitionNumber ( revenueOrderNumber.getAttribute ( "value" ) );
        return revenueOrderNumber.getAttribute ( "value" );


    }

    public String revenueOrderStatus() {
        //System.out.println(revenueOrderStatus.getText ());
        return revenueOrderStatus.getAttribute ( "value" );

    }

    public boolean isRevenueOrderApproved() {
        waitTime ( 3000 );
        clickLookupRecordIcon ();
        enterRequisitionNumForLookup ();
        clickLookupRecordOkbutton ();
        System.out.println ( revenueOrderStatus.getAttribute ( "value" ) );
        return revenueOrderStatus.getAttribute ( "value" ).equals ( "Completed" );


    }

    public void clickLookupRecordOkbutton() {
        lookupRecordOkbutton.click ();
        waitForElementToBeDisplayed ( revenueOrderStatus );
    }

    public void enterRequisitionNumForLookup() {

        requisitionNumberlookupBox.sendKeys ( getStoredRequisitionNumber () );
    waitTime ( 3000 );
}

    public void clickLookupRecordIcon() {
        lookupRecordIcon.click ();
        waitForElementToBeDisplayed ( requisitionNumberlookupBox );
    }

    public void clickRevenueInvoice() {
        revenueInvoice.click ();
        waitForElementToBeDisplayed ( revenueInvoiceTab );


    }

    public void waitForRevenueInvoiceWindow() {

        waitForElementToBeDisplayed ( newToolbarIcon );
        waitTime ( 10000 );

    }

    public void newToolbarIconClick() {
        newToolbarIcon.click ();

    }

    public void setInvoiceDeatils(String customer) throws InterruptedException {
        waitForElementToBeDisplayed ( customerTxt );
        waitForElementToBeDisplayed ( practiceName );
        waitTime ( 3000 );
        customerTxt.sendKeys ( customer );
        customerTxt.sendKeys ( Keys.TAB );
        waitTime ( 3000 );
        practiceName.clear ();
        practiceName.sendKeys ( "ErpPractice" );
        practiceName.sendKeys ( Keys.TAB );
        waitTime ( 3000 );


    }

    public void clickCreateLinesFromButton() {
        waitTime ( 2000 );
        createLinesFrom.click ();
        waitTime ( 5000 );

    }

    public void waitForTheCreateLinesFromPopup() {

        waitTime ( 2000 );
        waitForElementToBeDisplayed ( theCreateLinesFromPopup );

    }

    public void waitForOrderDropdown() {

        //div/table[contains(@id, '-cave')]/tbody/tr/td[4]//div/select/option[contains(text(),'50091')]
//        waitForElementToBeDisplayed (orderDropdown);
        System.out.println ( "Order drop down found" );
    }

    public void selectRevenueOrderForInvoice() {

        selectRevenueOrder ( getStoredRequisitionNumber () );

        //div/table[contains(@id, '-cave')]/tbody/tr/td[4]//div/select/option[contains(text(),'50091')]


    }

    public void selectRevenueOrder(String storedRequisitionNumber) {

        System.out.println ( driver.findElement ( By.xpath ( "//div/table[contains(@id, '-cave')]/tbody/tr/td[4]//div/select/option[contains(text(),'" + storedRequisitionNumber + "')]" ) ).getAttribute ( "value" ) );
        driver.findElement ( By.xpath ( "//div/table[contains(@id, '-cave')]/tbody/tr/td[4]//div/select/option[contains(text(),'" + storedRequisitionNumber + "')]" ) ).click ();
        waitTime ( 3000 );

        //aitForElementToBeDisplayed ( orderLinesChk );
    }

    public void isRevenueOrderDetailsDisplayed() {

        if (orderLinesChk.isDisplayed ())
            System.out.println ( "Order Lines FOund " );
        Assert.assertTrue ( "Order Line Not Found!!!", orderLinesChk.isDisplayed () );


    }

    public void selectOrder() {

        List<WebElement> checkBoxes = driver.findElements ( By.xpath ( "//div/table//tr//td[@instancename='Select']/div//input[@type='checkbox']" ) );
        System.out.println ( checkBoxes.size () );
        for (int i = 0; i < checkBoxes.size (); i++) {
            System.out.println ( checkBoxes.get ( i ).getText () );
            checkBoxes.get ( i ).click ();
            waitTime ( 5000 );

        }
    }

    public void clickOK() {
        if( orderLinesOK.isEnabled ()) {
            orderLinesOK.click ();
            waitTime ( 5000 );
        }
        else {System.out.println ( "Please Select Order Check Box for which invoice to be created" );}

    }


    public void waitForRevenueInvoiceTab() {


        waitForElementToBeDisplayed ( revenueInvoiceTab );

    }


    public boolean isRevenueInvoiceCreated() {

        System.out.println ( revenueInvoiceStatus.getAttribute ( "value" ) );
        return revenueInvoiceStatus.getAttribute ( "value" ).equals ( "Completed" );

    }

    public void clickDocumentActionInvoice() {

        waitForElementToBeDisplayed ( documentActionButtonInvoice );
        documentActionButtonInvoice.click ();
        waitForElementToBeDisplayed ( documentActionDropDown );
        documentActionDropDown.click ();
        waitForElementToBeDisplayed ( submitOption );
        submitOption.click ();
        okButton.click ();
        waitTime ( 6000 );


    }

    public void waitUntilDocumentActionInvoiceIsEnabled() {

        if (!documentActionButtonInvoice.isEnabled ())
        {
            waitTime ( 5000 );

        }
        else {}

    }

      public void clickRevenueInvoiceCash() {
        revenueInvoiceCash.click ();
        waitForElementToBeDisplayed ( revenueInvoiceCashTab );
        waitTime ( 2000 );


    }

    public void clickRevenueOrderCore() {

        revenueOrderCore.click();
        waitForElementToBeDisplayed ( revenueOrderCoreTab);



    }

    public boolean isCoreRevenueOrderApprovedByEMISProcessor() {



        waitTime ( 3000 );
        clickLookupRecordIcon ();
        enterRequisitionNumForLookup ();
        clickLookupRecordOkbutton ();
        waitTime ( 3000 );
        System.out.println ( coreRevenueOrderStatus.getAttribute ( "value" ) );
        return coreRevenueOrderStatus.getAttribute ( "value" ).equals ( "Approved" );
    }

    public boolean isCoreRevenueOrderApprovedByFinController() {

        waitTime ( 3000 );
        clickLookupRecordIcon ();
        enterRequisitionNumForLookup ();
        clickLookupRecordOkbutton ();
        System.out.println ( coreRevenueOrderStatus.getAttribute ( "value" ) );
        return coreRevenueOrderStatus.getAttribute ( "value" ).equals ( "Completed" );
    }

    public boolean isCashRevenueInvoiceCreated() {
        System.out.println ( revenueInvoiceStatus.getAttribute ( "value" ) );
        return revenueInvoiceStatus.getAttribute ( "value" ).equals ( "Completed" );


    }
}


    //@FindBy(xpath = ".//*[@id='pF9Pnx0']')]]")   WebElement customRequisitionWrokFlowIcon;

