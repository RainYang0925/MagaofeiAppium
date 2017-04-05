package com.magaofei.tal.page.talplayer;

import com.magaofei.tal.common.Handle;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by MAMIAN on 2017/4/5.
 */
public class MainPage {

    /*点击Play按钮*/
    public static void clickPlayBtn(AppiumDriver<WebElement> driver) {
        WebElement playBtn = driver.findElement(By.name("Play"));
        Handle.click(playBtn);
        Handle.sleep(3000);
    }

    /*点击Stop按钮*/
    public static void clickStopBtn(AppiumDriver<WebElement> driver) {
        WebElement stopBtn = driver.findElement(By.name("Stop"));
        Handle.click(stopBtn);
        Handle.sleep(3000);
    }

    /*点击Mute按钮*/
    public static void clickMuteBtn(AppiumDriver<WebElement> driver) {
        WebElement muteBtn = driver.findElement(By.name("Mute"));
        Handle.click(muteBtn);
        Handle.sleep(3000);
    }

    public static void assertUrlField(AppiumDriver<WebElement> driver, String playUrl) {
        WebElement urlField = driver.findElement(By.className("UIATextField"));
        if (!urlField.getText().equals(playUrl)) {


            urlField.click();
            // 问题 在使用clear之前，必须为官方输入法 ，且需要点击click调出键盘
            urlField.clear();
            urlField.sendKeys(playUrl);
            Handle.sleep(1000);
        }


        Assert.assertEquals(urlField.getText(), playUrl);
        Handle.sleep(2000);

//        try {
//            Assert.assertEquals(urlField.getText(), playUrl);
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
    }
}
