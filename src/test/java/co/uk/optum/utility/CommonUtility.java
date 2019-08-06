package co.uk.optum.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static co.uk.optum.utility.DriverProvider.driver;

public class CommonUtility {

    public static void waitForElementToBeDisplayed(WebElement webElement) {
        WebElement element = (new WebDriverWait(driver, 120))
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void waitForElementEnabled(WebElement webElement) {

        WebElement element1 = (new WebDriverWait(driver, 30))
        .until(ExpectedConditions.elementToBeClickable(webElement));


}

    public static boolean scroll_Page(WebElement webelement, int scrollPoints)
    {
        try
        {
            Actions dragger = new Actions(driver);
            // drag downwards
            int numberOfPixelsToDragTheScrollbarDown = 10;
            for (int i = 10; i < scrollPoints; i = i + numberOfPixelsToDragTheScrollbarDown)
            {
                dragger.moveToElement(webelement).clickAndHold().moveByOffset(0, numberOfPixelsToDragTheScrollbarDown).release(webelement).build().perform();
            }
            Thread.sleep(500);
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
    public static String getFutureDate(int numberOfDaysLater){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        Date currentDate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.DATE, numberOfDaysLater);
        Date futureDate = cal.getTime();
        String ddString = sdf.format(futureDate);
        return ddString;
    }


    public static String randomAlphaNumeric(int count) {

        String ALPHA_NUMERIC_STRING = "123456789ABCDEF";
        StringBuilder builder = new StringBuilder();

        while (count-- != 0) {

            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());

            builder.append(ALPHA_NUMERIC_STRING.charAt(character));

        }

        return builder.toString();

    }



    public static String randomAccountName(int count) {

        String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder builder = new StringBuilder();

        while (count-- != 0) {

            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());

            builder.append(ALPHA_NUMERIC_STRING.charAt(character));

        }

        return builder.toString();

    }

    public static String randomAccountNumber(int count) {

        String ALPHA_NUMERIC_STRING = "123456789";
        StringBuilder builder = new StringBuilder();

        while (count-- != 0) {

            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());

            builder.append(ALPHA_NUMERIC_STRING.charAt(character));

        }

        return builder.toString();

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


    public static String toAbsolutePath(String relativePath) {
        Path path = Paths.get(relativePath);
        Path effectivePath = path;
        if (!path.isAbsolute()) {
            Path base = Paths.get("");
            effectivePath = base.resolve(path).toAbsolutePath();
        }
        return effectivePath.normalize().toString();
    }

}
