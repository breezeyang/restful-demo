package com.breeze.springbootdemo.common;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class ResultDTO<T> implements Serializable {

    private static final long serialVersionUID = -3328866710948914902L;

    @ApiModelProperty(value = "错误编码 200 标识成功，其余均为失败", required = true)
    private int errno;

    @ApiModelProperty(value = "错误信息", required = true)
    private String errmsg;

    @ApiModelProperty(value = "返回对象", required = true)
    private T data;

    public ResultDTO() {

    }

    public ResultDTO(int errno, String errmsg, T data) {
        super();
        this.errno = errno;
        this.errmsg = errmsg;
        this.data = data;

    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
