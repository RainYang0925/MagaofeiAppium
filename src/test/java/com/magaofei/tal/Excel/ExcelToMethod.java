package com.magaofei.tal.Excel;

import com.magaofei.tal.common.Handle;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by MAMIAN on 2017/4/14.
 */
public class ExcelToMethod {

    private AppiumDriver driver;

    public static void findElementFromExcel (String[] cellList, int index, AppiumDriver<MobileElement> driver) throws Exception {
        String methodName = cellList[index];
        String positingMode = cellList[index+1];
        String element = cellList[index+2];
        String key = cellList[index+3];

        // 当有多个参数时
        String[] keys = null;
        if (key.contains(",")) {
             keys = key.split(",");
        }






        /*先找到控件元素*/
        MobileElement e = null;
        if (positingMode.equals("findElementByAccessibilityId")) {
            e = driver.findElementByAccessibilityId(element);
        } else if (positingMode.equals("findElementByClassName")) {
            e = driver.findElementByClassName(element);
        } else if (positingMode.contains("findElementsByClassName-")) {
            // 分割字符串, 找到-后面的数字, 并取其下标
            String[] p = positingMode.split("-");
            int i = Integer.parseInt(p[1]);
            List<MobileElement> l = driver.findElementsByClassName(element);
            e = l.get(i);
        } else {

        }


        /*再对其进行操作*/
        if (methodName.equals("click")) {
            e.click();
        } else if (methodName.equals("sendKeys")) {
            e.sendKeys(key);
            /*自定义等待时间*/
        } else if (methodName.equals("defaultSleep")) {
            Handle.defaultSleep();
        } else if (methodName.equals("customSleep")) {
            long l = Long.valueOf(key);

            Handle.customSleep(l);
        } else if (methodName.equals("clear")) {
            e.clear();

        } else if (methodName.equals("assertEquals")) {

            Assert.assertEquals(e.getText(), key);


        } else if (methodName.equals("iosDoubleClick")) {

            int x = Integer.parseInt(keys[0]);
            int y = Integer.parseInt(keys[1]);
            Handle.iosDoubleClick(driver, e, x, y);
        } else if (methodName.equals("pickerWheelChangeTopDefinition")) {
            Handle.pickerWheelChangeTopDefinition(driver, e);
        } else if (methodName.equals("pickerWheechangeDefinition")) {
            Handle.pickerWheechangeDefinition(driver, e, Boolean.getBoolean(key));
        }


    }

    @Test

    public void testStringInvokeMethod () {
        try {
            stringInvokeMethod("findElementByAccessibilityId", 1, "StartPreview");
//            stringInvokeMethod("customSleep", 1, 5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*todo 根据str动态调用Method, 但是实践起来不理想*/
    public void stringInvokeMethod(String str, int i, String k) throws Exception {

//        Handle.class.getMethod(str, new Class[] { long.class }).invoke(Handle.class, new Object[] { k });
        AppiumDriver.class.getMethod(str, new Class[] {String.class } ).invoke(AppiumDriver.class, new Object[] { k });

    }
}
