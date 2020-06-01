package com.alibaba.study.io.output;

import lombok.Data;

import java.util.List;

/**
 * 读取excel返回结果类
 *
 * @author Shawn (Shawn_0108@163.com)
 * @version 1.0
 * @date 2020/5/19 13:37
 */
@Data
public class ReadExcelDataResponse {

    private List<String> list;

    private Integer lines;
}
