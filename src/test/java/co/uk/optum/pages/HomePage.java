package co.uk.optum.pages;

import co.uk.optum.utility.DriverProvider;
import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotSelectableException;
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

    @FindBy(xpath = "//tr//td//div//a[contains(.,'Landing Page')]")
    WebElement landingPage;

    @FindBy(xpath="//div//ul//li//a//span[contains(.,'Landing Page')]")
    WebElement landingPageTab;

    @FindBy(xpath = "//tbody/tr/td/div/span[contains(.,'Finance')]")
//    @FindBy(xpath = "//div/div[@class='z-popup-content']/div/div[@class='z-panel-body']/div[1]/div/div[3]/table/tbody/tr[1]/td/div/span[2]")
    WebElement financeMenu;

    @FindBy(xpath = "//div/div[@class='z-popup-content']/div/div[@class='z-panel-body']/div[1]/div/div[3]/table/tbody/tr[2]/td/div/a")
    WebElement receivablesMenu;

//    @FindBy(xpath = "//div/div[@class='z-popup-content']/div/div[@class='z-panel-body']/div[1]/div/div[3]/table/tbody/tr[3]/td/div/a")
    @FindBy(xpath = "//td/div/a[contains(.,'Payables/Procurement')]")
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

    @FindBy(xpath="//tr/td/div/a/img[@src='/webui/theme/businessTeamBlue/images/mForm.png']")
    WebElement newTeamView;

    @FindBy(xpath="//div/ul/li[@class[contains(.,'z-tab-selected')]]/a/span[contains(.,'Team View')]")
    WebElement newTeamViewTab;

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

    @FindBy(xpath="//div//tr/td/div/a[contains (.,'Contract Changes')]")
    WebElement contractChanges;

    @FindBy(xpath="//div/ul/li[@class[contains(.,'z-tab-selected')]]/a/span[contains(.,'Contract Changes')]")
    WebElement contractChangeRequestTab;

    @FindBy(xpath ="//tr[@title='ApplyPensionChange']/td/div/a[contains(.,'ApplyPensionChange')]")
    WebElement pensionChangeProcess;

    @FindBy(xpath = "//div/ul/li/a/span[contains(.,'ApplyPensionChange')]")
    WebElement applyPensionTab;

    @FindBy(xpath = "//tr/td/div/a[text()='Apply Benefits Changes']")
    WebElement benefitChangeProcess;

    @FindBy(xpath = "//div/ul/li[2]/a/span[text()='Apply Benefits Changes']")
    WebElement applyBenefitTab;

<<<<<<< HEAD
    @FindBy(xpath = "//a[contains(.,'Home')]")
    WebElement homeMenu;
    @FindBy(xpath = "//img[@src[contains(.,'expand-header')]]")
    WebElement expandIcon;
    @FindBy(xpath = "//img[@src[contains(.,'collapse-header')]]")
    WebElement collapseIcon;



    // @FindBy(xpath="//tr/td/div/span[@class='global-search-box z-bandbox']/input")
=======
    @FindBy(xpath = "//tr[525]/td/div/a[text()='Check Request']")
    WebElement checkRequestProcess;

    @FindBy(xpath = "//div/ul/li/a/span[text()='Check Request']")
    WebElement checkRequestTab;



   // @FindBy(xpath="//tr/td/div/span[@class='global-search-box z-bandbox']/input")
>>>>>>> 4e1c505bb3f32c4e366af13677a902b4579c3c93
    //WebElement searchBar;

     //@FindBy(xpath="//div/a[2]/span/img[@src=\'/webui/theme/businessTeamBlue/images/expand-header.png\']")
    //WebElement expandHeader;

    //div/ul/li[@class[contains(.,'z-tab-selected')]]/a/span[contains(.,'Recruitment Request')]

    public void clickWorkflowActivities(){
        homeMenu.click();
     if (workflowActivitiesLabel.isDisplayed()){
         waitForElementToBeDisplayed (workflowActivitiesLabel  );
         workflowActivitiesLabel.click();
        }
        else{
         collapseIcon.click();
         waitForElementToBeDisplayed (workflowActivitiesLabel  );
         workflowActivitiesLabel.click();
     }


    }

    public void waitForHomePageLoad() {
        waitTime(2000);
        // expandHeader.click();
      //  WebElement expandButton=driver.findElement(By.xpath("//img[@src[contains(.,'expand-header')]]"));
        try {
            expandIcon.isDisplayed();
            System.out.print("clicking on expand button");
            expandIcon.click();
        }catch (Exception e)
        {
            System.out.println("Expand button not displayed");
        }
//        if (driver.findElement(By.xpath("//img[@src[contains(.,'expand-header')]]")).isDisplayed()){
//            driver.findElement(By.xpath("//img[@src[contains(.,'expand-header')]]")).click();
//
//        }

        waitForElementToBeDisplayed(logoutLink);
    }

    public boolean isHomeTabDispalyed() {
        waitTime(6000);
        waitForElementToBeDisplayed ( homeTab );
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

        waitTime ( 2000 );
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

        waitTime ( 2000 );
        menuIcon.click ();
        waitForElementToBeDisplayed ( hrpMenu);
        hrpMenu.click();
        waitForElementToBeDisplayed ( hrMenu);
        hrMenu.click();
        waitForElementToBeDisplayed ( teamView);
        teamView.click ();
        waitForElementToBeDisplayed (teamViewTAb);
        System.out.println ( "Teamview Opened ");
        waitTime ( 2000 );

    }

    public boolean isDashboradDisplayed() {

        return homeTab.isDisplayed();

    }

    public void iclicknewTeamView()
    {
        waitTime ( 2000 );
        menuIcon.click ();
        waitForElementToBeDisplayed ( hrpMenu);
        hrpMenu.click();
        waitForElementToBeDisplayed ( hrMenu);
        hrMenu.click();
        waitForElementToBeDisplayed(newTeamView);
        newTeamView.click();
        waitForElementToBeDisplayed(newTeamViewTab);
        waitTime ( 2000 );
    }

    public void iClickRecruitmentRequest() {

        waitTime ( 2000 );
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
        waitTime ( 2000 );
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

        waitTime ( 2000 );
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

        waitTime ( 2000 );
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

    public void openContractRequestPage(){
        waitTime ( 2000 );
        menuIcon.click ();
        waitForElementToBeDisplayed ( hrpMenu);
        hrpMenu.click();
        waitForElementToBeDisplayed ( hrMenu);
        hrMenu.click();
        waitForElementToBeDisplayed(contractChanges);
        contractChanges.click();
        waitForElementToBeDisplayed(contractChangeRequestTab);

    }

   public void openNewLandingPage()
   {
       waitTime ( 2000 );
       menuIcon.click ();
       waitForElementToBeDisplayed(landingPage);
       landingPage.click();
       waitForElementToBeDisplayed(landingPageTab);

   }

    public void searchPensionProcess(){
        menuIcon.click();
        waitForElementToBeDisplayed(pensionChangeProcess);
        pensionChangeProcess.click();
        waitForElementToBeDisplayed(applyPensionTab);

    }
    public void searchBenefitChangeProcess(){
        menuIcon.click();
        waitForElementToBeDisplayed(benefitChangeProcess);
        benefitChangeProcess.click();
        waitForElementToBeDisplayed(applyBenefitTab);
    }

    public void searchCheckRequestProcess(){
        menuIcon.click();
        waitForElementToBeDisplayed(checkRequestProcess);
        checkRequestProcess.click();
        waitForElementToBeDisplayed(checkRequestTab);
    }


//    public void selectHeader() {
//        if (driver.findElement(By.xpath("//img[@src[contains(.,'expand-header')]]")).isDisplayed())
//        {
//            driver.findElement(By.xpath("//img[@src[contains(.,'expand-header')]]")).click();
//        }
//
//    }
//
}

