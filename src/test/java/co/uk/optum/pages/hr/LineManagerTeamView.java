package co.uk.optum.pages.hr;

import co.uk.optum.utility.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.inject.Inject;

import static co.uk.optum.utility.CommonUtility.waitForElementToBeDisplayed;
import static co.uk.optum.utility.CommonUtility.waitTime;

public class LineManagerTeamView {

    private final WebDriver driver;

    @Inject
    public LineManagerTeamView() {
        this.driver = DriverProvider.driver;
        PageFactory.initElements ( driver, this );
    }

    @FindBy(xpath = "//div/a[@title[contains(.,'Lookup')]]/span[@class='z-toolbarbutton-content']/img[@src[contains(.,'Find24')]]")
    WebElement lookupRecordIcon;

    @FindBy(xpath = "//table/tbody/tr/td/div/div/input[@instancename='subordinate']")
    WebElement lookupPosition;

    @FindBy(xpath = "//table/tbody/tr/td[3]/div/button[@title='OK']")
    WebElement lookupRecordOkbutton;

    @FindBy(xpath = "//div/ul/li[@class[contains(.,'z-tab-selected')]]/a/span[contains(.,'Team View')]")
    WebElement teamViewTab;

    @FindBy(xpath = "//div[@class='z-toolbar']/div/a/span/img[@src[contains(.,'Last24.png')]]")
    WebElement selectPostiontoSearch;

    @FindBy(xpath = ".//*//div[@class [contains(.,'z-grid-body z-word-nowrap')]]")
    WebElement gridLayout;

//    @FindBy(xpath = "//div[@class='z-toolbar']/div/a/span/img[@src[contains(.,'/webui/theme/default/images/Last24.png')]]")
//    WebElement selectPostiontoSearch;

    @FindBy( xpath="//div/a[@title[contains(.,'Export Example')]]/span[@class='z-toolbarbutton-content']/img[@src[contains(.,'export')]]")
    WebElement exportExamples;

    @FindBy(xpath = "//div/ul/li[@class[contains(.,'z-tab-selected')]]/a/span[contains(.,'*Recruitment Request')]")
    WebElement newRecruitmentRequestTab;




    public void searchPosition() {
        lookupRecordIcon.click ();

    }

    public void enterPositionToSearch(String position) {

        waitForElementToBeDisplayed ( lookupPosition );
        lookupPosition.sendKeys ( position );


    }

    public void clickOKTeamviewSearch() {
        lookupRecordOkbutton.click ();
        waitForElementToBeDisplayed ( teamViewTab );
        System.out.println ( "Position Searched" );
        waitForElementToBeDisplayed ( gridLayout );
        System.out.println ( "Search Completed" );
    }

    public void selectPostionFromGrid()
    {

        waitForElementToBeDisplayed ( selectPostiontoSearch );

        if (selectPostiontoSearch.isEnabled ())
        {
            selectPostiontoSearch.click ();
            ;
        }
           waitTime(2000);
    }

    public void iClickExportExamples() {

        exportExamples.click ();
        System.out.println ( "Export Examples Clicked" );
        waitForElementToBeDisplayed (  newRecruitmentRequestTab);
        System.out.println ( newRecruitmentRequestTab.getText () );


    }

    public boolean isRecruitmentRequestPageDisplayed() {
        return newRecruitmentRequestTab.isDisplayed ();


    }


    public void closeTeamViewTab() {



    }
}
