package co.uk.optum.pages.finance.payables;

import co.uk.optum.utility.CommonUtility;
import co.uk.optum.utility.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.inject.Inject;

import static co.uk.optum.utility.CommonUtility.*;

/**
 * Created by bganesa5 on 3/20/2018.
 */
public class CreatePOFromRequisition {
    private final WebDriver driver;
    private final CustomPurchaseOrderPage customPurchaseOrderPage;
    @Inject
    public CreatePOFromRequisition(){
        this.driver = DriverProvider.driver;
        PageFactory.initElements(driver,this);
        this.customPurchaseOrderPage = new CustomPurchaseOrderPage();
    }

    @FindBy(xpath = "//td/div/span[@title='Material Requisition']/a")
    WebElement requisitionComboboxButton;

    @FindBy(xpath = "//div[@class[contains(.,'z-combobox-popup')] and @class[contains(.,'z-combobox-open')] and @class[contains(.,'z-combobox-shadow')]]/ul")
    WebElement requisitionComboboxListItems;

    @FindBy(xpath = "//div[@class='bottom-container z-div']/div[2][@class='button-container z-div']/button[@class='txt-btn btn-ok z-button']")
    WebElement okButton;

    @FindBy(xpath = "//div/span[2][contains(.,'Processing ... Please wait ...')]")
    By processingPleaseWaitLabelLocator;

    @FindBy(xpath = "//table/tbody/tr/td[2]/a[contains(.,'Generated PO')]")
    WebElement generatedPOLink;

    public void clickGeneratedPOLink(){
        generatedPOLink.click();
        customPurchaseOrderPage.waitForPurchaseOrderTextBox();
    }

    public void clickOkButton(){
        moveElementToVisibility(okButton);
        okButton.click();
//        waitForElementToDisappear(processingPleaseWaitLabelLocator);
        waitForElementToBeDisplayed(generatedPOLink);
    }

    public void clickRequisitionComboboxButton(){
        waitForElementToBeDisplayed(requisitionComboboxButton);
        requisitionComboboxButton.click();
        waitForElementToBeDisplayed(requisitionComboboxListItems);
    }

    public void selectRequisitionFromList(String requisitionNumber){
        driver.findElement(By.xpath("//li/span[2][contains(.,'"+ requisitionNumber +"')]")).click();
    }

    public void selectApprovedRequisitionAndGeneratePO(String requisitionNumber){
        clickRequisitionComboboxButton();
        selectRequisitionFromList(requisitionNumber);
        clickOkButton();
        clickGeneratedPOLink();
    }


}
