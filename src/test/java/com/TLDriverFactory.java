package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by onurb on 19-Dec-16.
 */
public class TLDriverFactory {

    private  ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public synchronized void setTLDriver (String browser, DesiredCapabilities caps) {
        if (browser.equals("firefox")) {
            tlDriver = ThreadLocal.withInitial(() -> {
                return new FirefoxDriver(caps); //You can use other driver based on your requirements.
            });
        } else if (browser.equals("chrome")) {
            tlDriver = ThreadLocal.withInitial(() -> {
                return new ChromeDriver(caps); //You can use other driver based on your requirements.
            });
        }
    }

    public synchronized ThreadLocal<WebDriver> getTLDriver () {
        return tlDriver;
    }
}
