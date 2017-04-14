package com.magaofei.tal.Excel;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by MAMIAN on 2017/4/14.
 */


public class ExcelUtil {

    @Test
    public static void testReadExcel (AppiumDriver<MobileElement> driver) {
        ExcelUtil re = new ExcelUtil();
//  List<String[]> list = re.readExcel("c:/群组.xls");
        List<String[]> list = null;
        try {
            // 当前目录下
            list = re.readExcel("ios_testcase.xlsx");
        } catch (Exception e){
            e.printStackTrace();
        }


        if (list != null) {
            /*二维数组*/
            for (int i = 0; i < list.size(); i++) {
                System.out.println("第" + (i + 1) + "行");
                /*
                * 列
                * TestCase	TestProcedure	Description  Method	PositioningMode	Element		Keys	Assert	TimeOut	Result
                * 1         2               3            4      5               6           7       8       9       10
                * */

                /*跳过第一行*/


                String[] cellList = list.get(i);
                for (int j = 0; j < cellList.length; j++) {
                    System.out.print("\t第" + (j + 1) + "列值：");
                    System.out.println(cellList[j]);

                    switch (j) {
                        case 3:
                            // 方法

                            ExcelToMethod.findElementFromExcel(cellList, j, driver);
                            break;
                    }
                }


            }
        }
    }


    public List<String[]> readExcel (String filePath) throws Exception  {
        List<String[]> dataList = new ArrayList<String[]>();

        /**判断是否是2003及以下格式的Excel,默认为True*/
        boolean isExcel2003 = true;
        if (isExcel2007(filePath)) {
            isExcel2003 = false;
        }
        /**File转为输入流*/
        File file = new File(filePath);
        InputStream excelInputStream = null;
        try {
            excelInputStream = new FileInputStream(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExcelUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        /**
         * 2003 --> HSSFWorkbook
         * 2017 --> XSSFWorkbook
         * */
        Workbook wb = null;
        try {
            wb = isExcel2003 ? new HSSFWorkbook(excelInputStream) : new XSSFWorkbook(excelInputStream);
        } catch (IOException ex) {
            Logger.getLogger(ExcelUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        /**读取第一个标签*/
        Sheet sheet = wb.getSheetAt(0);

        /**总行数*/
        int totalRows = sheet.getPhysicalNumberOfRows();
        /**总列数*/
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


    /**读取到单元格的内容后,判断是String还是数字还是布尔*/
    private String ConvertCellStr(Cell cell, String cellStr) {
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:

                // 读取String
                cellStr = cell.getStringCellValue().toString();
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
                    /**在这里取整*/
                    cellStr = String.format("%.0f",cell.getNumericCellValue());
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


    /**时间格式*/
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


    /** 判断是否是2007及之后格式的Excel*/
    private boolean isExcel2007(String fileName) {
        return fileName.matches("^.+\\.(?i)(xlsx)$");
    }
}
