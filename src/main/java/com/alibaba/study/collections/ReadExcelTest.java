package com.alibaba.study.collections;



import com.alibaba.study.util.ExcelUtil;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 读取 Excel 数据
 * @author Shawn (Shawn_0108@163.com)
 * @version 1.0
 * @date 2020/5/15 13:31
 */
public class ReadExcelTest {

    public static void main(String[] args) throws IOException, BiffException {
        List<List<String>> read = ExcelUtil.read("D:\\aa.xls");

        System.out.println(read);
    }
}
