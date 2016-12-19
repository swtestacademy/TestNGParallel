import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by onurb on 19-Dec-16.
 */
public class BrowserFactory {

    public ThreadLocal<WebDriver> getBrowser (String browser, DesiredCapabilities caps, ThreadLocal<WebDriver> driver) {
        if (browser.equals("firefox")) {
            driver = ThreadLocal.withInitial(() -> {
                return new FirefoxDriver(caps); //You can use other driver based on your requirement.
            });
        } else if (browser.equals("chrome")) {
            driver = ThreadLocal.withInitial(() -> {
                return new ChromeDriver(caps); //You can use other driver based on your requirement.
            });
        }
        return driver;
    }
}
