package com.breeze.controllers;

import com.breeze.model.TestModel;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.paramresolver.ParamMetaData;
import net.paoding.rose.web.paramresolver.ParamResolver;

public class TestModelBeanResolver implements ParamResolver{

    public boolean supports(ParamMetaData metaData) {
        return TestModel.class == metaData.getParamType();
    }

    public Object resolve(Invocation inv, ParamMetaData metaData) throws Exception {
        for (String paramName : metaData.getParamNames()) {
            if (paramName != null) {
                TestModel model = new TestModel();
                String userId = inv.getParameter("user_id");
                String userName = inv.getParameter("user_name");
                String userAge = inv.getParameter("age");
                model.setUserId(Long.parseLong(userId));
                model.setUserName(userName);
                model.setAge(Integer.parseInt(userAge));
                return model;
            }
        }
        return null;
    }

}
