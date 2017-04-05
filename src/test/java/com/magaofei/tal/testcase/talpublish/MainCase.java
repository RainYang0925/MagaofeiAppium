package com.magaofei.tal.testcase.talpublish;

import com.magaofei.tal.page.talpublish.MainPage;
import com.magaofei.tal.common.Handle;
/*双击*/

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import sun.applet.Main;

import java.net.URL;

/**
 * Created by MAMIAN on 2017/3/31.
 */
public class MainCase {

    private AppiumDriver<WebElement> driver;

    @Before
    public void setUp() throws Exception {


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformVersion", "10.3");
        capabilities.setCapability("deviceName", "MAMIANsiPhone");
//        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("automationName","XCUITest");
        capabilities.setCapability("bundleId","com.haoweilai.TALPublisher");
        capabilities.setCapability("udid","auto");

//        capabilities.setCapability("noReset", true);
        capabilities.setCapability("xcodeOrgId","N5G28WF2Y2");
        capabilities.setCapability("xcodeSigningId","iPhone Developer");



        driver = new IOSDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        MainPage.toSettingsController(driver);
    }

    @After
    public void tearDown() throws Exception {
        /*测试完毕之后，不退出应用，但需要重新调起WebDriverAgent*/
//        driver.quit();
    }

    @Test
    public void testDefault () {

        MainPage.changeDefinition(driver, true);

        MainPage.assertFpsTextField(driver);
        MainPage.assertGopTextField(driver);
        MainPage.assertRateTextField(driver);
        MainPage.assertRtmpTextField(driver);
        MainPage.clickAddBtn(driver);

        MainPage.clickApplyBtn(driver);

        MainPage.clickStartPreviewBtn(driver);
        MainPage.clickStartPushBtn(driver);

        MainPage.clickStopPreviewBtn(driver);
        MainPage.clickStopPushBtn(driver);


    }

    @Test
    public void testUIWide360P () {
        MainPage.changeDefinition(driver, false);
        MainPage.changeDefinition(driver, false);
    }

    /*
    * 10~20
    * 1~5
    *
    *
    * */




}
