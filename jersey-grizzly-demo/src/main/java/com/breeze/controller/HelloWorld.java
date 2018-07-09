package com.breeze.controller;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
 
@Path("/")
public class HelloWorld {
    
    public HelloWorld(){}
    
    @GET
    @Produces("text/plain")
    public String getMessage() {
        return "Hello World!";
    }
}