package com;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by ONUR on 03.12.2016.
 */
public class FirstTest extends TestBase {

    @Test
    public synchronized void GOOGLE0() throws Exception {
            System.out.println("Google0 Test Started! " + Thread.currentThread().getId());
            driver.navigate().to("http://www.google.com");
            System.out.println("Google0 Test's Page title is: " + driver.getTitle() + " " + Thread.currentThread().getId());
            Assert.assertEquals(driver.getTitle(), "Google");
            System.out.println("Google0 Test Ended! " + Thread.currentThread().getId());

    }

    @Test
    public  void GOOGLE2() throws Exception {
            System.out.println("Google2 Test Started! " + Thread.currentThread().getId());
            driver.navigate().to("http://www.google.com");
            System.out.println("Google2 Test's Page title is: " + driver.getTitle() + " " + Thread.currentThread().getId());
            Assert.assertEquals(driver.getTitle(), "Google");
            System.out.println("Google2 Test Ended! " + Thread.currentThread().getId());

    }

    @Test
    public  void GOOGLE3() throws Exception {
            System.out.println("Google3 Test Started! " + Thread.currentThread().getId());
            driver.navigate().to("http://www.google.com");
            System.out.println("Google3 Test's Page title is: " + driver.getTitle() + " " + Thread.currentThread().getId());
            Assert.assertEquals(driver.getTitle(), "Google");
            System.out.println("Google3 Test Ended! " + Thread.currentThread().getId());

    }

    @Test
    public  void GOOGLE4() throws Exception {
        System.out.println("Google4 Test Started! " + Thread.currentThread().getId());
        driver.navigate().to("http://www.google.com");
        System.out.println("Google3 Test's Page title is: " + driver.getTitle() + " " + Thread.currentThread().getId());
        Assert.assertEquals(driver.getTitle(), "Google");
        System.out.println("Google3 Test Ended! " + Thread.currentThread().getId());

    }

}
