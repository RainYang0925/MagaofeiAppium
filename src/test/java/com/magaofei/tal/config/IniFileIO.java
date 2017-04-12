package com.magaofei.tal.config;

import io.appium.java_client.AppiumDriver;
import org.ini4j.Wini;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * Created by MAMIAN on 2017/4/11.
 */

public class IniFileIO {


    public void sample01(String filename) throws IOException {
        Wini ini = new Wini(new File(filename));
//        int age = ini.get("demo", "age", int.class);
//        double height = ini.get("demo", "height", double.class);
//        String dir = ini.get("demo", "homeDir");

//        System.out.println(age);
//        System.out.println(height);
//        System.out.println(dir);

        Map<String, String> appiumIni = ini.get("appium");

        String platformVersion = appiumIni.get("platformVersion");
        String weight = appiumIni.get("weight");
        String homeDir = appiumIni.get("homeDir");

        // get all section names
        Set<String> sectionNames = ini.keySet();
    }

    @Test
    public void testMain () {
        try {
            sample01("/Users/MAMIAN/Desktop/demo.ini");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readProperties () {


    }

    @Test
    public void testProperties () {
        Properties prop = new Properties();
//        File classpathRoot = new File(System.getProperty("user.dir"));
        try {
            prop.load(new FileInputStream("src/test/java/com/magaofei/tal/config.properties"));

//            System.out.println(classpathRoot);
            System.out.println(prop.getProperty("udid"));
            System.out.println(prop.getProperty("platformVersion"));
            System.out.println(prop.getProperty("deviceName"));
            System.out.println(prop.getProperty("bundleId"));
            System.out.println(prop.getProperty("automationName"));


        } catch(Exception e) {
            e.printStackTrace();
        }


    }



}
