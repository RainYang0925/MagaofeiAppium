package com.magaofei.tal.Excel;

/**
 * Created by MAMIAN on 2017/4/17.
 */
public class MovingInvokeTest {

    private static MovingInvokeTest movingInvokeTest = new MovingInvokeTest(); // 创建MovingInvokeTest对象

    /*
     * 根据str字符串调用方法，变量i只是为了判断，调用有几个参数的方法
     */
    public static void stringInvokeMethod(String str, int i) throws Exception {
        if (i == 0) {
            // 调用没有参数的方法
            movingInvokeTest.getClass().getMethod(str, new Class[] {}).invoke(movingInvokeTest, new Object[] {});
        } else if (i == 1) {
            // 调用有一个参数的方法，参数为String类型的s
            movingInvokeTest.getClass().getMethod(str, new Class[] { String.class }).invoke(movingInvokeTest, new Object[] { "s" });
        } else if (i == 2) {
            // 调用有两个参数的方法 参数分别为String类型的qw和int型的1
            movingInvokeTest.getClass().getMethod(str, new Class[] { String.class, int.class }).invoke(movingInvokeTest, new Object[] { "qw", 1 });
        }
    }

    public void speak() {
        System.out.println("调用的没有参数的方法");
    }

    public void speak(String s) {
        System.out.println("调用有一个参数的方法,参数为:" + s);
    }

    public void speak(String s, int i) {
        System.out.println("调用有两个参数的方法,参数为,参数为:" + s + "和" + i);
    }

    public static void main(String[] args) throws Exception {
        stringInvokeMethod("speak", 1);
    }

}
