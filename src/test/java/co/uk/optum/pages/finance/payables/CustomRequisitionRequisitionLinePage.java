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
public class CustomRequisitionRequisitionLinePage {
    private final WebDriver driver;
    private final ProductInfoPage productInfoPage;

    @Inject
    public CustomRequisitionRequisitionLinePage(){
        this.driver = DriverProvider.driver;
        PageFactory.initElements(driver,this);
        this.productInfoPage = new ProductInfoPage();
    }

    @FindBy(xpath = "//div[@title='Product, Service, Item']/button/img[@src[contains(., 'Product')]]")
    WebElement productIcon;

    @FindBy(xpath = "//div[@class='adwindow-breadcrumb z-div']/table/tbody/tr/td/table/tbody/tr/td[5]/span[contains(., 'Requisition Line')]")
    WebElement requisitionLineText;

    @FindBy(xpath = "//td/div[@title='Quantity']/input")
    WebElement quantityTextBox;

    @FindBy(xpath = "//div[@class='adwindow-north z-div']/div/div/div[@class='z-toolbar-content z-toolbar-start']/a[@title[contains(., 'Save changes')]]/span[@class='z-toolbarbutton-content']/img[@src[contains(., 'Save')]]")
    WebElement saveIcon;

    @FindBy(xpath = "//a[@title='Parent Record   Alt+Up']/span/img[@src[contains(., 'Parent')]]")
    WebElement upArrowIcon;

    public void clickUpArrow(){
        upArrowIcon.click();
    }

    public void clickSave(){
        saveIcon.click();
        waitTime(3000);
    }

    public void enterQuantity(String quantity){
        quantityTextBox.clear();
        quantityTextBox.sendKeys(quantity);
    }

    public void waitForRequisitionLineText(){
        waitForElementToBeDisplayed(requisitionLineText);
    }

    public void clickProductIcon(){
        productIcon.click();
    }

    public void selectAProduct(){
        clickProductIcon();
        waitTime(4000);
        productInfoPage.searchAndSelectAProduct();
        enterQuantity("10");
        waitForElementToBeEnabled(upArrowIcon);
        waitForElementToBeEnabled(saveIcon);
        waitTime(4000);
        clickSave();
        clickUpArrow();
    }

}
