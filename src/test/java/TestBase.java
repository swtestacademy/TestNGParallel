import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class TestBase {

    //Declare ThreadLocal Driver (ThreadLocalMap) for ThreadSafe Tests
    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    @Parameters(value={"browser"})
    public void setupTest (String browser) throws MalformedURLException {
        //Set DesiredCapabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        
        //Set BrowserName
        capabilities.setCapability("browserName", browser);

        //Set Browser to ThreadLocalMap
        driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities));
    }

    public WebDriver getDriver() {
        //Get driver from ThreadLocalMap
        return driver.get();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        getDriver().quit();
    }

    @AfterClass void terminate () {
        //Remove the ThreadLocalMap element
        driver.remove();
    }
}
