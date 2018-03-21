package co.uk.optum.pages.finance.payables;

import co.uk.optum.utility.DriverProvider;
import co.uk.optum.utility.FeatureContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.inject.Inject;

import static co.uk.optum.utility.CommonUtility.waitForElementToBeDisplayed;
import static co.uk.optum.utility.FeatureContext.*;

/**
 * Created by bganesa5 on 2/12/2018.
 */
public class PayablesProcurementPage {
    private final WebDriver driver;

    @Inject
    public PayablesProcurementPage(){
        this.driver = DriverProvider.driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//tr/td/img[@title[contains(.,'Material Requisitions')]]")
    WebElement customRequisitionWrokFlowIcon;

    @FindBy(xpath = "//div/ul/li[@class[contains(.,'z-tab-selected')]]/a/span[contains(.,'Custom Requisition')]")
    WebElement customRequisitionTab;

    @FindBy(xpath = "//tr/td/img[@title[contains(.,'Create Purchase orders from Purchase Requisitions')]]")
    WebElement createPOfromRequisitionWorkFlowIcon;

    @FindBy(xpath = "//div/ul/li[@class[contains(.,'z-tab-selected')]]/a/span[contains(.,'Create PO from Requisition')]")
    WebElement createPOfromRequisitionTab;

    public void clickCreatePOfromRequisition(){
        createPOfromRequisitionWorkFlowIcon.click();
        waitForElementToBeDisplayed(createPOfromRequisitionTab);
    }

    public void waitForCustomRequisitionIconToDisplay(){
        waitForElementToBeDisplayed(customRequisitionWrokFlowIcon);
    }

    public void clickCustomRequisition(){
        customRequisitionWrokFlowIcon.click();
        waitForElementToBeDisplayed(customRequisitionTab);
    }
}
