package co.uk.optum.pages;

import co.uk.optum.utility.CommonUtility;
import co.uk.optum.utility.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.inject.Inject;

import static co.uk.optum.utility.CommonUtility.*;


public class HomePage {
    private WebDriver driver;

    @Inject
    public HomePage() {
        this.driver = DriverProvider.driver;
        PageFactory.initElements(driver, this);
    }

    //    @FindBy(linkText = "Log Out")
    @FindBy(xpath = "//tbody/tr/td/table/tbody/tr/td[13]/a/span[contains(.,'Log Out')]")
    WebElement logoutLink;

    @FindBy(xpath = "//span[contains(.,'Home')]")
    WebElement homeTab;

    @FindBy(xpath = "//tbody/tr/td[5]/button[@title='Menu']")
    WebElement menuIcon;

    @FindBy(xpath = "//tbody/tr/td/div/span[contains(.,'Finance')]")
//    @FindBy(xpath = "//div/div[@class='z-popup-content']/div/div[@class='z-panel-body']/div[1]/div/div[3]/table/tbody/tr[1]/td/div/span[2]")
    WebElement financeMenu;

    @FindBy(xpath = "//div/div[@class='z-popup-content']/div/div[@class='z-panel-body']/div[1]/div/div[3]/table/tbody/tr[2]/td/div/a")
    WebElement receivablesMenu;

    @FindBy(xpath = "//div/div[@class='z-popup-content']/div/div[@class='z-panel-body']/div[1]/div/div[3]/table/tbody/tr[3]/td/div/a")
    WebElement payablesProcurementMenu;

    @FindBy(xpath = "//div/div[@class='z-popup-content']/div/div[@class='z-panel-body']/div[1]/div/div[3]/table/tbody/tr[4]/td/div/a")
    WebElement receivablesCoreRevenueMenu;

    @FindBy(xpath = "//div/div[@class='z-popup-content']/div/div[@class='z-panel-body']/div[1]/div/div[3]/table/tbody/tr[5]/td/div/a")
    WebElement receivablesPrivateRevenueMenu;

    @FindBy(xpath = "//div/div[@class='z-popup-content']/div/div[@class='z-panel-body']/div[1]/div/div[3]/table/tbody/tr[6]/td/div/a")
    WebElement receivablesCashDeskMenu;


    public void waitForHomePageLoad() {
        waitForElementToBeDisplayed(logoutLink);
    }

    public boolean isHomeTabDispalyed() {
        waitTime(6000);
        return homeTab.isDisplayed();
    }

    public void clickLogout() {
        logoutLink.click();
    }

    public void clickMenuIcon() {
        menuIcon.click();
        waitForElementToBeDisplayed(financeMenu);
    }

    public void clickPayablesProcurementMenu() {
        payablesProcurementMenu.click();
    }

    public void clickReceivablesPrivateRevenueMenu() {
        receivablesPrivateRevenueMenu.click();
    }

    public void clickFinanceMenu(){
        financeMenu.click();
        waitForElementToBeDisplayed(payablesProcurementMenu);
    }
}
