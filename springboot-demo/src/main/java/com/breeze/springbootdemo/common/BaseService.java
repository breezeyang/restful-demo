package com.breeze.springbootdemo.common;


public class BaseService {
    public <T> ResultDTO<T> success() {
        ResultDTO<T> dto = new ResultDTO<T>();
        dto.setErrno(ResultCode.SUCC.getCode());
        dto.setErrmsg(ResultCode.SUCC.getMsg());
        return dto;
    }

    public <T> ResultDTO<T> success(T obj) {
        ResultDTO<T> dto = new ResultDTO<T>();
        dto.setErrno(ResultCode.SUCC.getCode());
        dto.setErrmsg(ResultCode.SUCC.getMsg());
        dto.setData(obj);
        return dto;
    }

    public <T> ResultDTO<T> success(String msg, T obj) {
        ResultDTO<T> dto = new ResultDTO<T>();
        dto.setErrno(ResultCode.SUCC.getCode());
        dto.setErrmsg(msg);
        dto.setData(obj);
        return dto;
    }

    public <T> ResultDTO<T> paramError(String msg) {
        ResultDTO<T> dto = new ResultDTO<T>();
        dto.setErrno(ResultCode.PARAM_ERROR.getCode());
        dto.setErrmsg(msg);
        return dto;
    }

    public <T> ResultDTO<T> paramError(String msg, T obj) {
        ResultDTO<T> dto = new ResultDTO<T>();
        dto.setErrno(ResultCode.PARAM_ERROR.getCode());
        dto.setErrmsg(msg);
        dto.setData(obj);
        return dto;
    }

    public <T> ResultDTO<T> error(String msg) {
        ResultDTO<T> dto = new ResultDTO<T>();
        dto.setErrno(ResultCode.ERROR.getCode());
        dto.setErrmsg(msg);
        return dto;
    }

    public <T> ResultDTO<T> error(String msg, T obj) {
        ResultDTO<T> dto = new ResultDTO<T>();
        dto.setErrno(ResultCode.ERROR.getCode());
        dto.setErrmsg(msg);
        dto.setData(obj);
        return dto;
    }

}
