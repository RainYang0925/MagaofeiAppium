package com.magaofei.tal.page.talplayer;

import com.magaofei.tal.common.Handle;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by MAMIAN on 2017/4/5.
 */
public class MainPage {

    /*点击Play按钮*/
    public static void clickPlayBtn(AppiumDriver<MobileElement> driver) {
        Find.playBtn(driver).click();
//        Handle.click(playBtn);
        Handle.customSleep(3000);
    }

    /*点击Stop按钮*/
    public static void clickStopBtn(AppiumDriver<MobileElement> driver) {
        Find.stopBtn(driver).click();
//        Handle.click(stopBtn);
        Handle.customSleep(3000);
    }

    /*点击Mute按钮*/
    public static void clickMuteBtn(AppiumDriver<MobileElement> driver) {
        Find.muteBtn(driver);
//        WebElement muteBtn = driver.findElement(By.name("Mute"));
//        Handle.click(muteBtn);
        Handle.customSleep(3000);
    }

    public static void assertUrlField(AppiumDriver<MobileElement> driver, String playUrl) {
        WebElement urlField = driver.findElement(By.className("UIATextField"));
        if (!urlField.getText().equals(playUrl)) {


            urlField.click();
            // 问题 在使用clear之前，必须为官方输入法 ，且需要点击click调出键盘
            urlField.clear();
            urlField.sendKeys(playUrl);
            Handle.defaultSleep();
        }


        Assert.assertEquals(urlField.getText(), playUrl);
        Handle.customSleep(2000);

//        try {
//            Assert.assertEquals(urlField.getText(), playUrl);
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
    }
}
