import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by ONUR on 03.12.2016.
 */
public class TestBase {

    //Declare ThreadLocal Driver for ThreadSafe Tests
    //protected ThreadLocal<RemoteWebDriver> driver = null;

    public ThreadLocal<WebDriver> driver;

    public void browserFactory (String browser, DesiredCapabilities caps) {
        if (browser.equals("firefox")) {
            driver = ThreadLocal.withInitial(() -> {
                return new FirefoxDriver(caps); //You can use other driver based on your requirement.
            });
        } else if (browser.equals("chrome")) {
            driver = ThreadLocal.withInitial(() -> {
                return new ChromeDriver(caps); //You can use other driver based on your requirement.
            });
        }
    }

    //Do the test setup
    @BeforeMethod
    @Parameters(value={"browser","platform"})
    public void setupTest (String browser, String platform) throws MalformedURLException {
        //Assign driver to a ThreadLocal
        //driver = new ThreadLocal<>();

        //Set DesiredCapabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //Firefox Profile Settings
        if (browser.equals("firefox")) {
            FirefoxProfile profile = new FirefoxProfile();
            //Accept Untrusted Certificates
            profile.setAcceptUntrustedCertificates(true);
            profile.setAssumeUntrustedCertificateIssuer(false);
            //Use No Proxy Settings
            profile.setPreference("network.proxy.type", 0);
            //Set Firefox profile to capabilities
            capabilities.setCapability(FirefoxDriver.PROFILE, profile);
        }
        //Set Platform
        capabilities.setCapability("platform", platform);
        //Set BrowserName
        capabilities.setCapability("browserName", browser);
        //driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities));
        //driver.set(WebDriver, capabilities);
        browserFactory(browser, capabilities);
    }

    public WebDriver getDriver() {
        return driver.get();
    }


    @AfterClass
    public void tearDown() throws Exception {
        getDriver().quit();
    }

    void waitForPageLoad () {
        ExpectedCondition pageLoads = driver1 -> (Boolean)((JavascriptExecutor) driver1).executeScript("return document.readyState").equals("complete");
        WebDriverWait wait = new WebDriverWait(driver.get(), 30);
        wait.until(pageLoads);
    }

}
