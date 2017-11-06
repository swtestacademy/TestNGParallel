package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;

/**
 * Created by ONUR on 03.12.2016.
 */
public class TestBase {

    protected WebDriver driver;
    protected WebDriverWait wait;
    private TLDriverFactory TLDriverFactory = new TLDriverFactory();
    private DesiredCapsManager desiredCapsManager = new DesiredCapsManager();
    // private final static Object objectLock= new Object();



    //Do the test setup
    @BeforeMethod
    @Parameters(value={"browser","platform"})
    public  void setupTest (@Optional String browser, @Optional String platform) throws MalformedURLException {
        //browser="chrome";
        //platform="WINDOWS";
        //Get DesiredCapabilities
        DesiredCapabilities capabilities = desiredCapsManager.getDesiredCapabilities(browser,platform);
        //Set & Get ThreadLocal Driver with Browser
        TLDriverFactory.setTLDriver(browser, capabilities);
        driver = TLDriverFactory.getTLDriver().get();
        wait = new WebDriverWait(driver, 15);

    }


    @AfterMethod
    public synchronized void tearDown() throws Exception {
        driver.quit();
        TLDriverFactory.getTLDriver().remove();
    }

}
