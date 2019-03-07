package co.uk.optum.utility;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

public class DriverProvider {

    public static WebDriver driver;
    public static String TESTURL = "https://ldlq3v-gpmweb.dev.unitedhealth.local/webui/";


    @Before
    public void setDriver() throws IOException {
        loadChromeDriver(System.getProperty("user.dir") + "//src//test//resources//config//chromedriver.exe");
//        loadDriver(System.getProperty("user.dir") + "//src//test//resources//config//geckodriver.exe");

    }

    private void loadDriver(String driverPath) {
        System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    private void loadChromeDriver(String driverPath) {
        System.setProperty("webdriver.chrome.driver", driverPath);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("useAutomationExtension", false);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }


    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed ()) {
            try {
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs ( OutputType.BYTES );
                scenario.embed ( screenshot, "image/png" );
                driver.close ();
                driver.quit ();
            } catch (Exception e) {

            }
        }
        driver.close ();
        driver.quit ();

    }

}