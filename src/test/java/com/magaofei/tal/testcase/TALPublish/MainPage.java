package com.magaofei.tal.testcase.TALPublish;

import com.magaofei.tal.uiautoutils.Handle;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.HashMap;

/**
 * Created by MAMIAN on 2017/3/31.
 */
public class MainPage {

    private AppiumDriver<WebElement> driver;

    @Before
    public void setUp() throws Exception {


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformVersion", "10.2");
        capabilities.setCapability("deviceName", "MAMIANsiPhone");
//        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("automationName","XCUITest");
        capabilities.setCapability("bundleId","com.haoweilai.TALPublisher");
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

    @Test
    public void testUI () {

        WebElement startPreview = driver.findElement(By.name("StartPreview"));
        Rectangle startPreviewRect = startPreview.getRect();
        System.out.println("X=" + startPreviewRect.getX());
        System.out.println("Y=" + startPreviewRect.getY());

        // 获取StartPreview的位置 + 宽度，往右偏移20px
        int settingX = startPreviewRect.getX() + startPreviewRect.getWidth() + 20;
        int settingY = startPreviewRect.getY() + 20;

        // 实现双击功能

        System.out.println(settingX);
        // 双击
        Handle.sleep(5000);

        TouchAction doubleClick = new TouchAction(driver);


        driver.tap(1, settingX, settingY, 5);
        Handle.sleep(50);
        driver.tap(1, settingX, settingY, 5);
        Handle.sleep(100);
        doubleClick.tap(settingX, settingY).release();
        doubleClick.tap(settingX, settingY);
//        driver.tap(1, settingX, settingY, 1);
//
//
//        WebElement window = driver.findElement(By.xpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]"));
//        driver.tap(2, window, 1);

        // 未实现
//        driver.performTouchAction(doubleClick);

        try {
            doubleClick(driver, settingX, settingY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("点击完毕");
        Handle.sleep(5000);

        System.out.println("完毕");




    }


    public static void doubleClick(WebDriver driver, double x, double y) throws InterruptedException {

        HashMap<String, Double> tapObject = new HashMap<String, Double>();

        tapObject.put("x", x); // in pixels from left

        tapObject.put("y", y); // in pixels from top

        tapObject.put("tapCount", 2.0);  // double tap

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("mobile: tap", tapObject);
    }

}
