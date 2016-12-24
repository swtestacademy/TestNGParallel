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

    public WebDriver driver;

    private TLDriverFactory TLDriverFactory = new TLDriverFactory();
    private DesiredCapsManager desiredCapsManager = new DesiredCapsManager();

    //Do the test setup
    @BeforeMethod
    @Parameters(value={"browser","platform"})
    public void setupTest (String browser, String platform) throws MalformedURLException {
        //Get DesiredCapabilities
        DesiredCapabilities capabilities = desiredCapsManager.getDesiredCapabilities(browser,platform);
        //Set & Get ThreadLocal Driver with Browser
        TLDriverFactory.setTLDriver(browser, capabilities);
        driver = TLDriverFactory.getTLDriver().get();
    }

/*    public WebDriver getWebDriver() {
        return tlDriver.get();
    }*/

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

/*    void waitForPageLoad () {
        ExpectedCondition pageLoads = (WebDriver driver) -> (Boolean)((JavascriptExecutor) driver).
                executeScript("return document.readyState").equals("complete");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoads);
    }*/

}
