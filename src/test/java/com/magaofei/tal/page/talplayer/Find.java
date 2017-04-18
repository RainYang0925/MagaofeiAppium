package com.magaofei.tal.page.talplayer;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * Created by MAMIAN on 2017/4/13.
 */
public class Find {

    public static MobileElement playBtn (AppiumDriver<MobileElement> driver) {
        return driver.findElementByAccessibilityId("Play");
    }

    public static MobileElement stopBtn (AppiumDriver<MobileElement> driver) {
        return driver.findElementByAccessibilityId("Stop");
    }

    public static MobileElement muteBtn (AppiumDriver<MobileElement> driver) {
        return driver.findElementByAccessibilityId("Mute");
    }

    public static MobileElement urlTextField (AppiumDriver<MobileElement> driver) {
//        return driver.findElement(By.className("TextField"));
        return driver.findElementByClassName("TextField");
    }

}
