package co.uk.optum.pages.hr;

import co.uk.optum.utility.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.hotkey.Keys;

import javax.inject.Inject;

import static co.uk.optum.utility.CommonUtility.*;
import static co.uk.optum.utility.FeatureContext.getStoredRequisitionNumber;

public class HRAdminChangePersonalDataPage {

    private final WebDriver driver;
    public String midName;

    @Inject
    public HRAdminChangePersonalDataPage() {
        this.driver = DriverProvider.driver;
        PageFactory.initElements ( driver, this );
    }

    @FindBy(xpath = "//div/a[@title[contains(.,'Lookup')]]/span[@class='z-toolbarbutton-content']/img[@src[contains(.,'Find24')]]")
    WebElement lookupRecordIcon;

    @FindBy(xpath = "//span[@class='z-group-icon-close z-group-icon']")
    WebElement advSearch;


    @FindBy(xpath = ".//span[@instancename='he_change_status']//a[@class='z-combobox-button']/i")
    WebElement kindOfUpdate;

    @FindBy(xpath = ".//span[@instancename='he_change_status']//input")
    WebElement kindOfUpdateTxt;


    @FindBy(xpath = ".//span[@title='Request Status']//a[@class='z-combobox-button']/i")
    WebElement statusDropdown;

    @FindBy(xpath = "//input[@instancename='he_employee_number']")
    WebElement empID;

    @FindBy(xpath = "//table/tbody/tr/td[3]/div/button[@title='OK']")
    WebElement okButton;

    @FindBy(xpath = "//div[@class='adwindow-north z-div']/div/div/div[@class='z-toolbar-content z-toolbar-start']/a[@title[contains(., 'Save changes')]]/span[@class='z-toolbarbutton-content']/img[@src[contains(., 'Save')]]")
    WebElement saveButton;

    @FindBy(xpath = ".//span[@title='Request Status']/input")
    WebElement statusInput;

    public void searchRequestAndApprove() {
        searchRequest();
        waitTime ( 2000 );
        approveRequest();


    }
    private void approveRequest() {

        statusDropdown.click ();
        waitForElementToBeDisplayed ( driver.findElement( By.xpath("//li/span["+ stringToContainsTag("15_Pre-Approved")+"]")) );
        driver.findElement(By.xpath("//li/span["+ stringToContainsTag("15_Pre-Approved")+"]")).click();
        waitTime(1000);
        saveButton.click ();
        waitTime ( 3000 );



        }

    private void searchRequest() {

        lookupRecordIcon.click ();
        waitForElementToBeDisplayed(advSearch);
        advSearch.click ();
        waitForElementToBeDisplayed ( kindOfUpdate );
        clickKindOfUpdate();
        waitForElementToBeDisplayed ( driver.findElement( By.xpath("//li/span["+ stringToContainsTag("Update my name")+"]"))) ;
        driver.findElement(By.xpath("//li/span["+ stringToContainsTag("Update my name")+"]")).click();
        waitTime ( 1000 );
        empID.sendKeys ( getStoredRequisitionNumber() );
        statusDropdown.click ();
        waitForElementToBeDisplayed ( driver.findElement( By.xpath("//li/span["+ stringToContainsTag("0_Created")+"]")) );
        driver.findElement(By.xpath("//li/span["+ stringToContainsTag("0_Created")+"]")).click();
        waitTime(1000);
        okButton.click ();
    }

    private void clickKindOfUpdate() {

        kindOfUpdate.click();
//        waitTime(2000);

    }


    public boolean isSaveSuccessfull() {
        return  (statusInput.getAttribute ( "value" ).equals ( "10_Accepted" ));

    }

    public void searchBankDetailRequestAndApprove() {

        lookupRecordIcon.click ();
        waitForElementToBeDisplayed(advSearch);
        advSearch.click ();
        waitForElementToBeDisplayed ( kindOfUpdate );
        kindOfUpdateTxt.sendKeys ( "Update my Bank details"+ Keys.TAB );

        waitTime ( 1000 );
        empID.sendKeys ( getStoredRequisitionNumber() );
        statusDropdown.click ();
        waitForElementToBeDisplayed ( driver.findElement( By.xpath("//li/span["+ stringToContainsTag("0_Created")+"]")) );
        driver.findElement(By.xpath("//li/span["+ stringToContainsTag("0_Created")+"]")).click();
        waitTime(1000);
        okButton.click ();
        waitTime ( 2000 );

        statusDropdown.click ();
        waitForElementToBeDisplayed ( driver.findElement( By.xpath("//li/span["+ stringToContainsTag("15_Pre-Approved")+"]")) );
        driver.findElement(By.xpath("//li/span["+ stringToContainsTag("15_Pre-Approved")+"]")).click();
        waitTime(1000);
        saveButton.click ();
        waitTime ( 3000 );

    }
}
