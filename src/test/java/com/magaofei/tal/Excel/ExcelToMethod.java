package com.magaofei.tal.Excel;

import com.magaofei.tal.common.Handle;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * Created by MAMIAN on 2017/4/14.
 */
public class ExcelToMethod {

    public static void findElementFromExcel (String[] cellList, int index, AppiumDriver<MobileElement> driver) {
        String methodName = cellList[index];
        String positingMode = cellList[index+1];
        String element = cellList[index+2];
        String keys = cellList[index+3];

        if (methodName.equals("click")) {
            if (positingMode.equals("ByAccessibilityId")) {

                driver.findElementByAccessibilityId(element).click();
            } else if (positingMode.equals("ByClassName")) {

                driver.findElementByClassName(element).click();
            }
        } else if (methodName.equals("sendKeys")) {
            if (positingMode.equals("ByAccessibilityId")) {

                driver.findElementByAccessibilityId(element).sendKeys(keys);
            } else if (positingMode.equals("ByClassName")) {

                driver.findElementByClassName(element).sendKeys(keys);
            }
            /*自定义等待时间*/
        } else if (methodName.equals("customSleep")) {
            long l = Long.valueOf(keys);

            Handle.customSleep(l);
        }


    }
}
