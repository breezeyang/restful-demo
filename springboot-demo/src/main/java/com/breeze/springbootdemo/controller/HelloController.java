package com.breeze.springbootdemo.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.breeze.springbootdemo.common.BaseService;
import com.breeze.springbootdemo.common.ResultDTO;

import io.swagger.annotations.ApiOperation;
import net.bytebuddy.asm.Advice.This;

@RestController
public class HelloController extends BaseService {

    Logger logger = LoggerFactory.getLogger(This.class);

    /**
     * 存活性监控
     * 
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "", notes = "存活性监控")
    public ResultDTO<String> hello() {
        logger.info("hello world");
        return this.success();
    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "test", notes = "存活性监控")
    public ResultDTO<String> hello(@RequestParam(value = "userid", required = true) Long userid) {
        System.out.println(userid);
        logger.info("hello world");
        return this.success();
    }

}
