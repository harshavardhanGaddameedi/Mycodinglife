package co.uk.optum.pages.finance.payables;

import co.uk.optum.utility.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

import static co.uk.optum.utility.CommonUtility.*;
import static co.uk.optum.utility.FeatureContext.*;
import static co.uk.optum.utility.FeatureContext.getStoredDocumentNumber;

/**
 * Created by bganesa5 on 3/12/2018.
 */
public class WorkflowActivitiesPage {
    private WebDriver driver;
    public WorkflowActivitiesPage(){
        this.driver = DriverProvider.driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div/table[contains(@id, 'cave')]/tbody/tr/td[3]/div[contains(.,'Requisition')]")
    WebElement customRequisitionList;

    @FindBy(xpath = "//div[@class='z-borderlayout']/div/div/div/div/div/table/tbody/tr[7]/td[3]/div/button")
    WebElement tickButton;

    @FindBy(xpath = "//table/tbody/tr/td[3]/select")
    WebElement yesnoDropDown;

    @FindBy(xpath = "//table/tbody/tr/td[3]/select")
    WebElement approvalDropdown;
    @FindBy(xpath = "//div/table[contains(@id, 'cave')]/tbody/tr/td[3]/div[contains(.,'Shipment/Receipt')]")
    WebElement materialReceiptList;

    @FindBy(xpath = "//div/table[contains(@id, 'cave')]/tbody/tr/td[3]/div[contains(.,'Payment')]")
    WebElement paymentList;

    public void selectRequisitionForApproval(String customRequisitionNumber){
        System.out.println(customRequisitionNumber);
        waitTime ( 5000 );
//WebElement requisitionOrder=


        WebElement re=driver.findElement(By.xpath("//tr/td[3]/div[contains(.,'"+ customRequisitionNumber +"')]"));

        if (re.isDisplayed()) {
            System.out.println("found the requisition");
            re.click();
        }else{
            WebElement scrollArea = driver.findElement ( By.xpath ( "//div[@class='z-listbox-body']"));
            scroll_Page(scrollArea,100);
            re.click ();
            System.out.println("unable to find the requistion ");
           // driver.findElement(By.xpath("//div/table[contains(@id, 'cave')]/tbody/tr/td[3]/div[contains(.,'900500')]")).click();
        }
       // driver.findElement(By.xpath("//div/table[contains(@id, 'cave')]/tbody/tr/td[3]/div[contains(.,'"+ customRequisitionNumber +"')]")).click();
//        EventFiringWebDriver eventFiringWebDriver=new EventFiringWebDriver(driver);
//        eventFiringWebDriver.executeScript("document.querySelector('\n" +
//                "//td/div/input[1]//preceding::div[@class='z-listbox-body'][1]').scrollDown=500");

       // WebDriver driver = new ChromeDriver();
//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        WebElement e = driver.findElement(By.xpath("//div/table[contains(@id, 'cave')]/tbody/tr/td[3]/div[contains(.,'"+ customRequisitionNumber  +"')]"));
//        //Coordinates cor=((Locatable)e).getCoordinates();
//        Coordinates coordinates=((Locatable)e).getCoordinates();
//        coordinates.inViewPort();
        //js.executeScript("arguments[0].scrollIntoView();", Element);

//        ((JavascriptExecutor) driver.createAndGetDeviceDriver())
//        js.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath("//div/table[contains(@id, 'cave')]/tbody/tr/td[3]/div[contains(.,'"+ customRequisitionNumber +"')]")));


  //driver.findElement(By.xpath("//div/table[contains(@id, 'cave')]/tbody/tr/td[3]/div[contains(.,'"+customRequisitionNumber+"')]")).click();
    }

    public void selectAnswer(String YesOrNo){
        moveElementToVisibility(approvalDropdown);
        Select answerDropdown = new Select(driver.findElement(By.xpath("//table/tbody/tr/td[3]/select")));
        answerDropdown.selectByVisibleText(YesOrNo);
    }

    public void selectAndApproveCustomRequisition(){
        waitForElementToBeDisplayed(customRequisitionList);
        selectRequisitionForApproval(getStoredRequisitionNumber());
        waitTime(2000);
        selectAnswer("Yes");
        waitTime(2000);
        clickTickButton();
        waitTime(2000);
    }

    public void clickTickButton(){
        moveElementToVisibility(tickButton);
        tickButton.click();
    }

    public void selectAndRejectCustomRequisition() {
        waitForElementToBeDisplayed(customRequisitionList);
        selectRequisitionForApproval(getStoredRequisitionNumber());
        waitTime(2000);
        selectAnswer("No");
        waitTime(2000);
        clickTickButton();
        waitTime(2000);
    }
    private void selectMaterialReceiptForApproval(String storedDocumentNumber) {
        waitTime ( 2000 );
        driver.findElement(By.xpath("//div/table[contains(@id, 'cave')]/tbody/tr/td[3]/div[contains(.,'"+ storedDocumentNumber +"')]")).click();
    }
    public void selectAndApproveMaterialReceipt() {
        waitForElementToBeDisplayed(materialReceiptList);
        System.out.println(getStoredDocumentNumber());
        selectMaterialReceiptForApproval(getStoredDocumentNumber());
        // selectMaterialReceiptForApproval("1000093");
        waitTime(2000);
        selectAnswer("Yes");
        waitTime(2000);
        clickTickButton();
        waitTime(2000);

    }

    public void selectAndRejectMaterialReceipt() {
        waitForElementToBeDisplayed(materialReceiptList);
        System.out.println(getStoredDocumentNumber());
        selectMaterialReceiptForApproval(getStoredDocumentNumber());
        // selectMaterialReceiptForApproval("1000093");
        waitTime(2000);
        selectAnswer("No");
        waitTime(2000);
        clickTickButton();
        waitTime(2000);
    }

    public void selectAndApprovePaymentReceipt() {
        waitForElementToBeDisplayed(paymentList);
        //selectPaymentRecordForApproval(getStoredDocumentNumber());
        selectMaterialReceiptForApproval("1000227");
        waitTime(2000);
        selectAnswer("Yes");
        waitTime(2000);
        clickTickButton();
        waitTime(2000);
        ;

    }
    private void selectPaymentRecordForApproval(String storedDocumentNumber) {
        waitTime ( 2000 );
        driver.findElement(By.xpath("//div/table[contains(@id, 'cave')]/tbody/tr/td[3]/div[contains(.,'"+ storedDocumentNumber +"')]")).click();


    }

    public void selectAndRejectPaymentReceipt() {
        waitForElementToBeDisplayed(paymentList);
        selectPaymentRecordForApproval(getStoredDocumentNumber());
       // selectMaterialReceiptForApproval("1000227");
        waitTime(2000);
        selectAnswer("No");
        waitTime(2000);
        clickTickButton();
        waitTime(2000);


    }
}
