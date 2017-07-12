package com.magaofei.tal.testcase.IPS;

import com.magaofei.tal.common.Handle;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.List;

/**
 * Created by MAMIAN on 2017/7/6.
 */
public class SimpleTestIPS {

    // 这里定义为静态方法，否则不能使静态变量
    private static AppiumDriver<MobileElement> driver;

    private static String playUrl = "rtmp://live.speiyou.com/live_online/d2";


    @Before
    public void setUp() throws Exception {


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformVersion", "10.3");
        capabilities.setCapability("deviceName", "MAMIANsiPhone");
//        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("automationName","XCUITest");
        capabilities.setCapability("bundleId","com.xes.ips");
        capabilities.setCapability("udid","auto");
//        capabilities.setCapability("noReset", true);
        capabilities.setCapability("xcodeOrgId","N5G28WF2Y2");
        capabilities.setCapability("xcodeSigningId","iPhone Developer");



        driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//        TestSuite suite = new TestSuite();


//        suite.addTest(new MainPage("testPlayBtn"));
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void testLogin() {

        // 帐号输入
        List<MobileElement> textField = driver.findElements(By.className("TextField"));
        MobileElement account = textField.get(0);
//        account.clear();
//        account.sendKeys("15015010198324");
        Handle.assertTestFieldSendKeys(account, "15015010198324");

        // 密码输入
        MobileElement secureTextField = driver.findElement(By.className("SecureTextField"));
        secureTextField.clear();
        secureTextField.sendKeys("11111111");
        Assert.assertEquals(secureTextField.getText(), "••••••••");


//        MobileElement l = driver.findElementByName("登录");
        List<MobileElement> l = driver.findElements(By.className("Button"));
        l.get(2).click();

        Handle.customSleep(10000);

    }



}


