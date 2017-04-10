package com.magaofei.tal.page.talpublish;

import com.magaofei.tal.common.Handle;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.junit.Assert;
import com.magaofei.tal.page.talpublish.Find;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

/**
 * Created by MAMIAN on 2017/4/5.
 * 存储页面上的所有可点击元素的操作
 */
public class MainPage {



    private static String rtmpUrl = "rtmp://10.2.250.92/live_haibian/";

    /**校验设置推流的值是否正确*/
    public static void assertCaptureValue (AppiumDriver<WebElement> driver) {
        /*思路
        * 1. 点击屏幕中心跳转
        * 2. 找到CaptureWidth 和 CaptureHeight
        * 3. 校验值
        *
        *
        * */




    }

    /**跳转到当前推流的详细信息*/
    private static void toDetailsInfo (AppiumDriver<WebElement> driver) {
        int x = driver.manage().window().getSize().getHeight();
        int y = driver.manage().window().getSize().getWidth();
        x = x / 2;
        y = y / 2;
        WebElement w = Handle.window(driver);

        Handle.iosDoubleClick(driver, w, x, y);
    }



    /**校验所有按钮的初始值*/
    public static void assertDefaultValue (AppiumDriver<WebElement> driver) {
        /*切换到最顶部*/
        changeTopDefinition(driver);
        /*保证是前置*/

        WebElement f = Find.frontTab(driver);
//        System.out.println(f.getAttribute("value"));
//
        if (!f.getAttribute("value").equals("false")) {
            f.click();
        }

        /*判断Switch的值是不是false*/
        WebElement b = Find.beautSwitch(driver);
//        System.out.println(b.getAttribute("value"));

        if (!b.getAttribute("value").equals("false")) {
            b.click();
        }

    }




    /**操作*/

    /**验证捕捉视频宽度值*/
    public static void assertCaptureWidthValue (AppiumDriver<WebElement> driver, String s) {
        Handle.assertStaticTextValue(Find.captureWidthValue(driver), s);
    }

    /**验证捕捉视频高度值*/
    public static void assertCaptureHeightValue (AppiumDriver<WebElement> driver, String s) {
        Handle.assertStaticTextValue(Find.captureHeightValue(driver), s);
    }

    public static void clickBackTab (AppiumDriver<WebElement> driver) {
        Find.backTab(driver).click();

    }

    public static void clickFrontTab (AppiumDriver<WebElement> driver) {
        Find.frontTab(driver).click();
    }


    public static void clickBeautySwitch (AppiumDriver<WebElement> driver, boolean targetValue) {
        WebElement f = Find.beautSwitch(driver);

        Handle.clickSwitch(f, targetValue);


    }

    public static void clickAddBtn (AppiumDriver<WebElement> driver) {
        /*点击add 按钮*/
//        addBtn(driver).click();
        Handle.click(Find.addBtn(driver));
    }

    /*todo 优化代码*/

    public static void clickCancelBtn (AppiumDriver<WebElement> driver) {
        Handle.click(Find.applyBtn(driver));
    }


    public static void clickApplyBtn (AppiumDriver<WebElement> driver) {
        Handle.click(Find.applyBtn(driver));

        /*界面跳转等待*/
        Handle.controllerSceneSleep();
    }

    private static void clickStartPreviewBtn (AppiumDriver<WebElement> driver) {
        WebElement d = driver.findElement(By.name("StartPreview"));
        d.click();
    }
    private static void clickStartPushBtn (AppiumDriver<WebElement> driver) {
        WebElement d = driver.findElement(By.name("StartPush"));
        d.click();
    }

    private static void clickStopPreviewBtn (AppiumDriver<WebElement> driver) {
        WebElement d = driver.findElement(By.name("StopPreview"));
        d.click();
    }
    private static void clickStopPushBtn (AppiumDriver<WebElement> driver) {
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

    public static String getRtmpUrl() {
        return rtmpUrl;
    }

    public static void setRtmpUrl(String rtmpUrl) {
        MainPage.rtmpUrl = rtmpUrl;
    }



    public static void toSettingsController (AppiumDriver<WebElement> driver) {
        /*
        * 1. 双击跳转
        * */

//        WebElement startPreview = driver.findElement(By.name("StartPreview"));
//        WebElement MuteSpeaker = driver.findElement(By.name("MuteSpeaker"));
//        WebElement StartPush = driver.findElement(By.name("StartPush"));
//        WebElement StartRecord = driver.findElement(By.name("StartRecord"));
//
        WebElement bottomView = Find.otherView(driver);
        /*1 1在左上角，在下面的Other中的任意位置双击都可以*/
        Handle.iosDoubleClick(driver, bottomView, 1, 1);


        Handle.controllerSceneSleep();


    }



    public static void assertFpsTextField (AppiumDriver<WebElement> driver) {
//        WebElement t = driver.findElement(By.xpath("//Application[1]//Window[1]//Other[1]//Other[1]//TextField[1]"));

        WebElement t = Find.fpsTextField(driver);

        Random r = new Random();
        /* 10 ~ 30*/
        int n = r.nextInt(20)+ 10;

        Handle.assertTestFieldSendKeys(t, String.valueOf(n));

    }

    public static void assertGopTextField (AppiumDriver<WebElement> driver) {
        /*List的下标从0开始*/

        WebElement t = Find.gopTextField(driver);

        Random r = new Random();
        int n = r.nextInt(7)+ 1;
//

        Handle.assertTestFieldSendKeys(t, String.valueOf(n));
    }

    public static void assertRateTextField (AppiumDriver<WebElement> driver) {

        WebElement t = Find.rateTextField(driver);

        Random r = new Random();
        int n = r.nextInt(488)+ 512;

        Handle.assertTestFieldSendKeys(t ,String.valueOf(n) + "000");
    }

    public static void assertRtmpTextField (AppiumDriver<WebElement> driver) {

        WebElement t = Find.rtmpTextField(driver);

        Random r = new Random();
        int n = r.nextInt(100)+ 1;

        String rtmpUrlString = rtmpUrl + String.valueOf(n);


        Handle.assertTestFieldSendKeys(t, rtmpUrlString);

        WebElement rtmpLabel = driver.findElement(By.name(rtmpUrlString));
        rtmpLabel.isDisplayed();

    }




    /*切换到最顶部*/
    public static void changeTopDefinition (AppiumDriver<WebElement> driver) {
        MainPage.toSettingsController(driver);
        WebElement pickerWheel = Find.pickerWheel(driver);
        int settingX = pickerWheel.getRect().getWidth() / 2;
        int settingY = pickerWheel.getSize().getHeight() / 2;
//        TouchAction swipe = new TouchAction(driver);


        /*先Tap 再 移动*/
//        swipe.tap(pickerWheel, settingX, settingY);

        int windowY = driver.manage().window().getSize().getHeight();

        Handle.swipe(driver, pickerWheel, settingX, settingY, 0, windowY);
//        swipe.moveTo(pickerWheel, settingX, windowY);
//        swipe.perform();

    }

    /*切换分辨率*/
    public static void changeDefinition (AppiumDriver<WebElement> driver, boolean up) {
        /*
        切换清晰度, 默认480P
        */

        /*先跳转界面*/
        MainPage.toSettingsController(driver);
        WebElement p = Find.pickerWheel(driver);

        /*思路：获取到picker的中心位置，在其Y轴上偏移上下20点，进行Tap*/
        int settingX = p.getRect().getWidth() / 2;
        int settingY = p.getSize().getHeight() / 2;

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
        pickerWheelChangeValue.tap(p, settingX, settingY);
        pickerWheelChangeValue.perform();

        Handle.defaultSleep();
    }

    public static void startPushLoop (AppiumDriver<WebElement> driver, String width, String height) {
        /*点击应用按钮*/
        MainPage.clickApplyBtn(driver);

        /*开始*/

                /*验证正常开始推*/
        MainPage.clickStartPreviewBtn(driver);
//        Handle.sleep(500);
//        driver.findElement(By.name("[Status] PreviewStarted"));
         /*验证正常Push*/
        MainPage.clickStartPushBtn(driver);
//        Handle.sleep(500);
//        driver.findElement(By.name("[Status] PublishStarted"));
        /*播放一秒后再开始验证*/
        Handle.defaultSleep();

        /*验证是否是width和height*/
        toDetailsInfo(driver);
        assertCaptureWidthValue(driver, width);
        assertCaptureHeightValue(driver, height);

        /*关闭详细信息*/
        Handle.defaultSleep();
        toDetailsInfo(driver);

        /*播放10秒*/
        Handle.customSleep(10000);

        /*验证关闭Preview*/
        MainPage.clickStopPreviewBtn(driver);
//        Handle.sleep(500);
//        driver.findElement(By.name("[Status] PreviewStopped"));

        /*验证关闭Push*/

        MainPage.clickStopPushBtn(driver);
//        driver.findElement(By.name("[Status] PublishStopped"));
//        Handle.sleep(500);


        Handle.defaultSleep();





        /*关闭*/
    }



}
