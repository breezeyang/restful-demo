package com.breeze.controllers;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.ParamValidator;
import net.paoding.rose.web.paramresolver.ParamMetaData;

import org.apache.commons.lang.StringUtils;
import org.springframework.validation.Errors;

import com.breeze.annotation.NotBlank;

public class NotBlankParamValidator implements ParamValidator {

    public boolean supports(ParamMetaData metaData) {
        return metaData.getAnnotation(NotBlank.class) != null;
    }

    public Object validate(ParamMetaData metaData, Invocation inv, Object target, Errors errors) {
        String paramName = metaData.getParamName();
        String value = inv.getParameter(paramName);
        if (StringUtils.isEmpty(value)) {
            return "@参数不能为空";
        }
        return null;
    }

}
