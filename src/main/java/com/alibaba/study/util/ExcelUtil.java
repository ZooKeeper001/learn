package com.alibaba.study.util;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.study.io.output.ReadExcelDataResponse;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Excel 写入 和 读取工具类
 *
 * @author Shawn (Shawn_0108@163.com)
 * @version 1.0
 * @date 2020/5/15 13:49
 */
@Slf4j
public class ExcelUtil {

    /**
     * 读取Excel文件内容
     *
     * @param path excel文件所在路径
     * @return list excel对应数据行的字符串集合
     */
    public static ReadExcelDataResponse read (String path) throws IOException, BiffException {
        ReadExcelDataResponse readExcelDataResponse = new ReadExcelDataResponse();
        List<String> list = new ArrayList<>();

        // 创建文件对象
        File file = new File(path);
        // 从文件流中获取Excel工作区对象（WorkBook）
        Workbook wb = Workbook.getWorkbook(file);
        // 从工作区中取得页（Sheet）
        Sheet sheet = wb.getSheet(0);
        // 循环打印Excel表中的内容
        Integer lines = sheet.getColumns();
        for (int i = 1; i < sheet.getRows(); i++) {
            StringBuilder builder1 = new StringBuilder();
            for (int j = 0; j < sheet.getColumns(); j++) {
                Cell cell = sheet.getCell(j, 0);
                String str1 = cell.getContents();
                builder1.append(str1 + ":");
            }
            String str2 = ":";
            String[] split = builder1.toString().split(str2);
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < sheet.getColumns(); j++) {
                Cell cell = sheet.getCell(j, i);
                String str = cell.getContents();
                builder.append(split[j] + ":" + str + ":");
            }
            list.add(builder.toString());
        }
        readExcelDataResponse.setList(list);
        readExcelDataResponse.setLines(lines);
        return readExcelDataResponse;
    }

    /**
     * 指定路径excel文件写入数据
     *
     * @param file 写入的文件
     * @param list 写入文件内的数据集合
     * @param classPath 类型的class的路径
     * @throws IOException
     * @throws WriteException
     * @throws ClassNotFoundException
     */
    public static void write (File file,List list,String classPath,Integer lines,String[] arr) throws IOException, WriteException, ClassNotFoundException {

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
                // rows表示需要写入Excel文件的行数
                int rows = list.size();
                for (int i =0 ;i < lines;i++) {
                    Label label = new Label(i, 0, arr[i]);
                    sheets.addCell(label);
                }
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
            log.error("导入excel文件失败",e);
        } finally {
            wb.write();
            wb.close();
        }

    }

    /**
     * 写入首行列表名称
     *
     * @param file
     * @param lines
     * @throws IOException
     * @throws WriteException
     */
    public static void writeTop (File file,Integer lines,String[] arr) throws IOException, WriteException {
        // 创建用于写入内容的Excel文件的引用
        WritableWorkbook wb = null;
        try {
            // 获取Excel文件
            wb = Workbook.createWorkbook(file);
            if (wb != null) {
                // 通过Excel文件获取第一个工作簿sheet
                WritableSheet sheets = wb.createSheet("sheet1", 0);
                for (int i =0 ;i < lines;i++) {
                    Label label = new Label(i, 0, arr[i]);
                    sheets.addCell(label);
                }
            }
        } catch (Exception e) {
            log.error("导入excel文件失败",e);
        } finally {
            wb.write();
            wb.close();
        }
    }

    public static void main(String[] args) {
        Path path2 = Paths.get("F:\\aaaaa\\ab.txt");
        try {
            Files.createFile(path2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
