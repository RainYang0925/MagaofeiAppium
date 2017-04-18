package com.magaofei.tal.testcase.talpublish;

import com.magaofei.tal.Excel.ExcelUtil;
import com.magaofei.tal.config.CapabilitiesSetup;
import com.magaofei.tal.page.talpublish.MainPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.net.URL;

/*双击*/

/**
 * Created by MAMIAN on 2017/3/31.
 */
/*测试顺序按照方法名排序*/
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MainCase {

    private AppiumDriver<MobileElement> driver;

    @Before
    public void setUp() throws Exception {


//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("platformVersion", "10.3");
//        capabilities.setCapability("deviceName", "MAMIANsiPhone");
////        capabilities.setCapability("app", app.getAbsolutePath());
//        capabilities.setCapability("automationName","XCUITest");
//        capabilities.setCapability("bundleId","com.haoweilai.TALPublisher");
//        capabilities.setCapability("udid","b43c63aac03fb48c3b40fd3cf886ad30bef9f73f");
//        // b43c63aac03fb48c3b40fd3cf886ad30bef9f73f   mengdeiPhone
//        // 4fde6542011bd1a001a41edac73f0e492af603b4
//
//        capabilities.setCapability("wdaLocalPort", "8002");
//        capabilities.setCapability("noReset", true);
//        capabilities.setCapability("xcodeOrgId","N5G28WF2Y2");
//        capabilities.setCapability("xcodeSigningId","iPhone Developer");



        driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), CapabilitiesSetup.readFile());
        
//        MainPage.toSettingsController(driver);

    }

    @After
    public void tearDown() throws Exception {
        /*即使退出也会保存*/
        driver.quit();
    }

//    @Test
    public void testReadExcel () {
        ExcelUtil.testReadExcel(driver);
    }



    @Test
    public void test001Default () {

        /*校验初始值*/
        MainPage.assertDefaultValue(driver);

        /*切换到指定目标的分辨率*/
//        MainPage.changeTopDefinition(driver);

        /*校验输入*/
        MainPage.assertFpsTextField(driver);
        MainPage.assertGopTextField(driver);
        MainPage.assertRateTextField(driver);
        MainPage.assertRtmpTextField(driver);
        MainPage.clickAddBtn(driver);

        MainPage.startPushLoop(driver, "72", "1280");

//        /*点击应用按钮*/
//        MainPage.clickApplyBtn(driver);
//
//        /*开始*/
//        MainPage.clickStartPreviewBtn(driver);
//        MainPage.clickStartPushBtn(driver);
//
//        Handle.sleep(10000);
//        /*关闭*/
//        MainPage.clickStopPreviewBtn(driver);
//        MainPage.clickStopPushBtn(driver);


    }

    @Test
    public void test002480P () {
        MainPage.changeDefinition(driver, false);
        MainPage.startPushLoop(driver, "480", "640");
    }

    @Test
    public void test003Wide360P () {
        MainPage.changeDefinition(driver, false);
        MainPage.startPushLoop(driver, "360", "640");
    }

    @Test
    public void test004360P () {
        MainPage.changeDefinition(driver, false);
        MainPage.startPushLoop(driver, "360", "480");
    }

    @Test
    public void test005288P () {
        MainPage.changeDefinition(driver, false);
        MainPage.startPushLoop(driver, "288", "352");
    }

    @Test
    public void test006180P () {
        MainPage.changeDefinition(driver, false);
        MainPage.startPushLoop(driver, "180", "320");
    }

    @Test
    public void test007720x720 () {
        MainPage.changeDefinition(driver, false);
        MainPage.startPushLoop(driver, "720", "720");
    }

    @Test
    public void test008480x480 () {
        MainPage.changeDefinition(driver, false);
        MainPage.startPushLoop(driver, "480", "480");
    }

    @Test
    public void test009360x360 () {
        MainPage.changeDefinition(driver, false);
        MainPage.startPushLoop(driver, "360", "360");
    }

    @Test
    public void test010288x288 () {
        MainPage.changeDefinition(driver, false);
        MainPage.startPushLoop(driver, "288", "288");
    }

    @Test
    public void test011180x180 () {
        MainPage.changeDefinition(driver, false);
        MainPage.startPushLoop(driver, "180", "180");
    }

    /*测试美颜*/
    public  @Test void test012BeautSwitch720P () {

        /*720P*/
        MainPage.changeTopDefinition(driver);
        /*打开*/
        MainPage.clickBeautySwitch(driver, true);


        MainPage.startPushLoop(driver, "720", "1280");

        MainPage.toSettingsController(driver);

        /*有开始就要有关闭*/
        MainPage.clickBeautySwitch(driver, false);
        MainPage.clickApplyBtn(driver);
        // 要Apply
    }

    /*测试后置摄像头720P*/
    public  @Test void test013Back720P () {
        /*720P*/
        MainPage.changeTopDefinition(driver);


        MainPage.clickBackTab(driver);

        MainPage.startPushLoop(driver, "720", "1280");


    }




    /*
    * 10~20
    * 1~5
    *
    *
    * */




}
