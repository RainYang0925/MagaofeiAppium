package com.magaofei.tal.testcase.talpublish;

import com.magaofei.tal.Excel.ExcelUtil;
import com.magaofei.tal.config.CapabilitiesSetup;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.URL;


/**
 * Created by MAMIAN on 2017/4/14.
 */

public class ExcelCase {
    private static AppiumDriver<MobileElement> driver;

    @Before
    public void setUp() throws Exception {
        driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), CapabilitiesSetup.readFile());
        // 在第一次初始化时 把driver传过去
//        ExcelUtil.setUp(driver);
    }

    @After
    public void tearDown() throws Exception {
        /*即使退出也会保存*/
        driver.quit();
    }



//    @TestFactory
//    Collection<DynamicTest> dynamicTestsFromCollection() {
//        return Arrays.asList(
//                dynamicTest("1st dynamic test", () -> ExcelUtil.testReadExcel(driver)),
//                dynamicTest("2nd dynamic test", () -> assertEquals(4, 2 * 2))
//        );
//    }



//    public static TestSuite suite()
//    {
//        TestSuite suite = new TestSuite();
//        ExcelUtil.testReadExcel(driver);
//        suite.addTest(new JUnit4TestAdapter(Test1.class));
//        suite.addTest(new JUnit4TestAdapter(Test2.class));
//
//        return suite;
//    }

//    @Test
//    public void testA () {
//
//    }

    @Test
    public void dynamicTestsWithInvalidReturnType() {

        ExcelUtil.testReadExcel(driver);

    }




//    @TestFactory
//    public Collection<DynamicTest> dynamicTestsFromCollection() {
////        return Arrays.asList(
////                dynamicTest("1st dynamic test in test interface", () -> assertTrue(true)),
////                dynamicTest("2nd dynamic test in test interface", () -> assertEquals(4, 2 * 2))
////        );
//        Collection e = new ArrayList();
//        e.add(ExcelUtil.testReadExcel(driver));
//        return e;
//
//    }


//    @TestFactory
//    List<DynamicTest> createPointTests() {
//        return Arrays.asList(
//                DynamicTest.dynamicTest(
//                        "A Great Test For Point",
//                        () -> {
//                            // test code
//                            ExcelUtil.testReadExcel(driver);
//
//                        }),
//                DynamicTest.dynamicTest(
//                        "Another Great Test For Point",
//                        () -> {
//                            // test code
//                        })
//        );
//    }



//
//    Stream<DynamicTest> generateRandomNumberOfTests() {
//
//        // Generates random positive integers between 0 and 100 until
//        // a number evenly divisible by 7 is encountered.
////        Iterator<Integer> inputGenerator = new Iterator<Integer>() {
////
////            Random random = new Random();
////            int current;
////
////            @Override
////            public boolean hasNext() {
////                current = random.nextInt(100);
////                return current % 7 != 0;
////            }
////
////            @Override
////            public Integer next() {
////                return current;
////            }
////        };
//
//        // Generates display names like: input:5, input:37, input:85, etc.
//        Function<Integer, String> displayNameGenerator = (input) -> "input:" + input;
//
//
//
//        // Executes tests based on the current input value.
//        ThrowingConsumer<Integer> testExecutor = (input) -> assertTrue(input % 7 != 0);
//
//        // Returns a stream of dynamic tests.
//        return DynamicTest.stream(inputGenerator, displayNameGenerator, testExecutor);
//    }

//
//
//    public static Collection<Method[]> data() {
//
//
//
//
//        // load the files as you want
//        Void[] fileArg1 = new Void[] { ExcelUtil.testReadExcel(driver)};
//        Object[] fileArg2 = new Object[] { new File("path2") };
//
//        Collection<Object[]> data = new ArrayList<Object[]>();
//        data.add(ExcelUtil.testReadExcel(driver));
//        data.add(fileArg2);
//        return data;
//    }
}
