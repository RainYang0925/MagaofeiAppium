package com.magaofei.tal.page.talpublish;



import com.magaofei.tal.common.Handle;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.Random;

/**
 * Created by MAMIAN on 2017/4/5.
 * 存储页面上的所有可点击元素的操作
 */
public class MainPage {



    private static String rtmpUrl = "rtmp://10.2.250.92/live_haibian/";

    /**校验设置推流的值是否正确*/
    public static void assertCaptureValue (AppiumDriver<MobileElement> driver) {
        /*思路
        * 1. 点击屏幕中心跳转
        * 2. 找到CaptureWidth 和 CaptureHeight
        * 3. 校验值
        *
        *
        * */




    }

    /**跳转到当前推流的详细信息*/
    private static void toDetailsInfo (AppiumDriver<MobileElement> driver) {
        int x = driver.manage().window().getSize().getHeight();
        int y = driver.manage().window().getSize().getWidth();
        x = x / 2;
        y = y / 2;
        MobileElement w = Handle.window(driver);

        Handle.iosDoubleClick(driver, w, x, y);

    }



    /**校验所有按钮的初始值*/
    public static void assertDefaultValue (AppiumDriver<MobileElement> driver) {
        /*切换到最顶部*/
        changeTopDefinition(driver);
        /*保证是前置*/

        MobileElement f = Find.frontTab(driver);
//        System.out.println(f.getAttribute("value"));
//
        if (!f.getAttribute("value").equals("false")) {
            f.click();
        }


        /*判断Switch的值是不是false*/
        MobileElement b = Find.beautSwitch(driver);
//        System.out.println(b.getAttribute("value"));

        if (!b.getAttribute("value").equals("false")) {
            b.click();
        }

    }




    /**操作*/

    /**验证捕捉视频宽度值*/
    public static void assertCaptureWidthValue (AppiumDriver<MobileElement> driver, String s) {
        Handle.assertStaticTextValue(Find.captureWidthValue(driver), s);
    }

    /**验证捕捉视频高度值*/
    public static void assertCaptureHeightValue (AppiumDriver<MobileElement> driver, String s) {
        Handle.assertStaticTextValue(Find.captureHeightValue(driver), s);
    }

    public static void clickBackTab (AppiumDriver<MobileElement> driver) {
        Find.backTab(driver).click();

    }

    public static void clickFrontTab (AppiumDriver<MobileElement> driver) {
        Find.frontTab(driver).click();
    }


    public static void clickBeautySwitch (AppiumDriver<MobileElement> driver, boolean targetValue) {
        MobileElement f = Find.beautSwitch(driver);

        Handle.clickSwitch(f, targetValue);


    }

    public static void clickAddBtn (AppiumDriver<MobileElement> driver) {
        /*点击add 按钮*/
//        addBtn(driver).click();
        Handle.click(Find.addBtn(driver));
    }

    /*todo 优化代码*/

    public static void clickCancelBtn (AppiumDriver<MobileElement> driver) {
        Handle.click(Find.applyBtn(driver));
    }


    public static void clickApplyBtn (AppiumDriver<MobileElement> driver) {
        Handle.click(Find.applyBtn(driver));

        /*界面跳转等待*/
        Handle.controllerSceneSleep();
    }

    private static void clickStartPreviewBtn (AppiumDriver<MobileElement> driver) {
        MobileElement d = driver.findElement(By.name("StartPreview"));
        d.click();
    }
    private static void clickStartPushBtn (AppiumDriver<MobileElement> driver) {
        MobileElement d = driver.findElement(By.name("StartPush"));
        d.click();
    }

    private static void clickStopPreviewBtn (AppiumDriver<MobileElement> driver) {
        MobileElement d = driver.findElement(By.name("StopPreview"));
        d.click();
    }
    private static void clickStopPushBtn (AppiumDriver<MobileElement> driver) {
        MobileElement d = driver.findElement(By.name("StopPush"));
        d.click();
    }

    public static void clickMuteSpeakerBtn (AppiumDriver<MobileElement> driver) {
        MobileElement d = driver.findElement(By.name("MuteSpeaker"));
        d.click();
    }
    public static void clickStartRecordBtn (AppiumDriver<MobileElement> driver) {
        MobileElement d = driver.findElement(By.name("StartRecord"));
        d.click();
    }

    public static String getRtmpUrl() {
        return rtmpUrl;
    }

    public static void setRtmpUrl(String rtmpUrl) {
        MainPage.rtmpUrl = rtmpUrl;
    }



    public static void toSettingsController (AppiumDriver<MobileElement> driver) {
        /*
        * 1. 双击跳转
        * */

//        MobileElement startPreview = driver.findElement(By.name("StartPreview"));
//        MobileElement MuteSpeaker = driver.findElement(By.name("MuteSpeaker"));
//        MobileElement StartPush = driver.findElement(By.name("StartPush"));
//        MobileElement StartRecord = driver.findElement(By.name("StartRecord"));
//      MobileElement o = driver.findElementByClassName("Other");
        MobileElement bottomView = Find.otherView(driver);
        /*1 1在左上角，在下面的Other中的任意位置双击都可以*/
        Handle.iosDoubleClick(driver, bottomView, 1, 1);


        Handle.controllerSceneSleep();


    }



    public static void assertFpsTextField (AppiumDriver<MobileElement> driver) {
//        MobileElement t = driver.findElement(By.xpath("//Application[1]//Window[1]//Other[1]//Other[1]//TextField[1]"));

        MobileElement t = Find.fpsTextField(driver);

        Random r = new Random();
        /* 10 ~ 30*/
        int n = r.nextInt(20)+ 10;

        Handle.assertTestFieldSendKeys(t, String.valueOf(n));

    }

    public static void assertGopTextField (AppiumDriver<MobileElement> driver) {
        /*List的下标从0开始*/

        MobileElement t = Find.gopTextField(driver);

        Random r = new Random();
        int n = r.nextInt(7)+ 1;
//

        Handle.assertTestFieldSendKeys(t, String.valueOf(n));
    }

    public static void assertRateTextField (AppiumDriver<MobileElement> driver) {

        MobileElement t = Find.rateTextField(driver);

        Random r = new Random();
        int n = r.nextInt(488)+ 512;

        Handle.assertTestFieldSendKeys(t ,String.valueOf(n) + "000");
    }

    public static void assertRtmpTextField (AppiumDriver<MobileElement> driver) {

        MobileElement t = Find.rtmpTextField(driver);

        Random r = new Random();
        int n = r.nextInt(100)+ 1;

        String rtmpUrlString = rtmpUrl + String.valueOf(n);


        Handle.assertTestFieldSendKeys(t, rtmpUrlString);

        MobileElement rtmpLabel = driver.findElement(By.name(rtmpUrlString));
        rtmpLabel.isDisplayed();

    }




    /*切换到最顶部*/
    public static void changeTopDefinition (AppiumDriver<MobileElement> driver) {
        MainPage.toSettingsController(driver);


        MobileElement pickerWheel = Find.pickerWheel(driver);

        Handle.pickerWheelChangeTopDefinition(driver, pickerWheel);


    }

    /*切换分辨率*/
    public static void changeDefinition (AppiumDriver<MobileElement> driver, boolean up) {
        /*
        切换清晰度, 默认480P
        */

        /*先跳转界面*/
        MainPage.toSettingsController(driver);
        MobileElement p =  Find.pickerWheel(driver);
        Handle.pickerWheelchangeDefinition(driver, p, false);
    }

    public static void startPushLoop (AppiumDriver<MobileElement> driver, String width, String height) {
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
