import org.openqa.selenium.WebDriver;

public class LocalDriverManager {
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return webDriver.get();
    }

    static void setWebDriver(WebDriver driver) {
        webDriver.set(driver);
    }
}