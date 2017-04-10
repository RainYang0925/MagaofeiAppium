package com.magaofei.tal.common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSTouchAction;
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

    /*验证向TextField发送的key
    * 由于是固定操作，所以封装起来
    * 先点击
    * 再清除
    * 再发送
    * 最后验证
    * */
    public static void assertTestFieldSendKeys(WebElement d, String s) {
        d.click();
        d.clear();
        d.sendKeys(s);
//        sleep(500);
        Assert.assertEquals(d.getText(), s);
    }

    public static void assertStaticTextValue (WebElement d, String s) {
        Assert.assertEquals(d.getText(), s);
    }

    /**寻找到当前页面的Window*/
    public static WebElement window (AppiumDriver<WebElement> driver) {
        return driver.findElement(By.className("Window"));
    }

    public static void iosDoubleClick (AppiumDriver<WebElement> driver, WebElement t, int x, int y) {
        IOSTouchAction d = new IOSTouchAction(driver);
        d.doubleTap(t, x, y);
        /*
        必须要加perform才生效
        * */
        d.perform();
    }


    public static void click(WebElement d) {
        d.click();
    }




    /*拖动操作
    * 其本质是，按住然后移动到指定位置
    *
    * */
    public static void swipe (AppiumDriver<WebElement> driver, WebElement target, int x , int y, int targetX, int targetY) {
        TouchAction t = new TouchAction(driver);
        t.press(target, x, y).waitAction(300).moveTo(target, x, targetY).release().perform();
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



    /*自定义等待时长*/
    public static void customSleep (long timeOut) {
        try {
            Thread.sleep(timeOut);
        } catch (InterruptedException e) {
            e.printStackTrace();
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
