package com.magaofei.tal.config;

import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by MAMIAN on 2017/3/27.
 * 初始化参数
 */
public class CapabilitiesSetup {

    /**返回参数*/
    public static DesiredCapabilities iosParameter () {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformVersion", "10.3");
        capabilities.setCapability("deviceName", "MAMIANsiPhone");
//        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("automationName","XCUITest");
        capabilities.setCapability("bundleId","com.haoweilai.TALPublisher");
        capabilities.setCapability("udid","b43c63aac03fb48c3b40fd3cf886ad30bef9f73f");
        // b43c63aac03fb48c3b40fd3cf886ad30bef9f73f   mengdeiPhone
        // 4fde6542011bd1a001a41edac73f0e492af603b4

        capabilities.setCapability("wdaLocalPort", "8002");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("xcodeOrgId","N5G28WF2Y2");
        capabilities.setCapability("xcodeSigningId","iPhone Developer");
        // 从文件读取
        return capabilities;
    }

    private String deviceName;
    private String app;
    private String udid;


    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getUdid() {
        return udid;
    }

    public void setUdid(String udid) {
        this.udid = udid;
    }
}
