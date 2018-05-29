package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;

/**
 * Created by ONUR on 03.12.2016.
 */
public class TestBase {

    protected WebDriverWait wait;

    //Do the test setup
    @BeforeMethod
    @Parameters(value={"browser"})
    public void setupTest (@Optional String browser) throws MalformedURLException {
        //Set & Get ThreadLocal Driver with Browser
        TLDriverFactory.setTLDriver(browser);
        wait = new WebDriverWait(TLDriverFactory.getTLDriver(), 15);
    }

    @AfterMethod
    public synchronized void tearDown() throws Exception {
        TLDriverFactory.getTLDriver().quit();
    }

}
