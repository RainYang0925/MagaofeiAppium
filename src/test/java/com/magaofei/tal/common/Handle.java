package com.magaofei.tal.common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;

/**
 * Created by MAMIAN on 2017/3/31.
 */
public class Handle {
    public static void findElementById () {

    }

    /*验证向TextField发送的key*/
    public static void assertTestFieldSendKeys(WebElement d, String s) {
        d.click();
        d.clear();
        d.sendKeys(s);
//        sleep(500);
        Assert.assertEquals(d.getText(), s);
    }

//    public static Dimension (AppiumDriver driver) {
////        WebElement w = driver.findElement(By.className("Window"));
////        return driver.manage().window().getSize();
//        Dimension s = driver.manage().window().getSize();
////        return w.getRect();
//        return s;
//
//
//    }

    public static void click(WebElement d) {
        d.click();
    }

//    public static void sleep(long timeOut) {
//        try {
//            Thread.sleep(timeOut);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    /*拖动操作
    * 其本质是，按住然后移动到指定位置
    *
    * */
    public static void swipe (AppiumDriver<WebElement> driver, WebElement target, int x , int y, int targetX, int targetY) {
        TouchAction t = new TouchAction(driver);
        t.press(target, x, y).waitAction(300).moveTo(target, x, targetY).release().perform();
    }

    public static void customSleep (long timeOut) {
        try {
            Thread.sleep(timeOut);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*每一次Switch单击时都需要确认*/
    public static void clickSwitch (WebElement f, boolean targetValue) {
        /*如果不是目标值就点击*/
        /*
        * true  --> 打开
        * false --> 关闭
        * */
        if (!f.getAttribute("value").equals(String.valueOf(targetValue))) {
            f.click();
        }
    }



    public static void controllerSceneSleep () {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*
    * 默认1秒
    * */
    public static void defaultSleep () {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // wait不能被写在static方法中
    public void tal_wait(long timeOut) {
        try {
            wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
