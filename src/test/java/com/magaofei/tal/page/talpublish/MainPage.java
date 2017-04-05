package com.magaofei.tal.page.talpublish;

import com.magaofei.tal.common.Handle;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSTouchAction;
import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import java.util.Random;

/**
 * Created by MAMIAN on 2017/4/5.
 */
public class MainPage {

    private static String rtmpUrl = "rtmp://10.2.250.92/live_haibian/";

    public static void toSettingsController (AppiumDriver<WebElement> driver) {
        /*
        * 1. 双击跳转
        * */

//        WebElement startPreview = driver.findElement(By.name("StartPreview"));
//        WebElement MuteSpeaker = driver.findElement(By.name("MuteSpeaker"));
//        WebElement StartPush = driver.findElement(By.name("StartPush"));
//        WebElement StartRecord = driver.findElement(By.name("StartRecord"));
//
//        WebElement window = driver.findElement(By.className("Window"));
//        WebElement bottomView = driver.findElement(By.xpath("//UIApplication[1]//UIWindow[1]//UIOther[2]"));
        WebElement bottomView = driver.findElement(By.className("Other"));



//        // 获取StartPreview的位置 + 宽度，往右偏移20px
//        int settingX = startPreview.getRect().getX() + startPreview.getRect().getWidth() + 20;
//        int centerX = window.getSize().getWidth() / 2;
//        int settingY = window.getSize().getHeight() - 20;
//
//        System.out.println("centerX=" + centerX);
//        System.out.println("startPreviewY=" + startPreview.getRect().getY());
//        System.out.println("muteSpeaker=" + MuteSpeaker.getRect().getY());
//        System.out.println("StartPush=" + StartPush.getRect().getY());
//        System.out.println("StartRecord=" + StartRecord.getRect().getY());

        // 实现双击功能



//        System.out.println(centerX);
//        System.out.println(settingY);

        IOSTouchAction doubleClickIOS = new IOSTouchAction(driver);
//        doubleClickIOS.doubleTap(window, centerX, settingY);
//        doubleClickIOS.doubleTap(window);
        doubleClickIOS.doubleTap(bottomView, 1, 1);
        /*
        必须要加perform才生效
        * */
        doubleClickIOS.perform();


    }
    public static void clickStartPreviewBtn (AppiumDriver<WebElement> driver) {
        WebElement d = driver.findElement(By.name("StartPush"));
        d.click();
    }
    public static void clickStartPushBtn (AppiumDriver<WebElement> driver) {
        WebElement d = driver.findElement(By.name("StartPush"));
        d.click();
    }

    public static void clickStopPreviewBtn (AppiumDriver<WebElement> driver) {
        WebElement d = driver.findElement(By.name("StopPush"));
        d.click();
    }
    public static void clickStopPushBtn (AppiumDriver<WebElement> driver) {
        WebElement d = driver.findElement(By.name("StopPush"));
        d.click();
    }

    public static void clickMuteSpeakerBtn (AppiumDriver<WebElement> driver) {
        WebElement d = driver.findElement(By.name("MuteSpeaker"));
        d.click();
    }
    public static void clickStartRecordBtn (AppiumDriver<WebElement> driver) {
        WebElement d = driver.findElement(By.name("StartRecord"));
        d.click();
    }

    public static void assertFpsTextField (AppiumDriver<WebElement> driver) {
        WebElement t = driver.findElement(By.xpath("//Application[1]//Window[1]//Other[1]//Other[1]//TextField[1]"));
        t.click();
        t.clear();

        Random r = new Random();
        int n = r.nextInt(30)+ 1;

        Handle.assertTestFieldSendKeys(t, String.valueOf(n));

        t.sendKeys(String.valueOf(n));

        Handle.sleep(1000);

        Assert.assertEquals(t.getText(), String.valueOf(n));
    }

    public static void assertGopTextField (AppiumDriver<WebElement> driver) {
        WebElement t = driver.findElement(By.className("TextField[2]"));
        t.click();
        t.clear();

        Random r = new Random();
        int n = r.nextInt(7)+ 1;

        t.sendKeys(String.valueOf(n));

        Handle.sleep(1000);

        Assert.assertEquals(t.getText(), String.valueOf(n));
    }

    public static void assertRateTextField (AppiumDriver<WebElement> driver) {
        WebElement t = driver.findElement(By.className("TextField[3]"));
        t.click();
        t.clear();

        Random r = new Random();
        int n = r.nextInt(488)+ 512;

        t.sendKeys(String.valueOf(n) + 000);

        Handle.sleep(1000);

        Assert.assertEquals(t.getText(), String.valueOf(n));
    }

    public static void assertRtmpTextField (AppiumDriver<WebElement> driver) {
        WebElement t = driver.findElement(By.className("TextField[5]"));
//        t.click();

        Random r = new Random();
        int n = r.nextInt(100)+ 1;

        String rtmpUrlString = rtmpUrl + String.valueOf(n);

        /*最后随机生成一个数字作为地址*/
//        t.sendKeys(rtmpUrlString);

        Handle.assertTestFieldSendKeys(t, rtmpUrlString);

//        Handle.sleep(500);
//
//        Assert.assertEquals(t.getText(), rtmpUrlString);
//
//        Handle.sleep(500);

        WebElement rtmpLabel = driver.findElement(By.name(rtmpUrlString));
        rtmpLabel.isDisplayed();

    }

    public static void clickAddBtn (AppiumDriver<WebElement> driver) {
        /*点击add 按钮*/
        WebElement add = driver.findElement(By.name("Add"));
        add.click();
    }

    public static void clickCancelBtn (AppiumDriver<WebElement> driver) {
        WebElement d = driver.findElement(By.name("Cancel"));
        d.click();
    }


    public static void clickApplyBtn (AppiumDriver<WebElement> driver) {
        WebElement d = driver.findElement(By.name("Apply"));
        d.click();
    }


    public static void changeDefinition (AppiumDriver<WebElement> driver, boolean up) {
        /*
        切换清晰度, 默认480P
        */
        WebElement pickerWheel = driver.findElement(By.className("PickerWheel"));

        /*思路：获取到picker的中心位置，在其Y轴上偏移上下20点，进行Tap*/
        int settingX = pickerWheel.getRect().getWidth() / 2;
        int settingY = pickerWheel.getSize().getHeight() / 2;

        /*
        * 如果是往上走，就y-20
        * 如果是往下走，就y+20
        *
        * */
        if (up) {
            settingY -= 20;
        } else {
            settingY += 20;
        }

        TouchAction pickerWheelChangeValue = new TouchAction(driver);
        pickerWheelChangeValue.tap(pickerWheel, settingX, settingY);
        pickerWheelChangeValue.perform();

        Handle.sleep(2000);



    }

}
