package com;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by ONUR on 03.12.2016.
 */
public class FirstTest extends TestBase {

    @Test(priority=1)
    public void YAHOO() throws Exception {
        System.out.println("Yahoo Test Started! " + Thread.currentThread().getId());
        driver.navigate().to("http://www.yahoo.com");
        System.out.println("Yahoo Test's Page title is: " + driver.getTitle() +" "+ Thread.currentThread().getId());
        Assert.assertEquals(driver.getTitle(), "Yahoo");
        System.out.println("Yahoo Test Ended! " + Thread.currentThread().getId());
    }

    @Test(priority=2)
    public void GOOGLE2() throws Exception {
        System.out.println("Google2 Test Started! " + Thread.currentThread().getId());
        driver.navigate().to("http://www.google.com");
        System.out.println("Google2 Test's Page title is: " + driver.getTitle() +" "+ Thread.currentThread().getId());
        Assert.assertEquals(driver.getTitle(), "Google");
        System.out.println("Google2 Test Ended! " + Thread.currentThread().getId());
    }

    @Test(priority=3)
    public void GOOGLE3() throws Exception {
        System.out.println("Google3 Test Started! " + Thread.currentThread().getId());
        driver.navigate().to("http://www.google.com");
        System.out.println("Google3 Test's Page title is: " + driver.getTitle() +" "+ Thread.currentThread().getId());
        Assert.assertEquals(driver.getTitle(), "Google");
        System.out.println("Google3 Test Ended! " + Thread.currentThread().getId());
    }

}
