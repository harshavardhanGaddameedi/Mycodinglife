package co.uk.optum.pages;

import co.uk.optum.utility.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.inject.Inject;

import static co.uk.optum.utility.CommonUtility.waitForElementToBeDisplayed;
import static co.uk.optum.utility.FeatureContext.getTotalLineAmount;


public class LoginPage{
    private final WebDriver driver;
    private final HomePage homePage;

    @FindBy(xpath = "//tr[@id='rowUser']/td[2]/input[@class='z-textbox']")
    WebElement userName;

    @FindBy(xpath = "//tr[@id='rowPassword']/td[2]/input[@class='z-textbox']")
    WebElement passowrd;

    @FindBy(xpath = "//tr[@id='rowLanguage']/td[2]/span/a[@class='z-combobox-button']")
    WebElement comboboxButton;

    @FindBy(xpath = "//body/div/ul/li/span[2][contains(., 'English')]")
    WebElement englishLang;

    @FindBy(xpath = "//body/div/ul/li/span[2][contains(., 'Colombia')]")
    WebElement colombiaLang;

    @FindBy(xpath = "//tr[@id='rowSelectRole']/td[2]/span[@class='z-checkbox']")
    WebElement selectRoleCheckbox;

    @FindBy(xpath = "//tbody/tr/td/div/div/div/div/div[2]/div/div[3]/div[1]/button")
    WebElement okButton;

    @Inject
    public LoginPage(){


        this.driver = DriverProvider.driver;
        PageFactory.initElements(driver, this);
        this.homePage = new HomePage();
    }


    public void enterUserName(String userid){
        userName.sendKeys(userid);
    }

    public void enterPassword(String pass){
        passowrd.sendKeys(pass);
    }

    public void clickLogin(){
        okButton.click();
     }

    public void waitForUserNameFieldToBeDisplayed(){
        waitForElementToBeDisplayed(userName);
    }

    public boolean isSelectRoleChecked(){
        System.out.println("Select Role Check box Selected : "+ selectRoleCheckbox.isSelected());
        System.out.println("Select Role Check box enabled : "+ selectRoleCheckbox.isEnabled());
        return selectRoleCheckbox.isSelected();
    }

    public void clickSelectRoleCheckbox(){
        selectRoleCheckbox.click();
    }

    public String[] getApprovalUser(){
        String[] user = new String[2];
        float totalLineAmount = Float.parseFloat(getTotalLineAmount());
        if (totalLineAmount < 1000.00){
            user[0] = "PracticeManager";
            user[1] = "PracticeManager";
        }else if(totalLineAmount >= 1000.00 && totalLineAmount < 10000.00){
            user[0] = "FinanceBP1";
            user[1] = "FinanceBP1";
        }else if(totalLineAmount >= 10000.00 && totalLineAmount < 20000.00 ){
            user[0] = "FinanceController1";
            user[1] = "FinanceController1";
        }else if(totalLineAmount >= 20000.00){
            user[0] = "FinanceDirector1";
            user[1] = "FinanceDirector1";
        }
        return user;
    }

    public void selectRole() {
        selectRoleCheckbox.click ();

    }
}
