package co.uk.optum.pages.finance.payables;

import co.uk.optum.utility.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static co.uk.optum.utility.CommonUtility.*;
import static co.uk.optum.utility.FeatureContext.*;

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

    public void selectRequisitionForApproval(String customRequisitionNumber){
        driver.findElement(By.xpath("//div/table[contains(@id, 'cave')]/tbody/tr/td[3]/div[contains(.,'"+ customRequisitionNumber +"')]")).click();
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

}
