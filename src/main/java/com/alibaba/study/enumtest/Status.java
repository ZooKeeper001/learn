package com.alibaba.study.enumtest;

/**
 * @author Shawn (Shawn_0108@163.com)
 * @date 2020/7/27 11:21
 */
public enum Status {
    NEW(1), PAY(2), SUCCESS(3), FAIL(-1), REFUND(-2);

    private int status;
    Status(int status) {
        this.status = status;
    }
    public int status() { return status; }
}
