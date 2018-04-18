package co.uk.optum.pages;

import co.uk.optum.utility.CommonUtility;
import co.uk.optum.utility.DriverProvider;
import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage{
    private final WebDriver driver;
    private final String url;

//    @FindBy(linkText = "Start now")
//    WebElement startNowBtn;

    @Inject
    public StartPage() {
        driver = DriverProvider.driver;
        url = DriverProvider.TESTURL;
        PageFactory.initElements(driver, this);
    }

    public void load() {
        driver.get(url);
    }

//    public void clickStartNow(){
//        startNowBtn.click();
//    }

}
