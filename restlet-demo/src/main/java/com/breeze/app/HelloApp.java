package com.breeze.app;

import org.restlet.Application;
import org.restlet.Context;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import com.breeze.controller.HelloWorld;

public class HelloApp extends Application {
    
    public HelloApp() {
    }  
    
    public HelloApp(Context parentContext) {  
        super(parentContext);  
    }  
    
    @Override
    public synchronized Restlet createInboundRoot() {
        System.out.println("createInboundRoot");
        Router router = new Router(getContext());
        router.attach("/hello", HelloWorld.class);
        return router;
    }
}
