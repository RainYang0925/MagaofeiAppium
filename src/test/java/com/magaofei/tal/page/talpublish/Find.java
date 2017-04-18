package com.magaofei.tal.page.talpublish;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.List;

/**
 * Created by MAMIAN on 2017/4/10.
 */
public class Find {
    /**find*/



    protected static MobileElement captureWidth (AppiumDriver<MobileElement> driver) {
        return driver.findElementByAccessibilityId("captureWidth");
    }


    protected static MobileElement captureHeight (AppiumDriver<MobileElement> driver) {
        return driver.findElementByAccessibilityId("captureHeight");
    }

    protected static MobileElement captureWidthCell (AppiumDriver<MobileElement> driver) {
        List<MobileElement> l = driver.findElements(By.className("Cell"));
        /*第三个cell*/
        return l.get(2);
    }

    /**捕捉宽度的值*/
    protected static MobileElement captureWidthValue (AppiumDriver<MobileElement> driver) {
        List<MobileElement> l = driver.findElements(By.className("StaticText"));
        /*第七个*/
        return l.get(6);
    }

    /**捕捉高度的值*/
    protected static MobileElement captureHeightValue (AppiumDriver<MobileElement> driver) {
        List<MobileElement> l = driver.findElements(By.className("StaticText"));
        /*第9个*/
        return l.get(8);
    }


    protected static MobileElement frontTab (AppiumDriver<MobileElement> driver) {
//        return driver.findElementByAccessibilityId("Front"));
        // 推荐写法
        return driver.findElementByAccessibilityId("Front");
    }


    protected static MobileElement backTab (AppiumDriver<MobileElement> driver) {
        return driver.findElementByAccessibilityId("Back");
    }

    protected static MobileElement beautSwitch (AppiumDriver<MobileElement> driver) {
        List<MobileElement> l = driver.findElements(By.className("Switch"));
        return l.get(0);
    }

    protected static MobileElement fpsTextField (AppiumDriver<MobileElement> driver) {
        List<MobileElement> l = driver.findElements(By.className("TextField"));
        return l.get(0);
    }

    protected static MobileElement gopTextField (AppiumDriver<MobileElement> driver) {
        List<MobileElement> l = driver.findElements(By.className("TextField"));
        return l.get(1);
    }

    protected static MobileElement rateTextField (AppiumDriver<MobileElement> driver) {
        List<MobileElement> l = driver.findElements(By.className("TextField"));
        return l.get(2);
    }

    protected static MobileElement rtmpTextField (AppiumDriver<MobileElement> driver) {
        List<MobileElement> l = driver.findElements(By.className("TextField"));
        return l.get(4);
    }

    protected static MobileElement otherView (AppiumDriver<MobileElement> driver) {
//        return driver.findElement(By.className("Other"));
        return driver.findElementByClassName("Other");
    }

    protected static MobileElement pickerWheel (AppiumDriver<MobileElement> driver) {
        return driver.findElement(By.className("PickerWheel"));


    }

    protected static MobileElement addBtn (AppiumDriver<MobileElement> driver) {
        return driver.findElementByAccessibilityId("Add");
    }

    protected static MobileElement cancelBtn (AppiumDriver<MobileElement> driver) {
        return driver.findElementByAccessibilityId("Cancel");
    }

    protected static MobileElement applyBtn (AppiumDriver<MobileElement> driver) {
//        By e = MobileBy.AccessibilityId("Apply");
//        return e;
        return driver.findElementByAccessibilityId("Apply");

    }
}
