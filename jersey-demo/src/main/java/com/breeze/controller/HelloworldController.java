package com.breeze.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.breeze.model.User;

@Path("/demo")
public class HelloworldController {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello World!";
    }

    @GET
    @Path("/{param}")
    @Produces("text/plain;charset=UTF-8")
    public String sayHelloToUTF8(@PathParam("param") String username) {
        return "Hello " + username;
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public User sayHelloToJson(@QueryParam("username") String username) {
        User user = new User();
        user.setId(1);
        user.setName(username);
        return user;
    }

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User updateUser(User user) {
        user.setId(2);
        user.setName("update name:" + user.getName());
        return user;
    }
}
