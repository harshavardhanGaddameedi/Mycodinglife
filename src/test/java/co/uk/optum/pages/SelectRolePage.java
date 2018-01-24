package co.uk.optum.pages;

import co.uk.optum.utility.CommonUtility;
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

    @Inject
    public SelectRolePage(){
        this.driver = DriverProvider.driver;
        PageFactory.initElements(driver, this);
    }

     @FindBy(xpath = "//button/img[contains(@src,'Ok')]")
    WebElement okBtnSelectRolePage;

    @FindBy(xpath = "//button/img[contains(@src,'Cancel')]")
    WebElement cancelBtnSelectRolePage;

    @FindBy(xpath = "//tbody/tr[contains(@id,'rowOrganisation')]/td[2]/span/a")
    WebElement organisationDropdownIcon;

    @FindBy(xpath = "//tbody/tr[contains(@id,'rowRole')]/td[2]/span/a")
    WebElement roleDropdownIcon;

    public void selectOrganisation(String orgName){
        driver.findElement(By.xpath("//body/div[2]/ul/li/span[contains(.,'"+ orgName +"')])")).click();
    }

    public void clickSelectRolePageOkBtn(){
        okBtnSelectRolePage.click();
    }

    public void waitForSelectRolePageOkBtnToBeDisplayed(){
        waitForElementToBeDisplayed(okBtnSelectRolePage);
    }

    public boolean isOkBtnSelectRolePageDisplayed(){
        return okBtnSelectRolePage.isDisplayed();
    }
}
