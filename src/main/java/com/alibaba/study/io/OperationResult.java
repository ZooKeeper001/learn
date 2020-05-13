package com.alibaba.study.io;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Shawn (Shawn_0108@163.com)
 * @version 1.0
 * @date 2020/5/9 10:56
 */
@Slf4j
@Data
public class OperationResult {
    /**
     * 返回码
     */
    private String resultCode = "0";

    /**
     * 返回类型
     */
    private String resultMessage = "ok";

    /**
     * 业务数据对象
     */
    Object data = null;

    private static final long serialVersionUID = 6044849293418983828L;

    /**
     * 交易正常
     * @return
     */
    public static OperationResult success() {
        return new OperationResult();
    }

    /**
     * 交易正常调用带数据
     * @param data
     * @return
     */
    public static OperationResult success(Object data){
        return new OperationResult(data);
    }



    public OperationResult() {

    }

    /**
     * 设置返回信息的构造方法,用于成功时返回明确的成功消息
     *
     * @param resultMessage 返回详细提示消息
     */
    public OperationResult(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    /**
     * 设置返回码和返回信息的构造方法,一般用于发生错误时设置
     *
     * @param resultCode    错误码
     * @param resultMessage 错误信息
     */
    public OperationResult(String resultCode, String resultMessage) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }

    /**
     * 正确情况下,只设置业务对象的构造方法
     *
     * @param data 业务数据对象
     */
    public OperationResult(Object data) {
        this.data = data;
    }
}
