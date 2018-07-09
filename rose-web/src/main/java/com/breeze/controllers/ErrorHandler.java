package com.breeze.controllers;

import net.paoding.rose.web.ControllerErrorHandler;
import net.paoding.rose.web.Invocation;

public class ErrorHandler implements ControllerErrorHandler {

    public Object onError(Invocation inv, Throwable ex) throws Throwable {
        if (ex instanceof RuntimeException) {
            return "@runtime";
        }
        return "@error";
    }

}
