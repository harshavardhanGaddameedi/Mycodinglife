package co.uk.optum.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
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

    public static String stringToContainsTag(String inputString){
        String containstag = "";
        String[] s = inputString.split(" ");

        System.out.println(s.length);
        for(int i=0; i < s.length; i++){
            if(i != s.length -1) {
                containstag += "contains(., '" + s[i] + "') and ";
            }else{
                containstag += "contains(., '" + s[i] + "')";
            }
        }
        return containstag;
    }

    public static float stringToFloat(String inputString){
        float f = Float.parseFloat(inputString);
        return f;
    }

    public static void moveElementToVisibility(WebElement webElement){
        new Actions(driver).moveToElement(webElement).perform();
    }

    public static void waitForElementToDisappear(By locator) {
        Boolean b = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

}
