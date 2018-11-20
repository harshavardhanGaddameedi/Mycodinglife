package co.uk.optum.pages;

import co.uk.optum.utility.DriverProvider;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.inject.Inject;

import static co.uk.optum.utility.CommonUtility.waitForElementToBeDisplayed;
import static co.uk.optum.utility.CommonUtility.waitTime;


public class  HomePage {

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

//    @FindBy(xpath = "//div/div[@class='z-popup-content']/div/div[@class='z-panel-body']/div[1]/div/div[3]/table/tbody/tr[3]/td/div/a")
    @FindBy(xpath = "//div/a[contains(.,'Payables/Procurement')]")
    WebElement payablesProcurementMenu;

    @FindBy(xpath = "//div/div[@class='z-popup-content']/div/div[@class='z-panel-body']/div[1]/div/div[3]/table/tbody/tr[4]/td/div/a")
    WebElement receivablesCoreRevenueMenu;

    @FindBy(xpath = "//div/div[@class='z-popup-content']/div/div[@class='z-panel-body']/div[1]/div/div[3]/table/tbody/tr[5]/td/div/a")
    WebElement receivablesPrivateRevenueMenu;

    @FindBy(xpath = "//div/div[@class='z-popup-content']/div/div[@class='z-panel-body']/div[1]/div/div[3]/table/tbody/tr[6]/td/div/a")
    WebElement receivablesCashDeskMenu;

    @FindBy(xpath = "//table/tbody/tr[3]/td/div/div/div/span[contains(.,'Workflow Activities')]")
    WebElement workflowActivitiesLabel;

    @FindBy(xpath =".//div/table//tr[@class='z-treerow z-treerow-selected']/td/div/a" )
    WebElement receivables;


    @FindBy(xpath ="//div[@class='z-panel-body']//table/tbody/tr[6]/td/div/a" )
    WebElement receivablesCashDesk;

    @FindBy (xpath = "//div/ul/li[@class[contains(.,'z-tab-selected')]]/a/span[contains(.,'Receivables_Cash_Desk')]")
    WebElement receivablesCashDeskTab;

    @FindBy(xpath = "//div/ul/li[@class[contains(.,'z-tab-selected')]]/a/span[contains(.,'Revenue Invoice Cash')]")
    WebElement revenueInvoiceCashTab;

    @FindBy(xpath = "//div/ul/li[@class[contains(.,'z-tab-selected')]]/a/span[contains(.,'Receivables Core Revenue')]")
    WebElement receivablesCoreRevenueTab;


    @FindBy(xpath = "//div//tr/td/div/span [contains(.,'Human Resource & Payroll')]")
    WebElement hrpMenu;

        @FindBy(xpath= "//div//tr/td/div/span[3][contains(.,'Human Resource')]")
        WebElement hrMenu;

//        //div//tr/td/div/span[4][contains(.,'Requests')]

     @FindBy(xpath= "//div//tr/td/div/span[4][contains(.,'Requests')]")
     WebElement requestMenu;

     @FindBy(xpath = "//div//tr/td/div/a[contains (.,'Recruitment Request')]")
     WebElement recruitmentRequestMenu;


    //div//div[@class [contains(.,'z-tree-body')]]/table//tr/td/div/a[contains(.,'New Position Request')]
    @FindBy(xpath = "//div//div[@class [contains(.,'z-tree-body')]]/table//tr/td/div/a[contains(.,'New Position Request')]")
    WebElement newPositionRequest;

    @FindBy(xpath = "//div//div[@class [contains(.,'z-tree-body')]]/table//tr/td/div/a[contains(.,'Team View')]")
    WebElement teamView;


    @FindBy(xpath = "//div//div[@class [contains(.,'z-tree-body')]]/table//tr/td/div/a[contains(.,'Details View')]")
    WebElement myDetailsView;

    @FindBy(xpath = "//div//div[@class [contains(.,'z-tree-body')]]/table//tr/td/div/a[contains(.,'Change Personal Data')]")
    WebElement changePersonalData;

    @FindBy(xpath = "//div/ul/li[@class[contains(.,'z-tab-selected')]]/a/span[contains(.,'Change Personal Data')]")
    WebElement changePersonalDataTab;

    @FindBy(xpath = "//div/ul/li[@class[contains(.,'z-tab-selected')]]/a/span[contains(.,'My Details View')]")
    WebElement myDetailsViewTab;

    @FindBy(xpath = "//div/ul/li[@class[contains(.,'z-tab-selected')]]/a/span[contains(.,'Team View')]")
    WebElement teamViewTAb;


    @FindBy(xpath = "//div/ul/li[@class[contains(.,'z-tab-selected')]]/a/span[contains(.,'New Position Request')]")
    WebElement newPositionRequestTab;


    @FindBy(xpath = "//div/ul/li[@class[contains(.,'z-tab-selected')]]/a/span[contains(.,'*Recruitment Request')]")
    WebElement newRecruitmentRequestTab;

    @FindBy(xpath = "//div/ul/li[@class[contains(.,'z-tab-selected')]]/a/span[contains(.,'Recruitment Request')]")
    WebElement recruitmentRequestTab;


    @FindBy(xpath = "//div//tr/td/div/a[contains (.,'Leaver Request')]")
    WebElement leaverRequest;




    @FindBy(xpath = "//div/ul/li[@class[contains(.,'z-tab-selected')]]/a/span[contains(.,'Leaver')]")
    WebElement leaverRequestTab;

    //div/ul/li[@class[contains(.,'z-tab-selected')]]/a/span[contains(.,'Recruitment Request')]

    public void clickWorkflowActivities(){
        workflowActivitiesLabel.click();
    }

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
        waitTime(2000);
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
        waitTime ( 5000 );
//        waitForElementToBeDisplayed(payablesProcurementMenu);
//        waitForElementToBeDisplayed(receivablesPrivateRevenueMenu);
//        waitForElementToBeDisplayed(receivablesCashDesk);
//        waitForElementToBeDisplayed (receivablesCoreRevenueMenu);


    }

    public void clickReceivables() {

        receivables.click();

    }

     public void clickReceivablesCashDesk () {
        receivablesCashDesk.click ();
        waitForElementToBeDisplayed ( receivablesCashDeskTab );
        System.out.println ( "Receivables Cash Desk Clicked" );

    }

    public void clickReceivablesCoreRevenue() {
        receivablesCoreRevenueMenu.click ();
        waitForElementToBeDisplayed ( receivablesCoreRevenueTab );


    }

    public void iClickNewPositonRequest() {

        menuIcon.click ();
        waitForElementToBeDisplayed ( hrpMenu);
        hrpMenu.click();
        waitForElementToBeDisplayed ( hrMenu);
        hrMenu.click();
        waitForElementToBeDisplayed ( requestMenu);
        requestMenu.click();
        waitForElementToBeDisplayed ( newPositionRequest);
        newPositionRequest.click();
        waitForElementToBeDisplayed ( newPositionRequestTab );
    }

    public void waitForNewPositionTabTobeDisplayed() {
        waitForElementToBeDisplayed ( newPositionRequestTab );
    }

    public void iClickTeamView() {

        menuIcon.click ();
        waitForElementToBeDisplayed ( hrpMenu);
        hrpMenu.click();
        waitForElementToBeDisplayed ( hrMenu);
        hrMenu.click();
        waitForElementToBeDisplayed ( teamView);
//        requestMenu.click();
        teamView.click ();
        waitForElementToBeDisplayed (teamViewTAb);
        System.out.println ( "Teamview Opened ");
        waitTime ( 2000 );

    }

    public boolean isDashboradDisplayed() {

        return homeTab.isDisplayed();

    }

    public void iClickRecruitmentRequest() {

        menuIcon.click ();
        waitForElementToBeDisplayed ( hrpMenu);
        hrpMenu.click();
        waitForElementToBeDisplayed ( hrMenu);
        hrMenu.click();
        waitForElementToBeDisplayed ( teamView);
        requestMenu.click();
        waitForElementToBeDisplayed ( recruitmentRequestMenu );
        recruitmentRequestMenu.click();
        waitForElementToBeDisplayed ( recruitmentRequestTab );
        System.out.println ("newRecruitmentRequestTab Opened");
//        teamView.click ();
//        waitForElementToBeDisplayed (teamViewTAb);
//        System.out.println ( "Teamview Opened ");
        waitTime ( 2000 );

    }

    public void clickMyDetailsView() {
        menuIcon.click ();
        waitForElementToBeDisplayed ( hrpMenu);
        hrpMenu.click();
        waitForElementToBeDisplayed ( hrMenu);
        hrMenu.click();
        waitForElementToBeDisplayed ( myDetailsView);
        myDetailsView.click ();
        waitForElementToBeDisplayed ( myDetailsViewTab );


    }

    public void openChangePersonaDataPage() {

        waitForElementToBeDisplayed ( menuIcon );
        menuIcon.click ();
        waitForElementToBeDisplayed ( hrpMenu );
        hrpMenu.click ();
        waitForElementToBeDisplayed ( hrMenu );
        hrMenu.click ();
        waitForElementToBeDisplayed ( requestMenu );
        requestMenu.click ();
        waitForElementToBeDisplayed ( changePersonalData );
        changePersonalData.click ();
        waitForElementToBeDisplayed ( changePersonalDataTab);
        Assert.assertTrue (" Change Personal Data Tab Not Opened",changePersonalDataTab.isDisplayed ());


    }

    public void openLeaverRequestPage() {

        menuIcon.click ();
        waitForElementToBeDisplayed ( hrpMenu);
        hrpMenu.click();
        waitForElementToBeDisplayed ( hrMenu);
        hrMenu.click();
        waitForElementToBeDisplayed ( requestMenu );
        requestMenu.click ();
        waitForElementToBeDisplayed (  leaverRequest);
        leaverRequest.click();
        waitForElementToBeDisplayed ( leaverRequestTab );


    }
}
