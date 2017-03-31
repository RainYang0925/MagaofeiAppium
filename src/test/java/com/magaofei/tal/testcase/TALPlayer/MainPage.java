package com.magaofei.tal.testcase.TALPlayer;

import com.magaofei.tal.uiautoutils.Handle;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import sun.applet.Main;


import java.net.URL;

/**
 * Created by MAMIAN on 2017/3/31.
 */
public class MainPage {

    // 这里定义为静态方法，否则不能使静态变量
    private static AppiumDriver<WebElement> driver;

    private static String playUrl = "rtmp://live.speiyou.com/live_online/d2";



    @Before
    public void setUp() throws Exception {


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformVersion", "10.2");
        capabilities.setCapability("deviceName", "xuan");
//        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("automationName","XCUITest");
        capabilities.setCapability("bundleId","com.haoweilai.TALPlayer");
        capabilities.setCapability("udid","auto");
//        capabilities.setCapability("noReset", true);
//        capabilities.setCapability("xcodeOrgId","N5G28WF2Y2");
//        capabilities.setCapability("xcodeSigningId","iPhone Developer");



        driver = new IOSDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }


    /*  old Method
    @Test
    public void testUI () {

        /*
        * 1. 点击TALPlayer界面的元素
        * udid : b43c63aac03fb48c3b40fd3cf886ad30bef9f73f iPhone6Plus 1502
        * */

        /*
        * 点击内容：
        * 输入网址，play、Mute、Stop、返回桌面重新调起
        *
        * 


        WebElement urlLabel = driver.findElement(By.className("UIATextField"));
//        WebElement urlLabel = driver.findElement(By.className("XCUIElementTypeTextField"));

        if (!urlLabel.getText().equals(playUrl)) {


            urlLabel.click();
            // 问题 在使用clear之前，必须为官方输入法 ，且需要点击click调出键盘
            urlLabel.clear();
            urlLabel.sendKeys(playUrl);
        }



        Handle.sleep(1000);


        Assert.assertEquals(urlLabel.getText(), playUrl);

        Handle.sleep(10000);


        System.out.print("完毕");

    }

    */

    @Test
    public void testPlayBtn() {
        /*
        * 1. 找到
        * 2. 点击
        *
        * */
        MainPage.assertUrlField();
        MainPage.clickPlayBtn();

    }

    @Test
    public void testStopBtn() {
        MainPage.assertUrlField();
        MainPage.clickPlayBtn();

        Handle.sleep(2000);

        MainPage.clickStopBtn();
    }

    /*先播放，等待，然后静音，再停止，再播放，再静音（此时正常），等待*/
    /*执行完每一步操作后等待两秒*/
    @Test
    public void testMuteBtn() {
        MainPage.assertUrlField();

        MainPage.clickPlayBtn();
        Handle.sleep(2000);

        MainPage.clickMuteBtn();
        Handle.sleep(2000);

        MainPage.clickStopBtn();
        Handle.sleep(2000);

        MainPage.clickPlayBtn();
        Handle.sleep(2000);

        MainPage.clickMuteBtn();
        Handle.sleep(5000);

    }

    @Test
    public void testBackground () {

        for (int i = 0; i < 10; i++) {
            // 返回桌面100秒后重新调起
            driver.runAppInBackground(100);
            System.out.println("第"+i+"次返回桌面测试");
        }

    }

    /*测试点击Play和Stop按钮，循环1000次*/
    @Test
    public void testPlayStopBtnLoop() {
        MainPage.assertUrlField();
        for (int i = 0; i < 1000; i++) {
            MainPage.clickPlayBtn();

            Handle.sleep(3000);
            MainPage.clickStopBtn();

            System.out.println(i+1);
        }

    }


    /*点击Play按钮*/
    public static void clickPlayBtn() {
        WebElement playBtn = driver.findElement(By.name("Play"));
        Handle.click(playBtn);
    }

    /*点击Stop按钮*/
    public static void clickStopBtn() {
        WebElement stopBtn = driver.findElement(By.name("Stop"));
        Handle.click(stopBtn);
    }

    /*点击Mute按钮*/
    public static void clickMuteBtn() {
        WebElement muteBtn = driver.findElement(By.name("Mute"));
        Handle.click(muteBtn);
    }

    public static void assertUrlField () {
        WebElement urlField = driver.findElement(By.className("UIATextField"));
        if (!urlField.getText().equals(playUrl)) {


            urlField.click();
            // 问题 在使用clear之前，必须为官方输入法 ，且需要点击click调出键盘
            urlField.clear();
            urlField.sendKeys(playUrl);
        }

        Handle.sleep(1000);

        Assert.assertEquals(urlField.getText(), playUrl);

//        try {
//            Assert.assertEquals(urlField.getText(), playUrl);
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
    }


}
