package com.breeze.springbootdemo.common;

public enum ResultCode {

    SUCC(0, "success"), PARAM_ERROR(1, "param error"), PROCESS_ERROR(2, "process error"), ERROR(500, "innner error");

    private int code;

    private String msg;

    private ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
