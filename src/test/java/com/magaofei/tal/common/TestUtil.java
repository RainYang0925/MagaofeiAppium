package com.magaofei.tal.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

/**
 * Created by MAMIAN on 2017/3/26.
 */
public class TestUtil {


    public static WebElement inputFieldAssert(String name, int type, WebDriver driver) throws Exception {
        WebElement d = driver.findElement(By.id(name));
        WebElement dClassName = driver.findElement(By.className(name));
        WebElement dXpathName = driver.findElement(By.xpath(name));

        d.click();
        d.clear();

//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        d.sendKeys("123");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals(d, "123");

        return d;
    }


}
