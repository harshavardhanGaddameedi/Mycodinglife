package co.uk.optum.pages.finance.receivables;

import co.uk.optum.utility.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static co.uk.optum.utility.CommonUtility.moveElementToVisibility;
import static co.uk.optum.utility.CommonUtility.waitForElementToBeDisplayed;
import static co.uk.optum.utility.CommonUtility.waitTime;
import static co.uk.optum.utility.DriverProvider.driver;
import static co.uk.optum.utility.FeatureContext.getStoredRequisitionNumber;

public class WorkflowActivitiesPage {

    private final WebDriver driver ;

    public WorkflowActivitiesPage(){
        this.driver = DriverProvider.driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div/table[contains(@id, 'cave')]/tbody/tr/td[3]/div[contains(.,'Order')]")
    WebElement revenueOrderList;

    @FindBy(xpath = "//div[@class='z-borderlayout']/div/div/div/div/div/table/tbody/tr[7]/td[3]/div/button")
    WebElement tickButton;

    @FindBy(xpath = "//table/tbody/tr/td[3]/select")
    WebElement yesnoDropDown;

    @FindBy(xpath = "//table/tbody/tr/td[3]/select")
    WebElement approvalDropdown;

    public void selectAndApproveRevenueOrder()
    {
        waitForElementToBeDisplayed(revenueOrderList);
//        System.out.println ( "Continuing" );
        System.out.println ( getStoredRequisitionNumber() );
        selectRevenueOrderForApproval(getStoredRequisitionNumber());
        waitTime(2000);
        selectAnswer("Yes");
        waitTime(2000);
        clickTickButton();
        waitTime(5000);

    }

    public void selectAnswer(String YesOrNo){
        moveElementToVisibility(approvalDropdown);
        Select answerDropdown = new Select(driver.findElement(By.xpath("//table/tbody/tr/td[3]/select")));
        answerDropdown.selectByVisibleText(YesOrNo);
    }

    public void selectRevenueOrderForApproval(String storedRequisitionNumber) {

//        System.out.println ( "Continuing------------------" );
        waitTime ( 2000 );
        driver.findElement( By.xpath("//div/table[contains(@id, 'cave')]/tbody/tr/td[3]/div[contains(.,'"+ storedRequisitionNumber +"')]")).click();
        waitTime ( 3000 );

//        System.out.println ( "Clicked" );
    }

    public void     clickTickButton(){
        moveElementToVisibility(tickButton);
        tickButton.click();
    }

    public void selectAndRejectRevenueOrder() {

        waitForElementToBeDisplayed(revenueOrderList);
//        System.out.println ( "Continuing" );
        System.out.println ( getStoredRequisitionNumber() );
        selectRevenueOrderForApproval(getStoredRequisitionNumber());
        waitTime(2000);
        selectAnswer("No");
        waitTime(2000);
        clickTickButton();
        waitTime(5000);
    }
}
