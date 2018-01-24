package co.uk.optum.utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static co.uk.optum.utility.DriverProvider.driver;

public class CommonUtility {

    public static void waitForElementToBeDisplayed(WebElement webElement) {
        WebElement element = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    public static String getFutureDate(int numberOfDaysLater){
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
        Date currentDate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.DATE, 5);
        Date futureDate = cal.getTime();
        String ddString = sdf.format(futureDate);
        return ddString;
    }

    public static void waitTime(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void waitForElementToBeEnabled(WebElement webElement){
        WebElement element = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.elementToBeClickable(webElement));

    }

}
