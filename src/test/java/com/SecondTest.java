package com;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by ONUR on 03.12.2016.
 */
public class SecondTest extends TestBase{

    @Test
    public void GOOGLE1() throws Exception {
        System.out.println("Google1 Test Started! " + Thread.currentThread().getId());
        TLDriverFactory.getTLDriver().navigate().to("http://www.google.com");
        System.out.println("Google1 Test's Page title is: " + TLDriverFactory.getTLDriver().getTitle() + " " + Thread.currentThread().getId());
        Assert.assertEquals(TLDriverFactory.getTLDriver().getTitle(), "Google");
        System.out.println("Google1 Test Ended! " + Thread.currentThread().getId());
    }

    @Test
    public void YANDEX() throws Exception {
        System.out.println("Yandex Test Started! " + Thread.currentThread().getId());
        TLDriverFactory.getTLDriver().navigate().to("http://www.yandex.com");
        System.out.println("Yandex Test's Page title is: " + TLDriverFactory.getTLDriver().getTitle() + " " + Thread.currentThread().getId());
        Assert.assertEquals(TLDriverFactory.getTLDriver().getTitle(), "Yandex");
        System.out.println("Yandex Test Ended! " + Thread.currentThread().getId());
    }


}
