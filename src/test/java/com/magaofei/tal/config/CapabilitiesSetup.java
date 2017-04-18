package com.magaofei.tal.config;

import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by MAMIAN on 2017/3/27.
 * 初始化参数
 */
public class CapabilitiesSetup {

    /*config文件的目录*/
    public static String configClassPath = "src/test/java/com/magaofei/tal/config.properties";

    /** iOS */
    private static String deviceName;
    private static String app;
    private static String udid;
    private static String wdaLocalPort;
    private static String xcodeOrgId;
    private static String xcodeSigningId;
    private static String automationName;
    private static String bundleId;
    private static String platformVersion;
    private static String clearSystemFiles;

    /**直接代码书写返回参数*/
    public static DesiredCapabilities parameter () {
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




    public static String getWdaLocalPort() {
        return wdaLocalPort;
    }

    public static void setWdaLocalPort(String wdaLocalPort) {
        CapabilitiesSetup.wdaLocalPort = wdaLocalPort;
    }

    public static void setUdid(String udid) {
        CapabilitiesSetup.udid = udid;
    }

    public static String getUdid() {
        return udid;
    }

    public static void setApp(String app) {
        CapabilitiesSetup.app = app;
    }

    public static String getApp() {
        return app;
    }

    public static String getAutomationName() {
        return automationName;
    }

    public static String getBundleId() {
        return bundleId;
    }

    public static String getDeviceName() {
        return deviceName;
    }

    public static String getXcodeOrgId() {
        return xcodeOrgId;
    }

    public static String getPlatformVersion() {
        return platformVersion;
    }

    public static String getXcodeSigningId() {
        return xcodeSigningId;
    }

    public static void setAutomationName(String automationName) {
        CapabilitiesSetup.automationName = automationName;
    }

    public static void setBundleId(String bundleId) {
        CapabilitiesSetup.bundleId = bundleId;
    }

    public static void setDeviceName(String deviceName) {
        CapabilitiesSetup.deviceName = deviceName;
    }

    public static void setPlatformVersion(String platformVersion) {
        CapabilitiesSetup.platformVersion = platformVersion;
    }

    public static void setXcodeOrgId(String xcodeOrgId) {
        CapabilitiesSetup.xcodeOrgId = xcodeOrgId;
    }

    public static void setXcodeSigningId(String xcodeSigningId) {
        CapabilitiesSetup.xcodeSigningId = xcodeSigningId;
    }


    /**
     * 使用文件读写返回参数
     *
     *
     * */
    public static DesiredCapabilities readFile () {
        Properties prop = new Properties();
//        File classpathRoot = new File(System.getProperty("user.dir"));
        DesiredCapabilities capabilities = new DesiredCapabilities();

        try {
            prop.load(new FileInputStream("src/test/java/com/magaofei/tal/config.properties"));


            // 1. 取数据
            setDeviceName(prop.getProperty("deviceName"));
            setBundleId(prop.getProperty("bundleId"));
            setAutomationName(prop.getProperty("automationName"));
            setWdaLocalPort(prop.getProperty("xcodeOrgId"));
            setWdaLocalPort(prop.getProperty("xcodeSigningId"));
            setWdaLocalPort(prop.getProperty("wdaLocalPort"));
            setUdid(prop.getProperty("udid"));
            setPlatformVersion(prop.getProperty("platformVersion"));






            // 2.做数据容错处理


            // 这里不能写作String.ValueOf
            if (automationName != null && !automationName.equals("")) {
                capabilities.setCapability("automationName", automationName);
            }

            if (bundleId != null && !bundleId.equals("")) {
                capabilities.setCapability("bundleId", bundleId);
            }

            if (udid!= null && !udid.equals("")) {
                capabilities.setCapability("udid", udid);
            }

            if (deviceName!= null && !deviceName.equals("")) {
                capabilities.setCapability("deviceName", deviceName);
            }

            if (xcodeOrgId != null && !xcodeOrgId.equals("")) {
                capabilities.setCapability("xcodeOrgId", xcodeOrgId);
            }

            if (xcodeSigningId != null && !xcodeSigningId.equals("")) {
                capabilities.setCapability("xcodeSigningId", xcodeSigningId);
            }

            if (platformVersion != null && !platformVersion.equals("")) {
                capabilities.setCapability("platformVersion", platformVersion);
            }



//            capabilities.setCapability("xcodeSigningId", prop.getProperty("xcodeSigningId"));


            // Android
//            capabilities.setCapability("appActivity", prop.getProperty("appActivity"));
//            capabilities.setCapability("appPackage", prop.getProperty("appPackage"));
//            capabilities.setCapability("appWaitActivity", prop.getProperty("appWaitActivity"));
//            capabilities.setCapability("appWaitPackage", prop.getProperty("appWaitPackage"));
//            capabilities.setCapability("appWaitDuration", prop.getProperty("appWaitDuration"));
//            capabilities.setCapability("deviceReadyTimeout", prop.getProperty("deviceReadyTimeout"));
//            capabilities.setCapability("adbPort", prop.getProperty("adbPort"));



//            return capabilities;

        } catch(Exception e) {
            e.printStackTrace();

        }


        return capabilities;



    }


    @Test
    public void test () {
        System.out.println(String.valueOf(xcodeOrgId));
    }


}
