package co.uk.optum.pages;

import co.uk.optum.utility.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.inject.Inject;

import static co.uk.optum.utility.CommonUtility.*;


public class SelectRolePage {
    private final WebDriver driver;
    private final HomePage homePage;

    @Inject
    public SelectRolePage(){
        this.driver = DriverProvider.driver;
        PageFactory.initElements(driver, this);
        this.homePage = new HomePage();
    }

     @FindBy(xpath = "//button/img[contains(@src,'Ok')]")
    WebElement okBtnSelectRolePage;

    @FindBy(xpath = "//button/img[contains(@src,'Cancel')]")
    WebElement cancelBtnSelectRolePage;

    @FindBy(xpath = "//tbody/tr[contains(@id,'rowOrganisation')]/td[2]/span/a")
    WebElement organisationDropdownIcon;

    @FindBy(xpath = "//tbody/tr[contains(@id,'rowRole')]/td[2]/span/a")
    WebElement roleDropdownIcon;

    public void clickRoleDropDownIcon(){
        roleDropdownIcon.click();
        waitTime(2000);
    }
    public void selectOrganisation(String orgName){
        clickOrganisationDropDownIcon();
        driver.findElement(By.xpath("//li/span["+ stringToContainsTag(orgName)+"]")).click();
    }

    public void clickOrganisationDropDownIcon(){
        organisationDropdownIcon.click();
        waitTime(2000);
    }

    public void clickSelectRolePageOkBtn(){
        okBtnSelectRolePage.click();
        homePage.waitForHomePageLoad();
    }

    public void waitForSelectRolePageOkBtnToBeDisplayed(){
        waitForElementToBeDisplayed(okBtnSelectRolePage);
    }

    public boolean isOkBtnSelectRolePageDisplayed(){
        return okBtnSelectRolePage.isDisplayed();
    }

    public void selectRole(String role){
        clickRoleDropDownIcon();
        waitForElementToBeDisplayed ( driver.findElement(By.xpath("//li/span["+ stringToContainsTag(role)+"]"))) ;
        driver.findElement(By.xpath("//li/span["+ stringToContainsTag(role)+"]")).click();
    }

    public boolean isRolePageDispalyed() {

        waitForElementToBeDisplayed ( roleDropdownIcon );
        return roleDropdownIcon.isDisplayed();
    }
}
