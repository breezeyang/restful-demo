package com.breeze.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import junit.framework.TestCase;

public class TestUserAPI extends TestCase {
    public static final String USER_API = "http://127.0.0.1:8080/resteasy-demo/rest/userservice/users";

    public void testCreateUserAndGetUser() throws IOException {
        URL url = new URL(USER_API);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.setConnectTimeout(1000);

        byte[] bytes = new byte[1024];
        // 读取请求返回值
        InputStream inStream = connection.getInputStream();
        inStream.read(bytes, 0, inStream.available());
        System.out.println(new String(bytes, "utf-8"));

        connection.disconnect();
    }
}