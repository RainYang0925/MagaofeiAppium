package com.magaofei.tal.uiautoutils;

import org.openqa.selenium.WebElement;

/**
 * Created by MAMIAN on 2017/3/31.
 */
public class Handle {
    public static void findElementById () {

    }

    public static void sendKeys() {

    }

    public static void click(WebElement d) {
        d.click();
    }

    public static void sleep(long timeOut) {
        try {
            Thread.sleep(timeOut);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
