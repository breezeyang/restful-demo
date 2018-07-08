package com.breeze.controller;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class HelloWorld extends ServerResource {
    
    @Get
    public String represent()
    {
        return "hello world!";
    }
}
