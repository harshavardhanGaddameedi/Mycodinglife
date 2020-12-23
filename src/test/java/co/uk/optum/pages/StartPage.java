package co.uk.optum.pages;

import co.uk.optum.utility.DriverProvider;
import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static co.uk.optum.utility.CommonUtility.waitTime;

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
//        driver.get(url);
        driver.navigate ().to ( url );
        waitTime(5000);
        System.out.println ( driver.getTitle () );
    }

//    public void clickStartNow(){
//        startNowBtn.click();
//    }

}
