package com.magaofei.tal.common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSTouchAction;
import org.junit.Assert;
import org.openqa.selenium.By;

/**
 * Created by MAMIAN on 2017/3/31.
 */
public class Handle {


    public void stringInvokeMethod(String str, int i) throws Exception {
        if (i == 0) {
            // 调用没有参数的方法
            this.getClass().getMethod(str, new Class[] {}).invoke(this, new Object[] {});
        } else if (i == 1) {
            // 调用有一个参数的方法，参数为String类型的s
            this.getClass().getMethod(str, new Class[] { String.class }).invoke(this, new Object[] { "s" });
        } else if (i == 2) {
            // 调用有两个参数的方法 参数分别为String类型的qw和int型的1
            this.getClass().getMethod(str, new Class[] { String.class, int.class }).invoke(this, new Object[] { "qw", 1 });
        }
    }

    public static void findElementById () {

    }

    /*验证向TextField发送的key
    * 由于是固定操作，所以封装起来
    * 先点击
    * 再清除
    * 再发送
    * 最后验证
    * */
    public static void assertTestFieldSendKeys(MobileElement d, String s) {

//        d.click();
        d.clear();
        d.sendKeys(s);
//        sleep(500);
        Assert.assertEquals(d.getText(), s);
    }

    public static void assertStaticTextValue (MobileElement d, String s) {
        Assert.assertEquals(d.getText(), s);
    }

    /**寻找到当前页面的Window*/
    public static MobileElement window (AppiumDriver<MobileElement> driver) {
        return driver.findElement(By.className("Window"));
    }

    public static void iosDoubleClick (AppiumDriver<MobileElement> driver, MobileElement t, int x, int y) {
        IOSTouchAction d = new IOSTouchAction(driver);
        d.doubleTap(t, x, y);
        /*
        必须要加perform才生效
        * */
        d.perform();
    }


    public static void click(MobileElement d) {
        d.click();
    }

    public static void pickerWheelChangeTopDefinition (AppiumDriver<MobileElement> driver, MobileElement pickerWheel) {


        int settingX = pickerWheel.getRect().getWidth() / 2;
        int settingY = pickerWheel.getSize().getHeight() / 2;
//        TouchAction swipe = new TouchAction(driver);


        /*先Tap 再 移动*/
//        swipe.tap(pickerWheel, settingX, settingY);

        int windowY = driver.manage().window().getSize().getHeight();

        Handle.swipe(driver, pickerWheel, settingX, settingY, 0, windowY);
//        swipe.moveTo(pickerWheel, settingX, windowY);
//        swipe.perform();

    }

    /*切换分辨率*/
    public static void pickerWheelchangeDefinition (AppiumDriver<MobileElement> driver, MobileElement p, boolean up) {
        /*
        切换清晰度, 默认480P
        */

        /*先跳转界面*/

        /*思路：获取到picker的中心位置，在其Y轴上偏移上下20点，进行Tap*/
        int settingX = p.getRect().getWidth() / 2;
        int settingY = p.getSize().getHeight() / 2;

        /*
        * 如果是往上走，就y-20
        * 如果是往下走，就y+20
        *
        * */

        if (up) {
            settingY -= 20;
        } else {
            settingY += 20;
        }

        TouchAction pickerWheelChangeValue = new TouchAction(driver);
        pickerWheelChangeValue.tap(p, settingX, settingY);
        pickerWheelChangeValue.perform();

        Handle.defaultSleep();
    }



    /*拖动操作
    * 其本质是，按住然后移动到指定位置
    *
    * */
    public static void swipe (AppiumDriver<MobileElement> driver, MobileElement target, int x , int y, int targetX, int targetY) {
        TouchAction t = new TouchAction(driver);
        t.press(target, x, y).waitAction(300).moveTo(target, x, targetY).release().perform();
    }



    /*每一次Switch单击时都需要确认*/
    public static void clickSwitch (MobileElement f, boolean targetValue) {
        /*如果不是目标值就点击*/
        /*
        * true  --> 打开
        * false --> 关闭
        * */
        if (!f.getAttribute("value").equals(String.valueOf(targetValue))) {
            f.click();
        }
    }



    /*自定义等待时长*/
    public static void customSleep (long timeOut) {
        try {
            Thread.sleep(timeOut);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void controllerSceneSleep () {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*
    * 默认1秒
    * */
    public static void defaultSleep () {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void testPrint () {
        System.out.println("suibiandayixie");
    }

    // wait不能被写在static方法中
    public void tal_wait(long timeOut) {
        try {
            wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
