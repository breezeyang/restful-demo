package com.breeze.controllers;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;
import net.paoding.rose.web.portal.Portal;
import net.paoding.rose.web.var.Flash;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import com.breeze.annotation.NotBlank;
import com.breeze.model.TestModel;
import com.google.gson.JsonObject;

@Path("/test/")
public class TestController {

    Logger logger = Logger.getLogger(TestController.class);

    @Get("hello")
    public String test() {
        logger.info("test---------");
        return "@Hello world";
    }

    @Get("topic/{topicId:[0-9]+}")
    public String showTopic(@Param("topicId") int topicId) {
        logger.info("topicId: " + topicId);
        return "@" + topicId;
    }

    @Get("model")
    public String model(TestModel model) {
        logger.info("model: " + model);
        return "@" + model;
    }

    @Get("notBlank")
    public String notBlank(@NotBlank @Param("messages") String message) {
        logger.info("message: " + message);
        return "@" + message;
    }

    @Get("/flash1")
    public String flashStep1(Flash flash) {
        flash.add("msg", "修改成功！");
        return "r:/flash2";
    }

    @Get("/flash2")
    public String flashStep2(Invocation inv, Flash flash) {
        inv.addModel("info", flash.get("msg"));
        return "flash";
    }

    @Get("/3.7")
    public String portal(Portal portal) {
        portal.addWindow("p1", "/test/wp1");
        portal.addWindow("p2", "/test/wp2");
        return "portal";
    }

    @Get("/wp1")
    public String portal1() {
        return "@this is p1";
    }

    @Get("/wp2")
    public String portal2() {
        return "@this is p2";
    }

    @Post("/doUpload")
    public String doUpload(@Param("file") MultipartFile file) {
        return "@ upload ok!" + file.getOriginalFilename();
    }

    @Post("/doUploads")
    public String doArrayUpload(@Param("files") MultipartFile[] files) {
        int size = files.length;
        for (int i = 0; i < size; i++) {
            logger.info("file_name : " + i + " " + files[i].getOriginalFilename());
        }

        return "@ upload ok!" + Arrays.deepToString(files);
    }

    @Get("json")
    public String testJson() {
        JsonObject jo = new JsonObject();
        jo.addProperty("hello", "world");
        return "@json:" + jo.toString();
    }

    @Post("requestBody")
    public String testRequestBody(HttpServletRequest request) {
        String body = null;
        try {
            int len = request.getContentLength();
            ServletInputStream inputStream = request.getInputStream();
            byte[] buffer = new byte[len];
            inputStream.read(buffer, 0, len);

            body = new String(buffer);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "@" + body;

    }
}
