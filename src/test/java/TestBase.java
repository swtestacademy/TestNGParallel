import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

/**
 * Created by ONUR on 03.12.2016.
 */
public class TestBase {

    public ThreadLocal<WebDriver> tlDriver;

    BrowserFactory browserFactory = new BrowserFactory();
    DesiredCaps desiredCaps = new DesiredCaps();

    //Do the test setup
    @BeforeMethod
    @Parameters(value={"browser","platform"})
    public void setupTest (String browser, String platform) throws MalformedURLException {
        //Get DesiredCapabilities
        DesiredCapabilities capabilities = desiredCaps.getDesiredCapabilities(browser,platform);
        //Get ThreadLocal Driver with Browser
        tlDriver = browserFactory.getBrowser(browser, capabilities,tlDriver);
    }

    public WebDriver getDriver() {
        return tlDriver.get();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        getDriver().quit();
    }

    void waitForPageLoad () {
        ExpectedCondition pageLoads = driver1 -> (Boolean)((JavascriptExecutor) driver1).
                executeScript("return document.readyState").equals("complete");
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(pageLoads);
    }

}
