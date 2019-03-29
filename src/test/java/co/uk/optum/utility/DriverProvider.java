package co.uk.optum.utility;

import org.apache.commons.lang.StringUtils;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static co.uk.optum.utility.CommonUtility.waitTime;

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
        System.out.println(System.getProperty ( "RemotelyYorN" ));
        System.out.println(StringUtils.isEmpty (System.getProperty ( "RemotelyYorN" )));
        System.out.println(System.getProperty ( "RemotelyYorN" ));

//        System.setProperty ( "RemotelyYorN","N");
//        System.setProperty ( "RemotelyYorN","Y");
        if (StringUtils.isEmpty (System.getProperty ( "RemotelyYorN" ))||System.getProperty ( "RemotelyYorN" ).equals ( "N") )
        {
            System.setProperty ( "webdriver.chrome.driver", driverPath );
            ChromeOptions chromeOptions = new ChromeOptions ();
            chromeOptions.setExperimentalOption ( "useAutomationExtension", false );
            driver = new ChromeDriver ( chromeOptions );
        }
        else
            {
                driver = createWebDriverSauce ();
            }
        driver.manage ().window ().maximize ();
        driver.manage ().timeouts ().implicitlyWait (10000, TimeUnit.MILLISECONDS );
    }
private RemoteWebDriver createWebDriverSauce()
{
    DesiredCapabilities capabilities = null;
    String USERNAME = "ppurnan";
    String ACCESS_KEY = "d2b60d6d-4c0e-4268-ada2-9d02b0bd8c3a";
    String URL1 = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
    capabilities = DesiredCapabilities.chrome();
    capabilities.setCapability( CapabilityType.BROWSER_NAME, "chrome");
    capabilities.setCapability(CapabilityType.VERSION, "72");
    capabilities.setCapability( CapabilityType.PLATFORM, "Windows 10");
//    capabilities.setCapability( CapabilityType.ACCEPT_INSECURE_CERTS,true);
    capabilities.setCapability( CapabilityType.ACCEPT_SSL_CERTS,true);
    capabilities.setCapability("screenResolution", "1920x1080");
    capabilities.setCapability("parent-tunnel", "optumtest");
    capabilities.setCapability("tunnelIdentifier", "Optum-Stage");
    RemoteWebDriver currentDriver = null;
    try {

        currentDriver = new RemoteWebDriver(new URL (URL1), capabilities);


        System.out.println ( currentDriver.getTitle () );
    } catch (MalformedURLException e) {
       e.printStackTrace ();
//        TestNGHelper.fail("Invalid SauceLabs URL: [" + URL + "]" + " <br> Exception Message: " + e.getStackTrace());
    }
    // log.info("Sucessfully configured connection to Sauce Labs");
    // currentDriver.setFileDetector(new LocalFileDetector());
    return currentDriver;
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