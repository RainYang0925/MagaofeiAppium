package com.magaofei.tal.TALPlayer;

import com.gargoylesoftware.htmlunit.javascript.host.Touch;
import com.magaofei.tal.common.CapabilitiesSetup;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


import io.appium.java_client.AppiumDriver.*;
import io.appium.java_client.AppiumDriver;

import java.io.File;
import java.net.URL;

/**
 * Created by MAMIAN on 2017/3/29.
 */
public class TALPlayer_iOS {

    private AppiumDriver<WebElement> driver;




    @Before
    public void setUp() throws Exception {


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformVersion", "10.2");
        capabilities.setCapability("deviceName", "xuan");
//        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("automationName","XCUITest");
        capabilities.setCapability("bundleId","com.haoweilai.TALPlayer");
        capabilities.setCapability("udid","auto");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("xcodeOrgId","N5G28WF2Y2");
        capabilities.setCapability("xcodeSigningId","iPhone Developer");

        CapabilitiesSetup s = new CapabilitiesSetup();


        driver = new IOSDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

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
        * */
        String playUrl = "rtmp://live.speiyou.com/live_online/d2";

//        WebElement urlLabel = driver.findElement(By.className("UIATextField"));
        WebElement urlLabel = driver.findElement(By.className("TextField"));


        urlLabel.clear();
        urlLabel.sendKeys(playUrl);

        TALPlayer_iOS.tal_sleep(1000);

        Assert.assertEquals(urlLabel.getText(), playUrl);


        WebElement playBtn = driver.findElement(By.name("Play"));
        playBtn.click();

        TALPlayer_iOS.tal_sleep(5000);


        TALPlayer_iOS.tal_sleep(5000);
        WebElement muteBtn = driver.findElement(By.name("Mute"));
        muteBtn.click();

        TALPlayer_iOS.tal_sleep(5000);
        WebElement stopBtn = driver.findElement(By.name("Stop"));
        stopBtn.click();


        TALPlayer_iOS.tal_sleep(5000);
        playBtn.click();


        // 返回桌面100秒后重新调起
        driver.runAppInBackground(100);




        

        System.out.print("完毕");









    }

    public static void tal_sleep(long timeOut) {
        try {

            Thread.sleep(timeOut);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
