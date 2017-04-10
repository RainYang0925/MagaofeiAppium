package com.magaofei.tal.page.talpublish;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by MAMIAN on 2017/4/10.
 */
public class Find {
    /**find*/



    protected static WebElement captureWidth (AppiumDriver<WebElement> driver) {
        return driver.findElement(By.name("captureWidth"));
    }


    protected static WebElement captureHeight (AppiumDriver<WebElement> driver) {
        return driver.findElement(By.name("captureHeight"));
    }

    protected static WebElement captureWidthCell (AppiumDriver<WebElement> driver) {
        List<WebElement> l = driver.findElements(By.className("Cell"));
        /*第三个cell*/
        return l.get(2);
    }

    /**捕捉宽度的值*/
    protected static WebElement captureWidthValue (AppiumDriver<WebElement> driver) {
        List<WebElement> l = driver.findElements(By.className("StaticText"));
        /*第七个*/
        return l.get(6);
    }

    /**捕捉高度的值*/
    protected static WebElement captureHeightValue (AppiumDriver<WebElement> driver) {
        List<WebElement> l = driver.findElements(By.className("StaticText"));
        /*第9个*/
        return l.get(8);
    }


    protected static WebElement frontTab (AppiumDriver<WebElement> driver) {
        return driver.findElement(By.name("Front"));
    }


    protected static WebElement backTab (AppiumDriver<WebElement> driver) {
        return driver.findElement(By.name("Back"));
    }

    protected static WebElement beautSwitch (AppiumDriver<WebElement> driver) {
        List<WebElement> l = driver.findElements(By.className("Switch"));
        return l.get(0);
    }

    protected static WebElement fpsTextField (AppiumDriver driver) {
        List<WebElement> l = driver.findElements(By.className("TextField"));
        return l.get(0);
    }

    protected static WebElement gopTextField (AppiumDriver driver) {
        List<WebElement> l = driver.findElements(By.className("TextField"));
        return l.get(1);
    }

    protected static WebElement rateTextField (AppiumDriver driver) {
        List<WebElement> l = driver.findElements(By.className("TextField"));
        return l.get(2);
    }

    protected static WebElement rtmpTextField (AppiumDriver driver) {
        List<WebElement> l = driver.findElements(By.className("TextField"));
        return l.get(4);
    }

    protected static WebElement otherView (AppiumDriver driver) {
        return driver.findElement(By.className("Other"));
    }

    protected static WebElement pickerWheel (AppiumDriver driver) {
        return driver.findElement(By.className("PickerWheel"));
    }

    protected static WebElement addBtn (AppiumDriver<WebElement> driver) {
        return driver.findElement(By.name("Add"));
    }

    protected static WebElement cancelBtn (AppiumDriver<WebElement> driver) {
        return driver.findElement(By.name("Cancel"));
    }

    protected static WebElement applyBtn (AppiumDriver<WebElement> driver) {
        return driver.findElement(By.name("Apply"));
    }
}
