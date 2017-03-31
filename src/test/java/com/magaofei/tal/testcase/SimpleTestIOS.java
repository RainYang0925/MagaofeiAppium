package com.magaofei.tal.testcase;

import io.appium.java_client.ios.IOSDriver;
import org.hamcrest.core.IsEqual;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.FindsByClassName;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;

//import java.lang.Thread;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import static org.junit.Assert.*;

import com.magaofei.tal.common.TestUtil;
import com.magaofei.tal.common.CapabilitiesSetup;


/**
 * Created by MAMIAN on 2017/3/26.
 */
public class SimpleTestIOS {
    private WebDriver driver;
//    private TestAppScreenSimple uiTestApp;


    @Before
    public void setUp() throws Exception {
        // set up appium
        File appDir = new File(System.getProperty("user.dir"), "../../../apps/TestApp/build/release-iphonesimulator");
        File app = new File(appDir, "TestApp.app");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformVersion", "10.2");
        capabilities.setCapability("deviceName", "MAMIANsiPhone6s");
//        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("automationName","XCUITest");
        capabilities.setCapability("bundleId","io.appium.TestApp");
        capabilities.setCapability("udid","auto");
        CapabilitiesSetup s = new CapabilitiesSetup();
        s.setDeviceName("MAMIANsiPhone6s");

        driver = new IOSDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }


    @Test
    public void testInput() {
        WebElement d = driver.findElement(By.id(""));
        d.clear();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        d.sendKeys("123");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals(d, "123");



    }





    public WebElement ch;







}
