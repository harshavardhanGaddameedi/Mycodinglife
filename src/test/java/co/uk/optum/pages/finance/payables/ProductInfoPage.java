package co.uk.optum.pages.finance.payables;

import co.uk.optum.utility.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.inject.Inject;

import static co.uk.optum.utility.CommonUtility.waitForElementToBeDisplayed;
import static co.uk.optum.utility.CommonUtility.waitForElementToBeEnabled;
import static co.uk.optum.utility.CommonUtility.waitTime;

/**
 * Created by bganesa5 on 2/14/2018.
 */
public class ProductInfoPage {
    private final WebDriver driver;

    @Inject
    public ProductInfoPage(){
        this.driver = DriverProvider.driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='confirm-panel-left z-hlayout']/div[1]/button[@class='img-btn btn-refresh z-button']")
    WebElement refreshButton;

    @FindBy(xpath = "//tr[@class='grid-layout z-row']/td[4]/div/div/input[@instancename='Name']")
    WebElement productNameTextbox;

    @FindBy(xpath = "//tr/td/div/span[@class='z-listitem-checkable z-listitem-checkbox']")
    WebElement prodcutCheckBox;

    @FindBy(xpath = "//div[@class='confirm-panel-right z-hlayout']/div[1]/button[@class='img-btn btn-ok z-button']")
    WebElement greenTickButton;

    public void clickOk(){
        waitForElementToBeEnabled(greenTickButton);
        greenTickButton.click();
    }

    public void clickProductCheckbox(){
        prodcutCheckBox.click();
    }

    public void enterProductNameToSearch(String productName){
        productNameTextbox.sendKeys(productName);
    }

    public void clickRefereshButton(){
        refreshButton.click();
        waitForElementToBeDisplayed(prodcutCheckBox);
    }

    public void searchAndSelectAProduct(){
        enterProductNameToSearch("Hepatitis");
        waitTime(2000);
        clickRefereshButton();
        clickProductCheckbox();
        clickOk();
        waitTime(10000);
    }

}
