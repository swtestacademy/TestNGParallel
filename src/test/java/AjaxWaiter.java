import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ONUR on 21.01.2017.
 */
public class AjaxWaiter {

    //Wait for JQuery Load
    public static void waitForJQueryLoad(WebDriver ajaxDriver, WebDriverWait wait) {
        JavascriptExecutor jsExec = (JavascriptExecutor) ajaxDriver;

        //Wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = driver -> ((Long) ((JavascriptExecutor) ajaxDriver)
                .executeScript("return jQuery.active") == 0);

        //Get JQuery is Ready
        boolean jqueryReady = (Boolean) jsExec.executeScript("return jQuery.active==0");

        //Wait JQuery until it is Ready!
        if(!jqueryReady) {
            System.out.println("JQuery is NOT Ready!");
            //Wait for jQuery to load
            wait.until(jQueryLoad);
        } else {
            System.out.println("JQuery is Ready!");
        }
    }

    //Wait Until JS Ready
    public static void waitUntilJSReady(WebDriver ajaxDriver, WebDriverWait wait) {
        JavascriptExecutor jsExec = (JavascriptExecutor) ajaxDriver;

        //Wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) ajaxDriver)
                .executeScript("return document.readyState").toString().equals("complete");

        //Get JS is Ready
        boolean jsReady =  (Boolean) jsExec.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if(!jsReady) {
            System.out.println("JS in NOT Ready!");
            //Wait for Javascript to load
            wait.until(jsLoad);
        } else {
            System.out.println("JS is Ready!");
        }
    }

    //Wait Until JQuery and JS Ready
    public static void waitUntilJQueryReady(WebDriver ajaxDriver, WebDriverWait wait) {
        JavascriptExecutor jsExec = (JavascriptExecutor) ajaxDriver;

        //First check that JQuery is defined on the page. If it is, then wait AJAX
        Boolean jQueryDefined = (Boolean) jsExec.executeScript("return typeof jQuery != 'undefined'");
        if (jQueryDefined == true) {
            //Pre Wait for stability (Optional)
            sleep(20);

            //Wait JQuery Load
            waitForJQueryLoad(ajaxDriver,wait);

            //Wait JS Load
            waitUntilJSReady(ajaxDriver,wait);

            //Post Wait for stability (Optional)
            sleep(20);
        }  else {
            System.out.println("jQuery is not defined on this site!");
        }
    }

    public static void sleep (Integer seconds) {
        long secondsLong = (long) seconds;
        try {
            Thread.sleep(secondsLong);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
