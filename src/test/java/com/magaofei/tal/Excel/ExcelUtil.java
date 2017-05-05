package com.magaofei.tal.Excel;

import com.magaofei.tal.config.CapabilitiesSetup;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by MAMIAN on 2017/4/14.
 * 参考: http://blog.csdn.net/yaohucaizi/article/details/8852872
 *
 */


public class ExcelUtil {

    private static AppiumDriver<MobileElement> excelDriver;
    private static Row row;
    private static String excelFilePath = "ios_testcase.xlsx";

    //    @Before
    // 不能写static
    public static void setUp() throws Exception {
        excelDriver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), CapabilitiesSetup.readFile());
//        excelDriver = driver;
    }

    //    @After
    public static void tearDown() throws Exception {
        /*即使退出也会保存*/
        excelDriver.quit();
    }

    //    @Test
    /*
    * 思路:
    * 每一次都会执行setUp 和 tearDown方法, 那每次case的开始和结束时 手动的执行
    * */
    public static void testReadExcel(AppiumDriver<MobileElement> driver) {
        excelDriver = driver;
        ExcelUtil re = new ExcelUtil();
//  List<String[]> list = re.readExcel("c:/群组.xls");
        List<String[]> list = null;
        try {
            // 当前目录下
            list = re.readExcel(excelFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // case的标识, 并赋予初始值
        String k = "0";

        if (list == null) {
            return;
        }


        /*二维数组*/
        // 跳过第一行

        int rowLength = list.size();
        for (int i = 1; i < rowLength; i++) {
            System.out.println("第" + (i + 1) + "行");
                /*
                * 列
                * TestCase	TestProcedure	Description  Method	PositioningMode	Element		Keys	Assert	TimeOut	Result
                * 1         2               3            4      5               6           7       8       9       10
                * */

                /*跳过第一行*/


            // 取出行
            String[] cellList = list.get(i);
            String testResult = "Fail";
            int cellListLength = cellList.length;
            String errMessage = null;


            for (int j = 0; j < cellListLength; j++) {
                System.out.print("\t第" + (j + 1) + "列值：");
                System.out.println(cellList[j]);

                // 在这里做一个判断, 如果是一次实例的 就做一次循环
                // 保存每次第一列的数值, 如果相等, 就继续, 如果不相等 ,就循环


                if (k.equals(cellList[0])) {
                    // 如果k和上一行的值相等, 说明是同一个实例
                    // 继续执行Test
                    try {
                        testMethod(cellList, j);
                        writeResult(excelFilePath, i, cellListLength - 1 , "Pass");
                    } catch (Exception | AssertionError e) {
                        // 这里捕捉多个异常, 并且要进行截图等操作
                            /*todo 1.截图 2.失败后直接跳转到下个用例
                            *
                            * */

                            /*
                            * done
                            * Assert异常捕捉
                            * */
                        testResult = "Fail";

                        errMessage = e.getMessage();
                        writeResult(excelFilePath, i, cellListLength - 2 , errMessage);
                        writeResult(excelFilePath, i, cellListLength - 1 , "Fail");
                        e.printStackTrace();

                        break;
                        // StackTrace 写入到Excel


                    }




                } else {
                    // 如果不相等, 说明不是同一个实例

                    // 并把新的用例的标识值 赋给 k
                    k = cellList[0];


                    // 开始执行tearDown


                    try {
//                            driver.quit();
                        tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    // 开始执行setUp
                    // 开始执行Test

                    try {
//                            driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), CapabilitiesSetup.readFile());
//                            excelDriver = driver;
                        setUp();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


//                        testMethod(cellList, j);


                }


                //

            }


        }

    }


    /**
     * 执行方法, 从第4列开始
     *
     * @param cellList 行
     * @param j        index
     */
    private static void testMethod(String[] cellList, int j) throws Exception {
        switch (j) {
            case 3:
                // 方法
                ExcelToMethod.findElementFromExcel(cellList, j, excelDriver);
//                try {
//                    ExcelToMethod.findElementFromExcel(cellList, j, excelDriver);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                            try {
//                                tearDown();
//                            } catch (Exception e) {
//                                e.printStackTrace();
//                            }
                break;
        }
    }

    public List<String[]> readExcel(String filePath) throws Exception {
        List<String[]> dataList = new ArrayList<String[]>();

        /*判断是否是2003及以下格式的Excel,默认为True*/
//        boolean isExcel2003 = true;
//        if (isExcel2007(filePath)) {
//            isExcel2003 = false;
//        }
        /*File转为输入流*/
        File file = new File(filePath);
        InputStream excelInputStream = null;
        try {
            excelInputStream = new FileInputStream(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExcelUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*
         * 2003 --> HSSFWorkbook
         * 2017 --> XSSFWorkbook
         * */
        Workbook wb = null;

        /*使用正则判断*/
//        try {
//            wb = isExcel2003 ? new HSSFWorkbook(excelInputStream) : new XSSFWorkbook(excelInputStream);
//        } catch (IOException ex) {
//            Logger.getLogger(ExcelUtil.class.getName()).log(Level.SEVERE, null, ex);
//        }

        /*新的判断方法*/
        wb = getWorkbook(excelInputStream);

        /*读取第一个标签*/
        Sheet sheet = wb.getSheetAt(0);

        /*总行数*/
        int totalRows = sheet.getPhysicalNumberOfRows();
        /*总列数*/
        int totalCells = 0;

        /*总行数>=1且第一列不等于空*/
        if (totalRows >= 1 && sheet.getRow(0) != null) {
            totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
        }

        /*遍历行和列*/
        /*行*/
        for (int r = 0; r < totalRows; r++) {
            Row row = sheet.getRow(r);

            if (row == null) {
                continue;
            }

            /*列*/
            String[] rowList = new String[totalCells];
            for (int c = 0; c < totalCells; c++) {
                Cell cell = row.getCell(c);
                String cellValue = "";
                if (cell == null) {
                    rowList[c] = (cellValue);
                    continue;
                }

                /*转换值*/
                cellValue = ConvertCellStr(cell, cellValue);
                rowList[c] = (cellValue);
            }
            // 添加到List
            dataList.add(rowList);
        }
        return dataList;
    }


    /**
     * 读取到单元格的内容后,判断是String还是数字还是布尔
     */
    private String ConvertCellStr(Cell cell, String cellStr) {
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:

                // 读取String
                cellStr = cell.getStringCellValue();
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                // boolean转为String
                cellStr = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_NUMERIC:
                // 先看是否是日期格式  转为String
                if (DateUtil.isCellDateFormatted(cell)) {
                    // 读取日期格式
                    cellStr = formatTime(cell.getDateCellValue().toString());
                } else {
                    // 读取数字
                    /*在这里取整*/
                    cellStr = String.format("%.0f", cell.getNumericCellValue());
//                    cellStr = String.valueOf(cell.getNumericCellValue());
                }
                break;
            case Cell.CELL_TYPE_FORMULA:
                // 读取公式
                cellStr = cell.getCellFormula().toString();
                break;
        }
        return cellStr;
    }


    /**
     * 时间格式
     */
    private String formatTime(String s) {
        SimpleDateFormat sf = new SimpleDateFormat("EEE MMM dd hh:mm:ss z yyyy", Locale.ENGLISH);
        Date date = null;
        try {
            date = sf.parse(s);
        } catch (ParseException ex) {
            Logger.getLogger(ExcelUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String result = sdf.format(date);
        return result;
    }


    /**
     * 判断是否是2007及之后格式的Excel
     */
    private boolean isExcel2007(String fileName) {
        return fileName.matches("^.+\\.(?i)(xlsx)$");
    }

    private static Workbook getWorkbook(InputStream is) throws IOException {
        Workbook wb = null;
        if (!is.markSupported()) {
            is = new PushbackInputStream(is, 8);
        }
        if (POIFSFileSystem.hasPOIFSHeader(is)) { // Excel2003及以下版本
            wb = (Workbook) new HSSFWorkbook(is);
        } else if (POIXMLDocument.hasOOXMLHeader(is)) { // Excel2007及以上版本
            wb = new XSSFWorkbook(is);
        } else {
            throw new IllegalArgumentException("你的Excel版本目前poi无法解析！");
        }
        return wb;
    }

    /**
     * 向表格中写入数据
     * @param filePath 表格路径
     * @param nowRowNum 需要写入的行
     * @param value 需要写入的内容
     */
    public static void writeResult(String filePath, int nowRowNum, int col, String value) {
        try {
            FileInputStream is = new FileInputStream(filePath);
            Workbook wb = getWorkbook(is);
            Sheet sheet1 = wb.getSheetAt(0);
            //Row row = sheet1.getRow(0);
            //Row row = sheet1.createRow(sheet1.getLastRowNum() + 1);
            if(col == 0) {
                row = sheet1.createRow(nowRowNum);
            } else {
                row = sheet1.getRow(nowRowNum);
            }
            //row.setHeightInPoints((short) 25);//设置行高
            // 给这一行赋值
            //如果col等于4，写入pass或者fail
            row.createCell(col).setCellValue(value);
            FileOutputStream os = new FileOutputStream(filePath);
            wb.write(os);
            is.close();
            os.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//    public static void write(List list) throws Exception {
////        List<List<String>> dateList = new ListSource().listSource();
//        HSSFWorkbook wb = new HSSFWorkbook();
//        HSSFSheet sheet = wb.createSheet("sheet");// 添加sheet
//        // 表格样式
//        HSSFCellStyle style = wb.createCellStyle();
//        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 指定单元格居中对齐
//        // // 边框
//        // style.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
//        // style.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
//        // style.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
//        // style.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
//        // //设置字体
//        // HSSFFont f = wb.createFont();
//        // f.setFontHeightInPoints((short)10);
//        // f.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
//        // style.setFont(f);
//        // //设置列宽
//        // sheet.setColumnWidth((short)0, (short)9600);
//        // sheet.setColumnWidth((short)1, (short)4000);
//        // sheet.setColumnWidth((short)2, (short)8000);
//        // sheet.setColumnWidth((short)3, (short)8000);
//
//        // 在索引0的位置创建第一行
//
//        for (int i = 0; i < dateList.size(); i++) {
//            HSSFRow row = sheet.createRow(i);
//            List list1 = list.get(i);
//            for (int j = 0; j < list.size(); j++) {
//                HSSFCell cell = row.createCell(j);
//                cell.setCellValue(list.get(j));
//                cell.setCellStyle(style);
//            }
//        }
        // 导出文件
//        FileOutputStream fout = new FileOutputStream(filePath);
//        wb.write(fout);
//        fout.close();
//    }
}
