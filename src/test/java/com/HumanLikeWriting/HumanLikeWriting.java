package com.HumanLikeWriting;

import com.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by ONUR on 21.01.2017.
 */
public class HumanLikeWriting extends TestBase{


    protected void writeLikeHuman (By by, String text){
        //Add Explicit and Asynchronous Wait
        //I only add explicit wait
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        String str = text;
        System.out.println("Text: " + text);
        WebElement element = driver.findElement(by);
        element.click();
        element.clear();

        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            String s = new StringBuilder().append(c).toString();
            System.out.println("Character: " + s);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            element.sendKeys(s);
        }
    }
}
