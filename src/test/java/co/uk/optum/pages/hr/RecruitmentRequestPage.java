package co.uk.optum.pages.hr;

import co.uk.optum.utility.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.hotkey.Keys;

import javax.inject.Inject;
import java.util.List;

import static co.uk.optum.utility.CommonUtility.getFutureDate;
import static co.uk.optum.utility.FeatureContext.setRequisitionNumber;

public class RecruitmentRequestPage {


    private final WebDriver driver;

    @Inject
    public RecruitmentRequestPage() {
        this.driver = DriverProvider.driver;
        PageFactory.initElements ( driver, this );
    }

    @FindBy(xpath = "//div//table//tr//td//span[@instancename='R_Request0he_type_recr']/input[@class='z-combobox-input']")
    WebElement typeOfRecruitment;


    @FindBy(xpath = "//div//table//tr/td/textarea[@title='Textual summary of this request']")
    WebElement businessCase;

    @FindBy(xpath = "//div//table//tr//td//span[@instancename='R_Request0R_Status_ID']/input[@class='z-combobox-input']")
    WebElement recruitmentStatus;


    @FindBy(xpath = "//div//table//tr//td//span[@instancename='R_Request0R_Status_ID']/input")
    WebElement recruitmentStatusReadOnly;

    @FindBy(xpath = "//div//table//tr//td//span[@instancename='R_Request0he_startdate']/input[@class='z-datebox-input']")
    WebElement dateProposedTextBox;

    @FindBy(xpath = "//div//div[@class='adwindow-north z-div']//div/a/span/img[@src='/webui/theme/default/images/Save24.png']")
    WebElement saveButton;


    @FindBy(xpath = "//div//div//table//tr//td/input[@title='Document sequence number of the document']")
    WebElement recruitmentDocNumber;


    public void setData(String type_of_recruitment, String business_case, String status) {
        typeOfRecruitment.sendKeys ( type_of_recruitment+ Keys.TAB );
        businessCase.sendKeys(business_case+Keys.TAB);
        recruitmentStatus.clear ();
        recruitmentStatus.sendKeys(status+Keys.TAB);

        System.out.println ( "Data Entered" );
    }

    public void setProposedDate(int days) {

                dateProposedTextBox.clear();
        dateProposedTextBox.sendKeys(getFutureDate(days));


    }

    public void clickSaveButton() {

//        waitForElementToBeDisplayed ( saveButton );

        List<WebElement> checkBoxes = driver.findElements ( By.xpath ( "//div//div[@class='adwindow-north z-div']//div/a/span/img[@src='/webui/theme/default/images/Save24.png']" ) );
        System.out.println ( checkBoxes.size () );
        for (int i = 0; i < checkBoxes.size (); i++) {
        if (checkBoxes.get ( i ).isDisplayed ())
            if (checkBoxes.get ( i ).isEnabled ()) {
                checkBoxes.get ( i ).click ();
                System.out.println ( "Saved" );

            }
        }

    }

    public boolean isRecruitmentRequestSentForApproval(String status) {

        String recruitmentRequestStatus = recruitmentStatusReadOnly.getAttribute ( "value" );
        System.out.println ( recruitmentStatusReadOnly.getAttribute ( "value" ) );
        return  recruitmentRequestStatus.equals ( status );




    }

    public void setRecruitmentDocNumber() {
        setRequisitionNumber ( recruitmentDocNumber.getAttribute ( "value" ) );
    }
}
