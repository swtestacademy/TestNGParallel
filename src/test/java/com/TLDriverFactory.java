package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by onurb on 19-Dec-16.
 */
public class TLDriverFactory {

    OptionsManager optionsManager = new OptionsManager();
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public synchronized void setTLDriver (String browser) {
        if (browser.equals("firefox")) {
            tlDriver = ThreadLocal.withInitial(() -> new FirefoxDriver(optionsManager.getFirefoxOptions()));
        } else if (browser.equals("chrome")) {
            tlDriver = ThreadLocal.withInitial(() -> new ChromeDriver(optionsManager.getChromeOptions()));
        }
    }

    public synchronized ThreadLocal<WebDriver> getTLDriver () {
        return tlDriver;
    }

}
