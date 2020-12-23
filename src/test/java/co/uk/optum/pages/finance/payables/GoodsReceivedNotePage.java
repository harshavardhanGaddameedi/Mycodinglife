package co.uk.optum.pages.finance.payables;

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
import static co.uk.optum.utility.FeatureContext.*;


public class GoodsReceivedNotePage {
    private final WebDriver driver;


    @Inject
    public GoodsReceivedNotePage() {
        this.driver = DriverProvider.driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//tbody/tr/td/span[@title='Document type or rules']/input")
    WebElement documentType;


    @FindBy(xpath = "//div[@title='Identifies a Business Partner']/input")
    WebElement supplierName;


    @FindBy(xpath = "//div/table//tr[1]//td[@instancename='Select']/div//input[@type='checkbox']")
    WebElement purchaseOrderChk;


    @FindBy(xpath = "//div//button[@title='OK']")
    WebElement purchaseOrderOK;

    @FindBy(xpath = "//div//span[@title='The current status of the document']/input")
    WebElement materialReceiptStatus;

    @FindBy(xpath = " //div//input[@ title='Document sequence number of the document']")
    WebElement documentNumber;

    @FindBy(xpath = "//div/a[@title[contains(.,'Lookup')]]/span[@class='z-toolbarbutton-content']/img[@src[contains(.,'Find24')]]")
    WebElement lookupRecordIcon;

    @FindBy(xpath = "//table/tbody/tr/td/div/div/input[@title='Document sequence number of the document']")
    WebElement requisitionNumberlookupBox;

    @FindBy(xpath = "//table/tbody/tr/td[3]/div/button[@title='OK']")
    WebElement lookupRecordOkbutton;
    //div[@title='Identifies a Business Partner']/input


    public void enterCustomRequisitionDetails(String DocumentType, String SupplierName) throws InterruptedException {

      waitTime(2000);

        documentType.sendKeys(DocumentType+ Keys.TAB);
        supplierName.sendKeys(SupplierName+Keys.TAB);

    }

    public void selectPurchaseOrderforReceipt() {
       selectPurchaseOrder(getPurchaseOrderNumber());
      //  selectPurchaseOrder("2017-228-02");
       // selectPurchaseOrder("1006");
    }

    private void selectPurchaseOrder(String purchaseOrderNumber) {

        System.out.println(driver.findElement(By.xpath("//div/table[contains(@id, '-cave')]/tbody/tr/td[4]//div/select/option[contains(text(),'" + purchaseOrderNumber + "')]")).getAttribute("value"));
        driver.findElement(By.xpath("//div/table[contains(@id, '-cave')]/tbody/tr/td[4]//div/select/option[contains(text(),'" + purchaseOrderNumber + "')]")).click();
        waitTime(3000);


    }

    public void clickLookupRecordIcon(){
        lookupRecordIcon.click();
        waitForElementToBeDisplayed(requisitionNumberlookupBox);
    }
    public void isPurchaseOrderDisplayed() {
        if (purchaseOrderChk.isDisplayed())
            System.out.println("Or FOund ");
        Assert.assertTrue("Order Line Not Found!!!", purchaseOrderChk.isDisplayed());


    }

    public void selectPurchaseOrder() {
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//div/table//tr//td[@instancename='Select']/div//input[@type='checkbox']"));
        System.out.println(checkBoxes.size());
        for (int i = 0; i < checkBoxes.size(); i++) {
            System.out.println(checkBoxes.get(i).getText());
            checkBoxes.get(i).click();
            waitTime(5000);


        }
    }

    public void clickOk() {

        if( purchaseOrderOK.isEnabled ()) {
            purchaseOrderOK.click ();
            waitTime ( 5000 );
        }
        else {System.out.println ( "Please Select purchase Order Check Box for which receipt to be created" );}
    }

    public boolean isMaterialReceiptGenerated() {
        System.out.println ( materialReceiptStatus.getAttribute ( "value" ) );
        waitTime ( 5000 );
        return materialReceiptStatus.getAttribute ( "value" ).equals ( "In Progress" );


    }
    public void clickLookupRecordOkbutton(){
        lookupRecordOkbutton.click();
       waitTime(3000);
        // waitForElementToBeDisplayed(approvedCheckbox);
    }
    public void enterDocumentNumForLookup(){
        requisitionNumberlookupBox.sendKeys(getStoredDocumentNumber());
        waitTime(3000);
    }
    public void  getDocumentNumber() {

        System.out.println ( documentNumber.getText () );
        setDocumentNumber ( documentNumber.getAttribute ( "value" ) );
//        return documentNumber.getAttribute ( "value" );

    }

    public void isMaterialReceiptRejected() {

    }

    public boolean isMaterialReceiptApproved() {
        waitTime(3000);
        clickLookupRecordIcon();
        enterDocumentNumForLookup();
        clickLookupRecordOkbutton();
        String actStatus=materialReceiptStatus.getAttribute ( "value" );

        if(actStatus.equals("Submitted"))
            return true;
        else
                return false;





    }

    public boolean isMaterialReceiptNotApproved() {
        waitTime(3000);
        clickLookupRecordIcon();
        enterDocumentNumForLookup();
        clickLookupRecordOkbutton();
        String actStatus=materialReceiptStatus.getAttribute ( "value" );

        if(actStatus.equals("Not Approved"))
            return true;
        else
            return false;
    }
}