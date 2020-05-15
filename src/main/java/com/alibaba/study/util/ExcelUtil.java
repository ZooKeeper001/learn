package com.alibaba.study.util;

import com.alibaba.fastjson.JSONObject;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Excel 写入 和 读取工具类
 *
 * @author Shawn (Shawn_0108@163.com)
 * @version 1.0
 * @date 2020/5/15 13:49
 */
public class ExcelUtil {

    /**
     * 读取Excel文件内容
     *
     * @param path excel文件所在路径
     * @return list excel对应数据行的字符串集合
     */
    public static List<List<String>>  read (String path) {
        List<List<String>> all = new ArrayList<>();
        List<String> list = new ArrayList<>();
        try {
            // 创建文件对象
            File file = new File(path);
            // 从文件流中获取Excel工作区对象（WorkBook）
            Workbook wb = Workbook.getWorkbook(file);
            // 从工作区中取得页（Sheet）
            Sheet sheet = wb.getSheet(0);
            // 循环打印Excel表中的内容
            for (int i = 1; i < sheet.getRows(); i++) {
                for (int j = 0; j < sheet.getColumns(); j++) {
                    Cell cell = sheet.getCell(j, i);
                    list.add(cell.getContents()+" ");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return all;
    }

    /**
     * 指定路径excel文件写入数据
     *
     * @param file
     * @param list
     * @param classPath
     * @throws IOException
     * @throws WriteException
     * @throws ClassNotFoundException
     */
    public static void write (File file,List list,String classPath) throws IOException, WriteException, ClassNotFoundException {
        StringBuffer sb = new StringBuffer();
        // 创建用于写入内容的Excel文件的引用
        WritableWorkbook wb = null;
        Class clazz = Class.forName(classPath);
        // 返回所有的属性
        Field[] field = clazz.getDeclaredFields();
        try {
            // 获取Excel文件
            wb = Workbook.createWorkbook(file);
            if (wb != null) {
                // 通过Excel文件获取第一个工作簿sheet
                WritableSheet sheets = wb.createSheet("sheet1", 0);
                for (int i =0 ;i < field.length;i++) {
                    Label label = new Label(i, 0, field[i].getName());
                    sheets.addCell(label);
                }
                // rows表示需要写入Excel文件的行数
                int rows = list.size();
                //j表示行数，i表示列数
                for (int j = 1; j < rows +1; j++) {
                    for (int i = 0;i <field.length;i++ ) {
                        JSONObject parse = (JSONObject)JSONObject.toJSON( list.get(j-1));
                        Label label = new Label(i, j,parse.getString(field[i].getName()));
                        sheets.addCell(label);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            wb.write();
            wb.close();
        }

    }
}
